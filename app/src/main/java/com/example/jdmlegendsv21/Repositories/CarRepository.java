package com.example.jdmlegendsv21.Repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.jdmlegendsv21.Database.AppDatabase;
import com.example.jdmlegendsv21.Database.CarDatabase;
import com.example.jdmlegendsv21.Model.Car;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class CarRepository {
    private AppDatabase data;
    private static CarRepository instance;

    private MutableLiveData<List<Car>> cars;

    public CarRepository(Application app)
    {
        CarDatabase carDatabase = CarDatabase.getInstance(app);
        data = carDatabase.appDatabase();
        cars = new MutableLiveData<>();
    }

    public static synchronized CarRepository getInstance(Application app)
    {
        if (instance == null)
        {
            instance = new CarRepository(app);
        }
        return instance;
    }

    public void save(Car car) throws ExecutionException, InterruptedException
    {
        new CarRepository.InsertAsyncTask(data).execute(car);
        List<Car> cars = getCarsFromDB();
        this.cars.postValue(cars);
    }

    public List<Car> getCarsFromDB() throws ExecutionException, InterruptedException {
        return new GetCars(data).execute().get();
    }
    public LiveData<List<Car>> getCars() {
        return cars;
    }

    public void removeCar(int pos) throws ExecutionException, InterruptedException {
        List<Car> list = getCarsFromDB();
        Car temp = list.get(pos);
        new RemoveItemAsync(data).execute(temp);
    }

    public static class RemoveItemAsync extends AsyncTask<Car, Void, Void> {
        private AppDatabase data;

        private RemoveItemAsync(AppDatabase data) {
            this.data = data;
        }

        @Override
        protected Void doInBackground(Car... cars) {
            data.removeCar(cars[0]);
            return null;
        }
    }

    public static class GetCars extends AsyncTask<Void, Void, List<Car>> {

        private AppDatabase data;

        private GetCars(AppDatabase data) {
            this.data = data;
        }

        @Override
        protected List<Car> doInBackground(Void... voids) {
            return data.getCars();
        }
    }

    private static class InsertAsyncTask extends AsyncTask<Car, Void, Void> {

        private AppDatabase data;

        private InsertAsyncTask(AppDatabase data) {
            this.data = data;
        }


        @Override
        protected Void doInBackground(Car... cars) {
            data.saveCar(cars[0]);
            return null;
        }
    }
}
