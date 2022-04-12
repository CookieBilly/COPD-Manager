package ws.billy.app.Code.New.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import ws.billy.app.InsideActivity;
import ws.billy.app.R;

public class Login extends AppCompatActivity {

    private FirebaseAuth mAuth;

    // define the email & password text edit
    private EditText emailEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        System.out.println("testing");

        // link the gui elements to the code
        mAuth = FirebaseAuth.getInstance();
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);

        // if they're already logged in, let them skip this
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null) {
            Intent intent = new Intent(this, InsideActivity.class);
            startActivity(intent);
        }

        findViewById(R.id.loginButton).setOnClickListener(this::LoginClicked);


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

    }

    private void LoginClicked(View v) {

        if (emailEditText.getText().toString().length() == 0 || passwordEditText.getText().toString().length() == 0) {
            Toast.makeText(Login.this, "Please enter an email and password!", Toast.LENGTH_SHORT).show();
            return;
        }

        System.out.println(emailEditText.getText().toString());
        System.out.println(passwordEditText.getText().toString());

        mAuth.signInWithEmailAndPassword(emailEditText.getText().toString(), passwordEditText.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            // login, send user to the main page
                            Intent intent = new Intent(Login.this, InsideActivity.class);
                            startActivity(intent);

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(Login.this, "Invalid login details!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

}
