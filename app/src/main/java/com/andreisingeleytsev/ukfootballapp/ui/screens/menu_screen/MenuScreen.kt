package com.andreisingeleytsev.ukfootballapp.ui.screens.menu_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.andreisingeleytsev.ukfootballapp.ui.utils.Routes

@Composable
fun MenuScreen(navHostController: NavHostController){
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
        Text(
            text = "MENU", modifier = Modifier.padding(top = 40.dp), style = TextStyle(
                fontSize = 40.sp, color = MainColor, fontFamily = Fonts.customFontFamily,
                fontWeight = FontWeight.Bold
            )
        )
        BoxWithConstraints(
            modifier = Modifier
                .padding(top = 50.dp, start = 18.dp, end = 18.dp)
                .fillMaxWidth()
                .height(350.dp)
        ) {
            val width = this.maxWidth
            Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width((width - 12.dp) / 2),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.btn_leagues),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                navHostController.navigate(Routes.LEAGUES_SCREEN)
                            },
                        contentScale = ContentScale.FillWidth
                    )
                    Image(
                        painter = painterResource(id = R.drawable.btn_settings),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth()
                            .clickable {
                                navHostController.navigate(Routes.SETTINGS_SCREEN)
                            },
                        contentScale = ContentScale.FillWidth
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width((width - 12.dp) / 2),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.btn_tracked),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth()
                            .clickable {
                                navHostController.navigate(Routes.TRACKED_SCREEN)
                            },
                        contentScale = ContentScale.FillWidth
                    )
                    Image(
                        painter = painterResource(id = R.drawable.btn_game),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth()
                            .clickable {
                                navHostController.navigate(Routes.GAME_SCREEN)
                            },
                        contentScale = ContentScale.FillWidth
                    )
                }
            }

            }
        }

}