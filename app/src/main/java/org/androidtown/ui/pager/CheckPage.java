package org.androidtown.ui.pager;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;

import static org.androidtown.ui.pager.R.id.callButton;
import static org.androidtown.ui.pager.R.id.text;
import static org.androidtown.ui.pager.R.id.textcheck;

/**
 * 한 페이지를 위한 레이아웃
 *
 * @author Mike
 */
public class CheckPage extends LinearLayout {
	Context mContext;
	TextView Text1;
	TextView textcheck;
	Button Button1;
	ImageView iconImage;
	FrameLayout frameLayout;
	ProgressBar progress;
	BackgroundTask task;
	int value;

	public CheckPage(Context context) {
		super(context);

		init(context);
	}

	public CheckPage(Context context, AttributeSet attrs) {
		super(context, attrs);

		init(context);
	}

	private void init(Context context) {
		mContext = context;


		// inflate XML layout
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.check_page, this, true);

		progress = (ProgressBar) findViewById(R.id.progress);
		frameLayout = (FrameLayout) findViewById(R.id.checklayout);
		iconImage = (ImageView) findViewById(R.id.iconImage);
		Text1 = (TextView) findViewById(R.id.Text1);
		textcheck = (TextView) findViewById(R.id.textcheck);
		Button1 = (Button) findViewById(R.id.Button1);


		Button1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				task = new BackgroundTask();
				task.execute(100);

				progress.setVisibility(VISIBLE);
				textcheck.setVisibility(View.VISIBLE);
				Button1.setVisibility(View.INVISIBLE);
				iconImage.setVisibility(INVISIBLE);

			}
		});

	}

	public void setImage(int resId) {
		iconImage.setImageResource(resId);
	}


	public String getNameText() {
		return Text1.getText().toString();
	}

	public void setNameText(String nameStr) {
		Text1.setText(nameStr);
	}

	public void setCallButton(String nameStr) {
		Button1.setText(nameStr);
	}

	class BackgroundTask extends AsyncTask<Integer, Integer, Integer> {
		protected void onPreExecute() {
			value = 0;
			progress.setProgress(value);
		}

		protected Integer doInBackground(Integer... values) {
			while (isCancelled() == false) {
				value++;
				if (value >= 100) {
					break;
				} else {
					publishProgress(value);
				}

				try {
					Thread.sleep(100);
				} catch (InterruptedException ex) {
				}
			}

			return value;
		}

		protected void onProgressUpdate(Integer... values) {
			progress.setProgress(values[0].intValue());
			textcheck.setText("진행 : " + values[0].toString()+"%");
		}

		protected void onPostExecute(Integer result) {
			progress.setProgress(0);
			textcheck.setText("현재 체온은 36.5입니다");
		}
	}
}
