package com.vukcho.saigrac.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow

abstract class SaigracViewModel<State, Action>(
    initialState: State,
) : ViewModel() {
    var vmState by mutableStateOf(initialState)

    val actions: MutableLiveData<List<Action>> = MutableLiveData(listOf())

    private var isInitialized: Boolean = false

    fun initialize() {
        if (!isInitialized) {
            isInitialized = true
            onInitialState()
        }
    }

    abstract fun onInitialState()

    protected fun sendAction(action: Action) {
        actions.value?.let { actionList ->
            val mutableActionList = actionList.toMutableList()
            mutableActionList.add(action)
            actions.value = mutableActionList
        }
    }

    internal fun onActionHandled() {
        actions.value?.let { actionList ->
            val mutableActionList = actionList.toMutableList()
            mutableActionList.removeFirstOrNull()
            actions.value = mutableActionList
        }
    }
}

@Composable
fun <State, Action> SaigracViewModel<State, Action>.ObserveActions(executeAction: (Action) -> (Unit)) {
    actions.asFlow().collectAsState(null).let {
        it.value?.firstOrNull()?.let { extendedAction ->
            if (actions.value?.contains(extendedAction) == true) {
                executeAction(extendedAction)
                onActionHandled()
            }
        }
    }
}

@Composable
inline fun <reified T : SaigracViewModel<*, *>> saigracViewModel(): T {
    val viewModel: T = hiltViewModel()
    LaunchedEffect(viewModel) {
        viewModel.initialize()
    }
    return viewModel
}
