## Android----- 改变图标原有颜色 和 搜索框

  <p><strong>本博客主要讲以下两点知识点</strong></p> 
<p><strong>图标改变颜色</strong>：Drawable的变色，让Android也能有iOS那么方便的图片色调转换，就像同一个图标，但是有多个地方使用，并且颜色不一样，就可以用这个方法了。</p> 
<p><strong>搜索框： </strong>一般是EditText实现，本文 实现 TextView图片和文字居中，键盘搜索。</p> 
<p>来看看效果图：</p> 
<p>&nbsp;&nbsp;&nbsp;&nbsp; <img alt="" height="646" src="http://images2017.cnblogs.com/blog/1041439/201709/1041439-20170914155405125-1018769923.gif" width="428"></p> 
<p>&nbsp;</p> 
<p>&nbsp;图标改变颜色：第一个界面的左边（二维码）和右边（更多）两个实现，我放进去的图片是黑色的，显示出来是白色的。</p> 
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <img alt="" src="http://images2017.cnblogs.com/blog/1041439/201709/1041439-20170914160358188-1629284929.png"></p> 
<p>搜索框：第一个界面的图片和文字居中，还可以设置间距，第二个见面搜索设置键盘搜索按钮，点击搜索监听事件，清除内容的图标。</p> 
<p>搜索框布局：</p> 
<pre><code class="language-html">　&lt;!--
            搜索图标设置  左边
            android:drawableLeft="@mipmap/icon_search"
            android:drawablePadding="5dp"  图标和文字的间距
            右边
            android:drawableRight="@mipmap/round_close"
            android:paddingRight="8dp"
            android:imeOptions="actionSearch"  设置成搜索按钮
        --&gt;
       &lt;EditText
            android:id="@+id/search_text"
            android:layout_width="0dp"
            android:layout_weight="1"
            android:layout_height="30dp"
            android:hint="输入要搜索的商品"
            android:background="@drawable/search_gray"
            android:layout_marginTop="10dp"
            android:layout_marginLeft="9dp"
            android:textSize="12sp"
            android:drawableLeft="@mipmap/icon_search"
            android:paddingLeft="9dp"
            android:drawablePadding="5dp"
            android:drawableRight="@mipmap/round_close"
            android:paddingRight="8dp"
            android:imeOptions="actionSearch"
            android:maxLines="1"
            android:singleLine="true"
          /&gt;</code></pre> 
<p>键盘监听：</p> 
<pre><code class="language-java">searchText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((actionId == 0 || actionId == 3) &amp;&amp; event != null) {
　　　　　　　　　　　　　//提示搜索内容
                    Toast.makeText(SearchActivity.this,searchText.getText().toString(),Toast.LENGTH_LONG).show();
                    //可以跳转搜索页面
                   /* Intent intent= new Intent(SearchActivity.this,SearchWebViewActivity.class);
                    intent.putExtra("model",model);
                    intent.putExtra("search",searchText.getText().toString());
                    startActivity(intent);
                    finish();*/
                }
                return false;
            }
        });</code></pre> 
<p>首页布局：</p> 
<pre><code class="language-html">&lt;LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@color/colorPrimary"
        android:minHeight="45dp"
        android:orientation="horizontal"
        android:gravity="center_vertical"
        &gt;
        &lt;ImageButton
            android:id="@+id/home_left_scan"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:paddingRight="19dp"
            android:paddingTop="3dp"
            android:paddingBottom="3dp"
            android:paddingLeft="11dp"
            android:layout_centerVertical="true"
            android:background="#00000000"
            /&gt;
        &lt;com.zhangqie.searchbox.view.DrawableTextView
            android:id="@+id/home_search"
            android:layout_width="match_parent"
            android:layout_height="28dp"
            android:layout_weight="1"
            android:background="@drawable/search_view_background"
            android:gravity="center_vertical"
            android:maxLines="1"
            android:text="输入搜索相关内容"
            android:drawableLeft="@mipmap/icon_search"
            android:textSize="12sp"
            android:drawablePadding="11dp"
            /&gt;
        &lt;ImageButton
            android:id="@+id/home_right_more"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerVertical="true"
            android:layout_alignParentRight="true"
            android:paddingRight="15dp"
            android:paddingTop="3dp"
            android:paddingBottom="3dp"
            android:paddingLeft="15dp"
            android:background="#00000000"
            /&gt;
    &lt;/LinearLayout&gt;</code></pre> 
<p>自定义DrawableTextView：（文字图标居中）</p> 
<pre><code class="language-java">public class DrawableTextView extends TextView {

    public DrawableTextView(Context context, AttributeSet attrs,
                            int defStyle) {
        super(context, attrs, defStyle);
    }

    public DrawableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawableTextView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable[] drawables = getCompoundDrawables();
        // 得到drawableLeft设置的drawable对象
        Drawable leftDrawable = drawables[0];
        if (leftDrawable != null) {
            // 得到leftDrawable的宽度
            int leftDrawableWidth = leftDrawable.getIntrinsicWidth();
            // 得到drawable与text之间的间距
            int drawablePadding = getCompoundDrawablePadding();
            // 得到文本的宽度
            int textWidth = (int) getPaint().measureText(getText().toString().trim());
            int bodyWidth = leftDrawableWidth + drawablePadding + textWidth;
            canvas.save();
            canvas.translate((getWidth() - bodyWidth) / 2, 0);
        }
        super.onDraw(canvas);
    }
}</code></pre> 
