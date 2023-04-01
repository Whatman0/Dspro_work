package ru.elone.dspro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.elone.dspro.R;


public class ChoiceActivity extends AppCompatActivity {
    private String[] devs = {"Выберите прибор:","6-ПРМ.00 №01","6-ПРН.01 №01","6-ПРН.01 №02","10-ПРМ.00 №01","10-ПРН.01 №01","10-ПРН.01 №02","12–ВКУ.00–00.000","14-ПРН.00 №01","14-ПРН.00 №02","16-ВКУ.00–00.000","16-ПРН.01 №01","16-ПРН.01 №02"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        String welcomeText = "Добро пожаловать, " + getIntent().getStringExtra("username") + "!";
        TextView tvWelcome = findViewById(R.id.tvWelcome);
        tvWelcome.setText(welcomeText);
        Spinner spinner = findViewById(R.id.spinner);

        spinner.setPrompt("");
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        CustomAdapter adapter = new CustomAdapter(this,
                android.R.layout.simple_spinner_item, devs);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinner.setAdapter(adapter);
        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            parent.getItemAtPosition(pos);
            CustomAdapter.flag = true;
            // Получаем выбранный объект
            switch (pos) {
                case 0:
                    return;
                case 1:
                    Intent intent = new Intent(ChoiceActivity.this, Prm6_1.class);
                    startActivity(intent);
                    return;
                case 2:
                    Intent intent1 = new Intent(ChoiceActivity.this, Prn6_1.class);
                    startActivity(intent1);
                    return;
                case 3:
                    Intent intent2 = new Intent(ChoiceActivity.this, Prn6_2.class);
                    startActivity(intent2);
                    return;

            }
        }



        };
        spinner.setOnItemSelectedListener(itemSelectedListener);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((Spinner) findViewById(R.id.spinner)).performClick();
                spinner.showContextMenu();
            }
        });
    }

}
