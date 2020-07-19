package ru.okcode.icalc

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import ru.okcode.icalc.command.Operand
import ru.okcode.icalc.command.Operator
import ru.okcode.icalc.command.OperatorFactory
import ru.okcode.icalc.command.OperatorType
import ru.okcode.icalc.core.CalcProcessor
import ru.okcode.icalc.core.CoreFactory
import ru.okcode.icalc.core.DaggerCoreFactory

class CalcViewModel : ViewModel() {
    private val coreFactory: CoreFactory = DaggerCoreFactory.create()
    private val calcProcessor: CalcProcessor = coreFactory.processor()

    private val _display = MutableLiveData<String>()
    val display: LiveData<String>
        get() = _display

    private val _isClearAll = MutableLiveData<Boolean>()
    val isClearAll: LiveData<Boolean>
        get() = _isClearAll

    private val displayObserver = Observer<String> { displayValue ->
        setDisplayValue(displayValue)
    }

    init {
        _isClearAll.value = false
        calcProcessor.displayResult.observeForever(displayObserver)
    }


    fun onClickOperand(operand: Operand) {
        calcProcessor.handleOperand(operand)
        _isClearAll.value = false
    }

    fun onClickOperator(operatorType: OperatorType) {
        val operator: Operator = OperatorFactory.createOperator(operatorType)
        calcProcessor.handleOperator(operator)
        _isClearAll.value = false
    }

    fun onClickClear() {
        calcProcessor.handleClear(isClearAll.value!!)
        _isClearAll.value = true
    }

    fun onClickEqually() {
        calcProcessor.handleEqually()
        _isClearAll.value = false
    }

    private fun setDisplayValue(value: String) {
        _display.value = value
    }

    override fun onCleared() {
        super.onCleared()
        calcProcessor.displayResult.removeObserver(displayObserver)
    }
}