package adapters;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mayd.R;
import com.example.mayd.databinding.UsersSampleBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

import java.util.List;

import Model.serviceProviderRecord;


public class AdapterServiceUsers extends RecyclerView.Adapter<AdapterServiceUsers.viewHolder> {

    Context context;
    List<serviceProviderRecord> list;
    private final ItemClickListener itemClickListener;

    public AdapterServiceUsers(Context context, List<serviceProviderRecord> list, ItemClickListener listener) {
        this.context = context;
        this.list = list;
        this.itemClickListener = listener;
    }



    /*public static void setFilteredItem(List<serviceProviderRecord> filteredItem)
    {
        this.list=filteredItem;
        notifyDataSetChanged();
    }*/
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.users_sample,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
       serviceProviderRecord users=list.get(position);

       Picasso.get().load(users.getServiceProviderProfile())
        .placeholder(R.drawable.profile_image_b)
        .into(holder.binding.AllServiceProviderImgV);
       holder.binding.nameTv.setText(users.getFirstName()+users.getLastName());
       holder.binding.serviceTv.setText(users.getServiceProviderService());

       holder.itemView.setOnClickListener(view ->{
           itemClickListener.onItemClick(users);
       });

/*
       holder.binding.phoneTv.setText(FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber());
*/


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface ItemClickListener{
        void onItemClick(Object data);
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        UsersSampleBinding binding;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            binding=UsersSampleBinding.bind(itemView);
        }


    }
}

