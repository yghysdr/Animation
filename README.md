---
title: Android 动画总结
date: 2016年9月23日10:19:19
tags:
 - Android
 - 工具
---
> Android中的动画分为帧动画Drawable Animation,补间动画View Animation，属性动画Property Animation。

<!--more-->
#帧动画 Drawable Animation
>像播放幻灯片一样,依次播放每张每张动画。也就是每个效果都是一张图片。

##属性
- 节点：animation-list 必须是根节点

|属性|作用|
|----|----|
|android:oneshot|true代表只执行一次，false循环执行|
|item|一个item是一个图片|
- 节点：item

|属性|作用|
|----|----|
|android:drawable|Drawable资源|
|android:duration|显示多长时间||
##实现

1.配置xml文件：res/drawable/frame_voice
```
<?xml version="1.0" encoding="utf-8"?>
<animation-list xmlns:android="http://schemas.android.com/apk/res/android"
    android:oneshot="false">
    <item
        android:drawable="@drawable/chat_left_voice_1"
        android:duration="200" />
    <item
        android:drawable="@drawable/chat_left_voice_2"
        android:duration="200" />
    <item
        android:drawable="@drawable/chat_left_voice_3"
        android:duration="200" />
</animation-list>
```
2.java
```
view.setBackgroundResource(R.drawable.frame_voice);
AnimationDrawable mAnimationDrawable = (AnimationDrawable)view.getBackground();
mAnimationDrawable.start();
```

#补间动画 View Animation

>特别特别注意：补间动画执行之后并未改变View的真实布局属性值。切记这一点，譬如我们在Activity中有一个Button在屏幕上方，
我们设置了平移动画移动到屏幕下方然后保持动画最后执行状态呆在屏幕下方，这时如果点击屏幕下方动画执行之后的Button是
没有任何反应的，而点击原来屏幕上方没有Button的地方却响应的是点击Button的事件
##动画分类

|java类名|xml标签|位置|效果|
|----|----|----|----|
|AlphaAnimation|<alpha>|放置在res/anim/目录下|渐变透明度动画效果|
|RotateAnimation|<rotate>|放置在res/anim/目录下|画面转移旋转动画效果|
|ScaleAnimation|<scale>|放置在res/anim/目录下|渐变尺寸伸缩动画效果|
|TranslateAnimation|<translate>|放置在res/anim/目录下|画面转换位置移动动画效果|
|AnimationSet|<set>|放置在res/anim/目录下|	一个持有其它动画元素alpha、scale、translate、rotate或者其它set元素的容器|
##通用属性详情

|xml属性|java方法|效果|
|----|-----|----|
|android:detachWallpaper|setDetachWallpaper(boolean)|是否在壁纸上运行|
|android:duration|setDuration(long)|动画持续时间，毫秒为单位|
|android:fillAfter|setFillAfter(boolean)|控件动画结束时是否保持动画最后的状态|
|android:fillBefore|setFillBefore(boolean)|控件动画结束时是否还原到开始动画前的状态|
|android:fillEnabled|setFillEnabled(boolean)|与android:fillBefore效果相同|
|android:interpolator|setInterpolator(Interpolator)|设定插值器（指定的动画效果，譬如回弹等）|
|android:repeatCount|setRepeatCount(int)|重复播放次数n，（即播放n+1次）|
|android:repeatMode|setRepeatMode(int)|重复类型有两个值，reverse表示倒序回放，restart表示从头播放|
|android:startOffset|setStartOffset(long)|调用start函数之后等待开始运行的时间，单位为毫秒|
|android:zAdjustment|setZAdjustment(int)|表示被设置动画的内容运行时在Z轴上的位置（top/bottom/normal），默认为normal|
##每种动画详情

|xml属性|java方法|效果|
|----|----|----|
||Alpha属性详解||
|android:fromAlpha|AlphaAnimation(float fromAlpha, …)|动画开始的透明度（0.0到1.0，0.0是全透明，1.0是不透明）|
|android:toAlpha|AlphaAnimation(…, float toAlpha)|动画结束的透明度，同上|
||Rotate属性详解||
|android:fromDegrees|RotateAnimation(float fromDegrees, …)|旋转开始角度，正代表顺时针度数，负代表逆时针度数|
|android:toDegrees|RotateAnimation(…, float toDegrees, …)|旋转结束角度，正代表顺时针度数，负代表逆时针度数|
|android:pivotX|RotateAnimation(…, float pivotX, …)|缩放起点X坐标（数值、百分数、百分数p，譬如50表示以当前View左上角坐标加50px为初始点、50%表示以前View的左上角加上当前View宽高的50%做为初始点、50%p表示以当前View的左上角加上父控件宽高的50%做为初始点）|
|android:pivotY|RotateAnimation(…, float pivotY)|缩放起点Y坐标，同上规律|
||Scale属性详解||
|android:fromXScale|ScaleAnimation(float fromX, …)|初始X轴缩放比例，1.0表示无变化|
|android:toXScale|ScaleAnimation(…, float toX, …)|结束X轴缩放比例|
|android:fromYScale|ScaleAnimation(…, float fromY, …)|初始Y轴缩放比例|
|android:toYScale|ScaleAnimation(…, float toY, …)|结束Y轴缩放比例|
|android:pivotX|ScaleAnimation(…, float pivotX, …)|缩放起点X轴坐标（数值、百分数、百分数p，譬如50表示以当前View左上角坐标加50px为初始点、50%表示以当前View的左上角加上当前View宽高的50%做为初始点、50%p表示以当前View的左上角加上父控件宽高的50%做为初始点）|
|android:pivotY|ScaleAnimation(…, float pivotY)|缩放起点Y轴坐标，同上规律|
||Translate属性详解||
|android:fromXDelta|TranslateAnimation(float fromXDelta, …)|起始点X轴坐标（数值、百分数、百分数p，譬如50表示以当前View左上角坐标加50px为初始点、50%表示以当前View的左上角加上当前View宽高的50%做为初始点、50%p表示以当前View的左上角加上父控件宽高的50%做为初始点）|
|android:fromYDelta|TranslateAnimation(…, float fromYDelta, …)|起始点Y轴从标，同上规律|
|android:toXDelta|TranslateAnimation(…, float toXDelta, …)|结束点X轴坐标，同上规律|
|android:toYDelta|TranslateAnimation(…, float toYDelta)|结束点Y轴坐标，同上规律|
##案例
- 通过java实现
```
Animation mAlpha;
mAlpha = new AlphaAnimation(1.0f, 0.0f);
mAlpha.setDuration(1);
mAlpha.setFillAfter(true);
mAlpha.setRepeatMode(Animation.REVERSE);
mAlpha.setRepeatCount(1);
view.startAnimation(mAlpha);
```
- 通过java+xml实现
1.xml资源文件配置  res/anim_alpha
```
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android">
    <alpha
        android:duration="2000"
        android:fillAfter="true"
        android:fromAlpha="1.0"
        android:repeatCount="1"
        android:repeatMode="reverse"
        android:toAlpha="0.0" />
</set>
```
2.通过java
```
Animation mAlpha;
mAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
view.startAnimation(mAlpha);
```


#属性动画 Property Animation

>属性动画是，动画的执行类来设置动画操作的对象的属性、持续时间，开始和结束的属性值，时间差值等，然后系统会根据设置的参数动态的变化对象的属性。
##属性

|属性|效果|
|----|----|
|Duration动画的持续时间|默认300ms|
|TimeInterpolator|时间插值，有LinearInterpolator、AccelerateDecelerateInterpolator，定义动画的变化率。|
|Repeat count and behavior|重复次数、以及重复模式；可以定义重复多少次；重复时从头开始，还是反向。|
|Animator sets|动画集合，你可以定义一组动画，一起执行或者顺序执行。|
|Frame refresh delay|帧刷新延迟，对于你的动画，多久刷新一次帧；默认为10ms，但最终依赖系统的当前状态；基本不用管。相关的类|
|ObjectAnimator|动画的执行类，后面详细介绍|
|ValueAnimator|动画的执行类，后面详细介绍|
|AnimatorSet|用于控制一组动画的执行：线性，一起，每个动画的先后执行等。|
|AnimatorInflater|用户加载属性动画的xml文件|
|TypeEvaluator|类型估值，主要用于设置动画操作属性的值。|

##
