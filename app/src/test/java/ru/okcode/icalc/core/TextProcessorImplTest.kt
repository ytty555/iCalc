package ru.okcode.icalc.core

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import ru.okcode.icalc.command.Operand

@RunWith(Parameterized::class)
class TextProcessorImplTest(
    private val start: String,
    private val operand: Operand,
    private val expected: String
) {

    private val textProcessor: TextProcessor = TextProcessorImpl()

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf("0", Operand.DIGIT_1, "1"),
                arrayOf("0", Operand.DIGIT_2, "2"),
                arrayOf("0", Operand.DIGIT_3, "3"),
                arrayOf("0", Operand.DIGIT_4, "4"),
                arrayOf("0", Operand.DIGIT_5, "5"),
                arrayOf("0", Operand.DIGIT_6, "6"),
                arrayOf("0", Operand.DIGIT_7, "7"),
                arrayOf("0", Operand.DIGIT_8, "8"),
                arrayOf("0", Operand.DIGIT_9, "9"),
                arrayOf("0", Operand.DIGIT_0, "0"),
                arrayOf("0", Operand.DIGIT_000, "0"),
                arrayOf("0", Operand.COMMA, "0,"),
                arrayOf("0", Operand.TRIGGER_PLUS_MINUS, "-0"),
                arrayOf("-0", Operand.TRIGGER_PLUS_MINUS, "0"),

                arrayOf("-0", Operand.DIGIT_1, "-1"),
                arrayOf("-0", Operand.DIGIT_2, "-2"),
                arrayOf("-0", Operand.DIGIT_3, "-3"),
                arrayOf("-0", Operand.DIGIT_4, "-4"),
                arrayOf("-0", Operand.DIGIT_5, "-5"),
                arrayOf("-0", Operand.DIGIT_6, "-6"),
                arrayOf("-0", Operand.DIGIT_7, "-7"),
                arrayOf("-0", Operand.DIGIT_8, "-8"),
                arrayOf("-0", Operand.DIGIT_9, "-9"),
                arrayOf("-0", Operand.DIGIT_0, "-0"),
                arrayOf("-0", Operand.DIGIT_000, "-0"),
                arrayOf("-0", Operand.COMMA, "-0,"),

                arrayOf("0,", Operand.DIGIT_1, "0,1"),
                arrayOf("0,", Operand.DIGIT_2, "0,2"),
                arrayOf("0,", Operand.DIGIT_3, "0,3"),
                arrayOf("0,", Operand.DIGIT_4, "0,4"),
                arrayOf("0,", Operand.DIGIT_5, "0,5"),
                arrayOf("0,", Operand.DIGIT_6, "0,6"),
                arrayOf("0,", Operand.DIGIT_7, "0,7"),
                arrayOf("0,", Operand.DIGIT_8, "0,8"),
                arrayOf("0,", Operand.DIGIT_9, "0,9"),
                arrayOf("0,", Operand.DIGIT_0, "0,0"),
                arrayOf("0,", Operand.DIGIT_000, "0,000"),
                arrayOf("0,", Operand.COMMA, "0,"),
                arrayOf("0,", Operand.TRIGGER_PLUS_MINUS, "-0,"),
                arrayOf("-0,", Operand.TRIGGER_PLUS_MINUS, "0,"),

                arrayOf("1", Operand.COMMA, "1,")
                )
        }
    }

    @Test
    fun generateText() {
        val textActual = textProcessor.generateText(start, operand)
        val textExpected: String = expected
        assertEquals(textExpected, textActual)
    }
}