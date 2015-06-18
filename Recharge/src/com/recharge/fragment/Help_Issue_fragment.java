package com.recharge.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.privatis.recharge.R;
import com.recharge.recharge.Help_sub_Activity;

public class Help_Issue_fragment extends Fragment implements OnClickListener {

	private LinearLayout ll_recharge, ll_addmoney, ll_offer, ll_tansfer,
			ll_account, ll_Other;

	public static Help_Issue_fragment newInstance(int page, String title) {
		Help_Issue_fragment fragmentFirst = new Help_Issue_fragment();
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

		View v = inflater.inflate(R.layout.help_issue_fragment, container,
				false);

		ll_recharge = (LinearLayout) v.findViewById(R.id.ll_recharge);
		ll_addmoney = (LinearLayout) v.findViewById(R.id.ll_addmoney);
		ll_offer = (LinearLayout) v.findViewById(R.id.ll_offer);
		ll_tansfer = (LinearLayout) v.findViewById(R.id.ll_tansfer);
		ll_account = (LinearLayout) v.findViewById(R.id.ll_account);
		ll_Other = (LinearLayout) v.findViewById(R.id.ll_Other);
		// return super.onCreateView(inflater, container, savedInstanceState);

		ll_recharge.setOnClickListener(this);
		ll_addmoney.setOnClickListener(this);
		ll_offer.setOnClickListener(this);
		ll_tansfer.setOnClickListener(this);
		ll_account.setOnClickListener(this);
		ll_Other.setOnClickListener(this);
		return v;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == ll_Other.getId()) {
			// bdl.putInt("index", 5);
		} else {
			Intent intent = new Intent(getActivity(), Help_sub_Activity.class);
			Bundle bdl = new Bundle();
			if (v.getId() == ll_recharge.getId()) {
				bdl.putInt("index", 0);
			} else if (v.getId() == ll_addmoney.getId()) {
				bdl.putInt("index", 1);
			} else if (v.getId() == ll_offer.getId()) {
				bdl.putInt("index", 2);
			} else if (v.getId() == ll_tansfer.getId()) {
				bdl.putInt("index", 3);
			} else if (v.getId() == ll_account.getId()) {
				bdl.putInt("index", 4);
			}
			intent.putExtras(bdl);
			startActivity(intent);
		}
	}
}
