package com.amalwin.quadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amalwin.quadrant.ui.theme.QuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    ComposeQuadrantApp()
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrantApp() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.weight(1f)) {
            ComposableInfoCard(
                stringResource(R.string.quadrant_1_title),
                stringResource(R.string.quadrant_1_description),
                Color.Green,
                Modifier
                    .background(Color.Green)
                    .padding(16.dp)
                    .weight(1f)
                    .fillMaxHeight()
            )
            ComposableInfoCard(
                "Image composable",
                "Creates a composable that lays out and draws a given Painter class object.",
                Color.Yellow,
                Modifier
                    .background(Color.Yellow)
                    .padding(16.dp)
                    .weight(1f)
                    .fillMaxHeight()
            )
        }

        Row(modifier = Modifier.weight(1f)) {
            ComposableInfoCard(
                "Row composable",
                "A layout composable that places its children in a horizontal sequence.",
                Color.Cyan,
                Modifier
                    .background(Color.Cyan)
                    .padding(16.dp)
                    .weight(1f)
                    .fillMaxHeight()
            )
            ComposableInfoCard(
                "Column composable",
                "A layout composable that places its children in a vertical sequence.",
                Color.Yellow,
                Modifier
                    .background(Color.LightGray)
                    .padding(16.dp)
                    .weight(1f)
                    .fillMaxHeight()
            )
        }
    }
}

@Composable
fun ComposableInfoCard(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp)
        )

        Text(
            text = description,
            textAlign = TextAlign.Justify,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "QuadrantPreview")
@Composable
fun DefaultPreview() {
    QuadrantTheme {
        ComposeQuadrantApp()
    }
}