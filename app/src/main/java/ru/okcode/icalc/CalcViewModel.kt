package ru.okcode.icalc

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.okcode.icalc.command.Operand
import ru.okcode.icalc.command.Operator
import ru.okcode.icalc.command.OperatorFactory
import ru.okcode.icalc.command.OperatorType
import ru.okcode.icalc.core.CalcProcessor
import ru.okcode.icalc.core.CoreFactory
import ru.okcode.icalc.core.DaggerCoreFactory
import ru.okcode.icalc.utils.ZERO

class CalcViewModel : ViewModel() {

    private val coreFactory: CoreFactory = DaggerCoreFactory.create()
    private val calcProcessor: CalcProcessor = coreFactory.processor()

    private val _display = MutableLiveData<String>()
    val display: LiveData<String>
        get() = _display

    init {
        setDisplayValue(ZERO)
    }

    fun onClickOperand(operand: Operand) {
        calcProcessor.handleOperand(operand)
    }


    fun onClickOperator(operatorType: OperatorType) {
        val operator: Operator = OperatorFactory.createOperator(operatorType)
        calcProcessor.handleOperator(operator)
    }

    fun onClickClear() {
        calcProcessor.handleClear()
    }

    fun onClickEqually() {
        calcProcessor.handleEqually()
    }

    private fun setDisplayValue(value: String) {
        _display.value = value
    }

}