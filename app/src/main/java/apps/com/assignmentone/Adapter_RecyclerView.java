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

public class Adapter_RecyclerView extends RecyclerView.Adapter<Adapter_RecyclerView.MyViewHolder> implements Serializable {

    private List<CategoryList> salesItemList;
    protected Context context;
    private SparseBooleanArray selectedItems;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewItemName;
        public ImageView imageViewCategory;

        public MyViewHolder(View view) {
            super(view);
            textViewItemName = (TextView) view.findViewById(R.id.tv_categname);
            imageViewCategory = (ImageView) view.findViewById(R.id.iv_category);
        }
    }

    public Adapter_RecyclerView(Context context,List<CategoryList> moviesList) {
        this.salesItemList = moviesList;
        this.context = context;
    }

    @Override
    public Adapter_RecyclerView.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Adapter_RecyclerView.MyViewHolder viewHolder = null;

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        viewHolder = new Adapter_RecyclerView.MyViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Adapter_RecyclerView.MyViewHolder holder, int position) {
        CategoryList table = salesItemList.get(position);
        Picasso.with(context).load("http://via.placeholder.com/350x150").into(holder.imageViewCategory);
        holder.textViewItemName.setText(table.getStringCategoryName());
//        holder.imageViewCategory.set("\u20B9" + table.getStringTotal());
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




