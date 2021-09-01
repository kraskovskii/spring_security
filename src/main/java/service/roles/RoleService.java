package service.roles;

import dao.roles.RoleDao;
import model.Role;

public interface RoleService {

    public Role getRoleByName(String name);

}
