package com.amalwin.profilepagewithjetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProfilePage() {
    Card(
        elevation = 10.dp, modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 100.dp, bottom = 100.dp, start = 16.dp, end = 16.dp
            )
            .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(30.dp))
    ) {
        Column(
            Modifier.verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.passport_photo),
                contentDescription = "Nalan Sarrwin",
                modifier = Modifier
                    .size(300.dp)
                    .clip(CircleShape)
                    .border(
                        width = 5.dp,
                        color = Color.Red,
                        shape = CircleShape
                    ),
                contentScale = ContentScale.Crop

            )
            Text(text = "Nalan Sarrwin")
            Text(text = "Germany")

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                profileStatistics("150", "Followers")
                profileStatistics("100", "Following")
                profileStatistics("30", "Posts")
            }

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Follow user")
                }
                Button(onClick = {/*TODO*/ }) {
                    Text(text = "Direct Message")
                }
            }
        }
    }
}

@Composable
fun profileStatistics(count: String, title: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = count, fontWeight = FontWeight.Bold)
        Text(text = title)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfilePage() {
    ProfilePage()
}