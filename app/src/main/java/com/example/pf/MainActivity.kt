package com.example.pf

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedBundle: Bundle?) {
        super.onCreate(savedBundle)
        setContentView(R.layout.activity_main)

        // Инициализация нижней панели навигации
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        // Установите начальный фрагмент (главный экран)
        replaceFragment(HomeFragment())

        // Обработчик событий для навигации
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            val fragment = when (menuItem.itemId) {
                R.id.menu_cart -> CartFragment()
                R.id.menu_home -> HomeFragment()
                R.id.menu_profile -> ProfileFragment()
                else -> null
            }
            fragment?.let { replaceFragment(it) }
            fragment != null
        }
    }

    // Метод для замены текущего фрагмента
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}

class CartFragment : Fragment() {
    // Здесь вы можете добавить логику для фрагмента корзины
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }
}

class ProfileFragment : Fragment() {
    // Здесь вы можете добавить логику для фрагмента профиля
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }
}

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Замените `R.layout.fragment_home` на файл макета фрагмента
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}
