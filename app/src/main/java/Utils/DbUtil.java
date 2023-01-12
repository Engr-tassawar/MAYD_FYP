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

    public static void AddOrder(Order order, Context context) {

       SetContactInfo(order,context);


    }

    private static void SetContactInfo(Order order, Context context) {
        String userId = FirebaseAuth.getInstance().getUid();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("CustomerUsers");
        Query query = reference.orderByChild("customerPhone");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        for (DataSnapshot data : dataSnapshot.getChildren()) {

                            HashMap<String,Object> customers;
                            customers =(HashMap<String,Object>) data.getValue();


                            String id = data.getKey();

                            if(Objects.equals(id, userId)){
                                order.CustomerContact = (String)customers.get("customerPhone");
                                saveOrderInDB(order, context);
                                break;
                            }


                        }


                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        /*userId = FirebaseAuth.getInstance().getUid();
        reference = FirebaseDatabase.getInstance().getReference("Orders");
        query = reference.orderByChild("CustomerId").equalTo(userId);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot data : dataSnapshot.getChildren()) {

                        HashMap<String,Object> customers;
                        customers =(HashMap<String,Object>) data.getValue();
                        Order mOrder = new Order();

                        mOrder.CustomerContact = (String)customers.get("customerPhone");

                        Toast.makeText(context,
                                "Phone Number is "+ mOrder.CustomerContact, Toast.LENGTH_SHORT).show();

                    }


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/



    }

    private static void saveOrderInDB(Order order, Context context){
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

    public static void ClearFetchedOrders() {
        customerOnGoingOrders.clear();
        customerCompletedOrders.clear();
        customerCancelledOrders.clear();
    }

    public static Order prepareOrder(Object order,String UiD) {
        HashMap<String,Object> orderHashMap;
        orderHashMap =(HashMap<String,Object>) order;
        Order mOrder = new Order();
        mOrder.date = (String)orderHashMap.get("date");
        mOrder.Uid = UiD;
        mOrder.address = (String)orderHashMap.get("address");
        mOrder.price = (String)orderHashMap.get("price");
        mOrder.description = (String)orderHashMap.get("description");
        mOrder.CustomerId = (String)orderHashMap.get("CustomerId");
        mOrder.time = (String)orderHashMap.get("time");
        mOrder.ServiceProviderName = (String)orderHashMap.get("ServiceProviderName");
        mOrder.ServiceProviderId = (String)orderHashMap.get("ServiceProviderId");
        mOrder.ServiceProviderType = (String)orderHashMap.get("ServiceProviderType");
        mOrder.status = (String)orderHashMap.get("status");
        mOrder.CustomerContact = (String)orderHashMap.get("CustomerContact");
        return mOrder;
    }

    public static void ChangeOrderStatus(String Uid , Common.OrderStatus status) {

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Orders");
        String orderStatus = String.valueOf(status);
        reference.child(Uid).child("status").setValue(orderStatus);
    }
}