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
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun ProfilePageV2() {
    Card(
        elevation = 10.dp, modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 100.dp, bottom = 100.dp, start = 16.dp, end = 16.dp
            )
            .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(30.dp))
    ) {
        ConstraintLayout() {
            val (image, nameTitle, locationTitle, statisticsRow, buttonFollow, buttonDirectMessages) = createRefs()
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
                    )
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                contentScale = ContentScale.Crop

            )
            Text(
                text = "Nalan Sarrwin",
                modifier = Modifier
                    .padding(top = 10.dp)
                    .constrainAs(nameTitle) {
                        top.linkTo(image.bottom)
                        start.linkTo(image.start)
                        end.linkTo(image.end)
                    })
            Text(
                text = "Germany",
                modifier = Modifier
                    .padding(top = 10.dp)
                    .constrainAs(locationTitle) {
                        top.linkTo(nameTitle.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    })

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .constrainAs(statisticsRow) {
                        top.linkTo(locationTitle.bottom)
                    }
            ) {
                profileStatistics("150", "Followers")
                profileStatistics("100", "Following")
                profileStatistics("30", "Posts")
            }


            Button(onClick = { }, modifier = Modifier.constrainAs(buttonFollow) {
                top.linkTo(statisticsRow.bottom, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(buttonDirectMessages.start)
                width = Dimension.wrapContent
            }) {
                Text(text = "Follow user")
            }
            Button(onClick = { }, modifier = Modifier.constrainAs(buttonDirectMessages) {
                top.linkTo(statisticsRow.bottom, margin = 16.dp)
                start.linkTo(buttonFollow.end)
                end.linkTo(parent.end)
                width = Dimension.wrapContent
            }) {
                Text(text = "Direct Message")
            }

        }
    }

    @Composable
    fun profileStatisticsV2(count: String, title: String) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = count, fontWeight = FontWeight.Bold)
            Text(text = title)
        }
    }

    /*@Preview(showBackground = true)
    @Composable
    fun PreviewProfilePageV2() {
        ProfilePage()
    }*/

}