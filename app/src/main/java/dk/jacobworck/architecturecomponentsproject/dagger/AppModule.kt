package dk.jacobworck.architecturecomponentsproject.dagger

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    private var application: Application

    constructor(application: Application){
        this.application = application
    }

    @Provides
    @Singleton
    fun getApplication(): Application{
        return application
    }

}