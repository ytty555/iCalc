package ru.okcode.icalc.core

import javax.inject.Inject

class DisplayProcessorImpl @Inject constructor(): DisplayProcessor {

    override fun getResultForDisplay(result: Double): String {
        // TODO Fix
        return result.toString()
    }

}