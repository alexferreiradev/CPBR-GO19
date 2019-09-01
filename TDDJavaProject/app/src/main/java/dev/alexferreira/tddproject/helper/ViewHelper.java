package dev.alexferreira.tddproject.helper;

import android.view.View;

public class ViewHelper {

    public static void showFirstGoneSecond(View first, View second) {
        first.setVisibility(View.VISIBLE);
        second.setVisibility(View.GONE);
    }
}
