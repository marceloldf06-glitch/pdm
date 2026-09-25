package com.example.apps;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int posicao = 0;
    double IMC = 0;
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
        Integer[] imgs = new Integer[]{
                R.drawable.cachorro,
                R.drawable.gardem,
                R.drawable.happy,
                R.drawable.patinho,
                R.drawable.porquinho
        };
        ImageView iv = findViewById(R.id.imageView2);

        Button btnvol, btnpro;
        btnvol = findViewById(R.id.btnvolt);
        btnpro = findViewById(R.id.btnprox);
        TextView tv = findViewById(R.id.txtIMC);
        EditText ep = findViewById(R.id.txtPeso);
        EditText ea = findViewById(R.id.txtAltura);

        btnpro.setOnClickListener(view -> {
            posicao++;
            iv.setImageResource(imgs[posicao]);
            if (posicao >= imgs.length-1){
                posicao = 0;
            }
            IMC = Double.parseDouble(ep.getText().toString()) / ((Double.parseDouble(ea.getText().toString()) * Double.parseDouble(ea.getText().toString())) / 10000);
            tv.setText(Double.toString(IMC));
        });
        btnvol.setOnClickListener(view -> {
            posicao--;
            if (posicao <0){
                posicao = imgs.length-1;
            }
            iv.setImageResource(imgs[posicao]);
            IMC =Double.parseDouble(ep.getText().toString()) / ((Double.parseDouble(ea.getText().toString()) * Double.parseDouble(ea.getText().toString())) / 10000);
            tv.setText(Double.toString(IMC));
        });

    }
}