package dk.jacobworck.persistency

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
abstract class WordDao {

    @Query("SELECT * FROM WordRecord")
    abstract fun getAllWords(): LiveData<List<WordRecord>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertWord(wordRecord: WordRecord)
}