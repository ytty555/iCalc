package ru.okcode.icalc.core

import ru.okcode.icalc.command.operand.Operand

interface NumberCreator {

    fun handleDigit(operand: Operand)
}