package com.amalwin.jetpackcomposerecyclerviewdemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amalwin.jetpackcomposerecyclerviewdemo.data.TvShowList
import com.amalwin.jetpackcomposerecyclerviewdemo.model.TvShow
import com.amalwin.jetpackcomposerecyclerviewdemo.ui.theme.JetpackComposeRecyclerViewDemoTheme

class InfoActivity : ComponentActivity() {
    companion object {
        private const val tvShowId = "TvShowId"
        fun intent(context: Context, tvShow: TvShow) =
            Intent(context, InfoActivity::class.java).apply {
                putExtra(tvShowId, tvShow)
            }
    }

    private val tvShow: TvShow by lazy {
        intent?.getSerializableExtra(tvShowId) as TvShow
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            viewMoreInfo(tvShow = tvShow)
        }
    }
}

@Composable
fun viewMoreInfo(tvShow: TvShow) {
    val scrollState: ScrollState = rememberScrollState()
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(), shape = RoundedCornerShape(corner = CornerSize(10.dp))
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .verticalScroll(scrollState)
        ) {
            Image(
                painter = painterResource(id = tvShow.imageId),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(corner = CornerSize(5.dp)))
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = tvShow.name,
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = tvShow.overview,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Normal
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Actual Release: ${tvShow.year}",
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = "IMDB: ${tvShow.rating}",
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    JetpackComposeRecyclerViewDemoTheme {
        viewMoreInfo(tvShow = TvShowList.tvShowList.get(0))
    }
}