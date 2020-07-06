package ru.okcode.icalc.command.operator

import java.lang.Exception
import javax.inject.Inject

class Clear @Inject constructor() : Operator {

    private val rang = 0

    override fun getRang(): Int {
        return rang
    }

    override fun calc(a: Double, b: Double): Double {
        // TODO TEST
        throw Exception("Method not allowed for this type!")
    }
}