package ru.okcode.icalc.core

import ru.okcode.icalc.command.Operand

interface TextProcessor {
    fun generateText(baseText: String, operand: Operand): String

    fun generateText(number: Double): String
}