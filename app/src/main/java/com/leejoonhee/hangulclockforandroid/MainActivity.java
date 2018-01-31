package com.leejoonhee.hangulclockforandroid;

import android.net.Uri;
import android.os.*;
import android.support.v7.app.*;
import android.view.*;
import android.content.*;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity
{
	DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
	DatabaseReference download = rootRef.child("downloads");
	DatabaseReference version = rootRef.child("version");
	TextView mversion;
	TextView mdownloads;
	private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		// Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
		MobileAds.initialize(this, "ca-app-pub-8081631582008293~8449303451");

		mAdView = findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);

		mversion = (TextView)findViewById(R.id.version);
		mdownloads = (TextView)findViewById(R.id.download);
	}
	
	public void setting(View v){
		startActivity(new Intent(this, SettingActivity.class));
	}
	
	public void help(View v){
		startActivity(new Intent(this, HelpActivity.class));
	}

	public void pc(View v){
		String url ="https://github.com/dsa28s/windows-hangul-clock";
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		startActivity(intent);
	}

	public void android(View v){
		String url ="https://github.com/neo81389/HangulClock";
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		startActivity(intent);
	}

	public void update(View v){
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.leejoonhee.hangulclockforandroid"));
		startActivity(intent);
	}

	@Override
	protected void onStart(){
		super.onStart();

		download.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				String text = dataSnapshot.getValue(String.class);

				mdownloads.setText(text);
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {

			}
		});

		version.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				String text = dataSnapshot.getValue(String.class);

				if(text.equals("1.7"))
					mversion.setText("현재 최신버전입니다");

				else
					mversion.setText("[업데이트하러가기]");
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {

			}
		});

	}

}
