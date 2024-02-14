package com.example.ticketscanner

import android.content.Intent
import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ticketscanner.ui.theme.TicketScannerTheme
import kotlinx.coroutines.delay

class splashScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicketScannerTheme {
                // A surface container using the 'background' color from the theme

                SplashScreen()
            }
        }
    }

    @Preview
    @Composable
    private fun SplashScreen(){

        LaunchedEffect(key1 = true){
            delay(1000)
            startActivity(Intent(this@splashScreenActivity, LoginScreenActivity::class.java))
            finish()
        }

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            color = MaterialTheme.colorScheme.background
        ) {

            Column(
                modifier = Modifier.wrapContentSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(contentAlignment = Alignment.TopCenter) {
                    Image(
                        painter = painterResource(id = R.drawable.agra_logo),
                        contentDescription = "splash Screen Logo",
                        modifier = Modifier.size(350.dp)
                    )
                }

                Text(
                    text = "E-Ticket Scanner",
                    style = TextStyle(
                        fontSize = 36.sp,
                        fontFamily = FontFamily.SansSerif
                    ),
                    modifier = Modifier.padding(bottom = 100.dp)
                )
            }

        }


        
    }
}
