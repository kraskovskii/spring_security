package dao.roles;

import model.Role;

import java.util.List;
import java.util.Set;

public interface RoleDao {
    public List<Role> getAllRoles();

    public void addRole(Role role);

    public void updateRole(Role role);

    public Role getRoleById(long id);

    public void deleteRole(Role role);

    public void deleteRoleById(long id);

    public Role getRoleByName(String name);

}
