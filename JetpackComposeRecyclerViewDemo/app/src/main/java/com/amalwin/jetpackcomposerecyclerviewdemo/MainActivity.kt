package com.amalwin.jetpackcomposerecyclerviewdemo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amalwin.jetpackcomposerecyclerviewdemo.data.TvShowList
import com.amalwin.jetpackcomposerecyclerviewdemo.model.TvShow
import com.amalwin.jetpackcomposerecyclerviewdemo.ui.theme.JetpackComposeRecyclerViewDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //ComposableListView()
            /*LazyColumnRecyclerViewComposable {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }*/
            showTVShows {
                //Toast.makeText(this, "${it.name} selected", Toast.LENGTH_LONG).show()
                startActivity(InfoActivity.intent(this, it))
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun ComposableListView() {
    val scrollState: ScrollState = rememberScrollState()
    Column(
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        for (i in 1..100) {
            Text(
                text = "Student $i",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(10.dp)
            )
            Divider(color = Color.Black, thickness = 5.dp)
        }
    }
}

@Composable
fun LazyColumnRecyclerViewComposable(selectedItem: (String) -> (Unit)) {
    LazyColumn() {
        items(100) {
            Text(
                text = "Student ${it + 1}",
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .padding(10.dp)
                    .clickable {
                        selectedItem("${it + 1} Selected")
                    }
            )
            Divider(color = Color.Black, thickness = 5.dp)
        }
    }
}

@Composable
fun showTVShows(selectedItem: (TvShow) -> (Unit)) {
    val tvShowList = remember { TvShowList.tvShowList }
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
        items(
            items = tvShowList,
            itemContent = {
                showTvShowListItemComposable(tvShow = it, selectedItem = selectedItem)
            }
        )
    }
}

@Composable
fun showTvShowImageComposable(tvShow: TvShow) {
    Image(
        painter = painterResource(id = tvShow.imageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(10.dp)
            .height(160.dp)
            .width(140.dp)
            .clip(RoundedCornerShape(corner = CornerSize(10.dp)))
    )
}

@Composable
fun showTvShowListItemComposable(tvShow: TvShow, selectedItem: (TvShow) -> (Unit)) {
    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        elevation = 10.dp,
        shape = RoundedCornerShape(corner = CornerSize(5.dp))
    ) {
        Row(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .clickable { selectedItem(tvShow) }, verticalAlignment = Alignment.CenterVertically
        ) {
            showTvShowImageComposable(tvShow = tvShow)
            Column() {
                Text(
                    text = tvShow.name,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = tvShow.overview,
                    style = MaterialTheme.typography.h6,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = tvShow.year.toString(),
                        style = MaterialTheme.typography.h6
                    )
                    Text(
                        text = tvShow.rating.toString(),
                        style = MaterialTheme.typography.h6
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeRecyclerViewDemoTheme {
        Greeting("Android")
    }
}