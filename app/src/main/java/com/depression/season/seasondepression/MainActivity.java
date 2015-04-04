package com.depression.season.seasondepression;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends Activity implements LocationListener{

    /***********  Create class and implements with LocationListener **************/

        private LocationManager locationManager;

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_weather);

            /********** get Gps location service LocationManager object ***********/
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

                /* CAL METHOD requestLocationUpdates */

            // Parameters :
            //   First(provider)    :  the name of the provider with which to register
            //   Second(minTime)    :  the minimum time interval for notifications,
            //                         in milliseconds. This field is only used as a hint
            //                         to conserve power, and actual time between location
            //                         updates may be greater or lesser than this value.
            //   Third(minDistance) :  the minimum distance interval for notifications, in meters
            //   Fourth(listener)   :  a {#link LocationListener} whose onLocationChanged(Location)
            //                         method will be called for each location update


            locationManager.requestLocationUpdates( LocationManager.GPS_PROVIDER,
                    3000,   // 3 sec
                    10, this);

            /********* After registration onLocationChanged method  ********/
            /********* called periodically after each 3 sec ***********/
        }

        /************* Called after each 3 sec **********/
        @Override
        public void onLocationChanged(Location location) {
            String str = "Latitude: "+location.getLatitude()+ "|| Longitude:" + location.getLongitude();
            Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
        }

        void data(double x, double y, Location location)
        {
            double longitude  = location.getLongitude();
            double Latitude = location.getLatitude();

        }
        @Override
        public void onProviderDisabled(String provider) {

            /******** Called when User off Gps *********/

            Toast.makeText(getBaseContext(), "Gps turned off ", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onProviderEnabled(String provider) {

            /******** Called when User on Gps  *********/

            Toast.makeText(getBaseContext(), "Gps turned on ", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            // TODO Auto-generated method stub

        }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void doSomething(View view) {
        Intent intent = new Intent(this, WeatherActivity.class);
        startActivity(intent);
        finish();

    }
}

