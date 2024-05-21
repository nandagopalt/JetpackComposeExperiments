package com.amalwin.corecomposeapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(): ViewModel() {

    val membersListState = MutableLiveData<ArrayList<String>>()
    val nameState = MutableLiveData<String>("")

    fun onButtonClicked(name: String) {
        nameState.value = name
    }

}