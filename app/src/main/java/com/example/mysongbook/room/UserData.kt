package com.example.mysongbook.room


import android.text.Editable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserData(@PrimaryKey(autoGenerate = false) /*var id: Int = 0,*/
                    var name: String,
                    var composer: String,
                    var lirics: String,
                    var artist: String,
                    var tone: String,
                    var text: String
           )
