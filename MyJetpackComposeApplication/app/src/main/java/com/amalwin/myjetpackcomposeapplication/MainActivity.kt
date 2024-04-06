package com.amalwin.myjetpackcomposeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amalwin.myjetpackcomposeapplication.ui.theme.MyJetpackComposeApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyJetpackComposeApplicationTheme {
                // A surface container using the 'background' color from the theme

            }
        }
    }
}

@Composable
fun GreetingText(name: String) {
    Text(
        text = "Welcome $name",
        modifier = Modifier.fillMaxHeight(0.5f)
    )
}

@Composable
fun GreetingTextV2(name: String) {
    Text(text = "Welcome $name")
}

@Composable
fun GreetingButton(name: String = "Hi") {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.DarkGray) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    modifier = Modifier
                        .wrapContentSize(align = Alignment.CenterEnd)
                        .weight(1f),
                    onClick = { }) {
                    //GreetingText(name = "Nandagopal")
                    GreetingTextV2(name = "Nalan Sarrwin RT")
                }
                Text(text = "Welcome",color = Color.White)
            }
            Row() {
                Text(text = "Second line aligned left", modifier = Modifier.wrapContentSize(align = Alignment.CenterEnd).weight(1f), color = Color.White)
                Spacer(modifier = Modifier.weight(1f))
                Text(text = "Second line aligned right", modifier = Modifier.wrapContentSize(), color = Color.White)
            }
            Row() {
                Text(text = "Third line aligned left", modifier = Modifier.wrapContentSize(), color = Color.White)
                Spacer(modifier = Modifier.weight(1f))
                Text(text = "Third line aligned right", modifier = Modifier.wrapContentSize(), color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    GreetingButton("Android")

}