package com.jmasagi.uptdjabar2.util.decoration

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import com.jmasagi.uptdjabar2.R

class ListPaddingDecoration(
        context: Context,
        val paddingLeft: Int = 0,
        val paddingRight: Int = 0
) : RecyclerView.ItemDecoration() {

    private var mDivider: Drawable? = null

    init {
        mDivider = ContextCompat.getDrawable(context, R.drawable.divider)
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State?) {

        val left = parent.paddingLeft + paddingLeft
        val right = parent.width - parent.paddingRight + paddingRight

        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
            val top = child.bottom + params.bottomMargin
            val bottom = top + (mDivider?.intrinsicHeight ?: 0)

            mDivider?.let {
                it.setBounds(left, top, right, bottom)
                it.draw(c)
            }

        }
    }
}