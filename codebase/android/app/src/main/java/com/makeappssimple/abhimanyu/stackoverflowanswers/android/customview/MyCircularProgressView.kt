package com.makeappssimple.abhimanyu.stackoverflowanswers.android.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.R

/**
 * https://stackoverflow.com/questions/74293221/custom-shape-for-circularprogressindicator/77324573#77324573
 */
class MyCircularProgressView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
) : View(context, attrs, defStyle) {
    private var stroke = 25F
    var size: Int = 200
        set(value) {
            field = value
            stroke = value * 0.125F
            invalidate()
        }
    var backgroundStartAngle: Float = 30F
        set(value) {
            field = value

            invalidate()
        }
    var backgroundSweepAngle: Float = 300F
        set(value) {
            field = value

            invalidate()
        }
    var progressStartAngle: Float = 150F
        set(value) {
            field = value

            invalidate()
        }
    var progressSweepAngle: Float = 180F
        set(value) {
            field = value

            invalidate()
        }

    private val backgroundPaint = Paint()
    private val progressPaint = Paint()

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.MyCircularProgressView,
            0,
            0,
        ).apply {
            try {
//                progressHeight = getInteger(R.styleable.LinearProgressView_progressHeight, 20)
//                progress = getFloat(R.styleable.LinearProgressView_progress, 0.4F)
            } finally {
                recycle()
            }
        }

        backgroundPaint.apply {
            color = 0xFFE0E0E0.toInt()
            strokeCap = Paint.Cap.ROUND
            style = Paint.Style.STROKE
            strokeWidth = stroke
        }
        progressPaint.apply {
            color = 0xFF0000EE.toInt()
            strokeCap = Paint.Cap.ROUND
            style = Paint.Style.STROKE
            strokeWidth = stroke
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawArc(
            stroke / 2F,
            stroke / 2F,
            size.toFloat(),
            size.toFloat(),
            backgroundStartAngle % 360F,
            backgroundSweepAngle % 360F,
            false,
            backgroundPaint,
        )
        canvas.drawArc(
            stroke / 2F,
            stroke / 2F,
            size.toFloat(),
            size.toFloat(),
            progressStartAngle % 360F,
            progressSweepAngle % 360F,
            false,
            progressPaint,
        )
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(size + stroke.toInt(), size + stroke.toInt())
    }
}
