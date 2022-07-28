package com.pixelprodukt.twoways.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
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
import com.pixelprodukt.twoways.config.Assets
import com.pixelprodukt.twoways.config.GameConfig
import com.pixelprodukt.twoways.enums.View
import com.ray3k.stripe.FreeTypeSkin
import ktx.app.KtxScreen
import ktx.graphics.use

class MainMenuScreen(private val game: TwoWaysGame) : KtxScreen {

    private val stage = Stage(ScalingViewport(Scaling.fill, GameConfig.VIEWPORT_WIDTH, GameConfig.VIEWPORT_HEIGHT))
    private val layoutTable = Table()

    private val btnStart = ImageTextButton("Start", game.fontskin)
    private val btnLoad = ImageTextButton("Load", game.fontskin)
    private val btnOptions = ImageTextButton("Options", game.fontskin)
    private val btnCredits = ImageTextButton("Credits", game.fontskin)

    private val titleTexture = Texture(Assets.TITLE_FONT_IMG)
    private val mainmenuBackgroundTexture = Texture(Assets.TITLE_BACKGROUND_IMG)

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
        game.batch.use { batch ->
            batch.draw(mainmenuBackgroundTexture, 0.0f, 0.0f)
            batch.draw(titleTexture, (GameConfig.VIEWPORT_WIDTH - titleTexture.width) / 2, 700.0f)
        }
        stage.act(Gdx.graphics.deltaTime)
        stage.draw()
    }
}