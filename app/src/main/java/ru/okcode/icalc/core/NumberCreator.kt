package ru.okcode.icalc.core

import androidx.lifecycle.LiveData
import ru.okcode.icalc.command.Operand

interface NumberCreator {

    val numberPresenter: LiveData<NumberPresenter>

    fun handleOperand(operand: Operand)

    fun setNumberPresenter(numberPresenter: NumberPresenter)
}