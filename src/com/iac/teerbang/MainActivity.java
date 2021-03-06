/*
 * Copyright 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.iac.teerbang;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * This example illustrates a common usage of the DrawerLayout widget in the
 * Android support library.
 * <p/>
 * <p>
 * When a navigation (left) drawer is present, the host activity should detect
 * presses of the action bar's Up affordance as a signal to open and close the
 * navigation drawer. The ActionBarDrawerToggle facilitates this behavior. Items
 * within the drawer should fall into one of two categories:
 * </p>
 * <p/>
 * <ul>
 * <li><strong>View switches</strong>. A view switch follows the same basic
 * policies as list or tab navigation in that a view switch does not create
 * navigation history. This pattern should only be used at the root activity of
 * a task, leaving some form of Up navigation active for activities further down
 * the navigation hierarchy.</li>
 * <li><strong>Selective Up</strong>. The drawer allows the user to choose an
 * alternate parent for Up navigation. This allows a user to jump across an
 * app's navigation hierarchy at will. The application should treat this as it
 * treats Up navigation from a different task, replacing the current task stack
 * using TaskStackBuilder or similar. This is the only form of navigation drawer
 * that should be used outside of the root activity of a task.</li>
 * </ul>
 * <p/>
 * <p>
 * Right side drawers should be used for actions, not navigation. This follows
 * the pattern established by the Action Bar that navigation should be to the
 * left and actions to the right. An action should be an operation performed on
 * the current contents of the window, for example enabling or disabling a data
 * overlay on top of the current content.
 * </p>
 */
public class MainActivity extends Activity {
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	private String[] mMenusTitles;
	private static String reservationNumber;
	private static String flightNumber;
	private Intent intent;
	boolean isKill = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		intent = getIntent();
		reservationNumber = intent.getStringExtra("reservationNumber");
		flightNumber = intent.getStringExtra("flightNumber");
		
		mTitle = mDrawerTitle = getTitle();
		mMenusTitles = getResources().getStringArray(
				R.array.airport_items_array);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		// set a custom shadow that overlays the main content when the drawer
		// opens
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);
		// set up the drawer's list view with items and click listener
		mDrawerList.setAdapter(new ArrayAdapter<String>(this,
				R.layout.drawer_list_item, mMenusTitles));
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		// enable ActionBar app icon to behave as action to toggle nav drawer
		getActionBar().setDisplayHomeAsUpEnabled(true);
		// getActionBar().setHomeButtonEnabled(true);

		// ActionBarDrawerToggle ties together the the proper interactions
		// between the sliding drawer and the action bar app icon
		mDrawerToggle = new ActionBarDrawerToggle(this, /* host Activity */
		mDrawerLayout, /* DrawerLayout object */
		R.drawable.ic_drawer, /* nav drawer image to replace 'Up' caret */
		R.string.drawer_open, /* "open drawer" description for accessibility */
		R.string.drawer_close /* "close drawer" description for accessibility */
		) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null) {
			selectItem(0);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// The action bar home/up action should open or close the drawer.
		// ActionBarDrawerToggle will take care of this.
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		// Handle action buttons

		 switch (item.getItemId()) {
	        case R.id.action_about:
	        	startActivity(new Intent(MainActivity.this, AboutActivity.class));
	            return true;
	        case R.id.action_disconnect:
	        	Intent intent = new Intent(this, SplashActivity.class);
				startActivity(intent);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }

	}

	/* The click listner for ListView in the navigation drawer */
	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			selectItem(position);
		}
	}

	private void selectItem(int position) {
		Fragment fragment;
		if(position == 9){
			fragment = new CurrencyConverterFragment();
		}else{
			fragment = new ItemFragment();
			Bundle args = new Bundle();

			args.putInt(ItemFragment.ARG_PLANET_NUMBER, position);
			fragment.setArguments(args);
		}

		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager.beginTransaction()
				.replace(R.id.content_frame, fragment).commit();

		// update selected item and title, then close the drawer
		mDrawerList.setItemChecked(position, true);
		setTitle(mMenusTitles[position]);
		mDrawerLayout.closeDrawer(mDrawerList);
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	/**
	 * When using the ActionBarDrawerToggle, you must call it during
	 * onPostCreate() and onConfigurationChanged()...
	 */

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggls
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	/**
	 * Fragment that appears in the "content_frame", shows a planet
	 */
	public static class ItemFragment extends Fragment {

		ImageView agents,coffees,gates,infos,luggage,shops,wcs;
		
		public static final String ARG_PLANET_NUMBER = "planet_number";
		Intent intent;
		public ItemFragment() {
			// Empty constructor required for fragment subclasses
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

			Intent intent;
			View rootView = inflater.inflate(R.layout.fragment_airport,	container, false);

			int i = getArguments().getInt(ARG_PLANET_NUMBER);
			String planet = getResources().getStringArray(R.array.airport_items_array)[i];
			
			agents = (ImageView) rootView.findViewById(R.id.airport_agents);
			coffees = (ImageView) rootView.findViewById(R.id.airport_coffees);
			gates = (ImageView) rootView.findViewById(R.id.airport_gates);
			infos = (ImageView) rootView.findViewById(R.id.airport_infos);
			luggage = (ImageView) rootView.findViewById(R.id.airport_luggage);
			shops = (ImageView) rootView.findViewById(R.id.airport_shops);
			wcs = (ImageView) rootView.findViewById(R.id.airport_wcs);
			
			switch (i) {
			case 0:
				setVisibility(View.VISIBLE);
				break;
			case 1:
				setVisibility(View.INVISIBLE);
			    luggage.setVisibility(View.VISIBLE);
				break;
			case 2:
				setVisibility(View.INVISIBLE);
				gates.setVisibility(View.VISIBLE);
				break;
			case 3:
				setVisibility(View.INVISIBLE);
				coffees.setVisibility(View.VISIBLE);
				break;
			case 4:
				setVisibility(View.INVISIBLE);
				agents.setVisibility(View.VISIBLE);
				break;
			case 5:
				setVisibility(View.INVISIBLE);
				infos.setVisibility(View.VISIBLE);
				break;
			case 6:
				setVisibility(View.INVISIBLE);
				shops.setVisibility(View.VISIBLE);
				break;
			case 7:
				setVisibility(View.INVISIBLE);
				wcs.setVisibility(View.VISIBLE);
				break;
			case 8:
				intent = new Intent(getActivity(), AirplaneActivity.class);
				intent.putExtra("reservationNumber", reservationNumber);
				intent.putExtra("filghtNumber", flightNumber);
				startActivity(intent);
				break;
			case 10:
				intent = new Intent(getActivity(), WeatherDisplayActivity.class);
				startActivity(intent);
				break;
			default:
				break;
			}
			
			getActivity().setTitle(planet);
			return rootView;
		}
		
		public void setVisibility(int visible){
			agents.setVisibility(visible);
			coffees.setVisibility(visible);
			gates.setVisibility(visible);
			infos.setVisibility(visible);
			luggage.setVisibility(visible);
			shops.setVisibility(visible);
			wcs.setVisibility(visible);
			
		}
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