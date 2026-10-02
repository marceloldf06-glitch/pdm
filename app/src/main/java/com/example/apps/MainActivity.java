package com.example.apps;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
String[] nomes = new String[]{"Robson", "João", "Julia", "Kiara", "Braian", "Marcelo", "Boos", "Beninca"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });
        ListView lv = findViewById(R.id.listView);
        ArrayAdapter<String> usb = new ArrayAdapter<>(getApplicationContext(), R.layout.itemdalista, R.id.textView, nomes);
        lv.setAdapter(usb);
        lv.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(getApplicationContext(),nomes[position],Toast.LENGTH_LONG).show();

        });




    }
}