package com.example.spaceteamllacdev.Fragments

import android.os.Bundle
import android.text.Html
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.spaceteamllacdev.GameViewModel
import com.example.spaceteamllacdev.GameViewModelFactory
import com.example.spaceteamllacdev.Models.EventGame
import com.example.spaceteamllacdev.Models.EventType
import com.example.spaceteamllacdev.Models.PolymorphicAdapter.eventGameParser
import com.example.spaceteamllacdev.R
import com.example.spaceteamllacdev.SpaceDimApplication
import com.example.spaceteamllacdev.WebSocket.EchoWebSocketListener
import com.example.spaceteamllacdev.databinding.WaitingRoomFragmentBinding
import timber.log.Timber


/**
 * A simple [Fragment] subclass.
 * Use the [WaitingRoomFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WaitingRoomFragment : Fragment() {

    private lateinit var binding: WaitingRoomFragmentBinding
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
            R.layout.waiting_room_fragment,
            container,
            false
        )

        binding.gameViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner


        viewModel.userRepo.currentUser.observe(viewLifecycleOwner, Observer {
            viewModel.onLaunch()
            binding.socketUnconnect.visibility = View.GONE
            binding.socketConnect.visibility = View.VISIBLE
            binding.labelRoom.text = Html.fromHtml("Room : <b>LLAC</b>  Username : <b>${viewModel.userRepo.currentUser.value?.name}</b>",Html.FROM_HTML_MODE_COMPACT)
        })

        viewModel.GameState.observe(viewLifecycleOwner, Observer<EventType> {
            when(it) {
                EventType.READY -> {
                    viewModel.webSocket.SendPlayerReady()
                    binding.btnReady.visibility = View.GONE
//                    viewModel.webSocket.webSocket?.send("{\"type\":\"READY\", \"value\":true}")
                }
            }
        })

        viewModel.getGameState.observe(viewLifecycleOwner, Observer {
            when(it) {
                is EventGame.WaitingForPlayer -> {
                    binding.layoutPlayer.removeAllViews()
                    it.userList.forEach {
                        val usercard = inflater.inflate(R.layout.user_card,null) as CardView

                        usercard.findViewById<TextView>(R.id.username).text = it.name
                        usercard.findViewById<TextView>(R.id.userState).text = it.state.toString()

                        binding.layoutPlayer.addView(usercard)
                        println(it.name + " " + it.state)
                    }
                }
            }
        })

        //view.btnReady.setOnClickListener { Navigation.findNavController(view).navigate(R.id.action_waitingRoomFragment_to_tableauFragment) }
//        view.btnReady.setOnClickListener { userIsReady() }

        binding.btnReady.setOnClickListener {
            viewModel.setUserReady()
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

    fun userIsReady(){
        viewModel.setUserReady()
    }

}