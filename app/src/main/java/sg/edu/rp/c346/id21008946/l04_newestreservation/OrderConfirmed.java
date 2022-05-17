package sg.edu.rp.c346.id21008946.l04_newestreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OrderConfirmed extends AppCompatActivity {

    Button homeBtn;
    TextView resultTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmed);

        homeBtn = findViewById(R.id.homeBtn);
        resultTv = findViewById(R.id.finalresultTv);

        Intent intent = getIntent();
        String result = String.format("Name: %s\nPhone Number : +65%s\nNo of Pax: %s\nDate: %s\nTime: %s\nAdditonal Info:\n%s",intent.getStringExtra("name")
                ,intent.getStringExtra("phonenumber"),intent.getStringExtra("noOfPax"),intent.getStringExtra("date")
                ,intent.getStringExtra("time"),intent.getStringExtra("addinfo"));
        resultTv.setText(result);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderConfirmed.this,HomeScreen.class);
                startActivity(intent);
            }
        });

    }
}