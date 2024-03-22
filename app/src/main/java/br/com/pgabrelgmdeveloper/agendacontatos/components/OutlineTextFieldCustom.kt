package br.com.pgabrelgmdeveloper.agendacontatos.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.pgabrelgmdeveloper.agendacontatos.ui.theme.Purple40


@Composable
fun OutlineTextFieldCustom(value: String, changeValue: (String) -> Unit,label:String ,keyOptions: KeyboardOptions, modifier: Modifier){
    OutlinedTextField(
        value = value,
        onValueChange = changeValue,
        label = {Text(text = label)},
        keyboardOptions = keyOptions,
        colors = OutlinedTextFieldDefaults.colors(
            focusedLabelColor = Purple40,
            focusedBorderColor = Purple40,
            cursorColor = Purple40
        ),
        modifier = modifier,
        maxLines = 1
    )
}


