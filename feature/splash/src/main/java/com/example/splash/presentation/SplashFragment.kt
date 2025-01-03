package com.example.splash.presentation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.splash.R



class SplashFragment : Fragment() {

    lateinit var splashViewModelFactory: SplashViewModelFactory
    private lateinit var splashViewModel: SplashViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        splashViewModelFactory = SplashServiceLocator.getService("splashViewModelFactory")!!
        splashViewModel = ViewModelProvider(
            this, splashViewModelFactory
        )[SplashViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (splashViewModel.isUserLogged()) {
            findNavController().navigate(R.id.action_Splash_to_Home)
        } else {
            findNavController().navigate(R.id.action_Splash_to_Login)
        }
    }
}