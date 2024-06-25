package com.example.pizzata.ui.screen.menu.detailmenu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzata.R
import com.example.pizzata.ui.theme.PizzaTATheme
import com.example.pizzata.ui.theme.PrimaryColor
import com.example.pizzata.ui.theme.Shapes


@Composable
fun DetailMenuOrder() {
    var quantity = remember { mutableIntStateOf(1) }
    var selectedCrust = remember { mutableStateOf("Original") }
    var note = remember { mutableStateOf(TextFieldValue("")) }

    Scaffold(
        bottomBar = {
            BottomButtonDetail()
        },
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        ImageSection()
                        Spacer(modifier = Modifier.height(16.dp))
                        DescriptionSection()
                        Spacer(modifier = Modifier.height(16.dp))
                        CrustSelection(selectedCrust.value) { selectedCrust.value = it }
                        Spacer(modifier = Modifier.height(16.dp))
                        NoteSection(note.value) { note.value = it }
                        Spacer(modifier = Modifier.height(16.dp))
                        QuantitySelector(
                            quantity = quantity.intValue,
                            onIncrease = quantity.intValue ++,
                            onDecrease = { if (quantity.intValue > 1) quantity.intValue-- }
                        )
                    }
                }
            }
        }
    )
}

@Composable
fun ImageSection() {
    val image: Painter = painterResource(id = R.drawable.banner1) // Ganti dengan id gambar Anda
    Image(
        painter = image,
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(Shapes.medium)
    )
}

@Composable
fun DescriptionSection() {
    Column {
        Text(
            text = "Fruit Creamy Pizza",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "78.000",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Pizza dengan campuran keju dan daging dan super pizza dengan campuran keju dan daging",
            fontSize = 16.sp
        )
    }
}

@Composable
fun CrustSelection(selectedCrust: String, onCrustSelected: (String) -> Unit) {
    Column {
        Text(
            text = "Pilih Pinggiran",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selectedCrust == "Original",
                onClick = { onCrustSelected("Original") }
            )
            Text(text = "Original")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selectedCrust == "Cheese",
                onClick = { onCrustSelected("Cheese") }
            )
            Text(text = "Cheese")
        }
    }
}

@Composable
fun NoteSection(note: TextFieldValue, onNoteChange: (TextFieldValue) -> Unit) {
    Column {
        Text(
            text = "Note to restaurant",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        BasicTextField(
            value = note,
            onValueChange = onNoteChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .border(1.dp, Color.Gray, Shapes.small)
                .padding(8.dp),
            decorationBox = { innerTextField ->
                if (note.text.isEmpty()) {
                    Text(
                        text = "Add your request",
                        color = Color.Gray
                    )
                }
                innerTextField()
            }
        )
    }
}

@Composable
fun QuantitySelector(
    quantity: Int,
    onIncrease: Int,
    onDecrease: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {},
            modifier = Modifier
                .size(36.dp),
            colors = ButtonDefaults.buttonColors(Color.Gray)
        ) {
            Text(text = "-", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = quantity.toString(), fontSize = 20.sp)
        Spacer(modifier = Modifier.width(16.dp))
        Button(
            onClick = {  },
            modifier = Modifier.size(36.dp),
            colors = ButtonDefaults.buttonColors(Color.Gray)
        ) {
            Text(text = "+", fontSize = 20.sp)
        }
    }
}

@Composable
fun BottomButtonDetail() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.White)
            .shadow(
                elevation = 1.dp,
                shape = RectangleShape,
                ambientColor = Color(0x3A000000),
                spotColor = Color(0x3A000000),
            ),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = { /* Handle click */ },
            shape = Shapes.medium,
            colors = ButtonDefaults.buttonColors(PrimaryColor),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 26.dp,)
        ) {
            Text("Add to Cart",
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}


@Composable
@Preview(showBackground = true)
fun DetailMenuScreenPreview(){
    PizzaTATheme {
        DetailMenuOrder()
    }
}