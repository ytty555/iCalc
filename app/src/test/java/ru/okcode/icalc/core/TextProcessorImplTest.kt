package ru.okcode.icalc.core

import org.junit.Assert.assertEquals
import org.junit.Assume
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import ru.okcode.icalc.command.Operand
import java.math.BigDecimal

@RunWith(Parameterized::class)
class TextProcessorImplTest(
    private val target: Target,
    private val start: Any,
    private val operand: Operand,
    private val expected: Any
) {

    private val textProcessor: TextProcessor = TextProcessorImpl()

    enum class Target {
        CONVERT_TO_NUMBER,
        CONVERT_TO_TEXT,
        CREATE_NEXT
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: generateText \"{0}\" => \"{1}\" => \"{2}\" => \"{3}\"")
        fun data(): Collection<Array<Any>> {
            return listOf(
                // Create next number as text ----------------------------------------------------------
                arrayOf(Target.CREATE_NEXT, "0", Operand.DIGIT_1, "1"),
                arrayOf(Target.CREATE_NEXT, "0", Operand.DIGIT_2, "2"),
                arrayOf(Target.CREATE_NEXT, "0", Operand.DIGIT_3, "3"),
                arrayOf(Target.CREATE_NEXT, "0", Operand.DIGIT_4, "4"),
                arrayOf(Target.CREATE_NEXT, "0", Operand.DIGIT_5, "5"),
                arrayOf(Target.CREATE_NEXT, "0", Operand.DIGIT_6, "6"),
                arrayOf(Target.CREATE_NEXT, "0", Operand.DIGIT_7, "7"),
                arrayOf(Target.CREATE_NEXT, "0", Operand.DIGIT_8, "8"),
                arrayOf(Target.CREATE_NEXT, "0", Operand.DIGIT_9, "9"),
                arrayOf(Target.CREATE_NEXT, "0", Operand.DIGIT_0, "0"),
                arrayOf(Target.CREATE_NEXT, "0", Operand.DIGIT_000, "0"),
                arrayOf(Target.CREATE_NEXT, "0", Operand.COMMA, "0,"),
                arrayOf(Target.CREATE_NEXT, "0", Operand.TRIGGER_PLUS_MINUS, "-0"),
                arrayOf(Target.CREATE_NEXT, "-0", Operand.TRIGGER_PLUS_MINUS, "0"),

                arrayOf(Target.CREATE_NEXT, "-0", Operand.DIGIT_1, "-1"),
                arrayOf(Target.CREATE_NEXT, "-0", Operand.DIGIT_2, "-2"),
                arrayOf(Target.CREATE_NEXT, "-0", Operand.DIGIT_3, "-3"),
                arrayOf(Target.CREATE_NEXT, "-0", Operand.DIGIT_4, "-4"),
                arrayOf(Target.CREATE_NEXT, "-0", Operand.DIGIT_5, "-5"),
                arrayOf(Target.CREATE_NEXT, "-0", Operand.DIGIT_6, "-6"),
                arrayOf(Target.CREATE_NEXT, "-0", Operand.DIGIT_7, "-7"),
                arrayOf(Target.CREATE_NEXT, "-0", Operand.DIGIT_8, "-8"),
                arrayOf(Target.CREATE_NEXT, "-0", Operand.DIGIT_9, "-9"),
                arrayOf(Target.CREATE_NEXT, "-0", Operand.DIGIT_0, "-0"),
                arrayOf(Target.CREATE_NEXT, "-0", Operand.DIGIT_000, "-0"),
                arrayOf(Target.CREATE_NEXT, "-0", Operand.COMMA, "-0,"),

                arrayOf(Target.CREATE_NEXT, "0,", Operand.DIGIT_1, "0,1"),
                arrayOf(Target.CREATE_NEXT, "0,", Operand.DIGIT_2, "0,2"),
                arrayOf(Target.CREATE_NEXT, "0,", Operand.DIGIT_3, "0,3"),
                arrayOf(Target.CREATE_NEXT, "0,", Operand.DIGIT_4, "0,4"),
                arrayOf(Target.CREATE_NEXT, "0,", Operand.DIGIT_5, "0,5"),
                arrayOf(Target.CREATE_NEXT, "0,", Operand.DIGIT_6, "0,6"),
                arrayOf(Target.CREATE_NEXT, "0,", Operand.DIGIT_7, "0,7"),
                arrayOf(Target.CREATE_NEXT, "0,", Operand.DIGIT_8, "0,8"),
                arrayOf(Target.CREATE_NEXT, "0,", Operand.DIGIT_9, "0,9"),
                arrayOf(Target.CREATE_NEXT, "0,", Operand.DIGIT_0, "0,0"),
                arrayOf(Target.CREATE_NEXT, "0,", Operand.DIGIT_000, "0,000"),
                arrayOf(Target.CREATE_NEXT, "0,", Operand.COMMA, "0,"),
                arrayOf(Target.CREATE_NEXT, "0,", Operand.TRIGGER_PLUS_MINUS, "-0,"),
                arrayOf(Target.CREATE_NEXT, "-0,", Operand.TRIGGER_PLUS_MINUS, "0,"),

                arrayOf(Target.CREATE_NEXT, "1", Operand.COMMA, "1,"),

                arrayOf(Target.CREATE_NEXT, "12345678", Operand.DIGIT_9, "123 456 789"),

                // Convert to text ----------------------------------------------------------
                arrayOf(Target.CONVERT_TO_TEXT, 2.000000, Operand.COMMA, "2"),
                arrayOf(Target.CONVERT_TO_TEXT, 2.250000, Operand.COMMA, "2,25"),
                arrayOf(Target.CONVERT_TO_TEXT, 2.2500001, Operand.COMMA, "2,2500001"),
                arrayOf(Target.CONVERT_TO_TEXT, 0.2500001, Operand.COMMA, "0,2500001"),
                arrayOf(Target.CONVERT_TO_TEXT, 0.0, Operand.COMMA, "0"),
                arrayOf(Target.CONVERT_TO_TEXT, 0.0000, Operand.COMMA, "0"),

                // Convert to number --------------------------------------------------------
                arrayOf(Target.CONVERT_TO_NUMBER, "2.000000", Operand.COMMA, 2.0),
                arrayOf(Target.CONVERT_TO_NUMBER, "2,000001", Operand.COMMA, 2.000001),
                arrayOf(Target.CONVERT_TO_NUMBER, "2,25000", Operand.COMMA, 2.25),
                arrayOf(Target.CONVERT_TO_NUMBER, "0,0", Operand.COMMA, 0.0),
                arrayOf(Target.CONVERT_TO_NUMBER, "0,000", Operand.COMMA, 0.0),
                arrayOf(Target.CONVERT_TO_NUMBER, "100 000,000", Operand.COMMA, 100000.0),

                arrayOf(Target.CONVERT_TO_NUMBER, "-2.000000", Operand.COMMA, -2.0),
                arrayOf(Target.CONVERT_TO_NUMBER, "-2,000001", Operand.COMMA, -2.000001),
                arrayOf(Target.CONVERT_TO_NUMBER, "-2,25000", Operand.COMMA, -2.25),
                arrayOf(Target.CONVERT_TO_NUMBER, "-0,0", Operand.COMMA, 0.0),
                arrayOf(Target.CONVERT_TO_NUMBER, "-0,000", Operand.COMMA, 0.0),
                arrayOf(Target.CONVERT_TO_NUMBER, "-100 000,000", Operand.COMMA, -100000.0),

                )
        }
    }

    @Test
    fun createNextNumberAsTextTest() {
        Assume.assumeTrue(target == Target.CREATE_NEXT)
        textProcessor.nextNumberAsText = start as String
        textProcessor.createNextNumberAsText(operand)
        val textActual = textProcessor.nextNumberAsText
        val textExpected: String = expected as String
        assertEquals(textExpected, textActual)
    }

    @Test
    fun convertToTextTest() {
        Assume.assumeTrue(target == Target.CONVERT_TO_TEXT)

        val number: BigDecimal = BigDecimal.valueOf(start as Double)

        val actual = textProcessor.convertToText(number)
        val textExpected: String = expected as String

        assertEquals(textExpected, actual)
    }

    @Test
    fun convertToNumberTest() {
        Assume.assumeTrue(target == Target.CONVERT_TO_NUMBER)

        val numberAsText: String = start as String

        val actual = textProcessor.convertToNumber(numberAsText)
        val expected: BigDecimal = BigDecimal.valueOf(expected as Double)

        assertEquals(expected, actual)
    }
}

