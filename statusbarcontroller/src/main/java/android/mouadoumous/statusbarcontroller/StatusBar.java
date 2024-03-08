package android.mouadoumous.statusbarcontroller;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class StatusBar {

    public static int getHeight(Activity activity){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            WindowInsets windowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
            return windowInsets.getInsets(WindowInsets.Type.statusBars()).top;
        }
        else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            WindowInsets windowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
            if (windowInsets != null) {
                DisplayCutout displayCutout = windowInsets.getDisplayCutout();
                if (displayCutout != null) {
                    return displayCutout.getSafeInsetTop();
                }
            }
            return 0;
        }
        else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            View decorView = activity.getWindow().getDecorView();
            WindowInsets insets = decorView.getRootWindowInsets();
            if (insets != null) {
                return insets.getSystemWindowInsetTop();
            }
            return 0;
        } else {
            Rect rectangle = new Rect();
            Window window = activity.getWindow();
            window.getDecorView().getWindowVisibleDisplayFrame(rectangle);
            return rectangle.top;
        }
    }
    @SuppressLint({"DiscouragedApi", "InternalInsetResource"})
    public static int getHeight(Context context) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            return getHeight(activity);
        }
        int statusBarHeight = 0;
        // 1. Check for a resource dimension (optional):
        // This prioritizes a potentially defined resource value if available.

        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = context.getResources().getDimensionPixelSize(resourceId);
            return statusBarHeight;
        }
        // 2. Fallback to calculation using display metrics:
        // This provides an estimate if no resource is available, but be aware of potential inaccuracies.

        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.R) {
            if (windowManager != null) {
                WindowInsets windowInsets = windowManager.getCurrentWindowMetrics().getWindowInsets();
                return windowInsets.getInsets(WindowInsets.Type.statusBars()).top;
            }
        }
        else if (Build.VERSION.SDK_INT > Build.VERSION_CODES.Q){
            if (windowManager != null) {
                WindowInsets windowInsets = windowManager.getCurrentWindowMetrics().getWindowInsets();
                DisplayCutout displayCutout = windowInsets.getDisplayCutout();
                if (displayCutout != null)
                    return displayCutout.getSafeInsetTop();
                else
                    return 0;
            }
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display display = null;
        if (windowManager != null)
            display = windowManager.getDefaultDisplay();
        else
            return 0;
        display.getRealMetrics(displayMetrics);
        Rect rect = new Rect();
        display.getRectSize(rect);
        statusBarHeight = displayMetrics.heightPixels - rect.height();
        return statusBarHeight;
    }


    public void hide(@NonNull Activity activity){
        activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    public void show(Activity activity){
        activity.getWindow().getDecorView().setSystemUiVisibility(0);
    }

    public boolean isHide(@NonNull Activity activity){
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.Q){
            WindowInsets windowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
            return windowInsets.isVisible(WindowInsetsCompat.Type.statusBars());
        }

        return activity.getWindow().getDecorView().getSystemUiVisibility() == View.SYSTEM_UI_FLAG_FULLSCREEN;
    }

    public boolean isShow(@NonNull Activity activity){
        return !isHide(activity);
    }


}
