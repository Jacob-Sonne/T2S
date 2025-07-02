package com.sonne.t2s

import android.app.Application
import androidx.room.Room
import com.sonne.t2s.data.database.AppDatabase

class T2SApplication : Application() {
    companion object {
        lateinit var database: AppDatabase
            private set
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }
}