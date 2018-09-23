package dk.jacobworck.model

import android.arch.lifecycle.LiveData

interface Repository {

    fun getWords(): LiveData<List<Word>>

    fun addWord(word: Word)

}