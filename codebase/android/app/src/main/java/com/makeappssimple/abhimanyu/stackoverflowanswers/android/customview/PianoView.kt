package com.makeappssimple.abhimanyu.stackoverflowanswers.android.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.media.MediaPlayer
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.R

val blackKeyNames = listOf("C#", "D#", "F#", "G#", "A#")
val blackKeyFiles = listOf(
    R.raw.c0,
    R.raw.d0,
    R.raw.f0,
    R.raw.g0,
    R.raw.a0,
)
val whiteKeyNames = listOf("C", "D", "E", "F", "G", "A", "B", "C")
val whiteKeyFiles = listOf(
    R.raw.c,
    R.raw.d,
    R.raw.e,
    R.raw.f,
    R.raw.g,
    R.raw.a,
    R.raw.b,
    R.raw.c,
)

data class KeyData(
    var isPressed: Boolean = false,
    val isWhite: Boolean,
    val name: String,
    val id: Int,
    val file: Int,
    val position: Rect,
)

class PianoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : View(context, attrs, defStyle) {
    private val keyDataList: MutableList<KeyData> = mutableListOf()
    private val whiteKeyDataList: MutableList<KeyData> = mutableListOf()
    private val blackKeyDataList: MutableList<KeyData> = mutableListOf()

    private val whiteKeyPaint = Paint()
    private val whiteBorderPaint = Paint()
    private val blackKeyPaint = Paint()
    private val pressedKeyPaint = Paint()

    private val blackTextPaint = Paint()
    private val whiteTextPaint = Paint()

    // Find pointers on given key
    private val keyIdPointersMap = hashMapOf<Int, MutableList<Int>>()
    private val cachedPointers = mutableMapOf<Int, Pair<Int, Int>>()

    init {
        whiteKeyPaint.apply {
            color = 0xFFFFFFFF.toInt()
        }
        blackKeyPaint.apply {
            color = 0xFF000000.toInt()
        }
        whiteBorderPaint.apply {
            color = 0xFF000000.toInt()
            style = Paint.Style.STROKE
            strokeWidth = 4F
            strokeCap = Paint.Cap.SQUARE
        }
        blackTextPaint.apply {
            color = 0xFF000000.toInt()
            textSize = 64F
            textAlign = Paint.Align.CENTER
        }
        whiteTextPaint.apply {
            color = 0xFFFFFFFF.toInt()
            textSize = 48F
            textAlign = Paint.Align.CENTER
        }
        pressedKeyPaint.apply {
            color = 0xFFFF0000.toInt()
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        val whiteKeyWidth = w / 8
        val blackKeyWidth = (whiteKeyWidth * 0.5).toInt()
        val blackKeyHeight = (h * 0.67).toInt()
        keyDataList.clear()
        whiteKeyDataList.clear()
        blackKeyDataList.clear()

        repeat(8) {
            whiteKeyDataList.add(
                KeyData(
                    id = it,
                    isWhite = true,
                    name = whiteKeyNames[it],
                    file = whiteKeyFiles[it],
                    position = Rect(it * whiteKeyWidth, 0, (it + 1) * whiteKeyWidth, h),
                )
            )
        }

        var offset = (whiteKeyWidth * 0.75).toInt()
        repeat(5) {
            blackKeyDataList.add(
                KeyData(
                    id = it + 8,
                    isWhite = false,
                    name = blackKeyNames[it],
                    file = blackKeyFiles[it],
                    position = Rect(offset, 0, offset + blackKeyWidth, blackKeyHeight),
                )
            )
            offset += whiteKeyWidth
            if (it == 1) {
                offset += whiteKeyWidth
            }
        }
        keyDataList.addAll(blackKeyDataList)
        keyDataList.addAll(whiteKeyDataList)
    }

    override fun onDraw(canvas: Canvas) {
        whiteKeyDataList.forEach { keyData ->
            if (keyData.isPressed) {
                canvas.drawRect(keyData.position, pressedKeyPaint)
            } else {
                canvas.drawRect(keyData.position, whiteKeyPaint)
                canvas.drawRect(keyData.position, whiteBorderPaint)
            }
            canvas.drawText(
                keyData.name,
                keyData.position.exactCenterX(),
                keyData.position.bottom - 40F,
                blackTextPaint,
            )
        }
        blackKeyDataList.forEach { keyData ->
            if (keyData.isPressed) {
                canvas.drawRect(keyData.position, pressedKeyPaint)
            } else {
                canvas.drawRect(keyData.position, blackKeyPaint)
            }
            canvas.drawText(
                keyData.name,
                keyData.position.exactCenterX(),
                keyData.position.bottom - 40F,
                whiteTextPaint,
            )
        }
    }

    override fun performClick(): Boolean {
        return super.performClick()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event == null) {
            return super.onTouchEvent(event)
        }

        when (event.action and MotionEvent.ACTION_MASK) {
            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_POINTER_DOWN -> {
                val pointerId = event.getPointerId(event.actionIndex)
                if (handlePointerDown(event, pointerId, event.actionIndex)) {
                    return true
                }
            }

            MotionEvent.ACTION_UP, MotionEvent.ACTION_POINTER_UP -> {
                val pointerId = event.getPointerId(event.actionIndex)
                return handlePointerUp(pointerId)
            }

            MotionEvent.ACTION_MOVE -> {
                var movedPointerId: Int = -1
                var movedPointerIndex: Int = -1
                for (i in 0 until event.pointerCount) {
                    val pointerId = event.getPointerId(i)
                    if (!(cachedPointers[pointerId]?.first == event.getX(i).toInt() &&
                                cachedPointers[pointerId]?.second == event.getY(i).toInt()
                                )
                    ) {
                        movedPointerIndex = i
                        movedPointerId = event.getPointerId(i)
                        break
                    }
                }
                if (movedPointerId != -1) {
                    var prevKey: KeyData? = null
                    keyIdPointersMap.forEach { (keyId, value) ->
                        if (value.contains(movedPointerId)) {
                            prevKey = keyDataList.find {
                                it.id == keyId
                            }
                        }
                    }

                    val pointerX = event.getX(movedPointerIndex).toInt()
                    val pointerY = event.getY(movedPointerIndex).toInt()
                    val newKey: KeyData? = keyDataList.find {
                        it.position.contains(pointerX, pointerY)
                    }

                    if (prevKey?.id == newKey?.id) {
                        cachedPointers[movedPointerId] = Pair(pointerX, pointerY)
                    } else {
                        handlePointerUp(movedPointerId)
                        handlePointerDown(event, movedPointerId, movedPointerIndex)
                    }
                }
                return true
            }
        }
        performClick()
        return super.onTouchEvent(event)
    }

    private fun handlePointerUp(pointerId: Int): Boolean {
        keyIdPointersMap.forEach { (keyId, value) ->
            if (value.contains(pointerId)) {
                val key = keyDataList.find {
                    it.id == keyId
                }
                if (value.size == 1) {
                    key?.isPressed = false
                    keyDataList[keyId].isPressed = false
                    invalidate()
                    keyIdPointersMap.remove(keyId)
                } else {
                    val updatedList = keyIdPointersMap[keyId] ?: mutableListOf()
                    updatedList.remove(pointerId)
                    keyIdPointersMap[keyId] = updatedList
                }
                cachedPointers.remove(pointerId)
                return true
            }
        }
        return false
    }

    private fun handlePointerDown(
        event: MotionEvent,
        pointerId: Int,
        pointerIndex: Int,
    ): Boolean {
        val pointerX = event.getX(pointerIndex).toInt()
        val pointerY = event.getY(pointerIndex).toInt()

        keyDataList.find {
            it.position.contains(pointerX, pointerY)
        }?.let { keyData ->
            if (!keyData.isPressed) {
                keyData.isPressed = true
                val mediaPlayer = MediaPlayer.create(context, keyData.file)
                mediaPlayer.start()
                invalidate()
            }
            val updatedList = (keyIdPointersMap[keyData.id] ?: emptyList()).toMutableList()
            updatedList.add(pointerId)
            keyIdPointersMap[keyData.id] = updatedList
            cachedPointers[pointerId] = Pair(pointerX, pointerY)
            return true
        }
        return false
    }
}
