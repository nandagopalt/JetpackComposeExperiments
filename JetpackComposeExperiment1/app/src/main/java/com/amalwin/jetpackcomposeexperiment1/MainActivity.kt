package com.amalwin.jetpackcomposeexperiment1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
                    //BoxLayoutV1("Hi")
                    //BoxLayoutV2()
                    BoxLayoutV3()
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

@Composable
fun GreetingV2(name: String) {
    Text(
        text = "Hello $name",
        fontSize = 15.sp,
        color = Color.Red,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .background(color = Color.Yellow)
            .border(2.dp, color = Color.Green)
            .padding(10.dp)
    )
}

@Composable
fun BoxLayoutV1(name: String) {
    Box(
        modifier = Modifier
            .background(color = Color.Yellow)
            .size(180.dp, 150.dp)
    ) {
        Box(
            modifier = Modifier
                .background(color = Color.Red)
                .size(80.dp, 80.dp)
                .align(Alignment.TopEnd)
        ) {}
        Text(
            text = "Hi $name",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .background(color = Color.Green)
                .padding(10.dp)
                .align(Alignment.BottomStart)
        )
    }
}

@Composable
fun BoxLayoutV2() {
    Box(
        modifier = Modifier
            .background(color = Color.Yellow)
            .padding(1.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "Top Start",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            modifier = Modifier
                .background(color = Color.White)
                .border(2.dp, color = Color.Green)
                .padding(10.dp)
                .align(Alignment.TopStart)
        )
        Text(
            text = "Top Center",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            modifier = Modifier
                .background(color = Color.White)
                .border(2.dp, color = Color.Green)
                .padding(10.dp)
                .align(Alignment.TopCenter)
        )
        Text(
            text = "Top End",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            modifier = Modifier
                .background(color = Color.White)
                .border(2.dp, color = Color.Green)
                .padding(10.dp)
                .align(Alignment.TopEnd)
        )

        Text(
            text = "Center Start",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            modifier = Modifier
                .background(color = Color.White)
                .border(2.dp, color = Color.Green)
                .padding(10.dp)
                .align(Alignment.CenterStart)
        )
        Text(
            text = "Center Center",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            modifier = Modifier
                .background(color = Color.White)
                .border(2.dp, color = Color.Green)
                .padding(10.dp)
                .align(Alignment.Center)
        )
        Text(
            text = "Center End",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            modifier = Modifier
                .background(color = Color.White)
                .border(2.dp, color = Color.Green)
                .padding(10.dp)
                .align(Alignment.CenterEnd)
        )
        Text(
            text = "Bottom Start",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            modifier = Modifier
                .background(color = Color.White)
                .border(2.dp, color = Color.Green)
                .padding(10.dp)
                .align(Alignment.BottomStart)
        )
        Text(
            text = "Bottom Center",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            modifier = Modifier
                .background(color = Color.White)
                .border(2.dp, color = Color.Green)
                .padding(10.dp)
                .align(Alignment.BottomCenter)
        )
        Text(
            text = "Bottom End",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            modifier = Modifier
                .background(color = Color.White)
                .border(2.dp, color = Color.Green)
                .padding(10.dp)
                .align(Alignment.BottomEnd)
        )


    }
}

@Composable
fun BoxLayoutV3() {
    Box(
        modifier =
        Modifier.background(color = Color.Cyan)
    ) {
        Image(
            painter = painterResource(id = R.drawable.download),
            contentDescription = "Nature's Image",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .border(2.dp, Color.Red)
                .padding(10.dp)
        )
        Text(
            text = "Nature's Gift",
            style = MaterialTheme.typography.h5,
            color = Color.DarkGray,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.BottomStart)
        )

        Button(
            onClick = {},
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.DarkGray,
                contentColor = Color.White
            ),
            modifier = Modifier
                .padding(5.dp)
                .border(2.dp, color = Color.Gray)
                .align(Alignment.TopEnd)
        ) {
            Text(
                text = "Add to cart",
                style = MaterialTheme.typography.h6,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeExperiment1Theme {
        Greeting("Android")
    }
}