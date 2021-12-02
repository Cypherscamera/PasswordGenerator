package com.example.passgenerator.Data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user:UserPass)

    @Update
    suspend fun updateUser(user: UserPass)

    @Delete
    suspend fun deleteUser(user: UserPass)

    @Query("Select * FROM data_table Order By id")
    fun readAllData(): LiveData<List<UserPass>>
}