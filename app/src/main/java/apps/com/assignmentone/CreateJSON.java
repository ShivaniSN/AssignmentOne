package apps.com.assignmentone;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CreateJSON {
    public JSONObject createJSON() throws JSONException {
        JSONObject category1 = new JSONObject();
        try {
            category1.put("category", "Fusion Box");
            category1.put("product1", "Dal Makhni Rice Box");
            category1.put("product2", "Chole Chawal Box");
            category1.put("product3", "Rajma Chawal Box");
            category1.put("product4", "Grilled Tikki Box");
            category1.put("product5", "Paneer Masala Box");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject category2 = new JSONObject();
        try {
            category2.put("category", "Curries");
            category2.put("product1", "Basmati Rice");
            category2.put("product2", "Tawa Paratha");
            category2.put("product3", "Kadhai Paneer");
            category2.put("product4", "Raita");
            category2.put("product5", "Butter Chicken");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject category3 = new JSONObject();
        try {
            category3.put("category", "Biryani");
            category3.put("product1", "Sahi Panner Biryani");
            category3.put("product2", "Firangi Subz Biryani");
            category3.put("product3", "Chicken Tikka Biryani");
            category3.put("product4", "Murg Dum Biryani");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject category4 = new JSONObject();
        try {
            category4.put("category", "Wraps");
            category4.put("product1", "Paneer Wrap");
            category4.put("product2", "Chicken Wrap");
            category4.put("product3", "Mayo Wrap");
            category4.put("product4", "Tikki Wrap");
            category4.put("product5", "Patty Wrap");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject category5 = new JSONObject();
        try {
            category5.put("category", "Ice Cream");
            category5.put("product1", "Tender CocoNut");
            category5.put("product2", "Sheer Khurma");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        JSONArray categoryArray = new JSONArray();
        categoryArray.put(category1);
        categoryArray.put(category2);
        categoryArray.put(category3);
        categoryArray.put(category4);
        categoryArray.put(category5);

        JSONObject categoryObj = new JSONObject();
        categoryObj.put("Category", categoryArray);

        JSONObject categoryMainObj = new JSONObject();
        categoryMainObj.put("info", categoryObj);

        return categoryMainObj;
    }
}
