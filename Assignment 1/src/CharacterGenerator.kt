import kotlin.random.Random

/**
 * Rolls a single six-sided die.
 *
 * @return a random number in the range 1-6
 */
fun rollDie(): Int {
    // The second argument to nextInt() is the upper bound, which is exclusive,
    // so this will return a number in the range 1-6.
    return Random.nextInt(1, 7)
}

/**
 * Rolls 3 six-sided dice.
 *
 * @return the sum of 3 random numbers in the range 1-6
 */
fun rollThreeDice(): Int {
    var total = 0
    var current = 0
    for (i in 1..3) {
        current = rollDie()
        total += current
        current = 0
    }
    return total
}

/**
 * Rolls a single die having numbers in the range [minValue] to [maxValue]
 * (inclusive).
 *
 * @return a random number in the range [minValue] to [maxValue] (inclusive)
 */
fun rollBiasedDie(minValue: Int, maxValue: Int): Int {
    return Random.nextInt(minValue, maxValue+1)
}

/**
 * Rolls 3 dice having numbers in the range [minValue] to [maxValue] (inclusive).
 *
 * @return the sum of 3 random numbers in the range [minValue] to [maxValue]
 */
fun rollThreeBiasedDice(minValue: Int, maxValue: Int): Int {
    var total = 0
    var current = 0
    for (i in 1..3) {
        current = rollBiasedDie(minValue, maxValue)
        total += current
        current = 0
    }
    return total
}

/**
 * Makes a character with a user-provided name and randomly-selected stats
 * using 3 ordinary six-sided dice.
 *
 * @return a sentence describing the character
 */
fun makeCharacter(): String {
    println("Enter your character's name:")
    val name = readln()
    val charisma = rollThreeDice()
    val agility = rollThreeDice()
    val speed = rollThreeDice()
    return "$name has charisma $charisma, agility $agility, and speed $speed."
}

/**
 * Makes a potentially superior character with a user-provided name and
 * randomly-selected stats using 3 positively biased dice.
 *
 * @return a sentence describing the hero
 */
fun makeHero(): String {
    println("Enter your character's name:")
    val name = readln()
    val charisma = rollThreeBiasedDice(3,6)
    val agility = rollThreeBiasedDice(3,6)
    val speed = rollThreeBiasedDice(3,6)
    return "$name has charisma $charisma, agility $agility, and speed $speed."
}

/**
 * Makes a character with a user-provided name and randomly-selected stats
 * using 3 dice whose minimum and maximum values are specified by the user.
 *
 * @return a sentence describing the adventurer
 */
fun makeAdventurer(): String {
    println("Enter your character's name:")
    val name = readln()
    println("Enter minimum value:")
    val min = readln().toInt()
    println("Enter maximum value:")
    val max = readln().toInt()
    val charisma = rollThreeBiasedDice(min,max)
    val agility = rollThreeBiasedDice(min,max)
    val speed = rollThreeBiasedDice(min,max)
    return "$name has charisma $charisma, agility $agility, and speed $speed."
}
