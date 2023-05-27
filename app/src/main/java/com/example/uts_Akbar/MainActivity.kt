package com.example.uts_Akbar

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {



    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(Menu.NONE, 1 , Menu.NONE, "Dark Mode")
        menu?.add(Menu.NONE, 2 , Menu.NONE, "Light Mode")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            1 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            2 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val pricelistList = listOf<pricelist>(
            pricelist(
                R.drawable.pubg,
                namepricelist = "Pubg Mobile",
                descpricelist = "Selamat datang di Store Ma.id, destinasi terbaik untuk mendapatkan voucher top-up PUBG dengan cepat dan mudah! Kami adalah toko online yang menyediakan berbagai pilihan voucher top-up untuk memenuhi kebutuhan Anda dalam meningkatkan pengalaman bermain game PUBG yang seru ini." +
                        "\nDengan voucher top-up PUBG dari Store Ma.id, Anda dapat mengisi saldo UC (Unknown Cash) dalam akun game PUBG Anda. UC adalah mata uang virtual yang digunakan di PUBG untuk membeli berbagai item dalam game, seperti skin senjata, pakaian, aksesori, atau paket loot yang menarik. Dengan menggunakan voucher top-up kami, Anda dapat dengan mudah meningkatkan inventaris Anda dan memperoleh keuntungan tambahan di medan pertempuran PUBG."
            ),
            pricelist(
                R.drawable.ml,
                namepricelist = "Mobile Legends",
                descpricelist = "Selamat datang di Store Ma.id, tujuan utama Anda untuk mendapatkan voucher game Mobile Legends dengan mudah dan cepat! Kami adalah toko online yang menyediakan berbagai voucher game Mobile Legends untuk memenuhi kebutuhan Anda dalam mengisi ulang saldo dalam game yang menarik ini.\n" +
                        "\n" +
                        "Dengan voucher game Mobile Legends dari Store Ma.id, Anda dapat meningkatkan pengalaman bermain Mobile Legends Anda dengan lebih banyak opsi dan keuntungan. Anda dapat menggunakan voucher ini untuk membeli berbagai item dalam game, seperti skin pahlawan yang keren, perlengkapan yang unik, dan aksesori yang menambah tampilan dan kemampuan karakter Anda." +
                        "\nDengan voucher game Mobile Legends dari Store Ma.id, Anda dapat meningkatkan pengalaman bermain Mobile Legends Anda dengan lebih banyak opsi dan keuntungan. Anda dapat menggunakan voucher ini untuk membeli berbagai item dalam game, seperti skin pahlawan yang keren, perlengkapan yang unik, dan aksesori yang menambah tampilan dan kemampuan karakter Anda."
            ),
            pricelist(
                R.drawable.valorant,
                namepricelist = "Valorant",
                descpricelist = "Selamat datang di Store Ma.id, tempat terbaik untuk mendapatkan voucher game Valorant dengan mudah dan cepat! Kami adalah toko online yang menyediakan berbagai voucher game Valorant untuk memenuhi kebutuhan Anda dalam mengisi saldo dan meningkatkan pengalaman bermain game FPS yang seru ini.\n" +
                        "Dengan voucher game Valorant dari Store Ma.id, Anda dapat mengakses berbagai fitur tambahan, senjata, skin, atau item lainnya yang akan meningkatkan tampilan dan kinerja karakter Anda dalam pertempuran. Voucher ini memungkinkan Anda untuk mengisi ulang saldo Valorant Points (VP) dalam akun game Anda, sehingga Anda dapat dengan mudah membeli apa pun yang Anda butuhkan di dalam game."
            ),

        )

        val recyclerView = findViewById<RecyclerView>(R.id.rv_anime)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = pricelistAdapter(this, pricelistList) {
            val intent = Intent(this, DetailpricelistActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)


        }



    }



}