package org.androidtown.ui.pager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.telecom.Call;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
/**
 * 한 페이지를 위한 레이아웃
 *
 * @author Mike
 */

	public class CallPage extends LinearLayout {
		Context mContext;
		TextView nameText;
		Button callButton;
		FrameLayout calllayout;



		public CallPage(Context context) {
			super(context);

			init(context);
		}

		public CallPage(Context context, AttributeSet attrs) {
			super(context, attrs);

			init(context);
		}

		private void init(Context context) {
			mContext = context;

			// inflate XML layout
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			inflater.inflate(R.layout.call_page, this, true);

			calllayout = (FrameLayout) findViewById(R.id.calllayout);

			nameText = (TextView) findViewById(R.id.nameText);
			callButton = (Button) findViewById(R.id.callButton);


		}


		public void setCallNumber(String number) {
			callButton.setTag(number);
		}

		public String getNameText() {
			return nameText.getText().toString();
		}

		public void setNameText(String nameStr) {
			nameText.setText(nameStr);
		}

		public void setCallButton(String nameStr) {
			callButton.setText(nameStr);
		}

	}

