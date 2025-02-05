package com.example.onlyofficeclient.ui.documents

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.onlyofficeclient.R
import com.example.onlyofficeclient.databinding.FragmentDocumentsBinding
import com.example.onlyofficeclient.ui.logon.LogonViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DocumentsFragment : Fragment() {

    private var _binding:  FragmentDocumentsBinding? = null
    private val binding: FragmentDocumentsBinding
        get() = _binding ?: throw RuntimeException("Document Fragment == null")
    private val viewModel by viewModels<DocumentsViewModel>()
//    private val args by navArgs<Args>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDocumentsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLoad.setOnClickListener {
            viewModel.getDocumentsSection()
        }
        Log.d("MyLog111", "Document fragment launch")
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}