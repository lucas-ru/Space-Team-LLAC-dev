package com.example.spaceteamllacdev.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.spaceteamllacdev.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_waiting_room.*
import kotlinx.android.synthetic.main.fragment_waiting_room.view.*
import timber.log.Timber


/**
 * A simple [Fragment] subclass.
 * Use the [WaitingRoomFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WaitingRoomFragment : Fragment() {

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
        val view = inflater.inflate(R.layout.fragment_waiting_room, container, false)

        view.button4.setOnClickListener { Navigation.findNavController(view).navigate(R.id.action_waitingRoomFragment_to_tableauFragment) }

        return view
    }

}