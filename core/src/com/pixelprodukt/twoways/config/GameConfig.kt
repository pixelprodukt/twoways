package com.pixelprodukt.twoways.config

object GameConfig {
    const val WINDOW_WIDTH =  1640
    const val WINDOW_HEIGHT = 920

    const val SCALE_FACTOR = 1

    const val VIEWPORT_WIDTH = (WINDOW_WIDTH / SCALE_FACTOR).toFloat()
    const val VIEWPORT_HEIGHT = (WINDOW_HEIGHT / SCALE_FACTOR).toFloat()

    const val RESIZABLE = false
}