package hibernate.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;

@Entity @FilterDef(name="tenantFilter", parameters=@ParamDef(name="tenantId", type="string")) @Filters(@Filter(name="tenantFilter", condition="tenant_id=:tenantId")) 
public class Product { 
	
	@Id private long id;
	
	@Column(name="tenant_id", nullable=false, updatable=false) 
	private String tenantId; @Column(name="prod_name", nullable=false) 
	private String prodName; public long getId() { return id; }
	public void setId(long id) { this.id = id; }
	public String getTenantId() { return tenantId; } 
	public void setTenantId(String tenantId) { this.tenantId = tenantId; } 
	public String getProdName() { return prodName; } 
	public void setProdName(String prodName) { this.prodName = prodName; } } 