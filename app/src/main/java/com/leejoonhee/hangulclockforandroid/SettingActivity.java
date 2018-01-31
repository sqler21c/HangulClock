package com.leejoonhee.hangulclockforandroid;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity
{
    SharedPreferences sets;
    EditText words;

    ImageView image;
    TextView sentence;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        image = (ImageView)findViewById(R.id.backgroud);
        sentence = (TextView)findViewById(R.id.title);

        words = (EditText)findViewById(R.id.editText1); //표시할문자 값을 받아주기위해 선언하였습니다

        sets = getSharedPreferences("usersets", Activity.MODE_PRIVATE); //MainActivity가 꺼져도 NewAppWidget에서 값을 받아 올 수 있도록 SharedPreference를 사용하였습니다
        words.setText(sets.getString("title", "언젠가는 빛이 될 당신"));

        if (sets.getInt("color", 0) == 1){
            image.setImageResource(R.drawable.hangulclock_board_white_prev);
            sentence.setTextColor(Color.WHITE);
        }

        if(sets.getInt("color", 0) == 2){
            image.setImageResource(R.drawable.hangulclock_board_black_prev);
            sentence.setTextColor(Color.BLACK);
        }

        if (sets.getInt("color", 0) == 3){
            image.setImageResource(R.drawable.hangulclock_board_pink_prev);
            sentence.setTextColor(getResources().getColor(R.color.pink));
        }

        if (sets.getInt("color", 0) == 4){
            image.setImageResource(R.drawable.hangulclock_board_red_prev);
            sentence.setTextColor(getResources().getColor(R.color.red));
        }

        if (sets.getInt("color", 0) == 5){
            image.setImageResource(R.drawable.hangulclock_board_orange_prev);
            sentence.setTextColor(getResources().getColor(R.color.orange));
        }

        if (sets.getInt("color", 0) == 6){
            image.setImageResource(R.drawable.hangulclock_board_green_prev);
            sentence.setTextColor(getResources().getColor(R.color.green));
        }

        if (sets.getInt("color", 0) == 7){
            image.setImageResource(R.drawable.hangulclock_board_bluegreen_prev);
            sentence.setTextColor(getResources().getColor(R.color.bluegreen));
        }
    }

    public void save(View v){
        SharedPreferences.Editor editor = sets.edit();
        editor.putString("title", words.getText().toString()); //edittext에서 얻어온 값을 title로 저장합니다.
        editor.commit();

        sentence.setText(sets.getString("title", "receivingfail"));

        Toast.makeText(getApplicationContext(), "적용되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void setwhite(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 1); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(Color.WHITE);
        image.setImageResource(R.drawable.hangulclock_board_white_prev);
        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void setblack(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 2); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(Color.BLACK);
        image.setImageResource(R.drawable.hangulclock_board_black_prev);
        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void setpink(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 3); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.pink));
        image.setImageResource(R.drawable.hangulclock_board_pink_prev);
        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void setred(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 4); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.red));
        image.setImageResource(R.drawable.hangulclock_board_red_prev);
        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void setorange(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 5); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.orange));
        image.setImageResource(R.drawable.hangulclock_board_orange_prev);
        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void setgreen(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 6); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.green));
        image.setImageResource(R.drawable.hangulclock_board_green_prev);
        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void setbluegreen(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 7); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.bluegreen));
        image.setImageResource(R.drawable.hangulclock_board_bluegreen_prev);
        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

}

