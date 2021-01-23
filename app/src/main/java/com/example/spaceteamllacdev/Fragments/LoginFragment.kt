package com.example.spaceteamllacdev.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.spaceteamllacdev.Models.UserPost
import com.example.spaceteamllacdev.R
import com.example.spaceteamllacdev.SpaceDimApplication
import com.example.spaceteamllacdev.databinding.LoginFragmentBinding
import com.example.spaceteamllacdev.user.UserViewModel
import com.example.spaceteamllacdev.user.UserViewModelFactory
import kotlinx.android.synthetic.main.login_fragment.view.*
import timber.log.Timber


class LoginFragment : Fragment() {
    private lateinit var binding: LoginFragmentBinding

    private val viewModel: UserViewModel by viewModels {
        UserViewModelFactory(SpaceDimApplication.userRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.i("onCreate Called")

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {



        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.login_fragment,
                container,
                false
        )

        binding.userViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.btnLaunch.setOnClickListener {
            val username = binding.usernameInput.text.toString()

            viewModel.connectUser(username)
            Navigation.findNavController(binding.root).navigate(R.id.action_loginFragment_to_waitingRoomFragment)
        }

        binding.btnRegister.setOnClickListener {
            val username = binding.usernameInput.text.toString()
            val newUser = UserPost(username)

            viewModel.addUser(newUser)
            Navigation.findNavController(binding.root).navigate(R.id.action_loginFragment_to_waitingRoomFragment)
        }



        return binding.root
    }

    override fun onStart() {
        super.onStart()

        Timber.i("onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy Called")
    }




}

