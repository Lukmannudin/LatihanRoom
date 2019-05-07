package com.oleg.latihanarchitecturecomponents

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.oleg.latihanarchitecturecomponents.database.WordRepository
import com.oleg.latihanarchitecturecomponents.database.WordRoomDatabase
import com.oleg.latihanarchitecturecomponents.model.Word
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewModel (application: Application):AndroidViewModel(application){
    private val repository:WordRepository

    val allWords: LiveData<List<Word>>

    init {
        val wordsDao = WordRoomDatabase.getDatabase(application,viewModelScope).wordDao()
        repository = WordRepository(wordsDao)
        allWords = repository.allWords
    }

    fun insert(word: Word)=viewModelScope.launch(Dispatchers.IO) {
        repository.insert(word)
    }



}