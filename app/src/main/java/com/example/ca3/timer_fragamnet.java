package com.example.ca3;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class timer_fragamnet extends Fragment {
    MediaPlayer player;
    Button workmode;
    Boolean bl;
    CountDownTimer countdowntimer,breaktimer;
    TextView worktv,breaktv,clock;
    ImageView sound;

    long [] pattern={0,3000,1000};

    long worktime,breaktime;
    SharedPreferences sharedpreference;
    private static final String shared_pref_name ="time";
    private static final String key_work_time ="work_time";
    private static final String key_break_time ="break_time";
    private static final String key_sunday_work_time ="sunday_work_time";
    private static final String key_sunday_break_time ="sunday_break_time";
    private static final String key_monday_work_time ="monday_work_time";
    private static final String key_monday_break_time ="monday_break_time";
    private static final String key_tueday_work_time ="tueday_work_time";
    private static final String key_tueday_break_time ="tueday_break_time";
    private static final String key_wednesday_work_time ="wednesday_work_time";
    private static final String key_wednesday_break_time ="wednesday_break_time";
    private static final String key_thursday_work_time ="thursday_work_time";
    private static final String key_thursday_break_time ="thursday_break_time";
    private static final String key_friday_work_time ="friday_work_time";
    private static final String key_friday_break_time ="friday_break_time";
    private static final String key_saturday_work_time ="saturday_work_time";
    private static final String key_saturday_break_time ="saturday_break_time";

    String sharedworktime;
    String sharedbreaktime;
    String dayOfTheWeek;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.timer,container,false);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ActionBar actionBar;
        actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000000"));
        actionBar.setBackgroundDrawable(colorDrawable);


        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date();
        dayOfTheWeek = sdf.format(d);

        workmode=view.findViewById(R.id.workmode);
        worktv=view.findViewById(R.id.work);
        breaktv=view.findViewById(R.id.breaktv);
        sound=view.findViewById(R.id.sound);
        clock=view.findViewById(R.id.clock);



        worktime=5;
        breaktime=4;


        sharedpreference =getActivity().getSharedPreferences(shared_pref_name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedpreference.edit();
//        Toast.makeText(getApplicationContext(),"in sunday block"+ dayOfTheWeek,Toast.LENGTH_SHORT).show();



        if(dayOfTheWeek.equals("Sunday"))
        {
            sharedworktime=sharedpreference.getString(key_sunday_work_time,null);
            sharedbreaktime=sharedpreference.getString(key_sunday_break_time,null);
            if(sharedworktime!=null && sharedbreaktime!=null)
            {

                worktime= TimeUnit.MINUTES.toMillis(Long.parseLong(sharedworktime));
                breaktime=TimeUnit.MINUTES.toMillis(Long.parseLong(sharedbreaktime));
            }
            else
            {


                editor.putString(key_sunday_work_time,String.valueOf(worktime));
                editor.putString(key_sunday_break_time,String.valueOf(breaktime));
                editor.apply();
            }

        }
        else if(dayOfTheWeek.equals("Monday"))
        {
            sharedworktime=sharedpreference.getString(key_monday_work_time,null);
            sharedbreaktime=sharedpreference.getString(key_monday_break_time,null);
            if(sharedworktime!=null && sharedbreaktime!=null)
            {
                worktime=Long.parseLong(sharedworktime);
                breaktime=Long.parseLong(sharedbreaktime);
            }
            else
            {
                editor.putString(key_monday_work_time,String.valueOf(worktime));
                editor.putString(key_monday_break_time,String.valueOf(breaktime));
                editor.apply();
            }

        }
        else if(dayOfTheWeek.equals("Tuesday"))
        {
            sharedworktime=sharedpreference.getString(key_tueday_work_time,null);
            sharedbreaktime=sharedpreference.getString(key_tueday_break_time,null);
            if(sharedworktime!=null && sharedbreaktime!=null)
            {
                worktime=Long.parseLong(sharedworktime);
                breaktime=Long.parseLong(sharedbreaktime);
            }
            else
            {
                editor.putString(key_tueday_work_time,String.valueOf(worktime));
                editor.putString(key_tueday_break_time,String.valueOf(breaktime));
                editor.apply();
            }

        }
        else if(dayOfTheWeek.equals("Wednesday"))
        {
            sharedworktime=sharedpreference.getString(key_wednesday_work_time,null);
            sharedbreaktime=sharedpreference.getString(key_wednesday_break_time,null);
            if(sharedworktime!=null && sharedbreaktime!=null)
            {
                worktime=Long.parseLong(sharedworktime);
                breaktime=Long.parseLong(sharedbreaktime);
            }
            else
            {
                editor.putString(key_wednesday_work_time,String.valueOf(worktime));
                editor.putString(key_wednesday_break_time,String.valueOf(breaktime));
                editor.apply();
            }

        }
        else if(dayOfTheWeek.equals("Thursday"))
        {
            sharedworktime=sharedpreference.getString(key_thursday_work_time,null);
            sharedbreaktime=sharedpreference.getString(key_thursday_break_time,null);
            if(sharedworktime!=null && sharedbreaktime!=null)
            {
                worktime=Long.parseLong(sharedworktime);
                breaktime=Long.parseLong(sharedbreaktime);
            }
            else
            {
                editor.putString(key_thursday_work_time,String.valueOf(worktime));
                editor.putString(key_thursday_break_time,String.valueOf(breaktime));
                editor.apply();
            }

        }
        else if(dayOfTheWeek.equals("Friday"))
        {
            sharedworktime=sharedpreference.getString(key_friday_work_time,null);
            sharedbreaktime=sharedpreference.getString(key_friday_break_time,null);
            if(sharedworktime!=null && sharedbreaktime!=null)
            {
                worktime=Long.parseLong(sharedworktime);
                breaktime=Long.parseLong(sharedbreaktime);
            }
            else
            {
                editor.putString(key_friday_work_time,String.valueOf(worktime));
                editor.putString(key_friday_break_time,String.valueOf(breaktime));
                editor.apply();
            }

        }
        else if(dayOfTheWeek.equals("Saturday"))
        {
            sharedworktime=sharedpreference.getString(key_saturday_work_time,null);
            sharedbreaktime=sharedpreference.getString(key_saturday_break_time,null);
            if(sharedworktime!=null && sharedbreaktime!=null)
            {
                worktime=Long.parseLong(sharedworktime);
                breaktime=Long.parseLong(sharedbreaktime);
            }
            else
            {
                editor.putString(key_saturday_work_time,String.valueOf(worktime));
                editor.putString(key_saturday_break_time,String.valueOf(breaktime));
                editor.apply();
            }

        }





        bl=false;




        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(player!=null) {

                    player.stop();
                }

            }
        });


        workmode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(bl==false)
                {

                    workmode.setText("workmode off");
                    bl=true;
                    worktv.setText("work");
                    if(countdowntimer!=null)
                    {


                        countdowntimer.cancel();
                        countdowntimer=null;

                    }
                    if(breaktimer!=null)
                    {
                        breaktimer.cancel();
                        breaktimer=null;

                    }
                    settimer();
                    setworktimer(worktime);
                    setbreaktimer(breaktime);
                    countdowntimer.start();



                }
                else
                {

                    workmode.setText("workmode on");
                    bl=false;
                    if(player!=null) {
                        player.stop();
                    }
                    if(countdowntimer!=null)
                    {
                        countdowntimer.cancel();
                        countdowntimer=null;

                    }
                    if(breaktimer!=null)
                    {
                        breaktimer.cancel();
                        breaktimer=null;

                    }
                    worktv.setText("");
                    breaktv.setText("");
                    clock.setText("");
                    player=null;
                }
            }
        });



    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.optionmenu, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.set:

                opendialog();
                return true;
            case R.id.week:
                opendialog1();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    public void opendialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        View view=getLayoutInflater().inflate(R.layout.set,null);

        final EditText worktimes=(EditText)view.findViewById(R.id.worktime);
        final EditText breaktimes=(EditText)view.findViewById(R.id.breaktime);
        Button apply=(Button)view.findViewById(R.id.apply);
        builder.setView(view);
        AlertDialog alertdialog=builder.create();
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(worktimes.getText().toString().length()!=0 && breaktimes.getText().toString().length()!=0)
                {
                    if(countdowntimer!=null)
                    {
                        countdowntimer.cancel();
                        countdowntimer=null;

                    }
                    if(breaktimer!=null)
                    {
                        breaktimer.cancel();
                        breaktimer=null;

                    }

                    worktime=(TimeUnit.MINUTES.toMillis(Long.parseLong(worktimes.getText().toString())));
                    breaktime=(TimeUnit.MINUTES.toMillis(Long.parseLong(breaktimes.getText().toString())));


                    bl=false;
                    if(player!=null)
                    {
                        player.stop();
                    }
                    SharedPreferences sharedpreference =getActivity().getSharedPreferences(shared_pref_name,Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedpreference.edit();

                    if(dayOfTheWeek.equals("Sunday"))
                    {

                        editor.putString(key_sunday_work_time,worktimes.getText().toString());
                        editor.putString(key_sunday_break_time,breaktimes.getText().toString());
                        editor.apply();

                    }
                    if(dayOfTheWeek.equals("Monday"))
                    {

                        editor.putString(key_monday_work_time,worktimes.getText().toString());
                        editor.putString(key_monday_break_time,breaktimes.getText().toString());
                        editor.apply();
                    }
                    if(dayOfTheWeek.equals("Tuesday"))
                    {

                        editor.putString(key_tueday_work_time,worktimes.getText().toString());
                        editor.putString(key_tueday_break_time,breaktimes.getText().toString());
                        editor.apply();

                    }
                    if(dayOfTheWeek.equals("Wednesday"))
                    {

                        editor.putString(key_wednesday_work_time,worktimes.getText().toString());
                        editor.putString(key_wednesday_break_time,breaktimes.getText().toString());
                        editor.apply();

                    }
                    if(dayOfTheWeek.equals("Thursday"))
                    {

                        editor.putString(key_thursday_work_time,worktimes.getText().toString());
                        editor.putString(key_thursday_break_time,breaktimes.getText().toString());
                        editor.apply();

                    }
                    if(dayOfTheWeek.equals("Friday"))
                    {

                        editor.putString(key_friday_work_time,worktimes.getText().toString());
                        editor.putString(key_friday_break_time,breaktimes.getText().toString());
                        editor.apply();;

                    }
                    if(dayOfTheWeek.equals("Saturday"))
                    {

                        editor.putString(key_saturday_work_time,worktimes.getText().toString());
                        editor.putString(key_saturday_break_time,breaktimes.getText().toString());
                        editor.apply();

                    }
                    workmode.setText("workmode on");
                    clock.setText("");
                    bl=false;
                    alertdialog.dismiss();



                }
                else
                {
                    alertdialog.dismiss();
                    Toast.makeText(getContext(),"fill required" , Toast.LENGTH_SHORT).show();
                }
            }
        });


        alertdialog.show();
    }
    public void opendialog1(){
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        View view=getLayoutInflater().inflate(R.layout.weekset,null);
        final EditText sunday_worktimes=(EditText)view.findViewById(R.id.sunday_worktime);
        final EditText sunday_breaktimes=(EditText)view.findViewById(R.id.sunday_breaktime);
        final EditText monday_worktimes=(EditText)view.findViewById(R.id.monday_worktime);
        final EditText monday_breaktimes=(EditText)view.findViewById(R.id.monday_breaktime);
        final EditText tuesday_worktimes=(EditText)view.findViewById(R.id.tuesday_worktime);
        final EditText tuesday_breaktimes=(EditText)view.findViewById(R.id.tuesday_breaktime);
        final EditText wednesday_worktimes=(EditText)view.findViewById(R.id.wednasday_worktime);
        final EditText wednesday_breaktimes=(EditText)view.findViewById(R.id.wednasday_breaktime);
        final EditText thursday_worktimes=(EditText)view.findViewById(R.id.thursday_worktime);
        final EditText thursday_breaktimes=(EditText)view.findViewById(R.id.thursday_breaktime);
        final EditText friday_worktimes=(EditText)view.findViewById(R.id.friday_worktime);
        final EditText friday_breaktimes=(EditText)view.findViewById(R.id.friday_breaktime);
        final EditText saturday_worktimes=(EditText)view.findViewById(R.id.saturday_worktime);
        final EditText saturday_breaktimes=(EditText)view.findViewById(R.id.saturday_breaktime);




        sharedpreference =getActivity().getSharedPreferences(shared_pref_name,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedpreference.edit();

        sunday_worktimes.setText(sharedpreference.getString(key_sunday_work_time,null));
        sunday_breaktimes.setText(sharedpreference.getString(key_sunday_break_time,null));

        monday_worktimes.setText(sharedpreference.getString(key_monday_work_time,null));
        monday_breaktimes.setText(sharedpreference.getString(key_monday_break_time,null));

        tuesday_worktimes.setText(sharedpreference.getString(key_tueday_work_time,null));
        tuesday_breaktimes.setText(sharedpreference.getString(key_tueday_break_time,null));

        wednesday_worktimes.setText(sharedpreference.getString(key_wednesday_work_time,null));
        wednesday_breaktimes.setText(sharedpreference.getString(key_wednesday_break_time,null));

        thursday_worktimes.setText(sharedpreference.getString(key_thursday_work_time,null));
        thursday_breaktimes.setText(sharedpreference.getString(key_thursday_break_time,null));

        friday_worktimes.setText(sharedpreference.getString(key_friday_work_time,null));
        friday_breaktimes.setText(sharedpreference.getString(key_friday_break_time,null));

        saturday_worktimes.setText(sharedpreference.getString(key_saturday_work_time,null));
        saturday_breaktimes.setText(sharedpreference.getString(key_saturday_break_time,null));






        Button apply=(Button)view.findViewById(R.id.apply);
        builder.setView(view);
        AlertDialog alertdialog=builder.create();
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(countdowntimer!=null)
                {
                    countdowntimer.cancel();
                    countdowntimer=null;

                }
                if(breaktimer!=null)
                {
                    breaktimer.cancel();
                    breaktimer=null;

                }
                if(sunday_worktimes.getText().toString().length()!=0)
                {
                    editor.putString(key_sunday_work_time,sunday_worktimes.getText().toString());

                }
                if(sunday_breaktimes.getText().toString().length()!=0)
                {
                    editor.putString(key_sunday_break_time,sunday_breaktimes.getText().toString());
                }
                if(monday_worktimes.getText().toString().length()!=0)
                {
                    editor.putString(key_monday_work_time,monday_worktimes.getText().toString());
                }
                if(monday_breaktimes.getText().toString().length()!=0)
                {
                    editor.putString(key_monday_break_time,monday_breaktimes.getText().toString());
                }
                if(tuesday_worktimes.getText().toString().length()!=0)
                {
                    editor.putString(key_tueday_work_time,tuesday_worktimes.getText().toString());
                }
                if(tuesday_breaktimes.getText().toString().length()!=0)
                {
                    editor.putString(key_tueday_break_time,tuesday_breaktimes.getText().toString());
                }
                if(wednesday_worktimes.getText().toString().length()!=0)
                {
                    editor.putString(key_wednesday_work_time,wednesday_worktimes.getText().toString());
                }
                if(wednesday_breaktimes.getText().toString().length()!=0)
                {
                    editor.putString(key_wednesday_break_time,wednesday_breaktimes.getText().toString());
                }
                if(thursday_worktimes.getText().toString().length()!=0)
                {
                    editor.putString(key_thursday_work_time,thursday_worktimes.getText().toString());
                }
                if(thursday_breaktimes.getText().toString().length()!=0)
                {
                    editor.putString(key_thursday_break_time,thursday_breaktimes.getText().toString());
                }
                if(friday_worktimes.getText().toString().length()!=0)
                {
                    editor.putString(key_friday_work_time,friday_worktimes.getText().toString());
                }
                if(friday_breaktimes.getText().toString().length()!=0)
                {
                    editor.putString(key_friday_break_time,friday_breaktimes.getText().toString());
                }
                if(saturday_worktimes.getText().toString().length()!=0)
                {
                    editor.putString(key_saturday_work_time,saturday_worktimes.getText().toString());
                }
                if(saturday_breaktimes.getText().toString().length()!=0)
                {
                    editor.putString(key_saturday_break_time,saturday_breaktimes.getText().toString());
                }
                editor.apply();
                editor.commit();
                clock.setText("");
                bl=false;
                workmode.setText("workmode on");

                alertdialog.dismiss();

            }
        });


        alertdialog.show();
    }
    public void setworktimer( long worktime)
    {
        countdowntimer=new CountDownTimer(worktime,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String chk=String.format(Locale.ENGLISH,"%02d : %02d",
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)-
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
                clock.setText(chk);

            }

            @Override
            public void onFinish() {
                if(player!=null)
                {
                    player.stop();
                }
                player= MediaPlayer.create(getContext(),R.raw.hello);

                player.start();
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                    vibrator.vibrate(VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE));
//                } else {
//                    vibrator.vibrate(pattern,1000);
//                }
                worktv.setText("");
                breaktv.setText("break");
                Toast.makeText(getContext(),"Take a break buddy",Toast.LENGTH_SHORT).show();
//                vibrator.vibrate(pattern, 0);
                breaktimer.start();

            }
        };
    }
    public void setbreaktimer(long breaktime)
    {
        breaktimer=new CountDownTimer(breaktime,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String chk=String.format(Locale.ENGLISH,"%02d : %02d",
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)-
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
                clock.setText(chk);
            }

            @Override
            public void onFinish() {
                worktv.setText("work");
                breaktv.setText("");
                countdowntimer.start();
                if(player!=null)
                {
                    player.stop();
                }

                player=MediaPlayer.create(getContext(),R.raw.breaks);

                player.start();
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                    vibrator.vibrate(VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE));
//                } else {
//                    vibrator.vibrate(pattern,1000);
//                }
//                vibrator.vibrate(pattern, 0);
                Toast.makeText(getContext(),"comeback to work",Toast.LENGTH_SHORT).show();

            }
        };
    }
    public void settimer()
    {
        SharedPreferences sharedpreference =getActivity().getSharedPreferences(shared_pref_name,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedpreference.edit();

        if(dayOfTheWeek.equals("Sunday"))
        {

            worktime=(TimeUnit.MINUTES.toMillis(Long.parseLong(sharedpreference.getString(key_sunday_work_time,null))));
            breaktime=(TimeUnit.MINUTES.toMillis(Long.parseLong(sharedpreference.getString(key_sunday_break_time,null))));


        }
        if(dayOfTheWeek.equals("Monday"))
        {

            worktime=(TimeUnit.MINUTES.toMillis(Long.parseLong(sharedpreference.getString(key_monday_work_time,null))));
            breaktime=(TimeUnit.MINUTES.toMillis(Long.parseLong(sharedpreference.getString(key_monday_break_time,null))));

        }
        if(dayOfTheWeek.equals("Tuesday"))
        {

            worktime=(TimeUnit.MINUTES.toMillis(Long.parseLong(sharedpreference.getString(key_tueday_work_time,null))));
            breaktime=(TimeUnit.MINUTES.toMillis(Long.parseLong(sharedpreference.getString(key_tueday_break_time,null))));

        }if(dayOfTheWeek.equals("Wednesday"))
    {

        worktime=(TimeUnit.MINUTES.toMillis(Long.parseLong(sharedpreference.getString(key_wednesday_work_time,null))));
        breaktime=(TimeUnit.MINUTES.toMillis(Long.parseLong(sharedpreference.getString(key_wednesday_break_time,null))));

    }if(dayOfTheWeek.equals("Thursday"))
    {

        worktime=(TimeUnit.MINUTES.toMillis(Long.parseLong(sharedpreference.getString(key_thursday_work_time,null))));
        breaktime=(TimeUnit.MINUTES.toMillis(Long.parseLong(sharedpreference.getString(key_thursday_break_time,null))));

    }if(dayOfTheWeek.equals("Friday"))
    {

        worktime=(TimeUnit.MINUTES.toMillis(Long.parseLong(sharedpreference.getString(key_friday_work_time,null))));
        breaktime=(TimeUnit.MINUTES.toMillis(Long.parseLong(sharedpreference.getString(key_friday_break_time,null))));

    }
        if(dayOfTheWeek.equals("Saturday"))
        {

            worktime=(TimeUnit.MINUTES.toMillis(Long.parseLong(sharedpreference.getString(key_saturday_work_time,null))));
            breaktime=(TimeUnit.MINUTES.toMillis(Long.parseLong(sharedpreference.getString(key_saturday_break_time,null))));

        }

    }




    @Override
    public void onStart() {
        Toast.makeText(getContext(),"Onstar",Toast.LENGTH_SHORT).show();
        super.onStart();
    }
}
