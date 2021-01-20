package com.example.spaceteamllacdev.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.spaceteamllacdev.GameViewModel
import com.example.spaceteamllacdev.R
import kotlinx.android.synthetic.main.fragment_login.view.*
import timber.log.Timber


class LoginFragment : Fragment() {
    private lateinit var viewModel: GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.i("onCreate Called")

        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)
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



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        view.btnLaunch.setOnClickListener {
            Timber.i("nickname: " + view.editName.text)
            viewModel.onLaunch()
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_waitingRoomFragment)
        }

        return view
    }
}

