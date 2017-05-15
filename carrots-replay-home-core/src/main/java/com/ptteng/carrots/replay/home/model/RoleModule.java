package com.ptteng.carrots.replay.home.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "role_module")
public class RoleModule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5947409749507903488L;	
	
		
   	 
    private Long id;
	
  	 
    private Long rid;
	
  	 
    private Long mid;
	
  	 
    private Long createBy;
	
  	 
    private Long updateBy;
	
  	 
    private Long updateAt;
	
  	 
    private Long createAt;
	
  
	
		 	
         	 	   @Id
     	   @GeneratedValue(strategy = GenerationType.AUTO)
              	@Column(name = "id")
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
		 	@Column(name = "role_id")
	public Long getRid() {
		return rid;
	}
	
	
	public void setRid(Long rid) {
		this.rid = rid;
	}
		 	@Column(name = "module_id")
	public Long getMid() {
		return mid;
	}
	
	
	public void setMid(Long mid) {
		this.mid = mid;
	}
		 	@Column(name = "create_by")
	public Long getCreateBy() {
		return createBy;
	}
	
	
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
		 	@Column(name = "update_by")
	public Long getUpdateBy() {
		return updateBy;
	}
	
	
	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}
		 	@Column(name = "update_at")
	public Long getUpdateAt() {
		return updateAt;
	}
	
	
	public void setUpdateAt(Long updateAt) {
		this.updateAt = updateAt;
	}
		 	@Column(name = "create_at")
	public Long getCreateAt() {
		return createAt;
	}
	
	
	public void setCreateAt(Long createAt) {
		this.createAt = createAt;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}

