package com.example.jdmlegendsv21.Adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jdmlegendsv21.Model.Car;
import com.example.jdmlegendsv21.R;

import java.util.ArrayList;
import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {

    private List<Car> cars;

    @NonNull
    @Override
    public CarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_cars_info, parent, false);
        return new CarAdapter.ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        if (cars != null && position <= cars.size())
        {
            holder.Brand.setText(cars.get(position).getCar_brand() + " ");
            holder.Model.setText(cars.get(position).getCar_model() + " ");
            holder.Body_type.setText(cars.get(position).getCar_body_type() + " ");
            holder.Year.setText(cars.get(position).getCar_year() + " ");
            switch (cars.get(position).getCar_model())
            {
                case "Civic":
                    holder.Image.setBackgroundResource(R.drawable.hondacivic);
                    break;
                case "Silvia":
                    holder.Image.setBackgroundResource(R.drawable.silvia);
                    break;
                case "Rx7":
                    holder.Image.setBackgroundResource(R.drawable.rx7);
                    break;
                case "Mx-5 Na8":
                    holder.Image.setBackgroundResource(R.drawable.miata);
                    break;
                case "Skyline GTR":
                    holder.Image.setBackgroundResource(R.drawable.r34);
                    break;
                case "Supra":
                    holder.Image.setBackgroundResource(R.drawable.supra);
                    break;
            }

        }

    }

    @Override
    public int getItemCount() {
        if (cars == null) {
            cars = new ArrayList<>();
            return 0;
        }
        return cars.size();
    }


    public CarAdapter(List<Car> cars) {
        this.cars = new ArrayList<>();
        this.cars = cars;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView Brand;
        public TextView Model;
        public TextView Body_type;
        public TextView Year;
        public ImageView Image;

            ViewHolder(@NonNull View itemView)
            {
                super(itemView);
                Brand = itemView.findViewById(R.id.text_car_brand);
                Model = itemView.findViewById(R.id.text_car_model);
                Body_type = itemView.findViewById(R.id.text_car_bodytype);
                Year = itemView.findViewById(R.id.text_car_year);
                Image = itemView.findViewById(R.id.imageViewCar);
            }
        }

    }