package ru.okcode.icalc.core

import ru.okcode.icalc.command.Operand
import ru.okcode.icalc.command.Operator

interface CalcProcessor {
    fun handleOperand(operand: Operand)
    fun handleOperator(operator: Operator)
    fun handleClear()
    fun handleEqually()
}