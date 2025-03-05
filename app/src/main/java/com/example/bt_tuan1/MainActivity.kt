package com.example.bt_tuan1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bt_tuan1.ui.theme.BT_tuan1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BT_tuan1Theme {
                ProfileScreen()
            }
        }
    }
}

@Composable
fun ProfileScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            TopActionButtons()
            ProfileContent()git init

        }
    }
}

@Composable
fun TopActionButtons() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.25f)
            .padding(16.dp)
    ) {
        ActionButton(icon = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
        ActionButton(icon = Icons.Filled.Edit, contentDescription = "Edit", tint = Color.Green)
    }
}

@Composable
fun ActionButton(icon: androidx.compose.ui.graphics.vector.ImageVector, contentDescription: String, tint: Color = Color.Unspecified) {
    OutlinedButton(
        onClick = { },
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.size(50.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = tint,
            modifier = Modifier.requiredSize(28.dp)
        )
    }
}

@Composable
fun ProfileContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileImage()
        ProfileName("Johan Smith")
        ProfileLocation("California, USA")
    }
}

@Composable
fun ProfileImage() {
    Image(
        painter = painterResource(id = R.drawable.avatar),
        contentDescription = "Profile Picture",
        modifier = Modifier
            .padding(20.dp)
            .size(200.dp)
            .clip(CircleShape)
    )
}

@Composable
fun ProfileName(name: String) {
    Text(
        text = name,
        fontWeight = FontWeight.Bold,
        fontSize = 42.sp,
        fontFamily = FontFamily.Serif
    )
}

@Composable
fun ProfileLocation(location: String) {
    Text(
        text = location,
        fontSize = 28.sp,
        fontFamily = FontFamily.Serif
    )
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    BT_tuan1Theme {
        ProfileScreen()
    }
}
