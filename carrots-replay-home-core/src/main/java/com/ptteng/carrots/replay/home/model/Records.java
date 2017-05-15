package com.ptteng.carrots.replay.home.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "records")
public class Records implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4280548437687492608L;

	/**
	 * 操作类型-创建
	 * 
	 */
	public static final String Operate_Create = "create";

	/**
	 * 操作类型-更新
	 * 
	 */
	public static final String Operate_Update = "update";

	/**
	 * 操作类型-创建
	 * 
	 */
	public static final String Operate_Delete = "delete";

	private Long id;

	private Long managerID;

	private Long moduleID;
	private Long targetID;
	
	private String targetName;
	

	private Long roleID;

	private String operate;

	private Long operateAt;

	private Long createAt;

	private Long updateAt;

	public Records(Long managerID, Long moduleID, Long roleID, String operate,
                   Long operateAt) {
		
		this.managerID=managerID;
		this.moduleID=moduleID;
		this.roleID=roleID;
		this.operate=operate;
		this.operateAt=operateAt;
	}
	
	public Records(Long targetID, String targetName) {
		
		this.targetID=targetID;
		this.targetName=targetName;
	
	}
	
	
	

	public Records() {
		super();
		// TODO Auto-generated constructor stub
	}




	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "manager_id")
	public Long getManagerID() {
		return managerID;
	}

	public void setManagerID(Long managerID) {
		this.managerID = managerID;
	}

	@Column(name = "module_id")
	public Long getModuleID() {
		return moduleID;
	}

	public void setModuleID(Long moduleID) {
		this.moduleID = moduleID;
	}

	@Column(name = "role_id")
	public Long getRoleID() {
		return roleID;
	}

	public void setRoleID(Long roleID) {
		this.roleID = roleID;
	}

	@Column(name = "operate")
	public String getOperate() {
		return operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}
	
	
	
	
	
	@Column(name = "target_id")
	public Long getTargetID() {
		return targetID;
	}




	public void setTargetID(Long targetID) {
		this.targetID = targetID;
	}



	@Column(name = "target_name")
	public String getTargetName() {
		return targetName;
	}




	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}




	@Column(name = "operate_at")
	public Long getOperateAt() {
		return operateAt;
	}

	public void setOperateAt(Long operateAt) {
		this.operateAt = operateAt;
	}

	@Column(name = "create_at")
	public Long getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Long createAt) {
		this.createAt = createAt;
	}

	@Column(name = "update_at")
	public Long getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Long updateAt) {
		this.updateAt = updateAt;
	}
	
	
	
	
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}
