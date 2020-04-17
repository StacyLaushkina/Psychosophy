package com.laushkina.anastasia.psychosophy.view.introduction

class IntroductionViewModel(var psychosophyDefinition: CharSequence,
                            var psychosophyBases: CharSequence,
                            var personalitiesDescription: CharSequence,
                            var relationshipsDescription: CharSequence) {
    constructor(): this("", "", "", "")
}