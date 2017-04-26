package android.support.design.widget;

import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.view.View;
import org.strongswan.android.utils.Constants;

class CoordinatorLayoutInsetsHelperLollipop implements CoordinatorLayoutInsetsHelper {
    CoordinatorLayoutInsetsHelperLollipop() {
    }

    public void setupForWindowInsets(View view, OnApplyWindowInsetsListener insetsListener) {
        if (ViewCompat.getFitsSystemWindows(view)) {
            ViewCompat.setOnApplyWindowInsetsListener(view, insetsListener);
            view.setSystemUiVisibility(Constants.MTU_MIN);
        }
    }
}
