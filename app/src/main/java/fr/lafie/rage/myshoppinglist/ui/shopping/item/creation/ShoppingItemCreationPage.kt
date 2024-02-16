package fr.lafie.rage.myshoppinglist.ui.shopping.item.creation

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.lafie.rage.myshoppinglist.R
import fr.lafie.rage.myshoppinglist.ui.shared.component.TextFieldForPositiveDecimal
import fr.lafie.rage.myshoppinglist.ui.shared.component.TextFieldForString
import fr.lafie.rage.myshoppinglist.ui.shared.theme.Typography

@Composable
fun ShoppingItemCreationPage() {
    val context = LocalContext.current

    var state by remember { mutableStateOf(ShoppingItemCreationState()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                style = Typography.headlineLarge,
                text = stringResource(id = R.string.shopping_item_creation_header)
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp),
            )
            Column {
                TextFieldForString(
                    modifier = Modifier.fillMaxWidth(),
                    label = stringResource(id = R.string.label_text_field_label),
                    placeholder = stringResource(
                        id = R.string.text_field_placeholder,
                        stringResource(id = R.string.label_text_field_label).lowercase()
                    ),
                    value = state.label,
                    onValueChange = { label: String ->
                        state = state.copy(label = label)
                    },
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(16.dp),
                )
                TextFieldForPositiveDecimal(
                    modifier = Modifier.fillMaxWidth(),
                    label = stringResource(id = R.string.count_text_field_label),
                    value = state.count,
                    onValueChange = { count ->
                        state = state.copy(count = count)
                    },
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(16.dp),
                )
                TextFieldForString(
                    modifier = Modifier.fillMaxWidth(),
                    label = stringResource(id = R.string.unit_text_field_label),
                    placeholder = stringResource(
                        id = R.string.text_field_placeholder,
                        stringResource(id = R.string.unit_text_field_label).lowercase()
                    ),
                    value = state.unit,
                    onValueChange = { unit ->
                        state = state.copy(unit = unit.trim())
                    },
                    imeAction = ImeAction.Done,
                )
            }

        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    Toast.makeText(
                        context,
                        "A new item has been added to your shopping list !",
                        Toast.LENGTH_SHORT
                    ).show()
                }) {
                Text(text = stringResource(id = R.string.create_shopping_item_label))
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun ShoppingItemCreationPagePreview() {
    ShoppingItemCreationState()
}
