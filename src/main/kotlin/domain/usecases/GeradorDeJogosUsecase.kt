package br.com.arcadia.domain.usecases

import br.com.arcadia.adapters.services.GerarPlanilhaExcelJogos
import br.com.arcadia.domain.exceptions.ErrorAoGerarException
import br.com.arcadia.domain.entities.Jogo
import kotlin.random.Random

class GeradorDeJogosUsecase {

    private val excel = GerarPlanilhaExcelJogos()

    fun gerarJogos(qtdJogos: Int) {
        val jogos = gerarListaJogos(qtdJogos)

        try {
            excel.gerarPlanilha(jogos)
        } catch (ex : Exception) {
            throw ErrorAoGerarException("Erro ao gerar excel")
        }

    }

    private fun gerarListaJogos(qtdJogos: Int) : List<Jogo> {
        val jogos = mutableListOf<Jogo>()
        for(index in 1..qtdJogos) {
            val jogo = Jogo("Jogo $index")

            adicionarNumeros(jogo)
            jogos.add(jogo)
        }
        return jogos
    }

    private fun adicionarNumeros(jogo: Jogo) {
        val listaDeNumeros = generateSequence { Random.nextInt(1, 25) }.distinct().take(15).toList()

        listaDeNumeros.forEach { num -> jogo.addNumero(num)}

        println(jogo)
    }
}