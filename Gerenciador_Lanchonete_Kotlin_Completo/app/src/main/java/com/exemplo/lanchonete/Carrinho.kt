package com.exemplo.lanchonete

// Representa um item que foi adicionado ao carrinho
data class ItemPedido(
    val descricao: String,
    val quantidade: Int,
    val precoUnitario: Double
) {
    // Valor deste item já multiplicado pela quantidade
    fun subtotal(): Double {
        return precoUnitario * quantidade
    }
}

// Objeto único (singleton) que guarda os itens do pedido em memória
// enquanto o app está aberto. Não é um banco de dados, é só uma
// lista compartilhada entre as telas.
object Carrinho {

    val itens = mutableListOf<ItemPedido>()

    fun adicionar(item: ItemPedido) {
        itens.add(item)
    }

    fun total(): Double {
        var soma = 0.0
        for (item in itens) {
            soma += item.subtotal()
        }
        return soma
    }

    // Monta um texto com todos os itens, um por linha.
    // Usado na tela do carrinho e no comprovante.
    fun textoDosItens(): String {
        val texto = StringBuilder()
        for (item in itens) {
            if (texto.isNotEmpty()) {
                texto.append("\n")
            }
            texto.append("• " + item.quantidade + "x " + item.descricao +
                    " - R$ " + String.format("%.2f", item.subtotal()))
        }
        return texto.toString()
    }

    fun limpar() {
        itens.clear()
    }
}
