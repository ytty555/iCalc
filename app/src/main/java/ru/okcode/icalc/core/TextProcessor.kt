package ru.okcode.icalc.core

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import ru.okcode.icalc.command.Operand

interface TextProcessor {
    val numberAsString: PublishSubject<String>

    fun createText(operand: Operand): TextProcessor

    fun clear(): TextProcessor


}