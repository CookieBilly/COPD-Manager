package ws.billy.app;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import ws.billy.app.Code.New.Chat.ChatActivity;
import ws.billy.app.Code.New.History.HistoryFragment;
import ws.billy.app.Code.New.Home.HomeFragment;
import ws.billy.app.Code.New.Questions.QuestionFragment;
import ws.billy.app.R;

public class InsideActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        } else {
            getWindow().getDecorView().setSystemUiVisibility(0);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new HomeFragment()).commit();
        }

        setUpBottomNavigation();
    }

    private void setUpBottomNavigation() {

        bottomNavigationView.setItemIconTintList(null);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.home) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new HomeFragment()).commit();
            } else if (itemId == R.id.history) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new HistoryFragment()).commit();
            } else if (itemId == R.id.question) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new QuestionFragment()).commit();
            } else if (itemId == R.id.chat) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new ChatActivity()).commit();
            }

            return true;
        });
    }

}
