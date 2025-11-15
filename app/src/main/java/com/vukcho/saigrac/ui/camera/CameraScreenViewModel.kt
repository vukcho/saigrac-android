package com.vukcho.saigrac.ui.camera

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.vukcho.saigrac.navigation.NavigationManager
import com.vukcho.saigrac.navigation.destinations.HomeDestination
import com.vukcho.saigrac.ui.SaigracViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

sealed class CameraScreenAction {

    data class OpenCamera(val uri: String) : CameraScreenAction()
}

data class CameraScreenState(
    val counter: Int,
)

@HiltViewModel
class CameraScreenViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val savedStateHandle: SavedStateHandle,
) : SaigracViewModel<CameraScreenState, CameraScreenAction>(
    initialState = CameraScreenState(
        counter = 0
    )
) {
    override fun onInitialState() {
        viewModelScope.launch {
            val counter = savedStateHandle.get<String>(HomeDestination.Camera.COUNTER_ARG)?.toIntOrNull()

            vmState = vmState.copy(
                counter = counter ?: 0,
            )
        }
    }

    fun onOpenCameraClicked() {
        sendAction(CameraScreenAction.OpenCamera(uri = System.currentTimeMillis().toString()))
    }

    fun onBackButtonClicked() = viewModelScope.launch {
        navigationManager.navigateBack()
    }
}
