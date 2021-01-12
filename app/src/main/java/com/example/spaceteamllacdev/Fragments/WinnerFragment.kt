package com.example.spaceteamllacdev.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.spaceteamllacdev.R
import kotlinx.android.synthetic.main.fragment_waiting_room.view.*
import kotlinx.android.synthetic.main.fragment_winner.view.*
import timber.log.Timber


/**
 * A simple [Fragment] subclass.
 * Use the [WinnerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WinnerFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.i("onCreate Called")

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
        val view = inflater.inflate(R.layout.fragment_winner, container, false)

        view.button3.setOnClickListener { Navigation.findNavController(view).navigate(R.id.action_winnerFragment_to_looserFragment) }

        return view    }
}