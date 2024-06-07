package com.example.ptixiakiergasia

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ptixiakiergasia.ui.theme.PtixiakiErgasiaTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        setContent {
            PtixiakiErgasiaTheme {
                var viewModel:ViewModel = ViewModel()
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //HomePage(viewModel=viewModel)
                   //OrderScreen(viewModel = viewModel)
                    NavHost(navController = navController,
                        startDestination = Screens.Homepage.route){
                         composable(route = Screens.Homepage.route){
                                HomePage(viewModel = viewModel,
                                    navController = navController)
                         }
                        composable(route = Screens.Order_screen.route){
                            OrderScreen(viewModel = viewModel,
                                navController = navController)
                        }
                    }
                }
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun preciew(){
    //HomePage()
}