package com.example.app_1_dinnergen

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.AdapterView
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//    }

    val dropdownlist1 = arrayOf("Tofu", "Pasta", "Tomatoes", "Spinach", "Potato")
    val dropdownlist2 = dropdownlist1.copyOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, dropdownlist1)
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, dropdownlist2)

        val generatebtn: Button = findViewById(R.id.generate_btn)
        val spinner1: Spinner = findViewById(R.id.spinner)
        val spinner2: Spinner = findViewById(R.id.spinner2)
        val dish: TextView = findViewById(R.id.dish)
        val dishdesc: TextView = findViewById(R.id.dish_desc)

//        setting the adapters for the view purpose
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item)

//        1st spinner
        spinner1.adapter = adapter
        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            }
        }

//        2nd spinner
        spinner2.adapter = adapter2
        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            }
        }

        generatebtn.setOnClickListener {
//            2-ingredient combinations
            if(spinner1.selectedItemPosition == 0 && spinner2.selectedItemPosition == 1 || spinner1.selectedItemPosition == 1 && spinner2.selectedItemPosition == 0) {
                dish.setText("Tofu Pesto Pasta")
                dishdesc.setText("Pasta tossed in cherry tomatoes and shallots baked in olive oil and crispy tofu covered in pesto sauce.")
            }
            if(spinner1.selectedItemPosition == 0 && spinner2.selectedItemPosition == 2 || spinner1.selectedItemPosition == 2 && spinner2.selectedItemPosition == 0) {
                dish.setText("Tomato Tofu")
                dishdesc.setText("Stir-fried tofu and scallion softened in a thick, sweet and savory tomato sauce.")
            }
            if(spinner1.selectedItemPosition == 0 && spinner2.selectedItemPosition == 3 || spinner1.selectedItemPosition == 3 && spinner2.selectedItemPosition == 0) {
                dish.setText("Tofu Stir Fry")
                dishdesc.setText("Crispy tofu and fresh broccoli and spinach sauteed in a quick and easy garlic sesame sauce.")
            }
            if(spinner1.selectedItemPosition == 0 && spinner2.selectedItemPosition == 4 || spinner1.selectedItemPosition == 4 && spinner2.selectedItemPosition == 0) {
                dish.setText("Vegan Sheet Pan Potatoes and Tofu")
                dishdesc.setText("Potatoes and tofu baked in the delicious juices of mushrooms and onions.")
            }
            if(spinner1.selectedItemPosition == 1 && spinner2.selectedItemPosition == 2 || spinner1.selectedItemPosition == 2 && spinner2.selectedItemPosition == 1) {
                dish.setText("Tomato Pasta")
                dishdesc.setText("Pasta tossed in a creamy tomato sauce.")
            }
            if(spinner1.selectedItemPosition == 1 && spinner2.selectedItemPosition == 3 || spinner1.selectedItemPosition == 3 && spinner2.selectedItemPosition == 1) {
                dish.setText("Spaghetti with Spinach and Creamy Tomato Sauce")
                dishdesc.setText("Pasta and spinach tossed in a creamy sun-dried tomato sauce.")
            }
            if(spinner1.selectedItemPosition == 1 && spinner2.selectedItemPosition == 4 || spinner1.selectedItemPosition == 4 && spinner2.selectedItemPosition == 1) {
                dish.setText("Pasata e Patate")
                dishdesc.setText("Pasta and potatoes tossed in a creamy and pancetta-infused sauce.")
            }
            if(spinner1.selectedItemPosition == 2 && spinner2.selectedItemPosition == 3 || spinner1.selectedItemPosition == 3 && spinner2.selectedItemPosition == 2) {
                dish.setText("Tomato and Spinach Pasta")
                dishdesc.setText("Pasta tossed in juicy cherry tomatoes, fresh spinach, olive oil, and a kick of red pepper flakes.")
            }
            if(spinner1.selectedItemPosition == 2 && spinner2.selectedItemPosition == 4 || spinner1.selectedItemPosition == 4 && spinner2.selectedItemPosition == 2) {
                dish.setText("Potato and Tomato Bake")
                dishdesc.setText("Potatoes and tomatoes baked in garlic and herb juices, crisped and topped with breadcrumbs and cheese.")
            }
            if (spinner1.selectedItemPosition == 3 && spinner2.selectedItemPosition == 4 || spinner1.selectedItemPosition == 4 && spinner2.selectedItemPosition == 3) {
                dish.setText("Spinach and Potato Curry")
                dishdesc.setText("Tender potatoes and wilted spinach simmered in a warm, spiced curry sauce.")
            }
//            duplicates
            if(spinner1.selectedItemPosition == 0 && spinner2.selectedItemPosition == 0) {
                dish.setText("Vegan Mapo Tofu")
                dishdesc.setText("Silken tofu in a bold, spicy Sichuan sauce with Shiitake mushrooms.")
            }
            if(spinner1.selectedItemPosition == 1 && spinner2.selectedItemPosition == 1) {
                dish.setText("Cacio e Pepe")
                dishdesc.setText("Pasta tossed in a simple, creamy pecorino and black pepper sauce.")
            }
            if(spinner1.selectedItemPosition == 2 && spinner2.selectedItemPosition == 2) {
                dish.setText("Tomato Bruschetta")
                dishdesc.setText("Fresh tomatoes and basil on crispy toasted bread.")
            }
            if(spinner1.selectedItemPosition == 3 && spinner2.selectedItemPosition == 3) {
                dish.setText("Creamed Spinach")
                dishdesc.setText("Spinach slow-cooked in a rich, buttery cream sauce.")
            }
            if(spinner1.selectedItemPosition == 4 && spinner2.selectedItemPosition == 4) {
                dish.setText("Duchess Potatoes")
                dishdesc.setText("Piped mashed potatoes baked until golden and crispy.")
            }
        }
    }
}