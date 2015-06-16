package com.recharge.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;

import com.privatis.recharge.R;

public class TransferViaMobile extends Fragment {
	private Button btn_mobile, btn_email;
	private LinearLayout ll_mobile, ll_email;

	public static TransferViaMobile newInstance(int page, String title) {
		TransferViaMobile fragmentFirst = new TransferViaMobile();
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
		View v = inflater.inflate(R.layout.sendmoney, container, false);
		// return super.onCreateView(inflater, container, savedInstanceState);
		btn_mobile = (Button) v.findViewById(R.id.btn_mobile);
		btn_email = (Button) v.findViewById(R.id.btn_email);

		ll_mobile = (LinearLayout) v.findViewById(R.id.ll_mobile);
		ll_email = (LinearLayout) v.findViewById(R.id.ll_email);

		ll_mobile.setVisibility(View.VISIBLE);
		ll_email.setVisibility(View.GONE);
		btn_mobile.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// ll_mobile.animate().translationY(100);

				// ll_email.setVisibility(View.GONE);
				// ll_mobile.setVisibility(View.VISIBLE);
				slideToRight(ll_email);
				slideToRightV(ll_mobile);
			}
		});

		btn_email.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// ll_mobile.setVisibility(View.GONE);
				// ll_email.setVisibility(View.VISIBLE);
				slideToLeft(ll_mobile);
				slideToLeftV(ll_email);
			}
		});
		return v;
	}

	// https://colinyeoh.wordpress.com/2012/10/07/simple-android-animation-on-view-gonevisible/
	// To animate view slide out from left to right
	public void slideToRight(View view) {
		TranslateAnimation animate = new TranslateAnimation(0, view.getWidth(),
				0, 0);
		animate.setDuration(500);
		animate.setFillAfter(true);
		view.startAnimation(animate);
		view.setVisibility(View.GONE);
	}

	public void slideToRightV(View view) {
		TranslateAnimation animate = new TranslateAnimation(0, 0, 0, 0);
		animate.setDuration(500);
		animate.setFillAfter(true);
		view.startAnimation(animate);
		view.setVisibility(View.VISIBLE);
	}

	// To animate view slide out from right to left
	public void slideToLeft(View view) {
		TranslateAnimation animate = new TranslateAnimation(0,
				-view.getWidth(), 0, 0);
		animate.setDuration(500);
		animate.setFillAfter(true);
		view.startAnimation(animate);
		view.setVisibility(View.GONE);
	}

	// To animate view slide out from right to left
	public void slideToLeftV(View view) {
		TranslateAnimation animate = new TranslateAnimation(0, 0, 0, 0);
		animate.setDuration(500);
		animate.setFillAfter(true);
		view.startAnimation(animate);
		view.setVisibility(View.VISIBLE);
	}

	// To animate view slide out from top to bottom
	public void slideToBottom(View view) {
		TranslateAnimation animate = new TranslateAnimation(0, 0, 0,
				view.getHeight());
		animate.setDuration(500);
		animate.setFillAfter(true);
		view.startAnimation(animate);
		view.setVisibility(View.GONE);
	}

	// To animate view slide out from bottom to top
	public void slideToTop(View view) {
		TranslateAnimation animate = new TranslateAnimation(0, 0, 0,
				-view.getHeight());
		animate.setDuration(500);
		animate.setFillAfter(true);
		view.startAnimation(animate);
		view.setVisibility(View.GONE);
	}
}
