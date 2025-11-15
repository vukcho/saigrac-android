package com.vukcho.saigrac.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val viewState = viewModel.vmState

    HomeScreenContent(
        counter = viewState.counter,
        onIncrementCounterClicked = viewModel::onIncrementCounterClicked,
        onDecrementCounterClicked = viewModel::onDecrementCounterClicked,
        onOpenCameraScreenClicked = viewModel::onOpenCameraScreenClicked
    )
}

@Composable
private fun HomeScreenContent(
    counter: Int,
    onIncrementCounterClicked: () -> Unit,
    onDecrementCounterClicked: () -> Unit,
    onOpenCameraScreenClicked: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Counter = $counter"
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = onIncrementCounterClicked
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = null
                )
            }

            Button(
                onClick = onDecrementCounterClicked
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = null
                )
            }
        }

        Button(
            onClick = onOpenCameraScreenClicked
        ) {
            Text(
                text = "Open camera screen!"
            )
        }
    }
}
