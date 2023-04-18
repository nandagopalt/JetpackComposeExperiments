package com.amalwin.jetpackcomposeexperiment1

import android.R
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amalwin.jetpackcomposeexperiment1.ui.theme.JetpackComposeExperiment1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeExperiment1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier.background(color = Color.Gray)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Greeting("AB")
                        Greeting("CDE")
                        Greeting("F")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Red,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(color = Color.Yellow)
            .border(2.dp, color = Color.Green)
            .padding(10.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeExperiment1Theme {
        Greeting("Android")
    }
}