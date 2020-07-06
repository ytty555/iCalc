package ru.okcode.icalc.command.operator

import javax.inject.Inject

class Division @Inject constructor() : Operator {

    private val rang = 2

    override fun getRang(): Int {
        return rang
    }

    override fun calc(a: Double, b: Double): Double {
        return a.div(b)
    }
}