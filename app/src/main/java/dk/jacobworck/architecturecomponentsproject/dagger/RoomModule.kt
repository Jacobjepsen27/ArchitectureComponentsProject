package dk.jacobworck.architecturecomponentsproject.dagger

import android.app.Application
import android.arch.persistence.room.Room
import dagger.Module
import dagger.Provides
import dk.jacobworck.model.Repository
import dk.jacobworck.persistency.WordDao
import dk.jacobworck.persistency.WordDatabase
import dk.jacobworck.remote.RemoteRepository
import javax.inject.Inject
import javax.inject.Singleton

@Module
class RoomModule {

    private var roomDatabase: WordDatabase

    @Inject
    constructor(application: Application){
        this.roomDatabase = Room.databaseBuilder(application,WordDatabase::class.java,"word_db").build()
    }

    @Provides
    @Singleton
    fun getDatabase(): WordDatabase{
        return this.roomDatabase
    }

    @Provides
    @Singleton
    fun getWordDao(wordDb: WordDatabase): WordDao {
        return wordDb.wordDao()
    }

    @Provides
    @Singleton
    fun getRepository(wordDao: WordDao): Repository {
        return RemoteRepository(wordDao)
    }

}