package edu.clementlefevre.td5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MyAdapter extends BaseAdapter {
    private final int tableToDisplay=20;

    private int value=0;

    private final LayoutInflater mInflater;

    public MyAdapter(MainActivity2 myActivity, String value) {
        this.value = Integer.parseInt(value);
        mInflater = LayoutInflater.from(myActivity.getContext());
    }


    @Override
    public int getCount() {
        return tableToDisplay;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v;
        v = view == null ? mInflater.inflate(R.layout.table_layout, viewGroup, false) : view;


        TextView textView = v.findViewById(R.id.itemText);

        textView.setText(String.valueOf(value) + " x " + String.valueOf(i + 1) + " = " + String.valueOf(value * (i + 1)));

        return v;
    }



}
