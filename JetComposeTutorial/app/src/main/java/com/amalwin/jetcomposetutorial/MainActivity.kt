package com.amalwin.jetcomposetutorial

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amalwin.jetcomposetutorial.ui.theme.JetComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        JetpackComposePosterImage()
                        JetpackComposeTitle(title = stringResource(R.string.jetpack_title))
                        JetpackComposePassage1(passage = stringResource(R.string.jetpack_passage1))
                        JetpackComposablePassage2(passage = stringResource(R.string.jetpack_passage2))
                    }
                }
            }
        }
    }
}

@Composable
fun JetpackComposePosterImage() {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Image(
        painter = image,
        contentDescription = null
    )
}

@Composable
fun JetpackComposeTitle(title: String) {
    Text(
        text = title,
        fontSize = 24.sp,
        color = Color.Black,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
            .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
    )
}

@Composable
fun JetpackComposePassage1(passage: String) {
    Text(
        text = passage,
        color = Color.Black,
        textAlign = TextAlign.Justify,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
            .padding(start = 16.dp, end = 16.dp)
    )
}

@Composable
fun JetpackComposablePassage2(passage: String) {
    Text(
        text = passage,
        textAlign = TextAlign.Justify,
        color = Color.Black,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(Alignment.CenterVertically)
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 16.dp)
    )
}

@Preview(showBackground = true, showSystemUi = true, name = "JetPackComposePreview")
@Composable
fun DefaultPreview() {
    JetComposeTutorialTheme {
        Column {
            JetpackComposePosterImage()
            JetpackComposeTitle(title = stringResource(R.string.jetpack_title))
            JetpackComposePassage1(passage = stringResource(R.string.jetpack_passage1))
            JetpackComposablePassage2(passage = stringResource(R.string.jetpack_passage2))
        }
    }
}