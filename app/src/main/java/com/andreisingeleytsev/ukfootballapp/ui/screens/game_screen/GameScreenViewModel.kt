package com.andreisingeleytsev.ukfootballapp.ui.screens.game_screen

import android.os.CountDownTimer
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreisingeleytsev.ukfootballapp.R
import com.andreisingeleytsev.ukfootballapp.ui.utils.UIEvents
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class GameScreenViewModel: ViewModel() {
    private val _uiEvent = Channel<UIEvents>()
    val uiEvent = _uiEvent.receiveAsFlow()
    fun onEvent(event: GameScreenEvent){
        when(event) {
            is GameScreenEvent.OnBack -> {
                sendUIEvent(UIEvents.OnBack)
            }
            is GameScreenEvent.OnFootballTap -> {
                if (!isTaped){
                    isTaped = true
                    img.value = footballer
                    object : CountDownTimer(300, 1000){
                        override fun onTick(p0: Long) {

                        }

                        override fun onFinish() {
                            img.value = footballerStand
                            isTaped = false
                        }
                    }.start()
                }

            }
            is GameScreenEvent.OnStart -> {
                isStart.value = false
                ballMoving()
            }
            is GameScreenEvent.OnPlayAgain -> {

                ballMoving()
            }
        }
    }
    private fun sendUIEvent(event: UIEvents){
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
    private val footballer = R.drawable.footballer
    private val footballerStand = R.drawable.footballer_stand
    val img = mutableStateOf(footballerStand)
    val yOffset = mutableStateOf((-93).dp)
    val score = mutableStateOf(0)
    var isTaped = false
    val isGameOn = mutableStateOf(false)
    val isStart = mutableStateOf(true)
    var ySpeed = -20
    val timer = object : CountDownTimer(300000, 25){
        override fun onTick(p0: Long) {
            yOffset.value+=ySpeed.dp
            speedChange()
            checkRicochet()
        }

        override fun onFinish() {

        }

    }

    private fun checkRicochet() {
        val newY = yOffset.value+ySpeed.dp
        if (isTaped) {
            if ((-93.dp) in yOffset.value..newY) {
                ySpeed = -20
                score.value+=1
                return
            }
        }
        if (newY>0.dp) {
            endGame()
        }
    }

    private fun endGame() {
        Log.d("tag", "check")
        timer.cancel()
        isGameOn.value = false
    }

    private fun ballMoving() {
        score.value = 0
        ySpeed = -20
        yOffset.value = (-93).dp
        isGameOn.value = true
        timer.start()
    }
    private fun speedChange(){
        ySpeed++
    }
}