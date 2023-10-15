package com.makeappssimple.abhimanyu.stackoverflowanswers.android.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CircleView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : View(context, attrs, defStyle) {
    private val paint = Paint()
    private val circleColor = 0xFF00FF00.toInt() // Green color (ARGB)

    init {
        paint.color = circleColor
        paint.style = Paint.Style.FILL_AND_STROKE
        paint.alpha = 1
    }

    override fun onDraw(canvas: Canvas) {
        val radius = minOf(width, height) / 2
        val centerX = width / 2
        val centerY = height / 2

        // Draw the circle in the center of the View
        canvas.drawCircle(centerX.toFloat(), centerY.toFloat(), radius.toFloat(), paint)
    }
}
