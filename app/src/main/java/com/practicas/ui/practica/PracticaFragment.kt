package com.practicas.ui.practica

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.practicas.databinding.FragmentPracticaBinding
import com.practicas.viewmodel.PracticaViewModel

class PracticaFragment : Fragment() {

    //SEMANA 02 SE AGREGO FragmentPracticaBinding en lugar del home abajo

    private var _binding: FragmentPracticaBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
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
        val root: View = binding.root

        val textView: TextView = binding.textHome
        //Esta val se cambia
        practicaViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}