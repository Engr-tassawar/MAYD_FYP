package fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mayd.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Model.Order;
import Model.serviceProviderRecord;
import adapters.PendingAdapter;


public class on_going_fragment extends Fragment {
    RecyclerView recyclerView;
    PendingAdapter pendingAdapter;
    ArrayList<Order> list=new ArrayList<>();

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

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_on_going_fragment, container, false);
       /* LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView=getView().findViewById(R.id.pending_Rv);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(pendingAdapter);
        database.getReference().child("Orders").child(auth.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    Order order=dataSnapshot.getValue(Order.class);
                    order.setUid(dataSnapshot.getKey());
                    list.add(order);
                }
                pendingAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/
   return view;
    }
}