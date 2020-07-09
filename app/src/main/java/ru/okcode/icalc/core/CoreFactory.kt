package ru.okcode.icalc.core

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class])
interface CoreFactory {
    fun getCalcProcessor(): CalcProcessor
    fun getDisplay(): Display
}