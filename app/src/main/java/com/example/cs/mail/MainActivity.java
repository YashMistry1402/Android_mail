package com.example.cs.mail;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtMailTo,txtSubject,txtMessage;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.b1);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            txtMailTo=(EditText)findViewById(R.id.e1);
            txtSubject=(EditText)findViewById(R.id.e2);
            txtMessage=(EditText)findViewById(R.id.e3);
            String[] to={txtMailTo.getText().toString()};
            String[] cc={txtSubject.getText().toString()};
            String subject=txtMessage.getText().toString();
            String msg=txtMessage.getText().toString();

            Intent it=new Intent(Intent.ACTION_SEND);
            it.setData(Uri.parse("mail to"));
            it.setType("text/plan");
            it.putExtra(Intent.EXTRA_EMAIL,to);
            it.putExtra(Intent.EXTRA_CC,cc);
            it.putExtra(Intent.EXTRA_SUBJECT,subject);
            it.putExtra(Intent.EXTRA_TEXT,msg);
            try{
                startActivity(Intent.createChooser(it,"Send mail.."));
                finish();
            }
            catch (android.content.ActivityNotFoundException ex){
                Toast.makeText(getApplicationContext(),"No Email app instaled",Toast.LENGTH_LONG).show();
            }
            }
        });

    }
}
