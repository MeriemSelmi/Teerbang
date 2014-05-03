package com.iac.teerbang;

import java.io.ObjectOutputStream.PutField;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.devspark.appmsg.AppMsg;
import com.iac.teerbang.domain.Flight;
import com.iac.teerbang.manager.FlightManager;

public class SplashActivity extends Activity {
	Animation animationLogo, animationForm;
	ImageView logo;
	RelativeLayout form;

	// Khoubeib
	EditText reservationNumber;
	EditText flightNumber;
	Button checkButton;
	FlightManager flightManager;
	Flight flight;

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

		// Khoubeib

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

					Intent intent = new Intent(view.getContext(),
							MainActivity.class);
					intent.putExtra("reservationNumber", reservationNumber.getText().toString());
					intent.putExtra("filghtNumber", flightNumber.getText().toString());
					startActivity(intent);
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
	public void onBackPressed() {
		this.finish();
		super.onBackPressed();
	}
}
