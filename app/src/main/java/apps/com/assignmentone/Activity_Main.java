package apps.com.assignmentone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Activity_Main extends AppCompatActivity {
    // Layout declarations
    CarouselView carouselView;
    RecyclerView recyclerView;
    // backend declarations
    int[] sampleImages = {R.drawable.image_one, R.drawable.image_three,
            R.drawable.image_four ,R.drawable.image_six};
    Adapter_RecyclerView adapter;
    List<CategoryList> categoryList =  new ArrayList<CategoryList>();
    CreateJSON createJSONObj = new CreateJSON();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carouselView = (CarouselView) findViewById(R.id.carouselView);
        recyclerView = (RecyclerView) findViewById(R.id.rvNumbers);

        //carousel view code
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);
        //recycler view code
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new Adapter_RecyclerView(Activity_Main.this,categoryList);
        recyclerView.setAdapter(adapter);
        //call to JSON data
        parseJSON();
        //recycler view on touch event handling
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(Activity_Main.this, new RecyclerTouchListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(Activity_Main.this, Activity_Menu.class);
                intent.putExtra("Header",categoryList.get(position).getStringCategoryName());
                intent.putExtra("product1",categoryList.get(position).getStringProduct1());
                intent.putExtra("product2",categoryList.get(position).getStringProduct2());
                intent.putExtra("product3",categoryList.get(position).getStringProduct3());
                intent.putExtra("product4",categoryList.get(position).getStringProduct4());
                intent.putExtra("product5",categoryList.get(position).getStringProduct5());
                startActivity(intent);
            }
        }));
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

    public void parseJSON(){
        try {
            JSONObject infoObj = createJSONObj.createJSON();
            JSONObject categoryObj = new JSONObject(infoObj.getString("info"));
            JSONArray categoryArrayObj = new JSONArray(categoryObj.getString("Category"));
            for (int i=0;i<categoryArrayObj.length();i++){
                JSONObject categObj = categoryArrayObj.getJSONObject(i);
                CategoryList lpg = new CategoryList();

                lpg.setStringCategoryName(categObj.getString("category"));
                lpg.setStringProduct1(categObj.getString("product1"));
                lpg.setStringProduct2(categObj.getString("product2"));
                if (categObj.has("product3")) {
                    lpg.setStringProduct3(categObj.getString("product3"));
                }
                if (categObj.has("product4")) {
                    lpg.setStringProduct4(categObj.getString("product4"));
                }
                if (categObj.has("product5")) {
                    lpg.setStringProduct5(categObj.getString("product5"));
                }
                categoryList.add(lpg);
            }
            adapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
