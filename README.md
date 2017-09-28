## Android--------工具类StatusBarUtil实现完美状态栏
 <p><span style="background-color:#ffffff; color:#000000">很早就想写这篇博客了，直到前几天有人问我这方面的问题才想起。</span></p> 
<p><span style="background-color:#ffffff; color:#000000">沉浸式状态栏是从android Kitkat（Android 4.4）开始出现的,顶部状态栏的颜色可以根据开发需求改变，使得APP风格更加好看，更加美观。</span></p> 
<p><span style="background-color:#ffffff; color:#000000">这是一个为Android App 设置状态栏的工具类， 可以在4.4及其以上系统中实现 沉浸式状态栏/状态栏变色，支持设置状态栏透明度。</span></p> 
<p><span style="background-color:#ffffff; color:#000000">先来看看案例的效果图：</span></p> 
<p><span style="background-color:#ffffff; color:#000000">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img alt="" src="http://images2017.cnblogs.com/blog/1041439/201709/1041439-20170927173032919-1040385828.gif" width="366"></span></p> 
<p><span style="background-color:#ffffff; color:#444444">&nbsp;</span></p> 
<p><span style="background-color:#ffffff; color:#444444">第一个是图片，其他的Fragment则是随机产生颜色。</span></p> 
<p>使用工具类 build.gradle引入</p> 
<pre><code class="language-java">
compile 'com.jaeger.statusbaruitl:library:1.3.0'

</code></pre> 
<p>StatusBarUtil具体源码 ：https://github.com/laobie/StatusBarUtil</p> 
<p>&nbsp;</p> 
<p>如何更好的改变状态栏颜色？ 可以在BaseActivity中写一个方法，如果某个Activity的颜色改变，则重新修改即可。</p> 
<pre><code class="language-java">public class BaseActivity extends AppCompatActivity {

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        setStatusBar();
    }

    protected void setStatusBar() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
    }

}</code></pre> 
<p>我的案例的Activity</p> 
<pre><code class="language-java">public class MainActivity extends BaseActivity {


    private ViewPager mVpHome;
    private BottomNavigationBar mBottomNavigationBar;
    private ArrayList&lt;Fragment&gt; mFragmentList = new ArrayList&lt;&gt;();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView(){
        mVpHome = (ViewPager) findViewById(R.id.viewpager);
        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_favorite, "One"))
                .addItem(new BottomNavigationItem(R.drawable.ic_gavel, "Two"))
                .addItem(new BottomNavigationItem(R.drawable.ic_grade, "Three"))
                .addItem(new BottomNavigationItem(R.drawable.ic_group_work, "Four"))
                .initialise();

        mBottomNavigationBar.setTabSelectedListener(new 

               BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                mVpHome.setCurrentItem(position);
                switch (position) {
                    case 0:
                        break;
                    default:
                        Random random = new Random();
                        int color = 0xff000000 | random.nextInt(0xffffff);
                        if (mFragmentList.get(position) instanceof SimpleFragment) {
                            ((SimpleFragment) mFragmentList.get(position))
                              .setTvTitleBackgroundColor(color);
                        }
                        break;
                }
            }

            @Override
            public void onTabUnselected(int position) {

            }
            @Override
            public void onTabReselected(int position) {

            }
        });

        mFragmentList.add(new ImageFragment());
        mFragmentList.add(new SimpleFragment());
        mFragmentList.add(new SimpleFragment());
        mFragmentList.add(new SimpleFragment());
        mVpHome.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int 
             positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mBottomNavigationBar.selectTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mVpHome.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }

            @Override
            public int getCount() {
                return mFragmentList.size();
            }
        });
    }

    /***
     * 重写，利用工具类 StatusBarUtil进行修改
     */
    @Override
    protected void setStatusBar() {
        StatusBarUtil.setTranslucentForImageViewInFragment(MainActivity.this, null);
    }
}</code></pre> 
<p>别忘了style中</p> 
<pre><code class="language-html"> &lt;style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar"&gt;
        &lt;!-- Customize your theme here. --&gt;
        &lt;item name="colorPrimary"&gt;@color/colorPrimary&lt;/item&gt;
        &lt;item name="colorPrimaryDark"&gt;@color/colorPrimaryDark&lt;/item&gt;
        &lt;item name="colorAccent"&gt;@color/colorAccent&lt;/item&gt;
        &lt;item name="windowNoTitle"&gt;true&lt;/item&gt;
        &lt;item name="windowActionBar"&gt;false&lt;/item&gt;
    &lt;/style&gt;</code></pre> 
