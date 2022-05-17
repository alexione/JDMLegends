package com.example.jdmlegendsv21.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("The term JDM originally represented cars sold primarily in Japan, but it has come to mean any high-performance Japanese model, whether a new or used car sold exclusively in Japan or in multiple global markets");
    }

    public LiveData<String> getText() {
        return mText;
    }
}