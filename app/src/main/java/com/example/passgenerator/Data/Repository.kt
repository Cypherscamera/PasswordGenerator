package com.example.passgenerator.Data

import androidx.lifecycle.LiveData

class Repository(private val userDao: UserDao) {

    val ReadAllData : LiveData<List<UserPass>> = userDao.readAllData()

    suspend fun addUser(userPass: UserPass){
        userDao.addUser(userPass)
    }

    suspend fun updateUser(userPass: UserPass){
        userDao.updateUser((userPass))
    }

    suspend fun deleteUser(userPass: UserPass){
        userDao.deleteUser(userPass)
    }
}