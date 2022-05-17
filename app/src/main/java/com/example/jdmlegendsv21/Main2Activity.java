package com.example.jdmlegendsv21;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.jdmlegendsv21.databinding.ActivityMain2Binding;
import com.example.jdmlegendsv21.ui.cars.CarsFragment;
import com.example.jdmlegendsv21.ui.home.HomeFragment;
import com.example.jdmlegendsv21.ui.save.SaveFragment;
import com.example.jdmlegendsv21.ui.slideshow.SearchFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main2Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMain2Binding binding;

    FloatingActionButton buttonLogout;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain2.toolbar);
        binding.appBarMain2.buttonLogout.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_cars,R.id.nav_save, R.id.nav_search)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main2);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        buttonLogout = findViewById(R.id.buttonLogout);
        mAuth = FirebaseAuth.getInstance();

        buttonLogout.setOnClickListener(view ->{
            mAuth.signOut();
            startActivity(new Intent(Main2Activity.this, LoginActiv.class));
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
            {
                case R.id.nav_home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main2, new HomeFragment()).commit();
                    break;

                case R.id.nav_cars:
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main2, new CarsFragment()).commit();
                    break;

                case R.id.nav_save:
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main2, new SaveFragment()).commit();
                    break;

                case R.id.nav_search:
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main2, new SearchFragment()).commit();
                    break;
            }

        return true;


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main2);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null){
            startActivity(new Intent(Main2Activity.this, LoginActiv.class));
        }
    }
}