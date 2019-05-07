package com.oleg.latihanarchitecturecomponents.database

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.oleg.latihanarchitecturecomponents.model.Word

class WordRepository (private val wordDao: WordDao){
    val allWords: LiveData<List<Word>> = wordDao.getAllWords()

    @WorkerThread
    suspend fun insert(word: Word){
        wordDao.insert(word)
    }
}