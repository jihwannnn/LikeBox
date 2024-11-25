package com.example.likebox.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Mock

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationScope