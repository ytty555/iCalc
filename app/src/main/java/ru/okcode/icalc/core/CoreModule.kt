package ru.okcode.icalc.core

import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class CoreModule {

    @Binds
    @Singleton
    abstract fun calcProcessor(processor: CalcProcessorImpl): CalcProcessor

    @Binds
    @Singleton
    abstract fun textProcessor(processor: TextProcessorImpl): TextProcessor

    @Binds
    abstract fun numberProcessor(processor: NumberProcessorImpl): NumberProcessor

}