package fr.lafie.rage.myshoppinglist.ui.shared.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import fr.lafie.rage.myshoppinglist.ui.shared.theme.MyShoppingListTheme

@Composable
fun TextFieldForString(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    imeAction: ImeAction = ImeAction.Next,
) {
    BaseTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        label = label,
        placeholder = placeholder,
        imeAction = imeAction,
    )
}

@Composable
fun TextFieldForPositiveDecimal(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    imeAction: ImeAction = ImeAction.Next,
) {
    BaseTextField(
        modifier = modifier,
        value = value,
        onValueChange = { newValue ->
            // Permet d'éviter le faire crash l'application lorsque l'utilisateur tape un point alors qu'il y en avait déjà un dans le nombre...
            // Du point de vu de l'utilisateur, on saute juste au caractère suivant quand on appuie sur le "."
            val adjustedValue = newValue.replace("..", ".")
            onValueChange(adjustedValue)
        },
        label = label,
        placeholder = "", // Pas de placeholder car on affiche toujours une valeur par défaut.
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Decimal,
        ),
        imeAction = imeAction,
    )
}

@Composable
private fun BaseTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    imeAction: ImeAction,
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        label = {
            Text(label)
        },
        placeholder = { Text(placeholder) },
        keyboardOptions = keyboardOptions.copy(imeAction = imeAction),
        singleLine = true,
    )
}

@Composable
@Preview
fun TextFieldForStringPreview() {
    MyShoppingListTheme {
        Column {
            TextFieldForString(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                onValueChange = {},
                label = "String",
                placeholder = "Write string here",
                imeAction = ImeAction.Next,
            )
            TextFieldForPositiveDecimal(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                onValueChange = {},
                label = "Decimal",
                imeAction = ImeAction.Done,
            )
        }
    }
}
