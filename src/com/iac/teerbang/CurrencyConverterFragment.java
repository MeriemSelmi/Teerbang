package com.iac.teerbang;

/*
 * Created by FirstAmong.com
 * License MIT
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CurrencyConverterFragment extends Fragment{
	public int to;
	public int from;
	public String[] val;
	public String s;
	public Handler handler;
	View rootView;
	
	public CurrencyConverterFragment() {
		// Empty constructor required for fragment subclasses
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.fragment_currency,	container, false);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
		.permitAll().build();
		StrictMode.setThreadPolicy(policy);
		
		getActivity().setTitle("Currency Converter");

		Spinner s1 = (Spinner) rootView.findViewById(R.id.spinner1);
		Spinner s2 = (Spinner) rootView.findViewById(R.id.spinner2);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				getActivity(), R.array.name, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
		val = getResources().getStringArray(R.array.value);
		s1.setAdapter(adapter);
		s2.setAdapter(adapter);
		s1.setOnItemSelectedListener(new spinOne(1));
		s2.setOnItemSelectedListener(new spinOne(2));
		Button b = (Button) rootView.findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				TextView t = (TextView) rootView.findViewById(R.id.textView4);
				if (from == to) {
					Toast.makeText(getActivity(), "Invalid", Toast.LENGTH_SHORT).show();
				} else {
					try {
						s = getJson("http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20(%22"
								+ val[from]
								+ val[to]
								+ "%22)&format=json&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=");
						JSONObject jObj;
						jObj = new JSONObject(s);
						String exResult = jObj.getJSONObject("query")
								.getJSONObject("results").getJSONObject("rate")
								.getString("Rate");
						t.setText(exResult);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClientProtocolException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		return rootView;
	}

	public String getJson(String url) throws ClientProtocolException,
			IOException {

		StringBuilder build = new StringBuilder();
		HttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		HttpResponse response = client.execute(httpGet);
		HttpEntity entity = response.getEntity();
		InputStream content = entity.getContent();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				content));
		String con;
		while ((con = reader.readLine()) != null) {
			build.append(con);
		}
		return build.toString();
	}

	private class spinOne implements OnItemSelectedListener {
		int ide;

		spinOne(int i) {
			ide = i;
		}

		public void onItemSelected(AdapterView<?> parent, View view, int index,
				long id) {
			if (ide == 1)
				from = index;
			else if (ide == 2)
				to = index;

		}

		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
		}

	}
}
