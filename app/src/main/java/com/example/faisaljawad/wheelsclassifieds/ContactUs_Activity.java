package com.example.faisaljawad.wheelsclassifieds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactUs_Activity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us_);
       final EditText nameofuser=(EditText) findViewById(R.id.namecontactus);
        final EditText emailofuser=(EditText) findViewById(R.id.emailcontactus);
       final EditText subjectofmail=(EditText) findViewById(R.id.subjectemail);
       final EditText message=(EditText) findViewById(R.id.editText6);

        Button sendmessage=(Button) findViewById(R.id.buttoncontactus);
        sendmessage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                String name=nameofuser.getText().toString();
                String email=emailofuser.getText().toString();
                String subject=subjectofmail.getText().toString();
                String msg=message.getText().toString();
                if(TextUtils.isEmpty(name)){
                    nameofuser.setError("Enter your name.");
                    nameofuser.requestFocus();
                    return;
                }
                Boolean onError=false;
                if(!isValidEmail(email))
                {
                    onError=true;
                    emailofuser.setError("Invalid Email!");
                    return;
                }
                if(TextUtils.isEmpty(subject)){
                    subjectofmail.setError("Enter subject for your message.");
                    subjectofmail.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(msg)){
                    message.setError("Enter message.");
                    message.requestFocus();
                    return;
                }
                Intent sendEmail = new Intent(android.content.Intent.ACTION_SEND);

                /* Fill it with Data */
                sendEmail.setType("plain/text");
                sendEmail.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"faisaljawad1@gmail.com"});
                sendEmail.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
                sendEmail.putExtra(android.content.Intent.EXTRA_TEXT,
                        "name:"+name+'\n'+'\n'+"Message:"+'\n'+msg);

                /* Send it off to the Activity-Chooser */
                startActivity(Intent.createChooser(sendEmail, "Send mail..."));






            }

        });






    }
    @Override
    public void onResume() {
        super.onResume();
        //Get a Tracker (should auto-report)


    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


}
