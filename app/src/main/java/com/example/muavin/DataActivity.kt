package com.example.muavin

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.FragmentNavigatorExtras


class DataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        val sName: EditText = findViewById(R.id.idetSName)
        val pName: EditText = findViewById(R.id.idetPName)
        val sMale: RadioButton = findViewById(R.id.idrbSMale)
        val pMale: RadioButton = findViewById(R.id.idrbPMale)
        val sFemale: RadioButton = findViewById(R.id.idrbSFemale)
        val pFemale: RadioButton = findViewById(R.id.idrbPFemale)
        val sDOB: DatePicker = findViewById(R.id.iddpSDOB)
        val pDOB: DatePicker = findViewById(R.id.iddpPDOB)
        val next: Button = findViewById(R.id.idbtnNext)

        val mainActivity = Intent(this, MainActivity::class.java)
        next.setOnClickListener {
            if (sName.text.isEmpty() || pName.text.isEmpty()) {
                Toast.makeText(this, "Please, Enter Details!", Toast.LENGTH_SHORT).show()
            } else {
                mainActivity.putExtra("sName", sName.text.toString())
                mainActivity.putExtra(
                    "sGender", if (sMale.isChecked) {
                        "Male"
                    } else if (sFemale.isChecked) {
                        "Female"
                    } else {
                        "Self Gender Error"
                    }
                )
                mainActivity.putExtra("sDOB", sDOB.dayOfMonth.toString())
                mainActivity.putExtra("sMOB", (sDOB.month+1).toString())
                mainActivity.putExtra("pName", pName.text.toString())
                mainActivity.putExtra(
                    "pGender", if (pMale.isChecked) {
                        "Male"
                    } else if (pFemale.isChecked) {
                        "Female"
                    } else {
                        "Partner Gender Error"
                    }
                )
                mainActivity.putExtra("pDOB", pDOB.dayOfMonth.toString())
                mainActivity.putExtra("pMOB", (pDOB.month+1).toString())
                startActivity(mainActivity)
                finish()
            }
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}