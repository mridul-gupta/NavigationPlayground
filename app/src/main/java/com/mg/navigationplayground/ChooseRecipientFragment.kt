package com.mg.navigationplayground

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.mg.navigationplayground.databinding.FragmentChooseRecipientBinding

class ChooseRecipientFragment : Fragment() {
    var navController: NavController? = null

    private lateinit var binding: FragmentChooseRecipientBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentChooseRecipientBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        binding.nextBtn.setOnClickListener {
            navController!!.navigate(R.id.action_chooseRecipientFragment_to_specifyAmountFragment)
        }

        binding.cancelBtn.setOnClickListener {
            activity?.onBackPressed()
        }
    }
}