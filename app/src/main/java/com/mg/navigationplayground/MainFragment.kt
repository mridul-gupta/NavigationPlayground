package com.mg.navigationplayground

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.google.android.material.transition.Hold
import com.mg.navigationplayground.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    var navController: NavController? = null

    private lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        exitTransition = Hold()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        binding.viewTransactionsBtn.setOnClickListener {
            val transitionName = getString(R.string.transition_main_to_view_transaction)
            it.transitionName = transitionName

            navController!!.navigate(
                resId = R.id.action_mainFragment_to_viewTransactionFragment,
                args = null,
                navOptions = null,
                navigatorExtras = FragmentNavigatorExtras(
                    it to transitionName
                )
            )
        }

        binding.sendMoneyBtn.setOnClickListener {
            navController!!.navigate(R.id.action_mainFragment_to_chooseRecipientFragment)
        }

        binding.viewBalanceBtn.setOnClickListener {
            navController!!.navigate(R.id.action_mainFragment_to_viewBalanceFragment)
        }
    }

}