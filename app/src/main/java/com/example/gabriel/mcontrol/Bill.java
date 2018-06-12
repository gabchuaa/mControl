package com.example.gabriel.mcontrol;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class Bill extends AppCompatActivity {

    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView lvItems;

    public void onAddItem(View v) {
        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        String itemText = etNewItem.getText().toString();
        itemsAdapter.add(itemText);
        etNewItem.setText("");
        writeItems();
    }

    private void readItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            items = new ArrayList<String>(FileUtils.readLines(todoFile));
        } catch (IOException e) {
            items = new ArrayList<String>();
        }
    }

    private void writeItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            FileUtils.writeLines(todoFile, items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        // ADD HERE
        lvItems = (ListView) findViewById(R.id.lvItems);
        items = new ArrayList<String>();
        readItems(); //
        itemsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);
        items.add("First Item");
        items.add("Second Item");
        setupListViewListener();
    }



        private void setupListViewListener() {
            lvItems.setOnItemLongClickListener(
                    new AdapterView.OnItemLongClickListener() {
                        @Override
                        public boolean onItemLongClick(AdapterView<?> adapter,
                                                       View item, int pos, long id) {
                            // Remove the item within array at position
                            items.remove(pos);
                            // Refresh the adapter
                            itemsAdapter.notifyDataSetChanged();
                            writeItems();
                            // Return true consumes the long click event (marks it handled)
                            return true;
                        }

                    });






        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        Toast.makeText(Bill.this, "Home", Toast.LENGTH_SHORT).show();
                        Intent intent0 = new Intent(Bill.this, MainActivity.class);
                        startActivity(intent0);
                        break;

                    case R.id.action_expenses:
                        Toast.makeText(Bill.this, "Expenses", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Bill.this, Expenses.class);
                        startActivity(intent);
                        break;
                    case R.id.action_receipt:
                        Toast.makeText(Bill.this, "Bill", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(Bill.this, Bill.class);
                        startActivity(intent1);
                        break;
                    case R.id.action_report:
                        Toast.makeText(Bill.this, "Report", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(Bill.this, Report.class);
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
