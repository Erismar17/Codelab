package co.edu.sena.basicscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.edu.sena.basicscodelab.ui.theme.BasicsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                MyApp()
            }
        }
    }
}
@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("World", "Compose")
) {
    Column(modifier = modifier.padding(vertical = 4.dp)) {
        for (name in names) {
            Greeting(name = name)
        }
    }
}
@Composable
private fun Greeting(name: String) {
    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp
    Surface(color = Color.LightGray, modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier.weight(1f).padding(bottom = extraPadding)) {
                Text(text = "Hello")
                Text(text = name)
            }
            ElevatedButton(
                onClick = { expanded.value = !expanded.value}) {
                Text(if (expanded.value) "Show less" else "Show more")
            }
        }
    }
}
@Preview(showBackground = true, widthDp = 300)
@Composable
private fun DefaultPreview() {
    BasicsCodelabTheme {
        MyApp()
    }
}