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
    abstract fun displayProcessor(processor: DisplayProcessorImpl): DisplayProcessor
}