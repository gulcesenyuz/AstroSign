package com.example.composeastrosign.ui.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.composeastrosign.data.model.ZodiacSignModel

@Composable
fun DetailsScreenContent(data: ZodiacSignModel, icon: Int, sign: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp, start = 16.dp, end = 16.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Card(
                backgroundColor = Color.White,
                shape = CircleShape,
                elevation = 50.dp,
            ) {
                Image(
                    painter = painterResource(icon),
                    contentDescription = "icon",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(6.dp)
                        .height(90.dp)
                        .width(90.dp)
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(8.dp))
                )

            }
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)) {

                if (!data.dateRange.isNullOrBlank()) {
                    Text(text = sign, color = Color.DarkGray, fontWeight = FontWeight.Bold)
                    Text(
                        text = data.dateRange,
                        color = Color.LightGray,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                } else {
                    Text(
                        text = sign,
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 24.dp)
                    )
                }
                //Todo tab gelecek
            }

        }

        Box(modifier = Modifier.padding(vertical = 16.dp)) {
            if (!data.description.isNullOrBlank()) {
                Text(
                    text = data.description,
                    color = Color.LightGray,
                    fontWeight = FontWeight.Light
                )
            } else {
                Text(text = "Sorry", color = Color.LightGray, fontWeight = FontWeight.Light)

            }
        }
    }
}