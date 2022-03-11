package com.practicas.ui.practica

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.practicas.R
import com.practicas.databinding.FragmentAddPracticaBinding
import com.practicas.model.Practica
import com.practicas.viewmodel.PracticaViewModel

//Semana03 segundo video

class AddPracticaFragment : Fragment() {
    // Se borro parte de arriba y parte de bajo dejando el oncreateview

    private lateinit var practicaViewModel: PracticaViewModel
    private var _binding: FragmentAddPracticaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        practicaViewModel = ViewModelProvider(this).get(PracticaViewModel::class.java)
        _binding = FragmentAddPracticaBinding.inflate(inflater, container, false)
        binding.btAgregar.setOnClickListener{
            agregarEstado()
        }
        return binding.root

    }

    private fun agregarEstado(){
        val nombre = binding.etNombre.text.toString()

        if(nombre.isNotEmpty()){
            val capital = binding.etCapital.text.toString()
            val poblacion = binding.etPoblacion.text.toString()
            val costas = binding.etCostas.text.toString()

            val practica = Practica(0,nombre,capital, poblacion, costas)

            practicaViewModel.addPractica(practica)
            Toast.makeText(requireContext(),
                getString(R.string.msg_estado_add),
                Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_addPracticaFragment_to_nav_practica)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}