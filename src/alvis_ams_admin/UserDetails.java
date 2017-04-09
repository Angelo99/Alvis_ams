/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alvis_ams_admin;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Nandun
 */
@Entity
@Table(name = "user_details", catalog = "ams", schema = "")
@NamedQueries({
    @NamedQuery(name = "UserDetails.findAll", query = "SELECT u FROM UserDetails u"),
    @NamedQuery(name = "UserDetails.findByUserId", query = "SELECT u FROM UserDetails u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserDetails.findByName", query = "SELECT u FROM UserDetails u WHERE u.name = :name"),
    @NamedQuery(name = "UserDetails.findByDeptId", query = "SELECT u FROM UserDetails u WHERE u.deptId = :deptId"),
    @NamedQuery(name = "UserDetails.findByAccountType", query = "SELECT u FROM UserDetails u WHERE u.accountType = :accountType"),
    @NamedQuery(name = "UserDetails.findByPicName", query = "SELECT u FROM UserDetails u WHERE u.picName = :picName"),
    @NamedQuery(name = "UserDetails.findByRoleId", query = "SELECT u FROM UserDetails u WHERE u.roleId = :roleId"),
    @NamedQuery(name = "UserDetails.findByAccessCode", query = "SELECT u FROM UserDetails u WHERE u.accessCode = :accessCode")})
public class UserDetails implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "name")
    private String name;
    @Column(name = "dept_id")
    private Integer deptId;
    @Column(name = "account_type")
    private String accountType;
    @Column(name = "pic_name")
    private String picName;
    @Column(name = "role_id")
    private Integer roleId;
    @Column(name = "access_code")
    private String accessCode;

    public UserDetails() {
    }

    public UserDetails(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        Integer oldUserId = this.userId;
        this.userId = userId;
        changeSupport.firePropertyChange("userId", oldUserId, userId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        Integer oldDeptId = this.deptId;
        this.deptId = deptId;
        changeSupport.firePropertyChange("deptId", oldDeptId, deptId);
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        String oldAccountType = this.accountType;
        this.accountType = accountType;
        changeSupport.firePropertyChange("accountType", oldAccountType, accountType);
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        String oldPicName = this.picName;
        this.picName = picName;
        changeSupport.firePropertyChange("picName", oldPicName, picName);
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        Integer oldRoleId = this.roleId;
        this.roleId = roleId;
        changeSupport.firePropertyChange("roleId", oldRoleId, roleId);
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        String oldAccessCode = this.accessCode;
        this.accessCode = accessCode;
        changeSupport.firePropertyChange("accessCode", oldAccessCode, accessCode);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserDetails)) {
            return false;
        }
        UserDetails other = (UserDetails) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "alvis_ams_admin.UserDetails[ userId=" + userId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
