package com.iac.teerbang;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends Activity {
	Animation animation; 
	ImageView logo;
	
	
	//Khoubeib
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		animation = AnimationUtils.loadAnimation(this, R.anim.down_to_up);
		logo = (ImageView) findViewById(R.id.splash_image);
		logo.startAnimation(animation);

		
		
		
		
		
		//Khoubeib
		
	}

	@Override
	public void onBackPressed() {
		this.finish();
		super.onBackPressed();
	}
}
