package com.example.pizzata.ui.screen.menu.detailmenu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzata.R
import com.example.pizzata.ui.components.menu.detailmenu.DescribeMenuLayout
import com.example.pizzata.ui.components.menu.detailmenu.ProductCounter
import com.example.pizzata.ui.screen.home.BannerHome
import com.example.pizzata.ui.theme.BorderCard
import com.example.pizzata.ui.theme.PizzaTATheme
import com.example.pizzata.ui.theme.PrimaryBackgroundColor
import com.example.pizzata.ui.theme.PrimaryColor
import com.example.pizzata.ui.theme.Shapes

@Composable
fun DetailMenuOrder(
    id : Int,
    image : Int,
    count: Int,
    onProductCountChanged: (count: Int) -> Unit,
    navigateBack : () -> Unit,
    modifier: Modifier = Modifier,
){
    var selectedCrust = remember { mutableStateOf("Original") }
    var note = remember { mutableStateOf(TextFieldValue("")) }

    Scaffold(
        bottomBar = {
            BottomButtonDetail()
        },
    ){ padding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(padding)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }

            CloseButton(
                navigateBack = { navigateBack()},
                modifier = modifier
                    .offset(
                        x= (20).dp,
                        y = (-180).dp
                    )
            )

            DescribeMenuLayout(
                1,
                "Full Creamy Pizza",
                "Pizza enak dengan tambahan saous yang menyegarkan dipadukan dengan karie ayam",
                "78.000"
            )

            CrustSelection(
                selectedCrust  = selectedCrust.value
            ) { selectedCrust.value = it }

            NoteSection(note.value
            ) { note.value = it }

            ProductCounter(
                orderCount = count,
                onProductIncreased = { onProductCountChanged(count + 1) },
                onProductDecreased = { if(count>0) onProductCountChanged(count - 1) },
                modifier = Modifier
                    .padding(top = 30.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
fun CloseButton(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
){
    Card(
        backgroundColor = Color.White,
        modifier = modifier
            .height(30.dp)
            .width(30.dp)
            .clip(RoundedCornerShape(30.dp))
            .clickable { navigateBack() }
    ){
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = null
        )
    }
}

@Composable
@Preview(showBackground = true)
fun ClosePreview(){
    PizzaTATheme {
    CloseButton({})
    }
}

@Composable
fun CrustSelection(
    selectedCrust: String,
    onCrustSelected: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp)
    ) {
        Text(
            text = "Pilih Pinggiran",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selectedCrust == "Original",
                onClick = { onCrustSelected("Original") },
                colors = RadioButtonColors(
                    selectedColor = PrimaryColor,
                    unselectedColor = Color.Gray,
                    disabledSelectedColor = PrimaryColor,
                    disabledUnselectedColor = PrimaryColor
                    )
            )
            Text(text = "Original")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selectedCrust == "Cheese",
                onClick = { onCrustSelected("Cheese") },
                colors = RadioButtonColors(
                    selectedColor = PrimaryColor,
                    unselectedColor = Color.Gray,
                    disabledSelectedColor = PrimaryColor,
                    disabledUnselectedColor = PrimaryColor
                )
            )
            Text(text = "Cheese")
        }
    }
}

@Composable
fun NoteSection(
    note: TextFieldValue,
    onNoteChange: (TextFieldValue) -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 10.dp)
    ) {
        Text(
            text = "Note to restaurant",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(20.dp))
        BasicTextField(
            value = note,
            onValueChange = onNoteChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .border(1.dp, BorderCard, Shapes.large)
                .padding(8.dp),
            decorationBox = { innerTextField ->
                if (note.text.isEmpty()) {
                    Text(
                        text = "Add your request",
                        color = Color.Gray,
                        modifier = Modifier
                            .padding(top = 6.dp, start = 10.dp)
                    )
                }
                innerTextField()
            }
        )
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
        DetailMenuOrder(
            121,
            R.drawable.menudetail2,
            0,
            {},
            {}
        )
    }
}