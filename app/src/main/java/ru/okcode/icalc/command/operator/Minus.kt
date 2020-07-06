package ru.okcode.icalc.command.operator

import javax.inject.Inject

class Minus @Inject constructor() : Operator {

    private val rang = 1

    override fun getRang(): Int {
        return rang
    }

    override fun calc(a: Double, b: Double): Double {
        return a.minus(b)
    }
}