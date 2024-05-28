package com.amalwintech.profilecardlayout

import android.graphics.drawable.VectorDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.amalwintech.profilecardlayout.ui.theme.LightGreen200
import com.amalwintech.profilecardlayout.ui.theme.ProfileCardLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UsersApplication()
        }
    }
}

@Composable
fun UsersApplication(userProfileList: List<UserProfile> = userProfileListHolder) {
    val navController = rememberNavController()
    NavHost(navController = navController, "employee_list") {
        composable("employee_list") {
            EmployeeListView(userProfileList, navController)
        }
        composable(
            route = "employee_Details/{employee_id}",
            arguments = listOf(navArgument("employee_id") {
                type = NavType.IntType
            })
        ) { navBackStackEntry ->
            EmployeeDetailView(navBackStackEntry.arguments!!.getInt("employee_id"), navController)
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmployeeListView(userProfileList: List<UserProfile>, navController: NavHostController?) {
    Scaffold(topBar = {
        AppBar(
            title = "Employee List",
            navigationIcon = Icons.Default.Home
        ) {

        }
    }) { padding ->
        Surface(
            color = Color.LightGray,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            /*Column() {
                for (userProfile in userProfileList)
                    ProfileCard(userProfile)
            }*/

            LazyColumn() {
                items(userProfileList) { userProfile ->
                    ProfileCard(userProfile) {
                        navController?.navigate("employee_Details/${userProfile.userId}") {

                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(title: String, navigationIcon: ImageVector, onClickListener: () -> Unit) {
    TopAppBar(
        title = { Text(text = "Messaging Application User") },
        navigationIcon = {
            Icon(
                navigationIcon,
                contentDescription = "",
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .clickable {
                        onClickListener.invoke()
                    },
            )
        },
    )
}

@Composable
fun ProfileCard(userProfile: UserProfile, onClickListener: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(Alignment.Top)
            .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
            .clickable(onClick = { onClickListener.invoke() }),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = CutCornerShape(topEnd = 24.dp),

        ) {
        Row(
            modifier = Modifier.wrapContentSize(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProfileCardImage(userProfile.onlineStatus, userProfile.url, 72.dp)
            ProfileContent(userProfile.name, userProfile.onlineStatus, Alignment.Start)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileCardImage(onlineStatus: Boolean, pictureDrawable: String, pictureSize: Dp) {
    Card(
        onClick = {},
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        shape = CircleShape,
        border = if (onlineStatus)
            BorderStroke(2.dp, color = LightGreen200) else
            BorderStroke(2.dp, color = Color.Red),
        modifier = Modifier.padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),

        ) {
        /*Image(
            painter = painterResource(id = drawable),
            contentDescription = "Content Description",
            modifier = Modifier.size(72.dp),
            contentScale = ContentScale.Crop
        )*/
        /*AsyncImage(
            model = "https://ik.imagekit.io/demo/default-image.jpg",
            contentDescription = null,
            modifier = Modifier.size(72.dp),
            contentScale = ContentScale.Crop
        )*/

        /*AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(pictureDrawable)
                .crossfade(true)
                .transformations(CircleCropTransformation())
                .build(),
            contentDescription = null,
            modifier = Modifier.size(72.dp),
            contentScale = ContentScale.Crop
        )*/
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(data = R.drawable.profile_image_2)
                    .apply {
                        transformations(CircleCropTransformation())
                    }.build()
            ),
            modifier = Modifier.size(pictureSize),
            contentDescription = "Profile picture description",
        )
    }
}

@Composable
fun ProfileContent(name: String, onlineStatus: Boolean, alignment: Alignment.Horizontal) {
    var status = "Active Now"
    Column(
        modifier = Modifier
            .padding(8.dp),
        horizontalAlignment = alignment
    ) {
                CompositionLocalProvider(
            LocalContentColor provides
                    if (onlineStatus) {
                        MaterialTheme.colorScheme.onSurface.copy(alpha = 1f)
                    } else {
                        status = "Offline"
                        MaterialTheme.colorScheme.onSurface.copy(alpha = .5f)
                    }
        ) {
            Text(text = name, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = status, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmployeeDetailView(userId: Int, navHostController: NavHostController?) {
    val userProfile = userProfileListHolder.first { userProfile ->
        userId == userProfile.userId
    }
    Scaffold(topBar = {
        AppBar(
            title = "Employee Details",
            navigationIcon = Icons.Default.ArrowBack
        ) {
            navHostController?.navigateUp()
        }
    }) { paddingValues ->
        Surface(
            color = Color.LightGray,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                EmployeeDetail(userProfile = userProfile)
            }

        }
    }
}

@Composable
fun EmployeeDetail(userProfile: UserProfile) {
    ProfileCardImage(
        onlineStatus = userProfile.onlineStatus,
        pictureDrawable = userProfile.url,
        pictureSize = 240.dp
    )
    ProfileContent(
        name = userProfile.name,
        onlineStatus = userProfile.onlineStatus,
        Alignment.CenterHorizontally
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun EmployeeProfileListPreview() {
    ProfileCardLayoutTheme {
        EmployeeListView(userProfileList = userProfileListHolder, null)
    }
}

@Composable
@Preview(showBackground = true)
fun EmployeeDetailPreview() {
    ProfileCardLayoutTheme() {
        EmployeeDetailView(userId = 10, null)
    }
}