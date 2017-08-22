package org.androidtown.ui.pager;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 한 페이지를 위한 레이아웃
 *
 * @author Mike
 */
public class UserPage extends LinearLayout {
	Context mContext;
	TextView Text2;
	Button Button2;
	FrameLayout userlayout;
	WebView webView;


	public UserPage(Context context) {
		super(context);

		init(context);
	}

	public UserPage(Context context, AttributeSet attrs) {
		super(context, attrs);

		init(context);
	}

	private void init(Context context) {
		mContext = context;

		// inflate XML layout
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.user_page, this, true);

		userlayout =(FrameLayout) findViewById(R.id.userlayout);
		webView=(WebView)findViewById(R.id.webView);
		Text2 = (TextView) findViewById(R.id.Text2);
		Button2 = (Button) findViewById(R.id.Button2);
		webView.setWebViewClient(new WebViewClient());

		WebSettings webSettings=webView.getSettings();
		webSettings.setJavaScriptEnabled(true);

		webView.loadUrl("http://google.com");
		Button2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
			Button2.setVisibility(INVISIBLE);
			webView.setVisibility(VISIBLE);
			}
		});

	}

	public String getNameText() {
		return Text2.getText().toString();
	}

	public void setNameText(String nameStr) {
		Text2.setText(nameStr);
	}
	public void setCallButton(String nameStr) {
		Button2.setText(nameStr);
	}

}

