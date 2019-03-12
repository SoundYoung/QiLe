package sun.qile;

import java.util.ArrayList;

/**
 * Created by soundyoung on 2018/7/3.
 *
 */
public class NodeBean {

    private String  id;

    private String prantid;

    private String name;

    private int lvl;



    public NodeBean(String id, int lvl, String name, String prantid) {
        this.id = id;
        this.lvl = lvl;
        this.name = name;
        this.prantid = prantid;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrantid() {
        return prantid;
    }

    public void setPrantid(String prantid) {
        this.prantid = prantid;
    }
}
