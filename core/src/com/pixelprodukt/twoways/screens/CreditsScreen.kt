package com.pixelprodukt.twoways.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.Touchable
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.utils.Scaling
import com.badlogic.gdx.utils.viewport.ScalingViewport
import com.pixelprodukt.twoways.TwoWaysGame
import com.pixelprodukt.twoways.config.GameConfig
import com.ray3k.stripe.FreeTypeSkin
import ktx.app.KtxScreen

class CreditsScreen(private val game: TwoWaysGame) : KtxScreen {

    private val fontskin = FreeTypeSkin(Gdx.files.internal("skin/two_ways_skin_new.json"))

    private val stage = Stage(ScalingViewport(Scaling.fill, GameConfig.VIEWPORT_WIDTH, GameConfig.VIEWPORT_HEIGHT))
    private val layoutTable = Table()
    private val label = Label("Design by pixelprodukt\n\nProgramming by pixelprodukt", fontskin)

    init {
        layoutTable.setFillParent(true)
        layoutTable.debug = false
        layoutTable.width = 800.0f
        layoutTable.touchable = Touchable.enabled
        layoutTable.add(label)
        stage.addActor(layoutTable)
    }

    override fun show() {
        Gdx.input.inputProcessor = stage
    }

    override fun render(delta: Float) {
        stage.act(Gdx.graphics.deltaTime)
        stage.draw()
    }
}