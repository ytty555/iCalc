package ru.okcode.icalc.core

import androidx.lifecycle.LiveData
import ru.okcode.icalc.command.Operand
import ru.okcode.icalc.command.Operator

interface CalcProcessor {
    val displayResult: LiveData<String>

    fun handleOperand(operand: Operand)
    fun handleOperator(operator: Operator)
    fun handleClear(clearAll: Boolean)
    fun handleEqually()

}