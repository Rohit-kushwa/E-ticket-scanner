package com.example.ticketscanner

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.ticketscanner.Instances.LoginInterface
import com.example.ticketscanner.Screens.ScannerBarcode
import com.example.ticketscanner.ui.theme.TicketScannerTheme
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    lateinit var barcodeScanner: com.example.ticketscanner.BarcodeScanner
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            barcodeScanner = BarcodeScanner(context)

            TicketScannerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val barcodeResults =
                        barcodeScanner.barCodeResults.collectAsStateWithLifecycle()

                    ScannerBarcode(barcodeScanner::startScan, barcodeResults.value )

                    val retrofit = Retrofit.Builder()
                        .baseUrl("https://eticket-uat.ckcloud.in/api/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

                    val apiService = retrofit.create(LoginInterface::class.java)

                    lifecycleScope.launch {
                        try {
                            val userName = "your_username"
                            val password = "your_password"
                            val loginResponse = apiService.login(userName, password)
                            // Handle the loginResponse
                            Log.d("LoginResponse", "ID: ${loginResponse.loginModel.get(0)}, LoginStatus: ${loginResponse.loginModel.get(1)}")
                        } catch (e: Exception) {
                            // Handle exceptions
                        }
                    }


                }
            }
        }
    }
}
