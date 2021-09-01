package service.roles;

import dao.roles.RoleDao;
import model.Role;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public Role getRoleByName(String name){
        return roleDao.getRoleByName(name);
    }


}

