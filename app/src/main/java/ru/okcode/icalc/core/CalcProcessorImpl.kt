package ru.okcode.icalc.core

import ru.okcode.icalc.command.Operator
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class CalcProcessorImpl @Inject constructor() : CalcProcessor {

    private val stackNumbers: Stack<Double> = Stack()

    private val queueOperators: Queue<Operator> = LinkedList()

    init {
        stackNumbers.push(0.0)
    }


    override fun handleOperator(operator: Operator) {
        TODO("Not yet implemented")
    }

    override fun handleNumber(number: Double) {
        TODO("Not yet implemented")
    }

}