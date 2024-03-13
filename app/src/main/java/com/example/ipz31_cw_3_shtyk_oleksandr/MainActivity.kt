package com.example.ipz31_cw_3_shtyk_oleksandr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Surface as Surface1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IPZ31_CW_3_Shtyk_OleksandrTheme {
                // A surface container using the 'background' color from the theme

            }
        }
    }

    private fun IPZ31_CW_3_Shtyk_OleksandrTheme(function: () -> Unit) {
        TODO("Not yet implemented")
    }
}

data class DayItem(val day: Int, val title: String, val imageRes: Int, val caption: String)

@Composable
fun FunCard(dayItem: DayItem) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = dayItem.title, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(150.dp))
        Image(
            painter = painterResource(id = dayItem.imageRes),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(165.dp)
                .clip(shape = RoundedCornerShape(150.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(150.dp))
        Text(text = dayItem.caption)
    }
}

@Composable
fun FunCtion() {
    val daysList = FunList()

    LazyColumn {
        items(daysList) { dayItem ->
            FunCard(dayItem = dayItem)
        }
    }
}

@Composable
fun FunList(): List<DayItem> {
    val dayResources = listOf(
        R.drawable.vector, R.drawable.vector, R.drawable.vector,
        R.drawable.vector, R.drawable.vector, R.drawable.vector
    )

    val dayTitles = listOf(
        "1", "2", "3", "4", "5", "6"
    )

    val dayCaptions = listOf(
        "Day 1", "Day 2", "Day 3",
        "Day 4", "Day 5", "Day 6",
    )

    return (1..10).mapIndexed { index, day ->
        DayItem(
            day = day,
            title = dayTitles[index % dayTitles.size],
            imageRes = dayResources[index % dayResources.size],
            caption = dayCaptions[index % dayCaptions.size]
        )
    }
}
