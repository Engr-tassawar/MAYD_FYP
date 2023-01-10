package fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.mayd.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import Model.Order;
import Model.serviceProviderRecord;
import adapters.AdapterServiceUsers;
import simpleActivity.booking_summary;

public class search_fragment extends Fragment {
    RecyclerView recyclerView;
    AdapterServiceUsers adapterServiceUsers;
    Order order;
    /*private MenuItem menuItem;*/
    private SearchView searchView;
    ArrayList<serviceProviderRecord> list = new ArrayList<>();
    FirebaseAuth auth;
    FirebaseDatabase database;

    public search_fragment() {
        // Required empty public constructor
    }

    public static search_fragment newInstance(Order data) {
        search_fragment fragment = new search_fragment();
        Bundle args = new Bundle();
        args.putSerializable("order", data);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        setHasOptionsMenu(true);//to show menu option in fragment
        order = (Order) getArguments().getSerializable(
                "order");
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.navigations_items, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.search_fragment, container, false);
        AdapterServiceUsers adapterServiceUsers = new AdapterServiceUsers(getContext(), list, data -> {
            serviceProviderRecord user = (serviceProviderRecord) data;
            order.ServiceProviderId = user.getUid();
            order.ServiceProviderName = user.getFirstName() + " " + user.getLastName();
            Log.d("tag", "UID for selected service provider is  " + order.ServiceProviderId);

            Intent intent = new Intent(getContext(), booking_summary.class);
            intent.putExtra("orderObject", order);
            startActivity(intent);
            getActivity().finish();
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView = view.findViewById(R.id.users_recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterServiceUsers);
        database.getReference().child("ServiceProviderUsers").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    serviceProviderRecord users = dataSnapshot.getValue(serviceProviderRecord.class);
                    users.setUid(dataSnapshot.getKey());
                    if(Objects.equals(users.getServiceProviderService(), order.ServiceProviderType))
                        list.add(users);
                }
                adapterServiceUsers.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return view;
    }

}