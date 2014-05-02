package com.iac.teerbang;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract.CommonDataKinds.Relation;
import android.text.Layout;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class SplashActivity extends Activity {
	Animation animationLogo, animationForm; 
	ImageView logo;
	RelativeLayout form;
	
	
	//Khoubeib
	
	
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
		
		
		
		//Khoubeib
		
	}

	@Override
	public void onBackPressed() {
		this.finish();
		super.onBackPressed();
	}
}
