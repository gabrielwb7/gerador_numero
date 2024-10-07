package br.com.arcadia.domain.entities

data class Jogo(val tagJogo: String) {
    private val listaNotas = mutableListOf<Int>()

    fun addNumero(num: Int) {
        listaNotas.add(num)
    }

    override fun toString(): String {
        return "Jogo tagJogo='$tagJogo', \n listaNotas=$listaNotas"
    }


}

