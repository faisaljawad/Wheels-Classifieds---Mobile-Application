package com.example.faisaljawad.wheelsclassifieds;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity
{
    EditText name,email,password,confirmPassword;
    DatabaseReference users = FirebaseDatabase.getInstance().getReference("Users");
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name = (EditText)findViewById(R.id.edtName);
        email = (EditText)findViewById(R.id.edtEmail_signup);
        password = (EditText)findViewById(R.id.edtPassword_signup);
        confirmPassword = (EditText)findViewById(R.id.edtPassword2_signup);
        auth = FirebaseAuth.getInstance();
    }
    public void saveSignUpInfo(View view)
    {
        if(name.getText().toString().matches("") && email.getText().toString().matches("") && password.getText().toString().matches("") && confirmPassword.getText().toString().matches(""))
        {
            name.setError("Name Field is Empty!");
            email.setError("Email Field is Empty!");
            password.setError("Password Field is Empty!");
            confirmPassword.setError("Confirm Password Field is Empty!");
            return;
        }
        else if (name.getText().toString().matches("") || !name.getText().toString().matches("[a-zA-Z\\s]+")) {
            name.setError("Name Field is Empty!");
             name.setError("Name must have alphabetical characters only!");
            return;
        }
        else if (email.getText().toString().matches("")||!email.getText().toString().matches("^[a-zA-Z][a-zA-Z0-9._%+-]+@[a-z.-]+\\.[a-z]{2,4}")) {
            email.setError("Email Field is Empty");
            email.setError("Format not matched!");
            return;
        }
        else if(password.getText().toString().matches("") || !password.getText().toString().matches("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d_#.,$]{6,}"))
        {
            password.setError("Password Field is Empty!");
            password.setError("Password must have atleast 1 upper case,1 lower case and 1 digit!");
            return;
        }
        else if(confirmPassword.getText().toString().matches("") || !confirmPassword.getText().toString().matches("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d_#.,$]{6,}"))
        {
            confirmPassword.setError("Confirm Password Field is Empty!");
            return;
        }
        else if(password.getText().toString().equals(confirmPassword.getText().toString()))
        {
           //SharedPreferences userSignUp = getSharedPreferences("Info", Context.MODE_PRIVATE);
           //SharedPreferences.Editor edit = userSignUp.edit();
           //edit.putString("username", name.getText().toString());
           //edit.putString("email1", email.getText().toString());
           //edit.putString("password1", password.getText().toString());
           //edit.apply();
            add_user();
        }
        else
        {
            password.setError("Password mismatched");
            confirmPassword.setError("Confirm Password misamtched!");
        }
    }

    private void add_user()
    {
        String email_in = email.getText().toString().trim();
        String password_in = password.getText().toString().trim();
        auth.createUserWithEmailAndPassword(email_in,password_in).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    String name_in = name.getText().toString().trim();
                    String email_in = email.getText().toString().trim();
                    String password_in = password.getText().toString().trim();
                    String id = users.push().getKey();
                    user_info_class user_obj = new user_info_class(name_in,email_in,password_in);
                    users.child(id).setValue(user_obj);
                    Toast.makeText(SignUp.this, "Sign-Up Successful", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(SignUp.this,Login.class);
                    startActivity(i);
                }
                else
                    Toast.makeText(SignUp.this, "Sign-Up Failed!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
