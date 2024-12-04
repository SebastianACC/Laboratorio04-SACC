package com.example.laboratorio04_sacc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import com.example.laboratorio04_sacc.ui.theme.Laboratorio04SACCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio04SACCTheme {
                Scaffold(
                    topBar = {
                        TopAppBarWithIcons()
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    ListaTareas(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarWithIcons() {
    TopAppBar(
        title = {
            Text(text = "Lista de Tareas")
        },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_menu_search),
                    contentDescription = "Menú"
                )
            }
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_menu_search),
                    contentDescription = "Buscar"
                )
            }
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_input_add),
                    contentDescription = "Agregar Tarea"
                )
            }
        }
    )
}

@Composable
fun ListaTareas(modifier: Modifier = Modifier) {
    val tasks = listOf(
        "Tarea 1: Realizar la reunión con el equipo.",
        "Tarea 2: Revisar los correos importantes.",
        "Tarea 3: Preparar la presentación para el cliente.",
        "Tarea 4: Organizar la base de datos del proyecto.",
        "Tarea 5: Actualizar la documentación."
    )

    LazyColumn(modifier = modifier) {
        items(tasks.size) { index ->
            TaskItem(task = tasks[index])
        }
    }
}

@Composable
fun TaskItem(task: String) {
    var isChecked by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = { isChecked = it }
        )

        Text(
            text = task,
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TaskListPreview() {
    Laboratorio04SACCTheme {
        ListaTareas()
    }
}
