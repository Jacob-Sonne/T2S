package com.sonne.t2s.service

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sonne.t2s.data.ColorTheme

object ThemeManager {
    private val _currentColors = MutableLiveData<ColorTheme>(LightColors)
    val currentColors: LiveData<ColorTheme> = _currentColors

    fun switchTheme(newColors: ColorTheme) {
        _currentColors.value = newColors
    }
}
