# android沉浸状态栏和顶部状态栏背景色的设置

<div id="article_content" class="article_content">

<span style="font-family:'Microsoft Yahei'; line-height:28px; text-indent:32px"></span>
<h3 id="一概述" style="font-size:16px; color:rgb(85,85,85); margin:0.8em 0px; padding:0px; font-weight:100; font-family:'microsoft yahei'; line-height:35px">
<span style="font-family:'microsoft yahei'; font-size:14px; line-height:35px">法一：</span></h3>
<p style="margin-top:0px; margin-bottom:1.1em; padding-top:0px; padding-bottom:0px; font-family:'microsoft yahei'; line-height:35px">
<span style="font-size:14px">现在很多应用都引用了沉浸式状态栏，如QQ，效果下图：</span></p>
<p style="font-size:14px; color:rgb(85,85,85); margin-top:0px; margin-bottom:1.1em; padding-top:0px; padding-bottom:0px; font-family:'microsoft yahei'; line-height:35px">
<img src="http://img.blog.csdn.net/20160726093554229?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center" alt=""><br>
</p>
<p style="font-size:14px; color:rgb(85,85,85); margin-top:0px; margin-bottom:1.1em; padding-top:0px; padding-bottom:0px; font-family:'microsoft yahei'; line-height:35px">
<span style="color:rgb(51,51,51); font-family:'Microsoft Yahei'; font-size:16px; line-height:28px"><br>
</span></p>
<p style="font-size:14px; color:rgb(85,85,85); margin-top:0px; margin-bottom:1.1em; padding-top:0px; padding-bottom:0px; font-family:'microsoft yahei'; line-height:35px">
<span style="color:rgb(51,51,51); font-family:'Microsoft Yahei'; font-size:16px; line-height:28px"><span style="color:rgb(51,51,51); font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px">这样的效果很酷炫，其实设置很简单。</span></span></p>
<p style="font-size:14px; color:rgb(85,85,85); margin-top:0px; margin-bottom:1.1em; padding-top:0px; padding-bottom:0px; font-family:'microsoft yahei'; line-height:35px">
<span style="color:rgb(51,51,51); font-family:'Microsoft Yahei'; font-size:16px; line-height:28px">不过要说明的是，这种效果只能在API19以及以上版本中才能够做到。</span></p>
<p><span style="color:rgb(51,51,51); font-family:'Microsoft Yahei'; font-size:16px; line-height:28px"><span style="color:rgb(51,51,51); font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px"><span style="color:rgb(51,51,51); font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px"><span style="color:rgb(51,51,51); font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px">&nbsp;
 &nbsp; &nbsp; &nbsp;如果想让界面Activity中实现这种效果，代码如下：</span>&nbsp;</span><br>
</span></span></p>
<p><span style="font-family:'Microsoft Yahei'; font-size:16px; line-height:28px"><span style="font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px"><span style="font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px"><span style="color:#333333">&nbsp;&nbsp;</span><span style="white-space:pre"><span style="color:#333333"></span><span style="color:#000099; background-color:rgb(255,255,255)"><strong>if</strong></span><span style="color:#333333">(VERSION.</span><span style="color:#3333ff">SDK_INT</span><span style="color:#333333">&gt;=
 VERSION_CODES.</span><span style="background-color:rgb(255,255,255)"><span style="color:#3333ff">KITKAT</span></span><span style="color:#333333">) {<br>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; //透明状态栏<br>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; getWindow().addFlags(WindowManager.LayoutParams.</span><span style="color:#3333ff">FLAG_TRANSLUCENT_STATUS)</span><span style="color:#333333">;<br>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; //透明导航栏<br>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; getWindow().addFlags(WindowManager.LayoutParams.</span><span style="background-color:rgb(255,255,255)"><span style="color:#3333ff">FLAG_TRANSLUCENT_NAVIGATION</span></span><span style="color:#333333">);<br>
&nbsp; &nbsp; &nbsp; &nbsp; }</span></span></span></span></span></p>
<p><span style="font-family:'Microsoft Yahei'; font-size:16px; line-height:28px"><span style="font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px"><span style="font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px"><span style="white-space:pre"><span style="color:rgb(51,51,51); font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px"></span><span style="font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px"><span style="color:#3333ff">VERSION_CODES.KITKAT</span></span><span style="color:rgb(51,51,51); font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px">就是</span><span style="font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px"><span style="color:#660000">API19</span></span><span style="color:rgb(51,51,51); font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px">的名称，只有手机系统版本</span><span style="font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px"><span style="color:#660000">大于19</span></span><span style="color:rgb(51,51,51); font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px">，才执行判断中的代码，才能显示沉浸状态栏的效果。&nbsp;</span><br style="color:rgb(51,51,51); font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px">
<span style="color:rgb(51,51,51); font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px">同时，这几句代码要写在</span><span style="font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px"><span style="color:#660000">setContentView(R.layout.XX);方法之前执行</span></span><span style="color:rgb(51,51,51); font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px">。</span><span style="color:#333333"><br>
</span></span></span></span></span></p>
<p><a target="_blank" target="_blank" name="t1" style="font-family:'microsoft yahei'; line-height:35px; font-size:16px; text-indent:32px; color:rgb(12,137,207); background-color:rgb(255,255,255)"><br>
</a></p>
<span style="line-height:28px"></span>
<p style="font-family:'microsoft yahei'; margin-top:0px; margin-bottom:1.1em; padding-top:0px; padding-bottom:0px; line-height:35px">
<span style="font-size:14px">&nbsp;先贴下效果图，以便和实现过程中做下对比</span></p>
<p style="font-family:'microsoft yahei'; margin-top:0px; margin-bottom:1.1em; padding-top:0px; padding-bottom:0px; line-height:35px">
<span style="font-size:14px"><img src="http://img.blog.csdn.net/20160726094643225?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center" alt=""><br>
</span></p>
<p style="font-family:'microsoft yahei'; margin-top:0px; margin-bottom:1.1em; padding-top:0px; padding-bottom:0px; line-height:35px">
<span style="font-size:14px">&nbsp;要去掉标题栏，在<span style="color:rgb(102,0,0); font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px; white-space:pre">setContentView(R.layout.XX);</span><span style="font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px; white-space:pre">之前</span><span style="font-family:'microsoft yahei'; font-size:14px; line-height:35px">加如代码：</span><span style="font-family:'microsoft yahei'; font-size:14px; line-height:35px">requestWindowFeature(Window.FEATURE_NO_TITLE);</span></span></p>
<p style="font-family:'microsoft yahei'; margin-top:0px; margin-bottom:1.1em; padding-top:0px; padding-bottom:0px; line-height:35px">
<span style="font-size:14px"><span style="font-family:'microsoft yahei'; font-size:14px; line-height:35px"><span style="font-family:'microsoft yahei'; font-size:14px; line-height:35px">&nbsp;效果图</span><br>
</span></span></p>
<p style="font-family:'microsoft yahei'; margin-top:0px; margin-bottom:1.1em; padding-top:0px; padding-bottom:0px; line-height:35px">
<span style="font-size:14px"><span style="font-family:'microsoft yahei'; font-size:14px; line-height:35px"><span style="font-family:'microsoft yahei'; font-size:14px; line-height:35px"><img src="http://img.blog.csdn.net/20160726094948813?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center" alt=""><br>
</span></span></span></p>
<p style="font-family:'microsoft yahei'; margin-top:0px; margin-bottom:1.1em; padding-top:0px; padding-bottom:0px; line-height:35px">
<span style="font-size:14px">API改为19以上，根标签添加背景颜色，然后</span></p>
<p style="font-family:'microsoft yahei'; margin-top:0px; margin-bottom:1.1em; padding-top:0px; padding-bottom:0px; line-height:35px">
<span style="font-size:14px"><img src="http://img.blog.csdn.net/20160726100426357?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center" alt=""><br>
</span></p>
<p style="margin-top:0px; margin-bottom:1.1em; padding-top:0px; padding-bottom:0px; line-height:35px">
<span style="font-family:Microsoft YaHei; font-size:14px"></span></p>
<h3 id="一概述" style="text-indent:32px; font-size:16px; color:rgb(85,85,85); margin:0.8em 0px; padding:0px; font-weight:100; font-family:'microsoft yahei'; line-height:35px">
<span style="font-size:14px">法二：</span></h3>
<p></p>
<p style="margin-top:0px; margin-bottom:1.1em; padding-top:0px; padding-bottom:0px; line-height:35px">
<span style="font-family:Microsoft YaHei; font-size:14px"><span style="color:rgb(51,51,51); font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px">在res目录下面新建一个values-v19文件夹，下面新建一个styles.xml文件，内容如下</span><br>
</span></p>
<p style="margin-top:0px; margin-bottom:1.1em; padding-top:0px; padding-bottom:0px; line-height:35px">
<span style="font-family:Microsoft YaHei; font-size:14px"><span style="color:rgb(51,51,51); font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px"><img src="http://img.blog.csdn.net/20160726095410080?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center" alt=""><br>
</span></span></p>
<p style="margin-top:0px; margin-bottom:1.1em; padding-top:0px; padding-bottom:0px; line-height:35px">
<span style="font-family:Microsoft YaHei; font-size:14px"><span style="color:rgb(51,51,51); font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px">当然这样还得在布局文件的根标签中添加</span></span></p>
<p style="margin-top:0px; margin-bottom:1.1em; padding-top:0px; padding-bottom:0px; line-height:35px">
<span style="font-family:Microsoft YaHei; font-size:14px"><span style="color:rgb(51,51,51); font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px">&nbsp; &nbsp;</span><span style="font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px"><span style="color:#cc0000">android:clipToPadding</span></span><span style="font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px"><span style="color:#333333">=</span><span style="color:#3333ff">&quot;true&quot;&nbsp;</span><br>
&nbsp; &nbsp;&nbsp;<span style="color:#cc0000">android:fitsSystemWindows</span></span><span style="color:rgb(51,51,51); font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px">=</span><span style="font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px"><span style="color:#3333ff">&quot;true&quot;</span><br>
</span></span></p>
<p style="margin-top:0px; margin-bottom:1.1em; padding-top:0px; padding-bottom:0px; line-height:35px">
<span style="font-family:Microsoft YaHei; font-size:14px"><span style="font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px">如果不添加这段代码的话，布局就会靠着顶部很近，就不好看了，</span></span></p>
<p style="margin-top:0px; margin-bottom:1.1em; padding-top:0px; padding-bottom:0px; line-height:35px">
<span style="font-family:Microsoft YaHei; font-size:14px"><span style="font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px"><img src="http://img.blog.csdn.net/20160726100555710?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center" alt=""><br>
</span></span></p>
<p style="margin-top:0px; margin-bottom:1.1em; padding-top:0px; padding-bottom:0px; line-height:35px">
<span style="font-family:Microsoft YaHei; font-size:14px"><span style="font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px">在AndroidManifest.xml 下的application 标签引用values<span style="color:rgb(51,51,51); font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px">-v19文件夹的styles.xml</span></span></span></p>
<p style="margin-top:0px; margin-bottom:1.1em; padding-top:0px; padding-bottom:0px; line-height:35px">
<span style="font-family:Microsoft YaHei; font-size:14px"><span style="font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px"><span style="color:rgb(51,51,51); font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px"><img src="http://img.blog.csdn.net/20160726101142369?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center" alt=""><br>
</span></span></span></p>
<p style="margin-top:0px; margin-bottom:1.1em; padding-top:0px; padding-bottom:0px; line-height:35px">
<span style="font-family:Microsoft YaHei; font-size:14px"><span style="font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px"><span style="color:rgb(51,51,51); font-family:'Microsoft Yahei'; font-size:16px; line-height:28px; text-indent:32px">运行效果是一样的。</span></span></span></p>
<p style="margin-top:0px; margin-bottom:1.1em; padding-top:0px; padding-bottom:0px; line-height:35px">
<span style="font-family:Microsoft YaHei; font-size:18px; color:#cc0000"><span style="font-family:'Microsoft Yahei'; line-height:28px; text-indent:32px"><span style="font-family:'Microsoft Yahei'; line-height:28px; text-indent:32px">源码下载：</span></span></span></p>
<p style="margin-top:0px; margin-bottom:1.1em; padding-top:0px; padding-bottom:0px; line-height:35px">
CSDN下载地址：<span style="font-size:14px"><a target="_blank" target="_blank" href="http://download.csdn.net/detail/dickyqie/9586254">http://download.csdn.net/detail/dickyqie/9586254</a></span></p>
<p style="margin-top:0px; margin-bottom:1.1em; padding-top:0px; padding-bottom:0px; line-height:35px">
github下载地址：<span style="font-size:14px; color:#cc0000"><a target="_blank" href="https://github.com/DickyQie/StatusBarDemo">https://github.com/DickyQie/StatusBarDemo</a></span></p>
   
</div>
