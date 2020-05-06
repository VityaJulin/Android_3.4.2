package com.example.android_332;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Button okBtn;
    private TextView primaryTxt;
    private Spinner langSpin;
    private Spinner themesSpin;
    private Spinner marginSpin;
    private int themeSpinPosition;
    private int marginSpinPosition;
    private View group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.app_name);
        Utils.onActivityCreateSetTheme(this);
        //Utils.onActivityCreateSetMargin(this);
        setContentView(R.layout.activity_main);
        initViews();
        initLangSpin();
        initThemesSpin();
        initMarginSpin();

        final ConstraintLayout constraintLayout = new ConstraintLayout(MainActivity.this);
        final ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        langSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] languages = getResources().getStringArray(R.array.lang_spin);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        themesSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] themes = getResources().getStringArray(R.array.themes_spin);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        marginSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] margins = getResources().getStringArray(R.array.margin_spin);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (langSpin.getSelectedItemPosition() == 0) {
                    Locale locale = new Locale("ru");
                    Configuration config = new Configuration();
                    config.setLocale(locale);
                    getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                } else if (langSpin.getSelectedItemPosition() == 1) {
                    Locale locale = new Locale("en", "us");
                    Configuration config = new Configuration();
                    config.setLocale(locale);
                    getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                }

                themeSpinPosition = themesSpin.getSelectedItemPosition();

                switch (themeSpinPosition) {
                    case 0:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_BLACK);
                        break;
                    case 1:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_GREEN);
                        break;
                    case 2:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_BLUE);
                        break;
                }

                marginSpinPosition = marginSpin.getSelectedItemPosition();

                switch (marginSpinPosition) {
                    case 0:
                        layoutParams.setMargins(1, 1, 1, 1);
                        break;
                    case 1:
                        layoutParams.setMargins(3, 3, 3, 3);
                        break;
                    case 2:
                        layoutParams.setMargins(10, 10, 10, 10);
                        break;
                }
                setContentView(constraintLayout);
                Toast.makeText(MainActivity.this, R.string.toast_select, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initViews() {
        langSpin = (Spinner) findViewById(R.id.land_spin);
        primaryTxt = findViewById(R.id.primary_txt);
        okBtn = findViewById(R.id.ok_btn);
        themesSpin = findViewById(R.id.themes_spin);
        marginSpin = findViewById(R.id.margin_spin);
        group = findViewById(R.id.group);
    }

    private void initLangSpin() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.lang_spin, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        langSpin.setAdapter(adapter);
    }

    private void initThemesSpin() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.themes_spin, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        themesSpin.setAdapter(adapter);
    }

    private void initMarginSpin() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.margin_spin, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        marginSpin.setAdapter(adapter);
    }
}
