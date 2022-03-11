package com.practicas.ui.practica

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.practicas.R
import com.practicas.databinding.FragmentUpdatePracticaBinding
import com.practicas.model.Practica
import com.practicas.viewmodel.PracticaViewModel

//Semana03 segundo video

class UpdatePracticaFragment : Fragment() {
    // Se borro parte de arriba y parte de bajo dejando el oncreateview

    private lateinit var practicaViewModel: PracticaViewModel
    private val args by navArgs<UpdatePracticaFragmentArgs>()
    private var _binding: FragmentUpdatePracticaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        practicaViewModel = ViewModelProvider(this).get(PracticaViewModel::class.java)
        _binding = FragmentUpdatePracticaBinding.inflate(inflater, container, false)

        binding.etNombre.setText(args.practica.nombre)
        binding.etCapital.setText(args.practica.capital)
        binding.etPoblacion.setText(args.practica.poblacion)
        binding.etCostas.setText(args.practica.Costas)

        binding.btActualizar.setOnClickListener{ updatePractica() }

        setHasOptionsMenu(true)
        return binding.root

    }

    private fun updatePractica() {
        val nombre = binding.etNombre.text.toString()

        if (nombre.isNotEmpty()) {
            val capital = binding.etCapital.text.toString()
            val poblacion = binding.etPoblacion.text.toString()
            val costas = binding.etCostas.text.toString()

            val practica = Practica(args.practica.id, nombre, capital, poblacion,costas)

            practicaViewModel.updatePractica(practica)
            Toast.makeText(
                requireContext(),
                getString(R.string.msg_estado_update),
                Toast.LENGTH_SHORT
            ).show()

            findNavController().navigate(R.id.action_updatePracticaFragment_to_nav_practica)

        }
    }

        override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
            inflater.inflate(R.menu.delete_menu,menu)
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {

            if(item.itemId==R.id.menu_delete){
                deleteEstado()

            }
            return  super.onOptionsItemSelected(item)
        }

        private fun deleteEstado(){
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle(R.string.menu_delete
            )
            builder.setMessage(getString(R.string.msg_seguroBorrar)+" ${args.practica.nombre}")
            builder.setNegativeButton(getString(R.string.no)){_,_ ->}
            builder.setPositiveButton(getString(R.string.si)){_,_ ->
                practicaViewModel.deletePractica(args.practica)
                findNavController().navigate(R.id.action_updatePracticaFragment_to_nav_practica)
            }
            builder.create().show()

        }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}