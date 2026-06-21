package com.example.app_1_dinnergen

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.AdapterView
import android.view.View
import android.content.Intent
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.net.toUri

class MainActivity : AppCompatActivity() {

    val dropdownlist1 = arrayOf("Tofu", "Pasta", "Tomatoes", "Spinach", "Potato")
    val dropdownlist2 = dropdownlist1.copyOf()

    private fun showWelcomeDialog() {
        val view: View = layoutInflater.inflate(R.layout.welcome_modal, null)
        val welcomeDone: Button = view.findViewById(R.id.welcomeStart)

        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setView(view)
        val alertDialog: AlertDialog = builder.create()

        welcomeDone.setOnClickListener{
            alertDialog.dismiss()
        }

        alertDialog.show()
    }

    private fun openUrl(url: String) {
        if(url.contains("http://") || url.contains("https://")) {
            val sendIntent = Intent(Intent.ACTION_VIEW, url.toUri())
            val chooser = Intent.createChooser(sendIntent, "Choose your browser")
            startActivity(chooser)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showWelcomeDialog()

//        dish links
        val url1 = "https://minimalistbaker.com/easy-pesto-pasta-bowls-with-crispy-tofu-veggies/"
        val url2 = "https://thewoksoflife.com/tomato-tofu/"
        val url3 = "https://www.wellplated.com/tofu-stir-fry/"
        val url4 = "https://ohmyveggies.com/vegan-sheet-pan-potatoes-tofu/#%f0%9f%93%96-recipe"
        val url5 = "https://www.saltandlavender.com/creamy-tomato-pasta/"
        val url6 = "https://www.eatingwell.com/recipe/7919563/spaghetti-spinach-with-sun-dried-tomato-cream-sauce/"
        val url7 = "https://thisitaliankitchen.com/pasta-e-patate/#wprm-recipe-container-22087"
        val url8 = "https://bakerbynature.com/easy-tomato-and-spinach-pasta/"
        val url9 = "https://anitalianinmykitchen.com/tomato-bake/"
        val url10 = "https://www.teaforturmeric.com/easy-spinach-potato-curry-aloo-palak/"

//        adapters
        val mArrayAdapter = ArrayAdapter<Any?>(this, R.layout.spinner_list, dropdownlist1)
        val mArrayAdapter2 = ArrayAdapter<Any?>(this, R.layout.spinner_list, dropdownlist2)

        val viewbtn: Button = findViewById(R.id.view_btn)
        val generatebtn: Button = findViewById(R.id.generate_btn)
        val spinner1: Spinner = findViewById(R.id.spinner)
        val spinner2: Spinner = findViewById(R.id.spinner2)
        val dish: TextView = findViewById(R.id.dish)
        val dishdesc: TextView = findViewById(R.id.dish_desc)
        val dishimg: ImageView = findViewById(R.id.image)

        viewbtn.isEnabled = false

        fun viewBtnStatus(boolean: Boolean) {
            viewbtn.isEnabled = boolean
        }

//        setting the adapters for the view purpose
        mArrayAdapter.setDropDownViewResource(R.layout.spinner_list)
        mArrayAdapter2.setDropDownViewResource(R.layout.spinner_list)


//        1st spinner
        spinner1.adapter = mArrayAdapter
        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            }
        }

//        2nd spinner
        spinner2.adapter = mArrayAdapter2
        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            }
        }

        generatebtn.setOnClickListener {
//            2-ingredient combinations
            if(spinner1.selectedItemPosition == 0 && spinner2.selectedItemPosition == 1 || spinner1.selectedItemPosition == 1 && spinner2.selectedItemPosition == 0) {
                dish.text = "Tofu Pesto Pasta"
                dishdesc.text = "Pasta tossed in cherry tomatoes and shallots baked in olive oil and crispy tofu covered in pesto sauce."
                dishimg.setImageResource(R.drawable.d1)
                viewBtnStatus(true)
            }
            if(spinner1.selectedItemPosition == 0 && spinner2.selectedItemPosition == 2 || spinner1.selectedItemPosition == 2 && spinner2.selectedItemPosition == 0) {
                dish.text = "Tomato Tofu"
                dishdesc.text = "Stir-fried tofu and scallion softened in a thick, sweet and savory tomato sauce."
                dishimg.setImageResource(R.drawable.d2)
                viewBtnStatus(true)
            }
            if(spinner1.selectedItemPosition == 0 && spinner2.selectedItemPosition == 3 || spinner1.selectedItemPosition == 3 && spinner2.selectedItemPosition == 0) {
                dish.text = "Tofu Stir Fry"
                dishdesc.text = "Crispy tofu and fresh broccoli and spinach sauteed in a quick and easy garlic sesame sauce."
                dishimg.setImageResource(R.drawable.d3)
                viewBtnStatus(true)
            }
            if(spinner1.selectedItemPosition == 0 && spinner2.selectedItemPosition == 4 || spinner1.selectedItemPosition == 4 && spinner2.selectedItemPosition == 0) {
                dish.text = "Vegan Sheet Pan Potatoes and Tofu"
                dishdesc.text = "Potatoes and tofu baked in the delicious juices of mushrooms and onions."
                dishimg.setImageResource(R.drawable.d4)
                viewBtnStatus(true)
            }
            if(spinner1.selectedItemPosition == 1 && spinner2.selectedItemPosition == 2 || spinner1.selectedItemPosition == 2 && spinner2.selectedItemPosition == 1) {
                dish.text = "Tomato Pasta"
                dishdesc.text = "Pasta tossed in a creamy tomato sauce."
                dishimg.setImageResource(R.drawable.d5)
                viewBtnStatus(true)
            }
            if(spinner1.selectedItemPosition == 1 && spinner2.selectedItemPosition == 3 || spinner1.selectedItemPosition == 3 && spinner2.selectedItemPosition == 1) {
                dish.text = "Spaghetti with Spinach and Creamy Tomato Sauce"
                dishdesc.text = "Pasta and spinach tossed in a creamy sun-dried tomato sauce."
                dishimg.setImageResource(R.drawable.d6)
                viewBtnStatus(true)
            }
            if(spinner1.selectedItemPosition == 1 && spinner2.selectedItemPosition == 4 || spinner1.selectedItemPosition == 4 && spinner2.selectedItemPosition == 1) {
                dish.text = "Pasata e Patate"
                dishdesc.text = "Pasta and potatoes tossed in a creamy and pancetta-infused sauce."
                dishimg.setImageResource(R.drawable.d7)
                viewBtnStatus(true)
            }
            if(spinner1.selectedItemPosition == 2 && spinner2.selectedItemPosition == 3 || spinner1.selectedItemPosition == 3 && spinner2.selectedItemPosition == 2) {
                dish.text = "Tomato and Spinach Pasta"
                dishdesc.text = "Pasta tossed in juicy cherry tomatoes, fresh spinach, olive oil, and a kick of red pepper flakes."
                dishimg.setImageResource(R.drawable.d8)
                viewBtnStatus(true)
            }
            if(spinner1.selectedItemPosition == 2 && spinner2.selectedItemPosition == 4 || spinner1.selectedItemPosition == 4 && spinner2.selectedItemPosition == 2) {
                dish.text = "Potato and Tomato Bake"
                dishdesc.text = "Potatoes and tomatoes baked in garlic and herb juices, crisped and topped with breadcrumbs and cheese."
                dishimg.setImageResource(R.drawable.d9)
                viewBtnStatus(true)
            }
            if (spinner1.selectedItemPosition == 3 && spinner2.selectedItemPosition == 4 || spinner1.selectedItemPosition == 4 && spinner2.selectedItemPosition == 3) {
                dish.text = "Spinach and Potato Curry"
                dishdesc.text = "Tender potatoes and wilted spinach simmered in a warm, spiced curry sauce."
                dishimg.setImageResource(R.drawable.d10)
                viewBtnStatus(true)
            }
        }

        viewbtn.setOnClickListener {
            if(spinner1.selectedItemPosition == 0 && spinner2.selectedItemPosition == 1 || spinner1.selectedItemPosition == 1 && spinner2.selectedItemPosition == 0) {
                viewbtn.isEnabled = true
                openUrl(url1)
            }
            if(spinner1.selectedItemPosition == 0 && spinner2.selectedItemPosition == 2 || spinner1.selectedItemPosition == 2 && spinner2.selectedItemPosition == 0) {
                viewbtn.isEnabled = true
                openUrl(url2)
            }
            if(spinner1.selectedItemPosition == 0 && spinner2.selectedItemPosition == 3 || spinner1.selectedItemPosition == 3 && spinner2.selectedItemPosition == 0) {
                viewbtn.isEnabled = true
                openUrl(url3)
            }
            if(spinner1.selectedItemPosition == 0 && spinner2.selectedItemPosition == 4 || spinner1.selectedItemPosition == 4 && spinner2.selectedItemPosition == 0) {
                viewbtn.isEnabled = true
                openUrl(url4)
            }
            if(spinner1.selectedItemPosition == 1 && spinner2.selectedItemPosition == 2 || spinner1.selectedItemPosition == 2 && spinner2.selectedItemPosition == 1) {
                viewbtn.isEnabled = true
                openUrl(url5)
            }
            if(spinner1.selectedItemPosition == 1 && spinner2.selectedItemPosition == 3 || spinner1.selectedItemPosition == 3 && spinner2.selectedItemPosition == 1) {
                viewbtn.isEnabled = true
                openUrl(url6)
            }
            if(spinner1.selectedItemPosition == 1 && spinner2.selectedItemPosition == 4 || spinner1.selectedItemPosition == 4 && spinner2.selectedItemPosition == 1) {
                viewbtn.isEnabled = false
                openUrl(url7)
            }
            if(spinner1.selectedItemPosition == 2 && spinner2.selectedItemPosition == 3 || spinner1.selectedItemPosition == 3 && spinner2.selectedItemPosition == 2) {
                viewbtn.isEnabled = false
                openUrl(url8)
            }
            if(spinner1.selectedItemPosition == 2 && spinner2.selectedItemPosition == 4 || spinner1.selectedItemPosition == 4 && spinner2.selectedItemPosition == 2) {
                viewbtn.isEnabled = false
                openUrl(url9)
            }
            if (spinner1.selectedItemPosition == 3 && spinner2.selectedItemPosition == 4 || spinner1.selectedItemPosition == 4 && spinner2.selectedItemPosition == 3) {
                viewbtn.isEnabled = false
                openUrl(url10)
            }
        }
    }
}