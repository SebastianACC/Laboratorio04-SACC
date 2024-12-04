package com.example.laboratorio04_sacc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.laboratorio04_sacc.ui.theme.Laboratorio04SACCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio04SACCTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ListaTareas(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
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
    Text(
        text = task,
        modifier = Modifier.padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun TaskListPreview() {
    Laboratorio04SACCTheme {
        ListaTareas()
    }
}