package ru.okcode.icalc.core

import ru.okcode.icalc.command.Operand
import javax.inject.Inject

class NumberCreatorImpl @Inject constructor() : NumberCreator {

    override fun handleOperand(operand: Operand) {
        TODO("Not yet implemented")
    }

    override fun getNumberPresenter(): NumberPresenter {
        TODO("Not yet implemented")
    }
}