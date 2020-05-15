package com.alumni.beans;

public class MemhobbiesBEAN {

	private int hid;
	private String hobbieesname;
	private int memberhobbieid;
	private int mem_Id;
	
	public int getMem_Id() {
		return mem_Id;
	}
	public void setMem_Id(int mem_Id) {
		this.mem_Id = mem_Id;
	}
	public int getHid() {
		return hid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hid;
		result = prime * result
				+ ((hobbieesname == null) ? 0 : hobbieesname.hashCode());
		result = prime * result + mem_Id;
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
		MemhobbiesBEAN other = (MemhobbiesBEAN) obj;
		if (hid != other.hid)
			return false;
		if (hobbieesname == null) {
			if (other.hobbieesname != null)
				return false;
		} else if (!hobbieesname.equals(other.hobbieesname))
			return false;
        return mem_Id == other.mem_Id;
    }
	
	public void setHid(int hid) {
		this.hid = hid;
	}
	public String getHobbieesname() {
		return hobbieesname;
	}
	public void setHobbieesname(String hobbieesname) {
		this.hobbieesname = hobbieesname;
	}
	public int getMemberhobbieid() {
		return memberhobbieid;
	}
	public void setMemberhobbieid(int memberhobbieid) {
		this.memberhobbieid = memberhobbieid;
	}
	

	
	
	
	
	
}
