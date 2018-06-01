package com.mitsuki.calculation;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Mitsuki on 2018/6/1.
 */

public class SelectDialog extends Dialog{

    private ItemClick click;

    public SelectDialog(@NonNull Context context) {
        super(context, R.style.DialogStyle);
    }

    public SelectDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);
    }


    public interface ItemClick{
        void click(String str);
    }
}
