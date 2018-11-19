package com.example.abc.myapplication43;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    @BindView(R.id.viewpager)
    MyViewpager viewpager;

    private List<String> list;

    private List<View> list2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        list=new ArrayList<>();
        list2=new ArrayList<>();
        list.add("https://tse4-mm.cn.bing.net/th?id=OIP.dqAgMxrMGP51EwmQNEgh3QHaEK&w=286&h=160&c=7&o=5&dpr=1.4&pid=1.7");
        list.add("https://tse3-mm.cn.bing.net/th?id=OIP.IvwSOqBTMKT2jJmHZvQ-lAHaEK&w=286&h=160&c=7&o=5&dpr=1.4&pid=1.7");

        for(int i=0;i<list.size();i++)
        {
            View view= getLayoutInflater().from(this).inflate(R.layout.view_layout,null);
            PhotoView photoView=(PhotoView)view.findViewById(R.id.photoview);
            Glide.with(this).load(list.get(i)).into(photoView);
            list2.add(view);
        }


        MyPageAdapter adapter=new MyPageAdapter(list2);

        viewpager.setAdapter(adapter);
        viewpager.setCurrentItem(0);
    }
}
