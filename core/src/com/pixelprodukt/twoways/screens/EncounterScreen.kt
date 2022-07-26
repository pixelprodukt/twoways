package com.pixelprodukt.twoways.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.utils.Scaling
import com.badlogic.gdx.utils.viewport.ScalingViewport
import com.pixelprodukt.twoways.TwoWaysGame
import com.pixelprodukt.twoways.config.GameConfig
import com.ray3k.stripe.FreeTypeSkin
import ktx.app.KtxScreen

class EncounterScreen(private val game: TwoWaysGame) : KtxScreen {

    private val fontskin = FreeTypeSkin(Gdx.files.internal("skin/two_ways_skin_new.json"))

    private val stage = Stage(ScalingViewport(Scaling.fill, GameConfig.VIEWPORT_WIDTH, GameConfig.VIEWPORT_HEIGHT))
    private val layoutTable = Table()

    override fun show() {
        Gdx.input.inputProcessor = stage
    }

    override fun render(delta: Float) {
        stage.act(Gdx.graphics.deltaTime)
        stage.draw()
    }
}