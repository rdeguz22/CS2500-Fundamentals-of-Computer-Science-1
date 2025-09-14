import java.awt.Color

class MyMondrianPainter : MondrianPainter() {
    override fun recolorRectangle(x: Int, y: Int) {
        val originalColor = canvas.getColorAt(x, y)
        val colors = listOf(Color.RED, Color.BLUE, Color.YELLOW, Color.WHITE, Color.ORANGE, Color.CYAN, Color.GREEN)
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
    MyMondrianPainter()
}
