package cn.tedu.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

/**
 * 选项菜单和上下文菜单的测试类
 */
public class SecondActivity extends AppCompatActivity {

    private Button btn_4;
    private Button btn_5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btn_4=findViewById(R.id.btn_4);
        btn_4.setOnCreateContextMenuListener(this);  //设置长按显示上下文菜单

        btn_5=findViewById(R.id.btn_5);

        //点击按钮显示弹出式菜单
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 新建一个弹出式菜单
                 * 第一个参数是当前的activity
                 * 第二个参数是当前触发的view
                 */
                PopupMenu menu=new PopupMenu(SecondActivity.this,btn_5);

                //加载选项，这里定义文件在//res/second.xml中
                menu.getMenuInflater().inflate(R.menu.second,menu.getMenu());

                //创建监听选中的事件，只要选项被选中了就能监听到
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.exit:
                                Toast.makeText(SecondActivity.this,"退出",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.account:
                                Toast.makeText(SecondActivity.this,"账号",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.set:
                                Toast.makeText(SecondActivity.this,"设置",Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return true;
                    }
                });
                menu.show();  //显示弹出菜单
            }
        });
    }

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


}
