package ru.okcode.icalc.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.okcode.icalc.command.Operand
import javax.inject.Inject

class NumberCreatorImpl @Inject constructor() : NumberCreator {

    private val _numberPresenter = MutableLiveData<NumberPresenter>()

    override val numberPresenter: LiveData<NumberPresenter>
        get() = _numberPresenter

    init {
        _numberPresenter.value = NumberPresenter.Companion.create(0.0)
    }

    override fun handleOperand(operand: Operand) {
        TODO("Not yet implemented")
    }

}