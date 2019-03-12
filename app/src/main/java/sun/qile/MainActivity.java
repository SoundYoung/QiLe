package sun.qile;

import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    LinearLayout content;

    ArrayList<NodeBean> jsonlist = new ArrayList<>();
    HashMap<String ,ArrayList<NodeBean>> lvlOneChild = new HashMap<>();
    HashMap<String ,ArrayList<NodeBean>> lvlTwoChild = new HashMap<>();

    ArrayList<NodeBean> lvlonelist = new ArrayList<>();
    ArrayList<NodeBean> lvltwolist = new ArrayList<>();
    ArrayList<NodeBean> lvlthreelist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        content = ((LinearLayout) findViewById(R.id.content));


        jsonlist.add(new NodeBean("1",0,"一级节点1",""));
        jsonlist.add(new NodeBean("2",0,"一级节点2",""));


        jsonlist.add(new NodeBean("11",1,"二级节点1","1"));
        jsonlist.add(new NodeBean("22",1,"二级节点2","2"));

        jsonlist.add(new NodeBean("111",2,"三级节点1","11"));
        jsonlist.add(new NodeBean("222",2,"三级节点2","22"));


        for (NodeBean nodeBean:jsonlist) {
            switch (nodeBean.getLvl()) {
                case 0:
                    //表示一级
                    lvlonelist.add(nodeBean);

                    break;

                case 1:

                    lvltwolist.add(nodeBean);

                    break;

                case 2:

                    lvlthreelist.add(nodeBean);

                    break;
            }
        }


        for (NodeBean node:lvlonelist) {
            //第一层for循环添加第一层节点
            View view = LayoutInflater.from(this).inflate(R.layout.item_two_lvl,null);
            TextView name = ((TextView) view.findViewById(R.id.lvname));
            name.setText(node.getName());

            LinearLayout childone = ((LinearLayout) view.findViewById(R.id.content));
            for(NodeBean nodetwo:lvltwolist) {

                View viewchildone = LayoutInflater.from(this).inflate(R.layout.item_two_lvl,null);
                if(nodetwo.getPrantid().equals(node.getId())) {
                    childone.addView(viewchildone);
                }
            }

            content.addView(view);
        }





    }
}
