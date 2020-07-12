package ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btl1.R;

import Interface.ItemClickListener;

public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView foodName;
    public ImageView foodImage;
    private ItemClickListener itemClickListener;



    public FoodViewHolder(@NonNull View itemView) {
        super(itemView);

        foodName=(TextView) itemView.findViewById(R.id.foodName);
        foodImage=(ImageView) itemView.findViewById(R.id.foodImage);

        itemView.setOnClickListener(this);
    }
    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
    @Override
    public void onClick(View view) {

            itemClickListener.onClick(view,getAdapterPosition(),false);
    }
}
