package ru.okcode.icalc.core

import android.util.Log
import io.reactivex.rxjava3.core.Observable
import ru.okcode.icalc.command.Calculable
import java.util.*
import javax.inject.Inject

class CalcProcessorImpl @Inject constructor() : CalcProcessor {

    private val numbers: Stack<Double> = Stack()

    private val operators: Stack<Calculable> = Stack()


    override fun handleOperator(operator: Calculable) {

        if (operators.isEmpty()) {
            operators.push(operator)
        } else {
            val operatorInQueue = operators.peek()
            val rangOperatorInQueue = operatorInQueue.getRang()
            val rangOperator = operator.getRang()
            if (rangOperator <= rangOperatorInQueue) {
                calcOperatorsFromQueue()
            }
            operators.push(operator)

        }
    }

    private fun calcOperatorsFromQueue() {
        while (operators.isNotEmpty()) {
            val b = numbers.pop()
            val a = numbers.pop()
            val operator = operators.pop()
            val result = operator.calc(a, b)
            numbers.push(result)
        }
    }

    override fun handleNumber(number: Double) {
        numbers.push(number)
    }

    override fun handleEqually() {
        calcOperatorsFromQueue()
    }


    override fun lastNumber(): Observable<Double> {
        return if (numbers.empty()) {
            Log.e("qq", "CalcProcessor lastNumber 0.0")
            Observable.just(0.0)
        } else {
            Log.e("qq", "CalcProcessor lastNumber ${numbers.peek()}")
            Observable.just(numbers.peek())
        }
    }
}