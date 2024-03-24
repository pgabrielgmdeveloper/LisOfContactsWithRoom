package br.com.pgabrelgmdeveloper.agendacontatos.views

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.pgabrelgmdeveloper.agendacontatos.Dao.AppDataBase
import br.com.pgabrelgmdeveloper.agendacontatos.components.OutlineTextFieldCustom
import br.com.pgabrelgmdeveloper.agendacontatos.model.Contato
import br.com.pgabrelgmdeveloper.agendacontatos.ui.theme.Purple40
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun createContato(navController: NavController) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    var name by remember {
        mutableStateOf("")
    }
    var idade by remember {
        mutableStateOf("")
    }
    var phone by remember {
        mutableStateOf("")
    }
    var sobrenome by remember {
        mutableStateOf("")
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Criar novo contato") },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Purple40, titleContentColor = Color.White)
            )
        }
    ) {
        Column(verticalArrangement = Arrangement.Center,modifier = Modifier.fillMaxSize()) {
            OutlineTextFieldCustom(
                value = name,
                changeValue = {
                              name = it
                },
                label = "Name",
                keyOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier
                    .padding(10.dp, 0.dp, 10.dp, 10.dp)
                    .fillMaxWidth()
            )
            OutlineTextFieldCustom(
                value = sobrenome,
                changeValue = {
                    sobrenome = it
                },
                label = "Sobrenome",
                keyOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier
                    .padding(10.dp, 0.dp, 10.dp, 10.dp)
                    .fillMaxWidth()
            )
            OutlineTextFieldCustom(
                value = idade,
                changeValue = {
                    idade = it
                },
                label = "Idade",
                keyOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .padding(10.dp, 0.dp, 10.dp, 10.dp)
                    .fillMaxWidth()
            )
            OutlineTextFieldCustom(
                value = phone,
                changeValue = {
                    phone = it
                },
                label = "Telefone",
                keyOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                modifier = Modifier
                    .padding(10.dp, 0.dp, 10.dp, 10.dp)
                    .fillMaxWidth()
            )

            Button(
                onClick = {
                    var error = true
                    scope.launch(Dispatchers.IO){
                        if (name.isEmpty() || sobrenome.isEmpty() || idade.isEmpty() || phone.isEmpty()) {
                            error = true
                        }else {
                            val contato = Contato(name,sobrenome,idade,phone)
                            val contatoDao = AppDataBase.getInstance(context).contatoDao()
                           contatoDao.gravar(mutableListOf(contato))
                            error = false
                        }
                    }
                    scope.launch (Dispatchers.Main) {
                        if (error) {
                            Toast.makeText(context,"Por favor preencher todos os campos", Toast.LENGTH_SHORT).show()
                        }else {
                            Toast.makeText(context,"Contato Salvo com sucesso !!", Toast.LENGTH_SHORT).show()
                        }

                    }

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "CADASTRAR")
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun t () {
    createContato(navController = rememberNavController())
}