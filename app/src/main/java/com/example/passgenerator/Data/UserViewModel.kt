package com.example.passgenerator.Data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    val readalldata :LiveData<List<UserPass>>
    private val repository: Repository

    init {
        val userdao = Database.getdatabase(application).userdao()
        repository = Repository(userdao)
        readalldata = repository.ReadAllData
    }

    fun adduser(userPass: UserPass){
        viewModelScope.launch (Dispatchers.IO){
            repository.addUser(userPass)
        }
    }
    fun updateuser(userPass: UserPass){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUser(userPass)
        }
    }
    fun deleteuser(userPass: UserPass){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUser(userPass)
        }
    }

}