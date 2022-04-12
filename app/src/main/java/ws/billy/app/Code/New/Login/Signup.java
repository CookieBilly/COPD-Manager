package ws.billy.app.Code.New.Login;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import ws.billy.app.InsideActivity;
import ws.billy.app.R;

public class Signup extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;

    // text entry fields
    private EditText usernameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText passwordRepeatEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set content view to the signup layout
        setContentView(R.layout.activity_signup);

        // define firebase's auth instance
        mAuth = FirebaseAuth.getInstance();

        // check if the user is already logged in (and skip page if so)
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null) {
            Intent intent = new Intent(this, InsideActivity.class);
            startActivity(intent);
            return;
        }

        // Show the sign up action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Sign Up");
        }

        // Text entry fields, used for validation & signup db entry
        usernameEditText = findViewById(R.id.name);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        passwordRepeatEditText = findViewById(R.id.confirm_password);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.loginsignup_menu, menu);
        return false;
    }

    // making sure back pressed directs properly
    @Override
    public void onBackPressed() {

        Intent intent = new Intent(this, Login.class);
        startActivity(intent);

    }

    @Override
    public void onClick(View view) {

        // When the sign up button is clicked
        if(view.getId() == R.id.buttonSignup) {

            // checking the password is repeated correctly
            if(!passwordEditText.getText().toString().equals(passwordRepeatEditText.getText().toString())) {

                // if it's not the same, throw an error and return.
                Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
                return;

            }

            // checking email & username aren't null
            if(usernameEditText.getText().toString().equals("Username") || emailEditText.getText().toString().equals("Email")) {

                Toast.makeText(this, "Invalid signup attempt!", Toast.LENGTH_SHORT).show();
                return;

            }

            // create user
            mAuth.createUserWithEmailAndPassword(emailEditText.getText().toString(), passwordEditText.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            // if the signup succeeds
                            if (task.isSuccessful()) {

                                // Sign up success, update display name
                                FirebaseUser user = mAuth.getCurrentUser();
                                UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                        .setDisplayName(usernameEditText.getText().toString())
                                        .build();

                                assert user != null;
                                user.updateProfile(profileUpdates)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    // open intent
                                                    Intent intent = new Intent(Signup.this, InsideActivity.class);
                                                    startActivity(intent);

                                                }
                                            }
                                        });


                            } else {

                                // throw an error that they're trying to sign up twice
                                Toast.makeText(Signup.this, "That email already exists!", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });


            // if the login button is clicked instead
        } else {

            // open intent
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);

        }
    }


}
