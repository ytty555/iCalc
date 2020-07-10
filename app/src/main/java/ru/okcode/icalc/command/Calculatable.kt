package ru.okcode.icalc.command

interface Calculatable {

    fun calc(vararg args: Double): Double

}