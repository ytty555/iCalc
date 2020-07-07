package ru.okcode.icalc.core

import ru.okcode.icalc.command.Operand

interface NumberCreator {

    fun handleOperand(operand: Operand)

    fun getNumberPresenter(): NumberPresenter
}