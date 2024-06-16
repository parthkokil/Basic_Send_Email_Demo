package com.parth.justsendemail;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextTo,editTextSubject,editTextMessage;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTo = findViewById(R.id.edit_email_address);
        editTextSubject = findViewById(R.id.edit_mail_subject);
        editTextMessage = findViewById(R.id.edit_mail_message);

        send = findViewById(R.id.send_email_button);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String to = editTextTo.getText().toString();
                String subject = editTextSubject.getText().toString();
                String message = editTextMessage.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{ to});
                intent.putExtra(Intent.EXTRA_SUBJECT,subject);
                intent.putExtra(Intent.EXTRA_TEXT,message);


                // need this to prompts email client only
                intent.setType("message/rfc822");

                startActivity(Intent.createChooser(intent,"Choose an Email Client : "));
            }
        });
    }
}