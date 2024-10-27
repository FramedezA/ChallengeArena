package com.example.home.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.WifiChecker
import com.example.home.R
import com.example.home.data.data_structures.Challenge
import com.example.home.databinding.FragmentHomeBinding


class HomeFragment : Fragment(),ChallengesAdapter.ChallengeClickListener {


    private lateinit var binding: FragmentHomeBinding

    lateinit var homeViewModelFactory: HomeViewModelFactory
    private lateinit var viewModel: HomeViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        homeViewModelFactory = HomeServiceLocator.getService("homeViewModelFactory")!!
        viewModel =
            ViewModelProvider(this, homeViewModelFactory)[HomeViewModel::class.java]

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("mLogView",viewModel.getUserName())
        binding.userNameTextView.text = viewModel.getUserName()
        viewModel.challenges.observe(viewLifecycleOwner) {
            binding.stateTextView.isVisible = it.isEmpty()
            setUpRecyclerView(it)
        }
        if (WifiChecker.isInternetConnected(requireContext())) {
            viewModel.getChallenges()
        } else {
            binding.stateTextView.isVisible = true
            Toast.makeText(context, "Нет подключения к интернету", Toast.LENGTH_LONG).show()
        }
        binding.achivButton.setOnClickListener {
            findNavController().navigate(R.id.action_Home_to_achiv)

        }
    }

    private fun setUpRecyclerView(entryList: List<Challenge>) {
        val recyclerView = binding.challengeList
        val adapter = ChallengesAdapter(entryList, this@HomeFragment)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }



    override fun onClick(challenge: Challenge) {
        val dialog =  object : ChallengeDialogFragment(context,challenge) {}
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.show()

    }

}