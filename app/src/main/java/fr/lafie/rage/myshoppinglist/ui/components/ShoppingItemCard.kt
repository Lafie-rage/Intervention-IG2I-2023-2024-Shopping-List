package fr.lafie.rage.myshoppinglist.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.lafie.rage.myshoppinglist.data.dto.ShoppingItem
import fr.lafie.rage.myshoppinglist.ui.theme.MyShoppingListTheme
import fr.lafie.rage.myshoppinglist.ui.theme.Typography
import fr.lafie.rage.myshoppinglist.utils.ShoppingItemCountFormatter

@Composable
fun ShoppingItemCard(
    shoppingItem: ShoppingItem,
) {
    val formattedCount = ShoppingItemCountFormatter.format(shoppingItem.count)

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        ) {
            Text(
                style = Typography.headlineMedium,
                text = shoppingItem.label,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Text(
                    style = Typography.bodyLarge,
                    text = formattedCount,
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    style = Typography.bodyLarge,
                    text = "Kg",
                )
            }
        }
    }
}


@Composable
@Preview(showBackground = false)
fun ShoppingItemCardPreview() {
    MyShoppingListTheme {
        ShoppingItemCard(
            ShoppingItem(
                id = 0,
                label = "Pomme de terre",
                count = 1f,
                unit = "Kg",
            )
        )
    }
}