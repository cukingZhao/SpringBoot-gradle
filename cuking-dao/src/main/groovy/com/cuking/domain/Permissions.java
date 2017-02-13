package com.cuking.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by cuking on 2017/2/9.
 */
@Entity
@Table(name = "s_permissions")
public class Permissions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int deep;

    public int getDeep() {
        return deep;
    }

    public void setDeep(int deep) {
        this.deep = deep;
    }

    //url
    private String url;

    //描述
    private String des;

    //父节点
    @JoinColumn(name="parentId")//关联user表的字段
    @ManyToOne(cascade={CascadeType.REFRESH},optional = true)
    private Permissions parent;


    @OneToMany(cascade={CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.EAGER,mappedBy="parent")
    private List<Permissions> children;

    public List<Permissions> getChildren() {
        return children;
    }

    public void setChildren(List<Permissions> children) {
        this.children = children;
    }

    //日期
    private Date createDate;
    private Date updateDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Permissions getParent() {
        return parent;
    }

    public void setParent(Permissions parent) {
        this.parent = parent;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
