package vn.edu.ntu.vancuong.mydatepickerdialog;

import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.TimePicker;

import java.util.Calendar;

public class myTimeDialog {
    Context context;
    Calendar calendar;
    onMyTimeChangeListener onMyTimeChangeListener;

    public myTimeDialog(Context context, Calendar calendar, myTimeDialog.onMyTimeChangeListener onMyTimeChangeListener) {
        this.context = context;
        this.calendar = calendar;
        this.onMyTimeChangeListener = onMyTimeChangeListener;
    }
    public void showTimeDialog(){
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener(){

            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                calendar.set(calendar.HOUR_OF_DAY, i);
                calendar.set(calendar.MINUTE, i1 );
                if (onMyTimeChangeListener != null)
                    onMyTimeChangeListener.timeUpDate(calendar);
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(context,onTimeSetListener,
                calendar.get(calendar.HOUR_OF_DAY),
                calendar.get(calendar.MINUTE),true);
        timePickerDialog.show();
    }

    public static interface onMyTimeChangeListener{
        public void timeUpDate(Calendar newTime);
    }

}
