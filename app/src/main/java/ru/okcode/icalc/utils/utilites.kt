package ru.okcode.icalc.utils

const val ZERO = "0"
const val COMMA = ','
const val POINT = '.'

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

fun String.normalizeForNumberCreator(): String {
    var result = this.unformat()

    if (result.contains(COMMA)) {
        result = result.replace(COMMA, POINT)
    }

    if (!result[result.lastIndex].isDigit()) {
        return result.substring(0, result.lastIndex)
    } else {
        return result
    }
}