package com.a4a.budok.di

import android.app.Application
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.a4a.budok.data.ActionsDataSource
import com.a4a.budok.Database
import com.a4a.budok.data.VocabDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSqlDriver(app: Application): SqlDriver {
        return AndroidSqliteDriver(
            schema = Database.Schema,
            context = app,
            name = "budok.db"
        )
    }

    @Provides
    @Singleton
    fun provideActionDataSource(driver: SqlDriver): ActionsDataSource {
        return ActionsDataSource(Database(driver))
    }

    @Provides
    @Singleton
    fun provideVocabDataSource(driver: SqlDriver): VocabDataSource {
        return VocabDataSource(Database(driver))
    }
}