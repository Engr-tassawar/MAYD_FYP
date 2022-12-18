package simpleActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mayd.R;
import com.google.firebase.auth.FirebaseAuth;

import Model.DriverClass;
import Model.Order;
import Utils.Common;
import Utils.DbUtil;

public class booking_summary extends AppCompatActivity {
    Button btn_confirmBookSummary;
    TextView bookingSummaryService, bookingSummaryPrice, bookingSummaryLocation, bookingSummaryTime, bookingSummaryServiceProviderName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_summary);

        Intent intent = getIntent();
        Order order = (Order) intent.getExtras().getSerializable("orderObject");

        btn_confirmBookSummary = findViewById(R.id.btn_confirmBookSummary);
        bookingSummaryService = findViewById(R.id.bookingSummaryService);
        bookingSummaryPrice = findViewById(R.id.bookingSummaryPrice);
        bookingSummaryLocation = findViewById(R.id.bookingSummaryLocation);
        bookingSummaryTime = findViewById(R.id.bookingSummaryTimeTV);
        bookingSummaryServiceProviderName = findViewById(R.id.orderedServiceProviderNameTv);

        bookingSummaryService.setText(order.ServiceProviderType);
        bookingSummaryPrice.setText(order.price);
        bookingSummaryLocation.setText(order.address);
        bookingSummaryTime.setText(order.time);
        bookingSummaryServiceProviderName.setText(order.ServiceProviderName);



        btn_confirmBookSummary.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(booking_summary.this)
                        .setTitle("Confirm")
                        .setMessage(("Are you sure to confirm your booking?"))
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                order.CustomerId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                                DbUtil.AddOrder(order, booking_summary.this);

                                Dialog dialog = new Dialog(booking_summary.this);
                                dialog.setContentView(R.layout.success_alert_dialog);
                                AppCompatButton btn_success = dialog.findViewById(R.id.btn_success);
                                dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimationReport;
                                dialog.getWindow().setBackgroundDrawableResource(R.color.black);
                                btn_success.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        dialog.dismiss();
                                        finish();
                                    }
                                });
                                dialog.show();


                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_baseline_warning_24)
                .setTitle("Exit")
                .setMessage(("Are you sure to want exit?"))
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

}