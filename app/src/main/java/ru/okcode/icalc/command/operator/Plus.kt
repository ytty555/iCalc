package ru.okcode.icalc.command.operator

import ru.okcode.icalc.command.Operator
import java.math.BigDecimal
import javax.inject.Inject

class Plus @Inject constructor() : Operator {

    private val rang = 1

    override fun rang(): Int {
        return rang
    }

    override fun calc(vararg args: BigDecimal): BigDecimal {
        val a = args[0]
        val b = args[1]
        return a.plus(b)
    }
}