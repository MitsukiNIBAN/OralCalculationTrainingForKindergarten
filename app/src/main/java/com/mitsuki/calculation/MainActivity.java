package com.mitsuki.calculation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private Button checkBtn;
    private Button getBtn;
    private ListView listView;
    private EditText number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBtn = findViewById(R.id.btn_check);
        getBtn = findViewById(R.id.btn_get_data);
        listView = findViewById(R.id.listview_data);
        number = findViewById(R.id.et_number);
    }


}
