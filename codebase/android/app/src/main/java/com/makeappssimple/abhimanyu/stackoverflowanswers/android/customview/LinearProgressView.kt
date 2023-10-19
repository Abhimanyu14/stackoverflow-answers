package com.makeappssimple.abhimanyu.stackoverflowanswers.android.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.R

private const val PADDING = 20F

class LinearProgressView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
) : View(context, attrs, defStyle) {
    var progressHeight: Int = 0
        set(value) {
            field = value

            invalidate()
        }
    var progress: Float = 0F
        set(value) {
            field = value

            invalidate()
        }
    private val backgroundPaint = Paint()
    private val progressPaint = Paint()

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.LinearProgressView,
            0,
            0,
        ).apply {
            try {
                progressHeight = getInteger(R.styleable.LinearProgressView_progressHeight, 20)
                progress = getFloat(R.styleable.LinearProgressView_progress, 0.4F)
            } finally {
                recycle()
            }
        }

        backgroundPaint.apply {
            color = 0xFFE0E0E0.toInt()
        }
        progressPaint.apply {
            color = 0xFF000000.toInt()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawRoundRect(
            PADDING,
            (height - progressHeight) / 2F,
            width - (PADDING * 2),
            (height + progressHeight) / 2F,
            progressHeight / 2F,
            progressHeight / 2F,
            backgroundPaint,
        )
        if (progress > 0) {
            canvas.drawRoundRect(
                PADDING,
                (height - progressHeight) / 2F,
                (width - PADDING * 2) * progress,
                (height + progressHeight) / 2F,
                progressHeight / 2F,
                progressHeight / 2F,
                progressPaint,
            )
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(widthMeasureSpec, progressHeight)
    }
}
