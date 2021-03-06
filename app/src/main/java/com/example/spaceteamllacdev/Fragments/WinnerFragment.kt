package com.example.spaceteamllacdev.Fragments

import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.example.spaceteamllacdev.GameViewModel
import com.example.spaceteamllacdev.GameViewModelFactory
import com.example.spaceteamllacdev.R
import com.example.spaceteamllacdev.SpaceDimApplication
import com.example.spaceteamllacdev.WebSocket.EchoWebSocketListener
import com.example.spaceteamllacdev.databinding.WaitingRoomFragmentBinding
import com.example.spaceteamllacdev.databinding.WinnerFragmentBinding
import timber.log.Timber


/**
 * A simple [Fragment] subclass.
 * Use the [WinnerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WinnerFragment : Fragment() {

    private lateinit var binding: WinnerFragmentBinding
    private val viewModel: GameViewModel by viewModels {
        GameViewModelFactory(SpaceDimApplication.userRepository, SpaceDimApplication.webSocket)
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
            R.layout.winner_fragment,
            container,
            false
        )

        binding.gameViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.btnRetry.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_winnerFragment_to_waitingRoomFragment)
        }

        viewModel.userRepo.currentUser.observe(viewLifecycleOwner, Observer {
            binding.scoreTxt.text = Html.fromHtml("Your score : <b>${it.score}</b>", Html.FROM_HTML_MODE_COMPACT)
        })

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