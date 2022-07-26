package com.pixelprodukt.twoways.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.pixelprodukt.twoways.TwoWaysGame
import com.pixelprodukt.twoways.config.GameConfig

fun main() {

    val config = LwjglApplicationConfiguration().apply {
        width = GameConfig.WINDOW_WIDTH
        height = GameConfig.WINDOW_HEIGHT
        resizable = GameConfig.RESIZABLE
    }

    LwjglApplication(TwoWaysGame(), config)
}