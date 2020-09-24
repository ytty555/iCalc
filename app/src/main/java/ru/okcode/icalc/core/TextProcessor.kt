package ru.okcode.icalc.core

import ru.okcode.icalc.command.Operand
import java.math.BigDecimal

interface TextProcessor {

    fun createNextNumberAsText(operand: Operand)

    var nextNumberAsText: String

    fun convertToText(number: BigDecimal): String

    fun convertToNumber(numberAsText: String): BigDecimal

}