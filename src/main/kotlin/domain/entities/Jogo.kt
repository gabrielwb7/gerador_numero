package br.com.arcadia.domain.entities

data class Jogo(val tagJogo: String) {
    private val listaNumeros = mutableListOf<Int>()

    fun addNumero(num: Int) {
        listaNumeros.add(num)
    }

    fun listaNumeros() : List<Int> {
        return this.listaNumeros
    }

    override fun toString(): String {
        return "Jogo tagJogo='$tagJogo', \n listaNotas=$listaNumeros"
    }


}

