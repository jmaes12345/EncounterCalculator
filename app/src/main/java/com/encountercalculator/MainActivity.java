package com.encountercalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.encountercalculator.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        TableLayout pcTableLayout = findViewById(R.id.PartyTable);
        TableRow header = findViewById(R.id.table_header);
        TextView column1 = new TextView(this);
        column1.setEnabled(false);
        column1.setText("PC Name");
        TextView column2 = new TextView(this);
        column2.setEnabled(false);
        column2.setText("Level");
        header.addView(column1);
        header.addView(column2);

        for (int i = 0; i < 3; i++) {
            TableRow row = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);
            EditText et1 = new EditText(this);
            EditText et2 = new EditText(this);
            row.addView(et1);
            row.addView(et2);
        }

        FloatingActionButton saveFAB = findViewById(R.id.saveFAB);
        FloatingActionButton addFAB = findViewById(R.id.addFAB);

        saveFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Party saved", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        addFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "New party member created", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}