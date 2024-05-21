package com.amalwintech.statemanagementviewmodelapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val textFieldLiveData = MutableLiveData("")

    fun onTextChanged(newName: String) {
        textFieldLiveData.value = newName
    }

}