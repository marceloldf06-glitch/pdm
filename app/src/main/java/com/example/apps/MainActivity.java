package com.example.apps;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.DialogTitle;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    int i = 1;
    ArrayList<String> nomes ;

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
        nomes = new ArrayList<String>();
        ListView lv = findViewById(R.id.listinha);
        Button b = findViewById(R.id.btnadd);
        EditText ed = findViewById(R.id.txtnome);

        b.setOnClickListener( view -> {
            nomes.add(ed.getText().toString());
            i++;
            ArrayAdapter<String> usb = new ArrayAdapter<>(getApplicationContext(), R.layout.itemdalista, R.id.textView, nomes);
            lv.setAdapter(usb);
        });
        ArrayAdapter<String> usb = new ArrayAdapter<>(getApplicationContext(), R.layout.itemdalista, R.id.textView, nomes);
        lv.setAdapter(usb);
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                                          @Override
                                          public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                                              AlertDialog.Builder bu = new AlertDialog.Builder(getApplicationContext())
                                                      .setTitle("Quer exluir mesmo?")
                                                      .setMessage("Confirmar exclusão")
                                                      .setPositiveButton("Sim", (dialogInterface, i1) -> {
                                                          nomes.remove(i);
                                                          usb.notifyDataSetChanged();
                                                          Toast.makeText(getApplicationContext(), "Nome excluido", Toast.LENGTH_LONG).show();
                                                      })
                                                      .setNegativeButton("Cancelar", (dialogInterface, i2) -> {
                                                          Toast.makeText(getApplicationContext(), "A exclusão foi cancelada", Toast.LENGTH_LONG).show();
                                                      })
                                                      .setCancelable(false);

                                              return false;
                                          }
                                      });
                lv.setOnItemClickListener((parent, view, position, id) -> {
                    Toast.makeText(getApplicationContext(), nomes.get(position), Toast.LENGTH_LONG).show();


                });




    }
}