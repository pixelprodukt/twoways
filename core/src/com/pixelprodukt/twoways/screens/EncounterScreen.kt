package com.pixelprodukt.twoways.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.Touchable
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.Scaling
import com.badlogic.gdx.utils.viewport.ScalingViewport
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.pixelprodukt.twoways.TwoWaysGame
import com.pixelprodukt.twoways.config.Assets
import com.pixelprodukt.twoways.config.EncounterConfig
import com.pixelprodukt.twoways.config.GameConfig
import com.pixelprodukt.twoways.enums.View
import com.ray3k.stripe.FreeTypeSkin
import ktx.app.KtxScreen
import ktx.app.clearScreen
import ktx.graphics.use

class EncounterScreen(private val game: TwoWaysGame) : KtxScreen {

    companion object {
        private const val CURRENT_TEXT_MARGIN_LEFT = 12.0f
        private const val CONTENT_WIDTH = 900.0f
        private const val LABEL_X_POSITION = (GameConfig.VIEWPORT_WIDTH - CONTENT_WIDTH) / 2
        private const val LABEL_Y_POSITION = 760.0f
        private const val TEXT_X_POSITION = ((GameConfig.VIEWPORT_WIDTH - CONTENT_WIDTH) / 2) + CURRENT_TEXT_MARGIN_LEFT
        private const val TEXT_Y_POSITION = 710.0f
    }

    private val backgroundTexture = Texture(Assets.ENCOUNTER_BACKGROUND_IMG)
    private val stage = Stage(ScalingViewport(Scaling.fill, GameConfig.VIEWPORT_WIDTH, GameConfig.VIEWPORT_HEIGHT))
    private val label = Label("empty", game.fontskin)
    private val mapper = jacksonObjectMapper()
    private val fileHandle  = Gdx.files.internal("configs/test.json")
    private val encounterConfig: List<EncounterConfig> = mapper.readValue(fileHandle.read())
    private var currentText = "empty"

    init {
        Gdx.app.log("EncounterScreen", "${encounterConfig}")
        game.fontskin.getFont("Lato-Regular").data.lineHeight = 2.2f
        initEncounter(encounterConfig[0])
    }

    private fun initEncounter(config: EncounterConfig) {
        stage.clear()
        label.setText(config.title)
        currentText = config.text
        initLayout()
        initButtons(config)
    }

    private fun initButtons(config: EncounterConfig) {

        val btnXPadding = 16.0f
        val btnYPadding = 12.0f
        var yPos = 230.0f

        config.choices.forEach { choice ->
            val btn = TextButton(choice.label, game.fontskin)
            btn.x = (GameConfig.VIEWPORT_WIDTH - label.width) / 2
            btn.y = yPos
            btn.width = btn.width + btnXPadding
            btn.height = btn.height + btnYPadding
            stage.addActor(btn)
            yPos -= btn.height

            btn.addListener(object: ClickListener() {
                override fun clicked(event: InputEvent?, x: Float, y: Float) {
                    super.clicked(event, x, y)
                    Gdx.app.log("EncounterScreen", "clicked button: ${btn.label}")
                }
            })
        }
    }

    private fun initLayout() {
        label.wrap = true
        label.width = CONTENT_WIDTH
        label.x = LABEL_X_POSITION
        label.y = LABEL_Y_POSITION
        stage.addActor(label)
    }

    override fun show() {
        Gdx.input.inputProcessor = stage
    }

    override fun render(delta: Float) {
        game.batch.use { batch ->
            batch.draw(backgroundTexture, 0.0f, 0.0f)
            game.fontskin.getFont("Lato-Regular")
                .draw(batch, currentText, TEXT_X_POSITION, TEXT_Y_POSITION, CONTENT_WIDTH, Align.left, true)
        }
        stage.act(Gdx.graphics.deltaTime)
        stage.draw()
    }
}