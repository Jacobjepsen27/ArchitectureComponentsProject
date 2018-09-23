package dk.jacobworck.persistency

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Room
import android.content.Context


@Database(entities = [WordRecord::class], version = 1, exportSchema = false)
abstract class WordDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao

    /*companion object {

        private var database: WordDatabase? = null

        fun getDatabase(context: Context): WordDatabase {
            if (database == null) {

                synchronized(WordDatabase::class.java) {
                    if (database == null) {
                        database = Room.databaseBuilder(context.applicationContext,
                                WordDatabase::class.java, "word_database")
                                // Wipes and rebuilds instead of migrating
                                // if no Migration object.
                                // Migration is not part of this practical.
                                .fallbackToDestructiveMigration()
                                .build()
                    }
                }

            }
            return database!!
        }

    }*/
}