package com.example.ticketscanner.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ticketscanner.R
import kotlinx.coroutines.launch

@Composable
fun ScannerBarcode(
    onScanBarcode: suspend () -> Unit,
    barcodeValue: String?
) {

    val scope = rememberCoroutineScope()

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {

        Box(
            modifier = Modifier
                .wrapContentSize(align = Alignment.TopEnd)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logout),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)// Adjust offset as needed
            )
        }

        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(bottom = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = barcodeValue ?: "Status",
                modifier = Modifier.padding(bottom = 40.dp),
                style = MaterialTheme.typography.displayMedium)

            Image(
                painter = painterResource(id = R.drawable.qr),
                contentDescription = "QR-code Image",
                modifier = Modifier.size(300.dp)
            )
            Spacer(modifier = Modifier.height(80.dp))


            Button(
                onClick = {scope.launch { onScanBarcode()}},
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .size(width = 200.dp, height = 55.dp)
            ) {
                Text(text = "Scan", style = TextStyle(fontSize = 26.sp))
            }

        }

    }
}



