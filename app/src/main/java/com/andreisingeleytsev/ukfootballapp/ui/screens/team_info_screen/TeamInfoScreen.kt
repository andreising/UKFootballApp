package com.andreisingeleytsev.ukfootballapp.ui.screens.team_info_screen

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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
import com.andreisingeleytsev.ukfootballapp.ui.screens.traked_screen.Completed
import com.andreisingeleytsev.ukfootballapp.ui.screens.traked_screen.Upcoming
import com.andreisingeleytsev.ukfootballapp.ui.theme.MainColor
import com.andreisingeleytsev.ukfootballapp.ui.theme.PrimaryColor
import com.andreisingeleytsev.ukfootballapp.ui.utils.Fonts
import com.andreisingeleytsev.ukfootballapp.ui.utils.Routes

@Composable
fun TeamInfoScreen(navController: NavHostController) {
    val state = remember {
        mutableStateOf(true)
    }
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter){
            Image(
                painter = painterResource(id = R.drawable.team_info_bg),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Row(
                Modifier
                    .padding(start = 10.dp, top = 44.dp, end = 10.dp)
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
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = null,
                            modifier = Modifier.size(300.dp),
                            tint = PrimaryColor
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
                            tint = PrimaryColor
                        )
                    }
                }
            }
        }

        Text(
            text = "ARSENAL", style = TextStyle(
                fontSize = 20.sp, color = PrimaryColor, fontFamily = Fonts.customFontFamily
            )
        )
        Column(
            modifier = Modifier
                .padding(start = 21.dp, end = 21.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (state.value){
                Matches(navHostController = navController, state = state)
            } else {
                Players()
            }
        }
    }
}

@Composable
fun Matches(navHostController: NavHostController, state: MutableState<Boolean>) {
    val thisState = remember {
        mutableStateOf(true)
    }
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(76.dp)
        .clickable {
            navHostController.navigate(Routes.SETTINGS_SCREEN)
        }
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(MainColor)
            .clickable {
                state.value = false
            }, contentAlignment = Alignment.Center){
            Text(text = "PLAYERS", style = TextStyle(
                fontSize = 25.sp, color = Color.White, fontFamily = Fonts.customFontFamily,
                fontWeight = FontWeight.Bold
            ))
        }
    }
    Text(text = "MATCHES", style = TextStyle(
        fontSize = 25.sp, color = MainColor, fontFamily = Fonts.customFontFamily,
        fontWeight = FontWeight.Bold
    ), modifier = Modifier.padding(top = 30.dp))
    BoxWithConstraints(
        Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)) {
        val width = maxWidth
        Row(Modifier.fillMaxWidth()) {
            Box(modifier = Modifier
                .width(width / 2)
                .background(if (thisState.value) MainColor else Color.White)
                .clickable {
                    thisState.value = true
                },
                contentAlignment = Alignment.Center){
                Text(text = "UPCOMING", style = TextStyle(
                    fontSize = 14.sp, color = if (!thisState.value) MainColor else Color.White, fontFamily = Fonts.customFontFamily,
                    fontWeight = FontWeight.Bold
                ) )
            }
            Box(modifier = Modifier
                .width(width / 2)
                .background(if (!thisState.value) MainColor else Color.White)
                .clickable {
                    thisState.value = false
                },
                contentAlignment = Alignment.Center){
                Text(text = "COMPLETED", style = TextStyle(
                    fontSize = 14.sp, color = if (thisState.value) MainColor else Color.White, fontFamily = Fonts.customFontFamily,
                    fontWeight = FontWeight.Bold
                ) )
            }
        }
    }
    Column(
        Modifier
            .fillMaxSize()
            .wrapContentHeight()
            .verticalScroll(rememberScrollState())) {
        if (thisState.value) Upcoming()
        else Completed()
    }
}

@Composable
fun Players(){
    Text(text = "PLAYERS", style = TextStyle(
        fontSize = 25.sp, color = MainColor, fontFamily = Fonts.customFontFamily,
        fontWeight = FontWeight.Bold
    ), modifier = Modifier.padding(top = 10.dp))
    Box(modifier = Modifier
        .padding(top = 30.dp)
        .fillMaxWidth()
        .height(1.dp)
        .background(MainColor))
    LazyColumn(){
        items(arsenalList){
            ListItem(triple = it)
        }
    }
}

@Composable
fun ListItem(triple: Triple<String, String, String>) {
    Column(Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.padding(start = 12.dp)) {
            Text(text = arsenalList.indexOf(triple).toString()+".", style = TextStyle(
                fontSize = 20.sp, color = MainColor.copy(alpha = 0.8f), fontFamily = Fonts.customFontFamily,
                fontWeight = FontWeight.Bold
            ), modifier = Modifier.padding(end = 36.dp))
            Column(Modifier.fillMaxWidth()) {
                Row(Modifier.fillMaxWidth()) {
                    Text(text = triple.first, style = TextStyle(
                        fontSize = 20.sp, color = Color.Black, fontFamily = Fonts.customFontFamily,
                        fontWeight = FontWeight.Bold
                    ))
                    Text(text = triple.second.uppercase(), style = TextStyle(
                        fontSize = 20.sp, color = Color.Black, fontFamily = Fonts.customFontFamily,
                        fontWeight = FontWeight.Bold
                    ))
                }
                Text(text = triple.third, style = TextStyle(
                    fontSize = 16.sp, color = MainColor, fontFamily = Fonts.customFontFamily,
                    fontWeight = FontWeight.Bold
                ))
            }
        }
        Box(modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth()
            .height(1.dp)
            .background(MainColor))
    }
}

val arsenalList = listOf(
    Triple("Aaron ", "Ramsdale", "Goalkeeper"),
    Triple("Matt ", "Turner", "Goalkeeper"),
    Triple("Karl ", "Hein", "Goalkeeper"),
    Triple("Kieran ", "Tierney", "Defender"),
    Triple("Ben ", "White", "Defender"),
    Triple("", "Gabriel", "Defender"),
    Triple("William ", "Saliba", "Defender"),
    Triple("Jakub ", "Kiwior", "Defender"),
    Triple("Rob ", "Holding", "Defender"),
    Triple("Takehiro ", "Tomiyasu", "Defender"),
    Triple("Oleksandr ", "Zinchenko", "Defender"),
    Triple("", "Thomas", "Midfielder"),
    Triple("Bukayo ", "Saka", "Midfielder"),
    Triple("Martin ", "Odegaard", "Midfielder"),
    Triple("Emile ", "Smith Rowe", "Midfielder"),
    Triple("", "Jorginho", "Midfielder"),
    Triple("Fabio ", "Vieira", "Midfielder"),
    Triple("Mohamed ", "Elneny", "Midfielder"),
    Triple("Granit ", "Xhaka", "Midfielder"),
    Triple("Gabriel ", "Jesus", "Forward"),
    Triple("Gabriel ", "Martinelli", "Forward"),
    Triple("Eddie ", "Nketiah", "Forward"),
    Triple("Leandro ", "Trossard", "Forward"),
    Triple("Reiss ", "Nelson", "Forward")
)