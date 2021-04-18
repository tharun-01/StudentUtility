package com.example.ca3;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Notes extends Fragment  implements View.OnClickListener {

    Button submit;
    EditText ed;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notes, container, false);
        submit=view.findViewById(R.id.submit);
        ed=view.findViewById(R.id.ed);
        if(!ExternalStorageAvailable())
            submit.setEnabled(false);
        submit.setOnClickListener(this);
        return view;

    }

    private boolean ExternalStorageAvailable() {
        String sState = Environment.getExternalStorageState();
        return  sState.equals(Environment.MEDIA_MOUNTED);
    }

    @Override
    public void onClick(View v) {

        File fol = getActivity().getExternalFilesDir("Notes");

        File file = new File(fol,"Note.text");
        FileOutputStream fOutput = null;
        try {
            fOutput = new FileOutputStream(file);
            fOutput.write(ed.getText().toString().getBytes());
            Toast.makeText(getActivity(),"Notes updated",Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(fOutput != null){
                try{
                    fOutput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }

    }
}