package de.syntax_institut.jetpack.a04jpcprojektwoche.data

import de.syntax_institut.jetpack.a04jpcprojektwoche.R
import de.syntax_institut.jetpack.a04jpcprojektwoche.data.model.Item
import de.syntax_institut.jetpack.a04jpcprojektwoche.utils.loremIpsum
import de.syntax_institut.jetpack.a04jpcprojektwoche.utils.loremIpsumTitle
import de.syntax_institut.jetpack.a04jpcprojektwoche.utils.randomRating
import kotlin.random.Random

class Repository {
    companion object {
        val items = generateItems()
        private fun generateItems(): List<Item> {
            val images = listOf(
                R.drawable.image_96x96,
                R.drawable.image_165x86,
                R.drawable.image_200x176,
                R.drawable.image_250x176,
                R.drawable.image_412x176,
                R.drawable.image_460x356,
                R.drawable.bird,
                R.drawable.blury,
                R.drawable.bridge,
                R.drawable.building,
                R.drawable.frozen,
                R.drawable.ice,
                R.drawable.lake_tekapo,
                R.drawable.nature,
                R.drawable.building,
                R.drawable.white,
                R.drawable.winter_sceen,
                R.drawable.tree
            )
            val items = mutableListOf<Item>()
            repeat(200) {
                items.add(
                    Item(
                        id = Random.nextLong(),
                        imageRes = images.random(),
                        headline = loremIpsumTitle(),
                        subhead = loremIpsumTitle(),
                        supportingText = loremIpsum(),
                        description = loremIpsum(until = Random.nextInt(80, 1000)),
                        rating = randomRating()
                    )
                )
            }
            return items
        }
    }
}