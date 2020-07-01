package com.example.btl1;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btl1.MonAn;
import com.example.btl1.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FoodAdapter_c extends RecyclerView.Adapter<FoodAdapter_c.ViewHolder> {
    ArrayList<food> arrMonAn;
    Context context;
    FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
    Query mDatabase;

    public FoodAdapter_c(ArrayList<food> arrMonAn, Context context){
        this.arrMonAn=arrMonAn;
        this.context=context;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final food Food=arrMonAn.get(position);
        holder.name.setText(Food.getName());
        holder.price.setText(Food.getPrice()+"Đ");
        Picasso.with(context).load(Food.getImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return arrMonAn.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        TextView name,price;
        ImageView image;
        CardView cardView;
        public ViewHolder(View itemView){
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.textviewTen);
            price=(TextView)itemView.findViewById(R.id.textviewMoTa);
            image=(ImageView)itemView.findViewById(R.id.imageviewHinh);

        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {

        }
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View itemView =layoutInflater.inflate(R.layout.dong_mon_an,parent,false);
        return new ViewHolder(itemView);
    }

}
