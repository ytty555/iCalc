package ru.okcode.icalc.command

import ru.okcode.icalc.command.operand.*
import ru.okcode.icalc.command.operator.*

class CommandFactory {

    companion object {
        fun createOperand(value: String): Operand? {
            return when (value) {
                "comma" -> Comma()
                "000" -> Digit000()
                "0" -> Digit0()
                "1" -> Digit1()
                "2" -> Digit2()
                "3" -> Digit3()
                "4" -> Digit4()
                "5" -> Digit5()
                "6" -> Digit6()
                "7" -> Digit7()
                "8" -> Digit8()
                "9" -> Digit9()
                else -> null
            }
        }

        fun createOperator(value: String): Operator? {
            return when (value) {
                "clean" -> Clear()
                "trigger_plus_minus" -> TriggerPlusMinus()
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