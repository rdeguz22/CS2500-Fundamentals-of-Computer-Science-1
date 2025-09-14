/**
 * Generates spiders on adjacent empty cells
 */
class SpiderSpawner : Entity("SpiderSpawner", "SpawnerOnSand.png"), Damageable {
    private val spawnProbabilty: Double = 0.75
    private var hardness: Int = 6

    private fun spawnIfSpace() {
        val emptyCellPosition = selectAdjacentEmptyCell()
        if (emptyCellPosition != null) {
            val spider = Spider()
            Game.place(spider, emptyCellPosition.x, emptyCellPosition.y)
            Game.addText("Spider spawned at ${emptyCellPosition}.")
        } else {
            Game.addText("There is no adjacent cell, so no Spider is created.")
        }
    }

    override fun tick() {
        val randValue = kotlin.random.Random.nextDouble()
        Game.addText("Random value: $randValue")
        if (randValue < spawnProbabilty) {
            Game.addText("Attempting to spawn a spider.")
            spawnIfSpace()
        } else {
            Game.addText("No spider spawned.")
        }
    }

    override fun takeDamage(damage: Int) {
        val actualDamage = if (damage > hardness) hardness else damage
        hardness -= actualDamage
        val text = if (actualDamage == 1) "unit" else "units"
        Game.addText("SpiderSpawner took $actualDamage $text of damage. Remaining hardness: $hardness.")
        if (hardness <= 0) {
            destroy()
        }
    }

    private fun destroy() {
        Game.addText("The SpiderSpawner has been destroyed.")
        exit()
    }
}