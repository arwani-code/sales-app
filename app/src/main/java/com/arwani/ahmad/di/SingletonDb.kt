package com.arwani.ahmad.di

import android.content.Context
import androidx.room.Room
import com.arwani.ahmad.data.local.ProductDao
import com.arwani.ahmad.data.local.ProductDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SingletonDb {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): ProductDatabase {
        return Room.databaseBuilder(
            context,
            ProductDatabase::class.java,
            "product_db"
        ).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideMoviesDao(moviesDatabase: ProductDatabase): ProductDao = moviesDatabase.productDao()

}