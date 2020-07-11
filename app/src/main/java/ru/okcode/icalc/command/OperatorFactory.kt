package ru.okcode.icalc.command

import ru.okcode.icalc.command.operator.*

class OperatorFactory {

    companion object {

        fun createOperator(operatorType: OperatorType): Calculable {
            return when (operatorType) {
                OperatorType.PERCENT -> Percent()
                OperatorType.PLUS -> Plus()
                OperatorType.MINUS -> Minus()
                OperatorType.DIVISION -> Division()
                OperatorType.MULTIPLICATION -> Multiplication()
            }
        }

    }
}