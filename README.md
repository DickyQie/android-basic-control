### Android------底部导航栏BottomNavigationBar
<div id="cnblogs_post_body" class="blogpost-body"><p>Android 的底部导航栏 BottomNavigationBar 由Google官方Material design中增加的。</p>
<p>Android底部导航栏的实现方式特别多，例如TabHost，TabLayout，或者TextView等，都可以实现底部导航栏的效果。</p>
<p>但Google既然推出了还是可以尽量用他来实现底部导航栏这样的功能。</p>
<p>下来看看案例效果图</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img src="http://images2017.cnblogs.com/blog/1041439/201709/1041439-20170928103605465-732384731.gif" alt="" width="399"></p>
<p>&nbsp;</p>
<p>使用添加依赖</p>
<p>&nbsp;</p>
<div class="cnblogs_code">
<pre><span style="color: #008080">compile</span> <span style="color: #ff6600">'com.ashokvarma.android:bottom-navigation-bar:1.3.0'</span></pre>
</div>
<p>&nbsp;</p>
<p>布局文件</p>
<div class="cnblogs_code">
<pre><span style="color: #0000ff">&lt;?</span><span style="color: #ff00ff">xml version="1.0" encoding="utf-8"</span><span style="color: #0000ff">?&gt;</span>
<span style="color: #0000ff">&lt;</span><span style="color: #800000">LinearLayout </span><span style="color: #ff0000">xmlns:android</span><span style="color: #0000ff">="http://schemas.android.com/apk/res/android"</span><span style="color: #ff0000">
    xmlns:tools</span><span style="color: #0000ff">="http://schemas.android.com/tools"</span><span style="color: #ff0000">
    android:id</span><span style="color: #0000ff">="@+id/activity_main"</span><span style="color: #ff0000">
    android:layout_width</span><span style="color: #0000ff">="match_parent"</span><span style="color: #ff0000">
    android:layout_height</span><span style="color: #0000ff">="match_parent"</span><span style="color: #ff0000">
    android:orientation</span><span style="color: #0000ff">="vertical"</span><span style="color: #ff0000">
    tools:context</span><span style="color: #0000ff">="com.zhangqie.bottomnavigationbar.MainActivity"</span><span style="color: #0000ff">&gt;</span>

    <span style="color: #0000ff">&lt;</span><span style="color: #800000">FrameLayout
        </span><span style="color: #ff0000">android:id</span><span style="color: #0000ff">="@+id/fragment"</span><span style="color: #ff0000">
        android:layout_width</span><span style="color: #0000ff">="match_parent"</span><span style="color: #ff0000">
        android:layout_height</span><span style="color: #0000ff">="0dp"</span><span style="color: #ff0000">
        android:layout_weight</span><span style="color: #0000ff">="1"</span><span style="color: #0000ff">/&gt;</span>

    <span style="color: #0000ff">&lt;</span><span style="color: #800000">com</span><span style="color: #ff0000">.ashokvarma.bottomnavigation.BottomNavigationBar
        android:id</span><span style="color: #0000ff">="@+id/bottom_navigation_bar"</span><span style="color: #ff0000">
        android:layout_width</span><span style="color: #0000ff">="match_parent"</span><span style="color: #ff0000">
        android:layout_height</span><span style="color: #0000ff">="wrap_content"</span><span style="color: #ff0000">
        android:layout_gravity</span><span style="color: #0000ff">="bottom"</span>
        <span style="color: #0000ff">/&gt;</span>

<span style="color: #0000ff">&lt;/</span><span style="color: #800000">LinearLayout</span><span style="color: #0000ff">&gt;</span></pre>
</div>
<p>&nbsp;</p>
<p>BottomNavigationBar的属性设置</p>
<div class="cnblogs_code">
<pre>mBottomNavigationBar =<span style="color: #000000"> (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomNavigationBar.setBarBackgroundColor(android.R.color.white);
        badgeItem </span>= <span style="color: #0000ff">new</span><span style="color: #000000"> BadgeItem()
                .setBackgroundColor(Color.RED).setText(</span>"99"<span style="color: #000000">)<span style="color: #008000">//<span style="color: #008000">设置角标内容</span></span>
                .setHideOnSelect(</span><span style="color: #0000ff">true</span>); <span style="color: #008000">//</span><span style="color: #008000">设置被选中时隐藏角标</span>
<span style="color: #000000">        mBottomNavigationBar
                .setActiveColor(R.color.colorBottomBack) </span><span style="color: #008000">//</span><span style="color: #008000">设置选中的颜色</span>
                .setInActiveColor(R.color.colorActive);<span style="color: #008000">//</span><span style="color: #008000">未选中颜色</span>
<span style="color: #000000">
        mBottomNavigationBar.addItem(</span><span style="color: #0000ff">new</span> BottomNavigationItem(R.drawable.icon_home_normal, "首页"<span style="color: #000000">))<span style="color: #008000">//<span style="color: #008000">添加图标和文字</span></span>
                .addItem(</span><span style="color: #0000ff">new</span> BottomNavigationItem(R.drawable.icon_shop_normal, "店铺"<span style="color: #000000">))
                .addItem(</span><span style="color: #0000ff">new</span> BottomNavigationItem(R.drawable.icon_cart_normal, "购物车"<span style="color: #000000">))
                .addItem(</span><span style="color: #0000ff">new</span> BottomNavigationItem(R.drawable.icon_my_normal, "我的"<span style="color: #000000">).setBadgeItem(badgeItem))
                .initialise();<br>　　     <span style="color: #000000"><span style="color: #008000">//<span style="color: #008000">设置点击事件</span></span></span>
        mBottomNavigationBar.setTabSelectedListener(</span><span style="color: #0000ff">new</span><span style="color: #000000"> BottomNavigationBar.OnTabSelectedListener(){

            @Override
            </span><span style="color: #0000ff">public</span> <span style="color: #0000ff">void</span> onTabSelected(<span style="color: #0000ff">int</span><span style="color: #000000"> position) {
                showFragment(position);
            }

            @Override
            </span><span style="color: #0000ff">public</span> <span style="color: #0000ff">void</span> onTabUnselected(<span style="color: #0000ff">int</span><span style="color: #000000"> position) {

            }

            @Override
            </span><span style="color: #0000ff">public</span> <span style="color: #0000ff">void</span> onTabReselected(<span style="color: #0000ff">int</span><span style="color: #000000"> position) {

            }
        });</span></pre>
</div>
<p>&nbsp;</p>
<p>setMode的相关属性</p>
<p>包含3种Mode:<br><br>MODE_DEFAULT</p>
<ul>
<li>&nbsp;&nbsp; 如果Item的个数&lt;=3就会使用MODE_FIXED模式，否则使用MODE_SHIFTING模式</li>


</ul>
<p><br>MODE_FIXED （固定大小）</p>
<ul>
<li>&nbsp;&nbsp; 填充模式，未选中的Item会显示文字，没有换挡动画。</li>
<li>&nbsp;&nbsp; 宽度=总宽度/action个数</li>
<li>&nbsp;&nbsp; 最大宽度: 168dp</li>
<li>&nbsp;&nbsp; 最小宽度: 80dp</li>
<li>&nbsp;&nbsp; Padding：6dp（8dp）、10dp、12dp</li>
<li>&nbsp;&nbsp; 字体大小：12sp、14sp</li>


</ul>
<p><br>MODE_SHIFTING （不固定大小）</p>
<ul>
<li>换挡模式，未选中的Item不会显示文字，选中的会显示文字。在切换的时候会有一个像换挡的动画</li>


</ul>
<p>&nbsp;</p>
<p>setBackgroundStyles的相关属性</p>
<p><br>包含3种Style:<br>BACKGROUND_STYLE_DEFAULT</p>
<ul>
<li>如果设置的Mode为MODE_FIXED，将使用BACKGROUND_STYLE_STATIC 。如果Mode为MODE_SHIFTING将使用BACKGROUND_STYLE_RIPPLE。</li>


</ul>
<p><br>BACKGROUND_STYLE_STATIC</p>
<ul>
<li>点击的时候没有水波纹效果</li>
<li>航条的背景色是白色，加上setBarBackgroundColor（）可以设置成你所需要的任何背景颜色</li>


</ul>
<p>BACKGROUND_STYLE_RIPPLE</p>
<ul>
<li>点击的时候有水波纹效果</li>
<li>导航条的背景色是你设置的处于选中状态的 Item的颜色（ActiveColor），也就是setActiveColorResource这个设置的颜色</li>


</ul>
<p>&nbsp;</p>

