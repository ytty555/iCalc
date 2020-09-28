package ru.okcode.icalc.core

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import ru.okcode.icalc.command.Operand
import java.math.BigDecimal

@RunWith(Parameterized::class)
class TextProcessorImplTest(
    private val start: String,
    private val operand: Operand,
    private val expected: String
) {

   private val textProcessor: TextProcessor = TextProcessorImpl()

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: generateText \"{0}\" => \"{1}\" => \"{2}\"")
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

                arrayOf("1", Operand.COMMA, "1,"),

                arrayOf("12345678", Operand.DIGIT_9, "123 456 789")
            )
        }
    }

    @Test
    fun createNextNumberAsTextTest() {
        textProcessor.nextNumberAsText = start
        textProcessor.createNextNumberAsText(operand)
        val textActual = textProcessor.nextNumberAsText
        val textExpected: String = expected
        assertEquals(textExpected, textActual)
    }

    @Test
    fun convertToTextTest01() {
        val number: BigDecimal = BigDecimal.valueOf(2.0000000)

        val actual = textProcessor.convertToText(number)
        val expected = "2"

        assertEquals(expected, actual)
    }

    @Test
    fun convertToTextTest02() {
        val number: BigDecimal = BigDecimal.valueOf(2.2500000)

        val actual = textProcessor.convertToText(number)
        val expected = "2,25"

        assertEquals(expected, actual)
    }

    @Test
    fun convertToTextTest03() {
        val number: BigDecimal = BigDecimal.valueOf(2.2500001)

        val actual = textProcessor.convertToText(number)
        val expected = "2,2500001"

        assertEquals(expected, actual)
    }

    @Test
    fun convertToTextTest04() {
        val number: BigDecimal = BigDecimal.valueOf(0.2500001)

        val actual = textProcessor.convertToText(number)
        val expected = "0,2500001"

        assertEquals(expected, actual)
    }

    @Test
    fun convertToTextTest05() {
        val number: BigDecimal = BigDecimal.valueOf(0.0)

        val actual = textProcessor.convertToText(number)
        val expected = "0"

        assertEquals(expected, actual)
    }
}