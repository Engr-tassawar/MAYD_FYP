package simpleActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mayd.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

import Model.Order;
import Utils.Common;
import Utils.DbUtil;
import adapters.PendingAdapter;

public class ServiceProviderOrderStatus extends AppCompatActivity {

    Button startOrder, completeOrder;
    Order mOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_order_status);

        startOrder = findViewById(R.id.btnStartOrder);
        completeOrder = findViewById(R.id.btnCompleteOrder);

        mOrder = Common.getOrderObject(ServiceProviderOrderStatus.this);

        startOrder.setOnClickListener(view -> {

            new AlertDialog.Builder(this)
                    .setIcon(R.drawable.ic_baseline_warning_24)
                    .setTitle("Start Order")
                    .setMessage(("Are you sure you want to start order?"))
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Toast.makeText(ServiceProviderOrderStatus.this, "Will decide it at ", Toast.LENGTH_SHORT).show();
                         /*   String userId = FirebaseAuth.getInstance().getUid();
                            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Orders");
                            reference.child(mOrder.Uid).child("status").setValue(Common.OrderStatus.Completed);//order started

                            finish();*/
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();


        });

        completeOrder.setOnClickListener(view -> {

            new AlertDialog.Builder(this)
                    .setIcon(R.drawable.ic_baseline_warning_24)
                    .setTitle("Complete Order")
                    .setMessage(("Are you sure your order is completed?"))
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Orders");
                            reference.child(mOrder.Uid).child("status").setValue(Common.OrderStatus.Completed);//order started
                            finish();
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();


        });

    }
}