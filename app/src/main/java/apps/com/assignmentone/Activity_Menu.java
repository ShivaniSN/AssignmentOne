package apps.com.assignmentone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Activity_Menu extends AppCompatActivity{

    ImageView imageViewBack;
    RecyclerView recyclerView;
    TextView textViewMenuHeader;

    String stringCategoryName = "";
    Adapter_RecyclerMenu adapter;
    List<CategoryList> categoryList =  new ArrayList<CategoryList>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        recyclerView = (RecyclerView) findViewById(R.id.rvmenu);
        imageViewBack = (ImageView) findViewById(R.id.iv_back);
        textViewMenuHeader = (TextView) findViewById(R.id.tv_header);

        stringCategoryName = getIntent().getStringExtra("Header");

        textViewMenuHeader.setText(stringCategoryName);

        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Menu.this, Activity_Main.class);
                startActivity(intent);
            }
        });

        //recycler view code
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        adapter = new Adapter_RecyclerMenu(Activity_Menu.this,categoryList);
        recyclerView.setAdapter(adapter);

        categoryList.add(new CategoryList(getIntent().getStringExtra("product1")));
        categoryList.add(new CategoryList(getIntent().getStringExtra("product2")));
            if (getIntent().hasExtra("product3")) {
                categoryList.add(new CategoryList(getIntent().getStringExtra("product3")));
            }
            if (getIntent().hasExtra("product4")) {
                categoryList.add(new CategoryList(getIntent().getStringExtra("product4")));
            }
            if (getIntent().hasExtra("product5")) {
                categoryList.add(new CategoryList(getIntent().getStringExtra("product5")));
            }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Activity_Menu.this, Activity_Main.class);
        startActivity(intent);
    }
}
