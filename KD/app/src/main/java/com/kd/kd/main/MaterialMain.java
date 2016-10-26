package com.kd.kd.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.kd.kd.R;
import com.kd.kd.kDtools.CircleImageView;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.Inflater;

public class MaterialMain extends DrawerActivity {
    private MaterialViewPager mViewPager;
    private Toolbar toolbar;
    private static final int ITEM_COUNT = 10;//记录的条数
    private int[] image1={R.mipmap.image1,R.mipmap.image2,R.mipmap.image3,R.mipmap.image4
            ,R.mipmap.image5,R.mipmap.image6,R.mipmap.image7,R.mipmap.image8,R.mipmap.image9,R.mipmap.image10};
    private ArrayList<String>titlelist1=new ArrayList<>(Arrays.asList("傻逼","二傻","三傻","牛逼网","楼上是蠢猪","楼中上是蠢猪"
            ,"杀人不眨眼","天下第一","我是大笨蛋","人生无偿"));
    private int[] image2={R.mipmap.image4
            ,R.mipmap.image5,R.mipmap.image6,R.mipmap.image7,R.mipmap.image1,R.mipmap.image2,R.mipmap.image3,R.mipmap.image8,R.mipmap.image9,R.mipmap.image10};
    private ArrayList<String>titlelist2=new ArrayList<>(Arrays.asList("楼中上是蠢猪"
            ,"杀人不眨眼","天下第一","我是大笨蛋","傻逼","二傻","三傻","牛逼网","楼上是蠢猪","人生无偿"));
    private String url="http://image.baidu.com/search/down?tn=download&ipn=dwnl&word=download&ie=utf8&fr=result&url=http%3A%2F%2Fimg05.tooopen.com%2Fimages%2F20140604%2Fsy_62331342149.jpg&thumburl=http%3A%2F%2Fimg5.imgtn.bdimg.com%2Fit%2Fu%3D2033765348%2C1346395611%26fm%3D21%26gp%3D0.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_main);

        setTitle("");
        mViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);


//如果你想过一会去更新这些条目，建议你把它以变量的形式保存
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("home");
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(2).withName("settes");

//创建drawer，并且基础它的返回值
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item1,
                        new DividerDrawerItem(),
                        item2,
                        new SecondaryDrawerItem().withName("settes")
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D
                    return true;
                    }
                })
                .build();
        toolbar = mViewPager.getToolbar();
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position % 4) {
                    case 0:
                        return RecyclerViewFragment.newInstance(image2,titlelist2);
                    case 1:
                        return RecyclerViewFragment.newInstance(image2,titlelist2);
                    case 2:
                       return RecyclerViewFragment.newInstance(image1,titlelist1);
                    case 3:
                        return RecyclerViewFragment.newInstance(image1,titlelist1);

                }return null;
            }

            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 4) {
                    case 0:
                        return "接单区";
                    case 1:
                        return "发单区";
                    case 2:
                        return "评论区";
                    case 3:
                        return "交流区";
                }
                return "";
            }
        });

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {

                    case 0:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.md_blue_grey_50,
                                "http://image.baidu.com/search/down?tn=download&ipn=dwnl&word=download&ie=utf8&fr=result&url=http%3A%2F%2Fimg05.tooopen.com%2Fimages%2F20140604%2Fsy_62331342149.jpg&thumburl=http%3A%2F%2Fimg5.imgtn.bdimg.com%2Fit%2Fu%3D2033765348%2C1346395611%26fm%3D21%26gp%3D0.jpg");
                    case 1:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.blue,
                                "http://image.baidu.com/search/down?tn=download&ipn=dwnl&word=download&ie=utf8&fr=result&url=http%3A%2F%2Fup.qqjia.com%2Fz%2F17%2Ftu17742_2.jpg&thumburl=http%3A%2F%2Fimg1.imgtn.bdimg.com%2Fit%2Fu%3D619035232%2C399014571%26fm%3D21%26gp%3D0.jpg");
                    case 2:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.red,
                                "http://image.baidu.com/search/down?tn=download&ipn=dwnl&word=download&ie=utf8&fr=result&url=http%3A%2F%2Fup.qqjia.com%2Fz%2F17%2Ftu17742_2.jpg&thumburl=http%3A%2F%2Fimg1.imgtn.bdimg.com%2Fit%2Fu%3D619035232%2C399014571%26fm%3D21%26gp%3D0.jpg");
                    case 3:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.green_teal,
                                "http://image.baidu.com/search/down?tn=download&ipn=dwnl&word=download&ie=utf8&fr=result&url=http%3A%2F%2Fimg05.tooopen.com%2Fimages%2F20140604%2Fsy_62331342149.jpg&thumburl=http%3A%2F%2Fimg5.imgtn.bdimg.com%2Fit%2Fu%3D2033765348%2C1346395611%26fm%3D21%26gp%3D0.jpg");
                }

                //execute others actions if needed (ex : modify your header logo)
            return null;

            }
        });

        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());

        View logo = findViewById(R.id.logo_white);
        if (logo != null) {
            logo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mViewPager.notifyHeaderChanged();
                    Toast.makeText(getApplicationContext(), "Yes, the title is clickable", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    }

