package com.mitsuki.calculation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button checkBtn;
    private Button getBtn;
    private ListView listView;
    private EditText number;

    private Adapter adapter;
    private SelectDialog selectDialog;
    private int clickItem = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBtn = findViewById(R.id.btn_check);
        getBtn = findViewById(R.id.btn_get_data);
        listView = findViewById(R.id.listview_data);
        number = findViewById(R.id.et_number);
        adapter = new Adapter(this);
        listView.setAdapter(adapter);

        checkBtn.setOnClickListener(view -> adapter.setMark(true));
        getBtn.setOnClickListener(view ->{
            String numStr = number.getText().toString().trim();
            if (numStr == null || numStr.length() <= 0){
                Toast.makeText(this,"请输入要生成的式子个数", Toast.LENGTH_LONG).show();
            }else {
                adapter.clear();
                int x = Integer.parseInt(numStr);
                for (int i = 0; i < x; i++){
                    adapter.addData(getFormula());
                }
                adapter.notifyDataSetChanged();
            }
        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            clickItem = position;
            if (selectDialog == null) selectDialog = new SelectDialog(this);
            selectDialog.show();
        });

    }

    private int rand(int x){
        return (int)(Math.random() * (x + 1));
    }

    //获得一个式子
    private Formula getFormula(){
        Formula formula = new Formula();
        //随机得到第一位数字
        formula.setNumber1(rand(20));
        //随机得到第一位符号
        if (rand(1) == Constant.ADD_INT){
            formula.setOperator2(Constant.ADD);
        }else {
            formula.setOperator2(Constant.MINUS);
        }
        //得到第二位数字
        formula.setNumber3(getNextNumber(formula.getNumber1(), formula.getOperator2()));
        //得到第二位符号
        if (rand(1) == Constant.ADD_INT){
            formula.setOperator4(Constant.ADD);
        }else {
            formula.setOperator4(Constant.MINUS);
        }
        //得到前两位的运算结果
        int x;
        if (formula.getOperator2()){
            x = formula.getNumber1() + formula.getNumber3();
        }else {
            x = formula.getNumber1() - formula.getNumber3();
        }
        //得到第三位数字
        formula.setNumber5(getNextNumber(x, formula.getOperator4()));
        //得到结果
        if (formula.getOperator4()){
            formula.setResult(x + formula.getNumber5());
        }else {
            formula.setResult(x - formula.getNumber5());
        }
        //得到隐藏的数字
        formula.setShadowNumber(rand(3));
        switch (formula.getShadowNumber()){
            case 0:
                formula.setSolution(formula.getNumber1());
                break;
            case 1:
                formula.setSolution(formula.getNumber3());
                break;
            case 2:
                formula.setSolution(formula.getNumber5());
                break;
            case 3:
                formula.setSolution(formula.getResult());
                break;
        }
        return formula;
    }

    //通过一位数和符号得到下一个符合条件的数
    private int getNextNumber(int x, boolean o){
        if (o){
            if (20 == x){
                return 0;
            }else {
                return rand(20 - x);
            }
        }else {
            if (0 == x){
                return 0;
            }else {
                return rand(x);
            }
        }
    }

    public void click(View view){
        selectDialog.dismiss();
        adapter.setAnswer(clickItem, ((TextView) view).getText().toString().trim());
    }
}
