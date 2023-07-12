package com.zsiqi.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.zsiqi.happybirthday.ui.theme.HappyBirthdayTheme
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HappyBirthday()
                }
            }
        }
    }
}

@Composable
fun HappyBirthday() {
    BirthdayGreetingWithImage(
        HappyBirthday = stringResource(R.string.happy_birthday_to_you),
        from = stringResource(R.string.from),
        message = stringResource(R.string.happy_birthday_to_stranger)
    )
    BirthdayGreetingButton()
}

@Composable
fun CelebrateText() {
    Text(text = "text")
}

@Composable
fun BirthdayGreetingWithImage(HappyBirthday: String, from: String, message: String) {
    val image = painterResource(R.drawable.androidparty)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        BirthdayGreetingWithText(HappyBirthday = HappyBirthday, from = from, message = message)
    }
}

@Composable
fun BirthdayGreetingButton(modifier: Modifier = Modifier) {
    var showText by remember { mutableStateOf(0) }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = modifier.height(100.dp))
        Button(onClick = {
            if (showText == 0) {
                showText++
            } else {
                showText--
            }
        }) {
            Text("Celebrate")
        }
    }
    if (showText == 1) {
        CelebrateText()
    }
}

@Composable
fun BirthdayGreetingWithText(
    HappyBirthday: String,
    from: String,
    message: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = HappyBirthday,
            fontSize = 30.sp,
            fontWeight = FontWeight(1000),
            modifier = modifier.padding(
                start = 16.dp,
                top = 50.dp,
                end = 16.dp,
                bottom = 16.dp
            )
        )
        Text(
            text = from,
            fontSize = 25.sp,
            fontWeight = FontWeight(600),
            modifier = modifier
                .align(
                    alignment = Alignment.End
                )
                .padding(
                    top = 16.dp,
                    end = 30.dp
                )
        )
        Spacer(modifier = modifier.height(50.dp))
        Text(
            text = message,
            fontWeight = FontWeight(1000),
            textAlign = TextAlign.Center,
            modifier = modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(start = 30.dp, end = 30.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HappyBirthdayTheme {
        HappyBirthday()
    }
}
