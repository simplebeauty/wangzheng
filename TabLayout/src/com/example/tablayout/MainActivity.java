package com.example.tablayout;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

@SuppressWarnings("这是怎么了？")
public class MainActivity extends TabActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Resources res=getResources(); 
		TabHost tabHost=getTabHost();
		TabHost.TabSpec spec;
		Intent intent;
		
		intent=new Intent().setClass(this,ArtistsActivity.class);
		spec=tabHost.newTabSpec("artists").setIndicator("Artists",res.getDrawable(R.drawable.ic_tab_artists)).setContent(intent);
		tabHost.addTab(spec);
		
		intent=new Intent().setClass(this,AlbumsActivity.class);
		spec=tabHost.newTabSpec("albums").setIndicator("Albums", res.getDrawable(R.drawable.ic_tab_albums)).setContent(intent);
		tabHost.addTab(spec);
		
		intent=new Intent().setClass(this,SongsActivity.class);
		spec=tabHost.newTabSpec("songs").setIndicator("Songs", res.getDrawable(R.drawable.ic_tab_songs)).setContent(intent);
		tabHost.addTab(spec);
		tabHost.setCurrentTab(0);
	}
	
}
