package com.jsp.warehouse.enums;

import java.util.List;

public enum AdminType {

	SUPER_ADMIN(List.of(Privilege.CREATE_ADMIN,
			Privilege.CREATE_WAREHOUSE)),

	Admin(List.of(Privilege.CREATE_STORAGE,
			Privilege.UPDATE_ADMIN));


	private List<Privilege> privileges;

    AdminType(List<Privilege> privileges){
		this.privileges= privileges;
	}


    public List<Privilege> getPrivileges(){
		return this.privileges;
	}
}








