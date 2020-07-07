package ru.okcode.icalc

import android.util.Log
import androidx.lifecycle.ViewModel
import ru.okcode.icalc.command.CommandFactory
import ru.okcode.icalc.command.operand.Operand
import ru.okcode.icalc.command.operator.Operator
import ru.okcode.icalc.core.CoreFactory
import ru.okcode.icalc.core.DaggerCoreFactory

class CalcViewModel() : ViewModel() {

    private val coreFactory: CoreFactory = DaggerCoreFactory.create()
    private val calcProcessor = coreFactory.getCalcProcessor()


    fun onClickDigit(value: String) {
        val operand: Operand? = CommandFactory.createOperand(value);
        operand?.let { currentOperand ->
            TODO("Not implemented yet")
        }
    }

    fun onClickOperator(value: String) {
        Log.e("qq", "Click operator: $value")
        val operator: Operator? = CommandFactory.createOperator(value)
        operator?.let { currentOperator ->
            TODO("Not implemented yet")
        }
    }
}