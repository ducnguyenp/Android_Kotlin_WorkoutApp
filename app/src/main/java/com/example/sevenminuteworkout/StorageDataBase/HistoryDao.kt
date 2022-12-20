package com.example.sevenminuteworkout.StorageDataBase

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {

    @Insert
    suspend fun insert(employeeEntity: HistoryEntity)

    @Update
    suspend fun update(employeeEntity: HistoryEntity)

    @Delete
    suspend fun delete(employeeEntity: HistoryEntity)

    @Query("Select * from `employee-table`")
    fun fetchAllEmployee():Flow<List<HistoryEntity>>

    @Query("Select * from `employee-table` where id=:id")
    fun fetchEmployeeById(id:Int):Flow<HistoryEntity>
}