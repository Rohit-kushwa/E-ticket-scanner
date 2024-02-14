package com.example.ticketscanner

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ticketscanner.dataModel.LoginModel
import com.example.ticketscanner.services.fetchData
import com.example.ticketscanner.ui.theme.TicketScannerTheme
import com.example.ticketscanner.viewModels.LoginViewModel

class LoginScreenActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicketScannerTheme {
                // A surface container using the 'background' color from the theme
                LoginPage(context = this@LoginScreenActivity)

//                var data by remember { mutableStateOf(emptyList<LoginModel>()) }
//
//                LaunchedEffect(Unit) {
//                    fetchData() { result ->
//                        result.fold(
//                            onSuccess = { xmlData ->
//                                val extractedData = xmlDataParser(xmlData)
//                                data = extractedData
//                                Toast.makeText(this@LoginScreenActivity, "Successful !!", Toast.LENGTH_SHORT)
//                                    .show()
//                            },
//                            onFailure = {
//                                // Handle error
//                                Toast.makeText(this@LoginScreenActivity, "Something wrong!", Toast.LENGTH_SHORT)
//                                    .show()
//                            }
//                        )
//                    }
//                }


            }
        }
    }

    @Composable
    fun LoginPage(
        context: Context
    ) {

        var UserId by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
        ) {

            Column(
                modifier = Modifier
                    .wrapContentSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.agra_logo),
                    contentDescription = "logo",
                    modifier = Modifier.size(300.dp)
                )
                Text(
                    text = "E-Ticket Scanner",
                    style = TextStyle(
                        fontSize = 36.sp,
                        fontFamily = FontFamily.SansSerif
                    ),
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 40.dp,),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center

                ) {

                    OutlinedTextField(
                        value = UserId,
                        onValueChange = { UserId = it },
                        label = { Text("Enter User-Id", style = TextStyle(fontSize = 17.sp)) },
                        textStyle = TextStyle(fontSize = 23.sp),
                        modifier = Modifier
                            .padding(top = 20.dp, bottom = 20.dp)
                            .size(height = 65.dp, width = 300.dp)
                    )

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Enter Password", style = TextStyle(fontSize = 17.sp)) },
                        visualTransformation = PasswordVisualTransformation(),
                        textStyle = TextStyle(fontSize = 23.sp),
                        modifier = Modifier
                            .padding(bottom = 20.dp)
                            .size(height = 65.dp, width = 300.dp)

                    )

                }
                Button(
                    onClick = {
                    }, shape = RoundedCornerShape(20.dp), modifier = Modifier
                        .size(width = 260.dp, height = 55.dp)
                ) {
                    Text(text = "Login", style = TextStyle(fontSize = 26.sp))
                }
            }
        }
    }

}

@Preview
@Composable
fun LoginScreenActivityPreview(){
    LoginScreenActivity()
}