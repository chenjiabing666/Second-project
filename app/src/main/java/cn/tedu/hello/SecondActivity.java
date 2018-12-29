package cn.tedu.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * 选项菜单和上下文菜单的测试类
 */
public class SecondActivity extends AppCompatActivity {

    private Button btn_4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btn_4=findViewById(R.id.btn_4);

        btn_4.setOnCreateContextMenuListener(this);  //设置长按显示上下文菜单

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
