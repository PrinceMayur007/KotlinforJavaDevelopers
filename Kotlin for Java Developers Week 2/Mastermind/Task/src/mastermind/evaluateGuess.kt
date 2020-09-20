package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    //guessing secret
    val (correctLetterAndPositionsAmount, reducedSecret, reducedGuess) =
            positionsGuessedCorrectly(secret, guess)

    val correctLettersAmount =
            lettersGuessedCorrectly(reducedSecret, reducedGuess)

    return Evaluation(correctLetterAndPositionsAmount, correctLettersAmount)
}
fun lettersGuessedCorrectly(secret: String, guess: String): Int {
    var correctGuesses = 0
    var mutableSecret = secret
    for (ch in guess) {
        if (mutableSecret.contains(ch)) {
            mutableSecret = mutableSecret.replaceFirst(ch.toString(), "", true)
            correctGuesses++
        }
    }
    return correctGuesses
}

fun positionsGuessedCorrectly(secret: String, guess: String): Triple<Int, String, String> {
    val indexesToRemove = identifyIndexesToRemove(guess, secret)
    var (reducedSecret, reducedGuess) =
            reduceStringsRemovingIndexesFrom(secret, guess, indexesToRemove)

    val correctGuesses = indexesToRemove.size
    return Triple(correctGuesses, reducedSecret, reducedGuess)
}

private fun identifyIndexesToRemove(guess: String, secret: String): MutableList<Int> {
    val indexesToRemove = mutableListOf<Int>()
    for (guessedPair in guess.withIndex()) {
        val guessedIndex = guessedPair.index
        val secretLetter = secret[guessedIndex]
        if (guessedPair.value == secretLetter) {
            indexesToRemove.add(guessedIndex)
        }
    }
    return indexesToRemove
}

private fun reduceStringsRemovingIndexesFrom(secret: String,
                                             guess: String,
                                             indexesToRemove: MutableList<Int>): Pair<String, String> {
    var currentSecret = secret
    var currentGuess = guess

    //reverse
    indexesToRemove.reversed().forEach {
        currentGuess = currentGuess.replaceRange(it, it + 1, "")
        currentSecret = currentSecret.replaceRange(it, it + 1, "")
    }
    return Pair(currentSecret, currentGuess)
}