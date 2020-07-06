package ru.okcode.icalc.command.operator

import ru.okcode.icalc.command.Command

interface Operator: Command {
    fun getRang(): Int

    fun calc(a: Double, b: Double = 0.0): Double
}