package com.practicas.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName="estado")
data class Practica(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name = "nombre")
    val nombre: String,
    @ColumnInfo(name = "capital")
    val capítal: String,
    @ColumnInfo(name = "poblacion")
    val poblacion: Int,
    @ColumnInfo(name = "costas")
    val Costas: String,
): Parcelable
