package com.example.laboratorio6.ui.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.laboratorio6.data.model.NamedApiResource
import com.example.laboratorio6.ui.theme.Laboratorio6Theme

@Composable
fun PokemonListScreen(
    onOpenDetail: (Int, String) -> Unit,
    vm: PokemonListViewModel = viewModel()
) {
    val state by vm.state.collectAsState()

    when {
        state.loading -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
        state.error != null -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Error: ${state.error}")
        }
        else -> LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(state.items) { p ->
                PokemonRow(p) { onOpenDetail(p.id, p.name) }
            }
        }
    }
}

@Composable
private fun PokemonRow(p: NamedApiResource, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val spriteUrl =
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${p.id}.png"
            AsyncImage(
                model = spriteUrl,
                contentDescription = p.name,
                modifier = Modifier.size(40.dp)
            )
            Spacer(Modifier.width(12.dp))
            Text(
                text = p.name.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() },
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PrevRow() {
    Laboratorio6Theme {
        PokemonRow(NamedApiResource("bulbasaur", "https://pokeapi.co/api/v2/pokemon/1/")) {}
    }
}
