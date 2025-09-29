package com.example.laboratorio6.ui.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.laboratorio6.R
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonDetailScreen(
    id: Int,
    name: String,
    onBack: () -> Unit,
    vm: PokemonDetailViewModel = viewModel()
) {
    LaunchedEffect(id) { vm.load(id) }
    val state by vm.state.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(name.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() })
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        when {
            state.loading -> Box(
                Modifier.fillMaxSize().padding(padding),
                contentAlignment = Alignment.Center
            ) { CircularProgressIndicator() }

            state.error != null -> Box(
                Modifier.fillMaxSize().padding(padding),
                contentAlignment = Alignment.Center
            ) { Text("Error: ${state.error}") }

            else -> {
                val s = state.data?.sprites
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(padding)
                        .padding(horizontal = 24.dp, vertical = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        LabelWithImage(stringRes = R.string.front, url = s?.front_default)
                        LabelWithImage(stringRes = R.string.back, url = s?.back_default)
                    }
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        LabelWithImage(stringRes = R.string.front_shiny, url = s?.front_shiny)
                        LabelWithImage(stringRes = R.string.back_shiny, url = s?.back_shiny)
                    }
                }
            }
        }
    }
}

@Composable
private fun LabelWithImage(stringRes: Int, url: String?) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = stringResource(id = stringRes), style = MaterialTheme.typography.labelLarge)
        Spacer(Modifier.height(8.dp))
        AsyncImage(model = url, contentDescription = null, modifier = Modifier.size(96.dp))
    }
}


