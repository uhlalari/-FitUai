package com.example.fituai.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUserData(userDataEntity: UserDataEntity)

    @Query("SELECT * FROM user_data LIMIT 1")
    suspend fun getUserData(): UserDataEntity?
}
