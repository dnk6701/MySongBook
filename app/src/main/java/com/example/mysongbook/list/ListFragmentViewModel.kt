package com.example.mysongbook.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.launch
import com.example.mysongbook.room.DbConnection
import com.example.mysongbook.room.UserData

class ListFragmentViewModel (application: Application) : AndroidViewModel(application) {
    private val userEntityDao =
        Room.databaseBuilder(application, DbConnection::class.java, "database")
            .build()
            .entityDao()

    val list = userEntityDao.getAll()
//    var number = count(list)

    fun insert(userData: UserData){
        viewModelScope.launch {
            userEntityDao.insert(userData)
        }
    }

}