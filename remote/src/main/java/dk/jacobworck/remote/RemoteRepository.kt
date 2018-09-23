package dk.jacobworck.remote

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import dk.jacobworck.model.Repository
import dk.jacobworck.model.Word
import dk.jacobworck.persistency.WordDao
import javax.inject.Inject

class RemoteRepository: Repository{

    private var wordDao: WordDao

    @Inject
    constructor(wordDao: WordDao){
        this.wordDao = wordDao
    }

    override fun getWords(): LiveData<List<Word>> {
        val wordListLivedata: MutableLiveData<List<Word>> = MutableLiveData()

        val wordList: MutableList<Word> = mutableListOf()
        wordList.add(Word("Apple"))
        wordList.add(Word("Banana"))
        wordList.add(Word("Tomato"))
        wordList.add(Word("Jelly bean"))

        wordListLivedata.value = wordList

        return wordListLivedata
    }

    override fun addWord(word: Word) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}