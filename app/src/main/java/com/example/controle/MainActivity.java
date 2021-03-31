package com.example.controle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText EP,EFF,nom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EP =findViewById(R.id.EP);
        EFF =findViewById(R.id.EFF);
        nom =findViewById(R.id.nom);
        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double nbre1 = Double.parseDouble(EP.getText().toString());
                double nbre2 = Double.parseDouble(EFF.getText().toString());
                String name = nom.getText().toString();
                double result = (((nbre1) * 25)+((nbre2)* 75))/100;
                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                adb.setMessage("Le stagiaire "+name+" a eu la moyenne : "+result);
                adb.setPositiveButton("OK", new DialogInterface.OnClickListener()
                { @Override public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(MainActivity.this,"clic sur OK",Toast.LENGTH_LONG).show();
                } });
                AlertDialog alert= adb.create();
                alert.show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.google:
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
                break;

            case R.id.close:
                Toast.makeText(this, "You clicked Close Button", Toast.LENGTH_SHORT).show();
                finish();


                break;
        }
        return super.onOptionsItemSelected(item);
    }
}