package repositories;

import models.Role;

public interface RoleDAO {
    Role getRoleById(Integer roleId);
    void changeRole(Integer roleId);

}
