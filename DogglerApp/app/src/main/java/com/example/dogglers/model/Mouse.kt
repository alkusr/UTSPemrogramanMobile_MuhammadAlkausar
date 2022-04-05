
package com.example.dogglers.model

import androidx.annotation.DrawableRes

data class Mouse(
    @DrawableRes val imageResourceId: Int,
    val name: String,
    val type: String,
    val con: String
)
