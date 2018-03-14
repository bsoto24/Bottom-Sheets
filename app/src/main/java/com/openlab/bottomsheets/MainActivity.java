package com.openlab.bottomsheets;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnShowBottomSheet, btnHideBottomSheet, btnShowDialog;
    private CardView cvBottomSheet;
    private BottomSheetBehavior bottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cvBottomSheet = findViewById(R.id.bottomSheet);
        btnShowDialog = findViewById(R.id.btnDialogBottomSheet);
        btnShowBottomSheet = findViewById(R.id.btnShowBottomSheet);
        btnHideBottomSheet = findViewById(R.id.btnHideBottomSheet);

        btnShowDialog.setOnClickListener(v -> {
            BottomSheetDialogFragment bsdFragment = MiBottomSheetDialogFragment.newInstance();
            bsdFragment.show(MainActivity.this.getSupportFragmentManager(), "BSDialog");
        });

        bottomSheetBehavior = BottomSheetBehavior.from(cvBottomSheet);

        btnShowBottomSheet.setOnClickListener(v -> bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED));
        btnHideBottomSheet.setOnClickListener(v -> bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED));
    }

}
