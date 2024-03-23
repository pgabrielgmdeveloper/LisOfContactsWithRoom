package br.com.pgabrelgmdeveloper.agendacontatos.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.pgabrelgmdeveloper.agendacontatos.constantes.Constants


@Entity(tableName = Constants.TABLE_NAME)
data class Contato(
    @ColumnInfo("name") val name: String,
    @ColumnInfo("sobrename") val sobrename: String,
    @ColumnInfo("idade") val idade: String,
    @ColumnInfo("phone") val phone: String
) {
    @PrimaryKey(autoGenerate = true) var uid: Int = 0
}
