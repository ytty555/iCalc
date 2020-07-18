package ru.okcode.icalc.core

import dagger.Binds
import dagger.Module

@Module
abstract class CoreModule {

    @Binds
    abstract fun bindCalcProcessor(processor: CalcProcessorImpl): CalcProcessor
}