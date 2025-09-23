package com.example.sanyog.presentation.callscreen

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sanyog.R

@Composable
@Preview(showSystemUi = true)
fun FavoritesSection(){

    val sampleFavorites = listOf(
        FavoriteContact(image = R.drawable.sharadha_kapoor, name = "Shraddha"),
        FavoriteContact(image = R.drawable.rajkummar_rao, name = "Rajkumar"),
        FavoriteContact(image = R.drawable.rashmika, name = "Rashmika"),
        FavoriteContact(image = R.drawable.tripti_dimri, name = "Tripti"),
        FavoriteContact(image = R.drawable.akshay_kumar, name = "Akshay"),
    )

    Column (modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)){

        Text(
            text = "Favorites",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Row (
            modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState())
        ){
            sampleFavorites.forEach {
                FavoritesItem(favoriteContact = it)
            }
        }
    }
}

data class FavoriteContact(
    val image: Int, val name: String
)