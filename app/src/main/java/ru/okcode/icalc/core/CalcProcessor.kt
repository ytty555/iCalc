package ru.okcode.icalc.core

import ru.okcode.icalc.command.Calculable
import ru.okcode.icalc.command.Operator

interface CalcProcessor {

    fun handleOperator(operator: Calculable)

    fun handleNumber(number: Double)

    fun handleEqually()

    fun getCalcResult(): Double
}