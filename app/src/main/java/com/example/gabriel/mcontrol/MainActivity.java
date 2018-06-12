package com.example.gabriel.mcontrol;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView cardview1 = (CardView) findViewById(R.id.bankcardId);
        CardView cardview2 = (CardView) findViewById(R.id.reportcardid);
        CardView cardview3 = (CardView) findViewById(R.id.remindercard);
        CardView cardview4 = (CardView) findViewById(R.id.cameracard);

        cardview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Expenses.class));
            }
        });

        cardview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Report.class));
            }
        });

        cardview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Bill.class));
            }
        });

        cardview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, camera.class));
            }
        });

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:

                        break;

                    case R.id.action_expenses:
                        Toast.makeText(MainActivity.this, "Action Expenses Clicked", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, Expenses.class);
                        startActivity(intent);
                        break;
                    case R.id.action_receipt:
                        Toast.makeText(MainActivity.this, "Action Bill Clicked", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(MainActivity.this, Bill.class);
                        startActivity(intent1);
                        break;
                    case R.id.action_report:
                        Toast.makeText(MainActivity.this, "Action Report Clicked", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(MainActivity.this, Report.class);
                        startActivity(intent2);
                        break;

                }
                return false;

            }
        });

        ActionBar actionBar = getSupportActionBar(); // or getActionBar();
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.dollar_24dp);
        getSupportActionBar().setDisplayUseLogoEnabled(true);





            }
        }







