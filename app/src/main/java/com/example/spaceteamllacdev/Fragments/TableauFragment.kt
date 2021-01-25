package com.example.spaceteamllacdev.Fragments

import android.animation.ObjectAnimator
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spaceteamllacdev.GameViewModel
import com.example.spaceteamllacdev.GameViewModelFactory
import com.example.spaceteamllacdev.models.EventGame
import com.example.spaceteamllacdev.R
import com.example.spaceteamllacdev.SpaceDimApplication
import com.example.spaceteamllacdev.adapter.UiElementAdapter
import com.example.spaceteamllacdev.databinding.TableauFragmentBinding
import timber.log.Timber


/**
 * A simple [Fragment] subclass.
 * Use the [TableauFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TableauFragment : Fragment() {

    private lateinit var binding: TableauFragmentBinding
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

        val manager = GridLayoutManager(activity, 2, GridLayoutManager.VERTICAL, false)


        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.tableau_fragment,
            container,
            false
        )

        binding.gameViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.elementList.adapter = UiElementAdapter(UiElementAdapter.OnClickListener {
            viewModel.webSocket.SendPlayerAction(it)
        })

        viewModel.getGameState.observe(viewLifecycleOwner, Observer {
            when(it) {
                is EventGame.GameStarted -> {
                    viewModel.setUiElementForLevel(it.uiElementList)

                    binding.txtGalaxy.text = Html.fromHtml("You are currently traveling in the <b>Galaxy 1</b>", Html.FROM_HTML_MODE_COMPACT)
                    binding.progressBarTime.visibility = View.VISIBLE

                }
                is EventGame.NextAction -> {
                    binding.progressBarTime.setProgress(0,false)
                    ObjectAnimator.ofInt(binding.progressBarTime,"progress",100)
                        .setDuration(it.action.time)
                        .start()
                    binding.txtMission.text = it.action.sentence
                }
                is EventGame.NextLevel -> {
                    viewModel.setUiElementForLevel(it.uiElementList)

                    binding.txtGalaxy.text = Html.fromHtml("You are currently traveling in the <b>Galaxy ${it.level}</b>", Html.FROM_HTML_MODE_COMPACT)
                }
                is EventGame.GameOver -> {
//                    viewModel.setGameOverValue(it)
//                    println(viewModel.getGameOverValues().value)
                    viewModel.userRepo.currentUser.value?.score = it.score
                    if (it.win) {
                        Navigation.findNavController(binding.root).navigate(R.id.action_tableauFragment_to_winnerFragment)
                    } else {
                        Navigation.findNavController(binding.root).navigate(R.id.action_tableauFragment_to_looserFragment)
                    }
                }
            }
        })

        viewModel.getUIElementsForLevel().observe(viewLifecycleOwner, Observer {
            it.forEach {
                println(it)

            }
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