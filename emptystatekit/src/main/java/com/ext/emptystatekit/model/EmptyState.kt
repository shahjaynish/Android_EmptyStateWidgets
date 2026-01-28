package com.ext.emptystatekit.model

import androidx.annotation.DrawableRes
import com.ext.emptystatekit.R

enum class EmptyState(
    @DrawableRes val defaultIcon: Int,
    val defaultTitle: String,
    val defaultMessage: String
) {
    NO_INTERNET(
        R.drawable.ic_no_internet,
        "No Internet Connection",
        "Please check your network and try again"
    ),

    NO_DATA(
        R.drawable.ic_no_data,
        "No Data Available",
        "There is nothing to show right now"
    ),

    ERROR(
        R.drawable.ic_error,
        "Something went wrong",
        "Please try again later"
    )
}
