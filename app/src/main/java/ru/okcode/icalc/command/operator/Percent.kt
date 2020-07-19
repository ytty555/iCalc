package ru.okcode.icalc.command.operator

import ru.okcode.icalc.command.Operator
import javax.inject.Inject

class Percent @Inject constructor() : Operator {

    private val rang = 0

    override fun rang(): Int {
        return rang
    }

    override fun calc(vararg args: Double): Double {
        val a = args[0]
        return a.div(100)
    }
}