package dk.jacobworck.architecturecomponentsproject.dagger

import dagger.Component
import dk.jacobworck.architecturecomponentsproject.MainActivity
import dk.jacobworck.architecturecomponentsproject.viewmodel.MainActivityViewModel
import dk.jacobworck.model.Repository
import dk.jacobworck.persistency.WordDao
import dk.jacobworck.persistency.WordDatabase
import dk.jacobworck.remote.RemoteRepository
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class,RoomModule::class])
interface WordComponent {

    fun inject(mainActivity: MainActivity)

    /*fun wordDao(): WordDao

    fun wordDb(): WordDatabase

    fun remoteRepo(): Repository*/

}