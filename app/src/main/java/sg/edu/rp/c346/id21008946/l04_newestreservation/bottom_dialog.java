package sg.edu.rp.c346.id21008946.l04_newestreservation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bottom_dialog extends AppCompatActivity {
    Button test;
    EditText nameEt;
    EditText numberEt;
    EditText NoPaxEt;
    TextView view1;
    TextView view2;
    TextView showText;
    AlertDialog.Builder dialogBuilder;
    AlertDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_dialog);

        test = findViewById(R.id.test);
        nameEt = findViewById(R.id.nameEt);
        numberEt = findViewById(R.id.NoOfPaxEt);
        NoPaxEt = findViewById(R.id.NoOfPaxEt);
        showText = findViewById(R.id.showText);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showText.setText("hello");
            }
        });
    }

    public void createPopUpWindow()
    {
        dialogBuilder = new AlertDialog.Builder(this);
        final View PopUpView = getLayoutInflater().inflate(R.layout.activity_popupwindow2,null);
        nameEt = findViewById(R.id.nameEt);
        numberEt = findViewById(R.id.NoOfPaxEt);
        NoPaxEt = findViewById(R.id.NoOfPaxEt);

        dialogBuilder.setView(PopUpView);
        dialog = dialogBuilder.create();
        dialog.show();
    }
}