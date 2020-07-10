package ru.okcode.icalc.core

import androidx.lifecycle.LiveData
import ru.okcode.icalc.command.Operand

interface Display {

    val displayValue: LiveData<String>

    fun handleOperand(operand: Operand)

    fun setDisplayValue(value: String)

}