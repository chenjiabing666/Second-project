package cn.tedu.hello;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }

    /**
     * 显示一般的对话框
     * @param v
     */
    public void showAD(View v){
        new AlertDialog.Builder(this)
                .setTitle("数据删除")  //设置标题
                .setMessage("确定删除吗?")   //设置提示信息
                .setPositiveButton("删除", new DialogInterface.OnClickListener() {  //设置正向的选项
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.out.println("点击了删除");
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {  //设置反向的选项
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.out.println("点击了取消");
                    }
                })
                .show();

    }


    /**
     * 显示单选对话框
     * @param v
     */
    public void showSignal(View v){
        final String[] color={"红","黄","蓝"};  //需要定义为final类型的选项
        new AlertDialog.Builder(this)
                .setTitle("指定背景颜色")  //设置标题
                /**
                 * 设置选项和监听
                 * 第一个参数是选项，一个String类型的数组
                 * 第二参数是默认选中的第几个，即是数组的下标
                 * 第三个参数是监听选中的方法
                 *
                 */
                .setSingleChoiceItems(color, 1, new DialogInterface.OnClickListener() {
                    /**
                     * 监听选中的方法
                     * @param dialog  对象
                     * @param which  选中的那个元素的在数组中的下标
                     */
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //提示显示的颜色
                        Toast.makeText(DialogActivity.this,color[which],Toast.LENGTH_SHORT).show();
                        //移除
                        dialog.dismiss();
                    }
                })
                .show();  //显示
    }


    /**
     * 显示自定义布局的对话框
     * @param v
     */
    public void showCustom(View v){
        /**
         * 创建一个View
         * 第一个参数指定当前的activity
         * 第二个参数指定View的xml文件
         * 第三个参数指定的是插入到当前activity的xml文件中的节点id，不插入直接传入null即可
         */
        View view=View.inflate(this,R.layout.dialog_view,null);  //动态加载view，这个view自定义的，没有对应的activity

        /**
         * 1、单独执行findViewById这个方法是在当前activity中对应的xml中寻找节点
         * 2、这里我们需要寻找动态加载的view中的节点，那么我们需要调用对应的view的findViewById的方法，如下
         */
        final  EditText userNameText=view.findViewById(R.id.userName);
        final  EditText pwdText=view.findViewById(R.id.pwd);
        new AlertDialog.Builder(this)
                .setTitle("指定背景颜色")  //设置标题
                .setView(view)            //设置其中的View，比如是ImageView
                .setNegativeButton("取消",null)  //反向的选择，不用监听，传入null即可
                .setPositiveButton("登录", new DialogInterface.OnClickListener() {   //登录的选项，正向的选择，需要监听读取数据判断登录
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //读取用户名和密码
                        String userName=userNameText.getText().toString();  //用户名
                        String pwd=pwdText.getText().toString();       //密码
                        if (!userName.equals("admin")||!pwd.equals("123456")){
                            Toast.makeText(DialogActivity.this,"用户名或者密码不正确",Toast.LENGTH_SHORT).show();
                        }else{
//                            dialog.dismiss();  //移除
                            Toast.makeText(DialogActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                        }
                    }
                })
        .show();
    }



}
