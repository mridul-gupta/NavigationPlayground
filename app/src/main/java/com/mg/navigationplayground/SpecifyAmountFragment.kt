package com.mg.navigationplayground

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.mg.navigationplayground.databinding.FragmentSpecifyAmountBinding

class SpecifyAmountFragment : Fragment() {

    private var navController: NavController? = null

    private lateinit var binding: FragmentSpecifyAmountBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSpecifyAmountBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        binding.sendBtn.setOnClickListener {
            navController!!.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment)
        }

        binding.cancelBtn.setOnClickListener {
            navController!!.popBackStack()
        }
    }
}