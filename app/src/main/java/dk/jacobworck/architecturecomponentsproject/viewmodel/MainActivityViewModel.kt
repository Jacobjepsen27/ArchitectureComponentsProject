package dk.jacobworck.architecturecomponentsproject.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import dk.jacobworck.model.Repository
import dk.jacobworck.model.Word
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private var repository: Repository): ViewModel() {

//    private lateinit var repository: Repository

    /*@Inject
    constructor(repository: Repository){
        this.repository = repository
    }*/

    fun getWords(): LiveData<List<Word>>{
//        val wordList: MutableLiveData<List<Word>> = MutableLiveData()
        return repository.getWords()
    }

}