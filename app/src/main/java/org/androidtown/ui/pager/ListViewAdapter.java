package org.androidtown.ui.pager;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dopy on 2016-11-06.
 */

public class ListViewAdapter extends BaseAdapter {
    private ArrayList<ListViewItem> listViewItemslist=new ArrayList<ListViewItem>();
    @Override
    public int getCount() {
        return listViewItemslist.size();
    }

    @Override
    public Object getItem(int i) {
        return listViewItemslist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final int pos=i;
        final Context context=viewGroup.getContext();

        if(view==null){
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listview_item, viewGroup, false);
        }

        ImageView iconImageView = (ImageView) view.findViewById(R.id.imageView) ;
        TextView titleTextView = (TextView) view.findViewById(R.id.textView) ;
        TextView descTextView = (TextView) view.findViewById(R.id.textView2) ;

        ListViewItem listViewItem=listViewItemslist.get(i);

        iconImageView.setImageDrawable(listViewItem.getIcon());
        titleTextView.setText(listViewItem.getName());
        descTextView.setText(listViewItem.getNumber());

        return view;
    }

    public void addItem(Drawable icon, String title, String desc) {
        ListViewItem item = new ListViewItem();

        item.setIcon(icon);
        item.setName(title);
        item.setNumber(desc);

        listViewItemslist.add(item);
    }
}
