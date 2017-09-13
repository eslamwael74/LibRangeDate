package com.example.eslamwael74.librangedate;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.example.eslamwael74.librangedate.MonthCellDescriptor;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    Calendar nextYear = Calendar.getInstance();

    CalendarPickerView calendarView;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", new Locale("ar", "EG"));


    ArrayList<String> dateList;
    List<Date> selectedDates;
    Date today = new Date();


    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.asd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i = 0; i < selectedDates.size(); i++) {
                    Date tempDate = selectedDates.get(i);
                    String fDate = sdf.format(tempDate);
                    dateList.add(fDate);

                }


                Log.d(TAG, "decorateDates: " + dateList);
                Toast.makeText(MainActivity.this, "" + dateList, Toast.LENGTH_LONG).show();
            }
        });

        calendarView = findViewById(R.id.calendar_view);

        nextYear.add(Calendar.YEAR, 2);

        calendarView.init(today, nextYear.getTime())
                .inMode(CalendarPickerView.SelectionMode.RANGE);

        calendarView.setCustomDayView(new DayViewAdapter() {
            @Override
            public void makeCellView(CalendarCellView parent) {
                LayoutInflater.from(parent.getContext()).inflate(R.layout.view_calendar_cell, parent);
                parent.setDayOfMonthTextView((TextView) parent.getChildAt(0).findViewById(R.id.calendar_cell_text_view));
            }
        });
        calendarView.setDecorators(new ArrayList<CalendarCellDecorator>() {{
            add(new CellDecorator(calendarView));
        }});

    }

    class CellDecorator implements CalendarCellDecorator {
        private CalendarPickerView calendar;

        CellDecorator(CalendarPickerView calendar) {
            this.calendar = calendar;
        }

        @Override
        public void decorate(CalendarCellView cellView, Date date) {

//            final String mDate = new SimpleDateFormat("yyyy/MM/dd", new Locale("ar", "EG")).format(calendar.getSelectedDate());

            selectedDates = calendar.getSelectedDates();

            dateList = new ArrayList<>();


            ImageView image = cellView.getChildAt(0).findViewById(R.id.calendar_cell_background_image);
            TextView textView = cellView.getChildAt(0).findViewById(R.id.calendar_cell_text_view);
            textView.setTextColor(cellView.getContext().getResources().getColor(R.color.calendar_text_selected));


            if (!cellView.isEnabled() || !cellView.isSelectable()) {
                textView.setTextColor(cellView.getContext().getResources().getColor(R.color.calendar_text_selected));
            } else {

                if (cellView.getRangeState().equals(RangeState.FIRST)) {
                    textView.setTextColor(cellView.getContext().getResources().getColor(R.color.calendar_selected_day_bg));
                    if (Locale.getDefault().getLanguage() == "en") {
                        image.setImageResource(R.drawable.calendar_cell_range_left);
                    } else {
                        image.setImageResource(R.drawable.calendar_cell_range_right);
                    }
                } else if (cellView.isSelected() && cellView.isToday()) {
                    textView.setTextColor(cellView.getContext().getResources().getColor(R.color.calendar_selected_day_bg));
                    image.setImageResource(R.drawable.bg_selected_sample);
                } else if (cellView.getRangeState().equals(RangeState.MIDDLE)) {
                    textView.setTextColor(cellView.getContext().getResources().getColor(R.color.calendar_selected_day_bg));
                    image.setImageResource(R.drawable.calendar_cell_range_middle);

                } else if (cellView.getRangeState().equals(RangeState.LAST)) {
                    textView.setTextColor(cellView.getContext().getResources().getColor(R.color.calendar_selected_day_bg));
                    if (Locale.getDefault().getLanguage().equals("en")) {
                        image.setImageResource(R.drawable.calendar_cell_range_right);
                    } else {
                        image.setImageResource(R.drawable.calendar_cell_range_left);
                    }

                } else if (cellView.isToday()) {
                    image.setImageResource(R.drawable.bg_today_sample);
                    textView.setTextColor(cellView.getContext().getResources().getColor(R.color.calendar_selected_day_bg));
                } else if (cellView.isSelected()) {
                    image.setImageResource(R.drawable.bg_selected_sample_circle);
                    textView.setTextColor(cellView.getContext().getResources().getColor(R.color.calendar_selected_day_bg));
                } else
                    image.setImageResource(0);
            }

//            if (selectedDates.contains(date)) {
//                //image.setImageResource(R.drawable.calendar_cell_range_middle);
////                    List<Date> s = new ArrayList<>();
////                    s.addAll(selectedDates);
////                    Toast.makeText(MainActivity.this, ""+s.size(), Toast.LENGTH_SHORT).show();
//
//
//
//            }


        }


    }


}