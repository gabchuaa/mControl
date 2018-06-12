package com.example.gabriel.mcontrol;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;


public class Report extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        PieChart pieChart = (PieChart) findViewById(R.id.piechart);

        List<PieEntry> entries = new ArrayList<>();

        entries.add(new PieEntry(18.5f, "Transport"));
        entries.add(new PieEntry(26.7f, "Entertainment"));
        entries.add(new PieEntry(24.0f, "Bill"));
        entries.add(new PieEntry(30.8f, "Food"));

        // entry color
        pieChart.setEntryLabelColor(Color.BLACK);
        pieChart.setEntryLabelTextSize(14f);


        PieDataSet set = new PieDataSet(entries, "Expenses");
        PieData data = new PieData(set);
        pieChart.setData(data);
        pieChart.invalidate(); // refresh
        data.setValueFormatter(new PercentFormatter());
        //data color
        data.setValueTextSize(14f);
        data.setValueTextColor(Color.BLACK);



        set.setColors(ColorTemplate.VORDIPLOM_COLORS);



        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        Toast.makeText(Report.this, "Home", Toast.LENGTH_SHORT).show();
                        Intent intent0 = new Intent(Report.this, MainActivity.class);
                        startActivity(intent0);
                        break;

                    case R.id.action_expenses:
                        Toast.makeText(Report.this, "Expenses", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Report.this, Expenses.class);
                        startActivity(intent);
                        break;
                    case R.id.action_receipt:
                        Toast.makeText(Report.this, "Bill", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(Report.this, Bill.class);
                        startActivity(intent1);
                        break;
                    case R.id.action_report:
                        Toast.makeText(Report.this, "Report", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(Report.this, Report.class);
                        startActivity(intent2);
                        break;

                }
                return true;

            }
        });

        ActionBar actionBar = getSupportActionBar(); // or getActionBar();
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.dollar_24dp);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


    }
}
