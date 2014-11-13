package com.example.buttondemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ShowActivity extends Activity {
	Intent mintent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_layout);
		
		mintent=this.getIntent();
		
		String InfoValue;
		if(mintent!=null)
		{
			InfoValue=mintent.getExtras().getString("SomeInfo");
			Toast.makeText(this, InfoValue, Toast.LENGTH_SHORT).show();
			TextView textView=(TextView)findViewById(R.id.textView1);
			textView.setText(InfoValue);
		}
		
		
		Button _button=(Button)findViewById(R.id.button1);
		
		_button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mintent.putExtra("SomeInfo", "zheng 你好！");
				setResult(4321, mintent);
				//关闭当前Activity
				finish();
			}
			
		});
	}
	

}
