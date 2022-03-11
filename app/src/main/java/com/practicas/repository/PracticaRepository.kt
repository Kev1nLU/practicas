package com.practicas.repository

import androidx.lifecycle.LiveData
import com.practicas.data.PracticaDao
import com.practicas.model.Practica

class PracticaRepository(private val practicaDao: PracticaDao) {

    val getAllData: LiveData<List<Practica>> = practicaDao.getAllData()

    suspend fun addPractica(practica: Practica){
        practicaDao.addPractica(practica)
    }
    suspend fun updatePractica(practica: Practica){
        practicaDao.updatePractica(practica)
    }
    suspend fun deletePractica(practica: Practica){
        practicaDao.deletePractica(practica)
    }
}