package com.sarwar.myapplication.mvload

import android.support.annotation.DrawableRes
import android.widget.ImageView

fun ImageView.load(url: String, @DrawableRes placeHolder: Int? = null, @DrawableRes errorImage: Int? = null) {


    placeHolder?.also {
        this.setImageResource(placeHolder)

    }

    MVLoadClient().requestAsBitmap(url) { bitmap, _ ->

        if (bitmap != null)
            this.setImageBitmap(bitmap)
        else {
            errorImage?.also {
                this.setImageResource(it)
            }
        }
    }
}