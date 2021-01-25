package com.example.spaceteamllacdev.models

data class Action(
        val sentence: String,
        val uiElement: UIElement,
        val time: Long = 8000
)