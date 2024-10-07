package br.com.arcadia.adapters.services

import br.com.arcadia.domain.entities.Jogo
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.nio.file.FileSystems


class GerarPlanilhaExcelJogos {

    fun gerarPlanilha(jogos: List<Jogo>) {
        val arquivo = arquivo()

        val workbook = HSSFWorkbook()
        val planilha = workbook.createSheet("Lotofacil")
        var numLinha = 0

        jogos.forEach { jogo ->
            run {
                val linha = planilha.createRow(numLinha++)
                var numCelula = 0
                val celulaJogo = linha.createCell(numCelula++)
                celulaJogo.setCellValue(jogo.tagJogo)

                jogo.listaNumeros().forEach { num ->
                    run {
                        val celulaNumero = linha.createCell(numCelula++)
                        celulaNumero.setCellValue(num.toString())
                    }
                }
            }
        }

        try {
            val out: FileOutputStream = FileOutputStream(File(arquivo))
            workbook.write(out)
            out.close()
            println("Arquivo Excel criado com sucesso!")
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            println("Arquivo não encontrado!")
        } catch (e: IOException) {
            e.printStackTrace()
            println("Erro na edição do arquivo!")
        }

    }

    private fun arquivo(): String {
        val currentDirectoryPath = FileSystems.getDefault().getPath("");
        val currentDirectoryName = currentDirectoryPath.toAbsolutePath().toString();
        val arquivo = "$currentDirectoryName/src/main/resources/planilhas/jogos.xls"
        return arquivo
    }
}