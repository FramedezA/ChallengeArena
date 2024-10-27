package com.example.challenges.presentation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challenges.Utils
import com.example.challenges.data.data_structures.Challenge
import com.example.challenges.databinding.FragmentChallengesBinding
import com.example.challenges.presentation.picker_manager.PickerManager
import com.example.core.WifiChecker
import com.example.home.presentation.HomeServiceLocator
import com.example.home.presentation.HomeViewModel
import java.util.Calendar

class ChallengesFragment : Fragment(), ChallengesAdapter.ChallengeClickListener {
    private lateinit var binding: FragmentChallengesBinding


    private lateinit var challengesViewModelFactory: ChallengesViewModelFactory
    private lateinit var viewModel: ChallengesViewModel
    private lateinit var homeViewModel: HomeViewModel

    private lateinit var pickerManager: PickerManager
    private lateinit var userChallenges: List<Challenge>


    override fun onAttach(context: Context) {
        super.onAttach(context)
        pickerManager = ChallengesServiceLocator.getService("pickerManager")!!
        challengesViewModelFactory =
            ChallengesServiceLocator.getService("challengesViewModelFactory")!!
        viewModel =
            ViewModelProvider(this, challengesViewModelFactory)[ChallengesViewModel::class.java]

        homeViewModel =ViewModelProvider(this, HomeServiceLocator.getService("homeViewModelFactory")!!)[HomeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChallengesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.challenges.observe(viewLifecycleOwner) {
            val list: MutableList<Challenge> = mutableListOf()
            it.forEach { element ->
                list.add(
                    Challenge(
                        element.id,
                        element.description,
                        element.rules,
                        element.title,
                        element.type,
                        element.date
                    ))
            }
            userChallenges = list
        }
        viewModel.challenges.observe(viewLifecycleOwner) {
            binding.stateTextView.isVisible = it.isEmpty()
            if (::userChallenges.isInitialized){
                setUpRecyclerView(it, userChallenges)
            }
            else{
                homeViewModel.getChallenges()
                viewModel.getChallenges(Utils.getTodayDate())
            }
        }
        viewModel.challengeRequest.observe(viewLifecycleOwner) {
            if (it.challengeId != -1) {
                Toast.makeText(requireContext(), "Вы записались на квест!", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        binding.dateSelectTextView.text = Utils.formattedDate(Utils.getTodayDate())
        if (WifiChecker.isInternetConnected(requireContext())) {
            homeViewModel.getChallenges()
            viewModel.getChallenges(Utils.getTodayDate())
        } else {
            binding.stateTextView.isVisible = true
            Toast.makeText(context, "Нет подключения к интернету", Toast.LENGTH_LONG).show()
        }
        binding.dateSelectTextView.setOnClickListener {
            showDatePickerDialog()
        }
//        binding.loginTextView.setOnClickListener {
//            findNavController().navigate(R.id.action_Auth_to_Login)
//        }
//        viewModel.userIsLogged.observe(viewLifecycleOwner) {
//            if (it) {
//                findNavController().navigate(R.id.action_Auth_to_Home)
//            }
////            when (it) {
////                -1 -> makeToast("Этот логин уже используется")
////
////                -2 -> makeToast("Пользователь с таким именем уже существует")
////                else -> {
////                    findNavController().navigate(R.id.action_Auth_to_Maps)
////                }
////            }
//
//        }
//        binding.registerButton.setOnClickListener {
//            checkingEnteredFields()
//        }
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        pickerManager.showDatePickerDialog(calendar, context) { _, myYear, myMonth, myDay ->
            val date = Utils.convertDate(myDay, myMonth, myYear)
            binding.dateSelectTextView.text = Utils.formattedDate("${myDay}.${myMonth}")
            viewModel.getChallenges(date)


        }
    }


    private fun setUpRecyclerView(challenges: List<Challenge>, userChallenges: List<Challenge>) {
        val recyclerView = binding.challengeList
        val adapter = ChallengesAdapter(challenges, userChallenges, this@ChallengesFragment)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

    override fun onEntryButtonClick(challenge: Challenge) {
        viewModel.setChallenge(challenge)

    }

    override fun onClick(challenge: Challenge) {
        val dialog = object : ChallengeDialogFragment(context, challenge) {}
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.show()

    }

}