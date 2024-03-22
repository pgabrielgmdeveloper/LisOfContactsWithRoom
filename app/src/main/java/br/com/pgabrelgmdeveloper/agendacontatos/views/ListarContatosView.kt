package br.com.pgabrelgmdeveloper.agendacontatos.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.pgabrelgmdeveloper.agendacontatos.R
import br.com.pgabrelgmdeveloper.agendacontatos.ui.theme.Purple40
import br.com.pgabrelgmdeveloper.agendacontatos.ui.theme.Purple80


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun listaContato(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Contatos")},
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Purple40, titleContentColor = Color.White)
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("createContato")
                },
                shape = CircleShape,
                containerColor = Purple40,
                contentColor = Color.White
            ) {
                Icon(imageVector = ImageVector.vectorResource(id = R.drawable.ic_add), contentDescription = "Icone de adicionar" )
            }
        }
    ) {

    }

}


@Preview(showBackground = true)
@Composable
fun preview(){
    listaContato(navController = rememberNavController())
}