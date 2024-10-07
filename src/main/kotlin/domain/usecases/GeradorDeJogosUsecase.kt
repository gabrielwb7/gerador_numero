package br.com.arcadia.domain.usecases

import br.com.arcadia.domain.entities.Jogo
import kotlin.random.Random

class GeradorDeJogosUsecase {

    fun gerarJogos(qtdJogos: Int) : List<Jogo> {
        val jogos = mutableListOf<Jogo>()
        for(index in 1..qtdJogos) {
            val jogo = Jogo("Jogo $index")

            adicionarNumeros(jogo)
        }
        return jogos
    }

    private fun adicionarNumeros(jogo: Jogo) {
        val listaDeNumeros = generateSequence { Random.nextInt(1, 25) }.distinct().take(15).toList()

        listaDeNumeros.forEach { num -> jogo.addNumero(num)}

        println(jogo)
    }
}