package com.example.jdmlegendsv21.ui.save;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import com.example.jdmlegendsv21.Model.Car;
import com.example.jdmlegendsv21.Repositories.CarRepository;

import java.util.concurrent.ExecutionException;

public class SaveViewModel extends AndroidViewModel {

    private CarRepository carRepository;

    public SaveViewModel(Application application)
    {
        super(application);
        carRepository = CarRepository.getInstance(application);
    }

    public void saveCar(Car car) throws ExecutionException, InterruptedException
    {
        carRepository.save(car);
    }

}
