package com.cr.entity;

public class Area {
   private String code;
   private String name;
   private int layer;
public Area() {
	super();
	// TODO Auto-generated constructor stub
}
public Area(String code, String name, int layer) {
	super();
	this.code = code;
	this.name = name;
	this.layer = layer;
}
@Override
public String toString() {
	return "Area [code=" + code + ", name=" + name + ", layer=" + layer + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((code == null) ? 0 : code.hashCode());
	result = prime * result + layer;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Area other = (Area) obj;
	if (code == null) {
		if (other.code != null)
			return false;
	} else if (!code.equals(other.code))
		return false;
	if (layer != other.layer)
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	return true;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getLayer() {
	return layer;
}
public void setLayer(int layer) {
	this.layer = layer;
}
   
}
