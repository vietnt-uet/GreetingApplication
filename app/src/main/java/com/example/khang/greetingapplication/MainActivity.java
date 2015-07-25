package com.example.khang.greetingapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener {
    String TAG = "MainActivity";
    SharedPreferences mSharedPref;

    Context mContext;
    EditText mEdtName;
    Button mBtnSwicht;

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart");
        String name = mSharedPref.getString(Common.NAME,"");
        mEdtName.setText(name);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putString(Common.NAME, mEdtName.getText().toString());
        editor.commit();
        //editor.apply();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSharedPref = getSharedPreferences(Common.GREETING_PREF,MODE_PRIVATE);
        mContext = this;

        mEdtName = (EditText) findViewById(R.id.edtName);
        mBtnSwicht = (Button) findViewById(R.id.btnSwicht);
        mBtnSwicht.setOnClickListener(this);
        Log.i(TAG, "onCreate");
    }

//    public void clickButton(View v){
//        Toast.makeText(mContext,"Click vao button",Toast.LENGTH_SHORT).show();
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(MainActivity.this,MainActivity2Activity.class);
        Bundle extras = new Bundle();
        extras.putString(Common.NAME,mEdtName.getText().toString());
        i.putExtras(extras);
        startActivity(i);
    }
}
