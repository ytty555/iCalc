package ru.okcode.icalc.core

import ru.okcode.icalc.command.Operand
import ru.okcode.icalc.utils.*
import javax.inject.Inject

class TextProcessorImpl @Inject constructor() : TextProcessor {

    /**
     * nextNumberAsText actual value
     */
    override var nextNumberAsText: String = ZERO

    /**
     * Convert Double to String
     */
    override fun convertToText(number: Double): String {
        var numberAsString = number.toString().replace(POINT, COMMA)
        if (numberAsString.endsWith(",0")) {
            val indexComma = numberAsString.indexOf(COMMA)
            numberAsString = numberAsString.substring(0, indexComma)
        }
        return numberAsString.formatForDisplay()
    }

    /**
     * Convert String to Double
     */
    override fun convertToNumber(numberAsText: String): Double {
        return numberAsText
            .normalizeForNumberCreator()
            .toDouble()
    }

    /**
     * Create nextNumberAsText
     */
    override fun createNextNumberAsText(operand: Operand) {

        val baseTextUnformatted = nextNumberAsText.unformat()
        if (countDigits(baseTextUnformatted) >= 9) {
            when (operand) {
                Operand.TRIGGER_PLUS_MINUS ->
                    nextNumberAsText = triggerPlusMinus(baseTextUnformatted).formatForDisplay()
                else -> nextNumberAsText = baseTextUnformatted.formatForDisplay()
            }
        }
        val result = StringBuilder()

        when (baseTextUnformatted) {
            "0" -> {
                when (operand) {
                    Operand.DIGIT_000 -> result.append(baseTextUnformatted)
                    Operand.TRIGGER_PLUS_MINUS -> result.append(triggerPlusMinus(baseTextUnformatted))
                    Operand.COMMA -> result.append("0,")
                    else -> result.append(operand.value)
                }
            }
            "-0" -> {
                when (operand) {
                    Operand.DIGIT_000 -> result.append(baseTextUnformatted)
                    Operand.TRIGGER_PLUS_MINUS -> result.append(triggerPlusMinus(baseTextUnformatted))
                    Operand.COMMA -> result.append("-0,")
                    else -> {
                        result.append("-")
                        result.append(operand.value)
                    }
                }
            }
            else -> {
                when (operand) {
                    Operand.DIGIT_000 -> {
                        result.append(baseTextUnformatted)
                        result.append(operand.value)
                    }
                    Operand.TRIGGER_PLUS_MINUS -> {
                        result.append(triggerPlusMinus(baseTextUnformatted))
                    }
                    Operand.COMMA -> {
                        result.append(baseTextUnformatted)
                        if (!baseTextUnformatted.contains(',')) {
                            result.append(",")
                        }
                    }
                    else -> {
                        result.append(baseTextUnformatted)
                        result.append(operand.value)
                    }
                }
            }
        }

        nextNumberAsText = result.toString().formatForDisplay()
    }

    private fun countDigits(baseText: String): Int {
        var counter = 0

        for (c: Char in baseText) {
            if (c.isDigit()) counter++
        }

        return counter
    }

    private fun triggerPlusMinus(input: String): String {
        return when (input[0]) {
            '-' -> input.substring(1)
            else -> "-$input"
        }
    }
}

