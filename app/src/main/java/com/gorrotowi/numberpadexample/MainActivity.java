package com.gorrotowi.numberpadexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.gorrotowi.numberpad.PhonePad;
import com.gorrotowi.numberpad.listeners.OnPhonePadListener;

public class MainActivity extends AppCompatActivity {

    PhonePad phonePad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phonePad = (PhonePad) findViewById(R.id.phonepad);

        phonePad.setOnPhonePadListener(new OnPhonePadListener() {
            @Override
            public void OnPhonePadCListener(String code, String number) {
                Log.e("result", code + " " + number);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
