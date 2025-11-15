package com.vukcho.saigrac.ui.camera

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.net.toUri
import com.vukcho.saigrac.ui.ObserveActions

@Composable
fun CameraScreen(viewModel: CameraScreenViewModel) {
    val viewState = viewModel.vmState

    val takePictureLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture()
    ) {
        Log.d("TEST", "photo taken") // ovde moze npr. viewmodel.onPhotoTaken()
    }

    CameraScreenContent(
        counter = viewState.counter,
        onOpenCameraClicked = viewModel::onOpenCameraClicked,
        onBackButtonClicked = viewModel::onBackButtonClicked,
    )

    viewModel.ObserveActions { action ->
        when (action) {
            is CameraScreenAction.OpenCamera -> takePictureLauncher.launch(action.uri.toUri())
        }
    }
}

@Composable
private fun CameraScreenContent(
    counter: Int,
    onOpenCameraClicked: () -> Unit,
    onBackButtonClicked: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Counter = $counter"
        )

        Button(
            onClick = onOpenCameraClicked
        ) {
            Text("Open camera")
        }

        Button(
            onClick = onBackButtonClicked
        ) {
            Text("back")
        }
    }
}
