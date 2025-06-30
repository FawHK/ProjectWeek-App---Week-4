package de.syntax_institut.jetpack.a04jpcprojektwoche.utils

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import java.util.Locale
import kotlin.math.roundToInt
import kotlin.random.Random

fun loremIpsum(from: Int = 10, until: Int = 20): String {
    val wordCount = Random.nextInt(from, until)
    val words = LoremIpsum(wordCount).values.first()
    val shuffledWords = words.split(" ").shuffled()
    return shuffledWords.joinToString(" ")
}

fun loremIpsumTitle(): String {
    val wordCount = Random.nextInt(5, 13)
    val words = LoremIpsum(wordCount).values.first()
    val shuffledWords = words.split(" ").shuffled()
    return shuffledWords.first().capitalize() + " " + shuffledWords.last().capitalize()
}

fun String.capitalize(locale: Locale = Locale.getDefault()): String {
    return this.replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(locale) else it.toString()
    }
}

fun randomRating(): String {
    val randomFloat = (Random.nextFloat() * 4.0f) + 1
    val roundedFloat = (randomFloat * 10).roundToInt() / 10.0f
    return String.format(Locale.getDefault(),"%.1f ✭", roundedFloat)
}