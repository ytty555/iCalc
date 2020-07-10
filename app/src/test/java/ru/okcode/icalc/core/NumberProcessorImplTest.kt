package ru.okcode.icalc.core

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class NumberProcessorImplTest(
    private val input: String,
    private val expected: Double
) {

    private val numberProcessor: NumberProcessor = NumberProcessorImpl()

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf("-0", 0.0),
                arrayOf("-0,", 0.0),
                arrayOf("0,", 0.0),
                arrayOf("0", 0.0),
                arrayOf("1", 1.0),
                arrayOf("-1", -1.0),
                arrayOf("1,0", 1.0),
                arrayOf("-1,0", -1.0),
                arrayOf("-1,1", -1.1),
                arrayOf("1,1", 1.1),
                arrayOf("123 456 789", 123456789.0),
                arrayOf("-123 456 789", -123456789.0),
                arrayOf("- 123 456 789", -123456789.0),
                arrayOf("9,12345678", 9.12345678)



            )
        }
    }

    @Test
    fun generateNumber() {
        val actual = numberProcessor.generateNumber(input)
        assertEquals(expected, actual, 0.0)
    }
}