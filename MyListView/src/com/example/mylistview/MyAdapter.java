package com.example.mylistview;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	private Context context;
	private List<itemInfo> lists;
	private LayoutInflater layoutInflater;
	ImageView img;
	TextView tv1;
	TextView tv2;
	
	/**
	 * 构造函数
	 * @param context
	 * @param lists
	 */
	public MyAdapter(Context context,List<itemInfo> lists){
		this.context=context;
		this.lists=lists;
		this.layoutInflater=LayoutInflater.from(context);
	}
	
	

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return lists.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return lists.get(arg0);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	
	/**
	 * 最重要的方法，每生生一个item的时候都会执行这个方法，在这个方法中实现数据与item中每个控件的绑定
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		// convertView对象就是item的界面对象，只有为空的时候我们才需要重新赋值一次，这样可以提高效率，如果有这个对象的话，系统会自动复用  
        //item_listview就是自定义的item的布局文件 
		if(convertView==null){
			convertView=layoutInflater.inflate(R.layout.item_listview, null);
		}
		//注意findViewById的时候，要使用convertView的这个方法，因为是在它里面进行控件的寻找  
		img=(ImageView) convertView.findViewById(R.id.img);
		tv1=(TextView) convertView.findViewById(R.id.tv1);
		tv2=(TextView) convertView.findViewById(R.id.tv2);
		
		img.setBackgroundResource(lists.get(position).getPicture());
		tv1.setText(lists.get(position).getTitle());
		tv2.setText(lists.get(position).getIndroduce());
		
		
		return convertView;
	}

}
