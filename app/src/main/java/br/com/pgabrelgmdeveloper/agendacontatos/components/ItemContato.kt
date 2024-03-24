package br.com.pgabrelgmdeveloper.agendacontatos.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import br.com.pgabrelgmdeveloper.agendacontatos.R
import br.com.pgabrelgmdeveloper.agendacontatos.ui.theme.ShapesCardsView


@Composable
fun ItemContato(){

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = ShapesCardsView.small,
        colors =CardDefaults.cardColors(containerColor = Color.White)
    ) {
        ConstraintLayout(modifier = Modifier
            .align(Alignment.CenterHorizontally)) {
            val (txtContato, txtIdade, txtNumero, iconEdit, iconDelete) = createRefs()
            Text(
                text = "Contato: PAULO MATIAS",
                modifier = Modifier.constrainAs(txtContato) {
                    top.linkTo(parent.top, margin = 30.dp)
                    start.linkTo(parent.start, margin = 0.dp)
                }
            )
            Text(
                text = "Idade: 24",
                modifier = Modifier.constrainAs(txtIdade) {
                    top.linkTo(txtContato.bottom, margin = 5.dp)
                    start.linkTo(parent.start, margin = 0.dp)
                }
            )
            Text(
                text = "Numero: 79988498785",
                modifier = Modifier.constrainAs(txtNumero) {
                    top.linkTo(txtIdade.bottom, margin = 5.dp)
                    start.linkTo(parent.start, margin = 0.dp)
                    bottom.linkTo(parent.bottom, margin = 30.dp)
                }
            )
            Button(
                onClick = { },
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
                onClick = { },
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


@Preview(showBackground = true)
@Composable
fun PreviewItemContato(){
    ItemContato()
}