package com.example.portfolioappcompose.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.outlined.BrokenImage
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.pm.ShortcutInfoCompat.Surface
import com.example.portfolioappcompose.data.model.Project

@Preview
@Composable
fun PortfolioCard(modifier: Modifier=Modifier) {

    val portfolioShowState = remember {
        mutableStateOf(false)
    }

    Surface(modifier = modifier.fillMaxSize()){
        Card(modifier = modifier
            .width(200.dp)
            .height(400.dp)
            .padding(20.dp),
            colors =  CardDefaults.cardColors(containerColor = Color.LightGray),
            elevation = CardDefaults.cardElevation(10.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp))
            ) {
            Column(modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally) {
                /*TODO*/
                PortfolioProfileImage()
                HorizontalDivider(color = Color.Black, modifier = modifier
                    .padding(20.dp)
                    .width(250.dp), thickness = 0.5.dp)
                PortfolioPersonInfo()
                Spacer(modifier = Modifier.padding(top = 15.dp))
                Button(onClick = {portfolioShowState.value = !portfolioShowState.value },
                    colors = ButtonDefaults.buttonColors(Color.DarkGray)) {
                    Text(text = "Portfolio")
                }

                PortfolioProject(isShown = portfolioShowState.value)



            }

        }
    }
}

@Preview
@Composable
private fun PortfolioProfileImage(modifier: Modifier = Modifier) {
    Surface(modifier = modifier
        .size(150.dp)
        .padding(10.dp),
        shape = CircleShape,
        border = BorderStroke(1.dp,Color.Black),
        shadowElevation = 10.dp
        ){
        Icon(imageVector = Icons.Default.Android,
            modifier = modifier
                .clip(CircleShape)
                .padding(20.dp),
            contentDescription = null)
    }
}

@Preview
@Composable
private fun PortfolioPersonInfo() {
    Column(modifier = Modifier.padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Ahmet Bugra Kaplan",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.padding(5.dp))
        Text(text = "Android Engineer",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.padding(5.dp))
        Text(text = "@BugraKaplan",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary)

    }
}

@Composable
fun PortfolioProject(modifier: Modifier = Modifier , isShown : Boolean = false){

    if(isShown){
        Box(modifier = modifier
            .fillMaxSize()
            .padding(5.dp)){
            Surface(modifier = modifier
                .padding(5.dp)
                .fillMaxSize(),
                shape = RoundedCornerShape(corner = CornerSize(10.dp)),
                border = BorderStroke(width = 1.dp, color = Color.Black)

            ){
                PortfolioProjectItem(
                    data = listOf(
                        Project("My Instagram Clone Project",
                            "Instagram klon projesi Atıl Hoca'nın eğitimleri ile yapıldı"),
                        Project("Bank App With Firebase",
                            "Firebase realtime veri tabanı" +
                                    " kullanılarak tasarlanan bir banka uygulaması"),
                        Project("Monster Slaughter",
                            "Konsol tabanlı java ile geliştirilmiş bir hayatta kalma oyunu"),
                    )

                )
            }
        }
    }
}

@Composable
fun PortfolioProjectItem(modifier: Modifier = Modifier,data : List<Project>) {
    LazyColumn (modifier = modifier.background(Color.LightGray)){
        items(data){item->
            Card(modifier = modifier
                .padding(10.dp)
                .fillParentMaxWidth(),
                shape = RoundedCornerShape(20.dp)
            ){
                Row(modifier = modifier
                    .background(MaterialTheme.colorScheme.background)
                    .padding(10.dp)
                    .fillParentMaxWidth()
                ){
                    PortfolioProfileImage(modifier = Modifier.size(100.dp))
                    Column(modifier = modifier
                        .padding(5.dp)
                        .align(Alignment.CenterVertically)
                    ){
                        Text(text = item.projectName ?: "PROJECT NAME",
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleMedium)

                        Text(text = item.projectDescription.toString(),
                            style =MaterialTheme.typography.bodySmall)
                    }

                }
            }
        }
    }
}

