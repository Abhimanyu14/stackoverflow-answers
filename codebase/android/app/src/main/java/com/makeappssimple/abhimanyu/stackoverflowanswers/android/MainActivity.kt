package com.makeappssimple.abhimanyu.stackoverflowanswers.android

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.gestures.GestureCancellationException
import androidx.compose.foundation.gestures.PressGestureScope
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.forEachGesture
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.AlertDialog
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.IconButton
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.pointer.AwaitPointerEventScope
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.input.pointer.PointerInputScope
import androidx.compose.ui.input.pointer.changedToUp
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.consumeDownChange
import androidx.compose.ui.input.pointer.isOutOfBounds
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChangeConsumed
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.fastAll
import androidx.compose.ui.util.fastAny
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.android.material.button.MaterialButton
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.ui.theme.StackOverflowAnswersTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.roundToInt
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import java.util.Locale

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(InternalCoroutinesApi::class, ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StackOverflowAnswersTheme(
            ) {
                DefaultAppView()
            }
        }
    }

    //    override fun dispatchTouchEvent(motionEvent: MotionEvent?): Boolean {
    //        return motionEvent?.pointerCount == 1 && super.dispatchTouchEvent(motionEvent)
    //    }
}

@Composable
fun DefaultAppView() {
    StackOverflowAnswersTheme(
    ) {
        // A surface container using the 'background' color from the theme
        Surface(
            color = MaterialTheme.colors.background,
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize(),
            ) {
                MyAppView()
            }
        }
    }
}

@Composable
fun MyAppView() {
    val navHostController = rememberNavController()
    NavHost(
        navController = navHostController,
        startDestination = "first",
    ) {
        composable(
            route = "first",
        ) {
            Home(
                navHostController = navHostController,
            )
        }
        composable(
            route = "second",
        ) {
            SimpleTextField(
                navHostController = navHostController,
            )
        }
    }
}

@Composable
fun Home(
    navHostController: NavController,
) {
    RtlLabelInOutlineTextField()
}

// New question code comes here

// https://stackoverflow.com/questions/72813452/how-to-change-label-direction-in-the-outlinedtextfield
@Composable
fun RtlLabelInOutlineTextField() {
    val (digit1, setDigit1) = remember {
        mutableStateOf("")
    }
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        OutlinedTextField(
            value = digit1,
            onValueChange = {
                setDigit1(it)
            },
            label = {
                Text("Label")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Next,
            ),
            modifier = Modifier.fillMaxWidth().padding(16.dp),
        )
    }
}

// https://stackoverflow.com/questions/72772733/how-can-i-click-on-component-behind-any-component-in-jetpack-compose
@Composable
fun ClickThrough() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier
                .size(200.dp)
                .clickable {
                    Log.e("Test", "Clicked Red Box")
                },
            color = Color.Red
        ) {}
        DisabledClickableSwitch()
        Surface(
            modifier = Modifier
                .size(50.dp)
                .clickable(
                    enabled = false, onClick = {},
                ),
            color = Color.Blue
        ) {}
    }
}

// https://stackoverflow.com/questions/72678189/is-there-a-way-to-check-if-user-has-scrolled-before
@Composable
fun IsScrolled() {
    var isScrolled by remember {
        mutableStateOf(false)
    }
    val scrollState = rememberLazyListState()
    val list = Array(50) {
        "Item ${it + 1}"
    }

    LaunchedEffect(
        key1 = scrollState.isScrollInProgress,
    ) {
        if (!isScrolled) {
            isScrolled = scrollState.isScrollInProgress
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Text(text = "$isScrolled")
        LazyColumn(
            state = scrollState,
            modifier = Modifier
                .background(LightGray)
                .fillMaxSize(),
        ) {
            items(list) {
                Text(
                    text = it,
                    modifier = Modifier
                        .padding(16.dp)
                        .background(White),
                )
            }
        }
    }
}

// https://stackoverflow.com/questions/72681547/android-jetpack-compose-position-children-in-lazyrow
@Composable
fun ScrollableRowWithSpace() {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    val list = Array(10) {
        "Item ${it + 1}"
    }

    LazyRow(
        modifier = Modifier
            .background(LightGray)
            .fillMaxWidth(),
    ) {
        item {
            Spacer(modifier = Modifier
                .background(White)
                .width(screenWidth / 2))
        }
        items(list) {
            Text(
                text = it,
                modifier = Modifier
                    .padding(16.dp)
                    .background(White),
            )
        }
    }
}

// https://stackoverflow.com/questions/72620951/fold-in-and-fold-out-in-modifier
@Composable
fun FoldInAndFoldOut() {
    val modifier = Modifier
        .size(40.dp)
        .background(Color.Gray)
        .clip(CircleShape)
    LaunchedEffect(modifier) {
        modifier.foldIn(0) { index, element: Modifier.Element ->
            Log.e("TAG", "$index -> $element")
            index + 1
        }
        modifier.foldOut(0) { element: Modifier.Element, index ->
            Log.e("TAG", "$index -> $element")
            index + 1
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Row(
            modifier = Modifier
                .weight(1F)
                .fillMaxWidth(),
        ) {
            Text("Child 1")
        }
        Row(
            modifier = Modifier
                .weight(1F)
                .fillMaxWidth(),
        ) {
            Text("Child 1")
        }
        Box(modifier = modifier.weight(1F))
    }
}

// https://stackoverflow.com/questions/68655165/break-sentence-line-with-hyphen-if-word-is-too-long-in-android-jetpack-compose/72556451#72556451
@Composable
fun LongText() {
    Text("This is a verrrryryryryreyeryeryeryerreyrfjdafbgkjabfdgbjabldfjbgjbakfdjbkgjbkadfbkgbbafdlbgboafdghbafdhlgalfdhgabdfgbfadhglfahgheyer long text".replace(
        " ",
        "\u00AD"))
}

// https://stackoverflow.com/questions/71476488/equal-width-elements-in-jetpack-compose-row
// https://stackoverflow.com/questions/72553148/how-can-i-make-all-cells-of-a-row-have-the-width-of-the-widest-one
@Composable
fun AutoWidthRow() {
    val items = listOf("Item 1", "Item 2", "Item 300")
    Row(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier.width(IntrinsicSize.Min),
    ) {
        items.forEach { option ->
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(
                        vertical = 6.dp, horizontal = 1.dp
                    )
                    // .width(IntrinsicSize.Max) // Removing this will wrap the text
                    .weight(1F)
                    .background(Color.Black)
            ) {
                Text(
                    text = option,
                    color = Color.White,
                    modifier = Modifier
                        .padding(14.dp),
                )
            }
        }
    }
}

// https://stackoverflow.com/questions/72545412/on-swipe-down-jetpack-compose-modalbottomsheet-skip-halfexpanded-state
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ModalBottomSheetSingleSwipe() {
    val coroutineScope: CoroutineScope = rememberCoroutineScope()
    val modalBottomSheetState: ModalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
//        confirmStateChange = {
//            it != ModalBottomSheetValue.HalfExpanded
//        },
    )

    LaunchedEffect(
        key1 = modalBottomSheetState.currentValue,
    ) {
        if (modalBottomSheetState.targetValue == ModalBottomSheetValue.HalfExpanded) {
            coroutineScope.launch {
                modalBottomSheetState.animateTo(ModalBottomSheetValue.Hidden)
            }
        }
    }
    ModalBottomSheetLayout(
        sheetState = modalBottomSheetState,
        sheetContent = {
            Text(
                text = "Bottom Sheet Content",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 16.dp)
                    .background(LightGray)
                    .wrapContentHeight()
                    .height(800.dp),
            )
        },
    ) {
        Box(
            contentAlignment = Alignment.Center,
        ) {
            TextButton(
                onClick = {
                    coroutineScope.launch {
                        // modalBottomSheetState.show()
                        modalBottomSheetState.animateTo(ModalBottomSheetValue.Expanded)
                    }
                },
            ) {
                Text(text = "Open Bottom Sheet")
            }
        }
    }
}

// https://stackoverflow.com/questions/72546187/kotlin-jetpack-compose-center-text-in-column-inside-a-lazycolum
@Composable
fun CenterTextWithFixedHeight() {
    Text(
        text = "Center",
        modifier = Modifier
            .background(LightGray)
            .fillMaxWidth()
            .height(50.dp)
            .wrapContentHeight(),
        textAlign = TextAlign.Center, // without it image 1, with it image 2
        color = Color.Black,
    )
}

// https://stackoverflow.com/questions/72546187/kotlin-jetpack-compose-center-text-in-column-inside-a-lazycolum
@Composable
fun CenterTextInColumn() {
    Box(modifier = Modifier
        .background(Color(0xFFf4f4f4))
        .fillMaxSize()
        .padding(top = 20.dp)) {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            elevation = 5.dp
        ) {
            val colorNamesList = listOf("Red", "Green", "Blue", "Indigo")
            LazyColumn() {
                itemsIndexed(
                    colorNamesList,
                ) { index, item ->
                    Column(
                        modifier = Modifier
                            .background(
                                color = Color(0xFFf2f2f2),
                            )
                            .clickable {
                                println(item)
                            },
                        horizontalAlignment = Alignment.CenterHorizontally,//those 2 does nothing
                        verticalArrangement = Arrangement.Center //when i change it nothing change
                    ) {
                        println(item + index)
                        Text(
                            text = "Item at  $item",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .wrapContentHeight(),
                            textAlign = TextAlign.Center, // without it image 1, with it image 2
                            color = Color.Black,
                        )
                        if (index < colorNamesList.lastIndex) {
                            Divider(
                                color = Color.Black.copy(alpha = 0.2f),
                                modifier = Modifier
                                    .padding(horizontal = 80.dp),
                            )
                        }
                    }
                }
            }
        }
    }
}


// https://stackoverflow.com/questions/72544313/kotlin-jetpack-compose-divider-before-my-first-item-with-lazycolumn-and-surface
@Composable
fun DividerCard() {
    Box(
        modifier = Modifier
            .background(Color(0xFFf4f4f4))
            .fillMaxSize()
            .padding(top = 20.dp),
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            elevation = 5.dp,
        ) {
            val colorNamesList = listOf("Red", "Green", "Blue", "Indigo")
            LazyColumn {
                itemsIndexed(
                    colorNamesList,
                ) { index, item ->
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .background(
                                color = Color(0xFFf2f2f2),
                            )
                            .clickable {
                                println(item)
                            },
                    ) {
                        println(item + index)
                        Text(
                            text = "Item at  $item",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .padding(top = 15.dp),
                            textAlign = TextAlign.Center,
                            color = Color.Black,
                        )
                        if (index < colorNamesList.lastIndex) {
                            Divider(
                                color = Color.Black.copy(alpha = 0.2f),
                                modifier = Modifier
                                    .padding(horizontal = 80.dp),
                            )
                        }
                    }
                }
            }
        }
    }
}


// https://stackoverflow.com/questions/72514987/unexpected-border-in-composables-border-shows-even-if-border-width-is-zero
@Composable
fun TextBoxPreview() {
    TextBox(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .padding(16.dp),
        backgroundColor = Color.Yellow,
        borderWidth = 0.dp,
        borderColor = Green
    )
}

@Composable
fun TextBox(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Yellow,
    borderWidth: Dp = 0.dp,
    borderColor: Color = Black,
) {
    Box(
        modifier = modifier
            .background(backgroundColor)
            .border(
                width = borderWidth,
                color = if (borderWidth == 0.dp) {
                    Transparent
                } else {
                    borderColor
                },
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "EXPLORE")
    }
}

// https://stackoverflow.com/questions/72477106/stringresource-not-loading-strings-of-current-locale?noredirect=1#comment128072981_72477106
@Composable
fun LocalizedGreeting() {
    val context = LocalContext.current
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Column {
            Button(
                onClick = {
                    changeLanguage(
                        context = context,
                        language = "it",
                    )
                },
            ) {
                Text("Italian")
            }
            Button(
                onClick = {
                    changeLanguage(
                        context = context,
                        language = "en",
                    )
                },
            ) {
                Text("English")
            }
            Text(
                stringResource(
                    id = R.string.localized_greeting,
                )
            )
        }
    }
}

fun changeLanguage(
    context: Context,
    language: String,
) {
    val locale = Locale(language)
    Locale.setDefault(locale)
    val config = Configuration()
    config.locale = locale
    context.resources.updateConfiguration(config, context.resources.displayMetrics)
    context.startActivity(Intent.makeRestartActivityTask((context as Activity).intent?.component))
}

// https://stackoverflow.com/questions/72483398/swipetodismess-swipetodismiss-overlays-on-the-next-list-item-when-swiped-how
/*@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SwipeToDismissSample() {
    val list = (1..10).toMutableList()
    val dismissState = rememberDismissState(
        confirmStateChange = {
            if (it == DismissValue.DismissedToStart) {
                list.remove(it)
                storedItemsViewModel.deleteOne(sentence)
            }
            true
        }
    )
    val direction = dismissState.dismissDirection
    SwipeToDismiss(
        state = dismissState,
        */
/***  create dismiss alert Background *//*
        directions = setOf(
            DismissDirection.EndToStart
        ),
        dismissThresholds = {
            *//*direction ->*//*
            FractionalThreshold(if (direction == DismissDirection.EndToStart) 0.1f else 0.5f)
            FractionalThreshold(0.2f)
        },
        background = {
            val color = when (dismissState.dismissDirection) {
                DismissDirection.StartToEnd -> Green
                DismissDirection.EndToStart -> Red
                null -> Transparent
            }
            val alignment = Alignment.CenterEnd
            val icon = Icons.Default.Delete
            val scale by animateFloatAsState(
                // this scales the icon
                if (dismissState.targetValue == DismissValue.Default) 0.75f else 1f
            )
            Box(
                Modifier
                    .fillMaxSize()
                    .background(color)
                    .padding(horizontal = Dp(20f)),
                contentAlignment = alignment
            ) {
                Icon(
                    icon,
                    contentDescription = "Delete Icon",
                    modifier = Modifier.scale(scale)
                )
            }
        },
        *//**** Dismiss Content *//*
        dismissContent = {
            Card(
                elevation = animateDpAsState(if (dismissState.dismissDirection != null) 4.dp else 0.dp).value,
            ) {
                FavoriteItem(sentence, word, grammar)
            }
        },
    )
}*/

// https://stackoverflow.com/questions/72474483/how-to-listen-to-keyboard-events-in-jetpack-compose-without-a-textfield
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CustomInput() {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember {
        FocusRequester()
    }

    LaunchedEffect(
        key1 = Unit,
    ) {
        focusRequester.requestFocus()
        keyboardController?.show()
    }

    var text by remember {
        mutableStateOf(
            value = "Sample Text",
        )
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box {
            Text(
                text = text,
            )
            BasicTextField(
                value = text,
                onValueChange = { value: String ->
                    text = value
                },
                modifier = Modifier
                    .focusRequester(focusRequester),
                singleLine = true,
            )
            Box(
                modifier = Modifier
                    .background(Red)
                    .matchParentSize()
                    .focusable(true)
                    .focusRequester(focusRequester)
                    .alpha(0f)
                    .clickable(
                        onClick = {
                            keyboardController?.show()
                        },
                    ),
            )
        }
    }
}

// https://stackoverflow.com/questions/72448831/compose-textfield-with-blinking-cursor-and-without-the-systems-keyboard
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun FocusedTextFieldWithoutKeyboard() {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember {
        FocusRequester()
    }

    LaunchedEffect(
        key1 = Unit,
    ) {
        focusRequester.requestFocus()
        keyboardController?.hide()
    }

    val initialText = "Sample Text"
    var text by remember {
        mutableStateOf(
            value = TextFieldValue(
                text = "Sample Text",
                selection = TextRange(
                    start = initialText.length,
                    end = initialText.length,
                ),
            ),
        )
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box {
            BasicTextField(
                value = text,
                onValueChange = { value: TextFieldValue ->
                    text = value
                },
                modifier = Modifier
                    .focusRequester(focusRequester),
                singleLine = true,
            )
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .alpha(0f)
                    .clickable(
                        onClick = {},
                    ),
            )
        }
        Row {
            Button(
                onClick = {
                    text = text.copy(
                        text = "${text.text}1",
                        selection = TextRange(
                            start = text.text.length + 1,
                            end = text.text.length + 1,
                        ),
                    )
                },
                modifier = Modifier.padding(horizontal = 8.dp),
            ) {
                Text(text = "1")
            }
            Button(
                onClick = {
                    text = text.copy(
                        text = "${text.text}2",
                        selection = TextRange(
                            start = text.text.length + 1,
                            end = text.text.length + 1,
                        ),
                    )
                },
                modifier = Modifier.padding(horizontal = 8.dp),
            ) {
                Text(text = "2")
            }
            Button(
                onClick = {
                    text = text.copy(
                        text = "${text.text}3",
                        selection = TextRange(
                            start = text.text.length + 1,
                            end = text.text.length + 1,
                        ),
                    )
                },
                modifier = Modifier.padding(horizontal = 8.dp),
            ) {
                Text(text = "3")
            }
        }
    }
}

// https://stackoverflow.com/questions/72444028/how-to-remove-default-padding-in-text-jetpack-compose
@OptIn(ExperimentalTextApi::class)
@Composable
fun TextWithoutPadding() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Text(
            text = AnnotatedString("Sample Text"),
            fontSize = 64.sp,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = true,
                ),
            ),
            modifier = Modifier
                .background(
                    color = Cyan,
                ),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = AnnotatedString("Sample Text"),
            fontSize = 64.sp,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false,
                ),
            ),
            modifier = Modifier
                .background(
                    color = Cyan,
                ),
        )
    }
}

// https://stackoverflow.com/questions/72112222/jetpack-compose-bottom-sheet-is-getting-collapsed-with-swipe-inside-its-content?noredirect=1#comment127421647_72112222
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NonSwipeableBottomSheet() {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )
    val isCollapsed = bottomSheetScaffoldState.bottomSheetState.isCollapsed
    val coroutineScope = rememberCoroutineScope()
    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            Box(
                Modifier
                    .fillMaxWidth()
                    .defaultMinSize(
                        minHeight = 1.dp,
                    )
                    .height(200.dp)
            ) {
                Text(
                    text = "Hello from sheet",
                )
            }
        },
        sheetPeekHeight = if (isCollapsed) {
            200.dp
        } else {
            200.dp
        },
    ) {
        Button(
            onClick = {
                coroutineScope.launch {
                    if (isCollapsed) {
                        bottomSheetScaffoldState.bottomSheetState.expand()
                    } else {
                        bottomSheetScaffoldState.bottomSheetState.collapse()
                    }
                }
            },
        ) {
            Text(
                text = if (isCollapsed) {
                    "Expand Bottom Sheet"
                } else {
                    "Collapse Bottom Sheet"
                },
            )
        }
    }
}


// https://stackoverflow.com/questions/72099001/show-jetpack-compose-widget-only-after-its-fully-populated
@Composable
fun Parent(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Column(modifier) {
        content()
        Text("Press me")
    }
}

@Composable
fun LoadAfterComplete() {
    Parent {
        (1..3).forEach {
            Text("Foobar")
        }
    }
}


// https://stackoverflow.com/questions/72014895/how-do-i-make-topappbar-background-same-as-rest-of-the-activity-ui
@Composable
fun NavigationBar(
    onIconClicked: () -> Unit,
    text: String,
) {
    TopAppBar(
        title = {
            Text(
                text = text,
                color = Black,
                fontSize = 48.sp
            )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Close",

                modifier = Modifier.clickable(onClick = onIconClicked),
                tint = Black
            )
        },
        backgroundColor = Cyan,
        elevation = 0.dp,
        modifier = Modifier.fillMaxWidth(),
    )
}

@Composable
fun MainView() {
    Column(
        Modifier
            .background(Cyan)
            .padding(40.dp, 0.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(45.dp)
    ) {
        NavigationBar(
            onIconClicked = { /*TODO*/ },
            text = "settings",
        )
        Box(
            Modifier
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.align(Alignment.CenterStart),
                text = "current user",
                style = TextStyle(
                    colorResource(id = R.color.black),
                    fontSize = 32.sp
                )
            )
            ClickableText(
                modifier = Modifier.align(Alignment.CenterEnd),
                style = TextStyle(
                    colorResource(id = R.color.black),
                    fontSize = 32.sp,
                    textAlign = TextAlign.End,
                    fontWeight = FontWeight.Bold
                ),
                text = AnnotatedString("SIGN OUT"),
                onClick = {}
            )
        }
        var text by rememberSaveable { mutableStateOf("Text") }

        Column(
            Modifier
                .fillMaxWidth()
                .background(Cyan)
        ) {
            TextField(
                value = text,
                onValueChange = {
                    text = it
                },
                textStyle = TextStyle(
                    fontSize = 20.sp,
                ),
                modifier = Modifier.fillMaxWidth(),
                maxLines = 1,
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Black,
                    backgroundColor = Transparent,
                    focusedIndicatorColor = Transparent,
                    unfocusedIndicatorColor = Transparent,
                    disabledIndicatorColor = Transparent
                ),
            )
        }
    }
}


// https://stackoverflow.com/questions/71996179/why-padding-from-top-gets-different-length-value-based-on-elements-alignment
@Composable
fun AlignmentPaddingCheck() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Divider(
                thickness = 3.dp,
                color = Red
            )

            Divider(
                modifier = Modifier
                    .border(2.dp, color = Blue)
                    .padding(top = 200.dp)
                    .border(2.dp, color = Green),
                thickness = 3.dp,
                color = Black
            )
        }
    }
}

// https://stackoverflow.com/questions/71996007/type-mismatch-required-paddingvalues-%e2%86%92-unit-found-unit
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentPaddingTest() {
    /*Scaffold(
        content = {
            ProfileContent()
        },
    )*/
}

@Composable
fun ProfileContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 96.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Text(
            text = "Good day!",
            fontSize = 48.sp,
        )
    }
}

// https://stackoverflow.com/questions/71992095/lazycolumn-inside-lazycolumn
@Composable
fun DropdownExample() {
    LazyColumn {
//        items(1) {
//            Checkbox(checked = false /*checkedState.value*/,
//                onCheckedChange = {})
//            Text(text = "$domainResponse.domains[0].name")
//        }
//        LazyColumn {
//            items(domainResponse.domains[0].pwas) { pwas ->
//                Checkbox(checked = false /*checkedState.value*/,
//                    onCheckedChange = {})
//                Text(text = "$pwas")
//            }
//        }
    }
}


// https://stackoverflow.com/questions/71957948/how-to-center-the-middle-child-in-a-compose-row-and-make-it-responsive
@Composable
fun MiddleItemRowWrapper() {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        MiddleItemRow("Label")
        MiddleItemRow("Loooooong Label")
        MiddleItemRow("Very very long Text jknfbajsbdfijag Label")

    }
}

@Composable
fun MiddleItemRow(
    text: String,
) {
    CenterAlignedTopAppBar(
        navigationIcon = {
            Text(
                text = text,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier
                    .background(Red)
                    .padding(
                        all = 16.dp,
                    ),
            )
        },
        title = {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .background(Cyan)
                    .padding(
                        all = 8.dp,
                    ),
            ) {
                Text("Button")
            }
        },
        actions = {
            Icon(
                imageVector = Icons.Rounded.Settings,
                contentDescription = null,
                modifier = Modifier
                    .background(Green)
                    .padding(
                        all = 16.dp,
                    ),
            )
        }
    )

    /*Row(
        verticalAlignment = Alignment.CenterVertically,
        // horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 16.dp,
            )
            .background(LightGray),
    ) {
        Text(
            text = text,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier
                .background(Red)
                .weight(
                    weight = 1f,
                )
                .padding(
                    all = 16.dp,
                ),
        )
        Button(
            onClick = { *//*TODO*//* },
            modifier = Modifier
                .background(Cyan)
                //                .weight(
                //                    weight = 1f,
                //                    fill = false,
                //                )
                .padding(
                    all = 16.dp,
                ),
        ) {
            Text("Button")
        }
        Icon(
            imageVector = Icons.Rounded.Settings,
            contentDescription = null,
            modifier = Modifier
                .background(Green)
                //                .weight(
                //                    weight = 1f,
                //                    fill = false,
                //                )
                .padding(
                    all = 16.dp,
                ),
        )
    }*/
}


// https://stackoverflow.com/questions/71927791/android-jetpack-compose-how-to-make-text-utilize-complete-row-space-and-break-t
@Composable
fun TextWordBreak() {
    Text(
        text = "This is a very long adsbgjkfdsabgjkbasdjhjabsdfhvadshbgkjasdbgjkbadsjkgbkbjkbhjavsgd text.",
        softWrap = false,
        overflow = TextOverflow.Visible,
    )
}

// https://stackoverflow.com/questions/71870416/how-shift-request-focus-to-next-textfield-in-jetpack-compose
@Composable
fun OtpScreen() {
    val focusManager = LocalFocusManager.current
    val (digit1, setDigit1) = remember {
        mutableStateOf("")
    }
    val (digit2, setDigit2) = remember {
        mutableStateOf("")
    }
    val (digit3, setDigit3) = remember {
        mutableStateOf("")
    }
    val (digit4, setDigit4) = remember {
        mutableStateOf("")
    }
    LaunchedEffect(
        key1 = digit1,
    ) {
        if (digit1.isNotEmpty()) {
            focusManager.moveFocus(
                focusDirection = FocusDirection.Next,
            )
        }
    }
    LaunchedEffect(
        key1 = digit2,
    ) {
        if (digit2.isNotEmpty()) {
            focusManager.moveFocus(
                focusDirection = FocusDirection.Next,
            )
        }
    }
    LaunchedEffect(
        key1 = digit3,
    ) {
        if (digit3.isNotEmpty()) {
            focusManager.moveFocus(
                focusDirection = FocusDirection.Next,
            )
        }
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        OutlinedTextField(
            value = digit1,
            onValueChange = {
                setDigit1(it)
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Next,
            ),
            modifier = Modifier.width(64.dp),
        )
        OutlinedTextField(
            value = digit2,
            onValueChange = {
                setDigit2(it)
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Next,
            ),
            modifier = Modifier.width(64.dp),
        )
        OutlinedTextField(
            value = digit3,
            onValueChange = {
                setDigit3(it)
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Next,
            ),
            modifier = Modifier.width(64.dp),
        )
        OutlinedTextField(
            value = digit4,
            onValueChange = {
                setDigit4(it)
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Done,
            ),
            modifier = Modifier.width(64.dp),
        )
    }
}

// https://stackoverflow.com/questions/71870900/reserve-space-for-invisible-items-in-jetpack-compose/71871204#71871204
@Composable
fun SplashScreen() {
    var imageVisibility by remember {
        mutableStateOf(false)
    }

    var textVisibility by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(Unit) {
        delay(1000)
        imageVisibility = true
        delay(5000)
        textVisibility = true
        delay(5000)
        // navHostController.navigate("second")
    }
    val alpha: Float by animateFloatAsState(
        targetValue = if (textVisibility) {
            1f
        } else {
            0f
        },
        animationSpec = tween(
            durationMillis = 3000,
            easing = LinearEasing,
        ),
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            AnimatedVisibility(
                visible = imageVisibility,
                enter = fadeIn(
                    TweenSpec(
                        durationMillis = 3000
                    )
                )
            ) {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "News Splash Screen"
                )
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .alpha(
                        alpha = alpha,
                    ),
                text = "Read News Everyday",
                textAlign = TextAlign.Center
            )
        }
    }
}


// https://stackoverflow.com/questions/71741634/observeasstate-on-viewmodel-livedata-dont-trigger-recomposition-in-compose
@Composable
fun AuthScreen(
    viewModel: UserViewModel = hiltViewModel(),
) {
    // val numberState by viewModel.number.observeAsState(0)

    LaunchedEffect(
        key1 = Unit,
    ) {
        // viewModel.getNumber()
    }
    // Log.d("Composable numberState", numberState.toString())
}

class UserViewModel : ViewModel() {
    private val _number = MutableLiveData<Int>()
    val number: LiveData<Int> = _number

    fun getNumber() {
        _number.value = 2

        //THIS LOG SHOWS THAT VALUE HAS BEEN UPDATED
        Log.d("ViewModel number", _number.value.toString())
    }
}

@Composable
fun BoxCircleCip() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Black),
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(Green)
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SimpleTextField(
    navHostController: NavHostController,
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }
    var flag by remember {
        mutableStateOf(true)
    }
    val initialText = "Sample Text"
    var text by remember {
        mutableStateOf(
            value = TextFieldValue(
                text = "Sample Text",
                selection = TextRange(
                    start = initialText.length,
                    end = initialText.length,
                ),
            ),
        )
    }

    LaunchedEffect(
        key1 = flag,
    ) {
        if (flag) {
            focusRequester.requestFocus()
        }
    }

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 32.dp),
    ) {
        //        Switch(
        //            checked = flag,
        //            onCheckedChange = {
        //                flag = !flag
        //            },
        //        )
        if (flag) {
            OutlinedTextField(
                value = text,
                onValueChange = { value: TextFieldValue ->
                    text = value
                },
                singleLine = true,
                modifier = Modifier.focusRequester(focusRequester = focusRequester),
            )
            Button(
                onClick = {
                    focusManager.clearFocus()
                },
            ) {
                Text("Clear Focus")
            }
        }

        //        Button(
        //            onClick = {
        //                if (isKeyboardShown) {
        //                    keyboardController?.hide()
        //                    focusManager.clearFocus()
        //                } else {
        //                    keyboardController?.show()
        //                }
        //                isKeyboardShown = !isKeyboardShown
        //            },
        //        ) {
        //            Text(text = "Toggle")
        //        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun KeyboardCheckTextField() {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    var isKeyboardShown by remember {
        mutableStateOf(false)
    }
    val initialText = "Sample Text"
    var text by remember {
        mutableStateOf(
            value = TextFieldValue(
                text = "Sample Text",
                selection = TextRange(
                    start = initialText.length,
                    end = initialText.length,
                ),
            ),
        )
    }

    Column {
        OutlinedTextField(
            value = text,
            onValueChange = { value: TextFieldValue ->
                text = value
            },
            singleLine = true,
        )
        Text(text = "Is Keyboard Shown : $isKeyboardShown")
        Button(
            onClick = {
                if (isKeyboardShown) {
                    keyboardController?.hide()
                    focusManager.clearFocus()
                } else {
                    keyboardController?.show()
                }
                isKeyboardShown = !isKeyboardShown
            },
        ) {
            Text(text = "Toggle")
        }
    }
}

fun onBottomSheetDismiss() {
    Log.e("TAG", "Bottom sheet Dismissed")
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetDismissAction() {
    val coroutineScope: CoroutineScope = rememberCoroutineScope()
    val modalBottomSheetState: ModalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
    )

    ModalBottomSheetLayout(
        sheetState = modalBottomSheetState,
        sheetContent = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize(),
            ) {
                Text(
                    text = "Bottom Sheet Content",
                    modifier = Modifier.padding(all = 64.dp),
                )
            }
        },
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(),
        ) {
            TextButton(
                onClick = {
                    coroutineScope.launch {
                        if (!modalBottomSheetState.isAnimationRunning) {
                            if (modalBottomSheetState.isVisible) {
                                modalBottomSheetState.hide()
                            } else {
                                modalBottomSheetState.show()
                            }
                        }
                    }
                },
            ) {
                Text("Show Bottom Sheet")
            }
        }
    }
}

@Composable
fun AutoFocusedTextField() {
    val initialText = "Sample Text"
    var text by remember {
        mutableStateOf(
            value = TextFieldValue(
                text = "Sample Text",
                selection = TextRange(
                    start = initialText.length,
                    end = initialText.length,
                ),
            ),
        )
    }

    BasicTextField(
        value = text,
        onValueChange = { value: TextFieldValue ->
            text = value
        },
        modifier = Modifier,
        singleLine = true,
    )
}

// https://stackoverflow.com/questions/71151322/can-i-use-statearraylistt-or-statemutablelistof-for-observed-by-compose
@Composable
fun ComposeListExample() {
    var mutableList: MutableState<MutableList<String>> = remember {
        mutableStateOf(mutableListOf())
    }
    var mutableList1: MutableState<MutableList<String>> = remember {
        mutableStateOf(mutableListOf())
    }
    var arrayList: MutableState<ArrayList<String>> = remember {
        mutableStateOf(ArrayList())
    }
    var arrayList1: MutableState<ArrayList<String>> = remember {
        mutableStateOf(ArrayList())
    }
    var list: MutableState<List<String>> = remember {
        mutableStateOf(listOf())
    }
    var stateList = remember {
        mutableStateListOf<String>()
    }

    Column(
        Modifier.verticalScroll(state = rememberScrollState())
    ) {
        // ShowListItems("MutableList", mutableList.value)
        // ShowListItems("Working MutableList", mutableList1.value)
        // ShowListItems("ArrayList", arrayList.value)
        // ShowListItems("Working ArrayList", arrayList1.value)
        // ShowListItems("List", list.value)

        Button(
            onClick = {
                mutableList.value.add("")
                arrayList.value.add("")

                val newMutableList1 = mutableListOf<String>()
                mutableList1.value.forEach {
                    newMutableList1.add(it)
                }
                newMutableList1.add("")
                mutableList1.value = newMutableList1

                val newArrayList1 = arrayListOf<String>()
                arrayList1.value.forEach {
                    newArrayList1.add(it)
                }
                newArrayList1.add("")
                arrayList1.value = newArrayList1

                val newList = mutableListOf<String>()
                list.value.forEach {
                    newList.add(it)
                }
                newList.add("")
                list.value = newList
            },
        ) {
            Text(text = "Add")
        }
    }
}

@Composable
private fun ShowListItems(title: String, list: List<String>) {
    Text(title)
    Column {
        repeat(list.size) {
            Text("$title Item Added")
        }
    }
}


// https://stackoverflow.com/questions/71141501/cant-animate-fab-visible-in-m3-scaffold
@OptIn(
    ExperimentalAnimationApi::class,
    androidx.compose.material3.ExperimentalMaterial3Api::class
)
@Composable
fun FabHide() {
    var fabVisible by remember {
        mutableStateOf(true)
    }
    Scaffold(
        floatingActionButton = {
            AnimatedVisibility(
                visible = fabVisible,
                enter = scaleIn(),
                exit = scaleOut(),
            ) {
                FloatingActionButton(onClick = {}) {
                    Icon(Icons.Default.Star, contentDescription = null)
                }
            }
        }
    ) { padding ->
        Button(
            onClick = {
                fabVisible = !fabVisible
            },
        ) {
            Text("Click to toggle FAB")
        }
    }
}


// https://stackoverflow.com/questions/71126264/lazy-vertical-grid-workaround-in-compose#71126264
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VerticalGrid() {
    val list = listOf("Apple", "Google", "Amazon", "Meta")
    val state = rememberLazyListState()
    /*LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        state = state,
    ) {
        items(list) { item ->
            Text(item)
        }
    }*/
}


// https://stackoverflow.com/questions/71105292/how-to-communicate-with-server-in-a-jetpack-compose-app?noredirect=1#comment125727901_71105292
suspend fun getServerMessage(): String {
    delay(5000)
    return "Success"
}

class GreetingFromServerViewModel : ViewModel() {
    var text by mutableStateOf("waiting for message")

    init {
        getMessage()
    }

    private fun getMessage() {
        viewModelScope.launch(Dispatchers.IO) {
            text = getServerMessage()
        }
    }
}

@Composable
fun GreetingFromServer(
    viewmodel: GreetingFromServerViewModel = viewModel(),
) {
    Text(viewmodel.text)
}


// https://stackoverflow.com/questions/71043481/using-sans-serif-condensed-in-compose
@Composable
fun CustomFontText() {
    Text(
        text = "Hello Font !",
        fontFamily = FontFamily.SansSerif,
    )
}

// https://stackoverflow.com/questions/71033789/how-to-handle-one-shot-operations-in-jetpack-compose
@Composable
fun OneShotOperation(
    viewmodel: OneShotOperationViewModel = viewModel(),
) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        Log.e("TAG", "Before collector")
        viewmodel
            .toastMessage
            .collect { message ->
                Toast.makeText(
                    context,
                    message,
                    Toast.LENGTH_SHORT,
                ).show()
            }
        Log.e("TAG", "After collector")
    }

    Column {
        Button(
            onClick = {
                viewmodel.sendMessage("Sample Toast")
            },
        ) {
            Text(text = "Show Toast")
        }
    }
}

class OneShotOperationViewModel : ViewModel() {
    private val _toastMessage = MutableSharedFlow<String>()
    val toastMessage = _toastMessage.asSharedFlow()

    fun sendMessage(message: String) {
        viewModelScope.launch {
            _toastMessage.emit(message)
        }
    }
}

// https://stackoverflow.com/questions/70959795/lazycolumn-items-stay-in-same-position-after-some-items-removed/70959871?noredirect=1#comment125461701_70959871
/*
@ExperimentalMaterialApi
@Composable
fun Screen(
    viewModel: MyViewModel = MyViewModel(),
) {
    val livedata = viewModel.itemsLiveData.observeAsState()
    val stateList = remember { mutableStateListOf<String>() }

    stateList.addAll(livedata.value!!)
    SwipableLazyColumn(viewModel, stateList)
}

@ExperimentalMaterialApi
@Composable
fun SwipableLazyColumn(
    viewModel: MyViewModel,
    stateList: SnapshotStateList<String>,
) {
    LazyColumn {
        items(items = stateList) { item ->
            val dismissState = rememberDismissState()
            if (dismissState.isDismissed(DismissDirection.EndToStart) || dismissState.isDismissed(
                    DismissDirection.StartToEnd)
            ) {
                viewModel.swipeToDelete(item)
            }
            SwipeToDismiss(
                state = dismissState,
                directions = setOf(DismissDirection.StartToEnd, DismissDirection.EndToStart),
                dismissThresholds = {
                    FractionalThreshold(0.25f)
                },
                background = {},
                dismissContent = {
                    // MyData(item)
                }
            )
        }
    }
}

class MyViewModel internal constructor() : LifecycleObserver {

    private val itemsList = mutableListOf<String>()

    private val _itemsLiveData = MutableLiveData<List<String>>()
    val itemsLiveData: LiveData<List<String>> = _itemsLiveData

    init {
        loadItems()
    }

    private fun loadItems() {
        onItemsLoaded(it.data)
    }

    private fun onItemsLoaded(itemsList: List<String>) {
        itemsList.clear()
        // itemsList.addAll(notifications)

        _itemsLiveData.value = if (itemsList.isNotEmpty()) {
            itemsList
        } else {
            null
        }
    }

    fun swipeToDelete(item: String) {
        if (itemsList.size == 0) return
        // itemRepository.deletelItem(item)
        onItemDeleted(item)
    }

    private fun onItemDeleted(item: String) {
        itemsList.remove(item)
        _itemsLiveData.value = itemsList
    }
}
*/

// https://stackoverflow.com/questions/70907656/strange-behaviour-with-horizontalarrangement-using-jetpack-compose
@Composable
fun ToolContent_() {
    Column {
        SettingsSwitch_("launch something 1")
        SettingsSwitch_("launch launch launch launch again and again and again something 2")
        SettingsSwitch_("launch something 3")
    }
}

@Composable
fun SettingsSwitch_(
    subtitle: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Red)
            .padding(start = 16.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            subtitle,
            Modifier
                .background(Cyan)
                .padding(end = 16.dp) // .weight(1f)
        )
        Switch(checked = false, onCheckedChange = null, modifier = Modifier.background(Green))
    }
}

// https://stackoverflow.com/questions/70895403/how-do-i-center-all-items-in-a-weighted-row-column
@Composable
private fun CenterAlignInRow() {

    Row(
        modifier = Modifier
            .background(Cyan)
            .fillMaxWidth(),
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.ic_launcher_foreground,
            ),
            contentDescription = "",
            modifier = Modifier
                .background(Red)
                .aspectRatio(1f, true)
                .weight(1f),
        )
        Image(
            painter = painterResource(
                id = R.drawable.ic_launcher_foreground,
            ),
            contentDescription = "",
            modifier = Modifier
                .background(Green)
                .aspectRatio(1f, true)
                .weight(1f),
        )
        Image(
            painter = painterResource(
                id = R.drawable.ic_launcher_foreground,
            ),
            contentDescription = "",
            modifier = Modifier
                .background(Blue)
                .aspectRatio(1f, true)
                .weight(1f),
        )
    }
}

// https://stackoverflow.com/questions/70279307/how-to-clear-a-textfields-value-and-clear-the-focus-at-the-same-time
@Composable
private fun ResetAndClearTextField() {
    val (textFieldValue, setTextFieldValue) = remember {
        mutableStateOf(
            TextFieldValue("")
        )
    }
    val focusManager = LocalFocusManager.current

    Column {
        TextField(
            value = textFieldValue,
            onValueChange = setTextFieldValue
        )

        Button(onClick = {
            setTextFieldValue(TextFieldValue(""))
            focusManager.clearFocus()
        }) {
            Text("reset and clear")
        }
    }
}

@Composable
fun TextInBorder() {

}


// https://stackoverflow.com/questions/70015237/divider-is-not-showing-in-the-custom-jetpack-compose-textfield#70015237
@Composable
fun EditProfileScreen() {

    val disableButtonState = remember {
        mutableStateOf(false)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 24.dp, end = 24.dp, top = 32.5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            /*CountryCodeAndMobileNumber(
                countryCodeList = listOf("+98"),
                clientInfo,
                disableButtonState,
                viewModel
            )*/

            Spacer(modifier = Modifier.size(16.dp))

            InputTextField(
                modifier = Modifier.fillMaxWidth(),
                textFieldValue = TextFieldValue("sasasasas@gmail.com"),
                labelText = "Email Address",
                withBorderModifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        shape = MaterialTheme.shapes.small,
                        color = LightGray,
                    )
                    .padding(4.dp),
                textStyle = MaterialTheme.typography.caption,
                dividerColor = LightGray, // AppColor.neutralColor.SILVER_CHALICE,
                spacer = 8.dp,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            ) {

            }
        }
    }
}

@Composable
private fun CountryCodeAndMobileNumber(
    countryCodeList: List<String>,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {

        /*CountryCodeDropDown(
            list = countryCodeList,
            label = "Country",
            // dividerColor = AppColor.neutralColor.SILVER_CHALICE,
            enabled = false
        )*/
        Spacer(modifier = Modifier.size(4.dp))
        InputTextField(
            textFieldValue = TextFieldValue("111111"),
            labelText = "Mobile Number",
            withBorderModifier = Modifier
                .wrapContentWidth()
                .border(
                    width = 1.dp,
                    shape = MaterialTheme.shapes.small,
                    color = LightGray,
                    // shape = AppShapes.small,
                    // color = AppColor.brandColor.BLUE_DE_FRANCE
                )
                .padding(4.dp),
            enabled = false,
            textStyle = MaterialTheme.typography.caption,
            dividerColor = LightGray,
            // textStyle = AppFont.PoppinsTypography.caption,
            // dividerColor = AppColor.neutralColor.SILVER_CHALICE,
            spacer = 8.dp,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        ) {

        }
    }
}


@Composable
fun InputTextField(
    modifier: Modifier = Modifier,
    textFieldValue: TextFieldValue = TextFieldValue(""),
    labelText: String,
    withBorderModifier: Modifier = Modifier,
    enabled: Boolean = true,
    dividerColor: Color,
    dividerThickness: Dp = 0.5.dp,
    spacer: Dp,
    textStyle: TextStyle,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    isDropDown: Boolean = false,
    valueChange: (String) -> Unit,
) {
    var value by remember { mutableStateOf(textFieldValue) }
    //This is used if we want to use it in DropDown
    if (textFieldValue.text.isNotEmpty() && isDropDown)
        value = textFieldValue
    ///////////////////////////////////////////
    val dividerState = remember {
        mutableStateOf(true)
    }

    BasicTextField(
        value = value,
        onValueChange = {
            value = it
            valueChange.invoke(it.text)
        },
        modifier = Modifier
            .onFocusChanged {
                dividerState.value = !it.isFocused
            },
        decorationBox = { innerTextField ->

            val mainModifier = if (!dividerState.value) {
                withBorderModifier

            } else {
                modifier
            }

            BorderColumnState(
                mainModifier,
                labelText,
                textStyle,
                spacer,
                innerTextField,
                dividerState,
                dividerThickness,
                dividerColor
            )
        }, keyboardOptions = keyboardOptions, enabled = enabled
    )
}

@Composable
private fun BorderColumnState(
    modifier: Modifier,
    labelText: String,
    textStyle: TextStyle,
    spacer: Dp,
    innerTextField: @Composable () -> Unit,
    dividerState: MutableState<Boolean>,
    dividerThickness: Dp,
    dividerColor: Color,
) {
    Column(
        modifier = modifier.wrapContentHeight(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = labelText, style = textStyle)
        Spacer(modifier = Modifier.size(spacer))
        innerTextField()
        if (dividerState.value) {
            Spacer(
                modifier = modifier
                    .size(dividerThickness)
                    .background(dividerColor)
            )
        }
    }
}

// https://stackoverflow.com/questions/70015530/unable-to-focus-anything
@Composable
fun FocusableText() {
    val scope = rememberCoroutineScope()
    val focusRequester = remember { FocusRequester() }
    var color by remember { mutableStateOf(White) }

    LaunchedEffect(scope) {
        focusRequester.requestFocus()
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(color)
                .onFocusChanged {
                    color = if (it.hasFocus || it.isFocused) {
                        LightGray
                    } else {
                        White
                    }
                }
                .focusRequester(focusRequester)
                .focusable(),
        )
    }
}


// https://stackoverflow.com/questions/70009088/sliding-an-item-next-to-the-expanding-animation
@ExperimentalAnimationApi
@Composable
fun ExpandableSearchbar() {
    var text by remember {
        mutableStateOf("")
    }
    var isSearchEnabled by remember {
        mutableStateOf(false)
    }
    val slow = 700
    val fast = 300
    /*var width by remember {
        mutableStateOf(0)
    }
    val offset by animateOffsetAsState(
        if (isSearchEnabled) {
            Offset(width.toFloat(), 0F)
        } else {
            Offset(0F, 0F)
        }
    )*/
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFE2E2E2))
            .height(120.dp),
    ) {
        IconButton(
            onClick = {
                isSearchEnabled = !isSearchEnabled
            },
            // modifier = Modifier.offset(offset.x.dp, offset.y.dp)
        ) {
            Icon(Icons.Default.Search, "search")
        }

        AnimatedVisibility(
            visible = isSearchEnabled,
            enter = fadeIn(
                animationSpec = tween(durationMillis = fast)
            ) + expandHorizontally(
                expandFrom = Alignment.End,
                animationSpec = tween(
                    durationMillis = slow,
                    easing = FastOutLinearInEasing,
                )
            )
            /*
            expandHorizontally(
                expandFrom = Alignment.End,
                animationSpec = tween(
                    durationMillis = slow,
                    easing = FastOutLinearInEasing,
                )
            )
            slideInHorizontally(
                initialOffsetX = {
                    width = it
                    it / 2
                },
                animationSpec = tween(durationMillis = slow)
            )
            */,
            exit = fadeOut(
                animationSpec = tween(
                    durationMillis = slow,
                    easing = FastOutLinearInEasing,
                )
            ) + shrinkHorizontally(
                shrinkTowards = Alignment.End,
                animationSpec = tween(
                    durationMillis = slow,
                    easing = FastOutLinearInEasing,
                )
            )
        ) {
            TextField(
                modifier = Modifier.padding(end = 16.dp),
                shape = RoundedCornerShape(10.dp),
                value = text,
                onValueChange = {
                    text = it
                },
            )
        }
    }
}

// https://stackoverflow.com/questions/69941390/how-to-draw-a-border-around-multiline-text-in-compose
@Composable
fun TextBorder() {
    Column {
        Text(
            "Box around text",
            modifier = Modifier
                .padding(top = 8.dp)
                .border(width = 2.dp, color = Red)
                .background(Color.DarkGray)
        )
        Text(
            "Box around text with a very very very very longlonglonglongword",
            modifier = Modifier
                .padding(top = 8.dp)
                .border(width = 2.dp, color = Red)
                .background(Color.DarkGray)
        )
    }
}

// Not posted as a question
@Composable
fun PreventSwitchConsumingClick() {
    var checked by remember {
        mutableStateOf(true)
    }
    val onCheckedChange = {
        checked = !checked
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onCheckedChange()
            }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text("Switch with label")
        Switch(
            checked = checked,
            enabled = true,
            onCheckedChange = null,
        )
    }
}

// https://stackoverflow.com/questions/69946779/disabled-switch-consumes-click-events-in-jetpack-compose
@Composable
fun DisabledSwitch() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {}
            //            .pointerInput(Unit) {
            //                detectTapAndPressUnconsumed(
            //                    onTap = {
            //                        Log.e("Test", "tap")
            //                    },
            //                )
            //            }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text("Disabled Switch")
        Switch(
            checked = false,
            enabled = false,
            onCheckedChange = {},
        )
    }
}

val NoPressGesture: suspend PressGestureScope.(Offset) -> Unit = { }

class PressGestureScopeImpl(
    density: Density,
) : PressGestureScope, Density by density {
    private var isReleased = false
    private var isCanceled = false
    private val mutex = Mutex(locked = false)

    /**
     * Called when a gesture has been canceled.
     */
    fun cancel() {
        isCanceled = true
        mutex.unlock()
    }

    /**
     * Called when all pointers are up.
     */
    fun release() {
        isReleased = true
        mutex.unlock()
    }

    /**
     * Called when a new gesture has started.
     */
    fun reset() {
        mutex.tryLock() // If tryAwaitRelease wasn't called, this will be unlocked.
        isReleased = false
        isCanceled = false
    }

    override suspend fun awaitRelease() {
        if (!tryAwaitRelease()) {
            throw GestureCancellationException("The press gesture was canceled.")
        }
    }

    override suspend fun tryAwaitRelease(): Boolean {
        if (!isReleased && !isCanceled) {
            mutex.lock()
        }
        return isReleased
    }
}

suspend fun PointerInputScope.detectTapAndPressUnconsumed(
    onPress: suspend PressGestureScope.(Offset) -> Unit = NoPressGesture,
    onTap: ((Offset) -> Unit)? = null,
) {
    val pressScope = PressGestureScopeImpl(this)
    forEachGesture {
        coroutineScope {
            pressScope.reset()
            awaitPointerEventScope {

                val down =
                    awaitFirstDown(requireUnconsumed = false).also { it.consumeDownChange() }

                if (onPress !== NoPressGesture) {
                    launch { pressScope.onPress(down.position) }
                }

                val up = waitForUpOrCancellationInitial()
                if (up == null) {
                    pressScope.cancel() // tap-up was canceled
                } else {
                    pressScope.release()
                    onTap?.invoke(up.position)
                }
            }
        }
    }
}

suspend fun AwaitPointerEventScope.waitForUpOrCancellationInitial(): PointerInputChange? {
    while (true) {
        val event = awaitPointerEvent(PointerEventPass.Initial)
        if (event.changes.fastAll { it.changedToUp() }) {
            // All pointers are up
            return event.changes[0]
        }

        if (event.changes.fastAny { it.consumed.downChange || it.isOutOfBounds(size) }) {
            return null // Canceled
        }

        // Check for cancel by position consumption. We can look on the Final pass of the
        // existing pointer event because it comes after the Main pass we checked above.
        val consumeCheck = awaitPointerEvent(PointerEventPass.Final)
        if (consumeCheck.changes.fastAny { it.positionChangeConsumed() }) {
            return null
        }
    }
}

// https://stackoverflow.com/questions/69941628/disabled-but-clickable-switch-in-jetpack-compose
@Composable
fun DisabledClickableSwitch(
    paidUser: Boolean = true,
) {
    var checked by remember {
        mutableStateOf(false)
    }
    val onCheckedChange = {
        if (paidUser) {
            checked = !checked
        } else {
            // Navigate to the require screen to show info about the paid feature here
            Log.e("Test", "Navigate from here")
        }
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onCheckedChange()
            }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text("Enable Paid Feature")
        Switch(
            checked = checked,
            enabled = paidUser,
            onCheckedChange = null,
        )
    }
}

// https://stackoverflow.com/questions/69932411/correct-way-to-handle-mutable-state-of-list-of-data-in-jetpack-compose
@Composable
fun ListState() {
    Log.e("TAG", "Recomposition")
    var list by rememberSaveable {
        mutableStateOf(mutableListOf<Int>())
    }
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            items(list) {
                Text(
                    text = "Test",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                )
            }
        }
        Button(
            onClick = {
                list.add(0)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text(text = "Add")
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
                    .clickable {
                        Log.e("Test", "Clicked $index")
                    }
                //                    .pointerInput("key", pressedItem) {
                //                        detectTapGestures(
                //                            onPress = {
                //                                Log.e("Test", "onPress")
                //                                Log.e("Test", "pressedItem: $pressedItem")
                //                                if (pressedItem == -1) {
                //                                    setPressedItem(index)
                //                                    Log.e("Test", "index: $index")
                //                                }
                //                            },
                //                            onTap = {
                //                                Log.e("Test", "onTap")
                //                                Log.e("Test", "pressedItem: $pressedItem")
                //                                Log.e("Test", "index: $index")
                //                                if (pressedItem == index) {
                //                                    // Click handler
                //                                    Log.e("Test", "Clicked item: $index")
                //
                //                                    setPressedItem(-1)
                //                                }
                //                            },
                //                            onDoubleTap = {
                //                                Log.e("Test", "onDoubleTap")
                //                                Log.e("Test", "pressedItem: $pressedItem")
                //                            },
                //                            onLongPress = {
                //                                Log.e("Test", "onLongPress")
                //                                Log.e("Test", "pressedItem: $pressedItem")
                //                            },
                //                        )
                //                    }
            ) {
                //                Text(
                //                    text = "$pressedItem",
                //                    textAlign = TextAlign.Center,
                //                    modifier = Modifier.fillMaxWidth(),
                //                )
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
                        text = "??? 0",
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
            .background(Red),
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
            .background(Red),
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
            Text(
                text = if (enabledStateFlow) {
                    "Enabled"
                } else {
                    "Disabled"
                }
            )
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
            Text(
                text = if (enabledState) {
                    "Enabled"
                } else {
                    "Disabled"
                }
            )
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
            Text(
                text = if (enabled) {
                    "Enabled"
                } else {
                    "Disabled"
                }
            )
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

@OptIn(ExperimentalMaterial3Api::class)
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
                        Red,
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
                .background(Red),
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
                .background(Red)
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
                    Text(
                        "Title",
                        Modifier
                            .background(Color.Blue)
                            .fillMaxWidth()
                    )
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
