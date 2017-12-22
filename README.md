### Android------底部导航栏BottomNavigationBar
		<div class="edit-box">
				<textarea name="content" class="editor-content"  id="ckeditor" > &lt;p&gt;Android 的底部导航栏 BottomNavigationBar 由Google官方Material design中增加的。&lt;/p&gt; 
&lt;p&gt;Android底部导航栏的实现方式特别多，例如TabHost，TabLayout，或者TextView等，都可以实现底部导航栏的效果。&lt;/p&gt; 
&lt;p&gt;但Google既然推出了还是可以尽量用他来实现底部导航栏这样的功能。&lt;/p&gt; 
&lt;p&gt;下来看看案例效果图&lt;/p&gt; 
&lt;p&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp; &lt;img alt="" src="http://images2017.cnblogs.com/blog/1041439/201709/1041439-20170928103605465-732384731.gif" width="399"&gt;&lt;/p&gt; 
&lt;p&gt;&amp;nbsp;&lt;/p&gt; 
&lt;p&gt;使用添加依赖&lt;/p&gt; 
&lt;pre&gt;&lt;code class="language-java"&gt;
compile 'com.ashokvarma.android:bottom-navigation-bar:1.3.0'

&lt;/code&gt;&lt;/pre&gt; 
&lt;p&gt;布局文件&lt;/p&gt; 
&lt;pre&gt;&lt;code class="language-html"&gt;&amp;lt;?xml version="1.0" encoding="utf-8"?&amp;gt;
&amp;lt;LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/activity_main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context="com.zhangqie.bottomnavigationbar.MainActivity"&amp;gt;

    &amp;lt;FrameLayout
        android:id="@+id/fragment"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"/&amp;gt;

    &amp;lt;com.ashokvarma.bottomnavigation.BottomNavigationBar
        android:id="@+id/bottom_navigation_bar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="bottom"
        /&amp;gt;

&amp;lt;/LinearLayout&amp;gt;&lt;/code&gt;&lt;/pre&gt; 
&lt;p&gt;BottomNavigationBar的属性设置&lt;/p&gt; 
&lt;pre&gt;&lt;code class="language-java"&gt;mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomNavigationBar.setBarBackgroundColor(android.R.color.white);
        badgeItem = new BadgeItem()
                .setBackgroundColor(Color.RED).setText("99")//设置角标内容
                .setHideOnSelect(true); //设置被选中时隐藏角标
        mBottomNavigationBar
                .setActiveColor(R.color.colorBottomBack) //设置选中的颜色
                .setInActiveColor(R.color.colorActive);//未选中颜色

        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.icon_home_normal,
           "首页"))//添加图标和文字
                .addItem(new BottomNavigationItem(R.drawable.icon_shop_normal, "店铺"))
                .addItem(new BottomNavigationItem(R.drawable.icon_cart_normal, "购物车"))
                .addItem(new BottomNavigationItem(R.drawable.icon_my_normal, "我的")
                .setBadgeItem(badgeItem))
                .initialise();
　　     //设置点击事件
        mBottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener(){

            @Override
            public void onTabSelected(int position) {
                showFragment(position);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });&lt;/code&gt;&lt;/pre&gt; 
&lt;p&gt;setMode的相关属性&lt;/p&gt; 
&lt;p&gt;包含3种Mode:&lt;br&gt; &lt;br&gt; MODE_DEFAULT&lt;/p&gt; 
&lt;ul&gt; 
 &lt;li&gt;&amp;nbsp;&amp;nbsp; 如果Item的个数&amp;lt;=3就会使用MODE_FIXED模式，否则使用MODE_SHIFTING模式&lt;/li&gt; 
&lt;/ul&gt; 
&lt;p&gt;&lt;br&gt; MODE_FIXED （固定大小）&lt;/p&gt; 
&lt;ul&gt; 
 &lt;li&gt;&amp;nbsp;&amp;nbsp; 填充模式，未选中的Item会显示文字，没有换挡动画。&lt;/li&gt; 
 &lt;li&gt;&amp;nbsp;&amp;nbsp; 宽度=总宽度/action个数&lt;/li&gt; 
 &lt;li&gt;&amp;nbsp;&amp;nbsp; 最大宽度: 168dp&lt;/li&gt; 
 &lt;li&gt;&amp;nbsp;&amp;nbsp; 最小宽度: 80dp&lt;/li&gt; 
 &lt;li&gt;&amp;nbsp;&amp;nbsp; Padding：6dp（8dp）、10dp、12dp&lt;/li&gt; 
 &lt;li&gt;&amp;nbsp;&amp;nbsp; 字体大小：12sp、14sp&lt;/li&gt; 
&lt;/ul&gt; 
&lt;p&gt;&lt;br&gt; MODE_SHIFTING （不固定大小）&lt;/p&gt; 
&lt;ul&gt; 
 &lt;li&gt;换挡模式，未选中的Item不会显示文字，选中的会显示文字。在切换的时候会有一个像换挡的动画&lt;/li&gt; 
&lt;/ul&gt; 
&lt;p&gt;&amp;nbsp;&lt;/p&gt; 
&lt;p&gt;setBackgroundStyles的相关属性&lt;/p&gt; 
&lt;p&gt;&lt;br&gt; 包含3种Style:&lt;br&gt; BACKGROUND_STYLE_DEFAULT&lt;/p&gt; 
&lt;ul&gt; 
 &lt;li&gt;如果设置的Mode为MODE_FIXED，将使用BACKGROUND_STYLE_STATIC 。如果Mode为MODE_SHIFTING将使用BACKGROUND_STYLE_RIPPLE。&lt;/li&gt; 
&lt;/ul&gt; 
&lt;p&gt;&lt;br&gt; BACKGROUND_STYLE_STATIC&lt;/p&gt; 
&lt;ul&gt; 
 &lt;li&gt;点击的时候没有水波纹效果&lt;/li&gt; 
 &lt;li&gt;航条的背景色是白色，加上setBarBackgroundColor（）可以设置成你所需要的任何背景颜色&lt;/li&gt; 
&lt;/ul&gt; 
&lt;p&gt;BACKGROUND_STYLE_RIPPLE&lt;/p&gt; 
&lt;ul&gt; 
 &lt;li&gt;点击的时候有水波纹效果&lt;/li&gt; 
 &lt;li&gt;导航条的背景色是你设置的处于选中状态的 Item的颜色（ActiveColor），也就是setActiveColorResource这个设置的颜色&lt;/li&gt; 
&lt;/ul&gt; 
&lt;p&gt;&amp;nbsp;&lt;/p&gt; 
&lt;p&gt;BottomNavigationBar源码：https://github.com/Ashok-Varma/BottomNavigation&lt;/p&gt; 
&lt;p&gt;&lt;strong&gt;&lt;span style="color:#008080"&gt;由于代码太多，就不一一贴出来了，源码直接下载即可&lt;/span&gt;&lt;/strong&gt;&lt;/p&gt; 
&lt;p&gt;&lt;span style="color:#3366ff"&gt;&lt;strong&gt;&lt;a href="https://github.com/DickyQie/android-basic-control/tree/bottom-navigationbar" target="_blank" rel="nofollow"&gt;&lt;span style="color:#3366ff"&gt;源码传送门&lt;/span&gt;&lt;/a&gt;&lt;/strong&gt;&lt;/span&gt;&lt;/p&gt; 
&lt;p&gt;&amp;nbsp;&lt;/p&gt; </textarea>
			</div>

