# FlexboxLayout——Android弹性布局 
 <p>FlexboxLayout是一个Android平台上与CSS的 Flexible box 弹性盒子布局模块 有相似功能的库。Flexbox 是CSS 的一种布局方案，可以简单、快捷的实现复杂布局。</p> 
<p>FlexboxLayout项目开源地址：<a href="https://github.com/google/flexbox-layout" target="_blank" rel="nofollow">https://github.com/google/flexbox-layout</a></p> 
<p>效果如图下：</p> 
<p>&nbsp;　　　　　　<img alt="" src="http://images2017.cnblogs.com/blog/1041439/201708/1041439-20170814095507225-391342420.gif"></p> 
<p>项目中添加依赖</p> 
<pre><code class="language-java">
compile 'com.google.android:flexbox:0.2.2'

</code></pre> 
<span id="OSC_h3_1"></span>
<h3>FlexboxLayout 常用属性</h3> 
<span id="OSC_h3_2"></span>
<h3>flexDirection</h3> 
<p><strong>flexDirection属性决定了主轴的方向，即FlexboxLayout里子Item的排列方向</strong>，有以下四种取值：</p> 
<ol> 
 <li>row (default)： 默认值，主轴为水平方向，从左到右。</li> 
 <li>row_reverse：主轴为水平方向，起点在有端，从右到左。</li> 
 <li>column：主轴为竖直方向，起点在上端，从上到下。</li> 
 <li>column_reverse：主轴为竖直方向，起点在下端，从下往上。</li> 
</ol> 
<pre><code class="language-html">&lt;com.google.android.flexbox.FlexboxLayout
        android:id="@+id/flexbox_layout4"
        android:layout_width="match_parent"
        android:layout_height="119dp"
        android:layout_marginTop="9dp"
        app:flexDirection="column"&gt;
.................</code></pre> 
<span id="OSC_h4_3"></span>
<h4>flexWrap</h4> 
<p><strong>flexWrap 这个属性决定Flex 容器是单行还是多行，并且决定副轴（与主轴垂直的轴）的方向。</strong>可能有以下3个值：</p> 
<ol> 
 <li>noWrap: 不换行，一行显示完子元素。</li> 
 <li>wrap: 按正常方向换行。</li> 
 <li>wrap_reverse: 按反方向换行。</li> 
</ol> 
<pre><code class="language-html"> &lt;com.google.android.flexbox.FlexboxLayout
        android:id="@+id/flexbox_layout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:flexWrap="wrap"
        &gt;
     ...............</code></pre> 
<span id="OSC_h4_4"></span>
<h4>justifyContent</h4> 
<p><strong>justifyContent 属性控制元素主轴方向上的对齐方式</strong>，有以下5种取值：</p> 
<ol> 
 <li>flex_start (default): 默认值，左对齐</li> 
 <li>flex_end: 右对齐</li> 
 <li>center: 居中对齐</li> 
 <li>space_between: 两端对齐，中间间隔相同</li> 
 <li>space_around: 每个元素到两侧的距离相等。</li> 
</ol> 
<pre><code class="language-html">&lt;com.google.android.flexbox.FlexboxLayout
        android:id="@+id/flexbox_layout2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:justifyContent="space_between"
        &gt;
............</code></pre> 
<span id="OSC_h4_5"></span>
<h4>alignItems</h4> 
<p><strong>alignItems 属性控制元素在副轴方向的对齐方式</strong>，有以下5种取值：</p> 
<ol> 
 <li>stretch (default) ：默认值，如果item没有设置高度，则充满容器高度。</li> 
 <li>flex_start：顶端对齐</li> 
 <li>flex_end：底部对齐</li> 
 <li>center：居中对齐</li> 
 <li>baseline：第一行内容的的基线对齐</li> 
</ol> 
<pre><code class="language-html"> &lt;com.google.android.flexbox.FlexboxLayout
        android:id="@+id/flexbox_layout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_marginTop="9dp"
        app:alignItems="flex_start"&gt;
..........................</code></pre> 
<span id="OSC_h4_6"></span>
<h4>alignContent</h4> 
<p><strong>alignContent 属性控制多根轴线的对齐方式(也就是控制多行，如果子元素只有一行，则不起作用（针对多行元素）</strong>，表示控件在副轴上的对齐方向，默认值为stretch，表示占满整个副轴，因为上文中我把FlexboxLayout的高度设置为包裹内容，所以这个属性大家可能没看到效果，这里我把FlexboxLayout的高度改为match_parent，可能有以下6种取值：</p> 
<ol> 
 <li>stretch (default): 默认值，充满交叉轴的高度（测试发现，需要alignItems 的值也为stretch 才有效）。</li> 
 <li>flex_start: 与交叉轴起点对齐。</li> 
 <li>flex_end: 与交叉轴终点对齐。</li> 
 <li>center: 与交叉轴居中对齐。</li> 
 <li>space_between: 交叉轴两端对齐，中间间隔相等。</li> 
 <li>space_around: 到交叉轴两端的距离相等。</li> 
</ol> 
<pre><code class="language-html"> &lt;com.google.android.flexbox.FlexboxLayout
        android:id="@+id/flexbox_layout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:alignContent="flex_start"
        app:flexWrap="wrap"
        app:alignItems="center"
        &gt;
..............</code></pre> 
<span id="OSC_h4_7"></span>
<h4>子元素的属性</h4> 
<p>layout_order</p> 
<p><code>layout_order</code> 属性可以改变子元素的排列顺序，默认情况下，FlexboxLayout子元素的排列是按照xml文件中出现的顺序。默认值为1，值越小排在越靠前。</p> 
<p>layout_flexGrow(float)</p> 
<p><code>layout_flexGrow</code> 子元素的放大比例， 决定如何分配剩余空间（如果存在剩余空间的话），默认值为0,不会分配剩余空间，如果有一个item的 <code>layout_flexGrow</code> 是一个正值，那么会将全部剩余空间分配给这个Item,如果有多个Item这个属性都为正值，那么剩余空间的分配按照<code>layout_flexGrow</code>定义的比例（有点像<code>LinearLayout</code>的<code>layout_weight</code>属性）。</p> 
<p>layout_flexShrink(float)</p> 
<p><code>layout_flexShrink</code>:子元素缩小比例，当空间不足时，子元素需要缩小（设置了换行则无效），默认值为1，如果所有子元素的<code>layout_flexShrink</code> 值为1,空间不足时，都等比缩小，如果有一个为0，其他为1，空间不足时，为0的不缩小，负值无效。</p> 
<p>layout_alignSelf</p> 
<p><code>layout_alignSelf</code> 属性可以给子元素设置对齐方式，上面讲的<code>alignItems</code>属性可以设置对齐，这个属性的功能和<code>alignItems</code>一样，只不过<code>alignItems</code>作用于所有子元素，而 <code>layout_alignSelf</code> 作用于单个子元素。默认值为auto, 表示继承<code>alignItems</code>属性，如果为auto以外的值，则会覆盖<code>alignItems</code>属性。有以下6种取值：</p> 
<ul> 
 <li>auto (default)</li> 
 <li>flex_start</li> 
 <li>flex_end</li> 
 <li>center</li> 
 <li>baseline</li> 
 <li>stretch</li> 
</ul> 
<p>除了<code>auto</code>以外，其他和<code>alignItems</code>属性一样。</p> 
<p>layout_flexBasisPercent (fraction)</p> 
<p><code>layout_flexBasisPercent</code>的值为一个百分比，表示设置子元素的长度为它父容器长度的百分比，如果设置了这个值，那么通过这个属性计算的值将会覆盖<code>layout_width</code>或者<code>layout_height</code>的值。<strong>但是需要注意，这个值只有设置了父容器的长度时才有效（也就是MeasureSpec mode 是 MeasureSpec.EXACTLY）</strong>。默认值时-1。</p> 
<p>layout_minWidth / layout_minHeight (dimension)</p> 
<p>强制限制 FlexboxLayout的子元素（宽或高）不会小于最小值，不管<code>layout_flexShrink</code>这个属性的值为多少，子元素不会被缩小到小于设置的这个最小值。</p> 
<p>layout_maxWidth / layout_maxHeight (dimension)</p> 
<p>这个和上面的刚好相反，强制限制FlexboxLayout子元素不会大于这个最大值, 不管<code>layout_flexGrow</code>的值为多少，子元素不会被放大到超过这个最大值。</p> 
<p>layout_wrapBefore</p> 
<p><code>layout_wrapBefore</code> 属性控制强制换行，默认值为false,如果将一个子元素的这个属性设置为true，那么这个子元素将会成为一行的第一个元素。这个属性将忽略<code>flex_wrap</code> 设置的 noWrap值。</p> 
<p>&nbsp;</p> 
<p>更多属性或功能去官网查看，本案例希望对各位有那么帮助。</p> 
<p>&nbsp;</p> 
<p>&nbsp;</p> 
<p><strong><span style="color:#008080">不足之处请留言指正！有问题的可以给我留言！谢谢！</span></strong></p> 
<p>&nbsp;</p> 
<p><span style="color:#000000">由于代码太多，就不一一贴出来了，直接下载即可，</span></p>
