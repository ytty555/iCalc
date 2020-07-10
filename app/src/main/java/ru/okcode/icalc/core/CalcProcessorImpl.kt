package ru.okcode.icalc.core

import ru.okcode.icalc.command.Calculable
import java.util.*
import javax.inject.Inject

class CalcProcessorImpl @Inject constructor() : CalcProcessor {

    private val numbers: Stack<Double> = Stack()

    private val oparators: Stack<Calculable> = Stack()

    private var calcResult: Double = 0.0


    override fun handleOperator(operator: Calculable) {

        if (oparators.isEmpty()) {
            oparators.push(operator)
        } else {
            val operatorInQueue = oparators.peek()
            val rangOperatorInQueue = operatorInQueue.getRang()
            val rangOperator = operator.getRang()
            if (rangOperator <= rangOperatorInQueue) {
                calcOperatorsFromQueue()
            }
            oparators.push(operator)

        }
    }

    private fun calcOperatorsFromQueue() {
        while (oparators.isNotEmpty()) {
            val b = numbers.pop()
            val a = numbers.pop()
            val operator = oparators.pop()
            val result = operator.calc(a, b)
            numbers.push(result)
            calcResult = result
        }
    }

    override fun handleNumber(number: Double) {
        numbers.push(number)
    }

    override fun handleEqually() {
        calcOperatorsFromQueue()
    }

    override fun getCalcResult(): Double {
        return calcResult
    }
}