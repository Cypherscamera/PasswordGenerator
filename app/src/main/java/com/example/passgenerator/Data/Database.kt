package com.example.passgenerator.Data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserPass::class], version = 1, exportSchema = false )
abstract  class Database : RoomDatabase() {

    abstract fun userdao(): UserDao

    companion object{

        @Volatile
        private var INSTANCE : com.example.passgenerator.Data.Database ? = null

        fun getdatabase(context: Context): com.example.passgenerator.Data.Database{

            val tempinstance = INSTANCE
            if(tempinstance!=null){
                return tempinstance
            }
            synchronized(this){

                val instance = Room.databaseBuilder(context.applicationContext,
                com.example.passgenerator.Data.Database::class.java,
                "user_databse",).build()

                INSTANCE == instance
                return instance
            }
        }


    }

}