import java.awt.Color
import kotlin.random.Random

/**
 * The desired canvas width, which must be at least 4 times [MIN_RECTANGLE_WIDTH].
 */
const val REQUESTED_CANVAS_WIDTH = 400

/**
 * The desired canvas height, which must be at least 4 times [MIN_RECTANGLE_HEIGHT].
 */
const val REQUESTED_CANVAS_HEIGHT = 400

/**
 * The minimum width of a colored rectangle.
 */
const val MIN_RECTANGLE_WIDTH = 80

/**
 * The minimum height of a colored rectangle.
 */
const val MIN_RECTANGLE_HEIGHT = 80

// seed for random number generator
val SEED = 2500

open class MondrianPainter {
    // Use this property when generating random numbers.
    private val random = Random(SEED)

    val canvas =
        Canvas(
            "Mondrian Painter",
            this,
            REQUESTED_CANVAS_WIDTH,
            REQUESTED_CANVAS_HEIGHT,
        )

    /**
     * Performs a side-by-side split of the region specified by [x], [y],
     * [width], and [height], if it is wide enough to split, and calls
     * [doMondrian] on each of the two smaller regions. If the original
     * region is too narrow to split, no action is taken.
     *
     * @return true if the original region was wide enough to split, false
     * otherwise
     */
    private fun splitLeftRight(x: Int, y: Int, width: Int, height: Int): Boolean {
        if (width <= MIN_RECTANGLE_WIDTH) return false
        val split = x + (width / 2)
        val widthFromLeft = split - x
        val widthFromRight = width - widthFromLeft
        if (widthFromLeft > 0 && widthFromRight > 0) {
            doMondrian(x, y, widthFromLeft, height)
            doMondrian(split, y, widthFromRight, height)
            return true
        }
        return false
    }

    /**
     * Performs an over-under split of the region specified by [x], [y],
     * [width], and [height], if it is tall enough to split, and calls
     * [doMondrian] on each of the two smaller regions. If the original
     * region is too short to split, no action is taken.
     *
     * @return true if the original region was tall enough to split, false
     * otherwise
     */
    private fun splitTopBottom(x: Int, y: Int, width: Int, height: Int): Boolean {
        if (height <= MIN_RECTANGLE_HEIGHT) return false
        val split = x + (height / 2)
        val heightFromTop = split - y
        val heightFromBottom = height - heightFromTop
        if (heightFromTop > 0 && heightFromBottom > 0) {
            doMondrian(x, y, width, heightFromTop)
            doMondrian(x, split, width, heightFromBottom)
            return true
        }
        return false
    }

    /**
     * Performs an horizontal and vertical split of the region specified
     * by [x], [y], [width], and [height], if it is both wide and tall enough
     * to split, and calls [doMondrian] on each of the four smaller regions.
     * If the original region is too small to split, no action is taken.
     *
     * @return true if the original region could be split, false otherwise
     */
    private fun split4Way(x: Int, y: Int, width: Int, height: Int): Boolean {
        if (width <= MIN_RECTANGLE_WIDTH || height <= MIN_RECTANGLE_HEIGHT) return false
        val verticalSplit = x + (width / 2)
        val horizontalSplit = y - (height / 2)
        val widthFromLeft = verticalSplit - x
        val widthFromRight = width - widthFromLeft
        val heightFromTop = horizontalSplit - y
        val heightFromBottom = height - heightFromTop
        if (widthFromLeft > 0 && widthFromRight > 0 && heightFromTop > 0 && heightFromBottom > 0) {
            doMondrian(x, y, widthFromLeft, heightFromTop)
            doMondrian(verticalSplit, y, widthFromRight, heightFromTop)
            doMondrian(x, horizontalSplit, widthFromLeft, heightFromBottom)
            doMondrian(verticalSplit, horizontalSplit, widthFromRight, heightFromBottom)
            return true
        }
        return false
    }

    /**
     * Divides the region with the given [x] and [y] coordinates and having
     * width [width] and height [height] into one or more colored rectangles,
     * in the style of Piet Mondrian.
     */
    fun doMondrian(
        x: Int,
        y: Int,
        width: Int,
        height: Int,
    ) {
        // TODO: When testing the split methods, put temporary calls here.

        // 1. If the width of the region is more than half the canvas width AND
        //    the height of the region is more than half the canvas height,
        //    call split4Way(x, y, width, height).
        if (width > REQUESTED_CANVAS_WIDTH / 2 && height > REQUESTED_CANVAS_HEIGHT / 2) {
            if (split4Way(x, y, width, height)) return
        }
        // 2. Otherwise, if the width of the region is more than half the
        //    canvas width (but the height is not more than half the canvas
        //    height), call splitLeftRight(x, y, width, height).
        if (width > REQUESTED_CANVAS_WIDTH / 2 && height <= REQUESTED_CANVAS_HEIGHT / 2) {
            if (splitLeftRight(x, y, width, height)) return
        }
        // 3. Otherwise, if the height of the region is more than half the
        //    canvas height (but the width is not more than half the canvas
        //    width), call splitTopBottom(x, y, width, height).
        if (height > REQUESTED_CANVAS_HEIGHT / 2 && width <= REQUESTED_CANVAS_WIDTH / 2) {
            if (splitTopBottom(x, y, width, height)) return
        }
        // 4. Otherwise, randomly choose a split type to attempt from these
        //    three options: LeftRight, TopBottom, or Both.
        //    * If LeftRight is chosen and the region is wide enough to split
        //      into two side-by-side regions, do so.
        //    * If TopBottom was chosen and the region is tall enough to split
        //      into two stacked (over-under) regions, do so.
        //    * If Both was chosen and the region is both wide enough and tall
        //      enough to split into four regions, do so.
        val option = listOf("LeftRight", "TopBottom", "Both").random()
        when (option) {
            "LeftRight" -> if (splitLeftRight(x, y, width, height)) return
            "TopBottom" -> if (splitTopBottom(x, y, width, height)) return
            "Both" -> if (split4Way(x, y, width, height)) return
        }

        // 5. If none of the above conditions code caused a split method to be
        //    called, fill the entire region with a single color. Half the time,
        //    the color should be white. The other half of the time, choose
        //    randomly among red, yellow, and blue. The outline color should
        //    always be black. You can modify the below sample code, which
        //    always draws a yellow rectangle with a black outline.
        val colors = listOf(Color.RED, Color.BLUE, Color.YELLOW)
        fun randomColor(): Color {
            return if (Math.random() < 0.5) Color.WHITE else colors.random()
        }
        canvas.drawRectangle(
            x,
            y,
            width,
            height,
            fillColor = randomColor(),
            outlineColor = Color.BLACK,
        )
    }

    /**
     * Handles a click at the specified [x]-[y] coordinates.
     */
    fun handleClick(x: Int, y: Int) {
        recolorRectangle(x, y)
    }

    /**
     * Changes the fill color of the rectangle containing ([x], [y]).
     */
    open fun recolorRectangle(x: Int, y: Int) {
        // You will need to determine the boundaries of the rectangle the
        // user has clicked on.
        // You may find the method canvas.getColorAt(x, y) helpful.
        val originalColor = canvas.getColorAt(x, y)
        val colors = listOf(Color.RED, Color.BLUE, Color.YELLOW, Color.WHITE)
        var left = x
        var right = x
        var top = y
        var bottom = y
        while (left > 0 && canvas.getColorAt(left - 1, y) == originalColor) {
            left--
        }
        while (right < REQUESTED_CANVAS_WIDTH - 1 && canvas.getColorAt(right + 1, y) == originalColor) {
            right++
        }
        while (top > 0 && canvas.getColorAt(x, top - 1) == originalColor) {
            top--
        }
        while (bottom < REQUESTED_CANVAS_HEIGHT - 1 && canvas.getColorAt(x, bottom + 1) == originalColor) {
            bottom++
        }
        val width = right - left + 1
        val height = bottom - top + 1
        canvas.drawRectangle(left, top, width, height, fillColor = colors.random(), outlineColor = Color.BLACK)
    }
}

/**
 * Creates a canvas and paints it in the style of Piet Mondrian.
 */
fun main() {
    require(REQUESTED_CANVAS_HEIGHT >= 4 * MIN_RECTANGLE_HEIGHT)
    require(REQUESTED_CANVAS_WIDTH >= 4 * MIN_RECTANGLE_WIDTH)
    MondrianPainter()
}

