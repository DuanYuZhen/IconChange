# IconChange

动态更换应用ICON

# 限制

- 1、只能替换预埋在应用内的icon，不能替换网络图片（未尝试过）；
- 2、只能在应用退出的时候更换icon，有两个原因：1、系统刷新icon时间较长；2、系统刷新icon可能会杀死应用；
- 3、icon切换为activity-alias标签中指定的图片后，AndroidStudio不能运行安装。需要切回activity标签中指定的图片，才可以运行安装；
- 4、AndroidManifest.xml文件中添加过activity-alias标签之后，下一版本不能删除，否则会导致应用升级失败，提示应用未安装。
- 5、设置enabled为false的activity，不能显示跳转，可通过以下方式跳转：

```java
public static void openMain(Context context) {
    if (context == null) {
        return;
    }
    Intent intent = new Intent();
    ComponentName cn = new ComponentName(
            context, context.getPackageName() + ".MainActivity");
    intent.setComponent(cn);
    context.startActivity(intent);
}
```

# 参考文章

- [Android动态修改应用图标和名称](https://juejin.im/post/5c36f2226fb9a049b7809170)