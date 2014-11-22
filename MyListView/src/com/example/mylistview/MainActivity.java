package com.example.mylistview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends Activity implements OnItemClickListener {
	
	private ListView listview;
	private List<itemInfo> lists;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listview=(ListView)findViewById(R.id.listview);
		lists=getLists();
		listview.setAdapter(new MyAdapter(this,lists));
		listview.setOnItemClickListener(this);
	}
	
	/**
	 * ��������
	 * @return
	 */
	private List<itemInfo> getLists(){
		List<itemInfo> lists=new ArrayList<itemInfo>();
		for(int i=0;i<20;i++){
			itemInfo info=new itemInfo();
			info.setPicture(R.drawable.fileholer);
			info.setTitle("���Ǳ���"+i);
			info.setIntroduce("���Ǽ��"+i);
			lists.add(info);
		}
		return lists;
	}

	@Override
	public void onItemClick(AdapterView<?> view, View arg1, int position, long arg3) {
		// TODO Auto-generated method stub
		//Toast.makeText(this, ((itemInfo)view.getItemAtPosition(position)).getTitle(), 0).show();
		Intent intent=new Intent(MainActivity.this,DetailList.class);
		startActivity(intent);
	}
}
