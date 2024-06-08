package xyz.teamgravity.typesafecomposenavigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kotlinx.serialization.Serializable

@Composable
fun ScreenA(
    onNavigateScreenB: (name: String, age: Int) -> Unit
) {
    Scaffold { padding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                space = 10.dp,
                alignment = Alignment.CenterVertically
            ),
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Text(
                text = stringResource(id = R.string.screen_a)
            )
            Button(
                onClick = {
                    onNavigateScreenB("Raheem", 23)
                }
            ) {
                Text(
                    text = stringResource(id = R.string.navigate_screen_b)
                )
            }
        }
    }
}

@Serializable
data object ScreenA