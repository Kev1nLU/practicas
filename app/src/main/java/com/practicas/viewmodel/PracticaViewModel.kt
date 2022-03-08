package com.practicas.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.practicas.data.PracticaDatabase
import com.practicas.model.Practica
import com.practicas.repository.PracticaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PracticaViewModel(application: Application) : AndroidViewModel(application) {

    val getAllData: LiveData<List<Practica>>
    private val repository: PracticaRepository

    init {
        val practicaDao = PracticaDatabase.getDatabase(application).practicaDao()
        repository = PracticaRepository(practicaDao)
        getAllData = repository.getAllData
    }
    fun addEstado (practica: Practica){
        viewModelScope.launch(Dispatchers.IO) {repository.addEstado(practica) }
    }

    fun updateEstado  (practica: Practica){
        viewModelScope.launch(Dispatchers.IO) {repository.updateEstado(practica) }
    }

    fun deleteEstado  (practica: Practica){
        viewModelScope.launch(Dispatchers.IO) {repository.deleteEstado(practica) }
    }

}