package Adapter;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btl1.R;
import com.example.btl1.Food;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import Interface.ItemClickListener;

public class FoodAdapter_c extends RecyclerView.Adapter<FoodAdapter_c.ViewHolder> {
    ArrayList<Food> arrMonAn;
    Context context;
    FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
    Query mDatabase;


    public FoodAdapter_c(ArrayList<Food> arrMonAn, Context context){
        this.arrMonAn=arrMonAn;
        this.context=context;
    }
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Food Food=arrMonAn.get(position);
        holder.name.setText(Food.getName());
        holder.price.setText(Food.getPrice()+"Đ");
        Picasso.with(context).load(Food.getImage()).into(holder.image);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if(!isLongClick){
                    Toast.makeText(context, "Đã chọn "+arrMonAn.get(position).getName(), Toast.LENGTH_SHORT).show();

                }

            }

        });

    }

    @Override
    public int getItemCount() {
        return arrMonAn.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener,View.OnClickListener {
        TextView name, price;
        ImageView image;
        private ItemClickListener itemClickListener;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name = (TextView) itemView.findViewById(R.id.textviewTen);
            price = (TextView) itemView.findViewById(R.id.textviewMoTa);
            image = (ImageView) itemView.findViewById(R.id.imageviewHinh);

        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {

        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), false);
        }
    }
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View itemView = layoutInflater.inflate(R.layout.dong_mon_an, parent, false);

            return new ViewHolder(itemView);
        }

    }



