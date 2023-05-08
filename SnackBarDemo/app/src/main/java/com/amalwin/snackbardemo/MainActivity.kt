package com.amalwin.snackbardemo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.amalwin.snackbardemo.ui.theme.SnackBarDemoTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SnackBarDemoTheme {
                // A surface container using the 'background' color from the theme
                    Row(
                        modifier = Modifier
                            .background(color = Color.Red)
                            .fillMaxSize(0.5f)
                    , horizontalArrangement = Arrangement.Center
                    , verticalAlignment = Alignment.CenterVertically
                    ) {
                        Greeting("Android")
                        showSnackBar()
                    }
                }
            }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun showSnackBar() {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope: CoroutineScope = rememberCoroutineScope()

    Scaffold(scaffoldState = scaffoldState) {
        Button(
            onClick = {
                coroutineScope.launch {
                    val snackBarResult = scaffoldState.snackbarHostState.showSnackbar(
                        message = "Snackbar Message !",
                        actionLabel = "Undo",
                        duration = SnackbarDuration.Long
                    )
                    when (snackBarResult) {
                        SnackbarResult.ActionPerformed -> Log.i("MYTAG", "Action label clicked !")
                        SnackbarResult.Dismissed -> Log.i("MYTAG", "Snackbar dismissed !")
                    }
                }
            }, enabled = true
        ) {
            Text(
                text = "Click for Snackbar",
                style = MaterialTheme.typography.h6
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SnackBarDemoTheme {
        Greeting("Android")
    }
}