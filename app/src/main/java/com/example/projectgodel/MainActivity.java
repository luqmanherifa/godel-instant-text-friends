package com.example.projectgodel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private Activity activity = this;
    ImageButton btnCallFadel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCallFadel = (ImageButton) this.findViewById(R.id.idCallFadel);
        btnCallFadel.setOnClickListener(new klikCallFadel());
    }

    class klikCallFadel implements Button.OnClickListener
    {
        public void onClick (View v)
        {
            Intent i = new Intent(activity, CallHim.class );
            startActivity(i);
        }
    }

}