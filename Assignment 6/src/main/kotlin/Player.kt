/**
 * The player, who is controlled by key presses.
 */
class Player : LivingEntity("Steve", "Steve.png", 20, 6) {
    var lastKeyPressed: String? = null

    override fun tick() {
        // Use a when-statement to decide what to do based on lastKeyPressed.
        // If it is null, do nothing.
        // If it is arrow-right or d, try to move right.
        // If it is arrow-left or a, try to move left.
        // If it is arrow-up or w, try to move up.
        // If it is arrow-down or s, try to move down.
        // If it is space, do nothing.
        when (lastKeyPressed) {
            null -> {

            }

            "arrow-right", "d" -> {
                moveRight()
            }

            "arrow-left", "a" -> {
                moveLeft()
            }

            "arrow-up", "w" -> {
                moveUp()
            }

            "arrow-down", "s" -> {
                moveDown()
            }

            "space" -> {

            }

            "slash-key", "/" -> {
                attack()
            }

            else -> {
                Game.addText("I don't know how to handle $lastKeyPressed")
            }
        }

        // If it is / (slash), attack all hostile mobs in fighting distance,
        // outputting an appropriate message if there are none.
        // You may find it helpful to use the property Game.placedEntities.

        // Otherwise, output a message saying it couldn't
        // process that character (stating what it was).

        // Finally, set lastKeyPressed to null
    }

    private fun attack() {
        for (entity in Game.placedEntities) {
            if (Game.calculateDistance(this, entity) <= FIGHTING_RANGE) {
                if (entity is Mob && entity.isAggressive) {
                    attack(entity)
                }
            }
        }
    }
}
