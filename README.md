# 打电话和发短信

## 功能描述
- ![](imageFolder/image1.png)


## 细节
- match_parent： 会适应父容器，将父容器的页面全部覆盖,一旦是线性水平均布局的话，那么这个控件将会独占一行

- wrap_content ： 是适应控件的大小 



## 界面布局
- 最外层是一个垂直的线性布局
- 里面的每一行是一个水平的线性布局



## 显式意图和隐式意图的区别
- 显式意图是跳转到本项目中的activity，隐式意图是跳转到本项目之外的activity，比如拨号界面，发短信页面
- 显示意图需要指定activity的class


## OptionMenu(选项菜单)
- 点击menu按钮，显示选项菜单，效果如下：
- ![](imageFolder/option.png)

### 创建菜单选项

- activity需要重写`onCreateOptionsMenu`方法，在其中添加选项菜单即可，如下：

```java
/**
     * 点击菜单按钮显示选项菜单
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /**
         * 第一个参数是分组，如果没有分组，一般是NONE即是0
         * 第二个参数是ItemId，唯一标识，每个选项必须是不同的
         * 第三个参数是显示的顺序，越小的显示在上面
         * 第四个参数是显示的内容
         */
        menu.add(Menu.NONE, 1, 1, "添加");
        menu.add(Menu.NONE, 2, 2, "删除");
        return super.onCreateOptionsMenu(menu);
    }
```
### 监听选中的状态

- 选中监听，实现`onOptionsItemSelected`这个方法即可即可，其中使用ItemId判断选中了那个item，如下：
```java
/**
     * 选项菜单被选中的监听
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {  //使用itemId判断到底选中了按钮
            case 1:
                Toast.makeText(this, "选择了添加", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "选择了删除", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
```


## ContextMenu（上下文菜单）
- 长按按钮，显示上下文菜单，显示的效果如下：
- ![](imageFolder/context.png)

### 创建选项
- 需要有一个按钮，并且为这个按钮设置一个监听的方法`setOnCreateContextMenuListener(OnCreateContextMenuListener l)`,这个方法需要在activity重写即可，重写的方法如下：
```java
    /**
         * 创建上下文菜单，通过长按视图触发，因此需要在view设置监听
         * @param menu
         * @param v
         * @param menuInfo
         */
        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            super.onCreateContextMenu(menu, v, menuInfo);
            menu.add(Menu.NONE,1,1,"添加");  //添加一个上下文选项
            MenuItem item = menu.add(Menu.NONE, 2, 2, "删除");
        }
```

### 监听选中的状态
- 在activity中重写`onContextItemSelected`这个方法监听，如下：
```java
    /**
         * 上下文菜单的选中监听
         * @param item
         * @return
         */
        @Override
        public boolean onContextItemSelected(MenuItem item) {
            switch (item.getItemId()){
                case 1:
                    Toast.makeText(this, "选择了添加", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(this, "选择了删除", Toast.LENGTH_SHORT).show();
                    break;
            }
            return super.onContextItemSelected(item);
        }
```













