package ru.okcode.icalc.command

import ru.okcode.icalc.command.operator.*

class CommandFactory {

    companion object {

        fun createOperator(value: String): Operator? {
            return when (value) {
                "percent" -> Percent()
                "plus" -> Plus()
                "minus" -> Minus()
                "division" -> Division()
                "multiplication" -> Multiplication()
                "equally" -> Equally()
                else -> null
            }
        }

    }
}