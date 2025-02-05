package com.example.onlyofficeclient.ui.logon

import android.content.Intent
import android.health.connect.datatypes.units.Length
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.onlyofficeclient.R
import com.example.onlyofficeclient.databinding.FragmentLogonBinding
import com.example.onlyofficeclient.utils.Resource
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LogonFragment : Fragment() {

    private var _binding: FragmentLogonBinding? = null
    private val binding: FragmentLogonBinding
        get() = _binding ?: throw RuntimeException("Logon Fragment == null")
    private val viewModel by viewModels<LogonViewModel>()

//    private val apiService = ApiFactory.apiService

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addChangeTextListeners()
        observeLiveDates()

        binding.btnLogin.setOnClickListener {
            binding.pbLoad.visibility = View.VISIBLE

            viewModel.auth(
                inputEmail = binding.etEmail.text.toString(),
                inputPassword = binding.etPassword.text.toString()
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLogonBinding.inflate(inflater, container, false)
        return binding.root
    }

//

    private fun observeLiveDates() {
        viewModel.errorInputEmail.observe(viewLifecycleOwner) { input ->
            val message = if (input) {
                getString(R.string.error_input_message)
            } else {
                null
            }
            binding.tilEmail.error = message
            binding.pbLoad.visibility = View.INVISIBLE
        }
        viewModel.errorInputPassword.observe(viewLifecycleOwner) { input ->
            val message = if (input) {
                getString(R.string.error_input_message)
            } else {
                null
            }
            binding.tilPassword.error = message
            binding.pbLoad.visibility = View.INVISIBLE
        }


        viewModel.authResponseLiveData.observe(viewLifecycleOwner) { response ->
            Log.d("MyLog111", "viewModel.authResponseLiveData.observe")
            when (response) {
                is Resource.Success -> {
                    response.data?.let {
                        binding.pbLoad.visibility = View.INVISIBLE
                        launchHomeFragment()
                    }
                }

                is Resource.Error -> {
                    response.message.let { errorMessage ->
                        Toast.makeText(requireContext(), "Error: ${errorMessage}", Toast.LENGTH_SHORT).apply {
                            show()
                        }
                        binding.pbLoad.visibility = View.INVISIBLE
                        Log.d("MyLog111", "Logon Fragment error: $errorMessage")
                    }
                }

                is Resource.Loading -> {
                    binding.pbLoad.visibility = View.VISIBLE
                    Log.d("MyLog111", "Loading")
                }
            }
        }
    }

    private fun addChangeTextListeners() {
        binding.etEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.resetErrorInputEmail()
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })

        binding.etPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.resetErrorInputPassword()
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
    }

    private fun launchHomeFragment() {
        findNavController().navigate(LogonFragmentDirections.actionLogonFragmentToDocumentsFragment())
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}