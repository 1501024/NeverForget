package jp.ac.asojuku.st.neverforget;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;



public class PropertyFragment extends Fragment {


    public static Fragment newInstance(Context context) {
        PropertyFragment f = new PropertyFragment();
        return f;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root =(ViewGroup)inflater.inflate(R.layout.fragment_property,null);
        return root;
    }

    @Override
    public void onPause() {
        super.onPause();

        EditText edText1=(EditText)getView().findViewById(R.id.editText1);
        EditText edText2=(EditText)getView().findViewById(R.id.editText2);

        String car;
            car=edText1.getText().toString();
        int phone;
        try{
            phone=Integer.parseInt(edText2.getText().toString());
        }catch(NumberFormatException e){
            phone=0;
        }

        SharedPreferences prefs=this.getActivity().getSharedPreferences("property",Context.MODE_APPEND);
        SharedPreferences.Editor editor=prefs.edit();
        editor.putString("car",car);
        editor.putInt("phone",phone);
        editor.apply();
    }

    @Override
    public  void onResume(){
        super.onResume();
        SharedPreferences prefs =this.getActivity().getSharedPreferences("property",Context.MODE_PRIVATE);
        String car     =prefs.getString("car","a");
        int phone   =prefs.getInt("phone",0);

        EditText edText1=(EditText)getView().findViewById(R.id.editText1);
        if(car !="a"){
            edText1.setText(car);
        }
        EditText edText2=(EditText)getView().findViewById(R.id.editText2);
        if(phone !=0){
            edText2.setText(Integer.toString(phone));
        }

    }


}