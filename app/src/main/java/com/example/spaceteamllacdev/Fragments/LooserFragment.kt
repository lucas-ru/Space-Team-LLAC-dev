package com.example.spaceteamllacdev.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.spaceteamllacdev.GameViewModel
import com.example.spaceteamllacdev.GameViewModelFactory
import com.example.spaceteamllacdev.R
import com.example.spaceteamllacdev.SpaceDimApplication
import com.example.spaceteamllacdev.WebSocket.EchoWebSocketListener
import com.example.spaceteamllacdev.databinding.LooserFragmentBinding
import com.example.spaceteamllacdev.databinding.WaitingRoomFragmentBinding
import timber.log.Timber


/**
 * A simple [Fragment] subclass.
 * Use the [LooserFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LooserFragment : Fragment() {

    private lateinit var binding: LooserFragmentBinding
    private val viewModel: GameViewModel by viewModels {
        GameViewModelFactory(SpaceDimApplication.userRepository, EchoWebSocketListener())
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
            R.layout.looser_fragment,
            container,
            false
        )

        binding.gameViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

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