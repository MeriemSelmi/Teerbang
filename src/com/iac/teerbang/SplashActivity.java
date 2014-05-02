package com.iac.teerbang;

import com.iac.teerbang.domain.Flight;
import com.iac.teerbang.manager.FlightManager;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SplashActivity extends Activity {
	Animation animation; 
	ImageView logo;
	
	
	//Khoubeib
	EditText reservationNumber;
	EditText flightNumber;
	Button checkButton;
	FlightManager flightManager;
	Flight flight;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		animation = AnimationUtils.loadAnimation(this, R.anim.down_to_up);
		logo = (ImageView) findViewById(R.id.splash_image);
		logo.startAnimation(animation);

		
		
		
		
		
		
		//Khoubeib
		
reservationNumber = (EditText) findViewById(R.id.checkReservation);
		
		flightNumber = (EditText) findViewById(R.id.checkFlightNumber);
		checkButton = (Button) findViewById(R.id.checkButton);
		flightManager = new FlightManager();
		
		
		checkButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				try {
					flight = flightManager.getFlightByPassenger(reservationNumber.getText().toString(), flightNumber.getText().toString());
					
					Toast.makeText(getApplicationContext(), flight.getArrivalAirport(), Toast.LENGTH_SHORT).show();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					Toast.makeText(getApplicationContext(), "yarraaaaah", Toast.LENGTH_SHORT).show();
					e.printStackTrace();
					
				}
			}
		});
	}

	@Override
	public void onBackPressed() {
		this.finish();
		super.onBackPressed();
	}
}
