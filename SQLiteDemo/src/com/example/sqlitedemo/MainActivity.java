package com.example.sqlitedemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends Activity {
	
	private DBManager mgr;
	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listView=(ListView)findViewById(R.id.listView1);
		//��ʼ��DBManager
		mgr=new DBManager(this);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		//Ӧ�õ����һ��Activity�ر�ʱӦ�ͷ�DB
		mgr.closeDB();
	}
	
	public void add(View view){
		ArrayList<Person> persons=new ArrayList<Person>();
		
		Person person1=new Person("Ivory",19,"lovely girl");
		Person person2=new Person("Jack",22,"lovely shit");
		Person person3=new Person("Tom",23,"lovely boy");
		Person person4=new Person("Kelly",25,"lovely baby");
		Person person5=new Person("Jane",22,"lovely woman");
		
		persons.add(person1);
		persons.add(person2);
		persons.add(person3);
		persons.add(person4);
		persons.add(person5);
		
		mgr.add(persons);
	}
	
	public void update(View view){
		Person person=new Person();
		person.name="Jane";
		person.age=30;
		mgr.updateAge(person);
	}
	
	public void delete(View view){
		Person person=new Person();
		person.age=30;
		mgr.deleteOldPerson(person);
	}
	
	public void query(View view){
		List<Person> persons=mgr.query();
		ArrayList<Map<String,String>> list=new ArrayList<Map<String,String>>();
		for(Person person : persons){
			HashMap<String,String> map=new HashMap<String,String>();
			map.put("name",person.name);
			map.put("info",person.age+" years old, "+person.info);
			list.add(map);
		}
		SimpleAdapter adaper=new SimpleAdapter(this,list,android.R.layout.simple_list_item_2,
				new String[]{"name","info"},new int[]{android.R.id.text1,android.R.id.text2});
		
		listView.setAdapter(adaper);
	}
	
	@SuppressWarnings("deprecation")
	public void queryTheCursor(View view){
		Cursor c=mgr.queryTheCursor();
		startManagingCursor(c);   //�и���Activity�����Լ�����������ȥ����Cursor����������
		CursorWrapper cursorWrapper=new CursorWrapper(c){
			public String getString(int columnIndex){
				//�����ǰ��������
				if(getColumnName(columnIndex).equals("info")){
					int age=getInt(getColumnIndex("age"));
					return age+" years old, "+super.getString(columnIndex);
				}
				return super.getString(columnIndex);
			}
		};
		
		//ȷ����ѯ�������"_id����
		@SuppressWarnings("deprecation")
		SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,
				cursorWrapper,new String[]{"name","info"},new int[]{android.R.id.text1,android.R.id.text2});
		
		ListView listView=(ListView)findViewById(R.id.listView1);
		listView.setAdapter(adapter);
	}
}
