// Generated by view binder compiler. Do not edit!
package ws.billy.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import ws.billy.app.R;

public final class ActivitySignupBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final RelativeLayout buttonSignup;

  @NonNull
  public final EditText confirmPassword;

  @NonNull
  public final EditText email;

  @NonNull
  public final LinearLayout goToSignup;

  @NonNull
  public final CardView login;

  @NonNull
  public final EditText name;

  @NonNull
  public final EditText password;

  @NonNull
  public final LinearLayout socialMediaLogin;

  private ActivitySignupBinding(@NonNull RelativeLayout rootView,
      @NonNull RelativeLayout buttonSignup, @NonNull EditText confirmPassword,
      @NonNull EditText email, @NonNull LinearLayout goToSignup, @NonNull CardView login,
      @NonNull EditText name, @NonNull EditText password, @NonNull LinearLayout socialMediaLogin) {
    this.rootView = rootView;
    this.buttonSignup = buttonSignup;
    this.confirmPassword = confirmPassword;
    this.email = email;
    this.goToSignup = goToSignup;
    this.login = login;
    this.name = name;
    this.password = password;
    this.socialMediaLogin = socialMediaLogin;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySignupBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySignupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_signup, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySignupBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      RelativeLayout buttonSignup = rootView.findViewById(R.id.buttonSignup);
      if (buttonSignup == null) {
        missingId = "buttonSignup";
        break missingId;
      }
      EditText confirmPassword = rootView.findViewById(R.id.confirm_password);
      if (confirmPassword == null) {
        missingId = "confirmPassword";
        break missingId;
      }
      EditText email = rootView.findViewById(R.id.email);
      if (email == null) {
        missingId = "email";
        break missingId;
      }
      LinearLayout goToSignup = rootView.findViewById(R.id.go_to_signup);
      if (goToSignup == null) {
        missingId = "goToSignup";
        break missingId;
      }
      CardView login = rootView.findViewById(R.id.login);
      if (login == null) {
        missingId = "login";
        break missingId;
      }
      EditText name = rootView.findViewById(R.id.name);
      if (name == null) {
        missingId = "name";
        break missingId;
      }
      EditText password = rootView.findViewById(R.id.password);
      if (password == null) {
        missingId = "password";
        break missingId;
      }
      LinearLayout socialMediaLogin = rootView.findViewById(R.id.social_media_login);
      if (socialMediaLogin == null) {
        missingId = "socialMediaLogin";
        break missingId;
      }
      return new ActivitySignupBinding((RelativeLayout) rootView, buttonSignup, confirmPassword,
          email, goToSignup, login, name, password, socialMediaLogin);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}