import kotlin.random.Random

// 1. Create a Boolean val property "isAlive" that is true unless numHearts is 0
//    (or, equivalently, status == Status.Dead). It should have a custom getter
//    like the existing status property.
//
//    Create a new function "testIsAlive" that tests isAlive with every possible
//    status value (i.e., Healthy, Injured, and Dead). Uncomment the call to
//    testIsAlive() in runTests().
//
//    Run the tests and ensure they pass before proceeding.
//
/**
 * Creates 2 mobs with maxHearts values of 7 (which should pass as isAlive) and 0 (which should not pass as isAlive)
 */
fun testIsAlive() {
    val testMob1 = Mob("Rico", 7, Mob.Behavior.Boss, 1, 2)
    assertTrue(testMob1.isAlive)
    val testMob2 = Mob("Mike", 0, Mob.Behavior.Hostile, 1, 3)
    assertFalse(testMob2.isAlive)
}

// 2. Minecraft mobs can be Passive, Hostile, Neutral, or Boss.
//    * Passive mobs do not attack the player under any circumstances.
//    * Neutral mobs attack the player only if they were attacked first.
//    * Hostile and Boss mobs always attack the player.
//    (My instructions take priority over actual Minecraft rules, in case of
//    conflict.)
//
//    Create a Boolean val property "isAggressive" with a custom getter.
//    * It should always be true for a living Mob whose behavior is Hostile or
//      Boss.
//    * It should never be true for a mob whose behavior is Passive.
//    * If a mob is Neutral, it should be false until the Mob has been attacked,
//      after which it becomes true until it dies.
//    * Dead mobs always have an isAggressive value of false.
//    You must use "when" in your custom getter.
//
//    Add a new function "testIsAggressive" that covers every relevant
//    combination. For example, you would need two tests for a Boss Mob: one
//    when it is alive (when isAggressive should be true) and one when it is
//    dead (when isAggressive should be false). You will need more cases for
//    Neutral Mobs, which go from false to true (when attacked) to false (when
//    dead).
//
//    Call testIsAggressive() from runTests(). Ensure that all tests pass
//    before proceeding.
//
/**
 * Creates 8 mobs to test the isAggressive property with
 * The instance aggresMob1 has a behavior of Boss, therefore it passes as aggressive
 * The instance aggresMob2 has a behavior of Boss but has a maxHearts of 0, so it should not be aggressive since the mob is dead
 * The instance aggresMob3 has a behavior of Passive, therefore it is not aggressive
 * The instance aggresMob4 has a behavior of Hostile, therefore it is aggressive
 * The instance aggresMob5 has a behavior of Hostile but has a maxHearts of 0, so it should not be aggressive since the mob is dead
 * The instance aggresMob6 has a behavior of Neutral and it is not attacked, therefore it should not be aggressive
 * The instance aggresMob7 has a behavior of Neutral but a maxHearts of 0, so it should not be aggressive since the mob is dead
 * The instance aggresMpb8 has a behavior of Neutral but is then attacked as it loses a heart from its maxHearts value, therefore it passes as aggressive
 */
fun testIsAggresive() {
    val aggresMob1 = Mob("Rico", 7, Mob.Behavior.Boss, 1, 3)
    assertTrue(aggresMob1.isAggresive)
    val aggresMob2 = Mob("Mike", 0, Mob.Behavior.Boss, 1, 3)
    assertFalse(aggresMob2.isAggresive)
    val aggresMob3 = Mob("Ryan", 4, Mob.Behavior.Passive, 4, 29)
    assertFalse(aggresMob3.isAggresive)
    val aggresMob4 = Mob("Fabs", 2, Mob.Behavior.Hostile, 6, 12)
    assertTrue(aggresMob4.isAggresive)
    val aggresMob5 = Mob("David", 0, Mob.Behavior.Hostile, 5, 7)
    assertFalse(aggresMob5.isAggresive)
    val aggresMob6 = Mob("Zay", 4, Mob.Behavior.Neutral, 2, 8)
    assertFalse(aggresMob6.isAggresive)
    val aggresMob7 = Mob("Juan", 0, Mob.Behavior.Neutral, 1, 3)
    assertFalse(aggresMob7.isAggresive)
    val aggresMob8 = Mob("Lucas", 17, Mob.Behavior.Neutral, 4, 9)
    aggresMob8.numHearts -= 1
    assertTrue(aggresMob8.isAggresive)
}

// 3. Add properties minDamage and maxDamage (both Int) to the Mob constructor.
//    They specify how much damage the Mob can do to the player. You will have
//    to change all calls to the Mob constructor to include these values.
//
// 4. Complete the method attack(), as described below in the code. Note that
//    if there is a call to zombie.attack(skeleton), the zombie would be
//    attacking the skeleton.
//
//    Add a new test function, "testAttack". Because attack() has some randomness,
//    your tests will have to use a range of values. For example, if a skeleton
//    that can do 1-3 hearts of damage attacks a zombie that starts with 20 hearts,
//    you could check if the zombie's number of hearts is 17-19 after a single attack.
//    Call testAttack() from runTests(), and make sure all tests pass before proceeding.
//
/**
 * Creates 3 mobs to test the attack function with
 * The instance attackMob1 is a Mob that is both alive and aggressive, therefore it should be able to attack and be attacked
 * The instance attackMob2 is a Mob that is dead but aggressive, so it should not be able to attack or be a victim since it is dead
 * The instance attackMob3 is a Mob that is alive but passive, so it should be able to attacked, but it should not be able to attack because it is not aggressive
 */
fun testAttack() {
    val attackMob1 = Mob("Rico", 24, Mob.Behavior.Boss, 2, 2)
    val attackMob2 = Mob("Mike", 0, Mob.Behavior.Hostile, 1, 3)
    val attackMob3 = Mob("Fabs", 19, Mob.Behavior.Passive, 3, 7)
    attackMob1.attack(attackMob3)
    attackMob1.attack(attackMob2)
    attackMob2.attack(attackMob1)
    attackMob3.attack(attackMob1)
}

// 5. Complete the method battle(), as described below in the code.
//
// 6. Write a function named "doBattle()" outside of the class. It should have
//    no parameters and should create two Mobs and have them fight to the death.
//
//    Modify main() to make it call doBattle(). You may comment out the call
//    to runTests().
//
//    Include a transcript in Summary.md.
//
/**
 * Creates two mobs that are both aggressive and alive to test if the battle function works
 */
fun doBattle() {
    val mobUno = Mob("Rico", 200, Mob.Behavior.Boss, 1, 14)
    val mobDos = Mob("Lucas", 200, Mob.Behavior.Hostile, 2, 22)
    mobUno.battle(mobDos)
}
// 7. If you have extra time and energy, add more functionality. One idea is to
//    create multiple Mobs and have them battle in pairs until there is only one
//    survivor ("Mob Madness"). You could decide whether their health should be
//    topped off between battles.
//
//    Don't change any of the methods you implemented for the required parts of
//    the assignment.
//
//    There is no extra credit. This is just for fun and possible prizes.

/**
 * A Minecraft mob.
 * @property type the type (species)
 * @property maxHearts the maximum health level
 * @property behavior the mob's behavior (Passive, Hostile, Neutral, or Boss)
 * @property minDamage the minimum damage a mob can do with an attack
 * @property maxDamage the maximum damage a mob can do with an attack
 */
class Mob(
    val type: String,
    val maxHearts: Int,
    val behavior: Behavior,
    val minDamage: Int,
    val maxDamage: Int
) {
    enum class Behavior { Passive, Hostile, Neutral, Boss }

    enum class Status { Healthy, Injured, Dead }

    var numHearts = maxHearts

    val status
        get() =
            when (numHearts) {
                maxHearts -> Status.Healthy
                0 -> Status.Dead
                else -> Status.Injured
            }

    val isAlive: Boolean //passes as true unless the value of maxHearts is 0
        get() =
            when (numHearts) {
                0 -> false
                else -> true
            }

    /**
     * Determines if a mob can attack based on behavior
     * Passive or dead mobs are never aggressive
     * Boss or Hostile mobs are always aggressive
     * Neutral mobs are aggressive if they are attacked, otherwise they are not aggressive
     */
    var isAggresive: Boolean = false
        get() =
            when {
                !isAlive -> false
                behavior == Behavior.Passive -> false
                behavior == Behavior.Boss -> true
                behavior == Behavior.Hostile -> true
                behavior == Behavior.Neutral -> if (numHearts < maxHearts) true else false
                else -> false
            }


    override fun toString() = type

    /**
     * Takes up to [damage] hearts of damage, to a maximum of [numHearts],
     * printing a message with the amount of damage taken and the
     * resulting [status].
     */

    fun takeDamage(damage: Int) {
        val actualDamage = if (damage > numHearts) numHearts else damage
        numHearts -= actualDamage
        val text = if (actualDamage == 1) "heart" else "hearts"
        println("The $type took $actualDamage $text of damage.")
        println("It is now $status.")
    }

    /**
     * Attacks [victim], doing between [minDamage] and[maxDamage]
     * (inclusive) hearts of damage.
     * @victim is the mob that is being attacked or losing hearts
     *
     * @throws IllegalArgumentException unless [isAggressive]
     */
    fun attack(victim: Mob) {
        // First, use require() to ensure that this Mob's isAggressive
        // property is true.
        //
        // If so, select a random number between minDamage and maxDamage
        // (including those values) and make the victim take that much
        // damage. For example, if minDamage was 3 and maxDamage was 5,
        // this would do 3, 4, or 5 hearts of damage.
        if (!this.isAggresive || !victim.isAlive) { // this function is a test case for Mob's that are trying to attack but can't due to behavior or Mobs that are being attacked and are already dead
            println("Cannot attack")
            return Unit
        }
        require(this.isAggresive && victim.isAlive)
        val damage = Random.nextInt(minDamage, maxDamage + 1)
        victim.takeDamage(damage)
    }

    /**
     * Simulates a battle to the death with [opponent]. The property
     * [isAggressive] must be true for at least one of them, or neither
     * would damage the other and the fight would never end.
     * @opponent is the mob that is in opposition
     *
     * @throws IllegalArgumentException if [isAggressive] is false for
     *     both this Mob and its opponent
     */
    fun battle(opponent: Mob) {
        // First, use require() to ensure that isAggressive is true
        // for at least one of the two Mobs.
        //
        // This Mob and its opponent take turns. A Mob does nothing
        // during its turn unless it isAggressive, in which case
        // call attack() with the other Mob as its victim.
        //
        // When one of the two Mobs is dead, the winner is announced
        // (printed), and the method ends (returns). Do not use the
        // keywords "break" or "continue" in this method. Do use "while".
        require(this.isAggresive || opponent.isAggresive)
        while (this.isAlive && opponent.isAlive) {
            if (this.isAggresive) {
                this.attack(opponent)
            }
            if (!opponent.isAlive) {
                println("$this has won the fight.")
            }
            if (opponent.isAggresive) {
                opponent.attack(this)
            }
            if (!this.isAlive) {
                println("$opponent has won the fight.")
            }
        }
    }
}

fun main() {
    //runTests()
    doBattle()
}

fun runTests() {
    testIsAlive()
    testIsAggresive()
    testAttack()
    println("All tests passed")
}
