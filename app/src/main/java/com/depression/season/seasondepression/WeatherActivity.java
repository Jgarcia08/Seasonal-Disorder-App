package com.depression.season.seasondepression;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.lang.*;
import org.json.*;


public class WeatherActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        double x;
        double y;
        // Here we are going to retrieve the temperature from the weather map
        try {

            JSONObject obj = new JSONObject("api.openweathermap.org/data/2.5/weather?lat=" + 35 + "&long=" + 129);
            String temperature = obj.getJSONObject ("main").getString("temp");
            TextView textv = (TextView) findViewById(R.id.theID);
            textv.setText("Temperature" + temperature);

            }

        catch (Exception e)
        {

        }

       /* try {
            obj = new JSONOBbject("api.openweathermap.org/data/2.5/weather?latitude=" + 35 + "longitude=" + 129);
        } catch (JSONException e) {
            e.printStackTrace();
        }
       */

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_weather, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
