package vn.edu.ntu.vancuong.mydatepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements myDateDialog.showDateChangeDialog, myTimeDialog.onMyTimeChangeListener{
    EditText editTime, edtDate;
    ImageView imDate, imTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addView();
        addEvent();
    }

    private void addEvent() {
        imDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDateDialog myDateDialog = new myDateDialog(MainActivity.this,
                        Calendar.getInstance(),
                        MainActivity.this);
                myDateDialog.showDateDialog();
            }
        });
        imTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myTimeDialog myTimeDialog = new myTimeDialog(MainActivity.this,
                        Calendar.getInstance(),
                        MainActivity.this);
                myTimeDialog.showTimeDialog();
            }
        });
    }

    private void addView() {
        edtDate = findViewById(R.id.editDate);
        editTime = findViewById(R.id.editTime);

        imDate = findViewById(R.id.imDate);
        imTime = findViewById(R.id.imTime);
    }

    @Override
    public void DateUpDate(Calendar newDate) {
        StringBuilder builder = new StringBuilder();
            builder.append(newDate.get(newDate.DAY_OF_MONTH))
                    .append("/")
                    .append(newDate.get(newDate.MONTH)+1)
                    .append("/")
                    .append(newDate.get(newDate.YEAR));
            edtDate.setText(builder.toString());
    }

    @Override
    public void timeUpDate(Calendar newTime) {
        StringBuilder builder = new StringBuilder();
        builder.append(newTime.get(newTime.HOUR_OF_DAY))
                .append(":")
                .append(newTime.get(newTime.MINUTE));
        editTime.setText(builder.toString());

    }
}