package prog3060.g5.bean;

import java.util.ArrayList;

import prog3060.g5.model.AreaDetail;

public class AreaListBean {
	ArrayList<AreaDetail> areaList = new ArrayList<AreaDetail>();
	
	public void setAreaList(ArrayList<AreaDetail> list) {
		this.areaList = list;
	}
	
	public ArrayList<AreaDetail> getAreaList() {
		return areaList;
	}
}
