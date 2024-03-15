package com.amalwin.statehandlingwithjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Composable
fun WelcomeComposable(name: String) {
    Surface(color = Color.DarkGray, modifier = Modifier.fillMaxSize()) {
        Surface(
            modifier = Modifier
                .wrapContentSize(align = Alignment.BottomStart),
            color = Color.Green
        ) {
            Text(
                text = "Welcome $name", modifier = Modifier
                    .padding(10.dp),
                style = MaterialTheme.typography.h4,
                color = Color.White
            )
        }
    }
}

@Composable
fun WelcomeComposableV2(name: String) {
    Surface(color = Color.DarkGray, modifier = Modifier.fillMaxSize()) {
        Surface(
            modifier = Modifier.wrapContentSize(Alignment.TopCenter),
            border = BorderStroke(5.dp, color = Color.Green)
        ) {
            Text(
                text = "Welcome $name",
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(16.dp),
                style = MaterialTheme.typography.h4,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun MainScreenDefaultPreview() {
    WelcomeComposableV2(name = "Android !")
}