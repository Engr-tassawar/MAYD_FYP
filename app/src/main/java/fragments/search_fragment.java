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

import Model.Order;
import Model.serviceProviderRecord;
import adapters.AdapterServiceUsers;
import simpleActivity.booking_summary;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link search_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
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

        /*searchView=(SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setIconified(true);
        SearchManager searchManager= (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                mySearch(s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                mySearch(s);
                return true;
            }
        });*/
        super.onCreateOptionsMenu(menu, inflater);
    }

 /*   private void mySearch(String s) {

        AdapterServiceUsers adapterServiceUsers=new AdapterServiceUsers(getContext(),list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView=recyclerView.findViewById(R.id.users_recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterServiceUsers);
        database.getReference().child("ServiceProviderUsers").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    serviceProviderRecord users=dataSnapshot.getValue(serviceProviderRecord.class);
                    users.setUid(dataSnapshot.getKey());
                    list.add(users);
                }
                adapterServiceUsers.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }*/

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
        searchView = view.findViewById(R.id.SearchView);
        recyclerView = view.findViewById(R.id.users_recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterServiceUsers);
        //ToDO: Change the query to get service providers depending upon service type
        database.getReference().child("ServiceProviderUsers").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    serviceProviderRecord users = dataSnapshot.getValue(serviceProviderRecord.class);
                    users.setUid(dataSnapshot.getKey());
                    list.add(users);
                }
                adapterServiceUsers.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filterList(s);
                return false;
            }
        });

   /*recyclerView=view.findViewById(R.id.users_recyclerView);
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    usersList =new ArrayList<>();
    getAllUsers();*/
        return view;
    }

    private void filterList(String s) {
        List<serviceProviderRecord> filteredList = new ArrayList<>();
        for (serviceProviderRecord item : list) {
            if (item.getFirstName().toLowerCase().contains(s.toLowerCase())) {
                filteredList.add(item);
            }
        }
        if (filteredList.isEmpty()) {
            Toast.makeText(getContext(),
                    "No data found", Toast.LENGTH_SHORT).show();

        } else {


/*
            AdapterServiceUsers.setFilteredItem(filteredList);
*/


        }
    }


}