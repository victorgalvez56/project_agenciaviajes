package com.example.project_agenciaviajes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.project_agenciaviajes.Menu.HomeFragment;
import com.example.project_agenciaviajes.Menu.PerfilFragment;
import com.example.project_agenciaviajes.Menu.ShoppingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PreviousActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous);

        BottomNavigationView bottomNav = findViewById(R.id.Botones_navegacion);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()){
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_perfil:
                            selectedFragment = new PerfilFragment();
                            break;
                        case R.id.nav_buy:
                            selectedFragment = new ShoppingFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };

}
