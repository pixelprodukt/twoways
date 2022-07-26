package com.pixelprodukt.twoways.config

data class EncounterConfig(val text: String, val choices: List<Choice>)

data class Choice(val label: String, val outcomes: List<String>)