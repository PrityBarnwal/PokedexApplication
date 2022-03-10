package com.coolapps.pokedex.repository

import com.coolapps.pokedex.di.PokeApi
import com.coolapps.pokedex.model.Pokemon
import com.coolapps.pokedex.model.PokemonList
import com.coolapps.pokedex.utils.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
){
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        }catch (e: Exception){
            return Resource.Error("An unKnown error occured. ")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        }catch (e: Exception){
            return Resource.Error("An unKnown error occured. ")
        }
        return Resource.Success(response)
    }
}