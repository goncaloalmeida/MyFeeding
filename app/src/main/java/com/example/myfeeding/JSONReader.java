package com.example.myfeeding;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JSONReader {
    private static String loadJSONFromAsset(Context context, String file_name) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(file_name);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public static List<Meal> get_meals_from_file(Context context, String file_name) {
        List<Meal> list = new ArrayList<>();
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset(context, file_name));
            JSONArray jsonArry = obj.getJSONArray("food");
            for (int i = 0; i < jsonArry.length(); i++) {
                JSONObject obj2 = jsonArry.getJSONObject(i);
                list.add(new Meal(obj2.getString("Name"), obj2.getInt("Calories")));
            }
        } catch (Exception exception) {
            Log.e("JSONReader", exception.getMessage());
        }
        return list;
    }
}
