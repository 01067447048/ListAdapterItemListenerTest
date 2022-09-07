package com.jaehyeon.listadapteritemlistenertest.binding

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.jaehyeon.listadapteritemlistenertest.R
import com.jaehyeon.listadapteritemlistenertest.model.CustomDataModel

@BindingAdapter("isEnableState")
fun bindViewIsEnable(view: ImageView, model: CustomDataModel?) {
    model ?: return

    if (model.mark) {
        view.setImageResource(R.drawable.ic_baseline_star_24)
    }
    else {
        view.setImageResource(R.drawable.ic_baseline_star_border_24)
    }
}