package com.example.profile.presentation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import com.example.profile.R
import com.example.profile.data.data_structures.Profile
import com.example.profile.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    lateinit var profileViewModelFactory: ProfileViewModelFactory
    private lateinit var viewModel: ProfileViewModel
    private lateinit var profile: Profile

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        profileViewModelFactory = ProfileServiceLocator.getService("profileViewModelFactory")!!
        viewModel =
            ViewModelProvider(this, profileViewModelFactory)[ProfileViewModel::class.java]

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getProfile()
        viewModel.profile.observe(viewLifecycleOwner) {
            profile = it
            setupProfile()

        }
    }

    override fun onPause() {
        super.onPause()
        if (::profile.isInitialized ){
        viewModel.setProfile(profile)
        }
    }

    fun setupProfile(){
        binding.nameEditText.setText(profile.name)
        binding.ageEditText.setText(profile.age.toString())
        binding.aboutEditText.setText(profile.description)
        binding.goalsEditText.setText(profile.goals)
        if(profile.sex == 1){
            binding.profilePhoto.setImageResource(R.drawable.man)

            binding.manRadioButton.isChecked = true
            binding.womanRadioButton.isChecked = false
        }
        else{
            binding.profilePhoto.setImageResource(R.drawable.woooooman)

            binding.manRadioButton.isChecked = false
            binding.womanRadioButton.isChecked = true
        }

        binding.nameEditText.doOnTextChanged { text, _, _, _ ->
            profile.name = text.toString().trim()

        }

        binding.ageEditText.doOnTextChanged { text, _, _, _ ->
            if(text.toString().isNotEmpty()){
                profile.age = text.toString().trim().toInt()

            }
            else{
                profile.age = 0
            }
        }
        binding.aboutEditText.doOnTextChanged { text, _, _, _ ->
            profile.description = text.toString().trim()

        }
        binding.goalsEditText.doOnTextChanged { text, _, _, _ ->
            profile.goals = text.toString().trim()
        }


        binding.manRadioButton.setOnClickListener {
            profile.sex = 1
            binding.womanRadioButton.isChecked = false
            binding.profilePhoto.setImageResource(R.drawable.man)



        }
        binding.womanRadioButton.setOnClickListener {
            profile.sex = 0
            binding.manRadioButton.isChecked = false
            binding.profilePhoto.setImageResource(R.drawable.woooooman)

        }
    }
}