/**
DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE 
                    Version 2, December 2004 

 Copyright (C) 2013 http://popofibo.com <popo.fibo@gmail.com> 

 Everyone is permitted to copy and distribute verbatim or modified 
 copies of this code, and changing it is allowed as long 
 as the name is changed. 

            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE 
   TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION 

  0. You just DO WHAT THE FUCK YOU WANT TO.
**/
package com.iac.teerbang;

import org.json.JSONException;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.iac.weather.model.Weather;
import com.iac.weather.util.WeatherConstants;
import com.iac.weather.util.WeatherHttpClient;
import com.iac.weather.util.WeatherJSONParser;

/**
 * 
 * @author popofibo
 * 
 */
public class WeatherDisplayActivity extends FragmentActivity {

	private TextView cityText;
	private String option;
	private TextView temp;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_display_content);
		Intent intent = getIntent();
		String city = intent.getStringExtra(WeatherConstants.EXTRA_MESSAGE);
		option = "Default";
		String lang = "en";
		cityText = (TextView) findViewById(R.id.cityName);
		temp = (TextView) findViewById(R.id.temprDegree);
		
		if (city == null)
			city = "Gurgaon, IN";

		try {
			JSONWeatherTask task = new JSONWeatherTask();
			task.execute(new String[] { city, lang });
		} catch (Exception ex) {
			// System.out.println(ex.getMessage());
			Builder alert = new AlertDialog.Builder(
					WeatherDisplayActivity.this);
			alert.setTitle("You made me crash, man!");
			alert.setMessage("Blast! Something went terribly wrong with the "
					+ "request. Check your connection and try again.");
			alert.setPositiveButton("OK", null);
			alert.show();
		}

	}

	private class JSONWeatherTask extends AsyncTask<String, Void, Weather> {

		@Override
		protected Weather doInBackground(String... params) {
			Weather weather = new Weather(option);
			String data = ((new WeatherHttpClient()).getWeatherData(
					"Madrid", params[1]));

			try {
				weather = WeatherJSONParser.getWeather(data, option);

			} catch (JSONException e) {
				e.printStackTrace();
			}
			return weather;

		}

		@Override
		protected void onPostExecute(Weather weather) {
			super.onPostExecute(weather);


			try {
				cityText.setText(weather.location.getCity()
						+ ((weather.location.getCity() != null)
								&& (weather.location.getCity().length() > 0) ? ", "
								: "") + weather.location.getCountry());
				temp.setText(""
						+ Math.round((weather.temperature.getTemp() - 275.15)));
				temp.setShadowLayer(2, 2, 2, 0xFF303030);
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
				Builder alert = new AlertDialog.Builder(
						WeatherDisplayActivity.this);
				alert.setTitle("You made me crash, man!");
				alert.setMessage("Blast! Something went terribly wrong with the "
						+ "request. Check your connection and try again.");
				alert.setPositiveButton("OK", null);
				alert.show();
			}
			
			
		}
	}

	

}
