package com.cuking.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by cuking on 2017/2/7.
 */

@Entity
@Table(name = "s_role")
public class SysRole {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
    private List<Permissions> permissionses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Permissions> getPermissionses() {
        return permissionses;
    }

    public void setPermissionses(List<Permissions> permissionses) {
        this.permissionses = permissionses;
    }
}
