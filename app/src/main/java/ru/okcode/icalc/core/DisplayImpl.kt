package ru.okcode.icalc.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.okcode.icalc.command.Operand
import javax.inject.Inject

class DisplayImpl @Inject constructor(): Display {

    private val textProcessor: TextProcessor = TextProcessorImpl()

    private val _displayValue = MutableLiveData<String>()
    override val displayValue: LiveData<String>
        get() = _displayValue

    init {
        _displayValue.value = ZERO
    }

    companion object {
        private const val ZERO = "0"
    }

    override fun setDisplayValue(value: String) {
        _displayValue.value = value
    }

    override fun handleOperand(operand: Operand) {
        val oldDisplayText = displayValue.value?: ZERO
        _displayValue.value = textProcessor.generateText(oldDisplayText, operand)
    }

}
