package ru.okcode.icalc.command

interface Operator {
    fun rang(): Int
    fun calc(vararg args: Double): Double
}