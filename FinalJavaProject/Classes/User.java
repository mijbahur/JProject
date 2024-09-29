package Classes;

import java.lang.*;
class User {
    private String name;
    private String userId;
    private String mblNo;
    private String password;
    private String dof;
    private String d, m, y;

    public User(String name, String userId, String mblNo, String password, String d, String m, String y) {
        this.name = name;
        this.userId = userId;
        this.mblNo = mblNo;
        this.password = password;
        this.d = d;
        this.m = m;
        this.y = y;
    }
    public User(String name, String userId, String mblNo, String dof) {
        this.name = name;
        this.userId = userId;
        this.mblNo = mblNo;
        this.y = dof;
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }
    public String getMblNo() {
        return mblNo;
    }

    public String getPassword() {
        return password;
    }

    public String getD() {
        return d;
    }
    public String getM() {
        return m;
    }
    public String getY() {
        return y;
    }
    public String getDof() {
        return dof;
    }
}