package khorunzhyicom.alex.theposter.presentation.common.ext

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso


@BindingAdapter("bind:imageUrl")
fun loadImage(view: ImageView, url: String) {
    Picasso.with(view.context).load(url).into(view)
}
