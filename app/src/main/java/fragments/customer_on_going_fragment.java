package fragments;

import static Utils.DbUtil.Parser;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.mayd.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

import Model.DriverClass;
import Model.Order;
import Model.serviceProviderRecord;
import Utils.Common;
import Utils.DbUtil;
import adapters.AdapterServiceUsers;
import adapters.PendingAdapter;


public class customer_on_going_fragment extends Fragment {

    public customer_on_going_fragment() {
        // Required empty public constructor
    }
    RecyclerView recyclerView;
    PendingAdapter pendingAdapter;
    ArrayList<Order> list = new ArrayList<>();
    FirebaseAuth auth;
    FirebaseDatabase database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customer_on_going_fragment, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView = view.findViewById(R.id.customerPendingOrders_recyclerView);
        recyclerView.setLayoutManager(layoutManager);

        String userId = FirebaseAuth.getInstance().getUid();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Orders");
        Query query = reference.orderByChild("CustomerId").equalTo(userId);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot data : dataSnapshot.getChildren()) {

                            HashMap<String,Object> orderHashMap;
                            orderHashMap =(HashMap<String,Object>) data.getValue();
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

                            HashMap<String,String> Service = (HashMap<String,String>)orderHashMap.get("service");
                            mOrder.service = Parser(mOrder.ServiceProviderType,Service);
                            //mOrder.service = Class.forName(mOrder.ServiceProviderType).cast(mOrder.service);
                            DriverClass driver = (Model.DriverClass)mOrder.service;
                            Toast.makeText(getContext(),"driver is  " + driver, Toast.LENGTH_LONG).show();
                            //Log.d("tag", "data is " + mOrder.ServiceProviderType);

                            list.add(mOrder);
                            pendingAdapter = new PendingAdapter(list,getContext());
                            recyclerView.setAdapter(pendingAdapter);
                            pendingAdapter.notifyDataSetChanged();


                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getContext(), "Cancelled", Toast.LENGTH_SHORT).show();

            }
        });
    }
}