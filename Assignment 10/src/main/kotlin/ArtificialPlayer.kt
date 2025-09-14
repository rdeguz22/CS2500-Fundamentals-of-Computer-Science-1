import java.lang.Thread.sleep

class ArtificialPlayer(ui: UserInterface) : Player(ui) {
    // Source of real Wordle word list: https://github.com/tabatkins/wordle-list
    private val wordList = readWordsFromFile("input-words.txt")
    private val constraints: MutableList<(String) -> Boolean> = mutableListOf()

    override fun startNewGame() {
        constraints.clear()
    }

    override fun generateGuess(): String {
        // Pause for one second so the play doesn't move too fast.
        sleep(1000L)

        // Return the first word that satisfies all the constraints.
        // You may want to write a helper method.
        return wordList.first { word -> constraints.all { it(word) } }
    }

    override fun incorporateFeedback(guess: String, matchString: String) {
        // Add new constraints based on our last guess and the resulting
        // matchString, as described in Instructions.md.
        for (i in guess.indices) {
            val char = guess[i]
            val match = matchString[i]
            when (match) {
                '*' -> {
                    constraints.add { word -> word[i] == char }
                }

                '+' -> {
                    constraints.add { word -> word.contains(char) && word[i] != char }
                }

                else -> {
                    if (constraints.contains { it.contains(char) }) constraints.add { word -> word[i] != char }
                    else constraints.add { word -> !word.contains(char) }
                }
            }
        }

    }
}
