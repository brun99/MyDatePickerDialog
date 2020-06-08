package vn.edu.ntu.vancuong.mydatepickerdialog;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.net.sip.SipSession;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class myDateDialog {
    Context context;
    Calendar calendarDate;
    showDateChangeDialog showDateChangeDialog;

    public myDateDialog(Context context, Calendar calendarDate, myDateDialog.showDateChangeDialog showDateChangeDialog) {
        this.context = context;
        this.calendarDate = calendarDate;
        this.showDateChangeDialog = showDateChangeDialog;
    }

    public void showDateDialog(){
        DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendarDate.set(calendarDate.YEAR, i);
                calendarDate.set(calendarDate.MONTH, i1);
                calendarDate.set(calendarDate.DAY_OF_MONTH, i2);
                if (showDateChangeDialog != null)
                    showDateChangeDialog.DateUpDate(calendarDate);
            }
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(context,
                onDateSetListener,
                calendarDate.get(calendarDate.YEAR),
                calendarDate.get(calendarDate.MONTH),
                calendarDate.get(calendarDate.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    public static interface showDateChangeDialog{
        public void DateUpDate(Calendar newDate);
    }
}


