package com.desing.ceibaprueba.di

import android.content.Context
import androidx.room.Room
import com.desing.ceibaprueba.data.model.database.entities.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    val USER_DATABASE_NAME = "user_database"

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(context, UserDatabase::class.java,USER_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideDaoUSer(db: UserDatabase) = db.getUserDao()
}