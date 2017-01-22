package jp.ac.asojuku.st.neverforget;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;



public class MemorialFragment extends Fragment {


    public static Fragment newInstance(Context context) {
        MemorialFragment f = new MemorialFragment();
        return f;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root =(ViewGroup)inflater.inflate(R.layout.fragment_memorial,null);
        return root;
    }

    @Override
    public void onPause() {
        super.onPause();

        EditText edText1=(EditText)getView().findViewById(R.id.editText1);
        EditText edText2=(EditText)getView().findViewById(R.id.editText2);
        EditText edText3=(EditText)getView().findViewById(R.id.editText3);
        EditText edText4=(EditText)getView().findViewById(R.id.editText4);
        EditText edText5=(EditText)getView().findViewById(R.id.editText5);

        int wedding;
        try{
            wedding=Integer.parseInt(edText1.getText().toString());
        }catch(NumberFormatException e){
            wedding=0;
        }
        int birthday;
        try{
            birthday=Integer.parseInt(edText2.getText().toString());
        }catch(NumberFormatException e){
            birthday=0;
        }
        int birthday1;
        try{
            birthday1=Integer.parseInt(edText3.getText().toString());
        }catch(NumberFormatException e){
            birthday1=0;
        }
        int birthday2;
        try{
            birthday2=Integer.parseInt(edText4.getText().toString());
        }catch(NumberFormatException e){
            birthday2=0;
        }
        int birthday3;
        try{
            birthday3=Integer.parseInt(edText5.getText().toString());
        }catch(NumberFormatException e){
            birthday3=0;
        }

        SharedPreferences prefs=this.getActivity().getSharedPreferences("mymemory",Context.MODE_APPEND);
        SharedPreferences.Editor editor=prefs.edit();
        editor.putInt("wedding",wedding);
        editor.putInt("birthday",birthday);
        editor.putInt("birthday1",birthday1);
        editor.putInt("birthday2",birthday2);
        editor.putInt("birthday3",birthday3);
        editor.apply();
    }

    @Override
    public  void onResume(){
        super.onResume();
        SharedPreferences prefs =this.getActivity().getSharedPreferences("mymemory",Context.MODE_PRIVATE);
        int birthday    =prefs.getInt("birthday",0);
        int birthday1   =prefs.getInt("birthday1",0);
        int birthday2   =prefs.getInt("birthday2",0);
        int birthday3   =prefs.getInt("birthday3",0);
        int wedding   =prefs.getInt("wedding",0);

        EditText edText1=(EditText)getView().findViewById(R.id.editText1);
        if(wedding !=0){
            edText1.setText(Integer.toString(wedding));
        }
        EditText edText2=(EditText)getView().findViewById(R.id.editText2);
        if(birthday !=0){
            edText2.setText(Integer.toString(birthday));
        }
        EditText edText3=(EditText)getView().findViewById(R.id.editText3);
        if(birthday1 !=0){
            edText3.setText(Integer.toString(birthday1));
        }
        EditText edText4=(EditText)getView().findViewById(R.id.editText4);
        if(birthday2 !=0){
            edText4.setText(Integer.toString(birthday2));
        }
        EditText edText5=(EditText)getView().findViewById(R.id.editText5);
        if(birthday3 !=0){
            edText4.setText(Integer.toString(birthday3));
        }

    }


}