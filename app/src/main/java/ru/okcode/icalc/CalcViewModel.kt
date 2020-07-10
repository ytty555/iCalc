package ru.okcode.icalc

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.okcode.icalc.command.Operand
import ru.okcode.icalc.core.CoreFactory
import ru.okcode.icalc.core.DaggerCoreFactory
import ru.okcode.icalc.core.Display

class CalcViewModel() : ViewModel() {

    private val coreFactory: CoreFactory = DaggerCoreFactory.create()
    private val calcProcessor = coreFactory.getCalcProcessor()
    private val display: Display = coreFactory.getDisplay()

    val displayValue: LiveData<String>
        get() = display.displayValue

    fun onClickOperand(operand: Operand) {
        display.handleOperand(operand)
    }

    fun onClickOperator(value: String) {
        TODO("Not implemented yet")
    }

    fun onClickClear() {
        display.setDisplayValue("0")
    }
}