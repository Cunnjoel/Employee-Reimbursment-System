package services;

import models.Role;
import repositories.RoleDAO;
import repositories.RoleDAOImlp;

public class RoleServices {
    private RoleDAO roleDAO;

    public RoleServices(RoleDAO roleDAO) { this.roleDAO = roleDAO; }

    public RoleServices() { this.roleDAO = new RoleDAOImlp(); }

    public Role getAllRoleGivenId(Integer roleId){
        return this.roleDAO.getRoleById(roleId);
    }
}
