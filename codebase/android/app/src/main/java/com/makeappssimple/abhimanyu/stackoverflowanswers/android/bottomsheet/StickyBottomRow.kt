package com.makeappssimple.abhimanyu.stackoverflowanswers.android.bottomsheet

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

/**
 * https://stackoverflow.com/questions/76454800/how-to-place-a-sticky-bottom-row-bar-at-modalbottomsheet-using-jetpack-compose
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun StickyBottomRow() {
    val coroutineScope = rememberCoroutineScope()
    val modalBottomSheetState: ModalBottomSheetState =
        rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)

    modalBottomSheetState.currentValue
    ModalBottomSheetLayout(
        sheetState = modalBottomSheetState,
        sheetContent = {
            SheetContent()
        },
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Button(
                onClick = {
                    coroutineScope.launch {
                        if (modalBottomSheetState.currentValue == modalBottomSheetState.targetValue) {
                            modalBottomSheetState.show()
                        }
                    }
                },
            ) {
                Text("Open Bottom Sheet")
            }
        }
    }
}

@Composable
private fun SheetContent() {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val footerHeight = 152.dp

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(
                    bottom = footerHeight,
                )
                .onGloballyPositioned {  }
                .verticalScroll(rememberScrollState()),
        ) {
            SheetScrollingContent()
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = if ((this.minHeight - footerHeight) > 0.dp) {
                        Log.e("Abhi", "footerHeight $footerHeight")
                        this.minHeight - footerHeight
                    } else {
                        0.dp
                    },
                )
        ) {
            Footer()
        }
    }
}

@Composable
private fun SheetScrollingContent() {
    Text(randomText)
}

@Composable
private fun Footer() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp,
                top = 16.dp,
            )
            .background(Color.Magenta),
    ) {}
}

val randomText =
    "Welcome to our user-friendly interface! We've designed this interface with you in mind, providing a seamless experience that makes your tasks a breeze. Whether you're a novice or an expert, our intuitive design ensures you can accomplish your goals effortlessly. Let's dive in!\n" +
            "\n" +
            "1. Start your journey by selecting the desired action from our well-organized menu.\n" +
            "2. Need assistance? Our comprehensive help section is just a click away, guiding you through any challenges you may encounter.\n" +
            "3. Customize your preferences to personalize your experience and tailor the interface to your liking.\n" +
            "4. Stay up-to-date with real-time notifications that keep you informed about important updates and events.\n" +
            "5. Collaborate effortlessly by inviting team members to join your workspace and work together seamlessly.\n" +
            "6. Enjoy a clutter-free workspace with our sleek and minimalistic design, allowing you to focus on what matters most.\n" +
            "7. Effortlessly navigate through various features using our intuitive and responsive navigation bar.\n" +
            "8. Streamline your workflow with our powerful search functionality, ensuring you find what you need in seconds.\n" +
            "9. Easily import and export your data with our seamless integration options with popular file formats.\n" +
            "10. Get a bird's-eye view of your progress and milestones with our interactive progress tracker.\n" +
            "11. Save time with smart automation features that handle repetitive tasks, freeing you up for more important work.\n" +
            "12. Access your data from anywhere, anytime, with our cloud-based storage solution.\n" +
            "13. Personalize your workspace with customizable themes and color schemes to suit your style.\n" +
            "14. Take advantage of our comprehensive analytics dashboard, providing valuable insights into your data.\n" +
            "15. Simplify complex tasks with step-by-step wizards and guided workflows, ensuring accuracy and efficiency.\n" +
            "16. Collaborate in real-time with team members through integrated chat and messaging features.\n" +
            "17. Enjoy a distraction-free environment with our focus mode, minimizing distractions and maximizing productivity.\n" +
            "18. Seamlessly switch between different projects or tasks without losing your progress.\n" +
            "19. Access an extensive library of pre-designed templates to kickstart your projects with ease.\n" +
            "20. Keep your data secure with robust encryption and advanced access controls.\n" +
            "21. Stay organized with customizable folders and tags, allowing you to categorize and manage your content effectively.\n" +
            "22. Optimize your efficiency with keyboard shortcuts, enabling quick navigation and actions.\n" +
            "23. Gain insights into user behavior with built-in analytics, helping you make data-driven decisions.\n" +
            "24. Leverage our powerful APIs to integrate our interface with your existing tools and systems.\n" +
            "25. Enjoy a mobile-responsive design that adapts to different screen sizes, ensuring a consistent experience on the go.\n" +
            "26. Minimize errors with real-time validation and error-checking features.\n" +
            "27. Seamlessly switch between light and dark mode to suit your preferences and reduce eye strain.\n" +
            "28. Access a comprehensive documentation portal that provides detailed instructions and tutorials.\n" +
            "29. Collaborate with ease by leaving comments and annotations on shared documents or projects.\n" +
            "30. Utilize our drag-and-drop functionality to effortlessly organize and rearrange your content.\n" +
            "31. Customize your dashboard with widgets and widgets to display the information that matters most to you.\n" +
            "32. Get started quickly with our interactive onboarding process, guiding you through the interface's key features.\n" +
            "33. Receive proactive suggestions and recommendations based on your usage patterns and preferences.\n" +
            "34. Track your time and manage your schedule with integrated calendar and task management features.\n" +
            "35. Celebrate your achievements with badges and rewards, adding a touch of gamification to your experience.\n" +
            "36. Enjoy seamless integration with popular third-party tools, enhancing your productivity and collaboration.\n" +
            "37. Stay connected with your team through integrated video conferencing and screen sharing capabilities.\n" +
            "38. Keep your data organized with advanced sorting and filtering options.\n" +
            "39. Access a comprehensive library of video tutorials and guides to enhance your learning experience.\n" +
            "40. We value your feedback! Help"
