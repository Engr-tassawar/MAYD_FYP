package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mayd.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Model.Order;

public class PendingAdapter extends RecyclerView.Adapter<PendingAdapter.viewHolder>{
    ArrayList<Order> list;
    Context context;

    public PendingAdapter(ArrayList<Order> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.pending_recycler_views,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
     Order order=list.get(position);
     holder.pending_date.setText(order.date);
     //holder.pending_service.setText(order.ServiceProviderType);
     holder.pending_time.setText(order.time);
     holder.pending_providerName.setText(order.ServiceProviderName);
     holder.pending_address.setText(order.address);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView pending_date,pending_service,pending_contact,pending_time,pending_providerName,
                pending_address;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            pending_date=itemView.findViewById(R.id.pending_date);
            pending_service=itemView.findViewById(R.id.pending_service);
            pending_contact=itemView.findViewById(R.id.pending_contact);
            pending_time=itemView.findViewById(R.id.pending_time);
            pending_providerName=itemView.findViewById(R.id.pending_providerName);
            pending_address=itemView.findViewById(R.id.pending_address);
        }
    }
}
