package com.example.jdmlegendsv21.ui.save;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.jdmlegendsv21.Model.Car;
import com.example.jdmlegendsv21.R;

import java.util.concurrent.ExecutionException;

import javax.annotation.Nullable;

public class SaveFragment extends Fragment {

    private SaveViewModel saveViewModel;
    private Button savebutton;
    private EditText Brand;
    private EditText Model;
    private EditText Body_type;
    private EditText Year;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        saveViewModel = new ViewModelProvider(this).get(SaveViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @androidx.annotation.Nullable ViewGroup container, @androidx.annotation.Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_save, container, false);
        Brand = view.findViewById(R.id.editTextBrandName);
        Model = view.findViewById(R.id.editTextModelName);
        Body_type = view.findViewById(R.id.editTextBodyType);
        Year = view.findViewById(R.id.editTextYear);
        savebutton = view.findViewById(R.id.buttonSave);

        savebutton.setOnClickListener(v -> {
            String car_name = " ";
            String car_model = " ";
            String car_body_type = " ";
            Integer car_year = 0;

            car_name = this.Brand.getText().toString();
            car_model = this.Model.getText().toString();
            car_body_type = this.Body_type.getText().toString();
            car_year = Integer.valueOf(this.Year.getText().toString());

            try {
                saveViewModel.saveCar(new Car(car_name, car_model, car_body_type, car_year));
                Toast.makeText(getContext(), "Car Saved", Toast.LENGTH_SHORT).show();
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        return view;
    }
}
