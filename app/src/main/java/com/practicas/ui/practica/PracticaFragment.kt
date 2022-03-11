package com.practicas.ui.practica

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.practicas.R
import com.practicas.adapter.PracticaAdapter
import com.practicas.databinding.FragmentPracticaBinding
import com.practicas.viewmodel.PracticaViewModel

class PracticaFragment : Fragment() {

    //SEMANA 02 SE AGREGO FragmentPracticaBinding en lugar del home abajo

    private var _binding: FragmentPracticaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //Esta val se cambia
        val practicaViewModel =
            ViewModelProvider(this).get(PracticaViewModel::class.java)
        //SEMANA 02 SE AGREGO FragmentPracticaBinding en lugar del home abajo
        _binding = FragmentPracticaBinding.inflate(inflater, container, false)
        //AQui abajo se elinaron una lineas
        binding.fbAgregar.setOnClickListener {
            findNavController().navigate(R.id.action_nav_practica_to_addPracticaFragment)
        }

        // Activar View recycler
        val practicaAdapter = PracticaAdapter() //Se crea un objeto adapter
        val reciclador = binding.reciclador // Se recupera el recyclar view de la vista
        reciclador.adapter =
            practicaAdapter // Se asigna restauranteAdapter como el adapter de recycler
        reciclador.layoutManager = LinearLayoutManager(requireContext())

        // Se crea un "observer" para mostrar la info de la tabla restaurantees..
        // se actualiza cuando cambio el set de datos
        practicaViewModel.getAllData.observe(viewLifecycleOwner)
        { practicas ->
            practicaAdapter.setData(practicas)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}