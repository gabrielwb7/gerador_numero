package br.com.arcadia.adapters.entrypoints

import br.com.arcadia.domain.usecases.GeradorDeJogosUsecase
import java.util.Scanner

class GeradorDeJogos {

    fun gerarJogos() {
        val usecase = GeradorDeJogosUsecase()
        val scanner = Scanner(System.`in`)
        var continua = true
        println("Bem vindo ao gerador de numeros para lotofacil!!!")

        do {
            var qtdJogos = 0

            val criarJogos = kotlin.runCatching {
                qtdJogos = pegarAQtdDeJogos(scanner)
            }

            criarJogos.onFailure {
                println("Erro ao capturar numeros")
            }

            criarJogos.onSuccess {
                usecase.gerarJogos(qtdJogos)
                println("Jogos gerado com sucesso")
                continua = false
            }

        } while (continua)

    }

    private fun pegarAQtdDeJogos(scanner: Scanner): Int {
        println("Digite a quantidade de jogos de 15 numeros você deseja, por favor.")

        val qtdDeJogos = scanner.nextInt()

        return qtdDeJogos
    }
}