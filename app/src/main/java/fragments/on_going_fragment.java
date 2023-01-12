package fragments;

import android.content.Intent;
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

import Model.Order;
import Model.serviceProviderRecord;
import Utils.Common;
import Utils.DbUtil;
import adapters.PendingAdapter;
import simpleActivity.ServiceProviderOrderStatus;
import simpleActivity.booking_summary;


public class on_going_fragment extends Fragment {
    RecyclerView recyclerView;
    PendingAdapter serviceProviderPendingAdapter;
    ArrayList<Order> ordersList=new ArrayList<>();
    FirebaseAuth auth;
    FirebaseDatabase database;

    public on_going_fragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        ordersList=new ArrayList<>();

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView = view.findViewById(R.id.providerOngoing_recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        String userId = FirebaseAuth.getInstance().getUid();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Orders");
        Query query = reference.orderByChild("ServiceProviderId").equalTo(userId);

            query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        for (DataSnapshot data : dataSnapshot.getChildren()) {

                            Order sOrder = DbUtil.prepareOrder(data.getValue(), data.getKey());
                            ordersList.add(sOrder);
                        }


                        serviceProviderPendingAdapter = new PendingAdapter(ordersList,getContext(), data -> {
                            Toast.makeText(getContext(), "Please confirm", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(requireActivity(),ServiceProviderOrderStatus.class);
                            Common.sendOrderObjectToNextActivity(intent,(Order)data);
                            startActivity(intent);
            /*serviceProviderRecord user = (serviceProviderRecord) data;
            order.ServiceProviderId = user.getUid();
            order.ServiceProviderName = user.getFirstName() + " " + user.getLastName();
            Log.d("tag", "UID for selected service provider is  " + order.ServiceProviderId);

            Intent intent = new Intent(getContext(), booking_summary.class);
            intent.putExtra("orderObject", order);
            startActivity(intent);
            getActivity().finish();*/
                        });


                        //serviceProviderPendingAdapter = new PendingAdapter(ordersList,getContext());
                        recyclerView.setAdapter(serviceProviderPendingAdapter);
                        serviceProviderPendingAdapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(getContext(), "Cancelled", Toast.LENGTH_SHORT).show();

                }
            });


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_on_going_fragment, container, false);

   return view;
    }
}