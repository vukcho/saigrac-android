package com.vukcho.saigrac.ui.home

import androidx.lifecycle.viewModelScope
import com.vukcho.saigrac.navigation.NavigationManager
import com.vukcho.saigrac.navigation.destinations.HomeDestination
import com.vukcho.saigrac.ui.SaigracViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

sealed interface HomeScreenAction

data class HomeScreenState(
    val counter: Int
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val navigationManager: NavigationManager
) :
    SaigracViewModel<HomeScreenState, HomeScreenAction>(
        initialState =
        HomeScreenState(
            counter = 0
        )
    ) {

    override fun onInitialState() {
    }

    fun onIncrementCounterClicked() {
        vmState = vmState.copy(
            counter = vmState.counter + 1
        )
    }

    fun onDecrementCounterClicked() {
        vmState = vmState.copy(
            counter = vmState.counter - 1
        )
    }

    fun onOpenCameraScreenClicked() = viewModelScope.launch {
        navigationManager.navigateTo(
            destination = HomeDestination.Camera(
                counter = vmState.counter,
            )
        )
    }
}
