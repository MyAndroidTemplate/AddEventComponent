package com.example.eventdetect;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements IGeneratedEvent{
    private long ellapsed = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ellapsed = System.currentTimeMillis();
        SaveToLog("onCreate called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        SaveToLog("onStart called, time elapsed: " + (System.currentTimeMillis() - ellapsed) + " ms");
        ellapsed = System.currentTimeMillis();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SaveToLog("onResume called, time elapsed: " + (System.currentTimeMillis() - ellapsed) + " ms");
        ellapsed = System.currentTimeMillis();
    }

    @Override
    protected void onPause() {
        super.onPause();
        SaveToLog("onPause called, time elapsed: " + (System.currentTimeMillis() - ellapsed) + " ms");
        ellapsed = System.currentTimeMillis();
    }

    @Override
    protected void onStop() {
        super.onStop();
        SaveToLog("onStop called, time elapsed: " + (System.currentTimeMillis() - ellapsed) + " ms");
        ellapsed = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SaveToLog("onDestroy called, time elapsed: " + (System.currentTimeMillis() - ellapsed) + " ms");
    }
    /**
     * Пишет сообщения в лог
     * Accept new message for Log
     * @param message
     */
    public void SaveToLog(String message)
    {
        if(message.length() > 0)
        {
            Log.i(TAG, message);
        }else{
           ShowToastMessage("SaveToLog method an returned answer: Nothing to save");
        }
    }

    /**
     * Показывает всплывающее сообщение
     * Show message in the tips
     * @param msg
     */
    public void ShowToastMessage(String msg)
    {
        Toast toast= null;
        if(msg.length() > 0)
        {
             toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
             toast.show();
        }else{
             toast=Toast.makeText(this,"ShowToastMessage answer:  Nothing message show you", Toast.LENGTH_LONG);
             toast.show();
        }
    }

    /**
     * Устанавливаем значение для TextView
     * Set value for current TextView
     * @param msg
     */
    public void SetToTextField(String msg)
    {
        if(msg != null)
        {
            TextView text = findViewById(R.id.textView);
                     text.setText(msg);
        }else{
            ShowToastMessage("SetToTextField method an returned answer: Nothing to save");
        }
    }

    @Override
    public void GeneratedEvent(View view) {
        try{
            switch(view.getId())
            {
                case R.id.EventGenerated:
                    SaveToLog("Start generated click");
                    SaveToLog("Someone press the button");
                    SetToTextField("Someone pressed the button");
                    break;
                case R.id.textView:
                    SetToTextField("Someone TextView pressed");
                    SaveToLog("Someone pressed TextView component");
                    break;
                default:
                    ShowToastMessage("Action is not defined");
                    break;
            }
        }catch(Exception ex)
        {
            Log.e(TAG,"Abort. Reason: " + ex.getMessage());
        }
    }
}