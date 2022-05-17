package sg.edu.rp.c346.id21008946.l04_newestreservation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class HomeScreen extends AppCompatActivity {

    Button bookAtable;
    BottomSheetDialog mainDialog;
//    AlertDialog.Builder dialogBuilder;
//    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        bookAtable = findViewById(R.id.bookAtable);
        mainDialog = new BottomSheetDialog(this,R.style.BottomSheetDialogTheme);
//       createDialog();



        bookAtable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mainDialog.show();
//                createPopUpWindow();
                Intent intent = new Intent(HomeScreen.this,BookATablePage.class);
                startActivity(intent);

                overridePendingTransition(R.anim.slide_up_in,R.anim.slide_up_out);
            }
        });
    }

//    private void createDialog()
//    {
//        View view = getLayoutInflater().inflate(R.layout.activity_bottom_dialog,null,false);
//        mainDialog.setContentView(view);
//    }
//
//    public void createPopUpWindow()
//    {
//        dialogBuilder = new AlertDialog.Builder(this);
//        final View PopUpView = getLayoutInflater().inflate(R.layout.activity_popupwindow2,null);
//        dialogBuilder.setView(PopUpView);
//        dialog = dialogBuilder.create();
//        dialog.show();
//    }



}
