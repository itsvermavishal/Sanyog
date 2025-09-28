package com.social.sanyog.presentation.groupsscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.social.sanyog.R
import com.social.sanyog.presentation.bottomnavigation.BottomNavigation
import com.social.sanyog.presentation.navigation.Routes

@Composable
fun GroupsScreen(navHostController: NavHostController){

    var isSearching by remember { mutableStateOf(false) }

    var search by remember { mutableStateOf("") }

    var showMenu by remember { mutableStateOf(false) }

    val groupsSample = listOf(
        Groups(
            image = R.drawable.img,
            name = "Tech Enthusiasts",
            memberCount = "256 members"
        ),
        Groups(
            image = R.drawable.girl2,
            name = "Smart Womens",
            memberCount = "3790 members"
        ),
        Groups(
            image = R.drawable.img,
            name = "Tech Enthusiasts Fan",
            memberCount = "128 members"
        ),
    )

    Scaffold (topBar = {
        Box(modifier = Modifier.fillMaxWidth()) {
            Column {

                Row {
                    if (isSearching) {
                        TextField(
                            value = search, onValueChange = { search = it },
                            placeholder = {
                                Text(text = "Search")
                            },
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            modifier = Modifier.padding(start = 12.dp),
                            singleLine = true
                        )
                    } else {
                        Text(
                            text = "Groups",
                            fontSize = 28.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 12.dp, top = 5.dp)
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    if (isSearching) {
                        IconButton(onClick = {
                            isSearching = false
                            search = ""
                        }) {

                            Icon(
                                painter = painterResource(id = R.drawable.cross),
                                contentDescription = null,
                                modifier = Modifier.size(15.dp)
                            )
                        }
                    } else {


                        IconButton(onClick = { isSearching = true }) {

                            Icon(
                                painter = painterResource(id = R.drawable.search),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                        }

                        IconButton(onClick = {
                            showMenu = true
                        }) {

                            Icon(
                                painter = painterResource(id = R.drawable.more),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )

                            DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false }) {

                                DropdownMenuItem(text = { Text(text = "Settings") }, onClick = { showMenu = false })
                            }
                        }

                    }
                }
                HorizontalDivider()
            }
        }
    },
        bottomBar = {
            BottomNavigation(navHostController, selectedItem = 0, onClick = {item ->

                when(item){
                    0 -> navHostController.navigate(Routes.HomeScreen)
                    1 -> navHostController.navigate(Routes.StatusScreen)
                    2 -> navHostController.navigate(Routes.GroupsScreen)
                    3 -> navHostController.navigate(Routes.CallScreen)
                }
            })
        }){
        Column(modifier = Modifier.padding(it)){

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.light_green)),
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) {

                Text(text = "Start a new Group", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Your Groups",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )

            LazyColumn {
                items(groupsSample.size){
                    GroupItemDesign(groups = groupsSample[it])
                }
            }
        }
    }
}