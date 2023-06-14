package com.makeappssimple.abhimanyu.stackoverflowanswers.android

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatTextView
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.gestures.GestureCancellationException
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.PressGestureScope
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.forEachGesture
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.AlertDialog
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.IconButton
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.SwipeableState
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowDownward
import androidx.compose.material.icons.rounded.ArrowUpward
import androidx.compose.material.icons.rounded.ChevronRight
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material.swipeable
import androidx.compose.material3.ElevatedCard
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
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathOperation
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.vector.ImageVector
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
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.input.pointer.positionChangeConsumed
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalTextToolbar
import androidx.compose.ui.platform.TextToolbar
import androidx.compose.ui.platform.TextToolbarStatus
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.fastAll
import androidx.compose.ui.util.fastAny
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.zIndex
import androidx.core.graphics.PathParser
import androidx.core.text.isDigitsOnly
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
import androidx.navigation.navDeepLink
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.google.android.material.button.MaterialButton
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.clickable.ClickableSample
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.focusrequester.FocusRequesterDemo
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.fontpadding.FontPadding
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.lazycolomnprogress.LazyColumnProgress
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.row.RowAlignmentDemo
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.topshadow.TopShadowDemo
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.ui.theme.StackOverflowAnswersTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin
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
            DefaultAppView()
        }
        // startActivity(Intent(this, BottomSheetActivity::class.java))
    }

    //    override fun dispatchTouchEvent(motionEvent: MotionEvent?): Boolean {
    //        return motionEvent?.pointerCount == 1 && super.dispatchTouchEvent(motionEvent)
    //    }
}

@Composable
fun DefaultAppView() {
    StackOverflowAnswersTheme() {
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
        startDestination = "home",
    ) {
        composable(
            route = "home",
        ) {
            Home(
                navHostController = navHostController,
            )
        }
        composable(
            route = "settings",
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = "stackoverflow://answers/settings"
                },
            ),
        ) {
            Settings(
                navHostController = navHostController,
            )
        }
    }
}

@Composable
fun Settings(
    navHostController: NavController,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(Red)
            .fillMaxSize(),
    ) {
        Button(
            onClick = {
                navHostController.navigateUp()
            },
        ) {
            Text("Back To Home")
        }
    }
}

@Composable
fun Home(
    navHostController: NavController,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(Color(0xFFF5F4FA))
            .fillMaxSize(),
    ) {
        TestApp()
    }
}

// https://stackoverflow.com/questions/74081535/compose-negative-offset-is-not-affecting-its-actual-size-measurement
@Composable
fun OffsetInColumn() {
    Column {
        Box() {
            Box(
                modifier = Modifier
                    .background(Red)
                    .size(200.dp),
            )
            Box(
                modifier = Modifier
                    // .offset(y = -100.dp)
                    .background(Cyan)
                    .size(200.dp),
            )
        }
        Box(
            modifier = Modifier
                .background(Blue)
                .size(200.dp),
        )
    }
}

fun customAndroidPath(): android.graphics.Path? {
    val pathString =
        "M 60,60 L 60,0 L 50,10 L 60,0 L 70,10"
    return PathParser.createPathFromPathData(pathString)
}

// https://stackoverflow.com/questions/74001641/how-to-draw-custom-shaped-surface-in-jetpack-compose
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomShapeSurface() {
    ElevatedCard(
        modifier = Modifier
            .clip(FolderShape())
            .background(Gray)
            .fillMaxWidth()
            .height(260.dp),
    ) {
        Text("Heading")
        Text("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.")
    }
}

class FolderShape() : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density,
    ): Outline {
        val path: android.graphics.Path = customAndroidPath() ?: android.graphics.Path()

        return Outline.Generic(
            path = path.asComposePath()
        )
    }
}

// https://stackoverflow.com/questions/74000870/compose-fillmaxsize-not-working-after-using-modifier-verticalscroll
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColumnScrollCheck() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            "Editor picks".uppercase(),
            modifier = Modifier.padding(8.dp),
        )

        ElevatedCard(
            modifier = Modifier
                .clickable {}
                .fillMaxSize()
        ) {
            Column {
                AsyncImage(
                    model = "https://images.pexels.com/photos/20787/pexels-photo.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Text(
            "Editor picks".uppercase(),
            modifier = Modifier.padding(8.dp),
        )

        ElevatedCard(
            modifier = Modifier
                .clickable {}
                .fillMaxSize()
        ) {
            Column {
                AsyncImage(
                    model = "https://images.pexels.com/photos/20787/pexels-photo.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Text(
            "Editor picks".uppercase(),
            modifier = Modifier.padding(8.dp),
        )

        ElevatedCard(
            modifier = Modifier
                .clickable {}
                .fillMaxSize()
        ) {
            Column {
                AsyncImage(
                    model = "https://images.pexels.com/photos/20787/pexels-photo.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Text(
            "Editor picks".uppercase(),
            modifier = Modifier.padding(8.dp),
        )

        ElevatedCard(
            modifier = Modifier
                .clickable {}
                .fillMaxSize()
        ) {
            Column {
                AsyncImage(
                    model = "https://images.pexels.com/photos/20787/pexels-photo.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Text(
            "Editor picks".uppercase(),
            modifier = Modifier.padding(8.dp),
        )

        ElevatedCard(
            modifier = Modifier
                .clickable {}
                .fillMaxSize()
        ) {
            Column {
                AsyncImage(
                    model = "https://images.pexels.com/photos/20787/pexels-photo.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun ImageBackground() {
    Image(
        painter = painterResource(
            id = R.drawable.ic_launcher_foreground,
        ),
        contentDescription = null,
        modifier = Modifier
            .height(160.dp)
            .width(160.dp)
            .paint(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentScale = ContentScale.FillWidth
            )
            .padding(4.dp),
    )
}

@Composable
fun AutoSpacedTextSample() {
    val (text, setText) = remember {
        mutableStateOf("")
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AutoSpacedText(
            text = text,
            modifier = Modifier
                .background(LightGray)
                .padding(16.dp),
        )
        TextField(
            value = text,
            onValueChange = setText,
            modifier = Modifier
                .padding(16.dp),
        )
    }
}

inline operator fun TextUnit.plus(other: TextUnit): TextUnit {
    return (this.value + other.value).sp
}

inline operator fun TextUnit.minus(other: TextUnit): TextUnit {
    return (this.value - other.value).sp
}

@Composable
fun AutoSpacedText(
    text: String,
    modifier: Modifier = Modifier,
    minimumLetterSpacing: Int = 2,
    maximumLetterSpacing: Int = 200,
    letterSpacingStep: Int = 2,
) {
    Log.e("Recomposed", "AutoSpacedText: $text")
    var letterSpacingCalculated by remember(text) {
        mutableStateOf(false)
    }
    var letterSpacing: TextUnit by remember(text) {
        mutableStateOf(minimumLetterSpacing.sp)
    }
    Text(
        text = text,
        modifier = modifier
            .requiredWidth(260.dp)
            .drawWithContent {
                if (letterSpacingCalculated) {
                    drawContent()
                }
            },
        letterSpacing = letterSpacing,
        textAlign = TextAlign.Center,
        overflow = TextOverflow.Visible,
        maxLines = 1,
        onTextLayout = {
            if (!letterSpacingCalculated) {
                if (letterSpacing.value.roundToInt() < maximumLetterSpacing && !it.hasVisualOverflow) {
                    letterSpacing += letterSpacingStep.sp
                } else {
                    letterSpacingCalculated = true
                    letterSpacing -= letterSpacingStep.sp
                }
            }
        },
    )
}

@Composable
fun LazyListPaddingSample() {
    LazyListContentPaddingSample()
}

@Composable
fun LazyListItemPaddingSample() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        items(16) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(
                        horizontal = 8.dp,
                        vertical = 4.dp,
                    )
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFFC99DD3)),
            )
        }
    }
}

@Composable
fun LazyListColumnPaddingSample() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        items(16) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(
                        horizontal = 8.dp,
                        vertical = 4.dp,
                    )
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFFC99DD3)),
            )
        }
    }
}

@Composable
fun LazyListContentPaddingSample() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            top = 16.dp,
            bottom = 16.dp,
        ),
    ) {
        items(16) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(
                        horizontal = 8.dp,
                        vertical = 4.dp,
                    )
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFFC99DD3)),
            )
        }
    }
}

@Composable
fun ExpandableListSample() {
    ExpandableList(
        expandableListItems = (1..5).map {
            ExpandableListItemData(
                title = "Title ${it + 1}",
                subTitle = "Sub Title ${it + 1}",
            )
        },
    )
}

@Composable
fun ExpandableList(
    expandableListItems: List<ExpandableListItemData>,
) {
    val expandedItemsIndices: SnapshotStateList<Boolean> = remember {
        mutableStateListOf(
            elements = List(5) { false }.toTypedArray(),
        )
    }

    LazyColumn {
        itemsIndexed(expandableListItems) { index: Int, item: ExpandableListItemData ->
            ExpandableListItem(
                expanded = expandedItemsIndices[index],
                title = item.title,
                subTitle = item.subTitle,
                onClick = {
                    expandedItemsIndices[index] = !expandedItemsIndices[index]
                },
            )
        }
    }
}

data class ExpandableListItemData(
    val title: String,
    val subTitle: String,
)

@Composable
fun ExpandableListItem(
    expanded: Boolean,
    title: String,
    subTitle: String,
    onClick: () -> Unit,
) {
    val chevronDegrees: Float by animateFloatAsState(
        targetValue = if (expanded) {
            90F
        } else {
            0F
        },
        animationSpec = tween(
            durationMillis = 3000,
        ),
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 3000,
                ),
            ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            IconButton(
                onClick = {
                    onClick()
                },
            ) {
                Icon(
                    imageVector = Icons.Rounded.ChevronRight,
                    contentDescription = null,
                    modifier = Modifier
                        .rotate(
                            degrees = chevronDegrees,
                        ),
                )
            }
            Text(
                text = title,
                modifier = Modifier
                    .padding(16.dp),
            )
        }
        if (expanded) {
            Text(
                text = subTitle,
                modifier = Modifier
                    .padding(
                        start = 64.dp,
                        end = 16.dp,
                    ),
            )
        }
    }
}

@Composable
fun RotatedText() {
    val density = LocalDensity.current
    val interactionSource: MutableInteractionSource = remember {
        MutableInteractionSource()
    }
    var isPressed by remember {
        mutableStateOf(false)
    }
    val currentIsPressed by rememberUpdatedState(isPressed)
    var degree by remember {
        mutableStateOf(0F)
    }

    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaction ->
            when (interaction) {
                is PressInteraction.Press -> {
                    isPressed = true
                }

                is PressInteraction.Release -> {
                    isPressed = false
                }
            }
        }
    }
    LaunchedEffect(
        key1 = currentIsPressed,
    ) {
        while (currentIsPressed) {
            degree = (degree + 1) % 360
            delay(30)
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(Blue),
                )
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(Red),
                )
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(Blue),
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(Black),
                )
                BoxWithConstraints {
                    Box(
                        modifier = Modifier
                            .height(60.dp)
                            .width(120.dp)
                            .customRotate(
                                width = density.run { maxWidth.toPx() },
                                height = density.run { maxHeight.toPx() },
                                degrees = degree,
                            )
                            .drawWithContent {

                            }
                            // .vertical()
                            // .rotate(degree)
                            .background(Cyan),
                    )
                }
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(Black),
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(Blue),
                )
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(Red),
                )
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(Blue),
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
        ) {
            IconButton(
                onClick = {
                    degree = (degree - 1) % 360
                },
            ) {
                Icon(
                    imageVector = Icons.Rounded.ArrowDownward,
                    contentDescription = null,
                )
            }
            Text(
                text = "Degree: $degree",
                modifier = Modifier.padding(24.dp),
            )
            IconButton(
                interactionSource = interactionSource,
                onClick = {
                    degree = (degree + 1) % 360
                },
            ) {
                Icon(
                    imageVector = Icons.Rounded.ArrowUpward,
                    contentDescription = null,
                )
            }
        }
    }
}

fun Modifier.customRotate(
    width: Float,
    height: Float,
    degrees: Float,
): Modifier {
    val radian = Math.toRadians(degrees.toDouble())
//    val layout: Modifier = layout { measurable, constraints ->
//        val width =
//            (constraints.minHeight * abs(sin(radian)) + constraints.minWidth * abs(cos(radian))).roundToInt()
//        val height =
//            (constraints.minWidth * abs(sin(radian)) + constraints.minHeight * abs(cos(radian))).roundToInt()
//        constraints.copy(
//            minWidth = width,
//            maxWidth = width,
//            minHeight = height,
//            maxHeight = height,
//        )
//        val placeable = measurable.measure(constraints)
//
//
//        Log.e("Rotate", "width: $width")
//        Log.e("Rotate", "height: $height")
//        Log.e("Rotate", "x: 0")
//        Log.e("Rotate", "y: ${(placeable.width * abs(sin(radian))).roundToInt()}")
//        layout(width, height) {
//            placeable.place(
//                x = 0, // -(placeable.width / 2 - placeable.height / 2),
//                y = (placeable.width * abs(sin(radian))).roundToInt(), // -(placeable.height / 2 - placeable.width / 2)
//            )
//        }
//    }

    val newWidth = (height * abs(sin(radian)) + width * abs(cos(radian))).roundToInt()
    val newHeight = (width * abs(sin(radian)) + height * abs(cos(radian))).roundToInt()

    return this
        .rotate(degrees)
        .graphicsLayer {
            rotationZ = degrees
            // scaleX = newWidth / width
            // scaleY = newHeight / height
        }
}

fun Modifier.vertical() =
    layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)
        layout(placeable.width, placeable.height) {
            placeable.place(
                x = 0, //-(placeable.width / 2 - placeable.height / 2),
                y = 0, // -(placeable.height / 2 - placeable.width / 2)
            )
        }
    }

@Composable
fun TextFieldWithoutCursor() {
    val (text, setText) = remember {
        mutableStateOf("")
    }

    val customTextSelectionColors = TextSelectionColors(
        handleColor = Transparent,
        backgroundColor = Transparent,
    )
    CompositionLocalProvider(
        LocalTextToolbar provides EmptyTextToolbar,
        LocalTextSelectionColors provides customTextSelectionColors,
    ) {
        BasicTextField(
            value = text,
            onValueChange = {
                if (text.isEmpty()) {
                    setText(it)
                }
            },
            singleLine = true,
            cursorBrush = SolidColor(Transparent),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Done,
            ),
            textStyle = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier
                .requiredWidth(80.dp)
                .padding(16.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(Color(0xFFEBE0F0))
                .padding(12.dp),
        )
    }
}

// Debounce click events
// Number Picker carousel
// Emoji Picker

// New question code comes here

// https://stackoverflow.com/questions/73599809/how-can-i-control-the-direction-of-animatedvisibility-in-compose
@Composable
fun SlideAnimationDirection() {
    var isVisible by remember {
        mutableStateOf(false)
    }
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
    ) {
        AnimatedVisibility(
            visible = isVisible,
            enter = slideInVertically(
                initialOffsetY = {
                    it / 2
                },
            ),
            exit = slideOutVertically(
                targetOffsetY = {
                    it / 2
                },
            ),
        ) {
            Text(
                text = "Sample",
                modifier = Modifier.padding(128.dp),
            )
        }
        androidx.compose.material3.Button(
            onClick = {
                isVisible = !isVisible
            },
        ) {
            Text("Swap")
        }
    }
}

// https://stackoverflow.com/questions/73550593/jetpack-compose-cursor-in-the-end-of-a-textfield
@Composable
fun AutCursorEndTextField() {
    var text: TextFieldValue by remember {
        mutableStateOf(
            value = TextFieldValue(),
        )
    }

    OutlinedTextField(
        value = text,
        onValueChange = { value: TextFieldValue ->
            text = TextFieldValue(
                text = value.text,
                selection = TextRange(
                    index = value.text.length - 1,
                ),
            )
        },
        modifier = Modifier.padding(16.dp),
    )
}

// https://stackoverflow.com/questions/73526330/how-to-put-the-label-of-android-compose-textfield-to-the-same-horizontal-axis-as
@Composable
fun LabelTextField() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Text(
            text = "Label",
            modifier = Modifier
                .padding(
                    horizontal = 16.dp,
                ),
        )
        TextField(
            value = "Text",
            onValueChange = {},
            modifier = Modifier
                .weight(1F),
        )
    }
}

@Composable
fun CodeA() {
    var temp = remember {
        1
    }
    val refresh = remember {
        mutableStateOf(100)
    }
    Log.e("Test", "temp reset")
    Log.e("Test", "Load $temp ${refresh.value}")
    Button(
        onClick = {
            temp++
            refresh.value++

            Log.e("Test", "Save $temp ${refresh.value}")
        }
    ) {
        Text("OK $temp ${refresh.value}")
    }
}

@Composable
fun CustomTabSample() {
    val (selected, setSelected) = remember {
        mutableStateOf(0)
    }

    CustomTab(
        items = listOf("MUSIC", "PODCAST"),
        selectedItemIndex = selected,
        onClick = setSelected,
    )
}

@Composable
fun CustomTab(
    selectedItemIndex: Int,
    items: List<String>,
    modifier: Modifier = Modifier,
    tabWidth: Dp = 100.dp,
    onClick: (index: Int) -> Unit,
) {
    val indicatorOffset: Dp by animateDpAsState(
        targetValue = tabWidth * selectedItemIndex,
        animationSpec = tween(easing = LinearEasing),
    )

    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(Color.White)
            .height(intrinsicSize = IntrinsicSize.Min),
    ) {
        MyTabIndicator(
            indicatorWidth = tabWidth,
            indicatorOffset = indicatorOffset,
            indicatorColor = androidx.compose.material3.MaterialTheme.colorScheme.primary,
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.clip(CircleShape),
        ) {
            items.mapIndexed { index, text ->
                val isSelected = index == selectedItemIndex
                MyTabItem(
                    isSelected = isSelected,
                    onClick = {
                        onClick(index)
                    },
                    tabWidth = tabWidth,
                    text = text,
                )
            }
        }
    }
}

@Composable
private fun MyTabItem(
    isSelected: Boolean,
    onClick: () -> Unit,
    tabWidth: Dp,
    text: String,
) {
    val tabTextColor: Color by animateColorAsState(
        targetValue = if (isSelected) {
            White
        } else {
            Black
        },
        animationSpec = tween(easing = LinearEasing),
    )
    Text(
        modifier = Modifier
            .clip(CircleShape)
            .clickable {
                onClick()
            }
            .width(tabWidth)
            .padding(
                vertical = 8.dp,
                horizontal = 12.dp,
            ),
        text = text,
        color = tabTextColor,
        textAlign = TextAlign.Center,
    )
}

@Composable
private fun MyTabIndicator(
    indicatorWidth: Dp,
    indicatorOffset: Dp,
    indicatorColor: Color,
) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width(
                width = indicatorWidth,
            )
            .offset(
                x = indicatorOffset,
            )
            .clip(
                shape = CircleShape,
            )
            .background(
                color = indicatorColor,
            ),
    )
}

@Composable
fun MyTabRowSample() {
    val (selected, setSelected) = remember {
        mutableStateOf(0)
    }
    MyTabRow(
        items = listOf("MUSIC", "PODCAST"),
        selectedItemIndex = selected,
        onClick = setSelected,
    )
}

@Composable
fun MyTabRow(
    selectedItemIndex: Int,
    items: List<String>,
    modifier: Modifier = Modifier,
    onClick: (index: Int) -> Unit,
) {
    val density = LocalDensity.current
    val tabWidths = remember {
        mutableStateListOf<Dp>()
    }
    val indicatorWidth: Dp by animateDpAsState(
        targetValue = tabWidths.getOrElse(selectedItemIndex) { 32.dp },
        animationSpec = tween(easing = LinearEasing),
    )
    val indicatorOffset: Dp by animateDpAsState(
        targetValue = tabWidths.take(selectedItemIndex).fold(0.dp) { accumulator, result ->
            accumulator + result
        },
        animationSpec = tween(easing = LinearEasing),
    )

    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(Color.White)
            .height(intrinsicSize = IntrinsicSize.Min),
    ) {
        MyTabIndicator(
            indicatorWidth = indicatorWidth,
            indicatorOffset = indicatorOffset,
            indicatorColor = androidx.compose.material3.MaterialTheme.colorScheme.primary,
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.clip(CircleShape),
        ) {
            items.mapIndexed { index, text ->
                val isSelected = index == selectedItemIndex
                val tabTextColor: Color by animateColorAsState(
                    targetValue = if (isSelected) {
                        Color.White
                    } else {
                        Color.Black
                    },
                    animationSpec = tween(easing = LinearEasing),
                )
                Text(
                    modifier = Modifier
                        .onGloballyPositioned {
                            tabWidths.add(index, density.run { it.size.width.toDp() })
                        }
                        .clip(CircleShape)
                        .clickable {
                            onClick(index)
                        }
                        .padding(
                            vertical = 8.dp,
                            horizontal = 12.dp,
                        ),
                    text = text,
                    color = tabTextColor,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Composable
fun SimpleCustomTextFieldDemo() {
    val (text, setText) = remember { mutableStateOf("") }
    SimpleCustomTextField(
        text = text,
        setText = setText,
        label = {
            Text(
                text = "Label",
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    )
}

@Composable
fun SimpleCustomTextField(
    text: String,
    setText: (text: String) -> Unit,
    modifier: Modifier = Modifier,
    label: @Composable (() -> Unit)? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(),
    shape: Shape = RoundedCornerShape(12.dp),
) {
    val color: State<Color> = colors.indicatorColor(
        enabled = true,
        isError = false,
        interactionSource = interactionSource,
    )

    Box(
        contentAlignment = Alignment.BottomStart,
        modifier = modifier
            .fillMaxWidth()
            .clip(shape)
            .background(White),
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = setText,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Transparent,
                disabledBorderColor = Transparent,
                errorBorderColor = Transparent,
                unfocusedBorderColor = Transparent,
            ),
            label = label,
            interactionSource = interactionSource,
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape)
                .border(
                    width = 1.dp,
                    color = color.value,
                    shape = shape,
                ),
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    label: String = "Label",
    enabled: Boolean = true,
    singleLine: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    isError: Boolean = false,
    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(),
    shape: Shape = RoundedCornerShape(12.dp),
) {
    val (text, setText) = remember { mutableStateOf("") }
    val color: State<Color> = colors.indicatorColor(
        enabled = enabled,
        isError = isError,
        interactionSource = interactionSource,
    )

    Box(
        contentAlignment = Alignment.BottomStart,
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(shape)
            .background(White),
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = setText,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Transparent,
                disabledBorderColor = Transparent,
                errorBorderColor = Transparent,
                unfocusedBorderColor = Transparent,
            ),
            label = {
                Text(
                    text = label,
                )
            },
            interactionSource = interactionSource,
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape)
                .border(
                    width = 1.dp,
                    color = color.value,
                    shape = shape,
                ),
        )

//        BasicTextField(
//            value = text,
//            onValueChange = setText,
//            interactionSource = interactionSource,
//            textStyle = TextStyle.Default,
//            enabled = enabled,
//            singleLine = singleLine,
//            modifier = Modifier
//                .fillMaxWidth()
//                .clip(shape),
//        ) {
//            TextFieldDefaults.OutlinedTextFieldDecorationBox(
//                value = text,
//                innerTextField = it,
//                enabled = enabled,
//                visualTransformation = VisualTransformation.None,
//                interactionSource = interactionSource,
//                contentPadding = TextFieldDefaults.textFieldWithoutLabelPadding(
//                    start = 24.dp,
//                    end = 24.dp,
//                    top = 8.dp,
//                    bottom = 16.dp,
//                ),
//                singleLine = singleLine,
//                label = {
//                    Text(
//                        text = label,
//                    )
//                },
//                colors = colors,
//                border = {
//                    TextFieldDefaults.BorderBox(
//                        enabled = enabled,
//                        isError = isError,
//                        interactionSource = interactionSource,
//                        colors = colors,
//                        shape = shape,
//                    )
//                }
//            )
//        }
    }
}

@Composable
fun MyTabSample() {
    MyCustomRow(
        items = listOf("Option 1 with long", "Option 2 with", "Option 3"),
    )
}

@Composable
fun MyCustomRow(
    modifier: Modifier = Modifier,
    items: List<String>,
) {
    val childrenWidths = remember {
        mutableStateListOf<Int>()
    }
    Box(
        modifier = modifier
            .background(Color.LightGray)
            .height(IntrinsicSize.Min),
    ) {
        // To add more box here
        Box(
            modifier = Modifier
                .widthIn(
                    min = 64.dp,
                )
                .fillMaxHeight()
                .width(childrenWidths.getOrNull(0)?.dp ?: 64.dp)
                .background(
                    color = DarkGray,
                ),
        )
        Row(
            horizontalArrangement = Arrangement.Center,
        ) {
            items.mapIndexed { index, text ->
                Text(
                    modifier = Modifier
                        .widthIn(min = 64.dp)
                        .padding(
                            vertical = 8.dp,
                            horizontal = 12.dp,
                        )
                        .onGloballyPositioned {
                            childrenWidths.add(index, it.size.width)
                        },
                    text = text,
                    color = Black,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Composable
fun BlendModeSample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEEFAFD)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        BlendBox(
            modifier = Modifier,
        )
    }
}

@Composable
fun BlendBox(
    modifier: Modifier = Modifier,
) {
    Canvas(
        modifier = modifier
            .size(
                width = 200.dp,
                height = 200.dp,
            ),
    ) {
        drawRoundRect(
            color = Color(0xFF0075D9),
            topLeft = Offset(
                40.dp.toPx(),
                40.dp.toPx(),
            ),
            size = Size(
                width = 80.dp.toPx(),
                height = 80.dp.toPx(),
            ),
            cornerRadius = CornerRadius(
                x = 16.dp.toPx(),
                y = 16.dp.toPx(),
            ),
            // blendMode = BlendMode.Clear,
        )
        drawRoundRect(
            color = Color(0xFF4CAF50),
            topLeft = Offset(
                80.dp.toPx(),
                80.dp.toPx(),
            ),
            size = Size(
                width = 80.dp.toPx(),
                height = 80.dp.toPx(),
            ),
            cornerRadius = CornerRadius(
                x = 16.dp.toPx(),
                y = 16.dp.toPx(),
            ),
            blendMode = BlendMode.Src,
        )
    }
}

// https://stackoverflow.com/questions/73510220/android-jetpack-fit-image-as-custom-style-in-card
@Composable
fun TestScreen1() {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                LazyRow(
                    Modifier.height(160.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    item {
                        PromotionItem1(
                            imagePainter = painterResource(id = R.drawable.statue_of_liberty),
                            title = "AMERICA",
                            header = "USA",
                            backgroundColor = Color.White
                        )
                    }
                    item {
                        PromotionItem1(
                            imagePainter = painterResource(id = R.drawable.statue_of_liberty),
                            title = "AMERICA",
                            header = "USA",
                            backgroundColor = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun PromotionItem1(
    title: String = "",
    header: String = "",
    backgroundColor: Color = Color.Transparent,
    imagePainter: Painter,
) {
    Card(
        Modifier.width(300.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = backgroundColor,
        elevation = 0.dp
    ) {
        Row(
            horizontalArrangement = Arrangement.End,
        ) {
//            Image(
//                painter = imagePainter, contentDescription = "",
//                modifier = Modifier
//                    .fillMaxHeight()
//                    .weight(1f),
//                alignment = Alignment.CenterEnd,
//                contentScale = ContentScale.Crop
//            )
            Column(
                Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                Text(text = header, fontSize = 14.sp, color = Color.Black)
            }
        }
    }
}

// Emoji View
@Composable
fun EmojiViewSample() {
    EmojiView("🧑‍🌾")
}

@Composable
fun EmojiView(
    emoji: String,
) {
    AndroidView(
        factory = { context ->
            AppCompatTextView(context).apply {
                setTextColor(Black.toArgb())
                text = emoji ?: "😟"
                textSize = 48.0F
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }
        },
        update = {
            it.apply {
                text = emoji ?: "😟"
            }
        },
    )
}


// https://stackoverflow.com/questions/73462737/classifier-context-does-not-have-a-companion-object-and-thus-must-be-initiali
@Composable
fun AppNotice() {
    val intent = Intent(Intent.ACTION_GET_CONTENT)
    intent.type = "*/*";
    intent.addCategory(Intent.CATEGORY_OPENABLE);
    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
            if (activityResult.resultCode == RESULT_OK) {
                Log.d("appDebug", "oky")
                var uri = intent.getData()
                // val name: String? = uri?.getOriginalFileName(Context)
                // Log.d("seeFile", "$name")
            } else {
                Log.d("appDebug", "Denied")
            }
        }
}

// https://stackoverflow.com/questions/73461963/onvaluechange-of-textfield-is-not-triggered-when-selecting-an-option-from-expose
@Composable
fun PlantExposedSelectSample() {
    val options = listOf("Option 1", "Option 2", "Option 3", "Option 4")
    val (optionSelected, setOptionSelected) = remember {
        mutableStateOf("")
    }
    PlantExposedSelect(
        options = options,
        optionSelected = optionSelected,
        label = "Label",
        onOptionSelected = {
            Log.e("eventValue", it)
            setOptionSelected(it)
            // viewModel.onEvent(AddEditPlantEvent.EnteredLight(it))
        },
        onFocusChange = {
            // viewModel.onEvent(AddEditPlantEvent.ChangedLightFocus(it))
        },
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PlantExposedSelect(
    options: List<String>,
    optionSelected: String,
    label: String,
    onOptionSelected: (String) -> Unit,
    onFocusChange: (FocusState) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }

    ) {
        TextField(
            readOnly = true,
            value = optionSelected,
            onValueChange = onOptionSelected,
            label = {
                Text(label)
            },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged {
                    onFocusChange(it)
                },
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            options.forEach { selectOption ->
                DropdownMenuItem(
                    onClick = {
                        onOptionSelected(selectOption)
                        expanded = false
                        Log.e("selectEdoption", selectOption)
                    }
                ) {
                    Text(text = selectOption)
                }
            }
        }
    }
}

// region Smiley Rating bar
@Composable
fun SmileyRatingBarSample() {
    /*
    Outrage - https://cdn-icons-png.flaticon.com/512/742/742791.png
    Sad - https://cdn-icons-png.flaticon.com/512/742/742761.png
    Sad - https://cdn-icons-png.flaticon.com/512/742/742752.png
    Sad - https://cdn-icons-png.flaticon.com/512/742/742908.png
    Angry - https://cdn-icons-png.flaticon.com/512/742/742905.png
     */
    val data: List<SmileyData> = listOf(
        SmileyData("https://cdn-icons-png.flaticon.com/512/742/742905.png", "Terrible"),
        SmileyData("https://cdn-icons-png.flaticon.com/512/742/742761.png", "Bad"),
        SmileyData("https://cdn-icons-png.flaticon.com/512/742/742774.png", "Okay"),
        SmileyData("https://cdn-icons-png.flaticon.com/512/742/742940.png", "Good"),
        SmileyData("https://cdn-icons-png.flaticon.com/512/742/742869.png", "Awesome"),
    )

    val (rating, setRating) = remember {
        mutableStateOf(data.size / 2)
    }

    SmileyRatingBar(
        data = data,
        rating = rating,
        setRating = setRating,
    )
}

data class SmileyData(
    val url: String,
    val label: String,
)

@Composable
fun SmileyRatingBar(
    data: List<SmileyData>,
    rating: Int,
    setRating: (rating: Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    BoxWithConstraints(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
    ) {
        val gap = (maxWidth / data.size) - 44.dp
        val offset: Dp by animateDpAsState(
            targetValue = (gap / 2) + (gap + 44.dp) * rating,
            animationSpec = tween(
                durationMillis = 300,
                delayMillis = 400,
                easing = LinearEasing,
            ),
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 24.dp,
                    start = 44.dp,
                    end = 44.dp,
                ),
            thickness = 4.dp,
        )
        ColorDivider(
            modifier = Modifier
                .padding(
                    top = 24.dp,
                )
                .offset(
                    x = offset,
                    y = 0.dp,
                ),
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
            modifier = modifier
                .height(80.dp)
                .fillMaxWidth(),
        ) {
            data.mapIndexed { index, smileyData ->
                Smiley(
                    smileyData = smileyData,
                    isSelected = index == rating,
                    index = index,
                    count = data.size,
                    modifier = Modifier.weight(1F),
                    onClick = {
                        setRating(index)
                    },
                )
            }
        }
    }
}

@Composable
fun ColorDivider(
    modifier: Modifier = Modifier,
) {
    Divider(
        color = Transparent,
        thickness = 4.dp,
        modifier = modifier
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        LightGray,
                        Color(0xFFFFD93B),
                        LightGray,
                    )
                )
            )
            .width(44.dp),
    )
}

@Composable
fun Smiley(
    smileyData: SmileyData,
    isSelected: Boolean,
    index: Int,
    count: Int,
    modifier: Modifier = Modifier,
    animationDurationInMillis: Int = 300,
    onClick: () -> Unit,
) {
    val delayMillis = if (isSelected) {
        animationDurationInMillis + 300
    } else {
        0
    }
    val padding: Dp by animateDpAsState(
        targetValue = if (isSelected) {
            0.dp
        } else {
            4.dp
        },
        animationSpec = tween(
            durationMillis = animationDurationInMillis,
            delayMillis = delayMillis,
            easing = LinearEasing,
        ),
    )
    val size: Dp by animateDpAsState(
        targetValue = if (isSelected) {
            52.dp
        } else {
            44.dp
        },
        animationSpec = tween(
            durationMillis = animationDurationInMillis,
            delayMillis = delayMillis,
            easing = LinearEasing,
        ),
    )
    val saturation: Float by animateFloatAsState(
        targetValue = if (isSelected) {
            1F
        } else {
            0F
        },
        animationSpec = tween(
            durationMillis = animationDurationInMillis,
            delayMillis = delayMillis,
            easing = LinearEasing,
        ),
    )
    val matrix = ColorMatrix().apply {
        setToSaturation(saturation)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth(),
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(smileyData.url)
                .crossfade(true)
                .build(),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(
                    top = padding,
                )
                .size(size)
                .clip(CircleShape)
                .clickable {
                    onClick()
                },
            colorFilter = ColorFilter.colorMatrix(matrix)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = smileyData.label,
            color = if (isSelected) {
                if (index < (count / 2)) {
                    Color.Red
                } else if (index > (count / 2)) {
                    Color(0xFF275A27)
                } else {
                    Color.Black
                }
            } else {
                Color.DarkGray
            },
            fontWeight = if (isSelected) {
                FontWeight.Bold
            } else {
                FontWeight.Normal
            },
        )
    }
}
// endregion

// https://stackoverflow.com/questions/73443804/how-can-one-composibles-clicks-pass-through-to-a-composible-underneath
@Composable
fun PassClicks() {
    Box {
        Box(
            Modifier
                .size(200.dp)
                .background(Color.Blue)
                .clickable { Log.d("Abhi", "I want to receive the clicks from the red box") }
        ) {}
        Box(
            Modifier
                .size(200.dp)
                .offset(x = 20.dp)
                .alpha(0.2F)
                .background(Color.Red)
                .clickable(
                    enabled = false,
                    onClick = { Log.d("Abhi", "I want my clicks to pass through to the blue box") },
                )
        ) {}
    }
}

// https://stackoverflow.com/questions/73443718/how-to-assign-value-in-setter-of-mutablestateof-in-kotlin
@Composable
fun TextFieldValueSet() {
    val answer: String? = null

    val textFieldValue by remember {
        mutableStateOf(TextFieldValue(answer ?: ""))
    }

    OutlinedTextField(
        value = textFieldValue,
        onValueChange = {},
        modifier = Modifier
            .fillMaxWidth(),
    )
}

// region Swipe Button
@Composable
fun SwipeButtonSample() {
    val coroutineScope = rememberCoroutineScope()
    val (isComplete, setIsComplete) = remember {
        mutableStateOf(false)
    }

    SwipeButton(
        text = "SAVE",
        isComplete = isComplete,
        onSwipe = {
            coroutineScope.launch {
                delay(2000)
                setIsComplete(true)
            }
        },
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SwipeButton(
    text: String,
    isComplete: Boolean,
    doneImageVector: ImageVector = Icons.Rounded.Done,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color(0xFF03A9F4),
    onSwipe: () -> Unit,
) {
    val width = 200.dp
    val widthInPx = with(LocalDensity.current) {
        width.toPx()
    }
    val anchors = mapOf(
        0F to 0,
        widthInPx to 1,
    )
    val swipeableState = rememberSwipeableState(0)
    val (swipeComplete, setSwipeComplete) = remember {
        mutableStateOf(false)
    }
    val alpha: Float by animateFloatAsState(
        targetValue = if (swipeComplete) {
            0F
        } else {
            1F
        },
        animationSpec = tween(
            durationMillis = 300,
            easing = LinearEasing,
        )
    )

    LaunchedEffect(
        key1 = swipeableState.currentValue,
    ) {
        if (swipeableState.currentValue == 1) {
            setSwipeComplete(true)
            onSwipe()
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .padding(
                horizontal = 48.dp,
                vertical = 16.dp,
            )
            .clip(CircleShape)
            .background(backgroundColor)
            .animateContentSize()
            .then(
                if (swipeComplete) {
                    Modifier.width(64.dp)
                } else {
                    Modifier.fillMaxWidth()
                }
            )
            .requiredHeight(64.dp),
    ) {
        SwipeIndicator(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .alpha(alpha)
                .offset {
                    IntOffset(swipeableState.offset.value.roundToInt(), 0)
                }
                .swipeable(
                    state = swipeableState,
                    anchors = anchors,
                    thresholds = { _, _ ->
                        FractionalThreshold(0.3F)
                    },
                    orientation = Orientation.Horizontal,
                ),
            backgroundColor = backgroundColor,
        )
        SwipeText(text, alpha, swipeableState)
        SwipeProgressIndicator(swipeComplete, isComplete)
        AnimatedVisibility(
            visible = isComplete,
            enter = fadeIn(),
            exit = fadeOut(),
        ) {
            Icon(
                imageVector = doneImageVector,
                contentDescription = null,
                tint = White,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(44.dp),
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun SwipeText(
    text: String,
    alpha: Float,
    swipeableState: SwipeableState<Int>,
) {
    Text(
        text = text,
        color = White,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .alpha(alpha)
            .padding(
                horizontal = 80.dp,
            )
            .offset {
                IntOffset(swipeableState.offset.value.roundToInt(), 0)
            },
    )
}

@Composable
private fun SwipeProgressIndicator(
    swipeComplete: Boolean,
    isComplete: Boolean,
) {
    AnimatedVisibility(
        visible = swipeComplete && !isComplete,
    ) {
        CircularProgressIndicator(
            color = White,
            strokeWidth = 1.dp,
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
        )
    }
}

@Composable
fun SwipeIndicator(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxHeight()
            .padding(2.dp)
            .clip(CircleShape)
            .aspectRatio(
                ratio = 1.0F,
                matchHeightConstraintsFirst = true,
            )
            .background(Color.White),
    ) {
        Icon(
            imageVector = Icons.Rounded.ChevronRight,
            contentDescription = null,
            tint = backgroundColor,
            modifier = Modifier.size(36.dp),
        )
    }
}
// endregion

// region MEDIUM - Page Indicator
// https://stackoverflow.com/questions/73416996/jetpack-compose-animated-pager-dots-indicator
@Composable
fun PageIndicatorSample() {
    val numberOfPages = 3
    val (selectedPage, setSelectedPage) = remember {
        mutableStateOf(0)
    }

    // NEVER use this, this is just for example
    LaunchedEffect(
        key1 = selectedPage,
    ) {
        delay(3000)
        setSelectedPage((selectedPage + 1) % numberOfPages)
    }

    PageIndicator(
        numberOfPages = numberOfPages,
        selectedPage = selectedPage,
        defaultRadius = 60.dp,
        selectedLength = 120.dp,
        space = 30.dp,
        animationDurationInMillis = 1000,
    )
}

@Composable
fun PageIndicator(
    numberOfPages: Int,
    modifier: Modifier = Modifier,
    selectedPage: Int = 0,
    selectedColor: Color = Color(0xFF3E6383),
    defaultColor: Color = Color.LightGray,
    defaultRadius: Dp = 20.dp,
    selectedLength: Dp = 60.dp,
    space: Dp = 30.dp,
    animationDurationInMillis: Int = 300,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(space),
        modifier = modifier,
    ) {
        for (i in 0 until numberOfPages) {
            val isSelected = i == selectedPage
            PageIndicatorView(
                isSelected = isSelected,
                selectedColor = selectedColor,
                defaultColor = defaultColor,
                defaultRadius = defaultRadius,
                selectedLength = selectedLength,
                animationDurationInMillis = animationDurationInMillis,
            )
        }
    }
}

@Composable
fun PageIndicatorView(
    isSelected: Boolean,
    selectedColor: Color,
    defaultColor: Color,
    defaultRadius: Dp,
    selectedLength: Dp,
    animationDurationInMillis: Int,
    modifier: Modifier = Modifier,
) {
    val color: Color by animateColorAsState(
        targetValue = if (isSelected) {
            selectedColor
        } else {
            defaultColor
        },
        animationSpec = tween(
            durationMillis = animationDurationInMillis,
        )
    )
    val width: Dp by animateDpAsState(
        targetValue = if (isSelected) {
            selectedLength
        } else {
            defaultRadius
        },
        animationSpec = tween(
            durationMillis = animationDurationInMillis,
        )
    )

    Canvas(
        modifier = modifier
            .size(
                width = width,
                height = defaultRadius,
            ),
    ) {
        drawRoundRect(
            color = color,
            topLeft = Offset.Zero,
            size = Size(
                width = width.toPx(),
                height = defaultRadius.toPx(),
            ),
            cornerRadius = CornerRadius(
                x = defaultRadius.toPx(),
                y = defaultRadius.toPx(),
            ),
        )
    }
}
// endregion

// https://stackoverflow.com/questions/73425959/how-can-i-place-an-icon-on-the-right-of-screen-without-padding-in-jetpack-compos
@Composable
fun IconPadding() {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Hello", Modifier.weight(1f))
            Text("World")
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Hello", Modifier.weight(1f))
            Icon(
                imageVector = Icons.Filled.Edit,
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .clip(CircleShape)
                    .clickable(
                        onClick = {},
                    )
                    .indication(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = rememberRipple(),
                    ),
            )
        }
    }
}

// https://stackoverflow.com/questions/73425741/why-cant-the-height-property-of-modifier-be-written-in-jetpack-compose
@Composable
fun OrderOfModifiers() {
    val modifier = Modifier
        .fillMaxWidth()
        .height(30.dp)
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Spacer(
            modifier = modifier
                .height(5.dp)
                .background(DarkGray),
        )
        Spacer(
            modifier = Modifier
                .height(5.dp)
                .then(modifier)
                .background(Cyan),
        )
    }
}

@Composable
fun PathPercent() {
    Canvas(
        modifier = Modifier
            .size(300.dp, 300.dp)
            .background(Red),
    ) {
        val largePath = Path().apply {
            addRect(Rect(Offset.Zero, Size(300.dp.toPx(), 300.dp.toPx())))
        }
        val smallPath = Path().apply {
            addOval(Rect(Offset.Zero, Size(200.dp.toPx(), 200.dp.toPx())))
        }
        val pathToDraw = Path.combine(
            operation = PathOperation.Difference,
            path1 = largePath,
            path2 = smallPath,
        )
        drawPath(
            path = pathToDraw,
            color = Black,
            alpha = 1F,
        )
    }
}

// region MEDIUM - Scratch card
@Composable
fun ScratchCardSample() {
    val cardPath = Path().apply {
        addOval(
            oval = Rect(
                Offset.Zero,
                Size(
                    width = 350.0F,
                    height = 350.0F,
                )
            )
        )
    }
    ScratchCard(
        cardPath = cardPath,
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ScratchCard(
    cardPath: Path? = null,
    pointerWidth: Float = 40.0F,
    percentToClear: Float = 0.8F,
) {
    val cardSide: Dp = if (cardPath != null) {
        max(cardPath.getBounds().width.dp, cardPath.getBounds().height.dp)
    } else {
        250.dp
    }
    val scratchCardPath = if (cardPath != null) {
        cardPath
    } else {
        val defaultCardSideInPx = with(
            receiver = LocalDensity.current,
        ) {
            cardSide.toPx()
        }
        Path().apply {
            addRect(
                rect = Rect(
                    offset = Offset.Zero,
                    size = Size(
                        width = defaultCardSideInPx,
                        height = defaultCardSideInPx,
                    )
                ),
            )
        }
    }
    var scratchedPath: Path by remember {
        mutableStateOf(
            value = Path(),
        )
    }
    val pathToDraw = Path.combine(
        operation = PathOperation.Difference,
        path1 = scratchCardPath,
        path2 = scratchedPath,
    )
    val pointerModifier = Modifier
        .pointerInteropFilter { motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {
                    scratchedPath.addOval(
                        oval = Rect(
                            center = Offset(
                                x = motionEvent.x,
                                y = motionEvent.y,
                            ),
                            radius = pointerWidth,
                        ),
                    )
                    scratchedPath = Path().apply {
                        addPath(scratchedPath)
                    }
                    true
                }

                else -> false
            }
        }

    Canvas(
        modifier = Modifier
            .background(Red)
            .size(
                width = cardSide,
                height = cardSide,
            )
            .then(
                other = pointerModifier,
            ),
    ) {
        drawPath(
            path = pathToDraw,
            color = Black,
            alpha = 1F,
        )
    }
}
// endregion

// region Drawing Board
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DrawingBoard() {
    var pointerPosition: Offset? by remember {
        mutableStateOf(null)
    }
    var motionEvent: MotionEvent? by remember {
        mutableStateOf(null)
    }
    val scratchedPath: Path by remember {
        mutableStateOf(Path().apply {
        })
    }
    val cardSide = 250.dp
    val scratchWidth = 40.0F

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Text("Position X = ${pointerPosition?.x} Y = ${pointerPosition?.y}")
        Text("${scratchedPath.isConvex}")
        Text("${scratchedPath.isEmpty}")
        Canvas(
            modifier = Modifier
                .background(LightGray)
                .size(
                    width = cardSide,
                    height = cardSide,
                )
        ) {
            val scratchCardPath = Path().apply {
                addRect(Rect(Offset.Zero, Offset(cardSide.toPx(), cardSide.toPx())))
            }

            val pathToDraw = Path.combine(
                operation = PathOperation.Difference,
                path1 = scratchCardPath,
                path2 = scratchedPath,
            )
            drawPath(
                path = pathToDraw,
                color = Black,
                alpha = 1F,
            )
        }
        Canvas(
            modifier = Modifier
                .background(LightGray)
                .size(
                    width = cardSide,
                    height = cardSide,
                )
                .pointerInteropFilter {
                    when (it.action) {
                        MotionEvent.ACTION_DOWN -> {
                            pointerPosition = Offset(
                                x = it.x,
                                y = it.y,
                            )
                            motionEvent = it
                            scratchedPath.moveTo(it.x, it.y)
                            true
                        }

                        MotionEvent.ACTION_MOVE -> {
                            pointerPosition = Offset(
                                x = it.x,
                                y = it.y,
                            )
                            motionEvent = it
                            scratchedPath.addOval(
                                oval = Rect(
                                    center = Offset(
                                        x = it.x,
                                        y = it.y,
                                    ),
                                    radius = scratchWidth,
                                ),
                            )
                            true
                        }

                        else -> false
                    }
                },
        ) {
            val scratchCardPath = Path().apply {
                addRect(Rect(Offset.Zero, Offset(cardSide.toPx(), cardSide.toPx())))
            }

            motionEvent?.let {
                clipPath(scratchCardPath) {
                    drawPath(
                        path = scratchedPath,
                        color = Green,
                        alpha = 1F,
                    )
                }
            }
        }
    }
}
// endregion

@Composable
fun PathDiff() {
    Canvas(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        val rect1 = Path().apply {
            addRect(Rect(Offset.Zero, Offset(400.0F, 400.0F)))
        }
        val rect2 = Path().apply {
            moveTo(100.0F, 100.0F)
            lineTo(200.0F, 100.0F)
            lineTo(200.0F, 200.0F)
        }
        val newPath = Path.combine(
            operation = PathOperation.Difference,
            path1 = rect1,
            path2 = rect2,
        )
        drawPath(
            path = rect2,
            color = Black,
            alpha = 1F,
            style = Stroke(
                width = 20.0F,
                cap = StrokeCap.Round,
            ),
        )
    }
}

// https://stackoverflow.com/questions/73389254/jetpackcompose-modifier-fillmaxheight-doesnt-work-in-card
@Composable
fun List(
    modifier: Modifier = Modifier,
) {
    val testList = listOf("test1", "test2")

    LazyColumn(
        modifier = modifier,
    ) {
        items(
            items = testList
        ) { testText ->
            Card(
                elevation = 10.dp,
                modifier = modifier
                    .padding(
                        top = 30.dp,
                        start = 30.dp,
                        end = 30.dp,
                        bottom = 30.dp,
                    )
                    .border(
                        width = 0.8.dp,
                        color = Color.DarkGray,
                        shape = RectangleShape,
                    )
            ) {
                Row(
                    modifier = Modifier
                        .requiredHeight(200.dp),
                ) {
                    Text(
                        text = testText,
                        fontSize = 30.sp,
                        modifier =
                        Modifier
                            .padding(
                                horizontal = 15.dp,
                                vertical = 20.dp,
                            ),
                    )
                    Divider(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(0.5.dp), // <-  It doesn't work.
                        color = Color.Black,
                    )
                }
            }
        }
    }
}

@Composable
fun List1(
    modifier: Modifier = Modifier,
) {
    val testList = listOf("test1", "test2")

    LazyColumn(
        modifier = modifier,
    ) {
        items(
            items = testList
        ) { testText ->
            Card(
                elevation = 10.dp,
                modifier = modifier
                    .fillMaxSize() // It doesn't work.
                    .padding(
                        top = 30.dp,
                        start = 30.dp,
                        end = 30.dp,
                        bottom = 30.dp,
                    )
                    .border(
                        width = 0.8.dp,
                        color = Color.DarkGray,
                        shape = RectangleShape,
                    )
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .heightIn(100.dp),
                    // .background(Cyan),
                ) {
                    Text(
                        text = testText,
                        fontSize = 30.sp,
                        modifier =
                        Modifier
                            // .background(LightGray)
                            .padding(
                                horizontal = 15.dp,
                                vertical = 20.dp,
                            ),
                    )
                    Divider(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(0.5.dp), // <-  It doesn't work.
                        color = Color.Black,
                    )
                }
            }
        }
    }
}

@Composable
fun ScaledText() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(Cyan)
            .requiredSize(
                200.dp,
                200.dp,
            ),
    ) {
        Text(
            text = "Sample Text",
            fontSize = 48.sp,
            maxLines = 1,
            modifier = Modifier
                .scale(
                    200.0F,
                    200.0F
                ),
        )
    }
}

// https://stackoverflow.com/questions/73374838/i-want-to-ask-on-how-to-perform-this-using-an-onclick-event-in-jetpack-compose
@Composable
fun ClickSample() {
    val (count, setCount) = remember {
        mutableStateOf(0)
    }
    Button(
        onClick = {

        },
    ) {
        Text("Add")
    }
}

// https://stackoverflow.com/questions/73364342/jetpack-compose-canvas-clip-to-rounded-arc-shape
@Composable
fun CanvasWithArc() {
    Canvas(
        modifier = Modifier
            .background(Black)
            .fillMaxSize(),
    ) {
        val path = Path().apply {
            this.addArc(
                oval = Rect(
                    topLeft = Offset(
                        x = 0F,
                        y = 0F,
                    ),
                    bottomRight = Offset(
                        x = size.width,
                        y = size.height,
                    )
                ),
                startAngleDegrees = 0F,
                sweepAngleDegrees = 240F,
            )
        }
        clipPath(
            path = path,
        ) {
            // following two drawArc could be replaced w/ drawCircle
            drawArc(
                color = Color.Magenta.copy(alpha = 0.2F),
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(
                    width = 2.0F,
                    cap = StrokeCap.Round,
                ),
                size = Size(100.0F, 100.0F),
                topLeft = Offset.Zero
            )

            drawArc(
                color = Color.Cyan,
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(
                    width = 2.0F,
                    cap = StrokeCap.Round
                ),
                size = Size(100.0F, 100.0F),
                topLeft = Offset.Zero
            )
        }
    }
}

@Composable
fun CustomProgressbar() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Black),
    ) {
        CircularProgressIndicator()
    }
}

// https://stackoverflow.com/questions/69511201/animating-content-in-jetpack-compose
@Composable
fun AnimateColumnToRow() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Sample(AlignmentState.Rowed)
        Sample(AlignmentState.Column)
//        Row {
//            ColourBox(
//                color = Red,
//            )
//        }
    }
}

enum class AlignmentState {
    Rowed,
    Column,
}

@Composable
fun Sample(
    state: AlignmentState,
) {
    // Dimensions of the static/stable box
    val redWidth = 50
    val redHeight = 50

    // Animated Coordinates of the dynamic box
    val blueX by animateDpAsState(targetValue = (if (state == AlignmentState.Rowed) (redWidth * 1.25f).roundToInt() else 0).dp)
    val blueY by animateDpAsState(targetValue = (if (state == AlignmentState.Rowed) 0 else redHeight).dp)

    Layout(
        content = {
            Box(
                modifier = Modifier
                    .height(redWidth.dp)
                    .width(redHeight.dp)
                    .background(Color.Red)
            )
            Box(
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .background(Color.Red)
            )
        },
    ) { measurables, constraints ->
        val red = measurables[0].measure(constraints)
        val blue = measurables[1].measure(constraints)

        layout(
            width = constraints.maxWidth,
            height = constraints.maxHeight,
        ) {
            red.place(0, 0)
            blue.place(blueX.value.roundToInt(), blueY.value.roundToInt())
        }
    }
}

@Composable
private fun ColourBox(
    color: Color,
) {
    Box(
        modifier = Modifier
            .background(
                color
            )
            .size(
                width = 40.dp,
                height = 40.dp,
            ),
    )
}

// https://stackoverflow.com/questions/73352954/change-the-color-of-the-background-for-each-card-composable-in-a-lazy-list-jet
@Composable
fun ColourCards() {
    val colors = listOf(Color.Blue, Green, Color.Magenta, Color.Gray, Color.Cyan)
    LazyColumn {
        items(40) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 16.dp,
                        vertical = 4.dp,
                    )
                    .background(colors[it % colors.size])
                    .height(80.dp),
            )
        }
    }
}

// https://stackoverflow.com/questions/73352084/how-to-center-text-in-canvas-in-jetpack-compose/73352227#73352227
@OptIn(ExperimentalTextApi::class)
@Composable
fun MyCenterTextInCanvas() {
    val width: Dp = 200.dp
    val height: Dp = 40.dp
    val textMeasurer = rememberTextMeasurer()
    Canvas(
        modifier = Modifier
            .background(Color.LightGray)
            .wrapContentSize(
                align = Alignment.Center,
            )
            .requiredSize(
                width = width,
                height = height,
            ),
    ) {
        drawText(
            textMeasurer = textMeasurer,
            text = "Sample Text",
            topLeft = Offset(
                x = (width / 2).toPx(),
                y = (height / 2).toPx(),
            ),
        )
    }
}

// https://stackoverflow.com/questions/73310731/cannot-move-button-with-zindex-to-front-jetpack-compose
@Composable
fun ViewSelector() {
    val (selected, setSelected) = remember {
        mutableStateOf("Deals")
    }

    Row(
        modifier = Modifier
            .background(Color(0xFFEEEEEE))
            .width(252.dp)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        ViewSelectorButton(
            text = "Deals",
            isSelected = selected == "Deals",
            setSelected = setSelected,
        )
        ViewSelectorButton(
            text = "Rewards",
            isSelected = selected == "Rewards",
            setSelected = setSelected,
        )
    }
}

@Composable
fun ViewSelectorButton(
    text: String,
    isSelected: Boolean,
    setSelected: (selected: String) -> Unit,
) {
    Button(
        modifier = Modifier
            .zIndex(
                zIndex = if (isSelected) {
                    1f
                } else {
                    1f
                },
            )
            .width(110.dp)
            .clip(
                shape = RoundedCornerShape(8.dp),
            ),
        // .offset(x = (-15).dp),
        onClick = {
            setSelected(text)
        },
        elevation = ButtonDefaults.elevation(
            defaultElevation = if (isSelected) {
                4.dp
            } else {
                (-4).dp
            },
            pressedElevation = 0.dp,
        ),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (isSelected) {
                Color(0xFFDDC0C0)
            } else {
                Color(0xFF6DB5CC)
            },
        )
    ) {
        Text(
            text = text,
            color = Black,
        )
    }
}

// region MEDIUM ARTICLE - BottomSheetSelectionDemo
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetSelectionDemo() {
    val coroutineScope: CoroutineScope = rememberCoroutineScope()
    val modalBottomSheetState: ModalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
    )
    val colors = arrayListOf("Red", "Green", "Blue", "White", "Black")
    val (value, setValue) = remember {
        mutableStateOf(colors[0])
    }
    val toggleModalBottomSheetState = {
        coroutineScope.launch {
            if (modalBottomSheetState.currentValue == modalBottomSheetState.targetValue) {
                if (modalBottomSheetState.isVisible) {
                    modalBottomSheetState.hide()
                } else {
                    modalBottomSheetState.show()
                }
            }
        }
    }

    ModalBottomSheetLayout(
        sheetState = modalBottomSheetState,
        sheetContent = {
            LazyColumn {
                items(colors) {
                    Text(
                        text = it,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                setValue(it)
                                toggleModalBottomSheetState()
                            }
                            .padding(
                                horizontal = 16.dp,
                                vertical = 12.dp,
                            ),
                    )
                }
            }
        },
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(),
        ) {
            MyReadOnlyTextField(
                value = value,
                label = "Select a color",
                onClick = {
                    toggleModalBottomSheetState()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 16.dp,
                        vertical = 4.dp,
                    ),
            )
        }
    }
}

@Composable
fun MyReadOnlyTextField(
    modifier: Modifier = Modifier,
    value: String,
    label: String,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier,
    ) {
        androidx.compose.material3.OutlinedTextField(
            value = value,
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth(),
            label = {
                Text(
                    text = label,
                )
            },
        )
        Box(
            modifier = Modifier
                .matchParentSize()
                .alpha(0f)
                .clickable(
                    onClick = onClick,
                ),
        )
    }
}
// endregion

// https://stackoverflow.com/questions/73284087/how-to-show-pin-field-with-custom-drawables
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CustomTextFieldVisual1() {
    var text by remember { mutableStateOf("") }
    val interactionSource = remember { MutableInteractionSource() }
    val enabled = true
    val singleLine = true

    var isError by remember { mutableStateOf(false) }
    var circleColor by remember { mutableStateOf(Gray) }

    val colors = TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = circleColor,
        unfocusedBorderColor = circleColor
    )

    BasicTextField(
        value = text,
        onValueChange = {
            if (it.length <= 1) {
                text = it
                if (it.isDigitsOnly()) {
                    circleColor = Green
                    isError = false
                }
            }
            if (it.isEmpty()) isError = true
        },
        interactionSource = interactionSource,
        textStyle = TextStyle.Default.copy(textAlign = TextAlign.Center, fontSize = 16.sp),
        enabled = enabled,
        singleLine = singleLine,
        modifier = Modifier
            .width(50.dp)
            .height(50.dp)
    ) {
        TextFieldDefaults.OutlinedTextFieldDecorationBox(
            value = text,
            visualTransformation = VisualTransformation.None,
            innerTextField = it,
            singleLine = singleLine,
            enabled = enabled,
            interactionSource = interactionSource,
            contentPadding = TextFieldDefaults.textFieldWithoutLabelPadding(
                start = 0.dp, end = 0.dp, top = 0.dp, bottom = 0.dp
            ),
            colors = colors,
            border = {
                TextFieldDefaults.BorderBox(
                    enabled,
                    isError,
                    interactionSource,
                    colors,
                    shape = CircleShape,
                    focusedBorderThickness = 3.dp,
                    unfocusedBorderThickness = 3.dp
                )
            }
        )
    }
}

object EmptyTextToolbar : TextToolbar {
    override val status: TextToolbarStatus = TextToolbarStatus.Hidden

    override fun hide() {}

    override fun showMenu(
        rect: Rect,
        onCopyRequested: (() -> Unit)?,
        onPasteRequested: (() -> Unit)?,
        onCutRequested: (() -> Unit)?,
        onSelectAllRequested: (() -> Unit)?,
    ) {
    }
}

@Composable
fun CustomTextFieldVisual() {
    val focusManager = LocalFocusManager.current
    val (text, setText) = remember {
        mutableStateOf(TextFieldValue(""))
    }
    val charLimit = 6

    LaunchedEffect(
        key1 = text,
    ) {
        if (text.text.length == charLimit) {
            focusManager.clearFocus()
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .width(
                    200.dp,
                ),
        ) {
            val customTextSelectionColors = TextSelectionColors(
                handleColor = Transparent,
                backgroundColor = Transparent
            )

            CompositionLocalProvider(
                LocalTextToolbar provides EmptyTextToolbar,
                LocalTextSelectionColors provides customTextSelectionColors,
            ) {
                BasicTextField(
                    value = text,
                    onValueChange = { newValue ->
                        if (newValue.text.length <= 6) {
                            setText(
                                if (newValue.selection.length > 0) {
                                    newValue.copy(
                                        selection = text.selection,
                                    )
                                } else {
                                    newValue
                                }
                            )
                        }
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.NumberPassword,
                        imeAction = ImeAction.Done,
                    ),
//                    textStyle = TextStyle(
//                        color = Transparent,
//                    ),
                    // readOnly = true,
                    cursorBrush = SolidColor(Transparent),
                    modifier = Modifier
                        .clip(CircleShape)
                        .fillMaxWidth()
                        .background(Color(0xFFEEEEEE))
                        .padding(16.dp),
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .clip(CircleShape)
                    .fillMaxWidth()
                    .background(Color(0xFFEEEEEE))
                    .padding(16.dp),
            ) {
                for (i in 0 until charLimit) {
                    if (i < text.text.length) {
                        Dot(Green)
                    } else {
                        Dot(Red)
                    }
                }
            }
        }
        Text(
            text = "Entered Text : ${text.text}",
            modifier = Modifier
                .padding(
                    all = 16.dp,
                ),
        )
    }
}

@Composable
fun Dot(
    color: Color,
) {
    Box(
        modifier = Modifier
            .requiredSize(
                size = 16.dp,
            )
            .background(
                color = color,
                shape = CircleShape,
            ),
    )
}


// https://stackoverflow.com/questions/73280574/how-to-set-a-outlinedtextfield-occupy-the-remaining-space-jetpack-compose
/*
@Composable
fun SmallAppBar() {
    androidx.compose.material3.MaterialTheme {
        SmallTopAppBar(
            title = {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(1f) // Here is the issue.
                        .padding(2.dp),
                    value = "",
                    onValueChange = {},
                    maxLines = 1,
                    singleLine = true,
                )
            },
            navigationIcon = {
                IconButton(
                    onClick = {},
                ) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowBack,
                        contentDescription = null,
                    )
                }
            },
            actions = {
//            OutlinedTextField(
//                modifier = Modifier
//                    .fillMaxWidth(1f) // Here is the issue.
//                    .padding(2.dp),
//                value = "",
//                onValueChange = {},
//                maxLines = 1,
//                singleLine = true,
//            )
            }
        )
    }
}
*/

// https://stackoverflow.com/questions/73276689/vertical-scroll-affecting-the-modifier-weight-in-jetpack-compose
@Composable
fun ScrollModifier() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(10.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.Blue)
                .height(200.dp),
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.Red)
                .height(200.dp),
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.Cyan)
                .height(200.dp),
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Green)
                .height(200.dp),
        )
        Spacer(
            modifier = Modifier.weight(1.0F),
        )
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("Button")
        }
    }
}

// https://stackoverflow.com/questions/73276491/handle-back-button-click-when-keyboard-is-open-in-jetpack-compose
@Composable
fun BackHandlingWhenKeyboardOpen() {
    val focusManager = LocalFocusManager.current
    BackHandler(
        enabled = true,
    ) {
        // This is not triggered when keyboard is open
        Log.d("TEST_TAG", "Back Handler")
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
            ) {
                focusManager.clearFocus()
            }
    ) {
        TextField(
            value = "",
            onValueChange = {},
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                },
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Done,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        )
    }
}

// https://stackoverflow.com/questions/73268655/how-to-handle-error-on-outlined-edit-text-checking-regex-in-compose
@Composable
fun ErrorCheck() {
    val (text, setText) = remember {
        mutableStateOf("")
    }
    UserInputTextField(
        fieldState = text,
        onFieldChange = setText,
        label = "Email",
    )
}

@Composable
fun UserInputTextField(
    fieldState: String,
    onFieldChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
) {
    androidx.compose.material.OutlinedTextField(
        value = fieldState,
        onValueChange = {
            onFieldChange(it)
        },
        isError = fieldState.contains("@"),
        modifier = modifier
            .fillMaxWidth()
            .padding(
                all = 16.dp,
            ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Blue,
            unfocusedBorderColor = Color.Black,
        )
    )
}

// https://stackoverflow.com/questions/73269574/state-hosting-in-jetpack-compose
@Composable
fun PulsePressure() {
    var systolicTextFieldValue by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue())
    }
    var isSystolicTextFieldValueError by rememberSaveable { mutableStateOf(false) }
    var diastolicTextFieldValue by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue())
    }
    var (isDiastolicTextFieldValueError, updateIsDiastolicTextFieldValueError) = rememberSaveable {
        mutableStateOf(
            false
        )
    }
    InputWithUnitContainer(
        systolicTextFieldValue,
        isError = isSystolicTextFieldValueError,
        updateIsError = updateIsDiastolicTextFieldValueError,
        incrementTextFieldValue = {
            systolicTextFieldValue = it
        })
    InputWithUnitContainer(
        textFieldValue = diastolicTextFieldValue,
        isError = isDiastolicTextFieldValueError,
        updateIsError = updateIsDiastolicTextFieldValueError,
        incrementTextFieldValue = {
            diastolicTextFieldValue = it
        }
    )
}

@Composable
fun InputWithUnitContainer(
    textFieldValue: TextFieldValue,
    isError: Boolean,
    updateIsError: (Boolean) -> Unit,
    incrementTextFieldValue: (TextFieldValue) -> Unit,
) {
    val maxLength = 4
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = textFieldValue,
            singleLine = true,
            onValueChange = {
                if (it.text.length <= maxLength) {
                    incrementTextFieldValue(it)
                }
                updateIsError(false)
            },
            isError = isError,
            textStyle = TextStyle(),
        )
    }
}

// https://stackoverflow.com/questions/73250986/different-types-of-width-in-jetpack-compose
@Composable
fun WidthTypes() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        Box(
            modifier = Modifier
                .background(Red)
                .height(40.dp)
                .fillMaxWidth(0.9F),
        ) {
            Box(
                modifier = Modifier
                    .background(Blue)
                    .height(10.dp)
                    .width(80.dp),
            )
        }
        Box(
            modifier = Modifier
                .background(Red)
                .height(40.dp)
                .widthIn(min = 40.dp, max = 100.dp),
        ) {
            Box(
                modifier = Modifier
                    .background(Blue)
                    .height(10.dp)
                    .width(80.dp),
            )
        }
        Box(
            modifier = Modifier
                .background(Red)
                .height(40.dp)
                .requiredWidth(40.dp),
        ) {
            Box(
                modifier = Modifier
                    .background(Blue)
                    .height(10.dp)
                    .width(80.dp),
            )
        }
        Box(
            modifier = Modifier
                .background(Red)
                .height(40.dp)
                .widthIn(70.dp, 100.dp)
                .width(40.dp),
        ) {
            Box(
                modifier = Modifier
                    .background(Blue)
                    .height(10.dp)
                    .width(80.dp),
            )
        }
    }
}

// https://stackoverflow.com/questions/73248554/how-to-get-value-from-radio-group-in-jetpack-compose
@Composable
fun KindRadioGroupUsage() {
    val kinds = listOf("Option 1", "Option 2", "Option 3")
    val (selected, setSelected) = remember { mutableStateOf("") }
    Column {
        KindRadioGroup(
            mItems = kinds,
            selected, setSelected
        )
        Text(
            text = "Selected Option : $selected",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .requiredWidth(56.dp)
                .width(56.dp)
                .fillMaxWidth(),
        )
    }
}

@Composable
fun KindRadioGroup(
    mItems: List<String>,
    selected: String,
    setSelected: (selected: String) -> Unit,
) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            mItems.forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selected == item,
                        onClick = {
                            setSelected(item)
                        },
                        enabled = true,
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color.Magenta
                        )
                    )
                    Text(text = item, modifier = Modifier.padding(start = 8.dp))
                }
            }
        }
    }
}

// https://stackoverflow.com/questions/73175298/border-radius-is-not-changing-based-on-shape-when-user-click-on-it-jetpack-compo
@Composable
fun BorderRadiusView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        val options = arrayListOf("First", "Second", "Third")
        options.forEachIndexed { _, optionText ->
            val interactionSource = remember { MutableInteractionSource() }
            val isPressed by interactionSource.collectIsPressedAsState()
            val backgroundColor = if (isPressed) Red else Green
            val textColor = if (isPressed) Cyan else Black
            val borderWidth = if (isPressed) 1.dp else 0.dp
            val borderColor = if (isPressed) Black else White
            val clickable = Modifier.clickable(
                interactionSource = interactionSource,
                indication = rememberRipple(true)
            ) {
                println("Item Click")
            }
            val shape = RoundedCornerShape(16.dp)
            Surface(
                modifier = Modifier
                    .clip(shape)
                    .border(
                        width = borderWidth,
                        color = borderColor,
                        shape = shape,
                    )
                    .then(clickable),
                // shape = shape,
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(backgroundColor)
                        .padding(16.dp),
                    text = optionText,
                    // style = Typography.h3,
                    fontWeight = FontWeight.Medium,
                    color = textColor
                )
            }
        }
    }
}

// https://stackoverflow.com/questions/73089220/how-to-give-a-box-a-circleshaped-stroke
@Composable
fun CircleBox() {
    Row {
        Box(
            modifier = Modifier
                .size(32.dp)
                .border(
                    border = BorderStroke(2.dp, Color.Red),
                    shape = CircleShape,
                ),
        ) {

        }
        Box(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .border(
                    border = BorderStroke(2.dp, Color.Red),
                    shape = CircleShape,
                ),
        ) {

        }
    }
}

// https://issuetracker.google.com/issues/236018302
@OptIn(
    ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class
)
@Composable
fun AnimatedFab() {
    var visibility by remember {
        mutableStateOf(true)
    }
    Scaffold(
        floatingActionButton = {
            AnimatedVisibility(visible = visibility) {
                Box {
                    FloatingActionButton(
                        modifier = Modifier.animateEnterExit(
                            enter = slideInVertically(),
                            exit = slideOutVertically()
                        ),
                        onClick = { }) {
                        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
                    }
                }
            }
        }
    ) {
        Button(
            onClick = { visibility = !visibility },
        ) {
            Text(text = "Toggle")
        }
    }
}

// https://stackoverflow.com/questions/72958203/outlinedtextfields-text-color-does-not-change-when-disabled
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DisabledTextField() {
    val interactionSource = remember { MutableInteractionSource() }
    val colors = TextFieldDefaults.outlinedTextFieldColors()
    val text = "+56"
    BasicTextField(
        value = text,
        onValueChange = {},
        interactionSource = interactionSource,
        enabled = false,
        singleLine = true,
        textStyle = TextStyle.Default,
        modifier = Modifier
            .width(IntrinsicSize.Min)
            .layoutId("country_code"),
    ) {
        TextFieldDefaults.OutlinedTextFieldDecorationBox(
            value = "+56",
            enabled = false,
            singleLine = true,
            innerTextField = it,
            visualTransformation = VisualTransformation.None,
            interactionSource = interactionSource,
            colors = colors
        )
    }
}

// https://stackoverflow.com/questions/72816899/using-toggle-in-a-password-field-in-jetpack-compose
@Composable
fun TogglePassword() {
    val password = remember {
        mutableStateOf("")
    }
    var revealPassword: MutableState<Boolean> = remember {
        mutableStateOf(false)
    } // To reveal the password with toggle
    OutlinedTextField(
        value = password.value,
        onValueChange = { newText ->
            password.value = newText
        },
        visualTransformation = if (revealPassword.value) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        trailingIcon = {
            if (revealPassword.value) {
                IconButton(
                    onClick = {
                        revealPassword.value = false
                    },
                ) {
                    Icon(imageVector = Icons.Filled.Visibility, contentDescription = null)
                }
            } else {
                IconButton(
                    onClick = {
                        revealPassword.value = true
                    },
                ) {

                    Icon(imageVector = Icons.Filled.VisibilityOff, contentDescription = null)
                }
            }
        },
        label = {
            Text(text = "Password")
        },
        singleLine = true,
        leadingIcon = {
            Icon(imageVector = Icons.Default.Lock, contentDescription = null)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    )
}

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
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
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
            Spacer(
                modifier = Modifier
                    .background(White)
                    .width(screenWidth / 2)
            )
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
    Text(
        "This is a verrrryryryryreyeryeryeryerreyrfjdafbgkjabfdgbjabldfjbgjbakfdjbkgjbkadfbkgbbafdlbgboafdghbafdhlgalfdhgabdfgbfadhglfahgheyer long text".replace(
            " ",
            "\u00AD"
        )
    )
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
/*
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
*/

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
    Box(
        modifier = Modifier
            .background(Color(0xFFf4f4f4))
            .fillMaxSize()
            .padding(top = 20.dp)
    ) {
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
/*
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
                onClick = { *//*TODO*//* },
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

    *//*Row(
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
            onClick = { *//**//*TODO*//**//* },
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
    }*//*
}
*/

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
                        if (modalBottomSheetState.currentValue == modalBottomSheetState.targetValue) {
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

@Composable
fun Demo() {
    // Counter()
    // CounterWithState()
    // CounterWithStateWithRemember()

    CounterWithStateWithRememberDelegation()
    // CounterWithStateWithRememberSyntacticSugar()
    // CounterWithStateWithRememberSaveable()

    // CounterStateHoisting()

    // DoubleCounter()
}

// Counter
@Composable
fun Counter() {
    // DONT DO THIS
    var count = 0
    Log.e("Test", "Outside Column: $count")

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("$count")
        Button(
            onClick = {
                count++
                Log.e("Test", "After increment: $count")
            },
        ) {
            Text("Increment")
        }
    }
}

@Composable
fun CounterWithState() {
    // DONT DO THIS
    val count = mutableStateOf(0)
    Log.e("Test", "Outside Column: ${count.value}")

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("${count.value}")
        Button(
            onClick = {
                count.value++
                Log.e("Test", "After increment: ${count.value}")
            },
        ) {
            Text("Increment")
        }
    }
}

// Remember
@Composable
fun CounterWithStateWithRemember() {
    val count = remember {
        mutableStateOf(0)
    }
    Log.e("Test", "Outside Column: ${count.value}")

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("${count.value}")
        Button(
            onClick = {
                count.value++
                Log.e("Test", "After increment: ${count.value}")
            },
        ) {
            Text("Increment")
        }
    }
}

@Composable
fun CounterWithStateWithRememberDelegation(
    viewModel: CounterWithStateWithRememberDelegationViewModel = hiltViewModel(),
) {
//    val count by viewModel.count
//    var count by remember {
//        mutableStateOf(0)
//    }
    Log.e("Test", "Recomposed")

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
//        Text("${viewModel.count}")
        Button(
            onClick = {
                viewModel.increment()
            },
        ) {
            Text("Increment to ${viewModel.count}")
        }
    }
}


class CounterWithStateWithRememberDelegationViewModel : ViewModel() {
    var count by mutableStateOf(0)
        private set


//    private val _count = mutableStateOf(0)
//    val count: State<Int> = _count

    fun increment() {
        count++
//        _count.value++
    }
}

@Composable
fun CounterWithStateWithRememberSyntacticSugar() {
    val (count, setCount) = remember {
        mutableStateOf(0)
    }
    Log.e("Test", "Outside Column: $count")

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("$count")
        Button(
            onClick = {
                setCount(count + 1)
                Log.e("Test", "After increment: $count")
            },
        ) {
            Text("Increment")
        }
    }
}

@Composable
fun CounterWithStateWithRememberSaveable() {
    val (count, setCount) = rememberSaveable {
        mutableStateOf(0)
    }
    Log.e("Test", "Outside Column: $count")

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("$count")
        Button(
            onClick = {
                setCount(count + 1)
                Log.e("Test", "After increment: $count")
            },
        ) {
            Text("Increment")
        }
    }
}

// State Hoisting and stateless
// from CounterWithStateWithRemember
@Composable
fun CounterStateHoisting() {
    var count by remember {
        mutableStateOf(0)
    }
    Log.e("Test", "Outside Column: $count")

    CounterUI(
        count = count,
        setCount = {
            count = it
        },
    )
}

@Composable
fun CounterUI(
    count: Int, // state
    setCount: (updatedCount: Int) -> Unit, // event
) {
    Log.e("Test", "Outside CounterUI: $count")
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("$count")
        Button(
            onClick = {
                setCount(count + 1)
                Log.e("Test", "After increment: $count")
            },
        ) {
            Text("Increment")
        }
    }
}

// syntactic sugar issue
@Composable
fun DoubleCounter() {
    val (count1, setCount) = remember {
        mutableStateOf(0)
    }
    var count2 by remember {
        mutableStateOf(0)
    }
    Log.e("Test", "Outside Column: count 1: $count1")
    Log.e("Test", "Outside Column: count 2: $count2")

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("$count1")
        Button(
            onClick = {
                setCount(count1 + 1)
                Log.e("Test", "After increment: $count1")
                setCount(count1 + 1)
                Log.e("Test", "After increment: $count1")
            },
        ) {
            Text("Increment")
        }
        Text("$count2")
        Button(
            onClick = {
                count2++
                Log.e("Test", "After increment: $count2")
                count2++
                Log.e("Test", "After increment: $count2")
            },
        ) {
            Text("Increment")
        }
    }
}

// Restoring state
// https://developer.android.com/jetpack/compose/state#restore-ui-state

// State holders

@OptIn(ExperimentalMaterialApi::class)
fun openModalBottomSheetState(
    coroutineScope: CoroutineScope,
    modalBottomSheetState: ModalBottomSheetState,
) {
    coroutineScope.launch {
        modalBottomSheetState.show()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetFillCheck() {
    val coroutineScope = rememberCoroutineScope()
    val modalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true,
    )
    var count by remember {
        mutableStateOf(0)
    }
    val colors = listOf(
        Color.Red, Color.Green, Color.DarkGray, Color.Black, Color.Blue, Color.Cyan, Color.Gray,
        Color.Magenta, Color.LightGray, Color.Yellow, Color.Red, Color.Green,
    )

    ModalBottomSheetLayout(
        sheetState = modalBottomSheetState,
        sheetShape = RoundedCornerShape(
            topStart = 16.dp,
            topEnd = 16.dp,
        ),
        sheetContent = {
            LazyColumn(Modifier.fillMaxWidth()) {
                items((0 until count).toList()) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .background(colors[it]),
                    ) {}
                }
            }
        },
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize(),
        ) {
            Button(
                onClick = {
                    count = 2
                    openModalBottomSheetState(
                        coroutineScope = coroutineScope,
                        modalBottomSheetState = modalBottomSheetState,
                    )
                },
            ) {
                Text("Open Sheet with 2 items")
            }
            Button(
                onClick = {
                    count = 6
                    openModalBottomSheetState(
                        coroutineScope = coroutineScope,
                        modalBottomSheetState = modalBottomSheetState,
                    )
                },
            ) {
                Text("Open Sheet with 6 items")
            }
            Button(
                onClick = {
                    count = 12
                    openModalBottomSheetState(
                        coroutineScope = coroutineScope,
                        modalBottomSheetState = modalBottomSheetState,
                    )
                },
            ) {
                Text("Open Sheet with 12 items")
            }
        }
    }
}

@Composable
fun TextFieldSample() {
    var value1 by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var value2 by remember {
        mutableStateOf(TextFieldValue(""))
    }
    Column {
        androidx.compose.material3.OutlinedTextField(
            value = value1,
            onValueChange = {
                value1 = it
                // onValueChange(it.text)
            },
            singleLine = true,
            modifier = Modifier,
        )

        androidx.compose.material3.OutlinedTextField(
            value = value2,
            onValueChange = {
                value2 = it
                // onValueChange(it.text)
            },
            singleLine = true,
            modifier = Modifier,
        )
    }
}

@Composable
fun TestApp() {
    StickyBottomRow()
}
