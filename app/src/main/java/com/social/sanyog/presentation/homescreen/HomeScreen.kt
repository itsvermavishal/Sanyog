package com.social.sanyog.presentation.homescreen

import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.social.sanyog.R
import com.social.sanyog.presentation.bottomnavigation.BottomNavigation
import com.social.sanyog.presentation.chat_box.ChatListBox
import com.social.sanyog.presentation.chat_box.ChatListModel

@Composable
@Preview(showSystemUi = true)
fun HomeScreen() {

    val chatData = listOf(
        ChatListModel(
            image = R.drawable.salman_khan,
            name = "Salman Khan",
            time = "10:00AM",
            message = "Hi, how are you?"
        ),

        ChatListModel(
            image = R.drawable.rashmika,
            name = "Rashmika Mandana",
            time = "9:00AM",
            message = "Hi"
        ),

        ChatListModel(
            image = R.drawable.sharadha_kapoor,
            name = "Sharadha Kapoor",
            time = "12:00PM",
            message = "how are you?"
        ),

        ChatListModel(
            image = R.drawable.tripti_dimri,
            name = "Tripti Dimiri",
            time = "2:00PM",
            message = "Hello"
        ),
        ChatListModel(
            image = R.drawable.girl2,
            name = "Aaliya",
            time = "7:00AM",
            message = "Nice"
        ),
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
                    painter = painterResource(id = R.drawable.add_chat_icon),
                    contentDescription = null,
                    modifier = Modifier.size(28.dp),
                )
            }
        },

        bottomBar = {
            BottomNavigation()
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            Spacer(modifier = Modifier.height(16.dp))
            Box(modifier = Modifier.fillMaxWidth()){

                Text(
                    text = "Sanyog",
                    fontSize = 28.sp,
                    color = colorResource(id = R.color.light_green),
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 16.dp),
                    fontWeight = FontWeight.Bold
                )
                Row (modifier = Modifier.align(Alignment.CenterEnd)){

                    IconButton(onClick = { }) {

                        Icon(
                            painter = painterResource(id = R.drawable.camera),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }

                    IconButton(onClick = { }) {

                        Icon(
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }

                    IconButton(onClick = { }) {

                        Icon(
                            painter = painterResource(id = R.drawable.more),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }

            HorizontalDivider()

            LazyColumn {

                items(chatData){it ->

                    ChatListBox(chatListModel = it)
                }
            }
        }
    }
}