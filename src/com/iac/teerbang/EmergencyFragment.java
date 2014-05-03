package com.iac.teerbang;

import java.util.LinkedList;
import java.util.List;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class EmergencyFragment extends Fragment implements OnClickListener{
	
	View rootView;
	ImageView emergencyA, emergencyB, controlPlayer, scene;
	LinearLayout layout;
	Animation animation;
	int currentPosition=0;
	boolean visible = false;
	
	Handler handler = new Handler();
 
	boolean paused=true;
	
	List<Integer> scenesA = new LinkedList<Integer>();
	List<Integer> scenesB = new LinkedList<Integer>();
	List<Integer> scenes;
	
	public EmergencyFragment() {
		// Empty constructor required for fragment subclasses
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.fragment_emergency,	container, false);
		getActivity().setTitle("Emergency");

		((ImageView) rootView.findViewById(R.id.emergencyA)).setOnClickListener(this);
		((ImageView) rootView.findViewById(R.id.emergencyB)).setOnClickListener(this);
		layout = (LinearLayout) rootView.findViewById(R.id.emergencyLayout);
		controlPlayer = (ImageView) rootView.findViewById(R.id.player_control);
		scene = (ImageView) rootView.findViewById(R.id.emergencyScene);
		
		animation = AnimationUtils.loadAnimation(getActivity(), R.anim.scene_fade_in);
		
		
		controlPlayer.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (paused) {
					paused= false;
					controlPlayer.setImageResource(R.drawable.pause);
				} else {
					paused=true;
					controlPlayer.setImageResource(R.drawable.play);
				}
			}
		});
		
		scenesA.add(R.drawable.security_21);
		scenesA.add(R.drawable.security_22);
		scenesA.add(R.drawable.security_23);
		scenesA.add(R.drawable.security_25);
		scenesA.add(R.drawable.security_27);
		scenesA.add(R.drawable.security_29);
		scenesA.add(R.drawable.security_31);
		
		scenesB.add(R.drawable.security_77);
		scenesB.add(R.drawable.security_80);
		scenesB.add(R.drawable.security_82);
		scenesB.add(R.drawable.security_84);
		scenesB.add(R.drawable.security_99);
		scenesB.add(R.drawable.security_100);
		scenesB.add(R.drawable.security_102);
		return rootView;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.emergencyA:
			if(!visible){
				layout.setVisibility(View.VISIBLE);
				layout.startAnimation(animation);
				visible = true;
			}
			scenes = scenesA;
			updateGestureImage();
			break;
		case R.id.emergencyB:
			if(!visible){
				layout.setVisibility(View.VISIBLE);
				layout.startAnimation(animation);
				visible = true;
			}
			scenes = scenesB;
			updateGestureImage();
			break;
		default:
			break;
		}
		
	}


	private void updateGestureImage() {
		if(currentPosition<scenes.size()){
			if(!paused){
				scene.setImageResource(scenes.get(currentPosition));
				currentPosition++;
			}
		}else{
			currentPosition=0;
			paused=true;
			controlPlayer.setImageResource(R.drawable.play);
		}
		handler.postDelayed(updateRunnable, 1000);
	}
	Runnable updateRunnable = new Runnable() {
		@Override
		public void run() {
			updateGestureImage();
		}
	};

}
