package com.makeappssimple.abhimanyu.stackoverflowanswers.android.pager

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerSample() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val pagerState = rememberPagerState(pageCount = { 10 })
        SaveVariable(pagerState, VariableViewModel())
    }
}

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun SaveVariable(pagerState: PagerState, viewModel: VariableViewModel) {
    LaunchedEffect(key1 = pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            viewModel.currentIndex = page
        }
    }
    LaunchedEffect(key1 = viewModel.setLastCurrentPage) {
        Log.e(">> LaunchedEffect", "${viewModel.currentIndex}")
    }
    SaveVariableItem(viewModel.currentIndex, viewModel.uiState, pagerState) {
        viewModel.changeUIi()
    }
}

class VariableViewModel : ViewModel() {
    var uiState by mutableStateOf(ScreenName.FIRST)
    var currentIndex by mutableStateOf(0)
    var setLastCurrentPage by mutableStateOf(false)
    fun changeUIi() {
        uiState = if (uiState == ScreenName.FIRST) {
            setLastCurrentPage = true
            ScreenName.SECOND
        } else {
            setLastCurrentPage = false
            ScreenName.FIRST
        }
    }
}

enum class ScreenName {
    FIRST,
    SECOND
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SaveVariableItem(
    currentIndex: Int,
    uiState: ScreenName,
    pagerState: PagerState,
    changeUiState: () -> Unit,
) {
    Column {
        when (uiState) {
            ScreenName.FIRST -> {
                ScreenFirstView(pagerState)
            }

            ScreenName.SECOND -> {
                ScreenSecondView(currentIndex, "SECOND")
            }
        }
        ChangeUiStateButton(changeUiState)
    }
}

@Composable
fun ChangeUiStateButton(changeUiState: () -> Unit) {
    Button(onClick = { changeUiState() }) {
        Text(text = "Add")
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ScreenFirstView(pagerState: PagerState) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .background(Color.Black)
    ) {
        HorizontalPager(
            modifier = Modifier.padding(20.dp),
            // pageCount = 10,
            state = pagerState
        ) { page ->
            Text(
                text = "Page: $page",
                modifier = Modifier.fillMaxWidth(),
                color = Color.White
            )
        }
    }
}

@Composable
fun ScreenSecondView(currentIndex: Int, screenImage: String) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .background(Color.Black)
    ) {
        Text(text = "$currentIndex ==== $screenImage", color = Color.White)
    }
}
