package com.example.wms.functions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wms.LoginScreen
import com.example.wms.R
import com.example.wms.ui.theme.WMSTheme

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {

    WMSTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = "dashboard"
        ) {
            composable("dashboard") {
                DashboardScreen(navController)
            }
        }
    }
}

@Composable
fun DashboardScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xF5F5F5)),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxHeight()
                .padding(1.dp)
        ){
            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(0.9f)
                    .height(120.dp)
                    .background(Color(0xFFFFFF)),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )

            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(1.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(10.dp)
                    ) {
                        Text(
                            text = "Welcome ${"chiru"}",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Here's a summary of your activity.",
                            fontSize = 14.sp
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.ic_announce), // Replace with your image
                        contentDescription = "Dashboard Icon",
                        modifier = Modifier
                            .size(464.dp)
                            .padding(end = 1.dp)
                    )
                }
            }

            Card(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(0.9f)
                    .height(280.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(8.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween, // Spread icons evenly
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_left),
                            contentDescription = "Left Icon",
                            modifier = Modifier.size(50.dp)
                        )

                        Image(
                            painter = painterResource(id = R.drawable.ic_sun),
                            contentDescription = "Center Icon",
                            modifier = Modifier.size(50.dp)
                        )

                        Image(
                            painter = painterResource(id = R.drawable.ic_right),
                            contentDescription = "Right Icon",
                            modifier = Modifier.size(50.dp)
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TimeUnitBox(value = "10", label = "HH")
                        Spacer(modifier = Modifier.width(8.dp))
                        TimeUnitBox(value = "22", label = "MM")
                        Spacer(modifier = Modifier.width(8.dp))
                        TimeUnitBox(value = "24", label = "SS")
                    }
                    Text(
                        text = "General Timings start from 6 am to 2 pm",
                        fontSize = 10.sp,
                    )

                    Spacer(modifier = Modifier.height(18.dp))
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .width(180.dp)
                    ) {
                        Text(text = "Check In")
                    }
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            Column(
                modifier = Modifier
                    .padding(6.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(52.dp, Alignment.CenterHorizontally)
                ) {
                    Button(
                        onClick = {
                            navController.navigate("profile")
                        },
                        modifier = Modifier.width(140.dp)
                    ) {
                        Text("Attendence")
                    }
                    Button(
                        onClick = {
                            navController.navigate("profile")
                        },
                        modifier = Modifier.width(140.dp)
                    ) {
                        Text("Leave")
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(52.dp, Alignment.CenterHorizontally)
                ) {
                    Button(
                        onClick = {
                            navController.navigate("profile")
                        },
                        modifier = Modifier.width(140.dp)
                    ) {
                        Text("Salary")
                    }
                    Button(
                        onClick = {
                            navController.navigate("profile")
                        },
                        modifier = Modifier.width(140.dp)
                    ) {
                        Text("Events")
                    }
                }
            }
        }
    }
}

@Composable
fun TimeUnitBox(value: String, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .size(width = 60.dp, height = 60.dp)
            .background(Color.LightGray, RoundedCornerShape(12.dp))
            .border(1.dp, Color.Gray, RoundedCornerShape(12.dp))
            .padding(8.dp)
    ) {
        Text(
            text = value,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = label,
            fontSize = 10.sp,
            color = Color.DarkGray
        )
    }
}

