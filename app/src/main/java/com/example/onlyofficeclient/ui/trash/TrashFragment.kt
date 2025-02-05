package com.example.onlyofficeclient.ui.trash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.onlyofficeclient.R
import com.example.onlyofficeclient.databinding.FragmentRoomsBinding
import com.example.onlyofficeclient.databinding.FragmentTrashBinding


class TrashFragment : Fragment() {
    private var _binding:  FragmentTrashBinding? = null
    private val binding: FragmentTrashBinding
        get() = _binding ?: throw RuntimeException("TrashFragment == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTrashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}