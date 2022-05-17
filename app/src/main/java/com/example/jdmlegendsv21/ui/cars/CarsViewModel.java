package com.example.jdmlegendsv21.ui.cars;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.jdmlegendsv21.Model.Car;
import com.example.jdmlegendsv21.Repositories.CarRepository;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class CarsViewModel extends AndroidViewModel {

    private CarRepository carRepository;

    public CarsViewModel(Application application)
    {
        super(application);
        carRepository = CarRepository.getInstance(application);
    }

    public LiveData<List<Car>> getCars() throws ExecutionException, InterruptedException {
        return carRepository.getCars();
    }

    public void removeItem(int pos) throws ExecutionException, InterruptedException {
        carRepository.removeCar(pos);
    }

}
