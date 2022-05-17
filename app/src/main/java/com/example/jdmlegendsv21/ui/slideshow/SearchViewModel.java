package com.example.jdmlegendsv21.ui.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SearchViewModel extends ViewModel {

    private final MutableLiveData<String> mText;


    public SearchViewModel() {
        this.mText = new MutableLiveData<>();
        mText.setValue("Pulito Fnatastico");
    }

    public LiveData<String> getText() {
        return mText;
    }
}