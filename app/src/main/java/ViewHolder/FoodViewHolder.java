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
    public TextView foodPrice;

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public FoodViewHolder(@NonNull View itemView) {
        super(itemView);

        foodName=(TextView) itemView.findViewById(R.id.food_name);
        foodImage=(ImageView) itemView.findViewById(R.id.food_image);
        foodPrice=(TextView) itemView.findViewById(R.id.food_price);
    }

    @Override
    public void onClick(View view) {

    }
}
