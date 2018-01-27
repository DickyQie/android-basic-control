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
<span id="OSC_h2_1"></span>
