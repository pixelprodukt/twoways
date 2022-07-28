package com.pixelprodukt.twoways

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.pixelprodukt.twoways.config.Assets
import com.pixelprodukt.twoways.enums.View
import com.pixelprodukt.twoways.screens.CreditsScreen
import com.pixelprodukt.twoways.screens.EncounterScreen
import com.pixelprodukt.twoways.screens.MainMenuScreen
import com.ray3k.stripe.FreeTypeSkin
import ktx.app.clearScreen

class TwoWaysGame : Game() {

    lateinit var fontskin: FreeTypeSkin
    lateinit var batch: SpriteBatch

    lateinit var mainMenuScreen: MainMenuScreen
    lateinit var encounterScreen: EncounterScreen
    lateinit var creditsScreen: CreditsScreen

    override fun create() {
        fontskin = FreeTypeSkin(Gdx.files.internal(Assets.SKIN))
        batch = SpriteBatch()

        mainMenuScreen = MainMenuScreen(this)
        encounterScreen = EncounterScreen(this)
        creditsScreen = CreditsScreen(this)
        setScreen(mainMenuScreen)
    }

    fun changeScreenTo(view: View) {
        when (view) {
            View.ENCOUNTER  -> setScreen(encounterScreen)
            View.CREDITS    -> setScreen(creditsScreen)
        }
    }

    override fun setScreen(screen: Screen?) {
        super.setScreen(screen)
    }

    override fun render() {
        clearScreen(143f / 255f, 159f / 255f, 159f / 255f, 1f)
        screen.render(Gdx.graphics.deltaTime)

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) setScreen(mainMenuScreen)
    }
}