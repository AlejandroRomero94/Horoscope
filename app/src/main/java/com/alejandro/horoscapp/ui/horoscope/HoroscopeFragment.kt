package com.alejandro.horoscapp.ui.horoscope

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alejandro.horoscapp.databinding.FragmentHoroscopeBinding


class HoroscopeFragment : Fragment() {

    private var _binding: FragmentHoroscopeBinding? = null
    private val binding get() = _binding!!

    /*
    Cuando se llame a binding, que es fijo, por detrás se llama a _binding que es el que se
    puede modificar y se podría romper si se accede directamente. El !! es para decir
    que estamos seguro de que no es nulo, y eso lo sabemos porque primero le estamos
    asignando un valor al binding.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHoroscopeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}