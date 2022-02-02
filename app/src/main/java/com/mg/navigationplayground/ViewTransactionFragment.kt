package com.mg.navigationplayground

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.transition.Hold
import com.google.android.material.transition.MaterialContainerTransform
import com.mg.navigationplayground.databinding.FragmentViewTransactionBinding

class ViewTransactionFragment : Fragment() {

    companion object {
        const val TRANSITION_NAME = "TRANSITION_NAME"
    }

    private lateinit var transitionName: String

    private lateinit var binding : FragmentViewTransactionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        exitTransition = Hold()

        transitionName = arguments?.getString(TRANSITION_NAME) ?: ""
        sharedElementEnterTransition = MaterialContainerTransform()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewTransactionBinding.inflate(layoutInflater)
        binding.root.transitionName = transitionName
        transitionName = arguments?.getString(TRANSITION_NAME) ?: ""
        sharedElementEnterTransition = MaterialContainerTransform()
        binding.root.transitionName = transitionName

        return binding.root
    }
}