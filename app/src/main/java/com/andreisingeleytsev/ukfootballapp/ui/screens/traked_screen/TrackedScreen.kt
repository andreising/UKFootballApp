package com.andreisingeleytsev.ukfootballapp.ui.screens.traked_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.andreisingeleytsev.ukfootballapp.R
import com.andreisingeleytsev.ukfootballapp.ui.theme.MainColor
import com.andreisingeleytsev.ukfootballapp.ui.utils.Fonts

@Composable
fun TrackedScreen(navHostController: NavHostController) {
    val thisState = remember {
        mutableStateOf(true)
    }
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Row(
            Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(MainColor),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier.wrapContentSize(),
                contentAlignment = Alignment.CenterStart
            ) {
                IconButton(onClick = {
                    navHostController.popBackStack()
                }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = null,
                        modifier = Modifier.size(300.dp),
                        tint = Color.White
                    )
                }
            }
            Text(text = "TRACKED", style = TextStyle(
                fontSize = 25.sp, color = Color.White, fontFamily = Fonts.customFontFamily,
                fontWeight = FontWeight.Bold
            ) )
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
                .padding(top = 50.dp, start = 18.dp, end = 18.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 22.dp)) {
                BoxWithConstraints(Modifier.fillMaxWidth()) {
                    val width = maxWidth
                    Row(Modifier.fillMaxWidth()) {
                        Box(
                            modifier = Modifier
                                .width(width / 2)
                                .background(if (thisState.value) MainColor else Color.White)
                                .clickable {
                                    thisState.value = true
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "UPCOMING", style = TextStyle(
                                    fontSize = 14.sp,
                                    color = if (!thisState.value) MainColor else Color.White,
                                    fontFamily = Fonts.customFontFamily,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                        Box(
                            modifier = Modifier
                                .width(width / 2)
                                .background(if (!thisState.value) MainColor else Color.White)
                                .clickable {
                                    thisState.value = false
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "COMPLETED", style = TextStyle(
                                    fontSize = 14.sp,
                                    color = if (thisState.value) MainColor else Color.White,
                                    fontFamily = Fonts.customFontFamily,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                    }
                }
            }
            if (thisState.value) Upcoming()
            else Completed()
        }
    }

}

@Composable
fun Upcoming() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(text = "There will be no matches in the near future", style = TextStyle(
            fontSize = 20.sp, color = MainColor, fontFamily = Fonts.customFontFamily,
            fontWeight = FontWeight.Bold
        ) )
    }

}

@Composable
fun Completed() {
    Image(
        painter = painterResource(id = R.drawable.first_match),
        contentDescription = null,
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.FillWidth
    )
    Image(
        painter = painterResource(id = R.drawable.second_match),
        contentDescription = null,
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.FillWidth
    )
    Image(
        painter = painterResource(id = R.drawable.third_match),
        contentDescription = null,
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.FillWidth
    )
}