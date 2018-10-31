# SyncHorizontalScrollView
横竖联动的ScrollView

## 先上传张效果图

![image](https://github.com/chensong1993/SyncHorizontalScrollView/blob/master/newsAd.gif)

## 主要实现功能
 竖列第一列和内容列可以上下联动 横列标题和内容可以左右联动

## 使用步骤
## Gradle
add Maven
``` groovy
 allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
 ```
add implementation
``` groovy
dependencies {
    implementation 'com.github.chensong1993:SyncHorizontalScrollView:v1.0.0'
}
```

接下来在布局中使用

# 想使哪个布局联动就给它包裹SyncHorizontalScrollView
``` groovy
<com.shanghai.flexiblelibrary.SyncHorizontalScrollView
      android:id="@+id/content_horsv"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:fillViewport="true"
                android:scrollbars="none">

                <android.support.v7.widget.RecyclerView
                    android:id="@+id/right_container_listview"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_marginRight="15dp"
                    android:background="#ffffff"
                    android:scrollbars="none" />

            </com.shanghai.flexiblelibrary.SyncHorizontalScrollView>
```
## 如图有两个部分 头部和内容 那么就需要给头部和内容各嵌套一个SyncHorizontalScrollView

布局很简单就这样
接下来看看代码
## 主要看看这个方法
``` groovy
  	//把刚刚嵌套的联动控件初始化
  	//横竖联动头容器
	SyncHorizontalScrollView mTitleHorScv;
 	//横竖联动内容容器
	SyncHorizontalScrollView mContentHorScv;

	// 设置标题和内容水平控件的联动
	//将两个控件交叉引用，这样就实现了联动的效果
        mTitleHorScv.setScrollView(mContentHorScv);
        mContentHorScv.setScrollView(mTitleHorScv);
```
 只需要简单得一步就能实现标题和内容的纵向联动
 如果要实现三个控件扩者更多的联动只需要添加上面代码再将初始化的控件交叉引用即可
