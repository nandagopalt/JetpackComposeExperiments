package com.amalwin.greetingsworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amalwin.greetingsworld.ui.theme.GreetingsWorldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingsWorldTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Box {
                        BirthDayGreetingsWithImage()
                        BirthDayGreetingsWithText(
                            message = stringResource(R.string.happy_birthday_text),
                            senderName = stringResource(R.string.from_sender)
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun BirthDayGreetingsWithImage() {
    val cakeImage = painterResource(id = R.drawable.androidparty)
    Image(
        painter = cakeImage,
        contentDescription = null,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun BirthDayGreetingsWithText(message: String, senderName: String) {
    Column {
        Text(
            text = message, fontSize = 32.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(top = 16.dp)

        )
        Text(
            text = senderName, fontSize = 21.sp, modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(end = 16.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    GreetingsWorldTheme {
        Box {
            BirthDayGreetingsWithImage()
            BirthDayGreetingsWithText(
                message = stringResource(R.string.happy_birthday_text), senderName = stringResource(
                    R.string.from_sender
                )
            )
        }
    }
}