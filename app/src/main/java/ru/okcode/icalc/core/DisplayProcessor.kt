package ru.okcode.icalc.core

interface DisplayProcessor {

    fun getResultForDisplay(result: Double): String

}