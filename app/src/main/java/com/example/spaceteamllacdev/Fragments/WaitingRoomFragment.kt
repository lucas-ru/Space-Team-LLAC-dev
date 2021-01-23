package com.example.spaceteamllacdev.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.spaceteamllacdev.GameViewModel
import com.example.spaceteamllacdev.Models.EventGame
import com.example.spaceteamllacdev.R
import com.example.spaceteamllacdev.databinding.WaitingRoomFragmentBinding
import kotlinx.android.synthetic.main.activity_login.*
import timber.log.Timber


/**
 * A simple [Fragment] subclass.
 * Use the [WaitingRoomFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WaitingRoomFragment : Fragment() {

    private lateinit var binding: WaitingRoomFragmentBinding
    private lateinit var viewModel: GameViewModel

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
            R.layout.waiting_room_fragment,
            container,
            false
        )

        binding.gameViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.isReady.observe(viewLifecycleOwner, Observer { newReady ->
            Timber.i("mon eventgame est passé à true")
        })

        //view.btnReady.setOnClickListener { Navigation.findNavController(view).navigate(R.id.action_waitingRoomFragment_to_tableauFragment) }
//        view.btnReady.setOnClickListener { userIsReady() }

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

    fun userIsReady(){
        viewModel.setUserReady()
    }

}