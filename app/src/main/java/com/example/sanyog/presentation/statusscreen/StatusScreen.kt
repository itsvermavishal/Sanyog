package com.example.sanyog.presentation.statusscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sanyog.R
import com.example.sanyog.presentation.bottomnavigation.BottomNavigation

@Composable
@Preview(showSystemUi = true)
fun StatusScreen() {

    val scrollState = rememberScrollState()

    val sampleStatus = listOf(
        Statusdata(
            image = R.drawable.hrithik_roshan,
            name = "Hritik Roshan",
            time = "10 min ago"
        ),
        Statusdata(
            image = R.drawable.carryminati,
            name = "CarryMinati",
            time = "45 min ago"
        ),
        Statusdata(
            image = R.drawable.mrbeast,
            name = "Mr. Beast",
            time = "2 hours ago"
        )
    )

    val sampleChannel = listOf(
        Channels(
            image = R.drawable.neat_roots,
            name = "Neat Roots",
            description = "Latest news in tech"
        ),
        Channels(
            image = R.drawable.girl,
            name = "Shraddha",
            description = "Cutest girls"
        ),
        Channels(
            image = R.drawable.mrbeast,
            name = "Beast",
            description = "Explore the Unexplored"
        )
    )

    Scaffold(
        floatingActionButton = {

            FloatingActionButton(
                onClick = { /*TODO*/ },
                containerColor = colorResource(id = R.color.light_green),
                modifier = Modifier.size(60.dp),
                contentColor = Color.White
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_photo_camera_24),
                    contentDescription = null,
                    modifier = Modifier.size(28.dp),
                )
            }
        },
        bottomBar = {
            BottomNavigation()
        },
        topBar = {
            TopBar()
        }
    ) {
        Column(modifier = Modifier.padding(it).fillMaxSize().verticalScroll(scrollState)) {

            Text(
                text = "Status",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
            )

            MyStatus()

            sampleStatus.forEach { data ->
                StatusItem(statusdata = data)
            }
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(
                color = Color.Gray
            )

            Text(
                text = "Channels",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Column(modifier = Modifier.padding(horizontal = 16.dp)) {

                Text(text = "Stay updated on topics that matter to you. Find channels to follow below")

                Spacer(modifier = Modifier.height(32.dp))
                Text(text = "Find channels to follow")
            }
            Spacer(modifier = Modifier.height(16.dp))

            sampleChannel.forEach { channel ->
                ChannelItemDesign(channel = channel)
            }
        }
    }
}