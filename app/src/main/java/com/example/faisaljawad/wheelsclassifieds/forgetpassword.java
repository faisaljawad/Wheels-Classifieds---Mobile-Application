package com.example.faisaljawad.wheelsclassifieds;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgetpassword extends AppCompatActivity {

    private EditText pass_email;
    private Button submitbtn;
    private FirebaseAuth firebaseAuth; //firebase Auth is an object here

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);
        pass_email=findViewById(R.id.emailforgetpassword);
         submitbtn=(Button)findViewById(R.id.btnForgetPassword);
         firebaseAuth=FirebaseAuth.getInstance();
         submitbtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String useremail=pass_email.getText().toString().trim(); //getting txt and converting into string and trim is used to remove whitespaces
                 if(useremail.equals(""))//if user email is null display this msg
                 {
                     Toast.makeText(forgetpassword.this,"Please enter your registered Email ID.", Toast.LENGTH_SHORT).show();
                 }
                 else
                 {
                     firebaseAuth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                         @Override
                         public void onComplete(@NonNull Task<Void> task) {
                             if(task.isSuccessful())
                             {
                                 Toast.makeText(forgetpassword.this,"Password reset email sent.", Toast.LENGTH_SHORT).show();
                                 finish();
                                 startActivity(new Intent(forgetpassword.this, Login.class));
                             }
                             else
                             {
                                 Toast.makeText(forgetpassword.this,"Error in sending mail.", Toast.LENGTH_SHORT).show();
                             }
                         }
                     });
                 }
             }
         });


    }

}
