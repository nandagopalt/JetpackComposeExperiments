package com.amalwin.businesscardapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amalwin.businesscardapplication.ui.theme.BusinessCardApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Gray
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Column(modifier = Modifier.weight(2f), verticalArrangement = Arrangement.Center) {
                            BusinessCardFirstPart(
                                "Nalan Sarrwin RT",
                                "Mobile Architect",
                                Modifier.fillMaxWidth()
                            )
                        }
                        BusinessCardSecondPart()
                    }
                }
            }
        }
    }
}

@Composable
fun BusinessCardFirstPart(fullName: String, title: String, modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val image = painterResource(id = R.drawable.android_logo)
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(200.dp, 200.dp)
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
        Text(
            text = fullName,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp,
            modifier = modifier.wrapContentWidth(Alignment.CenterHorizontally)
        )

        Text(
            text = title,
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Light,
            modifier = modifier.wrapContentWidth(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun IconValuePairComposable(
    painterResource: Painter,
    contentDescription: String?,
    modifier: Modifier
) {
    Row(
        modifier = Modifier
            .wrapContentHeight()
    ) {
        val icon = painterResource
        Icon(
            painter = icon,
            contentDescription = contentDescription,
            modifier = modifier
                .wrapContentWidth(Alignment.Start)
                .weight(1f)
        )
        Text(
            text = "9611728053",
            fontSize = 16.sp,
            color = Color.White,
            modifier = modifier
                .wrapContentWidth(Alignment.End)
                .weight(1f)
        )
    }
}


@Composable
fun BusinessCardSecondPart() {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
        modifier = Modifier
            .wrapContentSize()
            .padding(16.dp)
    ) {
        IconValuePairComposable(
            painterResource = painterResource(id = R.drawable.ic_phone),
            contentDescription = null,
            modifier = Modifier
        )
        IconValuePairComposable(
            painterResource = painterResource(id = R.drawable.ic_phone),
            contentDescription = null,
            modifier = Modifier
        )
        IconValuePairComposable(
            painterResource = painterResource(id = R.drawable.ic_phone),
            contentDescription = null,
            modifier = Modifier
        )
    }

}

@Preview(showBackground = true, showSystemUi = true, name = "BusinessCardPreview")
@Composable
fun DefaultPreview() {
    BusinessCardApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.primary
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Column(modifier = Modifier.weight(2f), verticalArrangement = Arrangement.Center) {
                    BusinessCardFirstPart(
                        "Nalan Sarrwin RT",
                        "Mobile Architect",
                        Modifier.fillMaxWidth()
                    )
                }
                BusinessCardSecondPart()
            }
        }

    }
}