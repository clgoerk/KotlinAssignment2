// Kotlin Assignment 2
// Christopher Goerk

fun main() {
    val original = "Hello, my name is Christopher Goerk"
    val key = 3
    val encrypted = caesarCipher(original, key)
    val word1 = "dusty"
    val word2 = "study"
    val anagrams = areAnagrams(word1, word2)
    val str1 = "hello world"
    val str2 = "world"
    val subString = isSubstring(str1, str2)
    val inputString = "Kotlin is a concise and powerful language"
    val longestWord = findLongestWord(inputString)

    println("A. Encrypted: $encrypted")
    println("B. Are \"$word1\" and \"$word2\" anagrams? $anagrams")
    println("C. Is \"$str2\" a substring of \"$str1\"? $subString")
    println("D. The longest word is: \"$longestWord\"")
} // Main

// A. Create a function that encrypts a supplied string by shifting the position
// of each letter by a supplied integer (the “key”).
// For example, if the key is 1, then a becomes b, c becomes d, and z becomes a, and so on.
fun caesarCipher(input: String, key: Int): String {
    val shift = key % 26 // Keep the shift within the alphabet range
    val result = StringBuilder() // StringBuilder for efficient string concatenation

    for (char in input) {
        result.append(
            when {
                char.isLowerCase() -> 'a' + (char - 'a' + shift).mod(26) // Shift lowercase letters
                char.isUpperCase() -> 'A' + (char - 'A' + shift).mod(26) // Shift uppercase letters
                else -> char // Keep non-alphabetic characters unchanged
            }
        )
    }
    return result.toString() // Return the final string
} // caesarCipher()

// B. Create a function that compares two single words and determines whether
// they are anagrams of each other (e.g., dusty and study are anagrams because you can
// rearrange the letters of dusty to create study, and vice versa).
fun areAnagrams(word1: String, word2: String): Boolean {
    return word1.lowercase().toCharArray().sorted() == // Convert to lowercase, then to a char array, and sort
            word2.lowercase().toCharArray().sorted()   // Do the same for the second word and compare the sorted lists
} // areAnagrams()


// C. Without using the String.contains method, write a function that compares two strings
// and determines whether the characters in the second string are a substring
// of the characters in the first string.
fun isSubstring(str1: String, str2: String): Boolean {
    return str1.indexOf(str2) != -1  // Checks if str2 is found in str1, returns true if found, false otherwise
} // isSubstring()


// D. Create a function that analyzes a string and returns the longest word in that string.
fun findLongestWord(input: String): String {
    return input.split("\\s+".toRegex())  // Splits by spaces
        .filter { it.isNotEmpty() }       // Removes empty values
        .maxByOrNull { it.length } ?: ""  // Finds the longest word
} // findLongestWord()
