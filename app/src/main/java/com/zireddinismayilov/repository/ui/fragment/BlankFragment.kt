package com.zireddinismayilov.repository.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.zireddinismayilov.repository.databinding.FragmentBlankBinding
import com.zireddinismayilov.repository.repository.DataRepository
import com.zireddinismayilov.repository.viewmodel.BlankViewModel


class BlankFragment : Fragment() {

    lateinit var viewModel: BlankViewModel
    lateinit var binding: FragmentBlankBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentBlankBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[BlankViewModel::class.java]
        viewModel.getData()
        DataRepository().data.observe(viewLifecycleOwner, Observer {

        })
        return binding.root
    }
}