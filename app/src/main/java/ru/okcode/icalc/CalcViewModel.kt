package ru.okcode.icalc

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.Disposable
import ru.okcode.icalc.command.Operand
import ru.okcode.icalc.command.OperatorFactory
import ru.okcode.icalc.command.OperatorType
import ru.okcode.icalc.core.*
import ru.okcode.icalc.utils.ZERO

class CalcViewModel() : ViewModel() {

    private val coreFactory: CoreFactory = DaggerCoreFactory.create()
    private val calcProcessor: CalcProcessor = coreFactory.getCalcProcessor()
    private val textProcessor: TextProcessor = coreFactory.getTextProcessor()
    private val numberProcessor: NumberProcessor = coreFactory.getNumberProcessor()

    private val _display = MutableLiveData<String>()
    val display: LiveData<String>
        get() = _display

    init {
        _display.value = ZERO
    }

    fun onClickOperand(operand: Operand) {
//        val oldDisplayText = display.value?: ZERO
//        _display.value = textProcessor.generateText(oldDisplayText, operand)
        TODO("Not implemented yet")
    }

    fun onClickOperator(operatorType: OperatorType) {
//        val operator = OperatorFactory.createOperator(operatorType)
//        val nextNumber = numberProcessor.generateNumber(display.value?: ZERO)
//        calcProcessor.handleNumber(nextNumber)
//        calcProcessor.handleOperator(operator)
        TODO("Not implemented yet")

    }

    fun onClickClear() {
//        setDisplayValue(ZERO)
        TODO("Not implemented yet")
    }

    fun onClickEqually() {
        calcProcessor.handleEqually()
    }

    private fun setDisplayValue(value: String) {
        _display.value = value
    }
}