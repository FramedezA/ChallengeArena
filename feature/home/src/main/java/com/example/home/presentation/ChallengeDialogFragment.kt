package com.example.home.presentation


import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.home.R
import com.example.home.data.data_structures.Challenge


//class ChallengeDialogFragment(private val challenge: Challenge):
//    DialogFragment() {
//    private lateinit var binding: FragmentDialogChallengeBinding
//
//    lateinit var challengesViewModelFactory: ChallengesViewModelFactory
//    private lateinit var viewModel: ChallengesViewModel
//
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
//    ): View {
//        binding = FragmentDialogChallengeBinding.inflate(layoutInflater)
//        return binding.root
//    }
//
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        challengesViewModelFactory =
//            ChallengesServiceLocator.getService("ChallengesViewModelFactory")!!
//        viewModel =
//            ViewModelProvider(this, challengesViewModelFactory)[ChallengesViewModel::class.java]
//
//    }
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val position = arguments?.getInt("position")!!
//        binding.positiveButton.setOnClickListener {
//            viewModel.deleteEntry(id,position)
//            dismiss()
//        }
//        binding.negativeButton.setOnClickListener {
//            dismiss()
//        }
//    }
//}
abstract class ChallengeDialogFragment(context: Context?,private val challenge: Challenge) :
    Dialog(context!!) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view :View = LayoutInflater.from(context).inflate(R.layout.fragment_dialog_challenge, null)
        setContentView(view)
        setCanceledOnTouchOutside(true)
        setCancelable(true)
        findViewById<TextView>(R.id.titleTextView).text = challenge.title
        findViewById<TextView>(R.id.rulesTextView).text = challenge.rules
        findViewById<TextView>(R.id.descriptionTextView).text = challenge.description
        findViewById<TextView>(R.id.dateTextView).text=challenge.date
        val imageView :ImageView = findViewById(R.id.challengeTypeImageView)
        if (challenge.type == "team"){
            imageView.setImageResource(R.drawable.users_02)
        }
        else{
            imageView.setImageResource(R.drawable.user)
        }

    }



}