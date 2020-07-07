package ru.okcode.icalc

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.okcode.icalc.command.CommandFactory
import ru.okcode.icalc.command.Operand
import ru.okcode.icalc.command.operator.Operator
import ru.okcode.icalc.core.CoreFactory
import ru.okcode.icalc.core.DaggerCoreFactory
import ru.okcode.icalc.core.NumberPresenter

class CalcViewModel() : ViewModel() {

    private val coreFactory: CoreFactory = DaggerCoreFactory.create()
    private val calcProcessor = coreFactory.getCalcProcessor()
    private val numberCreator = coreFactory.getNumberCreator()

    private val _numberPresenter = MutableLiveData<NumberPresenter>()
    val numberPresenter: LiveData<NumberPresenter>
        get() = _numberPresenter


    fun onClickDigit(operand: Operand) {
        numberCreator.handleOperand(operand)
        _numberPresenter.value = numberCreator.getNumberPresenter()
    }

    fun onClickOperator(value: String) {
        Log.e("qq", "Click operator: $value")
        val operator: Operator? = CommandFactory.createOperator(value)
        operator?.let { currentOperator ->
            TODO("Not implemented yet")
        }
    }
}