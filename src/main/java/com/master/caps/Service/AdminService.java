// package com.master.caps.Service;

// import com.master.caps.Model.Admin;
// import com.master.caps.Repository.AdminRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class AdminService {

//     private final AdminRepository adminRepository;

//     @Autowired
//     public AdminService(AdminRepository adminRepository) {
//         this.adminRepository = adminRepository;
//     }

//     public List<Admin> getAllAdmins() {
//         return adminRepository.findAll();
//     }

//     public Admin getAdminById(Integer id) throws Exception {
//         return adminRepository.findById(id)
//                 .orElseThrow(() -> new Exception("Admin not found with id: " + id));
//     }

//     public Admin updateAdmin(Integer id, Admin updatedAdmin) throws Exception {
//         Admin admin = adminRepository.findById(id)
//                 .orElseThrow(() -> new Exception("Admin not found with id: " + id));

//         admin.setUsername(updatedAdmin.getUsername());
//         admin.setBirthday(updatedAdmin.getBirthday());
//         admin.setGender(updatedAdmin.getGender());
//         admin.setFirstname(updatedAdmin.getFirstname());
//         admin.setLastname(updatedAdmin.getLastname());
//         admin.setPassword(updatedAdmin.getPassword());
//         admin.setSurname(updatedAdmin.getSurname());
//         admin.setAddress(updatedAdmin.getAddress());
//         admin.setContactnumber(updatedAdmin.getContactnumber());
//         admin.setEmail(updatedAdmin.getEmail());

//         return adminRepository.save(admin);
//     }

//     public void deleteAdmin(Integer id) {
//         Admin admin = adminRepository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Admin not found with id: " + id));

//         adminRepository.delete(admin);
//     }
// }
