package com.exemplo.lanchonete

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import java.net.HttpURLConnection
import java.net.URL

// Baixa uma imagem a partir de um link (URL) e coloca dentro de um ImageView.
//
// Baixar da internet demora, então o download roda em uma Thread separada
// (se rodasse na tela principal, o app travaria). Quando termina, a imagem
// é colocada no ImageView de volta na thread da tela, usando o Handler.
//
// Enquanto a foto não chega (ou se o link falhar), fica um ícone padrão.
object ImagemUrl {

    fun carregar(link: String, imageView: ImageView) {
        imageView.setImageResource(android.R.drawable.ic_menu_gallery)

        Thread {
            var foto: Bitmap? = null
            try {
                val conexao = URL(link).openConnection() as HttpURLConnection
                conexao.connectTimeout = 10000
                conexao.readTimeout = 10000
                // O Wikimedia pede que o app se identifique
                conexao.setRequestProperty("User-Agent", "LanchoneteApp/1.0 (projeto escolar)")

                if (conexao.responseCode == HttpURLConnection.HTTP_OK) {
                    val bytes = conexao.inputStream.readBytes()

                    // Descobre o tamanho da imagem e diminui se for muito grande,
                    // para não gastar memória à toa (a tela mostra só 120dp)
                    val medidas = BitmapFactory.Options()
                    medidas.inJustDecodeBounds = true
                    BitmapFactory.decodeByteArray(bytes, 0, bytes.size, medidas)

                    var reducao = 1
                    while (medidas.outWidth / reducao > 800) {
                        reducao *= 2
                    }

                    val opcoes = BitmapFactory.Options()
                    opcoes.inSampleSize = reducao
                    foto = BitmapFactory.decodeByteArray(bytes, 0, bytes.size, opcoes)
                }
                conexao.disconnect()
            } catch (e: Exception) {
                foto = null
            }

            val resultado = foto
            Handler(Looper.getMainLooper()).post {
                if (resultado != null) {
                    imageView.setImageBitmap(resultado)
                }
            }
        }.start()
    }
}
