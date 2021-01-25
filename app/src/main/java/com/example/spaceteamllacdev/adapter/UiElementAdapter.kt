package com.example.spaceteamllacdev.adapter

import android.content.Context
import android.hardware.SensorManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ListMenuItemView
import androidx.compose.ui.viewinterop.viewModel
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.spaceteamllacdev.Fragments.TableauFragment
import com.example.spaceteamllacdev.models.UIElement
import com.example.spaceteamllacdev.databinding.UiElementCardBinding
import com.squareup.seismic.ShakeDetector
import kotlinx.android.synthetic.main.ui_element_card.view.*

class UiElementAdapter(private val onClickListener: OnClickListener) :
    ShakeDetector.Listener,
    ListAdapter<UIElement,UiElementAdapter.UiElementPropertyViewHolder>(DiffCallback){

    private lateinit var shakeDetector: ShakeDetector

    private lateinit var onShakeListener : OnShakeListener


    class UiElementPropertyViewHolder(private var binding: UiElementCardBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(uiElementProperty: UIElement) {
            binding.property = uiElementProperty
            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<UIElement>() {
        override fun areItemsTheSame(oldItem: UIElement, newItem: UIElement): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: UIElement, newItem: UIElement): Boolean {
            return oldItem.id == newItem.id
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): UiElementPropertyViewHolder {
        return UiElementPropertyViewHolder(UiElementCardBinding.inflate(LayoutInflater.from(parent.context)))
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: UiElementPropertyViewHolder, position: Int) {
        val uiElementProperty = getItem(position)

        when(uiElementProperty) {
            is UIElement.Button -> {
                holder.itemView.actionBtn.visibility = View.VISIBLE
                holder.itemView.actionBtn.text = uiElementProperty.content
                holder.itemView.actionBtn.setOnClickListener {
                    onClickListener.onClick(uiElementProperty)
                }
            }
            is UIElement.Switch -> {
                holder.itemView.actionSwitch.visibility = View.VISIBLE
                holder.itemView.actionSwitch.text = uiElementProperty.content
                holder.itemView.actionSwitch.setOnClickListener {
                    onClickListener.onClick(uiElementProperty)
                }
            }
            is UIElement.Shake -> {
                shakeDetector = ShakeDetector(this)

                val sensorManager = holder.itemView.context.getSystemService(Context.SENSOR_SERVICE) as SensorManager?
                shakeDetector.start(sensorManager)

                 onShakeListener = OnShakeListener {
                    onShakeListener.onshake(it)
                }
            }
        }

        holder.bind(uiElementProperty)
    }


    class OnClickListener(val clickListener: (uiElementProperty:UIElement) -> Unit) {
        fun onClick(uiElementProperty:UIElement) = clickListener(uiElementProperty)
    }

    class OnShakeListener(val shakeListener: (uiElementProperty:UIElement) -> Unit) {
        fun onshake(uiElementProperty:UIElement) = shakeListener(uiElementProperty)
    }

    override fun hearShake() {
        println(onShakeListener)
    }
}