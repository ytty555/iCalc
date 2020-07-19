package ru.okcode.icalc.command.operator

import ru.okcode.icalc.command.Operator
import javax.inject.Inject

class Division @Inject constructor() : Operator {

    private val rang = 2

    override fun rang(): Int {
        return rang
    }

    override fun calc(vararg args: Double): Double {
        val a = args[0]
        val b = args[1]
        return a.div(b)
    }

}