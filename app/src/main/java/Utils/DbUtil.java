package Utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Model.Order;
import simpleActivity.booking_summary;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;


public class  DbUtil {
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

    public static void getCustomersPendingOrders(Context context){
        String userId = FirebaseAuth.getInstance().getUid();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Orders");
        Query query = reference.orderByChild("CustomerId").equalTo(userId);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot data : dataSnapshot.getChildren()) {
                        try{
                            HashMap<String,Object> orderHashMap;
                            try{
                                 orderHashMap =(HashMap<String,Object>) data.getValue();
                            }
                            catch(Exception e) {
                                Log.d("tag", "exce>> " + e);

                                return;
                            }
                            Order mOrder = new Order();
                            mOrder.date = (String)orderHashMap.get("date");
                            mOrder.address = (String)orderHashMap.get("address");
                            mOrder.price = (String)orderHashMap.get("price");
                            mOrder.description = (String)orderHashMap.get("description");
                            mOrder.CustomerId = (String)orderHashMap.get("CustomerId");
                            mOrder.time = (String)orderHashMap.get("time");
                            mOrder.ServiceProviderName = (String)orderHashMap.get("ServiceProviderName");
                            mOrder.ServiceProviderId = (String)orderHashMap.get("ServiceProviderId");
                            mOrder.ServiceProviderType = (String)orderHashMap.get("ServiceProviderType");

                            //The service is in hashmap. and it cannot be mapped to service
                            mOrder.service = Class.forName("Model.DriverClass").cast(orderHashMap.get("service"));

                            Toast.makeText(context,"data is " + mOrder.toString(), Toast.LENGTH_LONG).show();
                            Log.d("tag", "data is " + mOrder.toString());

                        }catch(Exception e){
                            Log.d("tag", "ex " + e);
                            Toast.makeText(context, "ex " + e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(context, "Cancelled", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
