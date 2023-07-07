package com.example.muavin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.muavin.Utilities.getImage
import com.example.muavin.Utilities.getPersonality

class PersonalityFragment:Fragment(R.layout.fragment_personality) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_personality, container, false)
        val sName: TextView = rootView.findViewById(R.id.idtvSStar)
        val pName: TextView = rootView.findViewById(R.id.idtvPStar)
        val sSign: ImageView = rootView.findViewById(R.id.idimgSStar)
        val pSign: ImageView = rootView.findViewById(R.id.idimgPStar)
        val sInfo: TextView = rootView.findViewById(R.id.idtvSPersonality)
        val pInfo: TextView = rootView.findViewById(R.id.idtvPPersonality)

        val data = this.arguments
        if (data != null) {
            sName.text = data.getString("sName")
            pName.text = data.getString("pName")
            sSign.setImageResource(getImage(data.getInt("sStar")))
            pSign.setImageResource(getImage(data.getInt("pStar")))
            sInfo.text = getPersonality(data.getInt("sStar"))
            pInfo.text = getPersonality(data.getInt("pStar"))
            return rootView
        } else {
            Toast.makeText(activity, "Technical Issue !", Toast.LENGTH_SHORT).show()
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}