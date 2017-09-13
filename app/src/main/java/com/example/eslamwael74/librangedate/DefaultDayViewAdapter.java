package com.example.eslamwael74.librangedate;

import android.view.ContextThemeWrapper;
import android.widget.TextView;

/**
 * Created by eslamwael74 on 12/09/17.
 */



public class DefaultDayViewAdapter implements DayViewAdapter {
    @Override
    public void makeCellView(CalendarCellView parent) {
        TextView textView = new TextView(
                new ContextThemeWrapper(parent.getContext(), R.style.CalendarCell_CalendarDate));
        textView.setDuplicateParentStateEnabled(true);
        parent.addView(textView);
        parent.setDayOfMonthTextView(textView);
    }
}
