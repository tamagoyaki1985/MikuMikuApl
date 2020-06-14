package com.example.mikumikuapl;

import java.io.File;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import android.content.Context;

import java.io.*;
import android.media.*;
import android.media.AudioAttributes;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import androidx.annotation.RequiresApi;


public class MainActivity extends Activity {
    private final String DOWNLOAD_FILE_URL = "http://mikumiku1234.ddns.net/calendar/calendar.wav";

    private ProgressDialog progressDialog;
    private ProgressHandler progressHandler;
    private AsyncFileDownload asyncfiledownload;

    private String voiceFilePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //progressHandler = new ProgressHandler();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void button1_click(View view){
        /*
        initFileLoader();
        showDialog(0);
        progressHandler.progressDialog = progressDialog;
        progressHandler.asyncfiledownload = asyncfiledownload;

        if (progressDialog != null && asyncfiledownload != null){
            progressDialog.setProgress(0);
            progressHandler.sendEmptyMessage(0);
        }else{
            Toast ts = Toast.makeText(this, "NULLエラー", Toast.LENGTH_LONG);
            ts.show();
        }
         */

        //playvoice(voiceFilePath);
        playvoice(DOWNLOAD_FILE_URL);
    }
  //  }
    /*
    private void initFileLoader()
    {
        Context applicationContext = getApplicationContext();
        File sdCard = Environment.getExternalStorageDirectory();
        File directory = new File(String.valueOf(applicationContext.getFilesDir()));
        if(directory.exists() == false){
            if (directory.mkdir() == true){
            }else{
                //
                Toast ts2 = Toast.makeText(this, directory.getAbsolutePath(), Toast.LENGTH_LONG);
                Toast ts1 = Toast.makeText(this, sdCard.getAbsolutePath(), Toast.LENGTH_LONG);
                Toast ts = Toast.makeText(this, "ディレクトリ作成に失敗", Toast.LENGTH_LONG);
                ts.show();
                ts1.show();
                ts2.show();

            }
        }
        File outputFile = new File(directory, "calendar.wav");
        asyncfiledownload = new AsyncFileDownload(this,DOWNLOAD_FILE_URL, outputFile);
        asyncfiledownload.execute();

        Toast ts2 = Toast.makeText(this, directory.getAbsolutePath(), Toast.LENGTH_LONG);
        ts2.show();

        voiceFilePath = directory.getAbsolutePath() + "/calendar.wav";


    //内部メモリの領域を用いる場合
    File dataDir = this.getFilesDir();
    File directory = new File(dataDir.getAbsolutePath()+ "/SampleFolder");
    if(directory.exists() == false){
      if (directory.mkdir() == true){
      }else{
        Toast ts = Toast.makeText(this, "ディレクトリ作成に失敗", Toast.LENGTH_LONG);
        ts.show();
      }
    }
    File outputFile = new File(directory, "test.jpg");
    asyncfiledownload = new AsyncFileDownload(this,DOWNLOAD_FILE_URL, outputFile);
    asyncfiledownload.execute();

    }
    */

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void playvoice(String voicefileurl){
/*
        MediaPlayer mBgmPlayer;
        mBgmPlayer = new MediaPlayer();
        try {
            mBgmPlayer.setDataSource(voiceFilePathStr);
            mBgmPlayer.prepare();
        } catch (IllegalArgumentException e) {
        } catch (SecurityException e) {
        } catch (IllegalStateException e) {
        } catch (IOException e) {
        }
        Toast ts2 = Toast.makeText(this, "ボイスファイル：　" + voiceFilePathStr, Toast.LENGTH_LONG);
        ts2.show();
        mBgmPlayer.start();
 */

        //効果音の再生準備をする
        AudioAttributes audioAttributes = new AudioAttributes
                .Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build();

        MediaPlayer mediaPlayer = new MediaPlayer();

        mediaPlayer.setAudioAttributes(audioAttributes);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try{
            mediaPlayer.setDataSource(voicefileurl);
            mediaPlayer.prepare();
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        } catch (IllegalArgumentException e) {
        } catch (SecurityException e) {
        } catch (IllegalStateException e) {
        } catch (IOException e) {
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        //cancelLoad();
    }

    @Override
    protected void onStop(){
        super.onStop();
        //cancelLoad();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /*
    private void cancelLoad()
    {
        if(asyncfiledownload != null){
            asyncfiledownload.cancel(true);
        }
    }
     */

/*
    @Override
    protected Dialog onCreateDialog(int id){
        switch(id){
            case 0:
                progressDialog = new ProgressDialog(this);
                progressDialog.setIcon(R.mipmap.ic_launcher);
                progressDialog.setTitle("Downloading files..");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Hide",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });

                progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                cancelLoad();
                            }
                        });
        }
        return progressDialog;
    }
*/
}