package ru.okcode.icalc.core

import io.reactivex.rxjava3.core.Observable
import ru.okcode.icalc.command.Calculable

interface CalcProcessor {

    fun handleOperator(operator: Calculable)

    fun handleNumber(number: Double)

    fun handleEqually()

    fun lastInputNumber(): Observable<Double>
}