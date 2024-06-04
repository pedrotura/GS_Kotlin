package pedrotura.com.github.listapraias.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pedrotura.com.github.R
import pedrotura.com.github.listapraias.model.ItemPraia

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    private val items = mutableListOf<ItemPraia>()

    fun adicionarItem(novoItem: ItemPraia) {
        items.add(novoItem)
        notifyDataSetChanged()
    }

    fun removerItem(item: ItemPraia) {
        items.remove(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.textItem)
        val buttonExcluir = view.findViewById<ImageButton>(R.id.buttonExcluir)

        fun bind(item: ItemPraia) {
            textView.text = item.nomePraia + ", " + item.cidade + ", " + item.estado
            buttonExcluir.setOnClickListener {
                item.onRemove(item)
            }
        }
    }

}