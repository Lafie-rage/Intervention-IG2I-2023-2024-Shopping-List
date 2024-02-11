package fr.lafie.rage.myshoppinglist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fr.lafie.rage.myshoppinglist.data.dto.ShoppingItem
import fr.lafie.rage.myshoppinglist.ui.components.ShoppingItemCard
import fr.lafie.rage.myshoppinglist.ui.theme.MyShoppingListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val shoppingItem = ShoppingItem(
            id = 0,
            label = "Pomme de terre",
            count = 1f,
            unit = "Kg",
        )
        setContent {
            MyShoppingListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        ShoppingItemCard(shoppingItem)
                        ShoppingItemCard(shoppingItem)
                        ShoppingItemCard(shoppingItem)
                        ShoppingItemCard(shoppingItem)
                    }
                }
            }
        }
    }
}