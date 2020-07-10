package ru.okcode.icalc.core

import ru.okcode.icalc.command.Operand
import ru.okcode.icalc.utils.formatForDisplay
import ru.okcode.icalc.utils.unformat
import javax.inject.Inject

class TextProcessorImpl @Inject constructor() : TextProcessor {

    override fun generateText(baseText: String, operand: Operand): String {

        val baseTextUnformatted = baseText.unformat()
        if (countDigits(baseTextUnformatted) >= 9) {
            return when (operand) {
                Operand.TRIGGER_PLUS_MINUS -> triggerPlusMinus(baseTextUnformatted).formatForDisplay()
                else -> return baseTextUnformatted.formatForDisplay()
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

        return result.toString().formatForDisplay()
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

