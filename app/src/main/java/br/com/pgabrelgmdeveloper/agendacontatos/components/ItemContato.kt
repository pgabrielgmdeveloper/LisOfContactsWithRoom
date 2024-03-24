package br.com.pgabrelgmdeveloper.agendacontatos.components

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import br.com.pgabrelgmdeveloper.agendacontatos.R
import br.com.pgabrelgmdeveloper.agendacontatos.model.Contato
import br.com.pgabrelgmdeveloper.agendacontatos.ui.theme.ShapesCardsView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun ItemContato(
    navigateToAtt: () -> Unit,
    deleteItem: () -> Unit,
    context: Context,
    contato: Contato
){
    val scope = rememberCoroutineScope()
    Card(
        modifier = Modifier.fillMaxWidth().padding(10.dp, 5.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = ShapesCardsView.small,
        colors =CardDefaults.cardColors(containerColor = Color.White),

    ) {
        ConstraintLayout() {
            val (txtContato, txtIdade, txtNumero, iconEdit, iconDelete) = createRefs()
            Text(
                text = "Contato: ${contato.name} ${contato.sobrename} ",
                modifier = Modifier.constrainAs(txtContato) {
                    top.linkTo(parent.top, margin = 30.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )
            Text(
                text = "Idade: ${contato.idade}",
                modifier = Modifier.constrainAs(txtIdade) {
                    top.linkTo(txtContato.bottom, margin = 5.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )
            Text(
                text = "Numero: ${contato.idade}",
                modifier = Modifier.constrainAs(txtNumero) {
                    top.linkTo(txtIdade.bottom, margin = 5.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 30.dp)
                }
            )
            Button(
                onClick = {
                  navigateToAtt()
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp, disabledElevation = 0.dp),
                modifier = Modifier.constrainAs(iconEdit){
                    start.linkTo(txtNumero.end, margin = 0.dp)
                    top.linkTo(parent.top, margin = 60.dp)
                }
            ) {
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_edit), contentDescription = "Icone de editar" )
            }
            Button(
                onClick = {
                    val dialog = AlertDialog
                        .Builder(context)
                    dialog.setTitle("Tem certesa ?")
                        .setMessage("Ao clicar em ok o contato sera excluido permanentemente")

                    dialog.setPositiveButton("Sim") {_,_ ->

                        deleteItem()

                        scope.launch(Dispatchers.Main) {
                            Toast.makeText(context,"Contato Deletado", Toast.LENGTH_SHORT).show()
                        }
                    }
                    dialog.setNegativeButton("Não") {_,_ ->

                    }
                    dialog.show()
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp, disabledElevation = 0.dp),
                modifier = Modifier.constrainAs(iconDelete){
                    start.linkTo(iconEdit.end, margin = 0.dp)
                    top.linkTo(parent.top, margin = 60.dp)
                }
            ) {
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_delete), contentDescription = "Icone de deletar" )
            }
        }
    }
}


