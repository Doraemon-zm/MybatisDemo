package com.zm.model;

public class Exam {
    private Integer id;

    private String name;

    private String keceng;

    private Integer fensu;

    public Exam(Integer id, String name, String keceng, Integer fensu) {
        this.id = id;
        this.name = name;
        this.keceng = keceng;
        this.fensu = fensu;
    }

    public Exam() {
        super();
    }

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
        this.name = name == null ? null : name.trim();
    }

    public String getKeceng() {
        return keceng;
    }

    public void setKeceng(String keceng) {
        this.keceng = keceng == null ? null : keceng.trim();
    }

    public Integer getFensu() {
        return fensu;
    }

    public void setFensu(Integer fensu) {
        this.fensu = fensu;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", keceng='" + keceng + '\'' +
                ", fensu=" + fensu +
                '}';
    }
}