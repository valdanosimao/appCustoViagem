package br.com.gastoviagem

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /*
      ActivityMainBinding é a classe que foi criada para mapear os elementos
      Inflate estamos falando, pegue o layout e infle/expanda
     */
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}