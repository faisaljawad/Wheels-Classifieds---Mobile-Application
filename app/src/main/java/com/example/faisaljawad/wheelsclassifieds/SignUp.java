package com.example.faisaljawad.wheelsclassifieds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity
{

    EditText name,email,password,confirmPassword;
    DatabaseReference users = FirebaseDatabase.getInstance().getReference("Users");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name = findViewById(R.id.edtName);
        email = findViewById(R.id.edtEmail);
        password = findViewById(R.id.edtPassWord);
        confirmPassword = findViewById(R.id.edtPassword2);
    }

    public void saveSignUpInfo(View view)
    {
        Toast.makeText(this,"Hello",Toast.LENGTH_SHORT).show();
        if(name.getText().toString().matches("") && email.getText().toString().matches("") && password.getText().toString().matches("") && confirmPassword.getText().toString().matches(""))
        {
            name.setError("Name Field is Empty!");
            email.setError("Email Field is Empty!");
            password.setError("Password Field is Empty!");
            confirmPassword.setError("Confirm Password Field is Empty!");
            return;
        }
        else if (name.getText().toString().matches("")) {
            name.setError("Name Field is Empty!");
            return;
        }
        else if (email.getText().toString().matches("")) {
            //Toast.makeText(this, "Email Field is left empty. Please Enter a valid Name", Toast.LENGTH_SHORT).show();
            email.setError("Email Field is Empty");
            return;
        }
        else if(password.getText().toString().matches(""))
        {
            password.setError("Password Field is Empty!");
            return;
        }
        else if(confirmPassword.getText().toString().matches(""))
        {
            confirmPassword.setError("Confirm Password Field is Empty!");
            return;
        }
        else if(password.getText().toString().equals(confirmPassword.getText().toString()))
        {
           // SharedPreferences userSignUp = getSharedPreferences("Info", Context.MODE_PRIVATE);
           // SharedPreferences.Editor edit = userSignUp.edit();

           //edit.putString("username", name.getText().toString());
           //edit.putString("email1", email.getText().toString());
           //edit.putString("password1", password.getText().toString());

           //edit.apply();

            Toast.makeText(this, "Sign-Up Successful", Toast.LENGTH_LONG).show();
            add_user();
            // Intent i = new Intent(this, Login.class);
            // startActivity(i);
        }

        else
        {
            password.setError("Password mismatched");
            confirmPassword.setError("Confirm Password misamtched!");
        }
    }

    private void add_user()
    {
        String name_in = name.getText().toString();
        String email_in = email.getText().toString();
        String password_in = password.getText().toString();
        String id = users.push().getKey();
        user_info_class user_obj = new user_info_class(name_in,email_in,password_in);
        users.child(id).setValue(user_obj);
    }
}
