package ru.okcode.icalc.command.operator

import javax.inject.Inject

class Percent @Inject constructor() : Operator {

    private val rang = 0

    override fun getRang(): Int {
        return rang
    }

    override fun calc(a: Double, b: Double): Double {
        // TODO TEST
        return a.div(100)
    }
}