package ru.okcode.icalc.command

interface Calculable : Operator {

    fun calc(vararg args: Double): Double

}