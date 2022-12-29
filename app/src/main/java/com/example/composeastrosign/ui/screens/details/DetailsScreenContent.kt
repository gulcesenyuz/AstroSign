package com.example.composeastrosign.ui.screens.details

import android.graphics.drawable.Icon
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.composeastrosign.data.model.ZodiacSignModel
import com.example.composeastrosign.ui.screens.components.colorInfo
import com.example.composeastrosign.ui.screens.components.dayListRow
import com.example.composeastrosign.ui.screens.components.infoRow

@Composable
fun DetailsScreenContent(data: ZodiacSignModel, icon: Int, sign: String, day: String, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp, start = 16.dp, end = 16.dp)
    ) {
        IconButton(onClick = {
            //TODO
            navController.popBackStack()
        }) {
            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Go Back")
        }

        Row(modifier = Modifier.fillMaxWidth().padding(top = 24.dp).padding(bottom = 24.dp)) {
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
            }

        }
        dayListRow(day)

        Box(modifier = Modifier.padding(vertical = 16.dp)) {
            if (!data.description.isNullOrBlank()) {
                Text(
                    text = data.description,
                    color = Color.Gray,
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp,
                )
            } else {
                Text(text = "Sorry", color = Color.Gray, fontWeight = FontWeight.Light)

            }
        }
        if (!data.color.isNullOrBlank()) {
            colorInfo(data.color)
        }
        if (!data.luckyNumber.isNullOrBlank()) {
            infoRow(data.luckyNumber)
        } else {
            infoRow("undefined")
        }
        if (!data.luckyTime.isNullOrBlank()) {
            infoRow(data.luckyTime)
        } else {
            infoRow("undefined")
        }
        if (!data.mood.isNullOrBlank()) {
            infoRow(data.mood)
        } else {
            infoRow("undefined")
        }
        if (!data.compatibility.isNullOrBlank()) {
            infoRow(data.compatibility)
        } else {
            infoRow("undefined")
        }


    }
}