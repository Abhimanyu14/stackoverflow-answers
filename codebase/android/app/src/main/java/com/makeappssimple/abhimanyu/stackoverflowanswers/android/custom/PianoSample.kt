@file:Suppress("UnnecessaryVariable")

package com.makeappssimple.abhimanyu.stackoverflowanswers.android.custom

import android.app.Activity
import android.content.pm.ActivityInfo
import android.media.MediaPlayer
import android.view.MotionEvent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.R

private val blackKeyNames = listOf("C#", "D#", "F#", "G#", "A#")
private val blackKeyFileMapping = mapOf(
    "C#" to R.raw.c0,
    "D#" to R.raw.d0,
    "F#" to R.raw.f0,
    "G#" to R.raw.g0,
    "A#" to R.raw.a0,
)
private val whiteKeyNames = listOf("C", "D", "E", "F", "G", "A", "B", "C")
private val whiteKeyFileMapping = mapOf(
    "C" to R.raw.c,
    "D" to R.raw.d,
    "E" to R.raw.e,
    "F" to R.raw.f,
    "G" to R.raw.g,
    "A" to R.raw.a,
    "B" to R.raw.b,
    "C" to R.raw.c,
)
private val pressedColor = Color.Yellow

private data class PianoKeyData(
    val name: String,
    val file: Int,
    val top: Dp,
    val left: Dp,
    val width: Dp,
    val height: Dp,
    val backgroundColor: Color,
    val borderColor: Color
)


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PianoSample() {
    val context = LocalContext.current
    val activity = context as? Activity
    activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        val keyNameToKeyDataMap: Map<String, PianoKeyData> = remember(maxWidth, maxHeight) {
            if (maxWidth != 0.dp && maxHeight != 0.dp) {
                getKeyNameKeyDataMap(maxWidth, maxHeight)
            } else {
                mapOf()
            }
        }

        val keyIdPointersMap = hashMapOf<String, MutableList<Int>>()
        val cachedPointers = mutableMapOf<Int, Pair<Int, Int>>()

//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .pointerInteropFilter { event ->
//                    fun handlePointerUp(pointerId: Int): Boolean {
//                        keyIdPointersMap.forEach { (keyName, value) ->
//                            if (value.contains(pointerId)) {
//                                val key = keyNameToKeyDataMap.find {
//                                    it.name == keyName
//                                }
//                                if (value.size == 1) {
//                                    key?.isPressed = false
//                                    keyNameToKeyDataMap[keyName].isPressed = false
//                                    // invalidate()
//                                    keyIdPointersMap.remove(keyName)
//                                } else {
//                                    val updatedList = keyIdPointersMap[keyName] ?: mutableListOf()
//                                    updatedList.remove(pointerId)
//                                    keyIdPointersMap[keyName] = updatedList
//                                }
//                                cachedPointers.remove(pointerId)
//                                return true
//                            }
//                        }
//                        return false
//                    }
//
//                    fun handlePointerDown(
//                        event: MotionEvent,
//                        pointerId: Int,
//                        pointerIndex: Int,
//                    ): Boolean {
//                        val pointerX = event
//                            .getX(pointerIndex)
//                            .toInt()
//                        val pointerY = event
//                            .getY(pointerIndex)
//                            .toInt()
//
//                        keyNameToKeyDataMap
//                            .find {
//                                it.position.contains(pointerX, pointerY)
//                            }
//                            ?.let { keyData ->
//                                if (!keyData.isPressed) {
//                                    keyData.isPressed = true
//                                    val mediaPlayer = MediaPlayer.create(context, keyData.file)
//                                    mediaPlayer.start()
//                                    // invalidate()
//                                }
//                                val updatedList =
//                                    (keyIdPointersMap[keyData.name] ?: emptyList()).toMutableList()
//                                updatedList.add(pointerId)
//                                keyIdPointersMap[keyData.name] = updatedList
//                                cachedPointers[pointerId] = Pair(pointerX, pointerY)
//                                return true
//                            }
//                        return false
//                    }
//
//                    when (event.action and MotionEvent.ACTION_MASK) {
//                        MotionEvent.ACTION_DOWN, MotionEvent.ACTION_POINTER_DOWN -> {
//                            val pointerId = event.getPointerId(event.actionIndex)
//                            handlePointerDown(event, pointerId, event.actionIndex)
//                        }
//
//                        MotionEvent.ACTION_UP, MotionEvent.ACTION_POINTER_UP -> {
//                            val pointerId = event.getPointerId(event.actionIndex)
//                            handlePointerUp(pointerId)
//                        }
//
//                        /*
//                        MotionEvent.ACTION_MOVE -> {
//                            var movedPointerId: Int = -1
//                            var movedPointerIndex: Int = -1
//                            for (i in 0 until event.pointerCount) {
//                                val pointerId = event.getPointerId(i)
//                                if (!(cachedPointers[pointerId]?.first == event
//                                        .getX(i)
//                                        .toInt() &&
//                                            cachedPointers[pointerId]?.second == event
//                                        .getY(i)
//                                        .toInt()
//                                            )
//                                ) {
//                                    movedPointerIndex = i
//                                    movedPointerId = event.getPointerId(i)
//                                    break
//                                }
//                            }
//                            if (movedPointerId != -1) {
//                                var prevKey: PianoKeyData? = null
//                                keyIdPointersMap.forEach { (keyId, value) ->
//                                    if (value.contains(movedPointerId)) {
//                                        prevKey = keyDataList.find {
//                                            it.name == keyId
//                                        }
//                                    }
//                                }
//
//                                val pointerX = event
//                                    .getX(movedPointerIndex)
//                                    .toInt()
//                                val pointerY = event
//                                    .getY(movedPointerIndex)
//                                    .toInt()
//                                val newKey: PianoKeyData? = keyDataList.find {
//                                    it.position.contains(pointerX, pointerY)
//                                }
//
//                                if (prevKey?.name == newKey?.name) {
//                                    cachedPointers[movedPointerId] = Pair(pointerX, pointerY)
//                                } else {
//                                    handlePointerUp(movedPointerId)
//                                    handlePointerDown(event, movedPointerId, movedPointerIndex)
//                                }
//                            }
//                            true
//                        }
//*/
//
//                        else -> {
//                            true
//                        }
//                    }
//                },
//        ) {
//            keyNameToKeyDataMap.forEach {
//                PianoKey(
//                    isPressed = false,
//                    data = it,
//                )
//            }
//        }
    }
}

@Composable
private fun PianoKey(
    isPressed: Boolean,
    data: PianoKeyData,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .offset(
                x = data.left,
                0.dp,
            )
            .width(data.width)
            .height(data.height)
            .background(
                if (isPressed) {
                    pressedColor
                } else {
                    data.backgroundColor
                }
            )
            .border(
                width = 1.dp,
                brush = SolidColor(
                    if (isPressed) {
                        pressedColor
                    } else {
                        data.borderColor
                    }
                ),
                shape = RectangleShape,
            ),
    )
}

/**
 * Given key name, return the key data
 */
private fun getKeyNameKeyDataMap(
    maxWidth: Dp,
    maxHeight: Dp,
): Map<String, PianoKeyData> {
    val whiteKeyWidth = maxWidth / 8
    val whiteKeyHeight = maxHeight
    val blackKeyWidth = whiteKeyWidth * 0.5F
    val blackKeyHeight = whiteKeyHeight * 0.67F
    val map = mutableMapOf<String, PianoKeyData>()

    var offset: Dp = 0.dp
    repeat(8) {
        map[whiteKeyNames[it]] = PianoKeyData(
            name = whiteKeyNames[it],
            file = whiteKeyFileMapping[whiteKeyNames[it]] ?: 0,
            top = 0.dp,
            left = offset,
            width = whiteKeyWidth,
            height = whiteKeyHeight,
            backgroundColor = Color.White,
            borderColor = Color.Black,
        )
        offset += whiteKeyWidth
    }
    offset = whiteKeyWidth * 0.75F
    repeat(5) {
        map[blackKeyNames[it]] = PianoKeyData(
            name = blackKeyNames[it],
            file = blackKeyFileMapping[blackKeyNames[it]] ?: 0,
            top = 0.dp,
            left = offset,
            width = blackKeyWidth,
            height = blackKeyHeight,
            backgroundColor = Color.Black,
            borderColor = Color.Transparent,
        )
        offset += whiteKeyWidth
        if (it == 1) {
            offset += whiteKeyWidth
        }
    }
    return map
}
