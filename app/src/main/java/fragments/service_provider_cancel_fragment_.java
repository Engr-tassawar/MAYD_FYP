package fragments;

import static Utils.DbUtil.prepareOrder;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

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

import java.util.Objects;

import Model.Order;
import Utils.Common;
import Utils.DbUtil;
import adapters.PendingAdapter;
import simpleActivity.ServiceProviderOrderStatus;


public class service_provider_cancel_fragment_ extends Fragment {

    RecyclerView recyclerView;
    FirebaseAuth auth;
    FirebaseDatabase database;
    PendingAdapter pendingAdapter;
    SwipeRefreshLayout refreshLayout;
    BottomNavigationView bottom_navigation;

    public service_provider_cancel_fragment_() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        bottom_navigation=requireActivity().findViewById(R.id.service_provider_bottomNavigation);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView = view.findViewById(R.id.providerCancel_recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        refreshLayout = view.findViewById(R.id.serviceProviderCancelOrders_refreshLayout);

        refreshLayout.setOnRefreshListener(() -> {
            DbUtil.serviceProviderCancelledOrders.clear();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.service_provider_cancel_fragment_, container, false);
    }

    private void RefreshData() {
        String userId = FirebaseAuth.getInstance().getUid();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Orders");

        Query query = reference.orderByChild("ServiceProviderId").equalTo(userId);

        pendingAdapter = new PendingAdapter(false,DbUtil.serviceProviderCancelledOrders,getContext(),data -> {
            ClickOrder(data);
        });
        recyclerView.setAdapter(pendingAdapter);
        pendingAdapter.notifyDataSetChanged();

        if(DbUtil.serviceProviderCancelledOrders.size() == 0  ){
            DbUtil.ClearServiceProviderFetchedOrders();
            query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        for (DataSnapshot data : dataSnapshot.getChildren()) {

                            Order mOrder = prepareOrder(data.getValue(), data.getKey());

                            if(Objects.equals(mOrder.status, String.valueOf(Common.OrderStatus.OnGoing)))
                                DbUtil.serviceProviderOnGoingOrders.add(mOrder);
                            else if(Objects.equals(mOrder.status, String.valueOf(Common.OrderStatus.Completed)))
                                DbUtil.serviceProviderCompletedOrders.add(mOrder);
                            else if(Objects.equals(mOrder.status, String.valueOf(Common.OrderStatus.Cancelled)))
                                DbUtil.serviceProviderCancelledOrders.add(mOrder);
                        }

                        pendingAdapter = new PendingAdapter(false,DbUtil.serviceProviderCancelledOrders,getContext(),data -> {
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
            pendingAdapter = new PendingAdapter(false,DbUtil.serviceProviderCompletedOrders,getContext(),data->{
                ClickOrder(data);
            });
            recyclerView.setAdapter(pendingAdapter);
            pendingAdapter.notifyDataSetChanged();

            if (refreshLayout.isRefreshing()) {
                refreshLayout.setRefreshing(false);
            }
        }
    }

    private void ClickOrder(Object data) {}
}