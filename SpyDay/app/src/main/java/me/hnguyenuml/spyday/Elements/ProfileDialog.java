package me.hnguyenuml.spyday.Elements;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import me.hnguyenuml.spyday.R;

/**
 * Created by quang on 10/8/2016.
 */

public class ProfileDialog extends Dialog implements View.OnClickListener {

    private Dialog profileD;
    private Button mFollow;
    private Button mChat;
    private Button mSpy;

    public ProfileDialog(Context context) {
        super(context);
    }

    public void showDialog(Activity activity, String msg){
        profileD = new Dialog(activity);
        profileD.requestWindowFeature(Window.FEATURE_NO_TITLE);
        profileD.setCancelable(false);
        profileD.setContentView(R.layout.dialog_public_profile);

        profileD.show();
    }

    public ProfileDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected ProfileDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    public void onClick(View v) {

    }
}
