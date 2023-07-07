package com.example.muavin

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.muavin.Utilities.calc

class LoveFragment:Fragment(R.layout.fragment_love) {
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_love, container, false)
        val sName: TextView = rootView.findViewById(R.id.idtvStarSName)
        val pName: TextView = rootView.findViewById(R.id.idtvStarPName)
        val sImg: ImageView = rootView.findViewById(R.id.idimgSSign)
        val pImg: ImageView = rootView.findViewById(R.id.idimgPSign)
        val loveBar: ProgressBar = rootView.findViewById(R.id.idpbLove)
        val loveStrength: TextView = rootView.findViewById(R.id.idtvLoveStrength)
        val btn: Button = rootView.findViewById(R.id.idbtnRev)

        val data = arguments
        if (data != null) {
            sName.text = data.getString("sName")
            pName.text = data.getString("pName")

            when (data.getString("sGender")) {
                "Male" -> sImg.setImageResource(R.drawable.man)
                "Female" -> sImg.setImageResource(R.drawable.woman)
            }
            when (data.getString("pGender")) {
                "Male" -> pImg.setImageResource(R.drawable.man)
                "Female" -> pImg.setImageResource(R.drawable.woman)
            }
            val mVal = calc(
                data.getString("sName").toString().toLowerCase(),
                data.getString("pName").toString().toLowerCase()
            )
            loveBar.progress = mVal
            loveStrength.text = "$mVal% Love"

            btn.setOnClickListener{
                if(sName.text == data.getString("sName")) {
                    sName.text = data.getString("pName")
                    pName.text = data.getString("sName")

                    when (data.getString("pGender")) {
                        "Male" -> sImg.setImageResource(R.drawable.man)
                        "Female" -> sImg.setImageResource(R.drawable.woman)
                    }
                    when (data.getString("sGender")) {
                        "Male" -> pImg.setImageResource(R.drawable.man)
                        "Female" -> pImg.setImageResource(R.drawable.woman)
                    }
                    val mVal = calc(
                        data.getString("pName").toString().toLowerCase(),
                        data.getString("sName").toString().toLowerCase()
                    )
                    loveBar.progress = mVal
                    loveStrength.text = "$mVal% Love"
                }
                else {
                    sName.text = data.getString("sName")
                    pName.text = data.getString("pName")

                    when (data.getString("sGender")) {
                        "Male" -> sImg.setImageResource(R.drawable.man)
                        "Female" -> sImg.setImageResource(R.drawable.woman)
                    }
                    when (data.getString("pGender")) {
                        "Male" -> pImg.setImageResource(R.drawable.man)
                        "Female" -> pImg.setImageResource(R.drawable.woman)
                    }
                    val mVal = calc(
                        data.getString("sName").toString().toLowerCase(),
                        data.getString("pName").toString().toLowerCase()
                    )
                    loveBar.progress = mVal
                    loveStrength.text = "$mVal% Love"
                }
            }

            return rootView
        } else {
            Toast.makeText(activity, "Technical Error !", Toast.LENGTH_SHORT).show()
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}