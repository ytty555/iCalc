package ru.okcode.icalc.command

import java.math.BigDecimal

interface Operator {
    fun rang(): Int
    fun calc(vararg args: BigDecimal): BigDecimal
}