package com.vukcho.saigrac.ui.home

import com.vukcho.saigrac.ui.SaigracViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

sealed interface HomeScreenAction

data object HomeScreenState

@HiltViewModel
class HomeViewModel @Inject constructor() :
    SaigracViewModel<HomeScreenState, HomeScreenAction>(initialState = HomeScreenState) {
        override fun onInitialState() {
        }
    }
