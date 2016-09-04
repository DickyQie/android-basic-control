#  Popupwindow的使用
<div id="article_content" class="article_content">

<p><span style="font-family:SimSun; font-size:18px; line-height:26px">PopupWindow在</span><a target="_blank" target="_blank" href="http://lib.csdn.net/base/15" class="replace_word" title="Android知识库" style="text-decoration:none; font-family:SimSun; font-size:18px; line-height:26px"><span style="color:#000000">Android</span></a><span style="font-family:SimSun; font-size:18px; line-height:26px">.widget包下，<span style="font-family:Helvetica,Tahoma,Arial,sans-serif; font-size:14px; line-height:25.2px">项目中经常会使用到<span style="font-family:Tahoma,Arial,Helvetica,sans-serif; font-size:15px; line-height:27px">PopupWindow</span>做菜单选项</span>，<span style="font-family:Tahoma,Arial,Helvetica,sans-serif; font-size:15px; line-height:27px">&nbsp;
 PopupWindow这个类用来实现一个弹出框，</span><span style="font-family:Tahoma,Arial,Helvetica,sans-serif; font-size:15px; line-height:27px"><strong>可<span style="color:#ff0000">以使用任意布局的View作为其内容</span></strong></span><span style="font-family:Tahoma,Arial,Helvetica,sans-serif; font-size:15px; line-height:27px">，这个弹出框是悬浮在当前activity之上的。</span></span></p>
<p><span style="font-family:Tahoma,Arial,Helvetica,sans-serif"><span style="font-size:15px; line-height:27px">效果图：</span></span></p>
<p><img src="http://img.blog.csdn.net/20160829112624782?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center" alt="" style="font-size:15px; line-height:27px; font-family:Tahoma,Arial,Helvetica,sans-serif"></p>
<p><strong><br>
</strong></p>
<p><span style="font-family:Helvetica,Tahoma,Arial,sans-serif"><span style="font-size:14px; line-height:25.2px"><strong>Java代码：</strong></span></span></p>
<p><span style="font-family:Helvetica,Tahoma,Arial,sans-serif; color:#3333ff"><span style="font-size:14px; line-height:25.2px">MainActivity.java</span></span></p>
<p><span style="font-family:Helvetica,Tahoma,Arial,sans-serif; color:#3333ff"><span style="font-size:14px; line-height:25.2px"></span></span></p>
<p><strong><span style="color:#7F0055">public</span> <span style="color:#7F0055">
class&nbsp;</span></strong>MainActivity <strong><span style="color:#7F0055">extends</span></strong> Activity<strong><span style="color:#7F0055">implements&nbsp;</span></strong>OnClickListener {</p>
<p>&nbsp;</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<strong><span style="color:#7F0055">private</span></strong> PopupWindow<span style="color:#0000C0">mPopWindow</span>;</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<strong><span style="color:#7F0055">private</span></strong> View <u><span style="color:#0000C0">parentView</span></u>;</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<strong><span style="color:#7F0055">private</span></strong> Context <span style="color:#0000C0">
context</span>;</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;ImageView <span style="color:#0000C0">mImageViewBar</span>;</p>
<p>&nbsp;</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span style="color:#646464">@Override</span></p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<strong><span style="color:#7F0055">protected</span> <span style="color:#7F0055">
void</span></strong>onCreate(Bundle savedInstanceState) {</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<strong><span style="color:#7F0055">super</span></strong>.onCreate(savedInstanceState);</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;requestWindowFeature(Window.<em><span style="color:#0000C0">FEATURE_NO_TITLE</span></em>);</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;setContentView(R.layout.<em><span style="color:#0000C0">activity_main</span></em>);</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span style="color:#0000C0">context</span> = <strong><span style="color:#7F0055">this</span></strong>;</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;initView();</p>
<p>&nbsp; &nbsp; &nbsp; }</p>
<p>&nbsp;</p>
<p>&nbsp; &nbsp; &nbsp;&nbsp;<strong><span style="color:#7F0055">private</span> <span style="color:#7F0055">
void</span></strong>initView() {</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<span style="color:#3F7F5F">// </span><strong><span style="color:#7F9FBF">TODO</span></strong><span style="color:#3F7F5F">Auto-generated method stub</span></p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<span style="color:#0000C0">parentView</span> =getLayoutInflater().inflate(R.layout.<em><span style="color:#0000C0">activity_main</span></em>,<strong><u><span style="color:#7F0055">null</span></u></strong>);</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<span style="color:#0000C0">mImageViewBar</span> =(ImageView) findViewById(R.id.<em><span style="color:#0000C0">menu</span></em>);</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<span style="color:#0000C0">mImageViewBar</span>.setOnClickListener(<strong><span style="color:#7F0055">this</span></strong>);</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; showPopupWindow();</p>
<p>&nbsp; &nbsp; &nbsp;}</p>
<p>&nbsp;</p>
<p>&nbsp; &nbsp; &nbsp;&nbsp;<strong><span style="color:#7F0055">private</span> <span style="color:#7F0055">
void</span></strong>showPopupWindow() {</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;LayoutInflater inflater = (LayoutInflater)<span style="color:#0000C0">context</span></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; .getSystemService(Context.<em><span style="color:#0000C0">LAYOUT_INFLATER_SERVICE</span></em>);</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; View contentView =inflater.inflate(R.layout.<em><span style="color:#0000C0">popuplayout</span></em>,<strong><u><span style="color:#7F0055">null</span></u></strong>);</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<span style="color:#0000C0">mPopWindow</span> = <strong><span style="color:#7F0055">new</span></strong>PopupWindow(contentView);</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<span style="color:#0000C0">mPopWindow</span>.setWidth(ViewGroup.LayoutParams.<em><span style="color:#0000C0">WRAP_CONTENT</span></em>);</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<span style="color:#0000C0">mPopWindow</span>.setHeight(ViewGroup.LayoutParams.<em><span style="color:#0000C0">WRAP_CONTENT</span></em>);</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<span style="color:#0000C0">mPopWindow</span> = <strong><span style="color:#7F0055">new</span></strong>PopupWindow();</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<span style="color:#3F7F5F">// </span><span style="color:#3F7F5F">设置</span><span style="color:#3F7F5F">SelectPicPopupWindow</span><span style="color:#3F7F5F">的</span><span style="color:#3F7F5F">View</span></p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<span style="color:#0000C0">mPopWindow</span>.setContentView(contentView);</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<span style="color:#3F7F5F">// </span><span style="color:#3F7F5F">设置</span><span style="color:#3F7F5F">SelectPicPopupWindow</span><span style="color:#3F7F5F">弹出窗体的宽</span></p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<span style="color:#0000C0">mPopWindow</span>.setWidth(LayoutParams.<em><span style="color:#0000C0">WRAP_CONTENT</span></em>);</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<span style="color:#3F7F5F">// </span><span style="color:#3F7F5F">设置</span><span style="color:#3F7F5F">SelectPicPopupWindow</span><span style="color:#3F7F5F">弹出窗体的高</span></p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<span style="color:#0000C0">mPopWindow</span>.setHeight(LayoutParams.<em><span style="color:#0000C0">WRAP_CONTENT</span></em>);</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<span style="color:#3F7F5F">// </span><span style="color:#3F7F5F">设置</span><span style="color:#3F7F5F">SelectPicPopupWindow</span><span style="color:#3F7F5F">弹出窗体可点击</span></p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span style="color:#0000C0">mPopWindow</span>.setFocusable(<strong><span style="color:#7F0055">true</span></strong>);</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span style="color:#0000C0">mPopWindow</span>.setOutsideTouchable(<strong><span style="color:#7F0055">true</span></strong>);</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span style="color:#3F7F5F">// </span><span style="color:#3F7F5F">刷新状态</span></p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span style="color:#0000C0">mPopWindow</span>.update();</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span style="color:#3F7F5F">// </span><span style="color:#3F7F5F">实例化一个</span><span style="color:#3F7F5F">ColorDrawable</span><span style="color:#3F7F5F">颜色为半透明</span></p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;ColorDrawable dw = <strong><span style="color:#7F0055">new</span></strong>ColorDrawable(0000000000);</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span style="color:#3F7F5F">// </span><span style="color:#3F7F5F">点</span><span style="color:#3F7F5F">back</span><span style="color:#3F7F5F">键和其他地方使其消失</span><span style="color:#3F7F5F">,</span><span style="color:#3F7F5F">设置了这个才能触发</span><span style="color:#3F7F5F">OnDismisslistener</span><span style="color:#3F7F5F">，设置其他控件变化等操作</span></p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span style="color:#0000C0">mPopWindow</span>.setBackgroundDrawable(dw);</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;contentView.findViewById(R.id.<em><span style="color:#0000C0">memu1</span></em>).setOnClickListener(<strong><span style="color:#7F0055">this</span></strong>);</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;contentView.findViewById(R.id.<em><span style="color:#0000C0">memu2</span></em>).setOnClickListener(<strong><span style="color:#7F0055">this</span></strong>);</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;contentView.findViewById(R.id.<em><span style="color:#0000C0">memu3</span></em>).setOnClickListener(<strong><span style="color:#7F0055">this</span></strong>);</p>
<p>&nbsp; &nbsp; &nbsp; }</p>
<p>&nbsp;</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp;<span style="color:#646464">@Override</span></p>
<p>&nbsp; &nbsp; &nbsp;&nbsp;<strong><span style="color:#7F0055">public</span> <span style="color:#7F0055">
void</span></strong>onClick(View v) {</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<strong><span style="color:#7F0055">int</span></strong> id =v.getId();</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<strong><span style="color:#7F0055">switch</span></strong> (id) {</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<strong><span style="color:#7F0055">case</span></strong> R.id.<em><span style="color:#0000C0">menu</span></em>:</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span style="color:#0000C0">mPopWindow</span>.showAsDropDown(<span style="color:#0000C0">mImageViewBar</span>);</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<strong><span style="color:#7F0055">break</span></strong>;</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<strong><span style="color:#7F0055">case</span></strong> R.id.<em><span style="color:#0000C0">memu1</span></em>: {</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Toast.<em>makeText</em>(<span style="color:#0000C0">context</span>,<span style="color:#2A00FF">&quot;</span><span style="color:#2A00FF">消息</span><span style="color:#2A00FF">&quot;</span>, Toast.<em><span style="color:#0000C0">LENGTH_SHORT</span></em>).show();</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span style="color:#0000C0">mPopWindow</span>.dismiss();</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;}</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<strong><span style="color:#7F0055">break</span></strong>;</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<strong><span style="color:#7F0055">case</span></strong> R.id.<em><span style="color:#0000C0">memu2</span></em>: {</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Toast.<em>makeText</em>(<span style="color:#0000C0">context</span>,<span style="color:#2A00FF">&quot;</span><span style="color:#2A00FF">收藏</span><span style="color:#2A00FF">&quot;</span>, Toast.<em><span style="color:#0000C0">LENGTH_SHORT</span></em>).show();</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<span style="color:#0000C0">mPopWindow</span>.dismiss();</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; }</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<strong><span style="color:#7F0055">break</span></strong>;</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<strong><span style="color:#7F0055">case</span></strong> R.id.<em><span style="color:#0000C0">memu3</span></em>: {</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Toast.<em>makeText</em>(<span style="color:#0000C0">context</span>,<span style="color:#2A00FF">&quot;</span><span style="color:#2A00FF">首页</span><span style="color:#2A00FF">&quot;</span>, Toast.<em><span style="color:#0000C0">LENGTH_SHORT</span></em>).show();</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<span style="color:#0000C0">mPopWindow</span>.dismiss();</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; }</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<strong><span style="color:#7F0055">break</span></strong>;</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;}</p>
<p>&nbsp; &nbsp; &nbsp; }</p>
<p>&nbsp;&nbsp; </p>
<p>&nbsp; &nbsp; &nbsp;&nbsp;<span style="color:#646464">@Override</span></p>
<p>&nbsp; &nbsp; &nbsp; &nbsp;<strong><span style="color:#7F0055">protected</span> <span style="color:#7F0055">
void</span></strong>onDestroy() {</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span style="color:#3F7F5F">// </span><strong><span style="color:#7F9FBF">TODO</span></strong><span style="color:#3F7F5F">Auto-generated method stub</span></p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<strong><span style="color:#7F0055">super</span></strong>.onDestroy();</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span style="color:#0000C0">mPopWindow</span>.dismiss();</p>
<p>&nbsp; &nbsp; &nbsp;}</p>
<p>&nbsp; }</p>
activity_main.xml
<p><span style="font-family:Helvetica,Tahoma,Arial,sans-serif; color:#3333ff"><span style="font-size:14px; line-height:25.2px"></span></span></p>
<p><span style="color:teal">&lt;?</span><span style="color:#3F7F7F">xml</span> <span style="color:#7F007F">
version</span>=<em><span style="color:#2A00FF">&quot;1.0&quot;</span></em> <span style="color:#7F007F">
encoding</span>=<em><span style="color:#2A00FF">&quot;utf-8&quot;</span></em><span style="color:teal">?&gt;</span></p>
<p><span style="color:teal">&lt;</span><span style="color:#3F7F7F">LinearLayout</span><span style="color:#7F007F">xmlns:android</span>=<em><span style="color:#2A00FF">&quot;http://schemas.android.com/apk/res/android&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;match_parent&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;match_parent&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:background</span>=<em><span style="color:#2A00FF">&quot;#FFFFFF&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:orientation</span>=<em><span style="color:#2A00FF">&quot;vertical&quot;</span></em><span style="color:teal">&gt;</span></p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp;&nbsp; <span style="color:teal">&lt;</span><span style="color:#3F7F7F">RelativeLayout</span></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;match_parent&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;wrap_content&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:background</span>=<em><span style="color:#2A00FF">&quot;#E4E4E4&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:minHeight</span>=<em><span style="color:#2A00FF">&quot;55dp&quot;</span></em><span style="color:teal">&gt;</span></p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;<u><span style="color:teal">&lt;</span><span style="color:#3F7F7F">ImageView</span></u></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;20dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;20dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_centerVertical</span>=<em><span style="color:#2A00FF">&quot;true&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_marginLeft</span>=<em><span style="color:#2A00FF">&quot;8dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_marginRight</span>=<em><span style="color:#2A00FF">&quot;5dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:focusable</span>=<em><span style="color:#2A00FF">&quot;true&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:src</span>=<em><span style="color:#2A00FF">&quot;@drawable/abc_ic_ab_back_mtrl_am_alpha&quot;</span></em><span style="color:teal">/&gt;</span></p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <u><span style="color:teal">&lt;</span><span style="color:#3F7F7F">ImageView</span></u></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:id</span>=<em><span style="color:#2A00FF">&quot;@&#43;id/menu&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;20dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;20dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_alignParentRight</span>=<em><span style="color:#2A00FF">&quot;true&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_centerVertical</span>=<em><span style="color:#2A00FF">&quot;true&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_marginRight</span>=<em><span style="color:#2A00FF">&quot;9dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:src</span>=<em><span style="color:#2A00FF">&quot;@drawable/top_arrow_message1&quot;</span></em><span style="color:teal">/&gt;</span></p>
<p>&nbsp;&nbsp;&nbsp; <span style="color:teal">&lt;/</span><span style="color:#3F7F7F">RelativeLayout</span><span style="color:teal">&gt;</span></p>
<p>&nbsp;</p>
<p><span style="color:teal">&lt;/</span><span style="color:#3F7F7F">LinearLayout</span><span style="color:teal">&gt;</span></p>
popuplayout.xml<br>
<p><span style="font-family:Helvetica,Tahoma,Arial,sans-serif; color:#3333ff"><span style="font-size:14px; line-height:25.2px"></span></span></p>
<p><span style="color:teal">&lt;?</span><span style="color:#3F7F7F">xml</span> <span style="color:#7F007F">
version</span>=<em><span style="color:#2A00FF">&quot;1.0&quot;</span></em> <span style="color:#7F007F">
encoding</span>=<em><span style="color:#2A00FF">&quot;utf-8&quot;</span></em><span style="color:teal">?&gt;</span></p>
<p><span style="color:teal">&lt;</span><span style="color:#3F7F7F">LinearLayout</span><span style="color:#7F007F">xmlns:android</span>=<em><span style="color:#2A00FF">&quot;http://schemas.android.com/apk/res/android&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;match_parent&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;wrap_content&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:gravity</span>=<em><span style="color:#2A00FF">&quot;center&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:orientation</span>=<em><span style="color:#2A00FF">&quot;vertical&quot;</span></em><span style="color:teal">&gt;</span></p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp;&nbsp; <u><span style="color:teal">&lt;</span><span style="color:#3F7F7F">LinearLayout</span></u></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;120dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;130dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_marginRight</span>=<em><span style="color:#2A00FF">&quot;2dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:background</span>=<em><span style="color:#2A00FF">&quot;@drawable/danchu&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:gravity</span>=<em><span style="color:#2A00FF">&quot;center_vertical&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:orientation</span>=<em><span style="color:#2A00FF">&quot;vertical&quot;</span></em><span style="color:teal">&gt;</span></p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:teal">&lt;</span><span style="color:#3F7F7F">RelativeLayout</span></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:id</span>=<em><span style="color:#2A00FF">&quot;@&#43;id/memu1&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;wrap_content&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;30dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_marginTop</span>=<em><span style="color:#2A00FF">&quot;5dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:gravity</span>=<em><span style="color:#2A00FF">&quot;center_vertical&quot;</span></em><span style="color:teal">&gt;</span></p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <u><span style="color:teal">&lt;</span><span style="color:#3F7F7F">ImageView</span></u></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:id</span>=<em><span style="color:#2A00FF">&quot;@&#43;id/xiaoxi&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;20dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;20dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_marginLeft</span>=<em><span style="color:#2A00FF">&quot;10dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:src</span>=<em><span style="color:#2A00FF">&quot;@drawable/android_arrow_application&quot;</span></em><span style="color:teal">/&gt;</span></p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:teal">&lt;</span><span style="color:#3F7F7F">TextView</span></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:id</span>=<em><span style="color:#2A00FF">&quot;@&#43;id/pop_computer&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;wrap_content&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;wrap_content&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_marginLeft</span>=<em><span style="color:#2A00FF">&quot;10dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_toRightOf</span>=<em><span style="color:#2A00FF">&quot;@&#43;id/xiaoxi&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <u><span style="color:#7F007F">android:text</span>=<em><span style="color:#2A00FF">&quot;</span></em></u><em><u><span style="color:#2A00FF">消息</span><span style="color:#2A00FF">&quot;</span></u></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:textColor</span>=<em><span style="color:#2A00FF">&quot;#FFFFFF&quot;</span></em><span style="color:teal">/&gt;</span></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:teal">&lt;/</span><span style="color:#3F7F7F">RelativeLayout</span><span style="color:teal">&gt;</span></p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:teal">&lt;</span><span style="color:#3F7F7F">View</span></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;wrap_content&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;1dp&quot;</span></em><span style="color:teal">/&gt;</span></p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:teal">&lt;</span><span style="color:#3F7F7F">RelativeLayout</span></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:id</span>=<em><span style="color:#2A00FF">&quot;@&#43;id/memu2&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;wrap_content&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;30dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_marginTop</span>=<em><span style="color:#2A00FF">&quot;5dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:gravity</span>=<em><span style="color:#2A00FF">&quot;center_vertical&quot;</span></em><span style="color:teal">&gt;</span></p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:teal">&lt;</span><span style="color:#3F7F7F">ImageView</span></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:id</span>=<em><span style="color:#2A00FF">&quot;@&#43;id/shanchu&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;20dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;20dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_marginLeft</span>=<em><span style="color:#2A00FF">&quot;10dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:src</span>=<em><span style="color:#2A00FF">&quot;@drawable/android_arrow_profitbillsm&quot;</span></em><span style="color:teal">/&gt;</span></p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:teal">&lt;</span><span style="color:#3F7F7F">TextView</span></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;wrap_content&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;wrap_content&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_marginLeft</span>=<em><span style="color:#2A00FF">&quot;10dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_toRightOf</span>=<em><span style="color:#2A00FF">&quot;@&#43;id/shanchu&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:text</span>=<em><span style="color:#2A00FF">&quot;</span><span style="color:#2A00FF">收藏</span><span style="color:#2A00FF">&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:textColor</span>=<em><span style="color:#2A00FF">&quot;#FFFFFF&quot;</span></em><span style="color:teal">/&gt;</span></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:teal">&lt;/</span><span style="color:#3F7F7F">RelativeLayout</span><span style="color:teal">&gt;</span></p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:teal">&lt;</span><span style="color:#3F7F7F">View</span></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;wrap_content&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;1dp&quot;</span></em><span style="color:teal">/&gt;</span></p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:teal">&lt;</span><span style="color:#3F7F7F">RelativeLayout</span></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:id</span>=<em><span style="color:#2A00FF">&quot;@&#43;id/memu3&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;wrap_content&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;30dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_marginBottom</span>=<em><span style="color:#2A00FF">&quot;5dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_marginTop</span>=<em><span style="color:#2A00FF">&quot;5dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:gravity</span>=<em><span style="color:#2A00FF">&quot;center_vertical&quot;</span></em><span style="color:teal">&gt;</span></p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <u><span style="color:teal">&lt;</span><span style="color:#3F7F7F">ImageView</span></u></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:#7F007F">android:id</span>=<em><span style="color:#2A00FF">&quot;@&#43;id/dianjifanhui&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;18dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;20dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_marginLeft</span>=<em><span style="color:#2A00FF">&quot;10dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:src</span>=<em><span style="color:#2A00FF">&quot;@drawable/dir15&quot;</span></em><span style="color:teal">/&gt;</span></p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:teal">&lt;</span><span style="color:#3F7F7F">TextView</span></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:id</span>=<em><span style="color:#2A00FF">&quot;@&#43;id/pop_manage&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;wrap_content&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;wrap_content&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_marginLeft</span>=<em><span style="color:#2A00FF">&quot;10dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_toRightOf</span>=<em><span style="color:#2A00FF">&quot;@&#43;id/dianjifanhui&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <u><span style="color:#7F007F">android:text</span>=<em><span style="color:#2A00FF">&quot;</span></em></u><em><u><span style="color:#2A00FF">首页</span><span style="color:#2A00FF">&quot;</span></u></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:textColor</span>=<em><span style="color:#2A00FF">&quot;#FFFFFF&quot;</span></em><span style="color:teal">/&gt;</span></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:teal">&lt;/</span><span style="color:#3F7F7F">RelativeLayout</span><span style="color:teal">&gt;</span></p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:teal">&lt;</span><span style="color:#3F7F7F">View</span></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;wrap_content&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;1dp&quot;</span></em><span style="color:teal">/&gt;</span></p>
<p>&nbsp;&nbsp;&nbsp; <span style="color:teal">&lt;/</span><span style="color:#3F7F7F">LinearLayout</span><span style="color:teal">&gt;</span></p>
<p>&nbsp;</p>
<p><span style="color:teal">&lt;/</span><span style="color:#3F7F7F">LinearLayout</span><span style="color:teal">&gt;</span></p>
<br>
<p><span style="font-family:Helvetica,Tahoma,Arial,sans-serif; color:#3333ff"><span style="font-size:14px; line-height:25.2px"></span></span></p>
<p style="margin-top:0px; margin-bottom:0.75em; padding-top:0px; padding-bottom:0px; font-family:Arial; font-size:14px; line-height:26px; text-indent:14px; background-color:rgb(254,254,254)">
<span style="font-family:Verdana,Arial,Helvetica,sans-serif; color:rgb(51,51,255)"><span style="line-height:21px">项目源码：</span></span></p>
<p style="margin-top:0px; margin-bottom:0.75em; padding-top:0px; padding-bottom:0px; font-family:Arial; font-size:14px; line-height:26px; text-indent:14px; background-color:rgb(254,254,254)">
<span style="font-family:Verdana,Arial,Helvetica,sans-serif; color:rgb(51,51,255)"><span style="line-height:21px">Eclipse:&nbsp;<a target="_blank" target="_blank" href="http://download.csdn.net/detail/dickyqie/9615658">http://download.csdn.net/detail/dickyqie/9615658</a></span></span></p>
<p style="margin-top:0px; margin-bottom:0.75em; padding-top:0px; padding-bottom:0px; font-family:Arial; font-size:14px; line-height:26px; text-indent:14px; background-color:rgb(254,254,254)">
<span style="font-family:Verdana,Arial,Helvetica,sans-serif; color:rgb(51,51,255)">AndroidStudio:&nbsp;<a target="_blank" href="https://github.com/DickyQie/PopupWindow">https://github.com/DickyQie/PopupWindow</a></span></p>
<p style="margin-top:0px; margin-bottom:0.75em; padding-top:0px; padding-bottom:0px; font-family:Arial; font-size:14px; line-height:26px; text-indent:14px; background-color:rgb(254,254,254)">
<br>
</p>
<br>
<p><span style="font-family:Tahoma,Arial,Helvetica,sans-serif"><span style="font-size:15px; line-height:27px"><br>
</span></span></p>
<p><span style="font-family:Tahoma,Arial,Helvetica,sans-serif"><span style="font-size:15px; line-height:27px"><br>
</span></span></p>
<p><span style="font-family:Tahoma,Arial,Helvetica,sans-serif"><span style="font-size:15px; line-height:27px"><br>
</span></span></p>
<p><span style="font-family:SimSun; font-size:18px; line-height:26px"><span style="font-family:Tahoma,Arial,Helvetica,sans-serif; font-size:15px; line-height:27px"><br>
</span></span></p>
<p><span style="font-family:SimSun; font-size:18px; line-height:26px"></span></p>
   
</div>
