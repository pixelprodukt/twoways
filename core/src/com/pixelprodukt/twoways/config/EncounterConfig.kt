package com.pixelprodukt.twoways.config

data class EncounterConfig(val title: String, val text: String, val choices: List<Choice>)

data class Choice(val label: String, val type: ChoiceType, val configuration: ChoiceConfiguration)

data class ChoiceConfiguration(val text: String)

enum class ChoiceType {
    BATTLE,
    ESCAPE
}