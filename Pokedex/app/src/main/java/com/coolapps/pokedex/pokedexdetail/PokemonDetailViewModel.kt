package com.coolapps.pokedex.pokedexdetail

import androidx.lifecycle.ViewModel
import com.coolapps.pokedex.model.Pokemon
import com.coolapps.pokedex.repository.PokemonRepository
import com.coolapps.pokedex.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(private val repository: PokemonRepository)
    : ViewModel() {
        suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
            return repository.getPokemonInfo(pokemonName)
        }
}