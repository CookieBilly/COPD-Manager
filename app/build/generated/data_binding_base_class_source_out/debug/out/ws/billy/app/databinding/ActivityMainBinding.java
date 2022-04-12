// Generated by view binder compiler. Do not edit!
package ws.billy.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import ws.billy.app.R;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final BottomNavigationView bottomNavigationView;

  @NonNull
  public final FrameLayout frameContainer;

  private ActivityMainBinding(@NonNull LinearLayout rootView,
      @NonNull BottomNavigationView bottomNavigationView, @NonNull FrameLayout frameContainer) {
    this.rootView = rootView;
    this.bottomNavigationView = bottomNavigationView;
    this.frameContainer = frameContainer;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      BottomNavigationView bottomNavigationView = rootView.findViewById(R.id.bottomNavigationView);
      if (bottomNavigationView == null) {
        missingId = "bottomNavigationView";
        break missingId;
      }
      FrameLayout frameContainer = rootView.findViewById(R.id.frameContainer);
      if (frameContainer == null) {
        missingId = "frameContainer";
        break missingId;
      }
      return new ActivityMainBinding((LinearLayout) rootView, bottomNavigationView, frameContainer);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
