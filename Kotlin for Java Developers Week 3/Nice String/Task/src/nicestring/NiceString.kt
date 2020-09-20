package nicestring

fun String.isNice(): Boolean {
    return isNiceWork()
}

fun String.isNiceSimple(): Boolean {
    var conditionsMatched = 0


    if(!this.contains("bu") && !this.contains("ba") && !this.contains("be")) {
        conditionsMatched++;
    }

    val vowels = "aeiou"
    val vowelsFound = this.sumBy { ch -> if (vowels.contains(ch)) 1 else 0 }

    if (vowelsFound >= 3) {
        conditionsMatched++;
    }

    val consecutiveChars = this.zipWithNext().count { it -> it.first == it.second }

    if (consecutiveChars >= 1) {
        conditionsMatched++;
    }

    return conditionsMatched >= 2
}

fun String.isNiceWork(): Boolean {

    val noBadSubstring = setOf("bu", "ba", "be").none { this.contains(it) }
    // Condition 1 : String should not contain "bu", "ba" and "be"
    val vowel = "aeiou"
    val hasThreeVowels = this.count { it in vowel } >= 3

    val hasConsecutiveChars = this.zipWithNext().any { it -> it.first == it.second }

    return listOf(noBadSubstring, hasConsecutiveChars, hasThreeVowels).count { it } >= 2
}