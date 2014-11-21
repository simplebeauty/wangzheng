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
	 * ���캯��
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
	 * ����Ҫ�ķ�����ÿ����һ��item��ʱ�򶼻�ִ����������������������ʵ��������item��ÿ���ؼ��İ�
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		// convertView�������item�Ľ������ֻ��Ϊ�յ�ʱ�����ǲ���Ҫ���¸�ֵһ�Σ������������Ч�ʣ�������������Ļ���ϵͳ���Զ�����  
        //item_listview�����Զ����item�Ĳ����ļ� 
		if(convertView==null){
			convertView=layoutInflater.inflate(R.layout.item_listview, null);
		}
		//ע��findViewById��ʱ��Ҫʹ��convertView�������������Ϊ������������пؼ���Ѱ��  
		img=(ImageView) convertView.findViewById(R.id.img);
		tv1=(TextView) convertView.findViewById(R.id.tv1);
		tv2=(TextView) convertView.findViewById(R.id.tv2);
		
		img.setBackgroundResource(lists.get(position).getPicture());
		tv1.setText(lists.get(position).getTitle());
		tv2.setText(lists.get(position).getIndroduce());
		
		
		return convertView;
	}

}
