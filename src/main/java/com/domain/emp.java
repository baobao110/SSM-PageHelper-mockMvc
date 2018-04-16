package com.domain;

public class emp {
    private Integer id;

    private String name;

    private String sex;

    private String email;

    private Integer deptId;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public emp(Integer id, String name, String sex, String email, Integer deptId) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.email = email;
        this.deptId = deptId;
    }
}