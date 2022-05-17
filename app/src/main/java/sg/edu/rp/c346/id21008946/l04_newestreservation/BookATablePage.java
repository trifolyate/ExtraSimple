package sg.edu.rp.c346.id21008946.l04_newestreservation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;


public class BookATablePage extends AppCompatActivity {

    EditText nameEt,dateEt,noOfPaxEt,numberEt,timeEt;
    Button submitBtn;
    TextView resetTv,resultTv;
    CheckBox cB;
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;
    int hour,minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_atable_page);

        nameEt =findViewById(R.id.nameEt);
        dateEt = findViewById(R.id.DateEt);
        noOfPaxEt = findViewById(R.id.NoOfPaxEt);
        numberEt = findViewById(R.id.NumberEt);
        timeEt = findViewById(R.id.TimeEt);
        resetTv = findViewById(R.id.tvReset);
        submitBtn = findViewById(R.id.submitBtn);
//        resultTv = findViewById(R.id.resultTv);
        cB = findViewById(R.id.checkBox);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        dateEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mcurrentDate = Calendar.getInstance();
                int mYear = mcurrentDate.get(Calendar.YEAR);
                int mMonth = mcurrentDate.get(Calendar.MONTH);
                int mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker;
                mDatePicker = new DatePickerDialog(BookATablePage.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        // TODO Auto-generated method stub
                        /*      Your code   to get date and time    */
                        selectedmonth = selectedmonth + 1;
                        dateEt.setText("" + selectedday + "/" + selectedmonth + "/" + selectedyear);
                    }
                }, mYear, mMonth, mDay);
                mDatePicker.setTitle("Select Date");
                mDatePicker.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                mDatePicker.show();
            }
        });
//        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() -1000);
        timeEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(BookATablePage.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        timeEt.setText( checkDigit(selectedHour) + ":" + checkDigit(selectedMinute));
                    }
                }, hour, minute, false);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });

        resetTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameEt.setText("");
                numberEt.setText("");
                noOfPaxEt.setText("");
                dateEt.setText("");
                timeEt.setText("");
                cB.setChecked(false);
            }
        });


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = "";
                Intent intent = new Intent(BookATablePage.this,OrderConfirmed.class);
                if(!TextUtils.isEmpty(nameEt.getText().toString()))
                {
                    intent.putExtra("name",nameEt.getText().toString());
                    if(!TextUtils.isEmpty(numberEt.getText().toString()))
                    {
                        String number = numberEt.getText().toString();
                        char firstnumber = number.charAt(0);
                        if(firstnumber == '9' || firstnumber == '8')
                        {
                            intent.putExtra("phonenumber",numberEt.getText().toString());
                            if(!TextUtils.isEmpty(noOfPaxEt.getText().toString()))
                            {
                                intent.putExtra("noOfPax",noOfPaxEt.getText().toString());
                                if(!TextUtils.isEmpty(dateEt.getText().toString()))
                                {
                                    intent.putExtra("date",dateEt.getText().toString());
                                    if(!TextUtils.isEmpty(timeEt.getText().toString()))
                                    {
                                        intent.putExtra("time",timeEt.getText().toString());
                                        if(cB.isChecked() == true)
                                        {
                                            String smoking1 = "Table will be near/in the smoking area";
                                            intent.putExtra("addinfo",smoking1);
                                        }
                                        else
                                        {
                                            String smoking2 = "Table will be away from the smoking area";
                                            intent.putExtra("addinfo",smoking2);
                                        }
                                        startActivity(intent);
                                     }
                                    else
                                    {
                                        Toast.makeText(BookATablePage.this,"Please enter a Time",Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else
                                {
                                    Toast.makeText(BookATablePage.this,"Please enter a Date",Toast.LENGTH_SHORT).show();
                                }
                            }
                            else
                            {
                                Toast.makeText(BookATablePage.this,"Please enter number of pax",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(BookATablePage.this,"Please enter the correct number 91234567 e.g.",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(BookATablePage.this,"Please enter your phone number",Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(BookATablePage.this,"Please enter your name",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public String checkDigit(int number) {
        return number <= 9 ? "0" + number : String.valueOf(number);
    }


}
