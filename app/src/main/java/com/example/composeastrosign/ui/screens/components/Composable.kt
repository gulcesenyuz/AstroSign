package com.example.composeastrosign.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.composeastrosign.ui.screens.dayList
import com.example.composeastrosign.ui.screens.model.MenuItemModel
import com.example.composeastrosign.ui.theme.*

@Composable
fun GridSnackCardWithTitle(
    sign: MenuItemModel,
    navController: NavHostController,
    day: String,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        val density = LocalDensity.current.density

        Box(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxSize()
                .aspectRatio(1f)
                .clickable {
                    navController.navigate("details/${sign.itemName}/${day}/${sign.itemImage}")
                },
        ) { imageAvatar(icon = sign.itemImage, iconName = sign.itemName) }

        Spacer(modifier = Modifier.height(4.dp))
        var padding by remember { mutableStateOf(0.dp) }
        Text(
            modifier = Modifier.padding(start = 4.dp, end = 4.dp, bottom = padding),
            text = sign.itemName,
            fontSize = 19.sp,
            fontWeight = (FontWeight.Bold),
            color = Color(0xFF3b236c),
            onTextLayout = {
                val lineCount = it.lineCount
                val height = (it.size.height / density).dp
                padding = if (lineCount > 1) 0.dp else height
            }
        )

    }

}

@Composable
fun imageAvatar(icon: Int, iconName: String) {
    Card(
        backgroundColor = Color.White,
        shape = CircleShape,
        elevation = 50.dp,
    ) {
        Image(
            painter = painterResource(icon),
            contentDescription = iconName,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(6.dp)
                .height(90.dp)
                .width(90.dp)
                .aspectRatio(1f)
                .clip(RoundedCornerShape(8.dp))
        )

    }

}

@Composable
fun dayListRow(day: String) {
    LazyRow {
        itemsIndexed(dayList) { index, item ->
            if (dayList[index] == day) {
                Card(
                    modifier = Modifier
                        .padding(8.dp),
                    elevation = 6.dp,
                    backgroundColor = Color.Red
                )
                {
                    Text(
                        text = dayList[index],
                        fontSize = 12.sp,
                        modifier = Modifier.padding(4.dp),
                        color = Color.Magenta, textAlign = TextAlign.Center
                    )

                }
            } else {
                Card(
                    modifier = Modifier
                        .padding(8.dp),
                    elevation = 6.dp
                )
                {
                    Text(
                        text = dayList[index],
                        fontSize = 12.sp,
                        modifier = Modifier.padding(4.dp),
                        color = Color.Magenta, textAlign = TextAlign.Center
                    )

                }
            }

        }
    }
}

@Composable
fun colorInfo(color: String) {
    var boxColor: Color = Teal200
    Row {
        Text(text = "Color: ", fontSize = 12.sp, fontWeight = Bold)
        when (color) {
            "Blue" -> {
                boxColor = Blue
            }
            "Brown" -> {
                boxColor = Brown
            }
            "Silver" -> {
                boxColor = Silver
            }
            "Copper" -> {
                boxColor = Copper
            }
            "Orchid" -> {
                boxColor = Orchid
            }
            "Purple" -> {
                boxColor = Purple
            }
            "Green" -> {
                boxColor = Green
            }
            "Pink" -> {
                boxColor = Pink
            }
            "Orange" -> {
                boxColor = Orange
            }
        }
        if (boxColor == Teal200) {
            Text(text = color, fontSize = 12.sp, fontWeight = Normal)
        } else {
            Box(
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp)
                    .padding(4.dp)
                    .fillMaxSize()
                    .aspectRatio(1f)
                    .background(boxColor, shape = CircleShape),
            )
        }


    }

}



