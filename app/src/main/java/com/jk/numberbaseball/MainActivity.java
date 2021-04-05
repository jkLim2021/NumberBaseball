package com.jk.numberbaseball;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    ImageView ch02, ch03;
    TextView tv01, tv02, tv03, tv04, list01, list02, list03;
    TextView ss1, ss2, ss3;
    int dap1, dap2, dap3, st, boll; //램덤값
    ImageView[] imv = new ImageView[10];
    ImageView[] smv = new ImageView[10];
    RelativeLayout layout01, layout02, layout03, layout04,layout05;

    int ins = 0, count = 1, countr = 0;
    String resultStr01 = "", resultStr02 = "", resultStr03 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv01 = findViewById(R.id.tv01);
        tv02 = findViewById(R.id.tv02);
        tv03 = findViewById(R.id.tv03);
        tv04 = findViewById(R.id.tv04);
        ss1 = findViewById(R.id.ss1);
        ss2 = findViewById(R.id.ss2);
        ss3 = findViewById(R.id.ss3);
        ch02 = findViewById(R.id.ch02);
        ch03 = findViewById(R.id.ch03);

        layout01 = findViewById(R.id.layout01);
        layout02 = findViewById(R.id.layout02);
        layout03 = findViewById(R.id.layout03);
        layout04 = findViewById(R.id.layout04);
        layout05 = findViewById(R.id.layout05);
        list01 = findViewById(R.id.list01);
        list02 = findViewById(R.id.list02);
        list03 = findViewById(R.id.list03);


        do {
            dap1 = (int) (Math.random() * 9) + 1;
            dap2 = (int) (Math.random() * 9) + 1;
            dap3 = (int) (Math.random() * 9) + 1;
        } while (dap1 == dap2 || dap1 == dap3 || dap2 == dap3);


        for (int i = 0; i < imv.length; i++) {
            imv[i] = findViewById(R.id.c00 + i);
            smv[i] = findViewById(R.id.s00 + i);


            int finalI = i;


            imv[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    if (ins == 0) {
                        ch03.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tv01.setText("");
                                ins--;
                                imv[finalI].setVisibility(View.VISIBLE);
                                smv[finalI].setVisibility(View.INVISIBLE);


                            }
                        });
                        smv[finalI].setVisibility(View.VISIBLE);
                        imv[finalI].setVisibility(View.GONE);
                        tv01.setText(finalI + "");
                        ins++;

                    } else if (ins == 1) {
                        ch03.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tv02.setText("");
                                ins--;
                                imv[finalI].setVisibility(View.VISIBLE);
                                smv[finalI].setVisibility(View.INVISIBLE);
                            }
                        });
                        smv[finalI].setVisibility(View.VISIBLE);
                        imv[finalI].setVisibility(View.GONE);
                        tv02.setText(finalI + "");
                        ins++;
                    } else if (ins == 2) {
                        ch03.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tv03.setText("");
                                ins--;
                                ch02.setVisibility(View.INVISIBLE);
                                imv[finalI].setVisibility(View.VISIBLE);
                                smv[finalI].setVisibility(View.INVISIBLE);
                            }
                        });
                        smv[finalI].setVisibility(View.VISIBLE);
                        imv[finalI].setVisibility(View.GONE);
                        tv03.setText(finalI + "");
                        ins++;
                    }
                    if (ins == 3) {

                        ch02.setVisibility(View.VISIBLE);


                        ch02.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                int num01 = Integer.parseInt(tv01.getText().toString());
                                int num02 = Integer.parseInt(tv02.getText().toString());
                                int num03 = Integer.parseInt(tv03.getText().toString());

                                if (num01 == dap1) {
                                    st++;
                                } else if (num01 == dap2 || num01 == dap3) {
                                    boll++;
                                }
                                if (num02 == dap2) {
                                    st++;
                                } else if (num02 == dap1 || num02 == dap3) {
                                    boll++;
                                }
                                if (num03 == dap3) {
                                    st++;
                                } else if (num03 == dap1 || num03 == dap2) {
                                    boll++;
                                }

                                //" + st +"S" + boll +"B"+ "\n";
                                resultStr01 += count + "라운드" + "\n";
                                resultStr02 += num01 + "" + num02 + "" + num03 + "\n";

                                if (st != 0 && boll != 0) {

                                    resultStr03 += st + "S" + boll + "B" + "\n";
                                } else if (st == 0 && boll != 0) {
                                    resultStr03 += boll + "B" + "\n";
                                } else if (st != 0 && boll == 0) {
                                    resultStr03 += st + "S" + "\n";
                                } else {
                                    resultStr03 += "OUT!" + "\n";

                                }

                                tv01.setText("");
                                tv02.setText("");
                                tv03.setText("");
                                count++;
                                list01.setText(resultStr01 + "");
                                list02.setText(resultStr02 + "");
                                list03.setText(resultStr03 + "");

                                ch02.setVisibility(View.INVISIBLE);
                                if (st == 3) {
                                    layout04.setVisibility(View.VISIBLE);


                                }
                                st = 0;
                                boll = 0;
                                ins = 0;
                                countr--;


                                for (int j = 0; j < imv.length; j++) {
                                    smv[j].setVisibility(View.INVISIBLE);
                                    imv[j].setVisibility(View.VISIBLE);
                                }

                                if (countr == 0) {
                                    layout03.setVisibility(View.VISIBLE);

                                }

                                tv04.setText(count + "라운드" + "");


                            }
                        });


                    }//  if (ins == 3)


                }
            });


        }


        ss1.setText(dap1 + "");
        ss2.setText(dap2 + "");
        ss3.setText(dap3 + "");


    }

    public void clickBtn(View v) {

        layout01.setVisibility(View.GONE);
        layout02.setVisibility(View.GONE);
        layout03.setVisibility(View.GONE);
        layout04.setVisibility(View.GONE);
        layout05.setVisibility(View.GONE);

        int id = v.getId();
        switch (id) {
            case R.id.st03:
                layout02.setVisibility(View.VISIBLE);
                countr = 10;
                break;

            case R.id.st04:
                layout02.setVisibility(View.VISIBLE);
                countr = 7;
                break;

            case R.id.st05:
                layout02.setVisibility(View.VISIBLE);
                countr = 5;
                break;

            case R.id.qicon:
                layout01.setVisibility(View.VISIBLE);
                layout05.setVisibility(View.VISIBLE);
                break;

            case R.id.exb:
                layout01.setVisibility(View.VISIBLE);
                layout05.setVisibility(View.GONE);
                break;
        }

    }

    public void home(View v) {

        layout01.setVisibility(View.VISIBLE);
        layout02.setVisibility(View.GONE);
        layout03.setVisibility(View.GONE);
        layout04.setVisibility(View.GONE);


        tv04.setText("1라운드");

        do {
            dap1 = (int) (Math.random() * 9) + 1;
            dap2 = (int) (Math.random() * 9) + 1;
            dap3 = (int) (Math.random() * 9) + 1;
        } while (dap1 == dap2 || dap1 == dap3 || dap2 == dap3);

        ss1.setText(dap1 + "");
        ss2.setText(dap2 + "");
        ss3.setText(dap3 + "");
        count =1;
        list01.setText("");
        list02.setText("");
        list03.setText("");
        resultStr01="";
        resultStr02="";
        resultStr03="";
    }

}