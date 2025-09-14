/**
 * A spawner of any type of [Entity].
 */
open class Spawner<T : Entity>(
    private val spawnType: String,
    private val spawn: () -> T,
    private val spawnProbability: Double,
    private var hardness: Int
) : Entity("$spawnType Spawner", "SpawnerOnSand.png"), Damageable {
    private fun spawnIfSpace() {
        val emptyCellPosition = selectAdjacentEmptyCell()
        if (emptyCellPosition != null) {
            val newEntity = spawn()
            Game.place(newEntity, emptyCellPosition.x, emptyCellPosition.y)
            Game.addText("$spawnType spawned at ${emptyCellPosition}.")
        } else {
            Game.addText("No adjacent cell available.")
        }
    }

    override fun tick() {
        val randValue = kotlin.random.Random.nextDouble()
        Game.addText("Random value: $randValue")
        if (randValue < spawnProbability) {
            Game.addText("Attempting to spawn a $spawnType.")
            spawnIfSpace()
        } else {
            Game.addText("No $spawnType spawned.")
        }
    }

    override fun takeDamage(damage: Int) {
        val actualDamage = if (damage > hardness) hardness else damage
        hardness -= actualDamage
        val text = if (actualDamage == 1) "unit" else "units"
        Game.addText("$spawnType took $actualDamage $text of damage. Remaining hardness: $hardness.")
        if (hardness <= 0) {
            destroy()
        }
    }

    private fun destroy() {
        Game.addText("The $spawnType has been destroyed.")
        exit()
    }
}
