package com.ext.emptystatekit.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.core.view.isVisible
import com.ext.emptystatekit.R
import com.ext.emptystatekit.model.EmptyState

class EmptyStateView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val icon: ImageView
    private val title: TextView
    private val message: TextView
    private val action: Button

    init {
        orientation = VERTICAL

        LayoutInflater.from(context)
            .inflate(R.layout.view_empty_state, this, true)

        icon = findViewById(R.id.esIcon)
        title = findViewById(R.id.esTitle)
        message = findViewById(R.id.esMessage)
        action = findViewById(R.id.esAction)

        applyAttributes(attrs)
    }

    private fun applyAttributes(attrs: AttributeSet?) {
        attrs ?: return

        val ta = context.obtainStyledAttributes(
            attrs,
            R.styleable.EmptyStateView
        )

        ta.getDrawable(R.styleable.EmptyStateView_es_icon)?.let {
            icon.setImageDrawable(it)
            icon.isVisible = true
        }

        ta.getString(R.styleable.EmptyStateView_es_title)?.let {
            title.text = it
            title.isVisible = true
        }

        ta.getString(R.styleable.EmptyStateView_es_message)?.let {
            message.text = it
            message.isVisible = true
        }

        ta.getString(R.styleable.EmptyStateView_es_buttonText)?.let {
            action.text = it
            action.isVisible = true
        }

        ta.recycle()
    }

    fun setOnActionClick(listener: () -> Unit) {
        action.setOnClickListener { listener() }
    }

    fun hide() {
        isVisible = false
    }

    fun show() {
        isVisible = true
    }

    fun showNoInternet(
        @DrawableRes icon: Int? = null,
        message: String? = null
    ) {
        val state = EmptyState.NO_INTERNET
        renderState(
            iconRes = icon ?: state.defaultIcon,
            titleText = state.defaultTitle,
            messageText = message ?: state.defaultMessage
        )
    }

    fun showNoData(
        @DrawableRes icon: Int? = null,
        message: String? = null
    ) {
        val state = EmptyState.NO_DATA
        renderState(
            iconRes = icon ?: state.defaultIcon,
            titleText = state.defaultTitle,
            messageText = message ?: state.defaultMessage
        )
    }

    fun showError(
        message: String? = null,
        @DrawableRes icon: Int? = null
    ) {
        val state = EmptyState.ERROR
        renderState(
            iconRes = icon ?: state.defaultIcon,
            titleText = state.defaultTitle,
            messageText = message ?: state.defaultMessage
        )
    }

    private fun renderState(
        @DrawableRes iconRes: Int?,
        titleText: String?,
        messageText: String?,
        buttonText: String? = null
    ) {
        show()

        iconRes?.let {
            icon.setImageResource(it)
            icon.isVisible = true
        } ?: run {
            icon.isVisible = false
        }

        titleText?.let {
            title.text = it
            title.isVisible = true
        } ?: run {
            title.isVisible = false
        }

        messageText?.let {
            message.text = it
            message.isVisible = true
        } ?: run {
            message.isVisible = false
        }

        buttonText?.let {
            action.text = it
            action.isVisible = true
        } ?: run {
            action.isVisible = false
        }
    }

}
