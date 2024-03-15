package com.amalwin.statehandlingwithjetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amalwin.statehandlingwithjetpackcompose.ui.theme.StateHandlingWithJetpackComposeTheme

class MainActivity : ComponentActivity() {
    private val count = mutableStateOf(0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateHandlingWithJetpackComposeTheme {
                Column(
                    modifier = Modifier
                        .background(color = Color.LightGray)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // MyButton()
                    var count by remember { mutableStateOf(0) }
                    MyButtonV2(count) { count = it + 1 }
                }
            }
        }
    }


    @Composable
    fun MyButton() {
        val context = LocalContext.current
        Button(
            onClick = {
                count.value += 1
                Toast.makeText(context, "Count is ${count.value} !", Toast.LENGTH_LONG).show()
            },
            shape = RoundedCornerShape(corner = CornerSize(10.dp)),
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.DarkGray,
                contentColor = Color.White
            ),
            contentPadding = PaddingValues(16.dp),
            border = BorderStroke(5.dp, color = Color.White)
        ) {
            Text(
                text = "Count is ${count.value}",
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(5.dp)
            )
        }
    }

    @Composable
    fun MyButtonV2(currentCount: Int, updateCountListenerEvent: (Int) -> Unit) {
        val context = LocalContext.current
        //var count by remember { mutableStateOf(0) }
        Button(
            onClick = {
                //count += 1
                //Toast.makeText(context, "$count", Toast.LENGTH_LONG).show()
                updateCountListenerEvent(currentCount)
            }, contentPadding = PaddingValues(16.dp),
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.Gray,
                contentColor = Color.White,
            ), border = BorderStroke(5.dp, color = Color.Black)
        ) {
            Text(
                text = "Add to cart : $currentCount",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StateHandlingWithJetpackComposeTheme {
        Greeting("Android")
    }
}
