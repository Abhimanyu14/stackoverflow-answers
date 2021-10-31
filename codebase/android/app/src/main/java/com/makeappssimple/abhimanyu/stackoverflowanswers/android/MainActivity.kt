package com.makeappssimple.abhimanyu.stackoverflowanswers.android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.button.MaterialButton
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.ui.theme.StackOverflowAnswersTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StackOverflowAnswersTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background,
                ) {
                    CustomRadioGroup()
                }
            }
        }
    }
}

// https://stackoverflow.com/questions/69788366/create-toggle-button-group-in-jetpack-compose-without-radio-buttons
@Composable
fun CustomRadioGroup() {
    val options = listOf(
        "Option 1",
        "Option 2",
        "Option 3",
        "Option 4",
    )
    var selectedOption by remember {
        mutableStateOf("")
    }
    val onSelectionChange = { text: String ->
        selectedOption = text
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
    ) {
        options.forEach { text ->
            Row(
                modifier = Modifier
                    .padding(
                        all = 8.dp,
                    ),
            ) {
                Text(
                    text = text,
                    style = typography.body1.merge(),
                    color = Color.White,
                    modifier = Modifier
                        .clip(
                            shape = RoundedCornerShape(
                                size = 12.dp,
                            ),
                        )
                        .clickable {
                            onSelectionChange(text)
                        }
                        .background(
                            if (text == selectedOption) {
                                Color.Magenta
                            } else {
                                Color.LightGray
                            }
                        )
                        .padding(
                            vertical = 12.dp,
                            horizontal = 16.dp,
                        ),
                )
            }
        }
    }
}

// https://stackoverflow.com/questions/69779605/modifier-clip-being-ignored
@Composable
fun RoundImage() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .aspectRatio(1f)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
    }
}

// https://stackoverflow.com/questions/69778021/clickable-area-not-updated-in-jetpack-compose
@Composable
fun ClickAndDrag() {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        DraggableShape()
    }
}

@Composable
fun DraggableShape() {
    Box(modifier = Modifier.fillMaxSize()) {
        var offsetX by remember { mutableStateOf(0f) }
        var offsetY by remember { mutableStateOf(0f) }

        Box(
            Modifier
                .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
                .background(Color.Blue)
                .size(50.dp)
                .clickable {
                    Log.e("TAG", "Clicked")
                }
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consumeAllChanges()
                        offsetX += dragAmount.x
                        offsetY += dragAmount.y
                    }
                }
        )
    }
}

// https://stackoverflow.com/questions/69774982/blur-modifier-in-jetpack-compose-doesnt-work-in-preview
@Composable
fun BlurCheck() {
    //    Column(modifier = Modifier.blur(30.dp)) {
    //        Text(text = "Sample", modifier = Modifier.padding(16.dp))
    //    }
}

// https://stackoverflow.com/questions/69767679/update-jetpack-compose-list-with-scroll-position-reset
@Composable
fun ScrollToTop() {
    Column {
        ExampleScreen()
    }
}

class ViewItemsState(
    val items: List<String>,
)

class ExampleViewModel : ViewModel() {
    private var _itemsLiveData =
        MutableLiveData(
            ViewItemsState(
                items = Array(20) {
                    it.toString()
                }.toList(),
            )
        )
    val itemsLiveData: LiveData<ViewItemsState>
        get() = _itemsLiveData

    private var _scrollToTop = MutableLiveData(false)
    val scrollToTop: LiveData<Boolean>
        get() = _scrollToTop

    fun updateScrollToTop(scroll: Boolean) {
        _scrollToTop.postValue(scroll)
    }
}

@Composable
fun ExampleScreen(
    viewModel: ExampleViewModel = ExampleViewModel(),
) {
    val itemState by viewModel.itemsLiveData.observeAsState()
    val scrollToTop by viewModel.scrollToTop.observeAsState()
    val listState = rememberLazyListState()

    LaunchedEffect(
        key1 = scrollToTop,
    ) {
        if (scrollToTop == true) {
            listState.scrollToItem(0)
            viewModel.updateScrollToTop(false)
        }
    }

    Column {
        LazyColumn(
            state = listState,
            modifier = Modifier.weight(1f),
        ) {
            items(itemState?.items.orEmpty()) { item ->
                Text(
                    text = item,
                    modifier = Modifier.padding(16.dp),
                )
            }
        }
        Button(
            onClick = {
                viewModel.updateScrollToTop(true)
            },
        ) {
            Text(text = "Scroll")
        }
    }
}
// END


// https://stackoverflow.com/questions/69766087/how-to-apply-materials-responsive-layout-grid-to-android-compose
@Composable
fun ButtonInGrid() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f),
            ) {
                Text(text = "Center Button")
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}
// END

// https://stackoverflow.com/questions/69763249/is-a-good-way-to-use-stateboolean-in-view-model-with-android-compose
class ToggleViewModel : ViewModel() {
    private val _enabledStateFlow = MutableStateFlow(false)
    val enabledStateFlow: StateFlow<Boolean> = _enabledStateFlow

    private val _enabledState = mutableStateOf(false)
    val enabledState: State<Boolean> = _enabledState

    private var _enabled = false
    val enabled: Boolean = _enabled

    fun setEnabledStateFlow(isEnabled: Boolean) {
        _enabledStateFlow.value = isEnabled
    }

    fun setEnabledState(isEnabled: Boolean) {
        _enabledState.value = isEnabled
    }

    fun setEnabled(isEnabled: Boolean) {
        _enabled = isEnabled
    }
}

@Composable
fun BooleanToggle(
    viewmodel: ToggleViewModel = ToggleViewModel(),
) {
    val enabledStateFlow by viewmodel.enabledStateFlow.collectAsState()
    val enabledState by viewmodel.enabledState
    val enabled by rememberSaveable {
        mutableStateOf(viewmodel.enabled)
    }

    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text(text = if (enabledStateFlow) {
                "Enabled"
            } else {
                "Disabled"
            })
            Button(onClick = { viewmodel.setEnabledStateFlow(!enabledStateFlow) }) {
                Text("Toggle State Flow")
            }
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text(text = if (enabledState) {
                "Enabled"
            } else {
                "Disabled"
            })
            Button(onClick = { viewmodel.setEnabledState(!enabledState) }) {
                Text("Toggle State")
            }
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text(text = if (enabled) {
                "Enabled"
            } else {
                "Disabled"
            })
            Button(onClick = { viewmodel.setEnabled(!enabled) }) {
                Text("Toggle Value")
            }
        }
    }
}
// END

// https://stackoverflow.com/questions/69758903/how-to-implement-a-translate-scale-animation-in-jetpack-compose
@Composable
fun AnimatedBox() {
    var enabled by remember {
        mutableStateOf(false)
    }
    val modifier = Modifier
        .clickable(
            onClick = { enabled = !enabled },
        )
        .animateContentSize()
        .background(
            Color.Cyan,
        )

    Box(
        modifier =
        if (enabled) {
            modifier.fillMaxSize()
        } else {
            modifier.size(36.dp)
        }
    ) {

    }
}

@Composable
fun MaterialButtonInterOp() {
    AndroidView(
        factory = {
            MaterialButton(it).apply {
                text = "Hello"
                elevation = 8.0F
            }
        },
        modifier = Modifier.padding(16.dp),
    )
}

@Composable
// https://stackoverflow.com/questions/69753048/how-can-i-change-topappbar-position-in-the-jetpack-compose
fun AppBarPos() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Account",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                    )
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Rounded.ArrowBack,
                        contentDescription = "back",
                    )
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Rounded.ShoppingCart,
                            contentDescription = "back",
                        )
                    }
                },
            )
        },
        content = {

        },
    )
}
// END

// https://stackoverflow.com/questions/69700669/is-it-possible-to-use-gradient-in-compose-theme-colors
@Composable
fun GradientColor() {
    Box(
        modifier = Modifier
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.Red,
                        Color.White,
                    ),
                    start = Offset(0f, 0f),
                    end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY),
                )
            )
            .fillMaxSize(),
    ) {

    }
}
// END


@Composable
fun TextFieldWeight() {

}

// https://stackoverflow.com/questions/69511201/animating-content-in-jetpack-compose
@Composable
fun AnimatedLayout() {


}

enum class ContentState {
    One,
    Two,
}

@ExperimentalAnimationApi
@Composable
fun ContentAnimator(
    modifier: Modifier = Modifier,
    // state: ContentState = ContentState.One,
) {
    var state by remember {
        mutableStateOf(ContentState.One)
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                state = if (state == ContentState.One) {
                    ContentState.Two
                } else {
                    ContentState.One
                }
            },
        contentAlignment = Alignment.Center,
    ) {
        AnimatedContent(
            targetState = state,
        ) { targetState ->
            when (targetState) {
                ContentState.One -> OneLayout()
                ContentState.Two -> TwoLayout()
            }
        }
    }
}

@Composable
fun OneLayout() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxSize()
            .rotate(90F)
    ) {
        Box(
            modifier = Modifier
                .size(width = 48.dp, height = 48.dp)
                .background(Color.Red),
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "Sample text",
            style = typography.h3,
        )
    }
}

@Composable
fun TwoLayout() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .size(width = 48.dp, height = 48.dp)
                .background(Color.Red)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Sample text",
            style = typography.h3,
        )
    }
}

// https://stackoverflow.com/questions/69501458/lazycolumn-with-header-item-in-card-and-remaining-items-in-card
@Composable
fun LazyHeaderImpl() {
    LazyHeader(
        data = Array(100) { "Item $it" }.toList(),
    )
}

@Composable
fun LazyHeader(
    data: List<String>,
) {
    // our offset to collapse toolbar
    val toolbarOffsetHeightPx = remember { mutableStateOf(0f) }

    // now, let's create connection to the nested scroll system and listen to the scroll
    // happening inside child LazyColumn
    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                // try to consume before LazyColumn to collapse toolbar if needed, hence pre-scroll
                val delta = available.y
                Log.e("Abhi", delta.toString())
                val newOffset = if ((toolbarOffsetHeightPx.value + delta) < 0) {
                    toolbarOffsetHeightPx.value + delta
                } else {
                    0F
                }
                toolbarOffsetHeightPx.value = newOffset // .coerceIn(-toolbarHeightPx, 0f)
                // here's the catch: let's pretend we consumed 0 in any case, since we want
                // LazyColumn to scroll anyway for good UX
                // We're basically watching scroll without taking it
                return Offset.Zero
            }
        }
    }

    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
        // .nestedScroll(nestedScrollConnection)
    ) {
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
                // .offset { IntOffset(x = 0, y = toolbarOffsetHeightPx.value.roundToInt()) },
            ) {
                Text(
                    text = "This is header text",
                    modifier = Modifier.padding(16.dp),
                )
            }
        }

        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                // .offset { IntOffset(x = 0, y = toolbarOffsetHeightPx.value.roundToInt()) },
            ) {
                // LazyColumn {
                this@LazyColumn.items(data) { item ->
                    Text(
                        text = item,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                    )
                }
                // }
            }
        }
    }
}
// END


// https://stackoverflow.com/questions/69500505/what-is-equivalent-to-banner-in-android-jetpack-compose/69504226#69504226
@Composable
fun BannerImpl() {
    Banner(
        text = "There was a problem processing a transaction on your credit card.",
        button1Text = "FIX IT",
        button2Text = "LEARN MORE",
    )
}

@Composable
fun Banner(
    text: String,
    button1Text: String? = null,
    button2Text: String? = null,
    button1ClickListener: (() -> Unit)? = null,
    button2ClickListener: (() -> Unit)? = null,
) {
    Column {
        Text(
            text = text,
            modifier = Modifier.padding(16.dp),
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 8.dp,
                    end = 8.dp,
                    bottom = 8.dp,
                ),
            horizontalArrangement = Arrangement.End,
        ) {
            button1Text?.let {
                TextButton(
                    onClick = if (button1ClickListener != null) {
                        button1ClickListener
                    } else {
                        {}
                    }
                ) {
                    Text(
                        text = button1Text,
                    )
                }
            }
            button2Text?.let {
                TextButton(
                    onClick = if (button2ClickListener != null) {
                        button2ClickListener
                    } else {
                        {}
                    }
                ) {
                    Text(
                        text = button2Text,
                    )
                }
            }
        }
        Divider()
    }
}
// END


@Composable
fun SecondAlertDialog() {
    val text = remember { mutableStateOf("") }
    val hasConfirmed = remember { mutableStateOf(false) }
    if (!hasConfirmed.value) {
        AlertDialog(
            // title = { Text("Title") },
            text = {
                Column {
                    Text("Title",
                        Modifier
                            .background(Color.Blue)
                            .fillMaxWidth())
                    OutlinedTextField(
                        value = text.value,
                        onValueChange = {
                            text.value = it
                        },
                        label = {
                            Text(
                                text = "",
                                style = typography.body2
                            )
                        }
                    )
                }
            },
            onDismissRequest = {
            },
            confirmButton = {
                Button(
                    onClick = {
                        hasConfirmed.value = true
                    },
                ) {
                    Text("Confirm")
                }
            }
        )
    } else {
        Text("Confirmed")
    }
}

@Composable
fun MyAlertDialog() {
    val text = remember { mutableStateOf("") }
    val hasConfirmed = remember { mutableStateOf(false) }
    if (!hasConfirmed.value) {
        AlertDialog(
            title = { Text("Title") },
            text = {
                OutlinedTextField(
                    value = text.value,
                    onValueChange = {
                        text.value = it
                    },
                    label = {
                        Text(
                            text = "",
                            style = typography.body2
                        )
                    }
                )
            },
            onDismissRequest = {
            },
            confirmButton = {
                Button(
                    onClick = {
                        hasConfirmed.value = true
                    },
                ) {
                    Text("Confirm")
                }
            }
        )
    } else {
        Text("Confirmed")
    }
}

@Composable
fun CardElevation() {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
    ) {
        Card(
            elevation = 64.dp,
        ) {
            Text(
                text = "Sample",
                modifier = Modifier
                    .background(Color.Blue)
                    .padding(32.dp),
            )
        }
    }
}

@Composable
fun TextInput() {
    var name by remember { mutableStateOf("") }
    Column {
        TextField(
            shape = MaterialTheme.shapes.medium,
            value = name,
            placeholder = {
                Text(
                    text = "Label",
                )
            },
            onValueChange = {
                name = it
            },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp,
                ),
        )
    }
}

@Preview()
@Composable
fun DefaultPreview() {
    StackOverflowAnswersTheme {
        TextInput()
    }
}
