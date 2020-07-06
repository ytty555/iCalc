package ru.okcode.icalc.core

import ru.okcode.icalc.command.Command
import javax.inject.Inject

class CalcProcessorImpl @Inject constructor(): CalcProcessor {

    override fun handleCommand(command: Command) {
        TODO("Not yet implemented")
    }

    override fun handleOperand(number: Float) {
        TODO("Not yet implemented")
    }
}