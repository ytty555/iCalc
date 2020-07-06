package ru.okcode.icalc.command.operator

import javax.inject.Inject

class TriggerPlusMinus @Inject constructor() : Operator {

    private val rang = 0

    override fun getRang(): Int {
        return rang
    }

    override fun calc(a: Double, b: Double): Double {
        // TODO TEST
        return a.times(-1)
    }
}