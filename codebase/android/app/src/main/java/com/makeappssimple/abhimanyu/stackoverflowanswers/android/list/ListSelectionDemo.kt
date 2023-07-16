package com.makeappssimple.abhimanyu.stackoverflowanswers.android.list

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.Pets
import androidx.compose.material.icons.rounded.RadioButtonUnchecked
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier

val animalNames = listOf(
    "Lion",
    "Elephant",
    "Tiger",
    "Giraffe",
    "Zebra",
    "Kangaroo",
    "Panda",
    "Monkey",
    "Dolphin",
    "Koala",
    "Cheetah",
    "Hippopotamus",
    "Gorilla",
    "Penguin",
    "Kangaroo",
    "Leopard",
    "Polar Bear",
    "Ostrich",
    "Giraffe",
    "Lemur",
    "Kangaroo",
    "Raccoon",
    "Koala",
    "Hedgehog",
    "Toucan"
)

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun ListSelectionDemo() {
    var isInSelectionMode by remember {
        mutableStateOf(false)
    }
    val selectedItems = remember {
        mutableStateListOf<String>()
    }
    val resetSelectionMode = {
        isInSelectionMode = false
        selectedItems.clear()
    }

    BackHandler(
        enabled = isInSelectionMode,
    ) {
        resetSelectionMode()
    }

    LaunchedEffect(
        key1 = isInSelectionMode,
        key2 = selectedItems.size,
    ) {
        if (isInSelectionMode && selectedItems.isEmpty()) {
            isInSelectionMode = false
        }
    }

    Scaffold(
        topBar = {
            if (isInSelectionMode) {
                SelectionModeTopAppBar(
                    selectedItems = selectedItems,
                    resetSelectionMode = resetSelectionMode,
                )
            } else {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = "Animals",
                        )
                    },
                )
            }
        },
    ) {
        LazyColumn(
            modifier = Modifier.padding(it)
        ) {
            items(animalNames) { animalName ->
                val isSelected = selectedItems.contains(animalName)
                ListItem(
                    modifier = Modifier.combinedClickable(
                        onClick = {
                            if (isInSelectionMode) {
                                if (isSelected) {
                                    selectedItems.remove(animalName)
                                } else {
                                    selectedItems.add(animalName)
                                }
                            } else {
                                // Click action if required when not in selection mode
                            }
                        },
                        onLongClick = {
                            if (isInSelectionMode) {
                                if (isSelected) {
                                    selectedItems.remove(animalName)
                                } else {
                                    selectedItems.add(animalName)
                                }
                            } else {
                                isInSelectionMode = true
                                selectedItems.add(animalName)
                            }
                        },
                    ),
                    leadingContent = {
                        if (isInSelectionMode) {
                            if (isSelected) {
                                Icon(
                                    imageVector = Icons.Rounded.CheckCircle,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary,
                                )
                            } else {
                                Icon(
                                    imageVector = Icons.Rounded.RadioButtonUnchecked,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.outline,
                                )
                            }
                        } else {
                            Icon(
                                imageVector = Icons.Rounded.Pets,
                                contentDescription = null,
                            )
                        }
                    },
                    headlineContent = {
                        Text(
                            text = animalName,
                        )
                    },
                )
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun SelectionModeTopAppBar(
    selectedItems: SnapshotStateList<String>,
    resetSelectionMode: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = "${selectedItems.size} selected",
                style = MaterialTheme.typography.titleLarge.copy(
                    color = MaterialTheme.colorScheme.onBackground,
                ),
            )
        },
        navigationIcon = {
            IconButton(
                onClick = resetSelectionMode,
            ) {
                Icon(
                    imageVector = Icons.Rounded.Close,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onBackground,
                )
            }
        },
        actions = {
            var isDropDownVisible by remember {
                mutableStateOf(false)
            }
            Box(
                modifier = Modifier,
            ) {
                IconButton(
                    onClick = {
                        isDropDownVisible = true
                    },
                ) {
                    Icon(
                        imageVector = Icons.Rounded.MoreVert,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground,
                    )
                }
                DropdownMenu(
                    expanded = isDropDownVisible,
                    onDismissRequest = {
                        isDropDownVisible = false
                    }
                ) {
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = "Move",
                            )
                        },
                        onClick = {
                            isDropDownVisible = false
                        },
                        leadingIcon = {
                            Icon(
                                Icons.Outlined.Edit,
                                contentDescription = null
                            )
                        },
                    )
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = "Delete",
                            )
                        },
                        onClick = {
                            isDropDownVisible = false
                        },
                        leadingIcon = {
                            Icon(
                                Icons.Outlined.Delete,
                                contentDescription = null
                            )
                        },
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
    )
}
