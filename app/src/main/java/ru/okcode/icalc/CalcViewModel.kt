package ru.okcode.icalc

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.okcode.icalc.command.Operand
import ru.okcode.icalc.core.*
import ru.okcode.icalc.utils.ZERO

class CalcViewModel() : ViewModel() {

    private val coreFactory: CoreFactory = DaggerCoreFactory.create()
    private val calcProcessor = coreFactory.getCalcProcessor()
    private val textProcessor: TextProcessor = coreFactory.getTextProcessor()

    private val _display = MutableLiveData<String>()
    val display: LiveData<String>
        get() = _display

    init {
        _display.value = ZERO
    }

    fun onClickOperand(operand: Operand) {
        val oldDisplayText = display.value?: ZERO
        _display.value = textProcessor.generateText(oldDisplayText, operand)
    }

    fun onClickOperator(value: String) {
        TODO("Not implemented yet")
    }

    fun onClickClear() {
        setDisplayValue(ZERO)
    }

    private fun setDisplayValue(value: String) {
        _display.value = value
    }
}