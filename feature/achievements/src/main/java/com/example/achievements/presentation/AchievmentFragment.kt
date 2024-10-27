package com.example.achievements.presentation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.achievements.R
import com.example.achievements.data.data_structures.Achievement
import com.example.achievements.databinding.FragmentAchievmentBinding
import com.example.core.WifiChecker

class AchievmentFragment : Fragment(){
    private lateinit var binding: FragmentAchievmentBinding


    private lateinit var achievementsViewModelFactory: AchievementsViewModelFactory
    private lateinit var viewModel: AchievementsViewModel



    override fun onAttach(context: Context) {
        super.onAttach(context)
        achievementsViewModelFactory =
            AchievmentsServiceLocator.getService("achievmentsViewModelFactory")!!
        viewModel =
            ViewModelProvider(this, achievementsViewModelFactory)[AchievementsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAchievmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.achievements.observe(viewLifecycleOwner) {
            binding.stateTextView.isVisible = it.isEmpty()
                setUpRecyclerView(it)
        }
        if (WifiChecker.isInternetConnected(requireContext())) {
            viewModel.getAchievments()
        } else {
            binding.stateTextView.isVisible = true
            Toast.makeText(context, "Нет подключения к интернету", Toast.LENGTH_LONG).show()
        }

    }



    private fun setUpRecyclerView(achievements: List<Achievement>, ) {
        val recyclerView = binding.achievmentList
        val adapter = AchievmentAdapter(achievements)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }



}