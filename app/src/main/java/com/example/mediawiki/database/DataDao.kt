package com.example.mediawiki.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.mediawiki.model.DataModel

@Dao
interface DataDao {

    @Insert(onConflict = REPLACE)
    fun insertAllData(dataModelList: List<DataModel>)

    @Query("SELECT * FROM data_table")
    fun getLiveData(): LiveData<List<DataModel>?>
}