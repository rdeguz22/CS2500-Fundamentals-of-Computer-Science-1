// You will be implementing a version of the game Wordle. If you are not
// familiar with it, learn how to play.
// https://www.nytimes.com/games/wordle/index.html
//
// Our version will not use colors.
// * It will use "*" (instead of green) for correct letters in the guess that
//   are in the correct position.
// * It will use "+" (instead of yellow) for letters that are in the secret word
//   but not in the correct position.
// * It will use "." for any guessed letters not in the secret word.
// See the provided method runTests() for examples.
//
// To make the logic easier, our game will have these differences:
// * Our secret words (answers) will have no repeating letters.
// * You can assume that there are no repeating letters in the guess.
// * You will be able to specify how long the secret word should be, which
//   should make debugging easier. For example, you can start with puzzles
//   of length 1 or 2.
// * Guesses do not have to be legal words. For example, you can guess "AEIOU".
// * There are an unlimited number of guesses.
//
// 0. Look over the provided functions in SupportCode.kt and the section
//    on useful functions and methods on Canvas.
//
// 1. Add properties (that are not parameters) to class WordleGame:
//    * guesses (MutableList<String>) [all guesses made]
//    * numGuesses (Int) [number of guesses made, custom getter]
//    * wordFound (Boolean) [whether the secret word has been guessed, custom
//      getter]
//    You must use a custom getter for numGuesses and wordFound.
//
// 2. You are provided with runTests5(), which runs tests on a 5-letter secret
//    word. Make sure you understand it. Remove the comment markers once you
//    have added the properties they reference.
//
//    Create similar methods for secret words of length 1, 2, 3, and 4. You must
//    have at least 5 assertions in each of your 4 test methods. You may use AI
//    to write or check your tests, and you may ask classmates or TAs to look over
//    your tests to make sure they are correct. Remember to list people/AI you worked
//    with in your write-up and that you are ultimately responsible for correctness.
//
//    Add calls from runTests() to your new functions, ordering them by
//    increasing word length.
//
//    Try running your tests. They should fail. That's good.
//    https://learning.oreilly.com/library/view/modern-c-programming/9781941222423/f_0054.html
//
// 3. Implement makeGuess(), as described in the KDoc, for words of length 1.
//    Note that we are no longer providing detailed instructions in the
//    comments. Do not proceed to the next step until runTests1() passes.
//
// 4. Repeat the process for words of length 2, 3, 4, and 5. You should write
//    a general solution that will work for strings of any length, but you may
//    find it easier to add one letter at a time until you find the general
//    pattern.
//
// 5. Implement playGame() as described in the KDoc and internal comments.
//    Modify main() so it calls playGame() after runTests().
//
// 6. Modify playGame() so it prompts the user after each game asking if
//    they would like to play again. If they indicate that they do, start
//    a fresh game with a different word. For full credit, do not reload the
//    word list, which is an expensive operation.
//
// 7. Put a transcript of your program in Summary.md. You should use the longest
//    word length you successfully implemented and show that the user could play
//    more than one game without restarting the program.
//
//    If you want an extra challenge, figure out how to correctly handle words
//    with repeated letters or to enforce that guesses are legal words.

/**
 * A single Wordle game.
 *
 * @property secretWord the word for the user to guess
 * @property guesses list of all user guesses
 * @property numGuesses number of guesses made
 * @property wordFound true if word is found false if not
 */
class WordleGame(
    val secretWord: String,
) {
    val guesses: MutableList<String> = mutableListOf()
    val numGuesses: Int
        get() = guesses.size
    val wordFound: Boolean
        get() = if (secretWord in guesses) true else false

    /**
     * Guesses that the secret word is [guess]. This returns a feedback String.
     * For every position where [guess] matches [secretWord], a star (*)
     * appears. For positions where the letter in [guess] corresponds to a
     * different position in [secretWord], a plus sign (+) appears. If there
     * is no match, a dot (.) appears.
     *
     * @throws IllegalArgumentException if the length of [guess] is not the same
     * as the length of [secretWord]
     */
    fun makeGuess(guess: String): String {
        require(guess.length == secretWord.length)
        val sb = StringBuilder()
        for (ch in secretWord.indices) {
            if (guess[ch].uppercaseChar() == secretWord[ch]) sb.append('*')
            else if (guess[ch].uppercaseChar() in secretWord) sb.append('+')
            else sb.append('.')
        }
        // If guess has not been played this game, add it to guesses.
        // Otherwise, it doesn't count as a new guess, but you should
        // still give feedback.
        if (guess !in guesses) guesses.add(guess.uppercase())
        // Calculate and return the match string.
        return sb.toString()
    }

}

/**
 * Plays Wordle.
 *
 * @property wordLength the length of the secret word
 */
fun playGame(wordLength: Int) {
    // Call readWordsFromFile() to get the random list of words.
    val words = readWordsFromFile(wordLength)
    // Get a random word from the list. Useful library functions are linked
    // in the Canvas assignment.
    while (true) {
        val randomWord = words.random()
        // Create a WordleGame with the random word.
        val game = WordleGame(randomWord.toString())
        // While the game has not been won:
        // 1. Prompt the player to enter a guess.
        // 2. Call makeGuess() with the guess.
        // 3. Print the resulting string.
        while (!game.wordFound) {
            println("Enter guess ($wordLength letter/s): ")
            val guess = readln()
            println(game.makeGuess(guess))
        }
        // Once the game has been won:
        // 1. Tell the player that they won.
        // 2. Say how many guesses it took to correctly guess the word.
        // 3. Print their guesses.
        println("You found the word! It took ${game.guesses.size} guess/es. You guessed: ${game.guesses.toString()}")
        println("Play again? y/n")
        val playAgain = readln()
        if (playAgain.lowercase() == "yes" || playAgain.lowercase() == "y") continue else break
    }
}

fun main() {
    runTests()
    playGame(5)
}

fun runTests() {
    runTests5()
    runTests4()
    runTests3()
    runTests2()
    runTests1()
    println("All tests pass.")
}

fun runTests5() {
    val game = WordleGame("ABCDE")
    assertEquals(0, game.numGuesses)
    assertFalse(game.wordFound)
    assertEquals(".....", game.makeGuess("FGHIJ"))
    assertEquals("++*++", game.makeGuess("EDCBA"))
    assertEquals(".*+++", game.makeGuess("ZBDEC"))
    assertFalse(game.wordFound)
    assertEquals(3, game.numGuesses)
    assertEquals(".....", game.makeGuess("FGHIJ"))
    assertEquals(3, game.numGuesses)
    assertEquals("*****", game.makeGuess("ABCDE"))
    assertEquals(4, game.numGuesses)
    assertTrue(game.wordFound)
    assertEquals(
        mutableListOf("FGHIJ", "EDCBA", "ZBDEC", "ABCDE"),
        game.guesses,
    )
}

fun runTests4() {
    val game = WordleGame("ABCD")
    assertEquals(0, game.numGuesses)
    assertFalse(game.wordFound)
    assertEquals("....", game.makeGuess("FGHI"))
    assertEquals("++*+", game.makeGuess("BDCA"))
    assertEquals(".*++", game.makeGuess("ZBDC"))
    assertFalse(game.wordFound)
    assertEquals(3, game.numGuesses)
    assertEquals("....", game.makeGuess("FGHI"))
    assertEquals(3, game.numGuesses)
    assertEquals("****", game.makeGuess("ABCD"))
    assertEquals(4, game.numGuesses)
    assertTrue(game.wordFound)
    assertEquals(
        mutableListOf("FGHI", "BDCA", "ZBDC", "ABCD"),
        game.guesses,
    )
}

fun runTests3() {
    val game = WordleGame("ABC")
    assertEquals(0, game.numGuesses)
    assertFalse(game.wordFound)
    assertEquals("...", game.makeGuess("FGH"))
    assertEquals("++*", game.makeGuess("BAC"))
    assertEquals(".*+", game.makeGuess("ZBA"))
    assertFalse(game.wordFound)
    assertEquals(3, game.numGuesses)
    assertEquals("...", game.makeGuess("FGH"))
    assertEquals(3, game.numGuesses)
    assertEquals("***", game.makeGuess("ABC"))
    assertEquals(4, game.numGuesses)
    assertTrue(game.wordFound)
    assertEquals(
        mutableListOf("FGH", "BAC", "ZBA", "ABC"),
        game.guesses,
    )
}

fun runTests2() {
    val game = WordleGame("AB")
    assertEquals(0, game.numGuesses)
    assertFalse(game.wordFound)
    assertEquals("..", game.makeGuess("FG"))
    assertEquals("++", game.makeGuess("BA"))
    assertEquals(".*", game.makeGuess("ZB"))
    assertFalse(game.wordFound)
    assertEquals(3, game.numGuesses)
    assertEquals("..", game.makeGuess("FG"))
    assertEquals(3, game.numGuesses)
    assertEquals("**", game.makeGuess("AB"))
    assertEquals(4, game.numGuesses)
    assertTrue(game.wordFound)
    assertEquals(
        mutableListOf("FG", "BA", "ZB", "AB"),
        game.guesses,
    )
}

fun runTests1() {
    val game = WordleGame("A")
    assertEquals(0, game.numGuesses)
    assertFalse(game.wordFound)
    assertEquals(".", game.makeGuess("F"))
    assertFalse(game.wordFound)
    assertEquals(1, game.numGuesses)
    assertEquals(".", game.makeGuess("G"))
    assertEquals(2, game.numGuesses)
    assertEquals("*", game.makeGuess("A"))
    assertEquals(3, game.numGuesses)
    assertTrue(game.wordFound)
    assertEquals(
        mutableListOf("F", "G", "A"),
        game.guesses,
    )

}
