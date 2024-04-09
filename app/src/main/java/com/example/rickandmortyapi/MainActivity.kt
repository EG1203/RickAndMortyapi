package com.example.rickandmortyapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmortyapi.ui.theme.RickAndMortyapiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyapiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RickAndMortyapiTheme {
        Greeting("Android")
    }
    class MainActivity : AppCompatActivity() {

        private lateinit var viewModel: CharacterViewModel

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            // Инициализация ViewModel
            viewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)

            // Подписка на LiveData
            viewModel.characters.observe(this, Observer { characters ->
                // Обновление UI с новым списком персонажей
                updateUI(characters)
            })

            // Загрузка данных
            viewModel.fetchCharacters(1)
        }

        private fun updateUI(characters: List<GameCharacter>) {
            // Здесь вы обновляете ваш UI, например, адаптер вашего RecyclerView
            // Например:
            // myAdapter.submitList(characters)
        }
    }

}