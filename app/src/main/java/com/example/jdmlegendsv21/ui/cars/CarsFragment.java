package com.example.jdmlegendsv21.ui.cars;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jdmlegendsv21.Adapter.CarAdapter;
import com.example.jdmlegendsv21.R;

import java.util.concurrent.ExecutionException;

public class CarsFragment extends Fragment {

    private RecyclerView recyclerView;
    private CarAdapter carAdapter;


   private CarsViewModel carsViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        carsViewModel = new ViewModelProvider(this).get(CarsViewModel.class);
        try {
            carsViewModel.getCars().observe(this, characters -> {

                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                carAdapter = new CarAdapter(characters);
                recyclerView.setAdapter(carAdapter);
                carAdapter.setOnClickListener(position ->
                {
                    carsViewModel.removeItem(position);
                    Toast.makeText(getContext(), "Item removed", Toast.LENGTH_SHORT).show();
                    carAdapter.notifyDataSetChanged();
                });
            });
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cars, container, false);

        recyclerView = view.findViewById(R.id.rvCars);

        return view;
    }


}