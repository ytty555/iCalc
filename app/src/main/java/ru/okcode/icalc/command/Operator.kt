package ru.okcode.icalc.command

interface Operator {
    fun getRang(): Int
    fun calc(vararg args: Double): Double
}