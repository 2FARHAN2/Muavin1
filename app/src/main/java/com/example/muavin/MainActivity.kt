package com.example.muavin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.muavin.Utilities.getStar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sName = intent.getStringExtra("sName")
        val sGender = intent.getStringExtra("sGender")
        val sDOB = intent.getStringExtra("sDOB")
        val sMOB = intent.getStringExtra("sMOB")
        val sStar = getStar(sDOB!!.toInt(), sMOB!!.toInt())
        val pName = intent.getStringExtra("pName")
        val pGender = intent.getStringExtra("pGender")
        val pDOB = intent.getStringExtra("pDOB")
        val pMOB = intent.getStringExtra("pMOB")
        val pStar = getStar(pDOB!!.toInt(), pMOB!!.toInt())


        val data = Bundle().apply {
            putString("sName", sName)
            putString("sGender", sGender)
            putInt("sStar", sStar)
            putString("pName", pName)
            putString("pGender", pGender)
            putInt("pStar", pStar)
        }

        val loveFragment = LoveFragment()
        val personalityFragment = PersonalityFragment()
        val starFragment = StarFragment()

        personalityFragment.arguments = data
        loveFragment.arguments = data
        starFragment.arguments = data
        setCurrentFragment(loveFragment)

        val x = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        x.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.love -> setCurrentFragment(loveFragment)
                R.id.personality -> setCurrentFragment(personalityFragment)
                R.id.star -> setCurrentFragment(starFragment)

            }
            true
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
}