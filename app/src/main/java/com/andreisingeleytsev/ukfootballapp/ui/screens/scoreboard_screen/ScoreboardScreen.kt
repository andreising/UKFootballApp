package com.andreisingeleytsev.ukfootballapp.ui.screens.scoreboard_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.andreisingeleytsev.ukfootballapp.R
import com.andreisingeleytsev.ukfootballapp.ui.theme.MainColor
import com.andreisingeleytsev.ukfootballapp.ui.utils.Fonts

@Composable
fun ScoreboardScreen(navHostController: NavHostController) {
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
            Text(text = "SCOREBOARD", style = TextStyle(
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
        Image(
            painter = painterResource(id = R.drawable.premier_league_logo),
            contentDescription = null,
            modifier = Modifier
                .width(180.dp)
                .padding(top = 36.dp),
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = "SEASON", style = TextStyle(
                fontSize = 13.sp, color = MainColor, fontFamily = Fonts.customFontFamily,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(top = 36.dp)
        )
        Card(
            modifier = Modifier
                .width(176.dp)
                .height(40.dp)
                .padding(top = 6.dp)
        ) {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(MainColor), contentAlignment = Alignment.Center){
                Text(text = "2022-2023", style = TextStyle(
                    fontSize = 16.sp, color = Color.White, fontFamily = Fonts.customFontFamily,
                    fontWeight = FontWeight.Bold
                ))
            }
        }
        Image(
            painter = painterResource(id = R.drawable.scoreboard),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 40.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
    }
}