package com.jt.manage.pojo;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jt.common.po.BasePojo;
@Table(name="tb_item_cat") //只使用table注解,与表格对应时,默认对应于类名相同的驼峰映射结果的表名
//ItemCat-->itemCat表格
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemCat extends BasePojo{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	//@Column(name="parent_id")
	private Long parentId;
	private String name;
	private Integer status;
	private Integer sortOrder;
	private Boolean isParent;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	public Boolean getIsParent() {
		return isParent;
	}
	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}
	
	//text
	public String getText() {
		return name;
	}
	//state
	public String getState() {
		return isParent? "closed":"open";
	}
	
}
