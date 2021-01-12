package com.example.spaceteamllacdev.Models

data class Action(
        val sentence: String,
        val uiElement: UIElement,
        val time: Long = 8000
)