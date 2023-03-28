package com.example.myfriendapp


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MyFriend::class], version = 1)
abstract  class AppDataBase: RoomDatabase() {
    abstract fun myfriendDao(): MyFriendDao

    companion object{
        var INSTANCE:AppDataBase? = null
        fun getAppDataBase(context: Context):AppDataBase? {
            if (INSTANCE == null) {
                synchronized(AppDataBase::class) {
                    INSTANCE =

                        Room.databaseBuilder(
                            context.applicationContext,
                            AppDataBase::class.java, "MyFriendAppDB"
                        ).build()
                }
            }
            return INSTANCE
        }
    fun destroyDataBase(){
        INSTANCE = null
    }}
    }
