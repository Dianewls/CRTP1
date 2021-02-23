package com.firida_diane.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView textView= findViewById(R.id.textView1);

        SharedPreferences settings = getSharedPreferences("cycle_vie_prefs", Context.MODE_PRIVATE);
        textView.setText(settings.getString("valeur",""));

       //Intent intent =getIntent();
       //String s=intent.getStringExtra("cle");
       //textView.setText(s);



        popUp("onCreate()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        popUp("onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        popUp("onStart()");
    }


    @Override
    protected void onResume() {
        super.onResume();
        popUp("onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences settings = getSharedPreferences("cycle_vie_prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        //editor.putString("valeur", getTxtValeur());
        editor.commit();


        if (isFinishing()) {
            popUp("onPause, l'utilisateur à demandé la fermeture via un finish()");
        } else {
            popUp("onPause, l'utilisateur n'a pas demandé la fermeture via un finish()");
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        popUp("onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        popUp("onDestroy()");
    }



    public void popUp(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }


}