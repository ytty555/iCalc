package ru.okcode.icalc

import androidx.lifecycle.ViewModel
import ru.okcode.icalc.command.Command
import ru.okcode.icalc.command.operand.Operand
import ru.okcode.icalc.core.CalcProcessor
import ru.okcode.icalc.core.CoreFactory
import ru.okcode.icalc.core.DaggerCoreFactory

class CalcViewModel(val calcProcessor: CalcProcessor) : ViewModel() {
    private val coreFactory: CoreFactory = DaggerCoreFactory.create()
    private val processor = coreFactory.processor()
    private val numberCreator = coreFactory.numberCreator()

    fun onClickDigit(operand: Operand) {
        numberCreator.handleDigit(operand)
    }

    fun onClickOperator(command: Command) {
        processor.handleCommand(command)
    }

}