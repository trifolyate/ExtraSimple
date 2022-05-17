package sg.edu.rp.c346.id21008946.l04_newestreservation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class popupwindow2 extends AppCompatActivity {

    Button btn;
    AlertDialog.Builder dialogBuilder;
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popupwindow2);

        btn = findViewById(R.id.btn1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPopUpWindow();
            }
        });

    }

    public void createPopUpWindow()
    {
        dialogBuilder = new AlertDialog.Builder(this);
        final View PopUpView = getLayoutInflater().inflate(R.layout.activity_popupwindow,null);
        dialogBuilder.setView(PopUpView);
        dialog = dialogBuilder.create();
        dialog.show();
    }
}