package ru.okcode.icalc.core

import ru.okcode.icalc.utils.normalizeForNumberCreator
import javax.inject.Inject

class NumberProcessorImpl @Inject constructor() : NumberProcessor {

    override fun generateNumber(text: String): Double {
        val unformattedText = text.normalizeForNumberCreator()
        return unformattedText.toDouble()
    }
}