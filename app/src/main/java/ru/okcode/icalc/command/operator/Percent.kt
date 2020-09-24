package ru.okcode.icalc.command.operator

import ru.okcode.icalc.command.Operator
import java.math.BigDecimal
import javax.inject.Inject

class Percent @Inject constructor() : Operator {

    private val rang = 0

    override fun rang(): Int {
        return rang
    }

    override fun calc(vararg args: BigDecimal): BigDecimal {
        val a = args[args.lastIndex]
        return a.div(BigDecimal.valueOf(100.0))
    }
}