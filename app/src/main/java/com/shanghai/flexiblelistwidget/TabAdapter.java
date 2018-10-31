package com.shanghai.flexiblelistwidget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * @author chensong
 * @date 2018/10/31 14:00
 */
public class TabAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<String> mList;
    private int type;
    private int TITLE = 1;
    private int CONTENT = 2;

    public TabAdapter(Context mContext, List<String> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    public TabAdapter(Context mContext, List<String> mList, int type) {
        this.mContext = mContext;
        this.mList = mList;
        this.type = type;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType ==TITLE) {
            View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_lv_good_name, parent, false);
            return new GuapaiViewHolder(itemView);
        } else {
            View itemView = LayoutInflater.from(mContext).inflate(R.layout.table_right_item, parent, false);
            return new ContentViewHolder(itemView);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof GuapaiViewHolder){
            GuapaiViewHolder mViewHolder = (GuapaiViewHolder) holder;
            mViewHolder.setmStock(mList.get(position));
            mViewHolder.refreshView();
        }else if(holder instanceof ContentViewHolder){
            ContentViewHolder mViewHolder = (ContentViewHolder) holder;
            mViewHolder.setmStock(mList.get(position));
            mViewHolder.refreshView();
        }
    }


    @Override
    public int getItemViewType(int position) {
        if (type == 0) {
            return TITLE;
        } else {
            return CONTENT;
        }
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    class GuapaiViewHolder extends RecyclerView.ViewHolder {

        TextView tv_goodname;
        String mStock;

        public GuapaiViewHolder(View view) {
            super(view);
            tv_goodname = (TextView) view.findViewById(R.id.tv_name);
        }

        public void setmStock(String mStock) {
            this.mStock = mStock;
        }

        void refreshView() {
            //公司名称
            tv_goodname.setText(mStock);

        }
    }
    class ContentViewHolder extends RecyclerView.ViewHolder {

        TextView tv_barcode;
        TextView tv_icon;
        TextView tv_category;
        TextView tv_spec;
        TextView tv_unit;
        TextView tv_supplier;
        TextView tv_sale_money;
        TextView tv_income_money;
        TextView tv_keep;
        TextView tv_intime;
        TextView tv_online;
        TextView tv_time, tv_z01;
        String mStock;

        public ContentViewHolder(View convertView) {
            super(convertView);
            //当前价
            tv_barcode = (TextView) convertView.findViewById(R.id.tv_table_content_right_item0);
            //涨跌幅
            tv_icon = (TextView) convertView.findViewById(R.id.tv_table_content_right_item1);
            //成交额
            tv_category = (TextView) convertView.findViewById(R.id.tv_table_content_right_item2);
            //成交量
            tv_spec = (TextView) convertView.findViewById(R.id.tv_table_content_right_item3);
            //涨跌额
            tv_unit = (TextView) convertView.findViewById(R.id.tv_table_content_right_item4);
            //营收
            tv_supplier = (TextView) convertView.findViewById(R.id.tv_table_content_right_item5);
            //净利润
            tv_sale_money = (TextView) convertView.findViewById(R.id.tv_table_content_right_item6);
            //流通股本
            tv_income_money = (TextView) convertView.findViewById(R.id.tv_table_content_right_item7);
            //流通市值
            tv_keep = (TextView) convertView.findViewById(R.id.tv_table_content_right_item8);
            //总股本
            tv_intime = (TextView) convertView.findViewById(R.id.tv_table_content_right_item9);
            //总市值
            tv_online = (TextView) convertView.findViewById(R.id.tv_table_content_right_item10);
            //市盈率
            tv_time = (TextView) convertView.findViewById(R.id.tv_table_content_right_item11);
            //每股收益
            tv_z01 = (TextView) convertView.findViewById(R.id.tv_table_content_right_item12);
        }

        public void setmStock(String mStock) {
            this.mStock = mStock;
        }

        void refreshView() {
            tv_barcode.setText(mStock);


            tv_icon.setText(mStock);
            tv_category.setText(mStock);
            tv_spec.setText(mStock);
            tv_unit.setText(mStock);

            tv_supplier.setText(mStock);



            tv_sale_money.setText(mStock);


            tv_keep.setText(mStock);



            tv_intime.setText(mStock);


            tv_income_money.setText(mStock);

            tv_online.setText(mStock);

            tv_time.setText(mStock);

            tv_z01.setText(mStock);

        }
    }
    public void add(List<String> mPriceEntityList) {
        mList = mPriceEntityList;
        notifyDataSetChanged();
    }

}
