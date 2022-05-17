package com.example.jdmlegendsv21.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.example.jdmlegendsv21.R;
import com.example.jdmlegendsv21.databinding.FragmentSearchBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class SearchFragment extends Fragment implements OnMapReadyCallback {

    private FragmentSearchBinding binding;
    private GoogleMap tMap;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        String MAP_FRAGMENT = "fragment_search";
        FragmentManager fragmentManager = getChildFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment) fragmentManager.findFragmentByTag(MAP_FRAGMENT);
        if(mapFragment == null){
            mapFragment = SupportMapFragment.newInstance();
            fragmentManager.beginTransaction().replace(R.id.mapView, mapFragment, MAP_FRAGMENT)
                    .commit();
        }
        mapFragment.getMapAsync(this);

        SearchViewModel searchViewModel = new ViewModelProvider(this).get(SearchViewModel.class);

        binding = FragmentSearchBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        tMap = googleMap;
        LatLng tokyo = new LatLng(37.316374620577875, 139.51152035524012);
        tMap.addMarker(new MarkerOptions()
                .position(tokyo)
                .title("Heaven of JDM cars"));
        tMap.moveCamera(CameraUpdateFactory.newLatLng(tokyo));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}