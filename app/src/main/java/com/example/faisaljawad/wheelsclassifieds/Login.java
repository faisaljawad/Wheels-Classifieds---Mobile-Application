package com.example.faisaljawad.wheelsclassifieds;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {

    EditText userEmail,userPassword;
    FirebaseAuth auth;
    FirebaseAuth.AuthStateListener auth_listener;
    public void change_to_forget_activitiy()
    {
        Intent intention = new Intent(this, forgetpassword.class);
        startActivity(intention);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userEmail = findViewById(R.id.edtEmail_signup);
        userPassword = findViewById(R.id.edtPassWord);


        Button login_btn = (Button) findViewById(R.id.btnLogIn);
        Button forget_btn = (Button) findViewById(R.id.btnForgetPassword);
        forget_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                change_to_forget_activitiy();
            }
        });
        login_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                start_signin();
            }
        });
        auth = FirebaseAuth.getInstance();
        auth_listener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(auth.getCurrentUser() != null)
                {
                    Toast.makeText(Login.this, "Sign-In Successful", Toast.LENGTH_SHORT).show();
                    
                    //startActivity(new Intent(Login.this, account_profile.class));
                }
            }
        };
    }
    public void start_signin() {
        String email_login = userEmail.getText().toString().trim();
        String password_login = userPassword.getText().toString().trim();
        if (TextUtils.isEmpty(email_login) || TextUtils.isEmpty(password_login)) {
            Toast.makeText(this, "Required Fields are Empty!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            auth.signInWithEmailAndPassword(email_login, password_login).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(Login.this, "Sign-In Failed!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(auth_listener);
    }

    public void logIn(View view) {
        SharedPreferences login = getSharedPreferences("Info", Context.MODE_PRIVATE);

        String email = login.getString("email1", "");
        String pass = login.getString("password1", "");

        if (email.equals("") && pass.equals(""))
        {
            Toast.makeText(this, "No Data Present Currently, Please SignUp Instead", Toast.LENGTH_LONG).show();
        }
        else
        {
            if (email.equals(userEmail.getText().toString()) && pass.equals(userPassword.getText().toString())) {
                Intent intention = new Intent(this, SplashScreen.class);
                startActivity(intention);
            }
            else
            {
                Toast.makeText(this, "Wrong Username/Passowrd", Toast.LENGTH_LONG).show();
            }
        }
    }
    public void RedirectSignUP(View view)
    {
        Intent i = new Intent(this,SignUp.class);
        startActivity(i);
    }
}
