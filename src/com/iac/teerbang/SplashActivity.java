package com.iac.teerbang;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.devspark.appmsg.AppMsg;
import com.iac.teerbang.domain.Flight;
import com.iac.teerbang.manager.FlightManager;

public class SplashActivity extends Activity {
	Animation animationLogo, animationForm;
	ImageView logo;
	RelativeLayout form;

	EditText reservationNumber;
	EditText flightNumber;
	Button checkButton;
	FlightManager flightManager;
	Flight flight;
	Intent intent;
	
	boolean isKill = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		animationLogo = AnimationUtils.loadAnimation(this, R.anim.logo);
		animationForm = AnimationUtils.loadAnimation(this, R.anim.form);

		logo = (ImageView) findViewById(R.id.splash_image);
		logo.startAnimation(animationLogo);

		form = (RelativeLayout) findViewById(R.id.checkForm);
		form.startAnimation(animationForm);

		reservationNumber = (EditText) findViewById(R.id.checkReservation);
		flightNumber = (EditText) findViewById(R.id.checkFlightNumber);
		checkButton = (Button) findViewById(R.id.checkButton);
		flightManager = new FlightManager();

		checkButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				try {
					flight = flightManager.getFlightByPassenger(
							reservationNumber.getText().toString(),
							flightNumber.getText().toString());

					intent = new Intent(view.getContext(),
							MainActivity.class);
					intent.putExtra("reservationNumber", reservationNumber
							.getText().toString());
					intent.putExtra("filghtNumber", flightNumber.getText()
							.toString());

					AppMsg.makeText((Activity) view.getContext(),
							"welcome back", AppMsg.STYLE_INFO).show();
					
					Handler handler = new Handler();
					handler.postDelayed(new Runnable() {
						
						@Override
						public void run() {
							startActivity(intent);
							SplashActivity.this.finish();
							overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
						}
					}, 1000);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					AppMsg.makeText((Activity) view.getContext(),
							"no such flight ", AppMsg.STYLE_ALERT).show();
					e.printStackTrace();

				}
			}
		});
		
	}

	@Override
	public void onResume(){
		if(isKill){
		    finish();
		}
		super.onResume();
	}
	
	@Override
	public void onBackPressed() {
		isKill = true;
		this.finish();
		getIntent().setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		super.onBackPressed();
	}
}
