package ru.okcode.icalc.core

import ru.okcode.icalc.command.Operator

interface CalcProcessor {

    fun handleOperator(operator: Operator)

    fun handleNumber(number: Double)
}