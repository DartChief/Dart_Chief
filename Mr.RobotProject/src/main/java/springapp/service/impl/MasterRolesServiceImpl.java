//package springapp.service.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import springapp.model.MasterRoles;
//import springapp.repository.MasterRolesRepository;
//import springapp.service.MasterRolesService;
//
//import java.util.Set;
//
//@Service
//public class MasterRolesServiceImpl implements MasterRolesService{
//
//    @Autowired
//    MasterRolesRepository masterRolesRepository;
//
//    @Override
//    public String getMasterRolesName(String username) {
//        return masterRolesRepository.getMasterRolesName(username);
//    }
//
//    @Override
//    public Set<MasterRoles> getMasterRolesByNumber(String number) {
//        return masterRolesRepository.getMasterRolesByNumber(number);
//    }
//}
