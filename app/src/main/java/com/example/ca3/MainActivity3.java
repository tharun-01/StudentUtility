package com.example.ca3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity3 extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        drawerLayout=findViewById(R.id.drawer);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView=findViewById(R.id.nav_view);

        final FragmentManager fManager = getSupportFragmentManager();
        final Fragment fragment1 = new timer_fragamnet();
        final Fragment fragment2 = new Notes();
        final Fragment fragment3 = new calender();
        final Fragment fragment4 = new todo();
        final Fragment fragment5 = new voicealarm();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment frag = null;
                int id=item.getItemId();
                switch (id)
                {
                    case R.id.timer:
                        frag = fragment1;
                        loadFragment(frag);
                        Toast.makeText(getApplicationContext(),"Timer",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.notes:
                        frag = fragment2;

                        loadFragment(frag);
                        Toast.makeText(getApplicationContext(),"Notes",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.calender:
                        frag = fragment3;
                        loadFragment(frag);
                        Toast.makeText(getApplicationContext(),"Calender",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.TodoList:
                        frag = fragment4;
                        loadFragment(frag);
                        Toast.makeText(getApplicationContext(),"todo",Toast.LENGTH_SHORT).show();
                        break;

                    default:
                        frag = fragment5;
                        loadFragment(frag);
                        Toast.makeText(getApplicationContext(),"Vopice",Toast.LENGTH_SHORT).show();
                        break;

                }
               // fManager.beginTransaction().replace(R.id.con,frag).commit();

                return true;
            }

            private void loadFragment(Fragment frag) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.con,frag).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentTransaction.addToBackStack(null);

            }
        });


    }
}