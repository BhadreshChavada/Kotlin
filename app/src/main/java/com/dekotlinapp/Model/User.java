
package com.dekotlinapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {

    @SerializedName("createdDate")
    @Expose
    private String createdDate;
    @SerializedName("createdBy")
    @Expose
    private String createdBy;
    @SerializedName("updatedDate")
    @Expose
    private String updatedDate;
    @SerializedName("updatedBy")
    @Expose
    private String updatedBy;
    @SerializedName("tanentID")
    @Expose
    private Integer tanentID;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("blocked")
    @Expose
    private Object blocked;
    @SerializedName("group")
    @Expose
    private Object group;
    @SerializedName("roles")
    @Expose
    private List<Object> roles = null;
    @SerializedName("permissions")
    @Expose
    private Object permissions;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("newPassword")
    @Expose
    private Object newPassword;
    @SerializedName("enabled")
    @Expose
    private Integer enabled;
    @SerializedName("fullName")
    @Expose
    private Object fullName;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("middleName")
    @Expose
    private String middleName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("address")
    @Expose
    private Object address;
    @SerializedName("contactNo")
    @Expose
    private String contactNo;
    @SerializedName("emailId")
    @Expose
    private String emailId;
    @SerializedName("userImage")
    @Expose
    private Object userImage;
    @SerializedName("roleID")
    @Expose
    private Integer roleID;
    @SerializedName("countryId")
    @Expose
    private Integer countryId;
    @SerializedName("stateId")
    @Expose
    private Integer stateId;
    @SerializedName("cityId")
    @Expose
    private Integer cityId;
    @SerializedName("gender")
    @Expose
    private Object gender;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("tokenId")
    @Expose
    private Object tokenId;
    @SerializedName("tenantPackageID")
    @Expose
    private Object tenantPackageID;
    @SerializedName("defaultFlag")
    @Expose
    private Boolean defaultFlag;
    @SerializedName("mobileToken")
    @Expose
    private Object mobileToken;
    @SerializedName("country")
    @Expose
    private Object country;
    @SerializedName("state")
    @Expose
    private Object state;
    @SerializedName("city")
    @Expose
    private Object city;
    @SerializedName("userRole")
    @Expose
    private Object userRole;
    @SerializedName("tenant")
    @Expose
    private Object tenant;
    @SerializedName("new")
    @Expose
    private Boolean _new;

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getTanentID() {
        return tanentID;
    }

    public void setTanentID(Integer tanentID) {
        this.tanentID = tanentID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getBlocked() {
        return blocked;
    }

    public void setBlocked(Object blocked) {
        this.blocked = blocked;
    }

    public Object getGroup() {
        return group;
    }

    public void setGroup(Object group) {
        this.group = group;
    }

    public List<Object> getRoles() {
        return roles;
    }

    public void setRoles(List<Object> roles) {
        this.roles = roles;
    }

    public Object getPermissions() {
        return permissions;
    }

    public void setPermissions(Object permissions) {
        this.permissions = permissions;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Object getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(Object newPassword) {
        this.newPassword = newPassword;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Object getFullName() {
        return fullName;
    }

    public void setFullName(Object fullName) {
        this.fullName = fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Object getUserImage() {
        return userImage;
    }

    public void setUserImage(Object userImage) {
        this.userImage = userImage;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Object getGender() {
        return gender;
    }

    public void setGender(Object gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Object getTokenId() {
        return tokenId;
    }

    public void setTokenId(Object tokenId) {
        this.tokenId = tokenId;
    }

    public Object getTenantPackageID() {
        return tenantPackageID;
    }

    public void setTenantPackageID(Object tenantPackageID) {
        this.tenantPackageID = tenantPackageID;
    }

    public Boolean getDefaultFlag() {
        return defaultFlag;
    }

    public void setDefaultFlag(Boolean defaultFlag) {
        this.defaultFlag = defaultFlag;
    }

    public Object getMobileToken() {
        return mobileToken;
    }

    public void setMobileToken(Object mobileToken) {
        this.mobileToken = mobileToken;
    }

    public Object getCountry() {
        return country;
    }

    public void setCountry(Object country) {
        this.country = country;
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }

    public Object getCity() {
        return city;
    }

    public void setCity(Object city) {
        this.city = city;
    }

    public Object getUserRole() {
        return userRole;
    }

    public void setUserRole(Object userRole) {
        this.userRole = userRole;
    }

    public Object getTenant() {
        return tenant;
    }

    public void setTenant(Object tenant) {
        this.tenant = tenant;
    }

    public Boolean getNew() {
        return _new;
    }

    public void setNew(Boolean _new) {
        this._new = _new;
    }

}
