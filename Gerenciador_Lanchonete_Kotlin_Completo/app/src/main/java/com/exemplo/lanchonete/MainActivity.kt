package com.exemplo.lanchonete

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // ---------------------------------------------------------------
    // LINKS DAS FOTOS DOS ITENS NOVOS
    // Para trocar a foto de um item, basta trocar o link aqui.
    // Todas as fotos abaixo vêm do Wikimedia Commons (imagens livres).
    // Créditos (a página de cada arquivo no Commons mostra o autor e a licença):
    //   Coxinha.jpg ................... domínio público
    //   Brazilian pastel.jpg .......... CC BY-SA 2.0
    //   French Fries.JPG .............. StockSnap / Pixabay
    //   Pao de queijo brasil.jpg ...... Acfariac, CC BY-SA 4.0
    //   Orange juice 1.jpg ............ USDA, domínio público
    // ---------------------------------------------------------------
    private val linkCoxinha = "https://upload.wikimedia.org/wikipedia/commons/8/81/Coxinha.jpg"
    private val linkPastel = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Brazilian_pastel.jpg/500px-Brazilian_pastel.jpg"
    private val linkBatataFrita = "https://upload.wikimedia.org/wikipedia/commons/8/83/French_Fries.JPG"
    private val linkPaoDeQueijo = "https://upload.wikimedia.org/wikipedia/commons/a/aa/Pao_de_queijo_brasil.jpg"
    private val linkSuco = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Orange_juice_1.jpg/500px-Orange_juice_1.jpg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnHotDog = findViewById<Button>(R.id.btnHotDog)
        val btnXBurguer = findViewById<Button>(R.id.btnXBurguer)
        val btnPizza = findViewById<Button>(R.id.btnPizza)
        val btnRefrigerante = findViewById<Button>(R.id.btnRefrigerante)
        val btnCoxinha = findViewById<Button>(R.id.btnCoxinha)
        val btnPastel = findViewById<Button>(R.id.btnPastel)
        val btnBatataFrita = findViewById<Button>(R.id.btnBatataFrita)
        val btnPaoDeQueijo = findViewById<Button>(R.id.btnPaoDeQueijo)
        val btnSuco = findViewById<Button>(R.id.btnSuco)
        val btnMilkshake = findViewById<Button>(R.id.btnMilkshake)
        val btnCarrinho = findViewById<Button>(R.id.btnCarrinho)
        val btnSobre = findViewById<Button>(R.id.btnSobre)

        // As fotos dos 4 primeiros itens estão dentro do app (pasta drawable).
        // As fotos dos itens novos são carregadas a partir dos links acima.
        ImagemUrl.carregar(linkCoxinha, findViewById<ImageView>(R.id.imgCoxinha))
        ImagemUrl.carregar(linkPastel, findViewById<ImageView>(R.id.imgPastel))
        ImagemUrl.carregar(linkBatataFrita, findViewById<ImageView>(R.id.imgBatataFrita))
        ImagemUrl.carregar(linkPaoDeQueijo, findViewById<ImageView>(R.id.imgPaoDeQueijo))
        ImagemUrl.carregar(linkSuco, findViewById<ImageView>(R.id.imgSuco))
        // A foto do milkshake agora é local (drawable ic_milkshake), como as 4 primeiras.

        // Cada produto abre sua própria tela de sabores/acompanhamentos
        btnHotDog.setOnClickListener {
            startActivity(Intent(this, HotDogActivity::class.java))
        }

        btnXBurguer.setOnClickListener {
            startActivity(Intent(this, XBurguerActivity::class.java))
        }

        btnPizza.setOnClickListener {
            startActivity(Intent(this, PizzaActivity::class.java))
        }

        btnRefrigerante.setOnClickListener {
            startActivity(Intent(this, RefrigeranteActivity::class.java))
        }

        btnCoxinha.setOnClickListener {
            startActivity(Intent(this, CoxinhaActivity::class.java))
        }

        btnPastel.setOnClickListener {
            startActivity(Intent(this, PastelActivity::class.java))
        }

        btnBatataFrita.setOnClickListener {
            startActivity(Intent(this, BatataFritaActivity::class.java))
        }

        btnPaoDeQueijo.setOnClickListener {
            startActivity(Intent(this, PaoDeQueijoActivity::class.java))
        }

        btnSuco.setOnClickListener {
            startActivity(Intent(this, SucoActivity::class.java))
        }

        btnMilkshake.setOnClickListener {
            startActivity(Intent(this, MilkshakeActivity::class.java))
        }

        btnCarrinho.setOnClickListener {
            startActivity(Intent(this, CarrinhoActivity::class.java))
        }

        btnSobre.setOnClickListener {
            startActivity(Intent(this, SobreActivity::class.java))
        }
    }
}
