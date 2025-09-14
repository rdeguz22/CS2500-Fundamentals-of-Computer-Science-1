/**
 * Prompts a user to enter their name.
 *
 * @return the text entered by the user
 */
fun getUserName(): String {
    println("What is your name?")
    val newName = readln()
    return newName
}

/**
 * Greets the user by [name].
 */
fun greetUser(name: String) {
    println("Hello, $name!")
}

/**
 * Prompts a user to enter their favorite food.
 *
 * @return the text entered by the user
 */
fun getFavFood(): String {
    println("What is your favorite food?")
    val favFood = readln()
    return favFood
}

/**
 * States the user's favorite food
 */
fun printFavFood(food: String) {
    println("Your favorite food is $food!")
}

/**
 * Prompts a user to enter their favorite song.
 *
 * @return the text entered by the user
 */
fun getFavSong(): String {
    println("What is your favorite song?")
    val favSong = readln()
    return favSong
}

/**
 * States the user's favorite song
 */
fun printFavSong(song: String) {
    println("Your favorite song is $song")
}

/**
 * Carries on a brief conversation with a user.
 */
fun converse() {
    val name = getUserName()
    greetUser(name)
    val food = getFavFood()
    printFavFood(food)
    val song = getFavSong()
    printFavSong(song)
}
