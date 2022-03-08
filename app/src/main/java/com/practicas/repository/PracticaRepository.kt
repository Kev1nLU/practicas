package com.practicas.repository

import androidx.lifecycle.LiveData
import com.practicas.data.PracticaDao
import com.practicas.model.Practica

class PracticaRepository(private val practicaDao: PracticaDao) {

    val getAllData: LiveData<List<Practica>> = practicaDao.getAllData()

    suspend fun addEstado(practica: Practica){
        practicaDao.addEstado(practica)
    }
    suspend fun updateEstado(practica: Practica){
        practicaDao.updateEstado(practica)
    }
    suspend fun deleteEstado(practica: Practica){
        practicaDao.deleteEstado(practica)
    }
}