package com.raulbrumar.stockmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    ListView listView;

    String urlPart1 = "https://financialmodelingprep.com/api/company/price/";
    String urlPart2 = "?datatype=json";
    String[] stockIDs = {"AAPL", "GOOGL", "FB", "NOK"};
    String[] stockNames = {"Apple", "GOOGLE", "FACEBOOK", "NOKIA"};

    ArrayList<String> prices = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        queue = Volley.newRequestQueue(this);
        for(int i = 0; i < stockIDs.length; i++)
        {
            Log.d("AAA", urlPart1 + stockIDs[i] + urlPart2);
            sendRequest(urlPart1 + stockIDs[i] + urlPart2, stockIDs[i], stockNames[i]);
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, prices);
        listView.setAdapter(adapter);
    }

    public void sendRequest(String url, final String stockName, final String companyName)
    {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            String price = response.getJSONObject(stockName).getString("price");
                            prices.add(companyName + ": " + price + "USD");
                            adapter.notifyDataSetChanged();
                        }
                        catch(Exception e)
                        {
                            Log.d("AAA", "ERROR parsing");
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

        queue.add(jsonObjectRequest);
    }
}
