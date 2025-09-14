package minecraft

import assertEquals
import assertFalse
import assertTrue

fun main() {
    testCountNeutralMobs()
    testGetNumEntitiesPrintedAs()
    testIsBehaviorPresent()
    testGetLivingEntityTypesSortedByX()
    testIsPlayerStrongest()
    testGetStrengthsOfNearbyThreats()
    testGetLocationList()
    testGetBlockNamesBeneathPlacedEntities()
    testGetDescriptionsOfEntitiesAndBlocks()
    testGetEntitiesWithinRange()
    println("All tests passed.")
}

/**
 * Gets a count of the number of neutral mobs on the board.
 */
fun countNeutralMobs(): Int = Game.placedEntities.filterIsInstance<Mob>().count { it.behavior == Mob.Behavior.Neutral }

fun testCountNeutralMobs() {
    assertEquals(1, countNeutralMobs())
}

/**
 * Gets the number of entities whose string representation is [printedForm].
 */
fun getNumEntitiesPrintedAs(printedForm: String): Int = Game.placedEntities.count { it.toString() == printedForm }

fun testGetNumEntitiesPrintedAs() {
    assertEquals(1, getNumEntitiesPrintedAs("Zombie"))
    assertEquals(2, getNumEntitiesPrintedAs("Witch"))
    assertEquals(0, getNumEntitiesPrintedAs("Axolotl"))
}

/**
 * Returns whether any mobs have the specified [behavior].
 */
fun isBehaviorPresent(behavior: Mob.Behavior): Boolean =
    Game.placedEntities.filterIsInstance<Mob>().any { it.behavior == behavior }

fun testIsBehaviorPresent() {
    assertTrue(isBehaviorPresent(Mob.Behavior.Passive))
    assertFalse(isBehaviorPresent(Mob.Behavior.Boss))
}

/**
 * Gets the type of every [Mob] sorted by increasing x-coordinate.
 */
fun getLivingEntityTypesSortedByX(): List<String> =
    Game.placedEntities.filterIsInstance<Mob>().sortedBy { Game.getPosition(it).x }.map { it.type }

fun testGetLivingEntityTypesSortedByX() {
    val expected = listOf("Witch", "Zombie", "Sheep", "Witch", "Skeleton", "Spider")
    val actual = getLivingEntityTypesSortedByX()
    assertEquals(expected, actual)
}

/**
 * Returns true if [Game.player] has higher [LivingEntity.numHearts] than any
 * other living entity.
 */
fun isPlayerStrongest() =
    // Hint: Try to rephrase the requirement to use the word "any" or "all".
    Game.placedEntities.filterIsInstance<LivingEntity>().all { it.numHearts < Game.player.numHearts }

fun testIsPlayerStrongest() {
    assertFalse(isPlayerStrongest())
}

/**
 * Gets the attack strength of every aggressive and mob whose distance from
 * [Game.player] is within fighting range. The list is sorted by increasing
 * distance.
 */
fun getStrengthsOfNearbyThreats(): List<Int> =
    Game.placedEntities.filterIsInstance<Mob>()
        .filter { it.isAggressive && Game.calculateDistance(it, Game.player) <= FIGHTING_RANGE }
        .sortedBy { Game.calculateDistance(it, Game.player) }.map { it.attackStrength }


fun testGetStrengthsOfNearbyThreats() {
    val expected = listOf(6, 5)
    val actual = getStrengthsOfNearbyThreats()
    assertEquals(expected, actual)
}

/**
 * Returns a list giving the type and location of each living entity on the
 * board, sorted from top to bottom of the board.
 */
fun getLocationList(): List<String> =
    Game.placedEntities.filterIsInstance<LivingEntity>().sortedBy { Game.getPosition(it).y }
        .map { "${it.type} at (${Game.getPosition(it).x}, ${Game.getPosition(it).y})" }

fun testGetLocationList() {
    val actual = getLocationList()
    val expected =
        listOf(
            "Witch at (1, 1)",
            "Skeleton at (6, 1)",
            "Spider at (7, 2)",
            "Sheep at (3, 3)",
            "Zombie at (2, 4)",
            "Steve at (5, 5)",
            "Witch at (4, 6)",
        )
    assertEquals(expected, actual)
}

/**
 * Gets the string representations of the blocks on which entities are placed.
 * Each string representation should occur no more than once.
 */
fun getBlockNamesBeneathPlacedEntities(): List<String> {
    // You will need to use Game.getBlock() to get the blocks at each entity's
    // position.
    //
    // Game.getBlock() will never return null for placed entities because they
    // are in bounds, but do not use "!!". Find another way to ensure the output
    // is List<String> (and not List<String?>).
    //
    // To get a string representation of an object, call its toString() method.
    return Game.placedEntities.mapNotNull { entity ->
        val position = Game.getPosition(entity)
        Game.getBlock(position.x, position.y)?.toString()
    }.distinct()
}

fun testGetBlockNamesBeneathPlacedEntities() {
    val actual = getBlockNamesBeneathPlacedEntities()
    assertEquals(2, actual.size)
    // The strings can be in any order.
    assertTrue(actual.contains("Grass"))
    assertTrue(actual.contains("Sand"))
}

/**
 * Returns an alphabetical list of statements about each entity and the block it
 * is placed on, such as "Axolotl is on Sand at (3, 4)", which would precede
 * "Zombie is on Sand at (2, 2)"
 */
fun getDescriptionsOfEntitiesAndBlocks(): List<String> =
    // Hint: Create a helper function.
    Game.placedEntities.mapNotNull { entity ->
        val position = Game.getPosition(entity)
        val block = Game.getBlock(position.x, position.y)
        block?.let {
            "${entity.type} is on ${block} at (${position.x}, ${position.y})"
        }
    }.sorted()

fun testGetDescriptionsOfEntitiesAndBlocks() {
    val expected =
        listOf(
            "Sheep is on Grass at (3, 3)",
            "Skeleton is on Sand at (6, 1)",
            "Spider is on Sand at (7, 2)",
            "Steve is on Grass at (5, 5)",
            "Witch is on Grass at (1, 1)",
            "Witch is on Grass at (4, 6)",
            "Zombie is on Grass at (2, 4)",
        )
    val actual = getDescriptionsOfEntitiesAndBlocks()
    assertEquals(expected, actual)
}

/**
 * Returns a list of entities within a given [range] from the player
 *
 * @param range the maximum distance from the player from which entities should be from.
 * @return a list of entities within the specified range from the player
 */
fun getEntitiesWithinRange(range: Double): List<Entity> {
    return Game.placedEntities.filter { entity ->
        Game.calculateDistance(entity, Game.player) <= range
    }
}

fun testGetEntitiesWithinRange() {
    val drop = getEntitiesWithinRange(6.0)
    assertTrue(drop.map { it.type }.contains("Sheep"))
    assertTrue(drop.map { it.type }.contains("Skeleton"))
}