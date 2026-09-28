package com.exemplo.lanchonete

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ComprovanteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comprovante)

        val tvNome = findViewById<TextView>(R.id.tvNome)
        val tvEndereco = findViewById<TextView>(R.id.tvEndereco)
        val tvItens = findViewById<TextView>(R.id.tvItens)
        val tvTotal = findViewById<TextView>(R.id.tvTotal)
        val tvCodigo = findViewById<TextView>(R.id.tvCodigo)
        val btnNovoPedido = findViewById<Button>(R.id.btnNovoPedido)

        val nome = intent.getStringExtra("NOME") ?: ""
        val endereco = intent.getStringExtra("ENDERECO") ?: ""
        val codigo = intent.getIntExtra("CODIGO", 0)

        tvNome.text = "Cliente: $nome"
        tvEndereco.text = "Endereço: $endereco"
        tvCodigo.text = codigo.toString()

        // Mostra os itens e o total ANTES de limpar o carrinho
        tvItens.text = Carrinho.textoDosItens()
        tvTotal.text = "Total: R$ " + String.format("%.2f", Carrinho.total())

        // Limpa o carrinho, já que este pedido foi concluído
        Carrinho.limpar()

        btnNovoPedido.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
