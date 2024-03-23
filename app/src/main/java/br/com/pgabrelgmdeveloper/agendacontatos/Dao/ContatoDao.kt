package br.com.pgabrelgmdeveloper.agendacontatos.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.pgabrelgmdeveloper.agendacontatos.model.Contato

@Dao
interface ContatoDao {

    @Insert
    fun gravar(listaContato: MutableList<Contato>)

    @Query("SELECT * FROM contato ORDER BY name ASC")
    fun getContatos(): MutableList<Contato>

    @Query("UPDATE contato SET name = :newName, sobrename = :newSobrenome, idade = :newIdade, phone = :newPhone" +
            "WHERE uid = :id ")
    fun atualizar(newName: String, newSobrenome: String, newIdade: String, newPhone: String, id: Int)


    @Query("DELETE FROM contato WHERE uid = :id")
    fun deletar(id: Int)
}