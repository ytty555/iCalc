package ru.okcode.icalc.core

import ru.okcode.icalc.command.Command

interface CalcProcessor {

    fun handleCommand(command: Command)

    fun handleOperand(number: Float)
}