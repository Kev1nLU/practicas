package com.practicas.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.practicas.model.Practica

@Dao
interface PracticaDao {

    //Se agrega esto, al lado del FROM se pone el nombre de la tabla
    @Query("SELECT * FROM ESTADO")
    fun getAllData(): LiveData<List<Practica>>
    //Se agrega esto, OJO con addNombre (nombre: Nombre)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPractica(practica: Practica)
    //Se agrega esto, OJO con addNombre (nombre: Nombre)
    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updatePractica(practica: Practica)
    //Se agrega esto, OJO con addNombre (nombre: Nombre)
    @Delete
    suspend fun deletePractica(practica: Practica)
}