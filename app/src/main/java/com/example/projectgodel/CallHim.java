package com.example.projectgodel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class CallHim extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_him);

        ImageButton buttonSend = findViewById(R.id.idSend);
        TextView viewTextPhoneNumber = findViewById(R.id.editPhoneNumber);
        EditText editTextMessage = findViewById(R.id.editMessage);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = viewTextPhoneNumber.getText().toString();
                String message = editTextMessage.getText().toString();

                boolean installed = appInstalled("com.whatsapp");

                if(installed){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+"+6281393452674"+phoneNumber+"&text="+message));
                    startActivity(intent);
                } else {
                    Toast.makeText(CallHim.this, "WhatsApp not installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean appInstalled(String url){
        PackageManager packageManager = getPackageManager();
        boolean app_installed;
        try {
            packageManager.getPackageInfo(url,packageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e){
            app_installed = false;
        } return app_installed;
    }
}