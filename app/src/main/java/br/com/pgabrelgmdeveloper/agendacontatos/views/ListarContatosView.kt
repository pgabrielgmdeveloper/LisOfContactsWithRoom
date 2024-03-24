package br.com.pgabrelgmdeveloper.agendacontatos.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.key.onInterceptKeyBeforeSoftKeyboard
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.pgabrelgmdeveloper.agendacontatos.Dao.AppDataBase
import br.com.pgabrelgmdeveloper.agendacontatos.Dao.ContatoDao
import br.com.pgabrelgmdeveloper.agendacontatos.R
import br.com.pgabrelgmdeveloper.agendacontatos.components.ItemContato
import br.com.pgabrelgmdeveloper.agendacontatos.model.Contato
import br.com.pgabrelgmdeveloper.agendacontatos.ui.theme.Purple40
import br.com.pgabrelgmdeveloper.agendacontatos.ui.theme.Purple80
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


var contatoDao: ContatoDao? = null

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun listaContato(navController: NavController) {

    val contatos: MutableList<Contato> = mutableListOf()
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    scope.launch(Dispatchers.IO) {

        contatoDao = AppDataBase.getInstance(context).contatoDao()
        val constatosDao = contatoDao!!.getContatos()
        constatosDao.forEach { contatos.add(it)}
    }

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

            LazyColumn(modifier = Modifier.padding(it) ) {
                itemsIndexed(contatos) { _ , item ->
                    ItemContato(
                        navigateToAtt = {
                            navController.navigate("updateContato/${item.uid}")
                        },
                        deleteItem = {
                            scope.launch(Dispatchers.IO) {
                                contatoDao!!.deletar(item.uid)

                            }
                            navController.navigate("listaContatos")
                        },
                        context = context, contato =  item)
                }
            }


    }

}


@Preview(showBackground = true)
@Composable
fun preview(){
    listaContato(navController = rememberNavController())
}