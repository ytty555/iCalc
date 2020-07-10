package ru.okcode.icalc.command

interface Calculable {

    fun calc(vararg args: Double): Double

}