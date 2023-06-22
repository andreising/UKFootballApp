package com.andreisingeleytsev.ukfootballapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.andreisingeleytsev.ukfootballapp.ui.screens.game_screen.GameScreen
import com.andreisingeleytsev.ukfootballapp.ui.screens.leagues_screen.LeaguesScreen
import com.andreisingeleytsev.ukfootballapp.ui.screens.menu_screen.MenuScreen
import com.andreisingeleytsev.ukfootballapp.ui.screens.scoreboard_screen.ScoreboardScreen
import com.andreisingeleytsev.ukfootballapp.ui.screens.settings_screen.SettingsScreen
import com.andreisingeleytsev.ukfootballapp.ui.screens.team_info_screen.TeamInfoScreen
import com.andreisingeleytsev.ukfootballapp.ui.screens.teams_screen.TeamsScreen
import com.andreisingeleytsev.ukfootballapp.ui.screens.traked_screen.TrackedScreen
import com.andreisingeleytsev.ukfootballapp.ui.utils.Routes

@Composable
fun UKFootballMainNavigation() {
    val navHostController = rememberNavController()
    NavHost(navController = navHostController, startDestination = Routes.MENU_SCREEN){
        composable(Routes.MENU_SCREEN){
            MenuScreen(navHostController)
        }
        composable(Routes.LEAGUES_SCREEN){
            LeaguesScreen(navHostController)
        }
        composable(Routes.SETTINGS_SCREEN){
            SettingsScreen(navHostController)
        }
        composable(Routes.TRACKED_SCREEN){
            TrackedScreen(navHostController)
        }
        composable(Routes.GAME_SCREEN){
            GameScreen(navHostController)
        }
        composable(Routes.TEAMS_SCREEN){
            TeamsScreen(navHostController)
        }
        composable(Routes.SCOREBOARD_SCREEN){
            ScoreboardScreen(navHostController)
        }
        composable(Routes.TEAM_INFO_SCREEN){
            TeamInfoScreen(navHostController)
        }
    }
}