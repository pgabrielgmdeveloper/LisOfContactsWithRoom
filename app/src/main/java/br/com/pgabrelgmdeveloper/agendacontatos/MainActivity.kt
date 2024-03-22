package br.com.pgabrelgmdeveloper.agendacontatos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.pgabrelgmdeveloper.agendacontatos.ui.theme.AgendaContatosTheme
import br.com.pgabrelgmdeveloper.agendacontatos.views.createContato
import br.com.pgabrelgmdeveloper.agendacontatos.views.listaContato
import br.com.pgabrelgmdeveloper.agendacontatos.views.updateContatoView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AgendaContatosTheme {
                val navController = rememberNavController()
                NavHost(navController = navController , startDestination = "listaContatos" ) {
                    composable("listaContatos"){
                        listaContato(navController)
                    }
                    composable("updateContato"){ updateContatoView(navController = navController) }
                    composable("createContato"){ createContato(navController = navController) }
                }

            }

        }
    }
}
