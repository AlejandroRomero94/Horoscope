package com.alejandro.horoscapp.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.alejandro.horoscapp.databinding.ItemHoroscopeBinding
import com.alejandro.horoscapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder (view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemHoroscopeBinding.bind(view)
    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) {
        val context = binding.tvTitle.context
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvTitle.text = context.getString(horoscopeInfo.name)

        binding.parent.setOnClickListener {
            startRotationAnimation(binding.ivHoroscope, newLambda = {onItemSelected(horoscopeInfo)} )
            //         onItemSelected(horoscopeInfo)}
        }
    }
private fun startRotationAnimation(view:View, newLambda:()->Unit){
    view.animate().apply {
        duration=500  //animación en milisegundos
        interpolator = LinearInterpolator () //va a tener la misma velocidad de principio a fin
        rotationBy(360f) //grados de la vuelta. By es sobre si mismo.
        withEndAction{newLambda}
        start()
    }
}
}