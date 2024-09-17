package com.example.charleslictof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.charleslictof.ui.theme.CharlesLiCtoFTheme

import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.material3.Slider
//import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CharlesLiCtoFTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var num by remember{ mutableStateOf(32f) }

    Column(modifier = Modifier
        .fillMaxHeight()
        .padding(horizontal = 16.dp),
//    horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Fahrenheit:", modifier = Modifier.padding(top = 64.dp, bottom = 16.dp))
        Text(text = "${num.roundToInt()}F")
        Slider(
            modifier = Modifier.semantics { contentDescription = "Fahrenheit" },
            value = num,
            valueRange = 0f..212f,
            onValueChange = { num = it },
            onValueChangeFinished = {
                if(num < 32){
                    num = 32f
                }
            },
            steps = 212
        )
        Text(text = "Celsius:", modifier = Modifier.padding(top = 64.dp, bottom = 16.dp))
        Text(text = "${((num - 32) * 5 / 9).roundToInt()}C")
        Slider(
            modifier = Modifier.semantics { contentDescription = "Celsius" },
            value = (num - 32) * 5 / 9,
            valueRange = 0f..100f,
            onValueChange = { num = it },
            steps = 212
        )

        Text(text = if (num > 68) "I wish it were colder" else "I wish it were warmer")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CharlesLiCtoFTheme {
        Greeting()
    }
}