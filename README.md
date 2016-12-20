#  Popupwindow的使用
 <p>PopupWindow在Android.widget包下，项目中经常会使用到PopupWindow做菜单选项，&nbsp; PopupWindow这个类用来实现一个弹出框，可以使用任意布局的View作为其内容，这个弹出框是悬浮在当前activity之上的。</p> 
<p>效果图：</p> 
<p><img alt="" src="http://img.blog.csdn.net/20160829112624782?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center"></p> 
<p>MainActivity.java</p> 
<pre><code class="language-java">public class MainActivity extends Activityimplements OnClickListener {
 
         private PopupWindow mPopWindow;
         private View parentView;
         private Context context;
         ImageView mImageViewBar;
 
         @Override
         protected voidonCreate(Bundle savedInstanceState) {
                   super.onCreate(savedInstanceState);
                   requestWindowFeature(Window.FEATURE_NO_TITLE);
                   setContentView(R.layout.activity_main);
                   context = this;
                   initView();
      }
 
      private void initView() {
        // TODOAuto-generated method stub
          parentView =getLayoutInflater().inflate(R.layout.activity_main,null);
          mImageViewBar =(ImageView) findViewById(R.id.menu);
          mImageViewBar.setOnClickListener(this);
          showPopupWindow();
     }
 
      private void showPopupWindow() {
           LayoutInflater inflater = (LayoutInflater)context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          View contentView =inflater.inflate(R.layout.popuplayout,null);
          mPopWindow = newPopupWindow(contentView);
          mPopWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
          mPopWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
          mPopWindow = newPopupWindow();
          // 设置SelectPicPopupWindow的View
          mPopWindow.setContentView(contentView);
          // 设置SelectPicPopupWindow弹出窗体的宽
          mPopWindow.setWidth(LayoutParams.WRAP_CONTENT);
          // 设置SelectPicPopupWindow弹出窗体的高
          mPopWindow.setHeight(LayoutParams.WRAP_CONTENT);
          // 设置SelectPicPopupWindow弹出窗体可点击
         mPopWindow.setFocusable(true);
         mPopWindow.setOutsideTouchable(true);
         // 刷新状态
         mPopWindow.update();
         // 实例化一个ColorDrawable颜色为半透明
         ColorDrawable dw = new ColorDrawable(0000000000);
         // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener，设置其他控件变化等操作
         mPopWindow.setBackgroundDrawable(dw);
         contentView.findViewById(R.id.memu1).setOnClickListener(this);
         contentView.findViewById(R.id.memu2).setOnClickListener(this);
         contentView.findViewById(R.id.memu3).setOnClickListener(this);
      }
 
       @Override
      public void onClick(View v) {
         int id =v.getId();
         switch (id) {
           case R.id.menu:
                 mPopWindow.showAsDropDown(mImageViewBar);
                 break;
           case R.id.memu1: {
                 Toast.makeText(context,"消息", Toast.LENGTH_SHORT).show();
                 mPopWindow.dismiss();
               }
                break;
           case R.id.memu2: {
                Toast.makeText(context,"收藏", Toast.LENGTH_SHORT).show();
                mPopWindow.dismiss();
              }
               break;
           case R.id.memu3: {
                Toast.makeText(context,"首页", Toast.LENGTH_SHORT).show();
                mPopWindow.dismiss();
              }
               break;
             }
      }
  
      @Override
       protected void onDestroy() {
           // TODOAuto-generated method stub
            super.onDestroy();
           mPopWindow.dismiss();
     }
  }</code></pre> 
<p>&nbsp;</p> 
<pre><code class="language-html">activity_main.xml
&lt;?xml version="1.0" encoding="utf-8"?&gt;
&lt;LinearLayoutxmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#FFFFFF"
    android:orientation="vertical"&gt;
 
    &lt;RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="#E4E4E4"
        android:minHeight="55dp"&gt;
 
        &lt;ImageView
            android:layout_width="20dp"
            android:layout_height="20dp"
            android:layout_centerVertical="true"
            android:layout_marginLeft="8dp"
            android:layout_marginRight="5dp"
            android:focusable="true"
            android:src="@drawable/abc_ic_ab_back_mtrl_am_alpha"/&gt;
 
        &lt;ImageView
            android:id="@+id/menu"
            android:layout_width="20dp"
            android:layout_height="20dp"
            android:layout_alignParentRight="true"
            android:layout_centerVertical="true"
            android:layout_marginRight="9dp"
            android:src="@drawable/top_arrow_message1"/&gt;
    &lt;/RelativeLayout&gt;
 
&lt;/LinearLayout&gt;
popuplayout.xml
&lt;?xml version="1.0" encoding="utf-8"?&gt;
&lt;LinearLayoutxmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:gravity="center"
    android:orientation="vertical"&gt;
 
    &lt;LinearLayout
        android:layout_width="120dp"
        android:layout_height="130dp"
        android:layout_marginRight="2dp"
        android:background="@drawable/danchu"
        android:gravity="center_vertical"
        android:orientation="vertical"&gt;
 
        &lt;RelativeLayout
            android:id="@+id/memu1"
            android:layout_width="wrap_content"
            android:layout_height="30dp"
            android:layout_marginTop="5dp"
            android:gravity="center_vertical"&gt;
 
            &lt;ImageView
                android:id="@+id/xiaoxi"
                android:layout_width="20dp"
                android:layout_height="20dp"
                android:layout_marginLeft="10dp"
                android:src="@drawable/android_arrow_application"/&gt;
 
            &lt;TextView
                android:id="@+id/pop_computer"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginLeft="10dp"
                android:layout_toRightOf="@+id/xiaoxi"
                android:text="消息"
                android:textColor="#FFFFFF"/&gt;
        &lt;/RelativeLayout&gt;
 
        &lt;View
            android:layout_width="wrap_content"
            android:layout_height="1dp"/&gt;
 
        &lt;RelativeLayout
            android:id="@+id/memu2"
            android:layout_width="wrap_content"
            android:layout_height="30dp"
            android:layout_marginTop="5dp"
            android:gravity="center_vertical"&gt;
 
            &lt;ImageView
                android:id="@+id/shanchu"
                android:layout_width="20dp"
                android:layout_height="20dp"
                android:layout_marginLeft="10dp"
                android:src="@drawable/android_arrow_profitbillsm"/&gt;
 
            &lt;TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginLeft="10dp"
                android:layout_toRightOf="@+id/shanchu"
                android:text="收藏"
                android:textColor="#FFFFFF"/&gt;
        &lt;/RelativeLayout&gt;
 
        &lt;View
            android:layout_width="wrap_content"
            android:layout_height="1dp"/&gt;
 
        &lt;RelativeLayout
            android:id="@+id/memu3"
            android:layout_width="wrap_content"
            android:layout_height="30dp"
            android:layout_marginBottom="5dp"
            android:layout_marginTop="5dp"
            android:gravity="center_vertical"&gt;
 
            &lt;ImageView
                android:id="@+id/dianjifanhui"
                android:layout_width="18dp"
                android:layout_height="20dp"
                android:layout_marginLeft="10dp"
                android:src="@drawable/dir15"/&gt;
 
            &lt;TextView
                android:id="@+id/pop_manage"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginLeft="10dp"
                android:layout_toRightOf="@+id/dianjifanhui"
                android:text="首页"
                android:textColor="#FFFFFF"/&gt;
        &lt;/RelativeLayout&gt;
 
        &lt;View
            android:layout_width="wrap_content"
            android:layout_height="1dp"/&gt;
    &lt;/LinearLayout&gt;
 
&lt;/LinearLayout&gt;</code></pre> 
<span id="OSC_h2_1"></span>
<h2>项目源码：</h2> 
<p>Eclipse:&nbsp;<a href="http://download.csdn.net/detail/dickyqie/9615658" target="_blank" rel="nofollow">http://download.csdn.net/detail/dickyqie/9615658</a></p> 
<p>AndroidStudio:&nbsp;<a href="https://github.com/DickyQie/PopupWindow" target="_blank" rel="nofollow">https://github.com/DickyQie/PopupWindow</a></p>
