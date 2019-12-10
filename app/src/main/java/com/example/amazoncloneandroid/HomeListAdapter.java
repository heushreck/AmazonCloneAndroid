package com.example.amazoncloneandroid;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.ViewHolder>{

    private HomeListData[] homeListData;
    private ViewGroup parent;

    // RecyclerView recyclerView;
    public HomeListAdapter(HomeListData[] homeListData) {
        this.homeListData = homeListData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.parent = parent;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.home_row_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final HomeListData myListData = homeListData[position];
        holder.title.setText(homeListData[position].getTitle());
        holder.bottomString.setText(homeListData[position].getBottom_string());
        holder.linearLayoutClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(parent.getContext(), NotHomeActivity.class);
                i.putExtra("items", myListData.getItemList());
                i.putExtra("content", ContentType.ITEM_LIST);
                parent.getContext().startActivity(i);
            }
        });
        holder.linearLayoutInflate.removeAllViews();
        switch (homeListData[position].getItemList().length){
            case 1:
                setupOneItem(holder,position);
                break;
            case 3:
                setupThreeItems(holder,position);
                break;
            case 4:
                setupFourItems(holder, position);
                break;
            default:
                setupOneItem(holder,position);
        }
    }

    @Override
    public int getItemCount() {
        return homeListData.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        //public ImageView middlefiller;
        public TextView title;
        public TextView bottomString;
        public LinearLayout linearLayoutClick;
        public LinearLayout linearLayoutInflate;
        public ViewHolder(View itemView) {
            super(itemView);
            //this.middlefiller = itemView.findViewById(R.id.home_list_image);
            this.title = itemView.findViewById(R.id.home_list_title);
            this.bottomString = itemView.findViewById(R.id.home_list_bottom);
            this.linearLayoutClick = itemView.findViewById(R.id.home_list_linear);
            this.linearLayoutInflate = itemView.findViewById(R.id.home_row_fragment_linear_layout);

        }
    }

    private void setupOneItem(ViewHolder holder, final int position){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View to_add = layoutInflater.inflate(R.layout.list_fragment_one_item,
                holder.linearLayoutInflate, false);

        TextView text = to_add.findViewById(R.id.list_fragment_one_text);
        ImageView image = to_add.findViewById(R.id.list_fragment_one_image);
        LinearLayout ll = to_add.findViewById(R.id.list_fragment_one_linear_layout_click);
        String name = homeListData[position].getItemList()[0].getItem_title();
        String price = homeListData[position].getItemList()[0].getItem_price_string();
        text.setText(name + "\n" + price);
        image.setImageResource(homeListData[position].getItemList()[0].getImgId());
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(parent.getContext(), NotHomeActivity.class);
                i.putExtra("item", homeListData[position].getItemList()[0]);
                i.putExtra("content", ContentType.SINGE_ITEM);
                parent.getContext().startActivity(i);
            }
        });
        holder.linearLayoutInflate.addView(to_add);
    }

    private void setupThreeItems(ViewHolder holder, final int position){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View to_add = layoutInflater.inflate(R.layout.list_fragment_three_items,
                holder.linearLayoutInflate, false);

        ImageView imageView1 = to_add.findViewById(R.id.list_fragment_three_image1);
        ImageView imageView2 = to_add.findViewById(R.id.list_fragment_three_image2);
        ImageView imageView3 = to_add.findViewById(R.id.list_fragment_three_image3);

        TextView textView11 = to_add.findViewById(R.id.list_fragment_three_text11);
        TextView textView12 = to_add.findViewById(R.id.list_fragment_three_text12);
        TextView textView21 = to_add.findViewById(R.id.list_fragment_three_text21);
        TextView textView22 = to_add.findViewById(R.id.list_fragment_three_text22);
        TextView textView31 = to_add.findViewById(R.id.list_fragment_three_text31);
        TextView textView32 = to_add.findViewById(R.id.list_fragment_three_text32);

        LinearLayout ll1 = to_add.findViewById(R.id.list_fragment_three_ll1);
        LinearLayout ll2 = to_add.findViewById(R.id.list_fragment_three_ll2);
        LinearLayout ll3 = to_add.findViewById(R.id.list_fragment_three_ll3);

        ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(parent.getContext(), NotHomeActivity.class);
                i.putExtra("item", homeListData[position].getItemList()[0]);
                i.putExtra("content", ContentType.SINGE_ITEM);
                parent.getContext().startActivity(i);
            }
        });

        ll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(parent.getContext(), NotHomeActivity.class);
                i.putExtra("item", homeListData[position].getItemList()[1]);
                i.putExtra("content", ContentType.SINGE_ITEM);
                parent.getContext().startActivity(i);
            }
        });

        ll3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(parent.getContext(), NotHomeActivity.class);
                i.putExtra("item", homeListData[position].getItemList()[2]);
                i.putExtra("content", ContentType.SINGE_ITEM);
                parent.getContext().startActivity(i);
            }
        });

        textView11.setText(homeListData[position].getItemList()[0].getItem_title());
        textView12.setText(homeListData[position].getItemList()[0].getItem_price_string());
        textView21.setText(homeListData[position].getItemList()[1].getItem_title());
        textView22.setText(homeListData[position].getItemList()[1].getItem_price_string());
        textView31.setText(homeListData[position].getItemList()[2].getItem_title());
        textView32.setText(homeListData[position].getItemList()[2].getItem_price_string());

        imageView1.setImageResource(homeListData[position].getItemList()[0].getImgId());
        imageView2.setImageResource(homeListData[position].getItemList()[1].getImgId());
        imageView3.setImageResource(homeListData[position].getItemList()[2].getImgId());
        holder.linearLayoutInflate.addView(to_add);
    }

    private void setupFourItems(ViewHolder holder, final int position){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View to_add = layoutInflater.inflate(R.layout.list_fragment_four_items,
                holder.linearLayoutInflate, false);

        ImageView image1 = to_add.findViewById(R.id.list_fragment_four_image1);
        ImageView image2 = to_add.findViewById(R.id.list_fragment_four_image2);
        ImageView image3 = to_add.findViewById(R.id.list_fragment_four_image3);
        ImageView image4 = to_add.findViewById(R.id.list_fragment_four_image4);

        TextView textView11 = to_add.findViewById(R.id.list_fragment_four_text11);
        TextView textView12 = to_add.findViewById(R.id.list_fragment_four_text12);
        TextView textView21 = to_add.findViewById(R.id.list_fragment_four_text21);
        TextView textView22 = to_add.findViewById(R.id.list_fragment_four_text22);
        TextView textView31 = to_add.findViewById(R.id.list_fragment_four_text31);
        TextView textView32 = to_add.findViewById(R.id.list_fragment_four_text32);
        TextView textView41 = to_add.findViewById(R.id.list_fragment_four_text31);
        TextView textView42 = to_add.findViewById(R.id.list_fragment_four_text32);

        ConstraintLayout ll1 = to_add.findViewById(R.id.list_fragment_four_ll1);
        ConstraintLayout ll2 = to_add.findViewById(R.id.list_fragment_four_ll2);
        ConstraintLayout ll3 = to_add.findViewById(R.id.list_fragment_four_ll3);
        ConstraintLayout ll4 = to_add.findViewById(R.id.list_fragment_four_ll4);

        image1.setImageResource(homeListData[position].getItemList()[0].getImgId());
        image2.setImageResource(homeListData[position].getItemList()[1].getImgId());
        image3.setImageResource(homeListData[position].getItemList()[2].getImgId());
        image4.setImageResource(homeListData[position].getItemList()[3].getImgId());

        textView11.setText(homeListData[position].getItemList()[0].getItem_title());
        textView12.setText(homeListData[position].getItemList()[0].getItem_price_string());
        textView21.setText(homeListData[position].getItemList()[1].getItem_title());
        textView22.setText(homeListData[position].getItemList()[1].getItem_price_string());
        textView31.setText(homeListData[position].getItemList()[2].getItem_title());
        textView32.setText(homeListData[position].getItemList()[2].getItem_price_string());
        textView41.setText(homeListData[position].getItemList()[2].getItem_title());
        textView42.setText(homeListData[position].getItemList()[2].getItem_price_string());

        ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(parent.getContext(), NotHomeActivity.class);
                i.putExtra("item", homeListData[position].getItemList()[0]);
                i.putExtra("content", ContentType.SINGE_ITEM);
                parent.getContext().startActivity(i);
            }
        });

        ll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(parent.getContext(), NotHomeActivity.class);
                i.putExtra("item", homeListData[position].getItemList()[1]);
                i.putExtra("content", ContentType.SINGE_ITEM);
                parent.getContext().startActivity(i);
            }
        });

        ll3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(parent.getContext(), NotHomeActivity.class);
                i.putExtra("item", homeListData[position].getItemList()[2]);
                i.putExtra("content", ContentType.SINGE_ITEM);
                parent.getContext().startActivity(i);
            }
        });

        ll4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(parent.getContext(), NotHomeActivity.class);
                i.putExtra("item", homeListData[position].getItemList()[2]);
                i.putExtra("content", ContentType.SINGE_ITEM);
                parent.getContext().startActivity(i);
            }
        });

        holder.linearLayoutInflate.addView(to_add);
    }

}
