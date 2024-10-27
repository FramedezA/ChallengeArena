package com.example.login.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.login.R
import com.example.login.databinding.FragmentLoginBinding
import javax.inject.Inject


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    lateinit var loginViewModelFactory: LoginViewModelFactory
    private lateinit var viewModel: LoginViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        loginViewModelFactory = LoginServiceLocator.getService("loginViewModelFactory")!!
        viewModel =
            ViewModelProvider(this, loginViewModelFactory)[LoginViewModel::class.java]

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.userIsLogged.observe(viewLifecycleOwner) {
            if (it) {

                findNavController().navigate(R.id.action_Login_to_Home)
            }

        }


        binding.registerTextView.setOnClickListener {
            findNavController().navigate(R.id.action_Login_to_Auth)
        }
        binding.loginButton.setOnClickListener {
            binding.loginButton.isClickable = false
            viewModel.login(
                binding.loginEditText.text.toString(),
                binding.passwordEditText.text.toString()
            )
            binding.loginButton.isClickable = true

        }
    }
}