package com.amalwin.corecomposeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import com.amalwin.corecomposeapplication.ui.theme.CoreComposeApplicationTheme

/*val members: ArrayList<String> =
    arrayListOf("Member 1", "Member 2", "Member 3", "Member 4", "Member 5")*/

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreenV2()
        }
    }
}

@Composable
fun MainScreenV2(viewModel: MainViewModel = MainViewModel()) {
    // Implement the state of the composable to trigger the recomposition while there is state change.
    val membersStateList = remember { mutableStateListOf<String>("Member 1", "Member 2") }
    //val newNameState = remember { mutableStateOf("") }
    val newNameState = viewModel.nameState.value
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        GreetingListV2(
            membersStateList,
            {
                membersStateList.add(newNameState.value)
            },
            newNameState.value,
            { name -> newNameState.value = name })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GreetingListV2(
    membersStateList: List<String>,
    clickHandler: () -> Unit,
    textFieldValue: String,
    textFieldHandler: (name: String) -> Unit
) {
    for (name in membersStateList) {
        Greeting(name = name)
    }
    TextField(value = textFieldValue, onValueChange = textFieldHandler)

    Button(onClick = clickHandler) {
        Text(text = "Add a member")
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name",
        modifier = Modifier.wrapContentSize(),
        style = MaterialTheme.typography.titleLarge,
        color = Color.Black
    )

}

@Composable
fun MainScreen(name: String): Unit {
    Surface(color = Color.Magenta, modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.wrapContentSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome $name",
                modifier = Modifier.wrapContentSize(),
                style = MaterialTheme.typography.titleLarge,
                color = Color.White,
            )
            Text(
                text = "Welcome $name",
                modifier = Modifier.wrapContentSize(),
                style = MaterialTheme.typography.titleLarge,
                color = Color.White,
            )
            Row(
                modifier = Modifier.wrapContentSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Welcome $name",
                    modifier = Modifier.wrapContentSize(),
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White,
                )
                Spacer(modifier = Modifier.weight(1.0f))
                Text(
                    text = "Welcome $name",
                    modifier = Modifier.wrapContentSize(),
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White,
                )
            }
        }

    }
}

@Composable
fun horizontalVerticalBars() {
    Surface(color = Color.DarkGray, modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                color = Color.Red, modifier = Modifier
                    .height(600.dp)
                    .width(100.dp)
            ) { }
            Surface(
                color = Color.Magenta, modifier = Modifier
                    .height(600.dp)
                    .width(100.dp)
            ) { }
            Surface(
                color = Color.Blue, modifier = Modifier
                    .height(600.dp)
                    .width(100.dp)
            ) { }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    //MainScreen(name = "Android")
    // horizontalVerticalBars()
    //namesList(members)
    MainScreenV2()
}

