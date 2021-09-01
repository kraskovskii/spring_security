package dao.roles;

import model.Role;

import java.util.List;
import java.util.Set;

public interface RoleDao {
    public Set<Role> getAllUsers();

    public void addRole(Role role);

    public void updateUser(Role role);

    public Role getRoleById(long id);

    public void deleteRole(Role role);

    public void deleteRoleById(long id);

    Role getRoleByName(String name);
}
