package dk.jacobworck.architecturecomponentsproject

import android.app.Application
import android.arch.lifecycle.ViewModel
import dagger.android.DaggerApplication
import dk.jacobworck.architecturecomponentsproject.dagger.*

class AACApplication: Application() {

    private lateinit var wordComponent: WordComponent

    override fun onCreate() {
        super.onCreate()

        wordComponent = DaggerWordComponent.builder()
                // list of modules that are part of this component need to be created here too
                .appModule(AppModule(this))
                .roomModule(RoomModule(this))
                .build()

    }

    fun getWordComponent(): WordComponent{
        return this.wordComponent
    }
}