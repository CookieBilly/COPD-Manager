// Generated by view binder compiler. Do not edit!
package ws.billy.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import ws.billy.app.R;

public final class FragmentHomeBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final LinearLayout contactDoctor;

  @NonNull
  public final ImageView iconMore;

  @NonNull
  public final ImageView menu;

  private FragmentHomeBinding(@NonNull ScrollView rootView, @NonNull LinearLayout contactDoctor,
      @NonNull ImageView iconMore, @NonNull ImageView menu) {
    this.rootView = rootView;
    this.contactDoctor = contactDoctor;
    this.iconMore = iconMore;
    this.menu = menu;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      LinearLayout contactDoctor = rootView.findViewById(R.id.contact_doctor);
      if (contactDoctor == null) {
        missingId = "contactDoctor";
        break missingId;
      }
      ImageView iconMore = rootView.findViewById(R.id.icon_more);
      if (iconMore == null) {
        missingId = "iconMore";
        break missingId;
      }
      ImageView menu = rootView.findViewById(R.id.menu);
      if (menu == null) {
        missingId = "menu";
        break missingId;
      }
      return new FragmentHomeBinding((ScrollView) rootView, contactDoctor, iconMore, menu);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}