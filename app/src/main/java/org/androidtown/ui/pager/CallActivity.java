package org.androidtown.ui.pager;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CallActivity extends AppCompatActivity {

    String[] List_MENU={"01033972208","023572208","201346359"};
    public ListView listView;
    public ListViewAdapter adapter;
    public Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        adapter=new ListViewAdapter();
        listView=(ListView)findViewById(R.id.ListView);
        listView.setAdapter(adapter);
        context=getApplicationContext();
        adapter.addItem(ContextCompat.getDrawable(context,R.drawable.ic_family),"이지건","0103397220");
        adapter.addItem(ContextCompat.getDrawable(context,R.drawable.ic_home),"가족","0103397220");
        adapter.addItem(ContextCompat.getDrawable(context,R.drawable.ic_hospital),"병원","0103397220");



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                ListViewItem item=(ListViewItem)parent.getItemAtPosition(position);
                String number=(String)item.getNumber();
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+number));
                startActivity(intent);
            }
        });

        Button button=(Button)findViewById(R.id.button3);//전화번호 추가 버튼
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                final View dialogView= inflater.inflate(R.layout.dialog_add_card,null);
                AlertDialog.Builder buider= new AlertDialog.Builder(CallActivity.this);
                buider.setTitle("전화번호 추가");
                buider.setView(dialogView);
                buider.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                buider.setPositiveButton("추가", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText editname=(EditText)dialogView.findViewById(R.id.editText);
                        EditText editnumber=(EditText)dialogView.findViewById(R.id.editText2);
                        String name=editname.getText().toString();
                        String number=editnumber.getText().toString();
                        RadioGroup rg=(RadioGroup)dialogView.findViewById(R.id.radiogroup);
                        int rbid=rg.getCheckedRadioButtonId();
                        RadioButton rb=(RadioButton)dialogView.findViewById(rbid);
                        String icon=rb.getText().toString();
                        switch (icon){
                            case"병원":
                                adapter.addItem(ContextCompat.getDrawable(context,R.drawable.ic_hospital),name,number);
                            break;
                            case "집":
                                adapter.addItem(ContextCompat.getDrawable(context,R.drawable.ic_home),name,number);
                                break;
                            case "가족":
                                adapter.addItem(ContextCompat.getDrawable(context,R.drawable.ic_family),name,number);
                                break;
                        }
                        Toast.makeText(getApplicationContext(),"추가 완료",Toast.LENGTH_LONG).show();
                    }
                });
                AlertDialog dialog=buider.create();
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
            }
        });
    }
}
