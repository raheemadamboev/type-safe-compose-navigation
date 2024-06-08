package xyz.teamgravity.typesafecomposenavigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kotlinx.serialization.Serializable

@Composable
fun ScreenB(
    args: ScreenB
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
                text = stringResource(id = R.string.screen_b)
            )
            args.name?.let { name ->
                Text(
                    text = name
                )
            }
            Text(
                text = stringResource(id = R.string.your_years_old, args.age)
            )
        }
    }
}

@Serializable
data class ScreenB(
    val name: String?,
    val age: Int
)