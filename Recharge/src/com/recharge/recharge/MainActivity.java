package com.recharge.recharge;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Application;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.privatis.recharge.R;
import com.recharge.common.constant;
import com.recharge.fragment.MainFragment;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MainActivity extends FragmentActivity {

	private DrawerLayout NavDrawerLayout;
	private ListView NavList;
	private String[] titulos;
	private ArrayList<Item_objct> NavItms;
	private TypedArray NavIcons;
	NavigationAdapter NavAdapter;
	private ActionBarDrawerToggle mDrawerToggle;
	private ImageView img_action_logo;
	LinearLayout ll_login, ll_login_signout;

	@SuppressWarnings("deprecation")
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(getWindow().FEATURE_ACTION_BAR_OVERLAY);

		setContentView(R.layout.activity_main);

		// requestWindowFeature(com.actionbarsherlock.view.Window.FEATURE_ACTION_BAR_OVERLAY);

		NavDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		NavDrawerLayout.bringToFront();
		// Lista
		NavList = (ListView) findViewById(R.id.lista);
		// Declaramos el header el caul sera el layout de header.xml
		View header = getLayoutInflater().inflate(R.layout.header, null);

		LinearLayout ll_edit_profile = (LinearLayout) header
				.findViewById(R.id.ll_edit_profile);
		ll_edit_profile.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				NavDrawerLayout.closeDrawer(NavList);
				Intent intent = new Intent(MainActivity.this,
						Profile_Acivity.class);
				startActivity(intent);
			}
		});
		// Establecemos header
		NavList.addHeaderView(header);
		// Tomamos listado de imgs desde drawable
		NavIcons = getResources().obtainTypedArray(R.array.navigation_iconos);
		// Tomamos listado de titulos desde el string-array de los recursos
		// @string/nav_options
		titulos = getResources().getStringArray(R.array.nav_options);
		// Listado de titulos de barra de navegacion
		NavItms = new ArrayList<Item_objct>();
		// Agregamos objetos Item_objct al array
		// Transfer Money
		NavItms.add(new Item_objct(titulos[0], NavIcons.getResourceId(0, -1)));
		// CashPay
		NavItms.add(new Item_objct(titulos[1], NavIcons.getResourceId(1, -1)));
		// Saved connections
		NavItms.add(new Item_objct(titulos[2], NavIcons.getResourceId(2, -1)));
		// Transaction history
		NavItms.add(new Item_objct(titulos[3], NavIcons.getResourceId(3, -1)));
		// Rafer & Earn
		if (!constant.get_emailid(getApplicationContext()).equals("")) {
			NavItms.add(new Item_objct(titulos[4], NavIcons
					.getResourceId(4, -1)));
		}
		// Security settings
		NavItms.add(new Item_objct(titulos[5], NavIcons.getResourceId(5, -1)));
		// Notifications
		NavItms.add(new Item_objct(titulos[6], NavIcons.getResourceId(6, -1)));
		// Help
		NavItms.add(new Item_objct(titulos[7], NavIcons.getResourceId(7, -1)));
		// About us
		NavItms.add(new Item_objct(titulos[8], NavIcons.getResourceId(8, -1)));
		// Declaramos y seteamos nuestrp adaptador al cual le pasamos el array
		// con los titulos
		NavAdapter = new NavigationAdapter(this, NavItms);
		NavList.setAdapter(NavAdapter);
		// Siempre vamos a mostrar el mismo titulo

		getActionBar().hide();

		mDrawerToggle = new ActionBarDrawerToggle(this, NavDrawerLayout,
				R.drawable.action_logo, R.string.drawer_open,
				R.string.drawer_close) {
			@Override
			public void onDrawerOpened(View drawerView) {
				// TODO Auto-generated method stub
				super.onDrawerOpened(drawerView);
			}

			@Override
			public void onDrawerClosed(View drawerView) {
				// TODO Auto-generated method stub
				super.onDrawerClosed(drawerView);
			}
		};

		/*
		 * img_action_logo = (ImageView) findViewById(R.id.img_action_logo);
		 * img_action_logo.setOnClickListener(new View.OnClickListener() {
		 * 
		 * @Override public void onClick(View v) { // TODO Auto-generated method
		 * stub Toast.makeText(getApplicationContext(), "sdsd",
		 * Toast.LENGTH_LONG).show(); } });
		 */

		showFragment();

		NavList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				if (NavDrawerLayout.isDrawerOpen(NavList)) {
					NavDrawerLayout.closeDrawer(NavList);
				} else {
					NavDrawerLayout.openDrawer(NavList);
				}

				if (titulos[position - 1].equals("Transfer money")) {
					Intent intent = new Intent(MainActivity.this,
							TransferMoneyActivity.class);
					startActivity(intent);
				} else if (titulos[position - 1].equals("CashPay")) {
					Intent intent = new Intent(MainActivity.this,
							CashPayActivity.class);
					startActivity(intent);
				} else if (titulos[position - 1].equals("Saved connections")) {
					Intent intent = new Intent(MainActivity.this,
							SaveConnection.class);
					startActivity(intent);
				} else if (titulos[position - 1].equals("Transaction history")) {
					Intent intent = new Intent(MainActivity.this,
							TransactionHistoryActivity.class);
					startActivity(intent);
				} else if (titulos[position - 1].equals("Refer &amp; Earn")) {
					// Intent intent = new Intent(MainActivity.this,
					// TransferMoneyActivity.class);
					// startActivity(intent);
				} else if (titulos[position - 1].equals("security settings")) {
					Intent intent = new Intent(MainActivity.this,
							SecuritySettingsActivity.class);
					startActivity(intent);
				} else if (titulos[position - 1].equals("Notifications")) {
					// Intent intent = new Intent(MainActivity.this,
					// TransferMoneyActivity.class);
					// startActivity(intent);
				} else if (titulos[position - 1].equals("Halp")) {
					Intent intent = new Intent(MainActivity.this,
							Help_Activity.class);
					startActivity(intent);
				} else if (titulos[position - 1].equals("About us")) {
					// Intent intent = new Intent(MainActivity.this,
					// TransferMoneyActivity.class);
					// startActivity(intent);
				}
				if (position == 1) {
				} else if (position == 2) {

				} else if (position == 3) {

				} else if (position == 4) {

				} else if (position == 5) {

				}
			}
		});

		constant.NavDrawerLayout = NavDrawerLayout;
		constant.NavList = NavList;
	}

	public void showFragment() {
		// Currently selected country
		// mTitle = mCountries[position];

		// Creating a fragment object
		// Main_Menu cFragment = new Main_Menu();
		MainFragment cFragment = new MainFragment();

		// Creating a Bundle object
		Bundle data = new Bundle();

		// Setting the index of the currently selected item of mDrawerList
		// data.putInt("position", position);

		// Setting the position to the fragment
		// cFragment.setArguments(data);
		// cFragment.

		// Getting reference to the FragmentManager
		FragmentManager fragmentManager = getSupportFragmentManager();

		// Creating a fragment transaction
		FragmentTransaction ft = fragmentManager.beginTransaction();

		// Adding a fragment to the fragment transaction
		// ft.replace(R.id.content_frame, cFragment);
		// String st = String.valueOf(position);
		ft.replace(R.id.content_frame, cFragment);

		// Committing the transaction
		ft.commit();
	}

}
