package com.mscottmcbee.flashkana

import com.mscottmcbee.flashkana.model.GenericModel
import com.mscottmcbee.flashkana.model.KanaObject
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testGenericModel(){
        var model = GenericModel("a title", "a description")
        model.addCards(listOf(KanaObject("Q", "A")))
        assertEquals(model.title, "a title")
        assertEquals(model.getSetName(), "a title")
        assertEquals(model.description, "a description")
        assertEquals(model.getSetDescription(), "a description")
        assertEquals(model.flashCards[0].answer, "A")
        assertEquals(model.flashCards[0].glyph, "Q")
        assertEquals(model.getRandomCard().answer, "A")
        assertEquals(model.getRandomCard().glyph, "Q")
        model.removeCards()
        assertEquals(model.flashCards.size, 0)
    }
}
