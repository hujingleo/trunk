package com.ptteng.carrots.replay.home.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Entity
@Table(name = "role")
public class Role implements Serializable {

	/**
	 *角色表
	 */
	private static final long serialVersionUID = 8109355439663838208L;

	/**
	 * 启用
	 *
	 */
	public static final String STATUS_USING = "using";

	/**
	 * 停用
	 *
	 */
	public static final String STATUS_STOPPED = "stopped";

	private Long id;

	private String name;

	private Map<Long,List<String>> permissionsSet=new HashMap<Long,List<String>>();


	private String permissions;

	private String status;

	private Long updateAt;

	private Long updateBy;

	private Long createAt;

	private Long createBy;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "permissions")
	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {

		this.permissions = permissions;

		
	}


	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "update_at")
	public Long getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Long updateAt) {
		this.updateAt = updateAt;
	}

	@Column(name = "update_by")
	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	@Column(name = "create_at")
	public Long getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Long createAt) {
		this.createAt = createAt;
	}

	@Column(name = "create_by")
	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	@Transient
	public Map<Long,List<String>> getPermissionsSet() {
		return this.permissionsSet;
	}




	public void setPermissionsSet(Map<Long,List<String>> permissionsSet) {

		this.permissionsSet = permissionsSet;
		Gson gson = new GsonBuilder().create();
		this.permissions = gson.toJson(permissionsSet);
	}
	
	
	
	
	
	


	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public static void main(String[] args) {

		Role r = new Role();
		Map<Long,List<String>> permissions=new HashMap<Long,List<String>>();
		permissions.put(3L, Arrays.asList(new String[]{"create","update","delete"}));
		
		r.setPermissionsSet(permissions);
		System.out.println(r);
		r.setPermissions("{3:[\"create\",\"update\",\"delete\"]}");
		System.out.println(r);
		
		
		System.out.println(permissions.keySet());

	}

}

