import kotlin.random.Random

const val FIGHTING_RANGE = 3.0

/**
 * A living entity, such as a [Mob] or [Player] in the game.
 */
abstract class LivingEntity(
    type: String,
    imageFileName: String,
    val maxHearts: Int,
    val attackStrength: Int,
) : Entity(type, imageFileName) {
    enum class Status { Healthy, Injured, Dead }

    var numHearts = maxHearts
        private set

    var status = Status.Healthy
        private set
        get() =
            when (numHearts) {
                maxHearts -> Status.Healthy
                0 -> Status.Dead
                else -> Status.Injured
            }

    val isAlive
        get() = status != Status.Dead

    override fun toString() = "$status $type"

    /**
     * Takes up to [damage] hearts of damage, to a maximum of [numHearts],
     * printing a message with the amount of damage taken and the
     * resulting [status].
     */
    fun takeDamage(
        attacker: LivingEntity,
        damage: Int,
    ) {
        val actualDamage = if (damage > numHearts) numHearts else damage
        numHearts -= actualDamage
        val text = if (actualDamage == 1) "heart" else "hearts"
        Game.addText("$type took $actualDamage $text of damage and is now $status.")
        if (status == Status.Dead) {
            this.die()
        }
    }

    /**
     * Attacks [victim], doing [attackStrength] hearts of damage.
     */
    open fun attack(victim: LivingEntity) {
        Game.addText("$type attacked ${victim.type}.")
        victim.takeDamage(this, attackStrength)
    }

    /**
     * Moves right one cell, or stays in the same place, if that cell is
     * occupied by a [LivingEntity] or out of bounds. This should throw
     * [IllegalArgumentException] if this living entity is not on the board.
     */
    fun moveRight() {
        // You should call Game.getPosition() and Game.place() as part of
        // your implementation.
        val currentPosition = Game.getPosition(this)
        if (currentPosition == null) throw IllegalArgumentException("This living entity is not on the board.")
        val newPosition = Pair(currentPosition.x + 1, currentPosition.y)
        if (!Game.isInBounds(newPosition.first, newPosition.second) || Game.isOccupied(
                newPosition.first,
                newPosition.second
            )
        ) return
        Game.place(this, newPosition.first, newPosition.second)
    }

    /**
     * Moves left one cell, or stays in the same place, if that cell is
     * occupied by a [LivingEntity] or out of bounds.
     */
    fun moveLeft() {
        move(-1, 0)
    }

    /**
     * Moves up one cell, or stays in the same place, if that cell is
     * occupied by a [LivingEntity] or out of bounds.
     */
    fun moveUp() {
        // On the game board, moving up decreases the y-coordinate.
        move(0, -1)
    }

    /**
     * Moves down one cell, or stays in the same place, if that cell is
     * occupied by a [LivingEntity] or out of bounds.
     */
    fun moveDown() {
        // On the game board, moving down increases the y-coordinate.
        move(0, 1)
    }

    /**
     * Moves randomly to an adjacent unoccupied cell. Cells
     * are considered adjacent if they are to the right, left, up,
     * or down (i.e., changing by 1 either the x-coordinate or the
     * y-coordinate but not both).
     */
    fun moveRandomly() {
        val rng = Random.nextInt(1, 4)
        when (rng) {
            1 -> moveRight()
            2 -> moveLeft()
            3 -> moveUp()
            4 -> moveDown()
        }
    }

    /**
     * Tries to move to an adjacent cell closer to [player]. Cells
     * are considered adjacent if they are to the right, left, up,
     * or down (i.e., changing by 1 either the x-coordinate or the
     * y-coordinate but not both). If all closer adjacent cells are
     * occupied, no movement will occur. This should throw
     * [IllegalArgumentException] if this living entity or [player]
     * is not on the board.
     */
    fun moveTowards(player: Player) {
        val currentPosition = Game.getPosition(this)
        if (currentPosition == null) throw IllegalArgumentException("This living entity is not on the board.")
        val otherCurrentPosition = Game.getPosition(player)
        if (otherCurrentPosition == null) throw IllegalArgumentException("This living entity is not on the board.")
        if (Game.isOccupied(otherCurrentPosition.x + 1, otherCurrentPosition.y) ||
            Game.isOccupied(otherCurrentPosition.x - 1, otherCurrentPosition.y) ||
            Game.isOccupied(otherCurrentPosition.x, otherCurrentPosition.y + 1) ||
            Game.isOccupied(otherCurrentPosition.x, otherCurrentPosition.y - 1)
        ) {
            return
        }
        if (otherCurrentPosition.x > currentPosition.x) {
            this.moveRight()
        } else if (otherCurrentPosition.x < currentPosition.x) {
            this.moveLeft()
        } else if (otherCurrentPosition.y > currentPosition.y) {
            this.moveDown()
        } else if (otherCurrentPosition.y < currentPosition.y) {
            this.moveUp()
        }
    }

    private fun move(deltaX: Int, deltaY: Int) {
        val currentPosition = Game.getPosition(this)
        if (currentPosition == null) throw IllegalArgumentException("This living entity is not on the board.")
        val newPosition = Pair(currentPosition.x + deltaX, currentPosition.y + deltaY)
        if (!Game.isInBounds(newPosition.first, newPosition.second) || Game.isOccupied(
                newPosition.first,
                newPosition.second
            )
        ) return
        Game.place(this, newPosition.first, newPosition.second)
    }
}
