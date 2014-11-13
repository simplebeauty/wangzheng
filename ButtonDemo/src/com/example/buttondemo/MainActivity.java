package com.example.buttondemo;

import android.annotation.TargetApi;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		//add a new Button
		Button newButton=new Button(this);
		newButton.setText("NewButton");
		
		LinearLayout layout=(LinearLayout)findViewById(R.id.Relative1);
		layout.addView(newButton,LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

		
		Button button2=(Button)this.findViewById(R.id.button1111);
		
		button2.setText("SecondButton");
		
		int buttonId=newButton.getId();
		
		Log.i("ButtonID","kk:"+Integer.toString(buttonId));
		
		//add Button event
		button2.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.i("Hello,","I'am Here!");
				//Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_LONG).show();
				
				Intent intent=new Intent(MainActivity.this,ShowActivity.class);
				intent.putExtra("SomeInfo", "你好，I'am a message!");
				//如何start两个Activity就会导致要返回两次
				//startActivity(intent);
				startActivityForResult(intent, 1234);
			}
		});
		
		//add Button event
		newButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Hello,I'm newButton!", Toast.LENGTH_SHORT).show();
			}
			
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if(resultCode==4321){
			String resultValue=data.getExtras().getString("SomeInfo");
			Toast.makeText(getApplicationContext(), resultValue, Toast.LENGTH_SHORT).show();
		}
		
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	
}
