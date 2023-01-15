package fragments;


import static Utils.DbUtil.prepareOrder;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mayd.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import Model.DriverClass;
import Model.Order;
import Utils.Common;
import Utils.DbUtil;
import adapters.PendingAdapter;


public class customer_on_going_fragment extends Fragment {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public customer_on_going_fragment() {
        // Required empty public constructor
    }
    RecyclerView recyclerView;
    PendingAdapter pendingAdapter;
    FirebaseAuth auth;
    FirebaseDatabase database;
    SwipeRefreshLayout refreshLayout;
    BottomNavigationView bottom_navigation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_customer_on_going_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bottom_navigation=requireActivity().findViewById(R.id.bottomNavigation);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView = view.findViewById(R.id.customerPendingOrders_recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        refreshLayout = view.findViewById(R.id.customerOnGoingOrders_refreshLayout);

        refreshLayout.setOnRefreshListener(() -> {
            DbUtil.customerOnGoingOrders.clear();
            RefreshData();

        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0 && bottom_navigation.isShown()) {
                    bottom_navigation.setVisibility(View.GONE);
                } else if (dy < 0 ) {
                    bottom_navigation.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                super.onScrollStateChanged(recyclerView, newState);
            }
        });
        RefreshData();

    }

    private void RefreshData() {
        String userId = FirebaseAuth.getInstance().getUid();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Orders");
        Query query = reference.orderByChild("CustomerId").equalTo(userId);
        pendingAdapter = new PendingAdapter(true,DbUtil.customerOnGoingOrders,getContext(),data -> {
            ClickOrder(data);
        });
        //pendingAdapter.clear();
        recyclerView.setAdapter(pendingAdapter);
        pendingAdapter.notifyDataSetChanged();

        if(DbUtil.customerOnGoingOrders.size() == 0  ){
            DbUtil.customerCancelledOrders.clear();
            DbUtil.customerCompletedOrders.clear();
            query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        for (DataSnapshot data : dataSnapshot.getChildren()) {

                            Order mOrder = prepareOrder(data.getValue(), data.getKey());

                            if(Objects.equals(mOrder.status, String.valueOf(Common.OrderStatus.OnGoing)))
                                DbUtil.customerOnGoingOrders.add(mOrder);
                            else if(Objects.equals(mOrder.status, String.valueOf(Common.OrderStatus.Completed)))
                                DbUtil.customerCompletedOrders.add(mOrder);
                            else if(Objects.equals(mOrder.status, String.valueOf(Common.OrderStatus.Cancelled)))
                                DbUtil.customerCancelledOrders.add(mOrder);
                        }

                        pendingAdapter = new PendingAdapter(true,DbUtil.customerOnGoingOrders,getContext(),data -> {
                            ClickOrder(data);
                        });
                        recyclerView.setAdapter(pendingAdapter);
                        pendingAdapter.notifyDataSetChanged();
                        if (refreshLayout.isRefreshing()) {
                            refreshLayout.setRefreshing(false);
                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(getContext(), "Cancelled", Toast.LENGTH_SHORT).show();

                }
            });
        }

        else{
            pendingAdapter = new PendingAdapter(true,DbUtil.customerOnGoingOrders,getContext(),data->{
                ClickOrder(data);
            });
            recyclerView.setAdapter(pendingAdapter);
            pendingAdapter.notifyDataSetChanged();

            if (refreshLayout.isRefreshing()) {
                refreshLayout.setRefreshing(false);
            }
        }
    }

    private void ClickOrder(Object data) {
        if(data == null)
            return;

        try {
            Order order = (Order)data;
            if(order.Uid == null )
                return;

            //ToDo: Make activity with name DisplayOrderInfo
           /* Intent intent = new Intent(requireActivity(),DisplayOrderInfo.class);
            Common.sendOrderObjectToNextActivity(intent,order);
            startActivity(intent);*/

            new AlertDialog.Builder(requireContext())
                    .setIcon(R.drawable.ic_baseline_warning_24)
                    .setTitle("Cancel Order")
                    .setMessage(("Are you sure you want to cancel order?"))
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Orders");
                            reference.child(order.Uid).child("status").setValue(Common.OrderStatus.Cancelled);
                            DbUtil.customerOnGoingOrders.clear();
                            RefreshData();
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();

        }
        catch(Exception e){
            Toast.makeText(requireContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }


}