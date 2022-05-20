package com.newcore.movieapptask.common.views

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.glide.slider.library.R
import com.glide.slider.library.slidertypes.BaseSliderView

class CustomSlider(context: Context?) : BaseSliderView(context) {
    var scaleType = ImageView.ScaleType.FIT_CENTER

    fun setScaleType(scaleType: ImageView.ScaleType): CustomSlider {
        this.scaleType = scaleType
        return this
    }

    override fun getView(): View {
        val v: View = LayoutInflater.from(context).inflate(R.layout.render_type_text, null)
        val target: AppCompatImageView = v.findViewById(R.id.glide_slider_image)
        target.scaleType = scaleType
        val description: AppCompatTextView = v.findViewById(R.id.glide_slider_description)
        description.text = getDescription()
        bindEventAndShow(v, target)
        return v
    }

}