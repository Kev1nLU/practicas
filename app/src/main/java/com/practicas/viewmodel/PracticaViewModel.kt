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
    fun addPractica (practica: Practica){
        viewModelScope.launch(Dispatchers.IO) {repository.addPractica(practica) }
    }

    fun updatePractica  (practica: Practica){
        viewModelScope.launch(Dispatchers.IO) {repository.updatePractica(practica) }
    }

    fun deletePractica  (practica: Practica){
        viewModelScope.launch(Dispatchers.IO) {repository.deletePractica(practica) }
    }

}