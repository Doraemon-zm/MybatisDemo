package com.zm.pojo;

/**
 * Created by Administrator on 2017/9/17.
 */
public class User {
    private Integer id;
    private String name;
    private String keceng;
    private String fensu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeceng() {
        return keceng;
    }

    public void setKeceng(String keceng) {
        this.keceng = keceng;
    }

    public String getFensu() {
        return fensu;
    }

    public void setFensu(String fensu) {
        this.fensu = fensu;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", keceng='" + keceng + '\'' +
                ", fensu='" + fensu + '\'' +
                '}';
    }
}
