package com.example.muavin

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.muavin.Utilities.getCompatibility
import com.example.muavin.Utilities.getImage
import com.example.muavin.Utilities.getName

class StarFragment:Fragment(R.layout.fragment_star) {
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_star, container, false)
        val sName: TextView = rootView.findViewById(R.id.idtvSName)
        val pName: TextView = rootView.findViewById(R.id.idtvPName)
        val sSign: ImageView = rootView.findViewById(R.id.idivSelf)
        val pSign: ImageView = rootView.findViewById(R.id.idivPartner)
        val sInfo: TextView = rootView.findViewById(R.id.idtvCompatibility)

        val data = arguments
        if (data != null) {
            sName.text = getName(data.getInt("sStar"))
            pName.text = getName(data.getInt("pStar"))
            sSign.setImageResource(getImage(data.getInt("sStar")))
            pSign.setImageResource(getImage(data.getInt("pStar")))
            sInfo.text = getCompatibility(data.getInt("sStar"), data.getInt("pStar"))
            return rootView
        } else {
            Toast.makeText(activity, "Technical Error !", Toast.LENGTH_SHORT).show()
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}
