package com.makeappssimple.abhimanyu.stackoverflowanswers.android

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Close
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
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
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        DisableMultiSelect()
                    }
                }
            }
        }
    }
}

// https://stackoverflow.com/questions/69902784/state-update-from-pointerinput-not-working?noredirect=1#comment123567201_69902784v
@Composable
fun PointerInput() {
    val (pressedItem, setPressedItem) = remember {
        mutableStateOf(-1)
    }

    Log.e("Test", "$pressedItem")
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(LightGray)
            .pointerInput("key") {
                detectTapGestures(
                    onPress = {
                        Log.e("Test", "onPress")
                        setPressedItem(1) // Not working
                    },
                    onTap = {
                        Log.e("Test", "onTap")
                        setPressedItem(2) // Not working
                    },
                    onDoubleTap = {
                        Log.e("Test", "onDoubleTap")
                        setPressedItem(3) // Not working
                    },
                    onLongPress = {
                        Log.e("Test", "onLongPress")
                        setPressedItem(4) // Not working
                    },
                )
            }
    ) {
        Text(
            text = "$pressedItem",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

// https://stackoverflow.com/questions/69901608/how-to-disable-multi-item-select-in-jetpack-compose-list-out-of-the-box-debounc
@Composable
fun DisableMultiSelect() {
    val (pressedItem, setPressedItem) = remember {
        mutableStateOf(-1)
    }

    Column(
        modifier = Modifier
            .background(White)
            .fillMaxSize(),
    ) {
        val data = Array(10) { it }

        data.forEachIndexed { index, _ ->
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(LightGray)
                    .pointerInput("key", pressedItem) {
                        detectTapGestures(
                            onPress = {
                                Log.e("Test", "onPress")
                                Log.e("Test", "pressedItem: $pressedItem")
                                if (pressedItem == -1) {
                                    setPressedItem(index)
                                    Log.e("Test", "index: $index")
                                }
                            },
                            onTap = {
                                Log.e("Test", "onTap")
                                Log.e("Test", "pressedItem: $pressedItem")
                                Log.e("Test", "index: $index")
                                if (pressedItem == index) {
                                    // Click handler
                                    Log.e("Test", "Clicked item: $index")

                                    setPressedItem(-1)
                                }
                            },
                            onDoubleTap = {
                                Log.e("Test", "onDoubleTap")
                                Log.e("Test", "pressedItem: $pressedItem")
                            },
                            onLongPress = {
                                Log.e("Test", "onLongPress")
                                Log.e("Test", "pressedItem: $pressedItem")
                            },
                        )
                    }
            ) {
                Text(
                    text = "$pressedItem",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
    }
}

// https://stackoverflow.com/questions/69901020/set-height-to-row-in-jetpack-compose-equivalent-to-wrap-content-in-xml
@Composable
fun RowHeight() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp),
    ) {
        Button(
            {},
            Modifier
                .weight(1f)
                .padding(16.dp),
        ) {
            Text(text = "Button 1")
        }
        Button(
            {},
            Modifier
                .weight(1f)
                .padding(16.dp),
        ) {
            Text(text = "Button 2")
        }
    }
}

// https://stackoverflow.com/questions/69901050/align-item-in-box-jetpack-compose
@Composable
fun ImageWithCloseButton() {
    Box(
        modifier = Modifier
            .background(LightGray)
            .padding(16.dp)
            .size(88.dp),
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.ic_launcher_foreground,
            ),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.Center)
                .clip(RoundedCornerShape(16.dp))
                .background(Black)
                .size(80.dp),
            contentScale = ContentScale.Crop,
        )
        IconButton(
            onClick = {},
            modifier = Modifier
                .clip(CircleShape)
                .background(White)
                .align(Alignment.TopEnd)
                .size(16.dp)
        ) {
            Icon(
                imageVector = Icons.Rounded.Close,
                contentDescription = "",
            )
        }
    }
}

// https://stackoverflow.com/questions/69867249/does-remember-only-work-with-mutablestate-variables
@Composable
fun RememberDemo() {
    var count by remember {
        mutableStateOf(0)
    }

    var fireCount by remember {
        mutableStateOf(0)
    }

    var fired = remember {
        false
    }
    if (!fired) {
        fireCount++
        fired = true
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
    ) {
        Text(
            text = "$count , $fireCount",
        )
        TextButton(
            onClick = {
                count++
            },
            modifier = Modifier.width(160.dp),
        ) {
            Text(text = "Increment")
        }
    }
}


// https://stackoverflow.com/questions/69862078/how-change-outlinetextfield-border-width-in-android-jetpack-compose
@Composable
fun TextFieldOutlineWidth() {
    OutlinedTextField(
        value = "",
        onValueChange = { },
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp),
        label = { Text(text = "Label") },
        // shape = RoundedCornerShape(12.dp),
    )
}

// https://stackoverflow.com/questions/69854608/how-to-put-3-texts-in-a-row-so-that-everything-is-visible
@Composable
fun RowExample() {
    Row(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(
            text = "Label",
            color = Red,
            style = typography.h5,
            modifier = Modifier.padding(8.dp),
        )
        Text(
            text = "If text is too long, wrap it",
            style = typography.h5,
            modifier = Modifier
                .weight(1f)
                .padding(8.dp),
        )
        Text(
            text = "(2)",
            color = Green,
            style = typography.h5,
            modifier = Modifier.padding(8.dp),
        )
    }
}

// https://stackoverflow.com/questions/69844103/how-to-remove-keyboard-flicker-on-switch-textfields
@Composable
fun KeyboardFlicker() {
    LazyColumn {
        items(20) {
            Row(modifier = Modifier.padding(vertical = 4.dp)) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .border(1.dp, Gray, RoundedCornerShape(4.dp))
                        .padding(vertical = 4.dp)
                ) {
                    BasicTextField(
                        value = "",
                        onValueChange = { },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                        ),
                    )
                    Text(
                        text = "₹ 0",
                        modifier = Modifier.alpha(0.5f)
                    )
                }
            }
        }
    }
}

// https://stackoverflow.com/questions/69843624/how-do-i-show-only-the-last-3-lines-of-text-in-jetpack-compose
@Composable
fun LastText() {
    Row(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(
            text = "This is a very long text 1.This is a very long text 2.This is a very long text 3.This is a very long text 4.This is a very long text 5.This is a very long text 6.This is a very long text 7.This is a very long text 8.This is a very long text 9.",
            maxLines = 3,
            modifier = Modifier
                .align(Alignment.Bottom)
                .padding(16.dp),
        )
    }
}

// https://stackoverflow.com/questions/69842871/how-to-remove-border-of-card-view-with-jetpack-compose
@Composable
fun CardBorder() {
    Card(
        elevation = 0.dp,
        modifier = Modifier
            .height(
                height = 120.dp,
            )
            .padding(
                all = 8.dp,
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {},
        ) {
            Text(
                modifier = Modifier
                    .weight(
                        weight = 1f,
                    )
                    .padding(
                        all = 8.dp,
                    )
                    .wrapContentWidth(
                        align = Alignment.Start,
                    ),
                text = "Submit",
                style = typography.h4,
            )
        }
    }
}

// https://stackoverflow.com/questions/69841065/jetpack-compose-about-preview-widthdp-and-heightdp
@Composable
fun NewDefaultPreview() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Red),
    )
}

// https://stackoverflow.com/questions/69840755/how-to-center-elements-in-row-jetpack-compose#69840755
@Composable
fun BaseTextField(
    modifier: Modifier = Modifier,
    maxLines: Int = 1,
    enabled: Boolean = true,
    textColor: Color = Black,
    value: String,
    placeholderText: String,
    onValueChange: (String) -> Unit,
) {
    TextField(
        modifier = modifier.padding(horizontal = 0.dp, vertical = 0.dp),
        value = value,
        onValueChange = onValueChange,
        maxLines = maxLines,
        enabled = enabled,
        placeholder = { Text(text = placeholderText) },
        colors = TextFieldDefaults.textFieldColors(
            textColor = textColor,
            focusedIndicatorColor = Transparent,
            disabledIndicatorColor = Transparent,
            unfocusedIndicatorColor = Transparent,
            backgroundColor = Transparent,
        )
    )
}

@Composable
fun PhoneNumberTextField(
    modifier: Modifier = Modifier,
    maxLines: Int = 1,
    enabled: Boolean = true,
    value: String = "123",
    numberPrefix: String = "+212",
    onValueChange: (String) -> Unit = {},
    onPrefixClick: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color.Red),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextButton(
            modifier = modifier.padding(17.dp),
            // numberPrefix = numberPrefix,
            onClick = onPrefixClick
        ) {
            Text(text = numberPrefix)
        }
        Box(
            Modifier
                .background(Gray)
                .height(20.dp)
                .width(1.dp)
                .padding(start = 3.dp, end = 14.dp)
        )
        BaseTextField(
            enabled = enabled,
            maxLines = maxLines,
            value = value,
            onValueChange = onValueChange,
            placeholderText = "Hint"
        )
    }
}

// https://stackoverflow.com/questions/69813880/always-display-placeholder-and-rtl-input-in-textfield-with-jetpack-compose?noredirect=1#comment123406417_69813880
@Composable
fun FixedPlaceholder() {
    var name by remember { mutableStateOf("") }
    Box {
        OutlinedTextField(
            shape = MaterialTheme.shapes.medium,
            value = name,
            onValueChange = {
                name = it
            },
            singleLine = true,
            textStyle = LocalTextStyle.current.copy(
                textAlign = TextAlign.End,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp,
                ),
        )
        Text(
            text = "to",
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 32.dp,
                    end = 32.dp,
                    top = 24.dp,
                    bottom = 8.dp
                ),
        )
    }
}

// https://stackoverflow.com/questions/69813731/custom-toast-in-jetpack-compose/69814172#69814172
@Composable
fun CustomToast() {

    // TL:DR - Custom toasts are deprecated

    val context = LocalContext.current
    val toast = Toast.makeText(
        context,
        "Showing toast....",
        Toast.LENGTH_LONG
    )


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                toast.show()
            },
        ) {
            Text(text = "Show Toast")
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
