package com.makeappssimple.abhimanyu.stackoverflowanswers.android.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import kotlin.math.min

/**
 * https://stackoverflow.com/questions/73316391/android-canvas-draw-text-on-circle-radius-based
 */
private const val PADDING = 20F
private const val PARTITIONS = 8

class LotteryWheel @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0,
) : View(context, attributeSet, defStyle) {
    private var radius: Float = 0F
    private var centerX: Float = 0F
    private var centerY: Float = 0F

    private val blackPaint = Paint()
    private val textPaint = Paint()

    init {
        blackPaint.apply {
            color = 0xFF000000.toInt()
            style = Paint.Style.STROKE
            strokeWidth = 10F
            textSize = 64F
            textAlign = Paint.Align.CENTER
        }
        textPaint.apply {
            color = 0xFF000000.toInt()
            style = Paint.Style.FILL
            textSize = 64F
            textAlign = Paint.Align.CENTER
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        radius = (min(w, h) / 2F) - PADDING
        centerX = w / 2F
        centerY = h / 2F
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawCircle(centerX, centerY, radius, blackPaint)
        repeat(4) {
            canvas.drawLine(
                centerX - radius, centerY,
                centerX + radius, centerY,
                blackPaint,
            )
            canvas.rotate(360F / PARTITIONS, centerX, centerY)
        }
        canvas.rotate(360F / (PARTITIONS * 2), centerX, centerY)
        repeat(8) {
            canvas.drawText("Test", centerX - (radius / 2), centerY, textPaint)
            canvas.rotate(360F / PARTITIONS, centerX, centerY)
        }
        canvas.rotate(360F / (PARTITIONS * 2), centerX, centerY)
    }
}
