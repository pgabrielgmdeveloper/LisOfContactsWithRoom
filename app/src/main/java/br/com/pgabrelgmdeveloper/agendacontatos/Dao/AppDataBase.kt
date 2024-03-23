package br.com.pgabrelgmdeveloper.agendacontatos.Dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.pgabrelgmdeveloper.agendacontatos.constantes.Constants
import br.com.pgabrelgmdeveloper.agendacontatos.model.Contato


@Database(entities = [Contato::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun contatoDao(): ContatoDao

    companion object {
        @Volatile
        private var INSTANCE : AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    Constants.DB_CONTATOS
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}