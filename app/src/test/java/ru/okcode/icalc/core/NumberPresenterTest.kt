package ru.okcode.icalc.core

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class NumberPresenterTest(private val paramOne: Double, private val paramTwo: String) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf(0.0, "0"),
                arrayOf(-0.0, "0"),
                arrayOf(0.1, "0,1"),
                arrayOf(-0.1, "-0,1"),
                arrayOf(15.0, "15"),
                arrayOf(-15.0, "-15"),
                arrayOf(15.001, "15,001"),
                arrayOf(-15.001, "-15,001")
            )
        }
    }

    @Test
    fun getValueAsDoubleWithInputDoubleTest() {
        val np = NumberPresenter.create(paramOne)
        val expected = paramOne
        val actual = np.valueAsDouble
        assertEquals(expected, actual, 0.0)
    }

    @Test
    fun getValueAsStringWithInputDoubleTest() {
        val np = NumberPresenter.create(paramOne)
        val expected: String = paramTwo
        val actual: String = np.valueAsString
        assertEquals(expected, actual)
    }

    @Test
    fun getValueAsDoubleWithInputStringTest() {
        val np = NumberPresenter.create(paramTwo)
        val expected = paramOne
        val actual = np.valueAsDouble
        assertEquals(expected, actual, 0.0)
    }

    @Test
    fun getValueAsStringWithInputStringTest() {
        val np = NumberPresenter.create(paramTwo)
        val expected = paramTwo
        val actual = np.valueAsString
        assertEquals(expected, actual)
    }
}