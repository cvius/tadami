package eu.kanade.presentation.manga

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import eu.kanade.tachiyomi.R

@Composable
fun DuplicateMangaDialog(
    onDismissRequest: () -> Unit,
    onMigrate: () -> Unit,
    onConfirm: () -> Unit,
    onOpenManga: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        confirmButton = {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                TextButton(
                    onClick = {
                        onDismissRequest()
                        onOpenManga()
                    },
                ) {
                    Text(text = stringResource(R.string.action_show_manga))
                }
                Spacer(modifier = Modifier.weight(1f))
                TextButton(
                    onClick = {
                        onDismissRequest()
                        onMigrate()
                    },
                ) {
                    Text(text = stringResource(R.string.migrate))
                }
                TextButton(
                    onClick = {
                        onDismissRequest()
                        onConfirm()
                    },
                ) {
                    Text(text = stringResource(R.string.action_just_add))
                }
            }
        },
        title = {
            Text(text = stringResource(R.string.are_you_sure))
        },
        text = {
            Text(text = stringResource(R.string.confirm_add_duplicate_manga))
        },
    )
}
