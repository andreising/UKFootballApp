package com.andreisingeleytsev.ukfootballapp.ui.screens.game_screen

import android.view.MotionEvent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.andreisingeleytsev.ukfootballapp.R
import com.andreisingeleytsev.ukfootballapp.ui.theme.MainColor
import com.andreisingeleytsev.ukfootballapp.ui.theme.PrimaryColor
import com.andreisingeleytsev.ukfootballapp.ui.utils.Fonts
import com.andreisingeleytsev.ukfootballapp.ui.utils.UIEvents

@Composable
fun GameScreen(navHostController: NavHostController, viewModel: GameScreenViewModel = hiltViewModel()) {
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { uiEvent ->
            when(uiEvent) {
                is UIEvents.OnBack ->{
                    navHostController.popBackStack()
                }
            }
        }
    }
    Box(Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.game_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(modifier = Modifier
            .fillMaxSize()
            .background(MainColor.copy(alpha = 0.5f)))
        Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Row(
                Modifier
                    .padding(start = 10.dp, top = 24.dp, end = 10.dp)
                    .fillMaxWidth()
                    .height(50.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier.wrapContentSize(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    IconButton(onClick = {
                        viewModel.onEvent(GameScreenEvent.OnBack)
                    }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = null,
                            modifier = Modifier.size(300.dp),
                            tint = Color.White
                        )
                    }
                }
                Box(
                    modifier = Modifier.wrapContentSize(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    IconButton(onClick = {

                    }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = null,
                            modifier = Modifier.size(20.dp),
                            tint = Color.White
                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .padding(start = 88.dp, end = 88.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                if (viewModel.isGameOn.value) IsGoing()
                else NotStarted()
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun IsGoing(viewModel: GameScreenViewModel = hiltViewModel()) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 45.dp),
        shape = RoundedCornerShape(45.dp)
    ) {
        Row(
            modifier = Modifier
                .background(Color.Black)
                .padding(start = 35.dp, end = 40.dp, top = 10.dp, bottom = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ball),
                contentDescription = null,
                modifier = Modifier.size(52.dp)
            )
            Text(
                text = viewModel.score.value.toString(), style = TextStyle(
                    fontSize = 40.sp, color = Color.White, fontFamily = Fonts.customFontFamily,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
    Box(
        modifier = Modifier
            .padding(bottom = 40.dp)
            .height(330.dp),
        contentAlignment = Alignment.BottomStart
    ) {
        Image(
            painter = painterResource(id = viewModel.img.value),
            contentDescription = null,
            modifier = Modifier
                .padding(end = 60.dp)
                .width(143.dp)
                .pointerInteropFilter {
                    when (it.action) {
                        MotionEvent.ACTION_DOWN -> {
                            viewModel.onEvent(GameScreenEvent.OnFootballTap)
                        }
                    }
                    true
                },
            contentScale = ContentScale.FillHeight
        )
        Image(
            painter = painterResource(id = R.drawable.ball),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .offset(x = 97.dp, y = viewModel.yOffset.value)
        )
    }
}

@Composable
fun NotStarted(viewModel: GameScreenViewModel = hiltViewModel()) {
    Column(
        Modifier
            .padding(top = 100.dp, start = 25.dp, end = 25.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (viewModel.isStart.value) {
            Button(
                onClick = {
                          viewModel.onEvent(GameScreenEvent.OnStart)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 125.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                )
            ) {
                Text(
                    text = "START!", style = TextStyle(
                        fontSize = 25.sp, color = MainColor, fontFamily = Fonts.customFontFamily,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        } else {
            Finish()
        }
    }
}

@Composable
fun Finish(viewModel: GameScreenViewModel = hiltViewModel()) {
    Text(
        text = "SCORE", style = TextStyle(
            fontSize = 25.sp, color = Color.White, fontFamily = Fonts.customFontFamily,
            fontWeight = FontWeight.Bold
        )
    )
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
            ,
        shape = RoundedCornerShape(45.dp)
    ) {
        Row(
            modifier = Modifier
                .background(Color.Black)
                .padding(top = 10.dp, bottom = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ball),
                contentDescription = null,
                modifier = Modifier
                    .size(52.dp)
                    .padding(start = 20.dp)
            )
            Text(
                text = viewModel.score.value.toString(), style = TextStyle(
                    fontSize = 40.sp, color = Color.White, fontFamily = Fonts.customFontFamily,
                    fontWeight = FontWeight.Bold
                ), modifier = Modifier.padding(end = 20.dp)
            )
        }
    }
    Button(
        onClick = {
            viewModel.onEvent(GameScreenEvent.OnPlayAgain)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 60.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White
        )
    ) {
        Text(
                text = "PLAY AGAIN", style = TextStyle(
                fontSize = 25.sp, color = MainColor, fontFamily = Fonts.customFontFamily,
                fontWeight = FontWeight.Bold
            )
        )
    }
}