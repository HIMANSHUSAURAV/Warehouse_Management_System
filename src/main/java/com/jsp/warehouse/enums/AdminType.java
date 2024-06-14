package com.jsp.warehouse.enums;

import java.util.List;

public enum AdminType {

	SUPER_ADMIN(List.of( Privilege.READ,Privilege.UPDATE_ADMIN,Privilege.CREATE_STORAGE ,Privilege.CREATE_ADMIN,Privilege.CREATE_ADDRESS,
			Privilege.UPDATE_STORAGE, Privilege.UPDATE_ADDRESS, Privilege.DELETE_ADDRESS,Privilege.DELETE_ADMIN,Privilege.UPDATE_ADMIN,
			Privilege.DELETE_STORAGE,Privilege.DELETE_WAREHOUSE,Privilege.CREATE_WAREHOUSE,Privilege.UPDATE_WAREHOUSE)),

	ADMIN(List.of(Privilege.CREATE_STORAGE,
			Privilege.UPDATE_ADMIN,Privilege.UPDATE_ADDRESS,Privilege.DELETE_ADDRESS ,Privilege.UPDATE_STORAGE,Privilege.DELETE_STORAGE));


	private List<Privilege> privileges;

	AdminType(List<Privilege> privileges){
		this.privileges= privileges;
	}


	public List<Privilege> getPrivileges(){
		return this.privileges;
	}
}








