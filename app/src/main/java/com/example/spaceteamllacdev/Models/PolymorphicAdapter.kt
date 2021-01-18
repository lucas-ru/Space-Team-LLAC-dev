package com.example.spaceteamllacdev.Models

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory


object PolymorphicAdapter {

    private val moshiEventSerializer: Moshi = with(Moshi.Builder()) {
        add(
            PolymorphicJsonAdapterFactory.of(EventGame::class.java,"type")
                .withSubtype(EventGame.Ready::class.java, EventType.READY.name)
                .withSubtype(EventGame.Error::class.java, EventType.ERROR.name)
                .withSubtype(EventGame.GameOver::class.java, EventType.GAME_OVER.name)
                .withSubtype(EventGame.GameStarted::class.java, EventType.GAME_STARTED.name)
                .withSubtype(EventGame.NextAction::class.java, EventType.NEXT_ACTION.name)
                .withSubtype(EventGame.NextLevel::class.java, EventType.NEXT_LEVEL.name)
                .withSubtype(EventGame.PlayerAction::class.java, EventType.PLAYER_ACTION.name)
                .withSubtype(EventGame.WaitingForPlayer::class.java, EventType.WAITING_FOR_PLAYER.name)
        )

        add(
                PolymorphicJsonAdapterFactory.of(UIElement::class.java,"type")
                        .withSubtype(UIElement.Button::class.java, UIType.BUTTON.name)
                        .withSubtype(UIElement.Shake::class.java, UIType.SHAKE.name)
                        .withSubtype(UIElement.Switch::class.java, UIType.SWITCH.name)
        )


        add(KotlinJsonAdapterFactory())
        build()
    }

    /*private val moshiUIelementSerializer: Moshi = with(Moshi.Builder()) {
        add(
            PolymorphicJsonAdapterFactory.of(UIElement::class.java,"type")
                .withSubtype(UIElement.Button::class.java, UIType.BUTTON.name)
                .withSubtype(UIElement.Shake::class.java, UIType.SHAKE.name)
                .withSubtype(UIElement.Switch::class.java, UIType.SWITCH.name)
        )

        add(KotlinJsonAdapterFactory())
        build()
    }*/

    val eventGameParser: JsonAdapter<EventGame> = moshiEventSerializer.adapter(EventGame::class.java)

    //val UIElementParser: JsonAdapter<UIElement> = moshiUIelementSerializer.adapter(UIElement::class.java)
}