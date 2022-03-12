package com.practicas.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.practicas.databinding.PracticaFilaBinding
import com.practicas.model.Practica
import com.practicas.ui.practica.PracticaFragmentDirections

class PracticaAdapter: RecyclerView.Adapter<PracticaAdapter.PracticaViewHolder>() {

    private var listaPracticas = emptyList<Practica>()

    inner class PracticaViewHolder(private val itemBindind: PracticaFilaBinding):
        RecyclerView.ViewHolder(itemBindind.root) {
        fun bind(practica: Practica){
            itemBindind.tvCapital.text = practica.capital
            itemBindind.tvPoblacion.text = practica.poblacion.toString() //aqui
            itemBindind.tvCostas.text = practica.Costas
            itemBindind.tvNombre.text = practica.nombre
            itemBindind.vistaFila.setOnClickListener {
                val action = PracticaFragmentDirections.
                actionNavPracticaToUpdatePracticaFragment(practica)
                itemView.findNavController().navigate(action)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PracticaViewHolder {
        val itemBindind = PracticaFilaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PracticaViewHolder(itemBindind)
    }

    override fun onBindViewHolder(holder: PracticaViewHolder, position: Int) {
        val practicaActual = listaPracticas[position]
        holder.bind(practicaActual)
    }

    override fun getItemCount(): Int {
        return listaPracticas.size
    }

    fun setData(practicas: List<Practica>){
        this.listaPracticas = practicas
        notifyDataSetChanged()
    }
}