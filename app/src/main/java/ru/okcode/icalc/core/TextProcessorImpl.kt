package ru.okcode.icalc.core

import ru.okcode.icalc.command.Operand
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

fun String.formatForDisplay(): String {
    val input: String = this.unformat()
    val partToComma: String
    val partAfterComma: String

    if (input.contains(',')) {
        val indexOfComma = input.indexOf(',')
        partToComma = input.substring(0, indexOfComma)
        partAfterComma = input.substring(indexOfComma)
    } else {
        partToComma = input
        partAfterComma = ""
    }

    val resultReversed = java.lang.StringBuilder()
    val partToCommaReversed = partToComma.reversed()

    for (i in partToCommaReversed.indices) {
        val counter = i + 1
        resultReversed.append(partToCommaReversed[i])
        if (counter < partToCommaReversed.length && counter % 3 == 0) {
            resultReversed.append(" ")
        }
    }

    return resultReversed.toString().reversed() + partAfterComma
}

fun String.unformat(): String {
    val input = this
    val result = java.lang.StringBuilder()

    for (ch in input) {
        if (ch != ' ') {
            result.append(ch)
        }
    }

    return result.toString()
}