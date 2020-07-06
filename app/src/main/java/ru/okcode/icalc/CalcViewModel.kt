package ru.okcode.icalc

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.okcode.icalc.command.CommandFactory
import ru.okcode.icalc.command.operand.Operand
import ru.okcode.icalc.command.operator.Operator
import ru.okcode.icalc.core.CoreFactory
import ru.okcode.icalc.core.DaggerCoreFactory

class CalcViewModel() : ViewModel() {

    private val coreFactory: CoreFactory = DaggerCoreFactory.create()
    private val calcProcessor = coreFactory.getCalcProcessor()
    private val displayProcessor = coreFactory.getDisplayProcessor()

    // Промежуточные результаты вычисления
    private var calcResult: Double = 0.0

    // Результат вычисления для вывода на дисплей
    private val _displayResult = MutableLiveData<String>()
    public val displayResult: LiveData<String>
        get() = _displayResult

    fun onClickDigit(value: String) {
        val operand: Operand? = CommandFactory.createOperand(value);
        operand?.let {
            calcResult = it.getResultNumber(calcResult)
            _displayResult.value = displayProcessor.getResultForDisplay(calcResult)
        }
    }

    fun onClickOperator(value: String) {
        Log.e("qq", "Click operator: $value")
        val operator: Operator? = CommandFactory.createOperator(value)
        operator?.let {
            calcProcessor.handleNumber(calcResult)
            calcProcessor.handleOperator(it)
        }
    }

}