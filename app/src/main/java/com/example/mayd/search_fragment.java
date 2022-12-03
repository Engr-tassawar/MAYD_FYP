package com.example.mayd;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Model.serviceProviderRecord;
import adapters.AdapterServiceUsers;
import simpleActivity.customer_registration;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link search_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class search_fragment extends Fragment {
    RecyclerView recyclerView;
    AdapterServiceUsers adapterServiceUsers;
/*private MenuItem menuItem;*/
private SearchView searchView;
    ArrayList<serviceProviderRecord> list=new ArrayList<>();
    FirebaseAuth auth;
    FirebaseDatabase database;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public search_fragment() {
        // Required empty public constructor
    }

    public static search_fragment newInstance(String param1, String param2) {
        search_fragment fragment = new search_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        setHasOptionsMenu(true);//to show menu option in fragment
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.navigations_items,menu);

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
        View view= inflater.inflate(R.layout.search_fragment, container, false);
        AdapterServiceUsers adapterServiceUsers=new AdapterServiceUsers(getContext(),list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        searchView=view.findViewById(R.id.SearchView);
        recyclerView=view.findViewById(R.id.users_recyclerView);
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
        List<serviceProviderRecord> filteredList=new ArrayList<>();
        for (serviceProviderRecord item:list){
            if (item.getFirstName().toLowerCase().contains(s.toLowerCase()))
            {
                filteredList.add(item);
            }
        }
        if (filteredList.isEmpty()){
            Toast.makeText(getContext(),
                    "No data found", Toast.LENGTH_SHORT).show();

        }
        else {


/*
            AdapterServiceUsers.setFilteredItem(filteredList);
*/


        }
    }


}