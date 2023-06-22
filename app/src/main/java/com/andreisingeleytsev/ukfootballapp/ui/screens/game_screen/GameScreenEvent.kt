package com.andreisingeleytsev.ukfootballapp.ui.screens.game_screen

sealed class GameScreenEvent{
    object OnFootballTap: GameScreenEvent()
    object OnBack: GameScreenEvent()
    object OnStart: GameScreenEvent()
    object OnPlayAgain: GameScreenEvent()
}
