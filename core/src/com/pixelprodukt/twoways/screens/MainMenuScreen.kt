package com.pixelprodukt.twoways.screens

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.Touchable
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.Scaling
import com.badlogic.gdx.utils.viewport.ScalingViewport
import com.pixelprodukt.twoways.TwoWaysGame
import com.pixelprodukt.twoways.config.GameConfig
import com.pixelprodukt.twoways.enums.View
import com.ray3k.stripe.FreeTypeSkin
import ktx.app.KtxScreen

class MainMenuScreen(private val game: TwoWaysGame) : KtxScreen {

    private val fontskin = FreeTypeSkin(Gdx.files.internal("skin/two_ways_skin_new.json"))

    private val stage = Stage(ScalingViewport(Scaling.fill, GameConfig.VIEWPORT_WIDTH, GameConfig.VIEWPORT_HEIGHT))
    private val layoutTable = Table()

    private val btnStart = ImageTextButton("Start", fontskin)
    private val btnLoad = ImageTextButton("Load", fontskin)
    private val btnOptions = ImageTextButton("Options", fontskin)
    private val btnCredits = ImageTextButton("Credits", fontskin)

    init {
        initMenuLayout()
        initButtonListener()
    }

    private fun initButtonListener() {
        btnStart.addListener(object: ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                super.clicked(event, x, y)
                game.changeScreenTo(View.ENCOUNTER)
            }
        })
        btnCredits.addListener(object: ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                super.clicked(event, x, y)
                game.changeScreenTo(View.CREDITS)
            }
        })
    }

    private fun initMenuLayout() {
        layoutTable.setFillParent(true)
        layoutTable.debug = false
        layoutTable.width = 800.0f
        layoutTable.touchable = Touchable.enabled
        layoutTable.add(btnStart).align(Align.center).fill().padBottom(12.0f).width(240.0f)
        layoutTable.row()
        layoutTable.add(btnLoad).align(Align.center).fill().padBottom(12.0f).width(240.0f)
        layoutTable.row()
        layoutTable.add(btnOptions).align(Align.center).fill().padBottom(12.0f).width(240.0f)
        layoutTable.row()
        layoutTable.add(btnCredits).align(Align.center).fill().padBottom(12.0f).width(240.0f)
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