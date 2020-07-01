package com.example.btl1.adapter;

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
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    ArrayList<MonAn> arrMonAn;
    Context context;
    FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
    DatabaseReference mDatabase;

    public FoodAdapter(ArrayList<MonAn> arrMonAn, Context context){
        this.arrMonAn=arrMonAn;
        this.context=context;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    final MonAn monAn=arrMonAn.get(position);
    holder.name.setText(monAn.getTen());
    //holder.price.setText(monAn.getMota()+"Đ");
        //Picasso.with(context).load(monAn.getHinh()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,price;
        ImageView image;
        CardView cardView;
        public ViewHolder(View itemView){
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.textviewTen);
            //price=(TextView)itemView.findViewById(R.id.textviewMoTa);
            //image=(ImageView)itemView.findViewById(R.id.imageviewHinh);

        }
        public void onCreatContextMenu(ContextMenu menu,View v,ContextMenu.ContextMenuInfo menuInfo){
            menu.setHeaderTitle("Lựa chọn option");
            menu.add(this.getAdapterPosition(),121,0,"Xóa món ăn");
            menu.add(this.getAdapterPosition(),122,0,"Cập nhật món ăn");

        }
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View itemView =layoutInflater.inflate(R.layout.dong_mon_an,parent,false);
        return new ViewHolder(itemView);
    }

}
