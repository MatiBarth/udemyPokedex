package com.example.pokedex

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.pokedex.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding : FragmentDetailBinding
    private lateinit var imageView: ImageView
    private lateinit var hpText: TextView
    private lateinit var attackText: TextView
    private lateinit var defenseText: TextView
    private lateinit var speedText: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailBinding.inflate(inflater,container,false)

        imageView = binding.fragmentDetailImage
        hpText = binding.fragmentDetailHp
        attackText = binding.fragmentDetailAttack
        defenseText = binding.fragmentDetailDefense
        speedText = binding.fragmentDetailSpeed


        return binding.root
    }

    fun setPokemonData (pokemon: Pokemon){
        var prefix = context?.getString(R.string.hp_prefix)
        hpText.text = "${prefix} ${pokemon.hp.toString()}"
        prefix = context?.getString(R.string.attack_prefix)
        attackText.text = "${prefix} ${pokemon.attack.toString()}"
        prefix = context?.getString(R.string.defense_prefix)
        defenseText.text = "${prefix} ${pokemon.defense.toString()}"
        prefix = context?.getString(R.string.speed_prefix)
        speedText.text = "${prefix} ${pokemon.speed.toString()}"
    }
}