package com.social.sanyog.presentation.bottomnavigation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.material3.NavigationBarItemDefaults
import com.social.sanyog.R

@Composable
fun BottomNavigation(
    navHostController: NavHostController,
    onClick:(index:Int) -> Unit,
    selectedItem:Int
) {

    val items = listOf(
        NavigationItem("Chats", R.drawable.chat_icon, R.drawable.outline_chat_24),
        NavigationItem("Status", R.drawable.update_icon, R.drawable.update_icon),
        NavigationItem("Groups", R.drawable.baseline_groups_24, R.drawable.outline_groups_24),
        NavigationItem("Calls", R.drawable.telephone, R.drawable.outline_phone_24)
    )

    NavigationBar (containerColor = Color.White, modifier = Modifier.height(80.dp)){
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = { onClick(index)},
                label = {
                    if (index == selectedItem){
                        Text(text = item.name, color = Color.Black)
                    }else{
                        Text(text = item.name, color = Color.Gray)
                    }
                },
                icon = {
                    Icon(
                        painter = if (index == selectedItem) {
                            painterResource(item.selectedIcon)
                        } else {
                            painterResource(item.unSelectedIcon)

                        },
                        contentDescription = item.name,
                        tint = if (index == selectedItem) {
                            Color.DarkGray
                        } else {
                            Color.Black
                        },
                        modifier = Modifier.size(24.dp)
                    )
                },

                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.DarkGray,
                    unselectedIconColor = Color.Black,
                    indicatorColor = colorResource(R.color.mint_green)
                )
            )
        }
    }
}

data class NavigationItem(
    val name: String,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unSelectedIcon: Int

)