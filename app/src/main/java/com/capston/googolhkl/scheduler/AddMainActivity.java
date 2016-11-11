package com.capston.googolhkl.scheduler;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.capston.googolhkl.schduler.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by googolhkl on 2016. 11. 11..
 */

public class AddMainActivity extends Activity {
    int i=0;
    String time = "";
    ToggleButton tb;
    HashSet<String> set = new HashSet<String>();
    private ArrayList<ClassInformation> ci;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmain);


        intent = getIntent();
        ci = (ArrayList<ClassInformation>) intent.getSerializableExtra("data");

        Log.d("STATE ci size =", Integer.toString(ci.size()));

        for(int i=0; i< ci.size(); i++) {
            String[] test = ci.get(i).getTime().split(" ");
            for (int j = 0; j < test.length; j++) {
                ToggleButton button = (ToggleButton) findViewById(getDaysID(test[j]));
                button.setBackgroundColor(Color.argb(80,0,0,0));
                button.setEnabled(false);
            }
        }



        ((ToggleButton)findViewById(R.id.addmon1)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("mon1");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("mon1");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addmon2)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("mon2");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("mon2");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addmon3)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("mon3");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("mon3");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addmon4)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("mon4");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("mon4");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addmon5)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("mon5");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("mon5");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addmon6)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("mon6");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("mon6");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addmon7)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("mon7");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("mon7");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addmon8)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("mon8");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("mon8");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addmon9)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("mon9");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("mon9");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addmon10)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("mon10");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("mon10");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addmon11)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("mon11");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("mon11");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addmon12)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("mon12");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("mon12");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addmon13)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("mon13");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("mon13");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addmon14)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("mon14");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("mon14");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addmon15)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("mon15");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("mon15");
                }
            }
        });

        // 닫기 눌렀을 때
        findViewById(R.id.cancle_btn).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        // 추가 눌렀을 때
        findViewById(R.id.add_btn).setOnClickListener( new Button.OnClickListener() {
            public void onClick(View v) {
                for(Iterator it = set.iterator(); it.hasNext();){
                    time += it.next() + " ";
                }
                Toast.makeText(AddMainActivity.this,"string=" +time.trim() ,Toast.LENGTH_LONG).show();

                Intent intentSubActivity =new Intent(AddMainActivity.this, AddClassActivity.class);
                intentSubActivity.putExtra("time",time);
                startActivity(intentSubActivity);
                finish();
            }
        });

    }

    Integer getDaysID(String str)
    {
        if(str.equals("mon1"))
            return R.id.addmon1;
        else if(str.equals("mon2"))
            return R.id.addmon2;
        else if(str.equals("mon3"))
            return R.id.addmon3;
        else if(str.equals("mon4"))
            return R.id.addmon4;
        else if(str.equals("mon5"))
            return R.id.addmon5;
        else if(str.equals("mon6"))
            return R.id.addmon6;
        else if(str.equals("mon7"))
            return R.id.addmon7;
        else if(str.equals("mon8"))
            return R.id.addmon8;
        else if(str.equals("mon9"))
            return R.id.addmon9;
        else if(str.equals("mon10"))
            return R.id.addmon10;
        else if(str.equals("mon11"))
            return R.id.addmon11;
        else if(str.equals("mon12"))
            return R.id.addmon12;
        else if(str.equals("mon13"))
            return R.id.addmon13;
        else if(str.equals("mon14"))
            return R.id.addmon14;
        else if(str.equals("mon15"))
            return R.id.addmon15;
        else if(str.equals("tue1"))
            return R.id.addtue1;
        else if(str.equals("tue2"))
            return R.id.addtue2;
        else if(str.equals("tue3"))
            return R.id.addtue3;
        else if(str.equals("tue4"))
            return R.id.addtue4;
        else if(str.equals("tue5"))
            return R.id.addtue5;
        else if(str.equals("tue6"))
            return R.id.addtue6;
        else if(str.equals("tue7"))
            return R.id.addtue7;
        else if(str.equals("tue8"))
            return R.id.addtue8;
        else if(str.equals("tue9"))
            return R.id.addtue9;
        else if(str.equals("tue10"))
            return R.id.addtue10;
        else if(str.equals("tue11"))
            return R.id.addtue11;
        else if(str.equals("tue12"))
            return R.id.addtue12;
        else if(str.equals("tue13"))
            return R.id.addtue13;
        else if(str.equals("tue14"))
            return R.id.addtue14;
        else if(str.equals("tue15"))
            return R.id.addtue15;
        else if(str.equals("wed1"))
            return R.id.addwed1;
        else if(str.equals("wed2"))
            return R.id.addwed2;
        else if(str.equals("wed3"))
            return R.id.addwed3;
        else if(str.equals("wed4"))
            return R.id.addwed4;
        else if(str.equals("wed5"))
            return R.id.addwed5;
        else if(str.equals("wed6"))
            return R.id.addwed6;
        else if(str.equals("wed7"))
            return R.id.addwed7;
        else if(str.equals("wed8"))
            return R.id.addwed8;
        else if(str.equals("wed9"))
            return R.id.addwed9;
        else if(str.equals("wed10"))
            return R.id.addwed10;
        else if(str.equals("wed11"))
            return R.id.addwed11;
        else if(str.equals("wed12"))
            return R.id.addwed12;
        else if(str.equals("wed13"))
            return R.id.addwed13;
        else if(str.equals("wed14"))
            return R.id.addwed14;
        else if(str.equals("wed15"))
            return R.id.addwed15;
        else if(str.equals("thu1"))
            return R.id.addthu1;
        else if(str.equals("thu2"))
            return R.id.addthu2;
        else if(str.equals("thu3"))
            return R.id.addthu3;
        else if(str.equals("thu4"))
            return R.id.addthu4;
        else if(str.equals("thu5"))
            return R.id.addthu5;
        else if(str.equals("thu6"))
            return R.id.addthu6;
        else if(str.equals("thu7"))
            return R.id.addthu7;
        else if(str.equals("thu8"))
            return R.id.addthu8;
        else if(str.equals("thu9"))
            return R.id.addthu9;
        else if(str.equals("thu10"))
            return R.id.addthu10;
        else if(str.equals("thu11"))
            return R.id.addthu11;
        else if(str.equals("thu12"))
            return R.id.addthu12;
        else if(str.equals("thu13"))
            return R.id.addthu13;
        else if(str.equals("thu14"))
            return R.id.addthu14;
        else if(str.equals("thu15"))
            return R.id.addthu15;
        else if(str.equals("fri1"))
            return R.id.addfri1;
        else if(str.equals("fri2"))
            return R.id.addfri2;
        else if(str.equals("fri3"))
            return R.id.addfri3;
        else if(str.equals("fri4"))
            return R.id.addfri4;
        else if(str.equals("fri5"))
            return R.id.addfri5;
        else if(str.equals("fri6"))
            return R.id.addfri6;
        else if(str.equals("fri7"))
            return R.id.addfri7;
        else if(str.equals("fri8"))
            return R.id.addfri8;
        else if(str.equals("fri9"))
            return R.id.addfri9;
        else if(str.equals("fri10"))
            return R.id.addfri10;
        else if(str.equals("fri11"))
            return R.id.addfri11;
        else if(str.equals("fri12"))
            return R.id.addfri12;
        else if(str.equals("fri13"))
            return R.id.addfri13;
        else if(str.equals("fri14"))
            return R.id.addfri14;
        else if(str.equals("fri15"))
            return R.id.addfri15;
        else if(str.equals("sat1"))
            return R.id.addsat1;
        else if(str.equals("sat2"))
            return R.id.addsat2;
        else if(str.equals("sat3"))
            return R.id.addsat3;
        else if(str.equals("sat4"))
            return R.id.addsat4;
        else if(str.equals("sat5"))
            return R.id.addsat5;
        else if(str.equals("sat6"))
            return R.id.addsat6;
        else if(str.equals("sat7"))
            return R.id.addsat7;
        else if(str.equals("sat8"))
            return R.id.addsat8;
        else if(str.equals("sat9"))
            return R.id.addsat9;
        else if(str.equals("sat10"))
            return R.id.addsat10;
        else if(str.equals("sat11"))
            return R.id.addsat11;
        else if(str.equals("sat12"))
            return R.id.addsat12;
        else if(str.equals("sat13"))
            return R.id.addsat13;
        else if(str.equals("sat14"))
            return R.id.addsat14;
        else if(str.equals("sat15"))
            return R.id.addsat15;
        else if(str.equals("sun1"))
            return R.id.addsun1;
        else if(str.equals("sun2"))
            return R.id.addsun2;
        else if(str.equals("sun3"))
            return R.id.addsun3;
        else if(str.equals("sun4"))
            return R.id.addsun4;
        else if(str.equals("sun5"))
            return R.id.addsun5;
        else if(str.equals("sun6"))
            return R.id.addsun6;
        else if(str.equals("sun7"))
            return R.id.addsun7;
        else if(str.equals("sun8"))
            return R.id.addsun8;
        else if(str.equals("sun9"))
            return R.id.addsun9;
        else if(str.equals("sun10"))
            return R.id.addsun10;
        else if(str.equals("sun11"))
            return R.id.addsun11;
        else if(str.equals("sun12"))
            return R.id.addsun12;
        else if(str.equals("sun13"))
            return R.id.addsun13;
        else if(str.equals("sun14"))
            return R.id.addsun14;
        else if(str.equals("sun15"))
            return R.id.addsun15;
        else
            return R.id.addsun15;
    }
}