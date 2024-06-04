package pedrotura.com.github.listapraias.model

data class ItemPraia (
    val nomePraia : String,
    val cidade : String,
    val estado : String,
    val onRemove : (ItemPraia) -> Unit
    )