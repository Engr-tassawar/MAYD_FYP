package Utils;

import android.content.Context;
import android.util.Log;
import android.widget.Adapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Model.DriverClass;
import Model.Order;
import adapters.PendingAdapter;
import simpleActivity.booking_summary;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;


public class  DbUtil {
    public static ArrayList<Order> customerOnGoingOrders = new ArrayList<>();
    public static ArrayList<Order> customerCompletedOrders = new ArrayList<>();
    public static ArrayList<Order> customerCancelledOrders = new ArrayList<>();

    public static void AddOrder(Order order, Context context){
        FirebaseDatabase.getInstance().getReference("Orders")
                .push()
                .setValue(order).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(context,
                                    "Successfully Ordered", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context,
                                    "Error Occurred while ordering", Toast.LENGTH_SHORT).show();
                        }
                    }

                });
    }

    public static void ClearFetchedOrders(){
        customerOnGoingOrders.clear();
        customerCompletedOrders.clear();
        customerCancelledOrders.clear();
    }

    /*public static void ChangeOrderStatus(String Uid , Common.OrderStatus){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Orders");
        //ToDO
       /* reference.child(Uid).child("status").setValue(String.valueOf(Common.OrderStatus));//order started
        finish();*/
    }

