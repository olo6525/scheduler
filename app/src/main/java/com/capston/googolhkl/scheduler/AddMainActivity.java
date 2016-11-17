package com.capston.googolhkl.scheduler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.capston.googolhkl.schduler.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by googolhkl on 2016. 11. 11..
 */

// 과목추가 눌렀을 때
public class AddMainActivity extends Activity {
    String time = "";
    HashSet<String> set = new HashSet<String>();
    private ArrayList<ClassInformation> ci;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmain);


        intent = getIntent();
        ci = (ArrayList<ClassInformation>) intent.getSerializableExtra("data");

        for(int i=0; i< ci.size(); i++) {
            String[] test = ci.get(i).getTime().split(" ");
            for (int j = 0; j < test.length; j++) {
                ToggleButton button = (ToggleButton) findViewById(getDaysID(test[j]));
                button.setBackgroundResource(MainActivity.getButtonColorDrawable(ci.get(i).getClassColor()));
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

        ((ToggleButton)findViewById(R.id.addtue1)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("tue1");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("tue1");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addtue2)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("tue2");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("tue2");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addtue3)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("tue3");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("tue3");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addtue4)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("tue4");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("tue4");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addtue5)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("tue5");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("tue5");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addtue6)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("tue6");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("tue6");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addtue7)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("tue7");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("tue7");
                }
            }
        });


        ((ToggleButton)findViewById(R.id.addtue8)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("tue8");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("tue8");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addtue9)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("tue9");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("tue9");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addtue10)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("tue10");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("tue10");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addtue11)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("tue11");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("tue11");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addtue12)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("tue12");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("tue12");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addtue13)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("tue13");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("tue13");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addtue14)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("tue14");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("tue14");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addtue15)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("tue15");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("tue15");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addwed1)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("wed1");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("wed1");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addwed2)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("wed2");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("wed2");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addwed3)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("wed3");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("wed3");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addwed4)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("wed4");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("wed4");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addwed5)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("wed5");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("wed5");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addwed6)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("wed6");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("wed6");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addwed7)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("wed7");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("wed7");
                }
            }
        });


        ((ToggleButton)findViewById(R.id.addwed8)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("wed8");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("wed8");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addwed9)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("wed9");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("wed9");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addwed10)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("wed10");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("wed10");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addwed11)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("wed11");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("wed11");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addwed12)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("wed12");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("wed12");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addwed13)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("wed13");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("wed13");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addwed14)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("wed14");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("wed14");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addwed15)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("wed15");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("wed15");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addthu1)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("thu1");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("thu1");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addthu2)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("thu2");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("thu2");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addthu3)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("thu3");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("thu3");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addthu4)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("thu4");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("thu4");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addthu5)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("thu5");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("thu5");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addthu6)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("thu6");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("thu6");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addthu7)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("thu7");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("thu7");
                }
            }
        });


        ((ToggleButton)findViewById(R.id.addthu8)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("thu8");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("thu8");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addthu9)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("thu9");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("thu9");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addthu10)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("thu10");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("thu10");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addthu11)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("thu11");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("thu11");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addthu12)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("thu12");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("thu12");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addthu13)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("thu13");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("thu13");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addthu14)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("thu14");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("thu14");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addthu15)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("thu15");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("thu15");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addfri1)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("fri1");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("fri1");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addfri2)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("fri2");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("fri2");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addfri3)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("fri3");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("fri3");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addfri4)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("fri4");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("fri4");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addfri5)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("fri5");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("fri5");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addfri6)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("fri6");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("fri6");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addfri7)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("fri7");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("fri7");
                }
            }
        });


        ((ToggleButton)findViewById(R.id.addfri8)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("fri8");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("fri8");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addfri9)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("fri9");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("fri9");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addfri10)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("fri10");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("fri10");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addfri11)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("fri11");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("fri11");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addfri12)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("fri12");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("fri12");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addfri13)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("fri13");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("fri13");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addfri14)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("fri14");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("fri14");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addfri15)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("fri15");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("fri15");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addsat1)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("sat1");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("sat1");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addsat2)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("sat2");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("sat2");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addsat3)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("sat3");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("sat3");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addsat4)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("sat4");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("sat4");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addsat5)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("sat5");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("sat5");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addsat6)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("sat6");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("sat6");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addsat7)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("sat7");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("sat7");
                }
            }
        });


        ((ToggleButton)findViewById(R.id.addsat8)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("sat8");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("sat8");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addsat9)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("sat9");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("sat9");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addsat10)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("sat10");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("sat10");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addsat11)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("sat11");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("sat11");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addsat12)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("sat12");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("sat12");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addsat13)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("sat13");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("sat13");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addsat14)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("sat14");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("sat14");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addsat15)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("sat15");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("sat15");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addsun1)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("sun1");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("sun1");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addsun2)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("sun2");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("sun2");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addsun3)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("sun3");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("sun3");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addsun4)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("sun4");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("sun4");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addsun5)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("sun5");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("sun5");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addsun6)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("sun6");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("sun6");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addsun7)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("sun7");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("sun7");
                }
            }
        });


        ((ToggleButton)findViewById(R.id.addsun8)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("sun8");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("sun8");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addsun9)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("sun9");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("sun9");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addsun10)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("sun10");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("sun10");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addsun11)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("sun11");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("sun11");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addsun12)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("sun12");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("sun12");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addsun13)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("sun13");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("sun13");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addsun14)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("sun14");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("sun14");
                }
            }
        });

        ((ToggleButton)findViewById(R.id.addsun15)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.drawable.add_class_button2);
                    set.add("sun15");
                } else {
                    buttonView.setBackgroundResource(R.drawable.add_class_button1);
                    set.remove("sun15");
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