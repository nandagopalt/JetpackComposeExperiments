package com.amalwin.myjetpackcomposeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        text = "Welcome $name", modifier = Modifier.fillMaxHeight(0.5f)
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
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Button(modifier = Modifier
                    .wrapContentSize(align = Alignment.CenterEnd)
                    .weight(1f),
                    onClick = { }) {
                    //GreetingText(name = "Nandagopal")
                    GreetingTextV2(name = "Nalan Sarrwin RT")
                }
                Text(text = "Welcome", color = Color.White)
            }
            Row() {
                Text(
                    text = "Second line aligned left",
                    modifier = Modifier
                        .wrapContentSize(align = Alignment.CenterEnd)
                        .weight(1f),
                    color = Color.White
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Second line aligned right",
                    modifier = Modifier.wrapContentSize(),
                    color = Color.White
                )
            }
            Row() {
                Text(
                    text = "Third line aligned left",
                    modifier = Modifier.wrapContentSize(),
                    color = Color.White
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Third line aligned right",
                    modifier = Modifier.wrapContentSize(),
                    color = Color.White
                )
            }
            Row() {
                Text(
                    text = "Hello Mr.XYZ",
                    modifier = Modifier
                        .clickable(onClick = {})
                        .padding(all = 24.dp)
                        .width(200.dp)
                        .height(240.dp),
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        fontFamily = FontFamily.Cursive
                    )
                )
            }
            Row(
                modifier = Modifier.fillMaxSize(),
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Hello Mr.ABC",
                    modifier = Modifier
                        .wrapContentSize(),
                    style = MaterialTheme.typography.h3,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Cursive,
                    color = Color.White
                )
            }
        }
    }
}

@Composable()
fun MainScreen() {
    Surface(
        color = Color.DarkGray,
        modifier = Modifier.fillMaxSize()
    ) {
        Surface(
            modifier = Modifier.wrapContentSize(align = Alignment.Center),
            color = Color.Magenta
        ) {
            Text(
                text = "Wrapped Content",
                modifier = Modifier.wrapContentSize(),
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Light
            )

        }

    }
}

@Composable
fun MainScreenV2() {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.DarkGray) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalColoredBar(Color.Red)
            HorizontalColoredBar(Color.Magenta)
            HorizontalColoredBar(Color.Cyan)
            HorizontalColoredBar(Color.Yellow)
            HorizontalColoredBar(Color.Blue)
        }
    }
}

@Composable
fun HorizontalColoredBar(color: Color) {
    Surface(
        modifier = Modifier
            .height(600.dp)
            .width(60.dp), color = color
    ) { }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    //GreetingButton("Android")
    //MainScreen()
    MainScreenV2()
}