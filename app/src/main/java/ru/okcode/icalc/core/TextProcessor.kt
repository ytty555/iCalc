package ru.okcode.icalc.core

import ru.okcode.icalc.command.Operand

interface TextProcessor {

    fun createText(operand: Operand)

    var nextNumberAsText: String

    fun convertToText(number: Double): String

    fun convertToNumber(numberAsText: String): Double

}