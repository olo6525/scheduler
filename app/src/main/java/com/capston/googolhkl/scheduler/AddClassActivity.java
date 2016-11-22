package com.capston.googolhkl.scheduler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.capston.googolhkl.schduler.R;
import java.util.ArrayList;

/**
 * Created by googolhkl on 2016. 11. 11..
 */

// 과목추가에서 시간선택후 추가눌렀을 때
public class AddClassActivity extends Activity {

    Intent intent;
    String time;
    private SQLiteHelper dbHelper;
    private ArrayList<ClassInformation> ci = new ArrayList<ClassInformation>();
    String classColor = "color_button1";
    private int tb1,tb2,tb3,tb4,tb5,tb6,tb7,tb8,tb9,tb10;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_add);
        dbHelper = new SQLiteHelper(getApplicationContext(), "classInfo.db", null,1);
        intent = getIntent();
        time = (String)intent.getSerializableExtra("time");

        ArrayList<String> result = dbHelper.getResult();
        for(int i=0; i< result.size(); i++){
            ci.add(new ClassInformation(result.get(i)));
        }

        Toast.makeText(this,"학교이름, 수강명, 수강번호는 정확하게 입력해야 채팅 서비스 이용이 가능합니다",Toast.LENGTH_LONG).show();


        if(!ci.isEmpty()) {
            String schoolName = ci.get(0).getSchoolName();
            EditText schoolNameText = (EditText) findViewById(R.id.class_add_schoolname_show);
            schoolNameText.setText(schoolName);
        }


        /*

        ToggleButton button = (ToggleButton) findViewById(R.id.color_button1);
        button.setBackgroundResource(R.drawable.col1);


        button = (ToggleButton) findViewById(R.id.color_button2);
        button.setBackgroundResource(R.drawable.col2);

        button = (ToggleButton) findViewById(R.id.color_button3);
        button.setBackgroundResource(R.drawable.col3);


        button = (ToggleButton) findViewById(R.id.color_button4);
        button.setBackgroundResource(R.drawable.col4);
        button = (ToggleButton) findViewById(R.id.color_button5);
        button.setBackgroundResource(R.drawable.col5);


        button = (ToggleButton) findViewById(R.id.color_button6);
        button.setBackgroundResource(R.drawable.col6);


        button = (ToggleButton) findViewById(R.id.color_button7);
        button.setBackgroundResource(R.drawable.col7);

        button = (ToggleButton) findViewById(R.id.color_button8);
        button.setBackgroundResource(R.drawable.col8);

        button = (ToggleButton) findViewById(R.id.color_button9);
        button.setBackgroundResource(R.drawable.col9);

        button = (ToggleButton) findViewById(R.id.color_button10);
        button.setBackgroundResource(R.drawable.col10);
        */



       /* ((ToggleButton)findViewById(R.id.color_button1)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.color.col1d);
                    classColor = "color_button1";
                    buttonView.setEnabled(false);
                } else {
                    buttonView.setBackgroundResource(R.color.col1);
                    classColor = "color_button1";
                }
            }
        });

        ((ToggleButton)findViewById(R.id.color_button2)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.color.col2d);
                    classColor = "color_button2";
                    buttonView.setEnabled(false);
                } else {
                    buttonView.setBackgroundResource(R.color.col2);
                    classColor = "color_button1";
                }
            }
        });

        ((ToggleButton)findViewById(R.id.color_button3)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.color.col3d);
                    classColor = "color_button3";
                    buttonView.setEnabled(false);
                } else {
                    buttonView.setBackgroundResource(R.color.col3);
                    classColor = "color_button1";
                }
            }
        });

        ((ToggleButton)findViewById(R.id.color_button4)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.color.col4d);
                    classColor = "color_button4";
                    buttonView.setEnabled(false);
                } else {
                    buttonView.setBackgroundResource(R.color.col4);
                    classColor = "color_button1";
                }
            }
        });

        ((ToggleButton)findViewById(R.id.color_button5)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.color.col5d);
                    classColor = "color_button5";
                    buttonView.setEnabled(false);
                } else {
                    buttonView.setBackgroundResource(R.color.col5);
                    classColor = "color_button1";
                }
            }
        });

        ((ToggleButton)findViewById(R.id.color_button6)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.color.col6d);
                    classColor = "color_button6";
                    buttonView.setEnabled(false);
                } else {
                    buttonView.setBackgroundResource(R.color.col6);
                    classColor = "color_button1";
                }
            }
        });

        ((ToggleButton)findViewById(R.id.color_button7)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.color.col7d);
                    classColor = "color_button7";
                    buttonView.setEnabled(false);
                } else {
                    buttonView.setBackgroundResource(R.color.col7);
                    classColor = "color_button1";
                }
            }
        });

        ((ToggleButton)findViewById(R.id.color_button8)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.color.col8d);
                    classColor = "color_button8";
                    buttonView.setEnabled(false);
                } else {
                    buttonView.setBackgroundResource(R.color.col8);
                    classColor = "color_button1";
                }
            }
        });

        ((ToggleButton)findViewById(R.id.color_button9)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.color.col9d);
                    classColor = "color_button9";
                    buttonView.setEnabled(false);
                } else {
                    buttonView.setBackgroundResource(R.color.col9);
                    classColor = "color_button1";
                }
            }
        });

        ((ToggleButton)findViewById(R.id.color_button10)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.color.col10d);
                    classColor = "color_button10";
                    buttonView.setEnabled(false);
                } else {
                    buttonView.setBackgroundResource(R.color.col10);
                    classColor = "color_button1";
                }
            }
        });*/



        ((ToggleButton)findViewById(R.id.color_button1)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.color.col1d);
                    classColor = "color_button1";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=0;
                    tb2=1;
                    tb3=1;
                    tb4=1;
                    tb5=1;
                    tb6=1;
                    tb7=1;
                    tb8=1;
                    tb9=1;
                    tb10=1;

                }
                else if(tb1==1)
                {
                    buttonView.setBackgroundResource(R.color.col1d);
                    classColor = "color_button1";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=0;
                    tb2=1;
                    tb3=1;
                    tb4=1;
                    tb5=1;
                    tb6=1;
                    tb7=1;
                    tb8=1;
                    tb9=1;
                    tb10=1;
                }
                else
                {
                    buttonView.setBackgroundResource(R.color.col1);
                    classColor = "color_button1";
                }
            }
        });


        ((ToggleButton)findViewById(R.id.color_button2)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.color.col2d);
                    classColor = "color_button2";
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=1;
                    tb2=0;
                    tb3=1;
                    tb4=1;
                    tb5=1;
                    tb6=1;
                    tb7=1;
                    tb8=1;
                    tb9=1;
                    tb10=1;

                }
                else if(tb2==1)
                {
                    buttonView.setBackgroundResource(R.color.col2d);
                    classColor = "color_button2";
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=1;
                    tb2=0;
                    tb3=1;
                    tb4=1;
                    tb5=1;
                    tb6=1;
                    tb7=1;
                    tb8=1;
                    tb9=1;
                    tb10=1;
                }  else {
                    buttonView.setBackgroundResource(R.color.col2);
                    classColor = "color_button2";
                }
            }
        });

        ((ToggleButton)findViewById(R.id.color_button3)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.color.col3d);
                    classColor = "color_button3";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=1;
                    tb2=1;
                    tb3=0;
                    tb4=1;
                    tb5=1;
                    tb6=1;
                    tb7=1;
                    tb8=1;
                    tb9=1;
                    tb10=1;

                }
                else if(tb3==1)
                {
                    buttonView.setBackgroundResource(R.color.col3d);
                    classColor = "color_button3";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=1;
                    tb2=1;
                    tb3=0;
                    tb4=1;
                    tb5=1;
                    tb6=1;
                    tb7=1;
                    tb8=1;
                    tb9=1;
                    tb10=1;
                }  else {
                    buttonView.setBackgroundResource(R.color.col3);
                    classColor = "color_button3";
                }
            }
        });

        ((ToggleButton)findViewById(R.id.color_button4)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.color.col4d);
                    classColor = "color_button4";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=1;
                    tb2=1;
                    tb3=1;
                    tb4=0;
                    tb5=1;
                    tb6=1;
                    tb7=1;
                    tb8=1;
                    tb9=1;
                    tb10=1;

                }
                else if(tb4==1)
                {
                    buttonView.setBackgroundResource(R.color.col4d);
                    classColor = "color_button4";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=1;
                    tb2=1;
                    tb3=1;
                    tb4=0;
                    tb5=1;
                    tb6=1;
                    tb7=1;
                    tb8=1;
                    tb9=1;
                    tb10=1;
                } else {
                    buttonView.setBackgroundResource(R.color.col4);
                    classColor = "color_button4";
                }
            }
        });

        ((ToggleButton)findViewById(R.id.color_button5)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.color.col5d);
                    classColor = "color_button5";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=1;
                    tb2=1;
                    tb3=1;
                    tb4=1;
                    tb5=0;
                    tb6=1;
                    tb7=1;
                    tb8=1;
                    tb9=1;
                    tb10=1;

                }
                else if(tb5==1)
                {
                    buttonView.setBackgroundResource(R.color.col5d);
                    classColor = "color_button5";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=1;
                    tb2=1;
                    tb3=1;
                    tb4=1;
                    tb5=0;
                    tb6=1;
                    tb7=1;
                    tb8=1;
                    tb9=1;
                    tb10=1;
                }  else {
                    buttonView.setBackgroundResource(R.color.col5);
                    classColor = "color_button5";
                }
            }
        });

        ((ToggleButton)findViewById(R.id.color_button6)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.color.col6d);
                    classColor = "color_button6";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=1;
                    tb2=1;
                    tb3=1;
                    tb4=1;
                    tb5=1;
                    tb6=0;
                    tb7=1;
                    tb8=1;
                    tb9=1;
                    tb10=1;

                }
                else if(tb6==1)
                {
                    buttonView.setBackgroundResource(R.color.col6d);
                    classColor = "color_button6";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=1;
                    tb2=1;
                    tb3=1;
                    tb4=1;
                    tb5=1;
                    tb6=0;
                    tb7=1;
                    tb8=1;
                    tb9=1;
                    tb10=1;
                }  else {
                    buttonView.setBackgroundResource(R.color.col6);
                    classColor = "color_button6";
                }
            }
        });

        ((ToggleButton)findViewById(R.id.color_button7)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.color.col7d);
                    classColor = "color_button7";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=1;
                    tb2=1;
                    tb3=1;
                    tb4=1;
                    tb5=1;
                    tb6=1;
                    tb7=0;
                    tb8=1;
                    tb9=1;
                    tb10=1;

                }
                else if(tb7==1)
                {
                    buttonView.setBackgroundResource(R.color.col7d);
                    classColor = "color_button7";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=1;
                    tb2=1;
                    tb3=1;
                    tb4=1;
                    tb5=1;
                    tb6=1;
                    tb7=0;
                    tb8=1;
                    tb9=1;
                    tb10=1;
                }  else {
                    buttonView.setBackgroundResource(R.color.col7);
                    classColor = "color_button7";
                }
            }
        });

        ((ToggleButton)findViewById(R.id.color_button8)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.color.col8d);
                    classColor = "color_button8";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=1;
                    tb2=1;
                    tb3=1;
                    tb4=1;
                    tb5=1;
                    tb6=1;
                    tb7=1;
                    tb8=0;
                    tb9=1;
                    tb10=1;

                }
                else if(tb8==1)
                {
                    buttonView.setBackgroundResource(R.color.col8d);
                    classColor = "color_button8";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=1;
                    tb2=1;
                    tb3=1;
                    tb4=1;
                    tb5=1;
                    tb6=1;
                    tb7=1;
                    tb8=0;
                    tb9=1;
                    tb10=1;
                }  else {
                    buttonView.setBackgroundResource(R.color.col8);
                    classColor = "color_button8";
                }
            }
        });

        ((ToggleButton)findViewById(R.id.color_button9)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.color.col9d);
                    classColor = "color_button9";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=1;
                    tb2=1;
                    tb3=1;
                    tb4=1;
                    tb5=1;
                    tb6=1;
                    tb7=1;
                    tb8=1;
                    tb9=9;
                    tb10=1;

                }
                else if(tb9==1)
                {
                    buttonView.setBackgroundResource(R.color.col9d);
                    classColor = "color_button9";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=1;
                    tb2=1;
                    tb3=1;
                    tb4=1;
                    tb5=1;
                    tb6=1;
                    tb7=1;
                    tb8=1;
                    tb9=0;
                    tb10=1;
                }  else {
                    buttonView.setBackgroundResource(R.color.col9);
                    classColor = "color_button9";
                }
            }
        });

        ((ToggleButton)findViewById(R.id.color_button10)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.color.col10d);
                    classColor = "color_button10";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    tb1=1;
                    tb2=1;
                    tb3=1;
                    tb4=1;
                    tb5=1;
                    tb6=1;
                    tb7=1;
                    tb8=1;
                    tb9=1;
                    tb10=0;

                }
                else if(tb10==1)
                {
                    buttonView.setBackgroundResource(R.color.col10d);
                    classColor = "color_button10";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    tb1=1;
                    tb2=1;
                    tb3=1;
                    tb4=1;
                    tb5=1;
                    tb6=1;
                    tb7=1;
                    tb8=1;
                    tb9=1;
                    tb10=0;
                }  else {
                    buttonView.setBackgroundResource(R.color.col10);
                    classColor = "color_button10";
                }
            }
        });

        /*
        findViewById(R.id.color_button1).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                classColor = "color_button1";
            }
        });


        findViewById(R.id.color_button2).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                classColor = "color_button2";
            }
        });

        findViewById(R.id.color_button3).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                classColor = "color_button3";
            }
        });

        findViewById(R.id.color_button4).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                classColor = "color_button4";
            }
        });

        findViewById(R.id.color_button5).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                classColor = "color_button5";
            }
        });

        findViewById(R.id.color_button6).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                classColor = "color_button6";
            }
        });

        findViewById(R.id.color_button7).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                classColor = "color_button7";
            }
        });

        findViewById(R.id.color_button8).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                classColor = "color_button8";
            }
        });

        findViewById(R.id.color_button9).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                classColor = "color_button9";
            }
        });

        findViewById(R.id.color_button10).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                classColor = "color_button10";
            }
        });
        */

        // 닫기 눌렀을 때
        findViewById(R.id.class_add_cancle).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        // 추가 눌렀을 때
        findViewById(R.id.class_add_ok).setOnClickListener( new Button.OnClickListener() {
            public void onClick(View v) {

                String schoolName;
                String className;
                String classNumber;
                String professor;
                String classRoom;
                String memo = "";

                EditText editText1 = (EditText)findViewById(R.id.class_add_schoolname_show);
                schoolName = editText1.getText().toString();

                editText1 = (EditText)findViewById(R.id.class_add_classname_show);
                className = editText1.getText().toString();

                editText1 = (EditText)findViewById(R.id.class_add_classnumber_show);
                classNumber = editText1.getText().toString();

                editText1 = (EditText)findViewById(R.id.class_add_professor_show) ;
                professor = editText1.getText().toString();

                editText1 = (EditText)findViewById(R.id.class_add_classroom_show) ;
                classRoom = editText1.getText().toString();

                String query = time + ":"+ schoolName + ":" + className + ":" + classNumber + ":" + professor + ":" + classRoom + ":" + classColor + ":" + memo;
                dbHelper.insert(time,schoolName,className,classNumber,professor,classRoom,memo,classColor);
                finish();
            }
        });
    }
}