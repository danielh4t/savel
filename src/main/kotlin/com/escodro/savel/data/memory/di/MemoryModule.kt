package com.escodro.savel.data.memory.di

import com.escodro.savel.data.memory.MemorySaveToken
import com.escodro.savel.data.repository.datasource.SaveTokenDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val memoryModule =
    module {
        singleOf(::MemorySaveToken) bind SaveTokenDataSource::class
    }
