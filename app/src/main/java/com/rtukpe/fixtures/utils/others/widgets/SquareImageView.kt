package com.rtukpe.fixtures.utils.others.widgets

import android.content.Context
import android.util.AttributeSet

class SquareImageView : android.support.v7.widget.AppCompatImageView {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val measuredWidth = measuredWidth
        val measuredHeight = measuredHeight
        if (measuredWidth > measuredHeight)
            setMeasuredDimension(measuredHeight, measuredHeight)
        else
            setMeasuredDimension(measuredWidth, measuredWidth)
    }
}