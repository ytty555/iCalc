package ru.okcode.icalc.core

import ru.okcode.icalc.command.Command
import ru.okcode.icalc.command.operator.Operator

interface CalcProcessor {

    fun handleOperator(operator: Operator)

    fun handleNumber(number: Double)
}