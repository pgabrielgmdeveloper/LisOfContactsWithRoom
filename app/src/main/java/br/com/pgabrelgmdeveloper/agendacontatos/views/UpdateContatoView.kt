package br.com.pgabrelgmdeveloper.agendacontatos.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.pgabrelgmdeveloper.agendacontatos.components.OutlineTextFieldCustom
import br.com.pgabrelgmdeveloper.agendacontatos.ui.theme.Purple40

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun updateContatoView(navController: NavController) {
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
                title = { Text(text = "Atualizar Contatoo") },
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
                value = sobrenome,
                changeValue = {
                    sobrenome = it
                },
                label = "Phone",
                keyOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                modifier = Modifier
                    .padding(10.dp, 0.dp, 10.dp, 10.dp)
                    .fillMaxWidth()
            )

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth().padding(10.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "Atualizar")
            }
        }
    }
}