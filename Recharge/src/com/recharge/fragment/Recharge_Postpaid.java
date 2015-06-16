package com.recharge.fragment;

import com.privatis.recharge.R;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Recharge_Postpaid extends Fragment {
	private TextView txt_provider, txt_state;

	public static Recharge_Postpaid newInstance(int page, String title) {
		Recharge_Postpaid fragmentFirst = new Recharge_Postpaid();
		Bundle args = new Bundle();
		args.putInt("someInt", page);
		args.putString("someTitle", title);
		fragmentFirst.setArguments(args);
		return fragmentFirst;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.recharge_postpaid_fragment,
				container, false);
		// return super.onCreateView(inflater, container, savedInstanceState);

		txt_provider = (TextView) v.findViewById(R.id.txt_provider);
		txt_state = (TextView) v.findViewById(R.id.txt_state);

		txt_provider.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				open_provide_dialog();
			}
		});

		txt_state.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				open_state_dialog();
			}
		});
		return v;
	}

	public void open_provide_dialog() {
		final CharSequence[] items = { "Aritel", "Vodafone", "BSNL",
				"Reliance CAMA", "Relience GSM", "Aricel", "MTNL", "Idea",
				"Tata Indicom", "Tata Docomo", "MTS", "Uninor", "Videocon" };

		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle("Operator");
		builder.setItems(items, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int item) {
				// Do something with the selection
				txt_provider.setText(items[item]);
			}
		});
		AlertDialog alert = builder.create();
		alert.show();
	}

	public void open_state_dialog() {
		final CharSequence[] items = { "Andra Pradesh", "Arunachal Pradesh",
				"Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana",
				"Himachal Pradesh", "Jammu and Kashmir", "Jharkhand",
				"Karnataka", "Kerala", "Madya Pradesh", "Maharashtra",
				"Manipur", "Meghalaya", "Mizoram", "Nagaland", "Orissa",
				"Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Tripura",
				"Uttaranchal", "Uttar Pradesh", "West Bengal" };

		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle("Circle");
		builder.setItems(items, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int item) {
				// Do something with the selection
				txt_state.setText(items[item]);
			}
		});
		AlertDialog alert = builder.create();
		alert.show();
	}

}
