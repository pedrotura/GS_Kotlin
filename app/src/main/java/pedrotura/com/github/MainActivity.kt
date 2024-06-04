package pedrotura.com.github

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.RecyclerView
import pedrotura.com.github.listapraias.adapter.ItemsAdapter
import pedrotura.com.github.listapraias.model.ItemPraia
import pedrotura.com.github.ui.theme.PedroTura_RM93391_modelo_recyclerViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val itemsAdapter = ItemsAdapter()
        recyclerView.adapter = itemsAdapter

        val buttonIncluir = findViewById<Button>(R.id.buttonIncluir)
        val editPraia = findViewById<EditText>(R.id.editPraia)
        val editCidade = findViewById<EditText>(R.id.editCidade)
        val editEstado = findViewById<EditText>(R.id.editEstado)

        buttonIncluir.setOnClickListener {
            if (editPraia.text.isEmpty()) {
                editPraia.error = "Preencha o campo"
                return@setOnClickListener
            }

            if (editCidade.text.isEmpty()) {
                editCidade.error = "Preencha o campo"
                return@setOnClickListener
            }

            if (editEstado.text.isEmpty()) {
                editEstado.error = "Preencha o campo"
                return@setOnClickListener
            }

            val item = ItemPraia(
                nomePraia = editPraia.text.toString(),
                cidade = editCidade.text.toString(),
                estado = editEstado.text.toString(),
                onRemove = {
                    itemsAdapter.removerItem(it)
                }
            )

            itemsAdapter.adicionarItem(item)
            editPraia.text.clear()
            editCidade.text.clear()
            editEstado.text.clear()

        }

    }
}