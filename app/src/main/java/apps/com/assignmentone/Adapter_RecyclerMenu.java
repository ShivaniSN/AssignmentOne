package apps.com.assignmentone;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Adapter_RecyclerMenu extends RecyclerView.Adapter<Adapter_RecyclerMenu.MyViewHolder> implements Serializable {

    private List<CategoryList> salesItemList;
    protected Context context;
    private SparseBooleanArray selectedItems;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewItemName;
        public ImageView imageView;

        public MyViewHolder(View view) {
            super(view);
            textViewItemName = (TextView) view.findViewById(R.id.tv_product);
            imageView = (ImageView)view.findViewById(R.id.iv_image);
        }
    }

    public Adapter_RecyclerMenu(Context context,List<CategoryList> moviesList) {
        this.salesItemList = moviesList;
        this.context = context;
    }

    @Override
    public Adapter_RecyclerMenu.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Adapter_RecyclerMenu.MyViewHolder viewHolder = null;

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item_menu, parent, false);
        viewHolder = new Adapter_RecyclerMenu.MyViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Adapter_RecyclerMenu.MyViewHolder holder, int position) {
        CategoryList table = salesItemList.get(position);
        holder.textViewItemName.setText(table.getStringCategoryName());
        holder.imageView.setBackgroundResource(R.drawable.product);
    }

    @Override
    public int getItemCount() {
        return salesItemList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return salesItemList.get(position) != null ? 1 : 0;
    }

    public void toggleSelection(int pos) {
        if (selectedItems.get(pos, false)) {
            selectedItems.delete(pos);
        }
        else {
            selectedItems.put(pos, true);
        }
        notifyItemChanged(pos);
    }

    public void clearSelections() {
        selectedItems.clear();
        notifyDataSetChanged();
    }

    public int getSelectedItemCount() {
        return selectedItems.size();
    }

    public List<Integer> getSelectedItems() {
        List<Integer> items =
                new ArrayList<Integer>(selectedItems.size());
        for (int i = 0; i < selectedItems.size(); i++) {
            items.add(selectedItems.keyAt(i));
        }
        return items;
    }
}





