package com.mitsuki.calculation;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitsuki on 2018/6/1.
 */

public class Adapter extends BaseAdapter {

    private List<Formula> datas;
    private Boolean mark = false;
    private Context context;

    public Adapter(Context context) {
        this.context = context;
        this.datas = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (convertView == null) {// View未被实例化，即缓冲池中无缓存才创建View
            // 将控件id保存在viewHolder中
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_calculation, null);
            viewHolder.formulaView = convertView.findViewById(R.id.tv_formula);
            viewHolder.answerView = convertView.findViewById(R.id.tv_answer);
            viewHolder.resultView = convertView.findViewById(R.id.iv_result);
            // 通过setTag将ViewHolder与convertView绑定
            convertView.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder) convertView.getTag();

        if (mark) {
            String formula = "";
            switch (datas.get(i).getShadowNumber()) {
                case 0:
                    formula = formula + "<font color='#ff9f44'>" + datas.get(i).getNumber1() + " </font>";
                    formula = formula + (datas.get(i).getOperator2() ? "+ " : "- ");
                    formula = formula + datas.get(i).getNumber3() + " ";
                    formula = formula + (datas.get(i).getOperator4() ? "+ " : "- ");
                    formula = formula + datas.get(i).getNumber5() + " = ";
                    formula = formula + datas.get(i).getResult();
                    break;
                case 1:
                    formula = formula + datas.get(i).getNumber1() + " ";
                    formula = formula + (datas.get(i).getOperator2() ? "+ " : "- ");
                    formula = formula + "<font color='#ff9f44'>" + datas.get(i).getNumber3() + " </font>";
                    formula = formula + (datas.get(i).getOperator4() ? "+ " : "- ");
                    formula = formula + datas.get(i).getNumber5() + " = ";
                    formula = formula + datas.get(i).getResult();
                    break;
                case 2:
                    formula = formula + datas.get(i).getNumber1() + " ";
                    formula = formula + (datas.get(i).getOperator2() ? "+ " : "- ");
                    formula = formula + datas.get(i).getNumber3() + " ";
                    formula = formula + (datas.get(i).getOperator4() ? "+ " : "- ");
                    formula = formula + "<font color='#ff9f44'>" + datas.get(i).getNumber5() + " </font> = ";
                    formula = formula + datas.get(i).getResult();
                    break;
                case 3:
                    formula = formula + datas.get(i).getNumber1() + " ";
                    formula = formula + (datas.get(i).getOperator2() ? "+ " : "- ");
                    formula = formula + datas.get(i).getNumber3() + " ";
                    formula = formula + (datas.get(i).getOperator4() ? "+ " : "- ");
                    formula = formula + datas.get(i).getNumber5() + " = " + "<font color='#ff9f44'>" + datas.get(i).getResult() + " </font>";
                    ;
                    break;
            }
            viewHolder.formulaView.setText(Html.fromHtml(formula));
            viewHolder.answerView.setText(datas.get(i).getIntput() == -1 ? "0" : datas.get(i).getIntput() + "");
            viewHolder.resultView.setVisibility(View.VISIBLE);
            if (datas.get(i).getIntput() == datas.get(i).getSolution()) {
                viewHolder.answerView.setTextColor(Color.GREEN);
                viewHolder.resultView.setImageResource(R.drawable.ic_right);
            } else {
                viewHolder.answerView.setTextColor(Color.RED);
                viewHolder.resultView.setImageResource(R.drawable.ic_false);
            }
        } else {
            String formula = "";
            switch (datas.get(i).getShadowNumber()) {
                case 0:
                    formula = formula + "? ";
                    formula = formula + (datas.get(i).getOperator2() ? "+ " : "- ");
                    formula = formula + datas.get(i).getNumber3() + " ";
                    formula = formula + (datas.get(i).getOperator4() ? "+ " : "- ");
                    formula = formula + datas.get(i).getNumber5() + " = ";
                    formula = formula + datas.get(i).getResult();
                    break;
                case 1:
                    formula = formula + datas.get(i).getNumber1() + " ";
                    formula = formula + (datas.get(i).getOperator2() ? "+ " : "- ");
                    formula = formula + "? ";
                    formula = formula + (datas.get(i).getOperator4() ? "+ " : "- ");
                    formula = formula + datas.get(i).getNumber5() + " = ";
                    formula = formula + datas.get(i).getResult();
                    break;
                case 2:
                    formula = formula + datas.get(i).getNumber1() + " ";
                    formula = formula + (datas.get(i).getOperator2() ? "+ " : "- ");
                    formula = formula + datas.get(i).getNumber3() + " ";
                    formula = formula + (datas.get(i).getOperator4() ? "+ " : "- ");
                    formula = formula + "? = ";
                    formula = formula + datas.get(i).getResult();
                    break;
                case 3:
                    formula = formula + datas.get(i).getNumber1() + " ";
                    formula = formula + (datas.get(i).getOperator2() ? "+ " : "- ");
                    formula = formula + datas.get(i).getNumber3() + " ";
                    formula = formula + (datas.get(i).getOperator4() ? "+ " : "- ");
                    formula = formula + datas.get(i).getNumber5() + " = ?";
                    break;
            }
            viewHolder.formulaView.setText(formula);
            viewHolder.answerView.setText(datas.get(i).getIntput() == -1 ? "0" : datas.get(i).getIntput() + "");
            viewHolder.answerView.setTextColor(Color.parseColor("#ff9f44"));
            viewHolder.resultView.setVisibility(View.INVISIBLE);
        }


        return convertView;
    }

    public void setDatas(List<Formula> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public void clear() {
        datas.clear();
        this.mark = false;
    }

    public void addData(Formula formula) {
        datas.add(formula);
    }

    public void setMark(Boolean mark) {
        this.mark = mark;
        notifyDataSetChanged();
    }

    public void setAnswer(int positon, String x) {
        try {
            datas.get(positon).setIntput(Integer.parseInt(x));
            notifyDataSetInvalidated();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class ViewHolder {
        TextView formulaView;
        TextView answerView;
        ImageView resultView;
    }
}
