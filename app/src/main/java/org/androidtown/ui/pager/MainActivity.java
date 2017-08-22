package org.androidtown.ui.pager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * 뷰페이저를 사용하는 방법에 대해 알 수 있습니다.
 *
 * @author Mike
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 뷰페이저 객체를 참조하고 어댑터를 설정합니다.
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        pager.setAdapter(adapter);





}
    /**
     * 뷰페이저를 위한 어댑터 정의
     */
    public class ViewPagerAdapter extends PagerAdapter {
        // sample names
        private String[] names = { "심박측정", "전화걸기", "사용자설정"};
        // sample image resource ids
        private int[] resIds = {R.drawable.dream01};
        // sample call numbers
        private String[] callNumbers = {"", "010-3513-1651",""};
        private String[] callButton={"측정하기","전화걸기","사용자설정"};
        /**
         * Context 객체
         */
        private Context mContext;

        /**
         * 초기화
         *
         * @param context
         */
        public ViewPagerAdapter( Context context ) {
            mContext = context;
        }

        /**
         * 페이지 갯수
         */
        public int getCount() {
            return names.length;
        }

        /**
         * 뷰페이저가 만들어졌을 때 호출됨
         */
        public Object instantiateItem(ViewGroup container, int position) {
                if (position==0) {
                    CheckPage page = new CheckPage(mContext);
                    page.setNameText(names[position]);
                    page.setCallButton(callButton[position]);
                    page.setImage(resIds[position]);
                    container.addView(page, position);
                    return page;
                }
                else if(position==1){
                CallPage page = new CallPage(mContext);
                page.setNameText(names[position]);
                page.setCallNumber(callNumbers[position]);
                page.setCallButton(callButton[position]);
                container.addView(page, position);
                return page;
            }

            else {
                    UserPage page = new UserPage(mContext);
                    page.setNameText(names[position]);
                    page.setCallButton(callButton[position]);
                    container.addView(page, position);
                    Button callButton = (Button) findViewById(R.id.callButton);
                    callButton.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Intent intent=new Intent(getApplicationContext(),CallActivity.class);
                            startActivity(intent);

                        }
                    });
                    return page;
                }

            // 컨테이너에 추가

        }

        /**
         * Called to remove the page
         */
        public void destroyItem(ViewGroup container, int position, Object view) {
            container.removeView((View)view);
        }

        public boolean isViewFromObject(View view, Object object) {
            return view.equals(object);
        }

    }


}
