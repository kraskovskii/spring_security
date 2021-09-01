package dao.roles;

import model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Set;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Set<Role> getAllUsers() {
        return null;
    }

    @Override
    public void addRole(Role role) {

    }

    @Override
    public void updateUser(Role role) {

    }

    @Override
    public Role getRoleById(long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public void deleteRole(Role role) {

    }

    @Override
    public void deleteRoleById(long id) {

    }

    @Override
    public Role getRoleByName(String name) {
        return entityManager.createQuery("From Role u where u.name =: name", Role.class)
                .setParameter("name", name)
                .getSingleResult();

    }
}
