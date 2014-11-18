package com.example.buttondemo;

import java.io.File;
import java.io.FileOutputStream;

import android.annotation.TargetApi;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
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
		newButton.setText("NewDial");
		
		Button callButton=new Button(this);
		callButton.setText("NewCall");
		
		//创建内存文件
		Button fileButton=new Button(this);
		fileButton.setText("CreateFileOnInternalStorage");
		
		//创建外部存储文件
		Button fileButton2=new Button(this);
		fileButton2.setText("CreateFileOnExternalStorage");
		
		LinearLayout layout=(LinearLayout)findViewById(R.id.Relative1);
		layout.addView(newButton,LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layout.addView(callButton,LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layout.addView(fileButton,LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		layout.addView(fileButton2,LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

		
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
		
		//add Button event-dial
		newButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//电话拨号的两种方式dial和call
				Intent newIntent=new Intent();
				newIntent.setAction(Intent.ACTION_DIAL);
				newIntent.setData(Uri.parse("tel:15279116211"));
				startActivity(newIntent);
				//Toast.makeText(getApplicationContext(), "Hello,I'm newButton!", Toast.LENGTH_SHORT).show();
			}
			
		});
		
		//call，这种方式需要在Manifest中添加permission
		callButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent newIntent2=new Intent();
				newIntent2.setAction(Intent.ACTION_CALL);
				newIntent2.setData(Uri.parse("tel:13133808238"));
				startActivity(newIntent2);
			}
			
		});
		
		//在Internal Storage上新建文件
		fileButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String filename="myfile.txt";
				File file=new File(MainActivity.this.getFilesDir(),filename);
				String str="Hello world!";
				FileOutputStream outputStream;
				try{
					outputStream=openFileOutput(filename,Context.MODE_PRIVATE);
					outputStream.write(str.getBytes());
					outputStream.close();
					Toast.makeText(getApplicationContext(), "filePath:"+file.getPath(), Toast.LENGTH_SHORT).show();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		
		//在Internal Storage上新建文件
				fileButton2.setOnClickListener(new OnClickListener(){

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
							File file=new File(Environment.getExternalStorageDirectory(),"files.txt");
							String str="Hello world!";
							try{
								FileOutputStream outputStream=new FileOutputStream(file);
								outputStream.write(str.getBytes());
								outputStream.close();
								Toast.makeText(getApplicationContext(), "ExternalfilePath2:"+file.getPath(), Toast.LENGTH_SHORT).show();
							}catch(Exception e){
								e.printStackTrace();
							}
						}
						else
							Toast.makeText(getApplicationContext(), "No ExternalStorage!", Toast.LENGTH_SHORT).show();
						
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
