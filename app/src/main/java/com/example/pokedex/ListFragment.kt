package com.example.pokedex

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment() {

    interface PokemonSelectListener {
        fun onPokemonSelected(pokemon: Pokemon)
    }

    private lateinit var pokemonselectListener: PokemonSelectListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        pokemonselectListener = try {
            context as PokemonSelectListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement PokemonSelectListener")
        }
    }

override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {

    val view = inflater.inflate(R.layout.fragment_list, container, false)

    val recycler = view.findViewById<RecyclerView>(R.id.pokemon_recycler)
    recycler.layoutManager = LinearLayoutManager(requireActivity())
    val adapter = PokemonAdapter()
    recycler.adapter = adapter

    adapter.onItemClickListener = {
        Toast.makeText(requireActivity(), it.name, Toast.LENGTH_SHORT).show()
        pokemonselectListener.onPokemonSelected(it)
    }

    val pokemonList: MutableList<Pokemon> = mutableListOf(
        Pokemon(4, "Charmander", 39, 52, 43, 65, Pokemon.PokemonType.FIRE,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR76FDDW33MdOR0yiqsf5Pph_KjRXAz6JwqNhGxJBuEtQ&s"),
        Pokemon(3, "Venuasaur", 80, 82, 83, 80, Pokemon.PokemonType.GRASS,"https://www.nintenderos.com/wp-content/uploads/2022/08/EP1085_Venusaur_de_Kukui-1.jpg"),
        Pokemon(2, "Ivysaur", 60, 62, 63, 60, Pokemon.PokemonType.GRASS,"https://images.wikidexcdn.net/mwuploads/wikidex/6/60/latest/20151001164033/EP893_Ivysaur_de_Xana.png"),
        Pokemon(7, "Squirtle", 44, 48, 65, 43, Pokemon.PokemonType.WATER,"https://www.mundodeportivo.com/alfabeta/hero/2023/06/squirtle-pokemon-famoso.jpeg?width=1200"),
        Pokemon(25, "Pikachu", 35, 55, 40, 90, Pokemon.PokemonType.ELECTRIC,"https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/media/image/2022/11/pikachu-pokemon-escarlata-purpura-2888180.jpg?tf=3840x"),
    )

    adapter.submitList(pokemonList)

    return view
}
}