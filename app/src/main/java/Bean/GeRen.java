package Bean;

/**
 * Created by Administrator on 2017/12/11 0011.
 */

public class GeRen {
    private int logoimageId;
    private int goImageid;
    private String name;

    public GeRen(int logoimageId, String name,int goImageid) {
        this.logoimageId = logoimageId;
        this.goImageid = goImageid;
        this.name = name;
    }

    public int getLogoimageId() {
        return logoimageId;
    }

    public void setLogoimageId(int logoimageId) {
        this.logoimageId = logoimageId;
    }

    public int getGoImageid() {
        return goImageid;
    }

    public void setGoImageid(int goImageid) {
        this.goImageid = goImageid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GeRen{" +
                "logoimageId=" + logoimageId +
                ", goImageid=" + goImageid +
                ", name='" + name + '\'' +
                '}';
    }
}
