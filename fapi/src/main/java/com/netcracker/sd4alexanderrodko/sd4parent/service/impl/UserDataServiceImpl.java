package com.netcracker.sd4alexanderrodko.sd4parent.service.impl;

import com.netcracker.sd4alexanderrodko.sd4parent.models.AccountViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.models.RoleViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.models.StudentViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.models.UserViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service(value = "userService")
public class UserDataServiceImpl implements UserDataService {
    @Value("${backend.server.url}")
    private String backendServerUrl;
    @Value("${users.server.url}")
    private String usersServerUrl;
    @Value("${groups.server.url}")
    private String groupsServerUrl;
    @Value("${login.server.url}")
    private String loginServerUrl;


    @Autowired
    PasswordEncoder encoder;

    @Override
    public AccountViewModel saveEmployer(AccountViewModel accountViewModel) {
        if (accountViewModel.getId() == 0)
            accountViewModel.setPassword(encoder.encode(accountViewModel.getPassword()));
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + usersServerUrl, accountViewModel, AccountViewModel.class).getBody();
    }

    @Override
    public AccountViewModel saveStudent(StudentViewModel studentViewModel) {
        if (studentViewModel.getAccount().getId() == 0)
            studentViewModel.getAccount().setPassword(encoder.encode(studentViewModel.getAccount().getPassword()));
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + usersServerUrl + "/students", studentViewModel, AccountViewModel.class).getBody();
    }

    @Override
    public AccountViewModel transferStudent(Long newGroup, Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(backendServerUrl + usersServerUrl + "?new=" + newGroup +"&id=" + id, AccountViewModel.class).getBody();
    }


    @Override
    public void deleteStudent(long groupId, long studentId) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + usersServerUrl + "/students/" + groupId + "/" + studentId);
    }

    @Override
    public void deleteEmployer(long employerId) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + usersServerUrl + "/" + employerId);
    }

    @Override
    public List<AccountViewModel> getAll(Integer page, Integer size) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AccountViewModel[]> forEntity = restTemplate.getForEntity(backendServerUrl + usersServerUrl + "?page=" + page + "&size=" + size, AccountViewModel[].class);
        AccountViewModel[] accountViewModels = forEntity.getBody();
        return accountViewModels == null ? Collections.emptyList() : Arrays.asList(accountViewModels);

    }

    @Override
    public List<AccountViewModel> getAllByLastName(String lastName) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AccountViewModel[]> forEntity = restTemplate.getForEntity(backendServerUrl + usersServerUrl + "?lastName=" + lastName, AccountViewModel[].class);
        AccountViewModel[] accountViewModels = forEntity.getBody();
        return accountViewModels == null ? Collections.emptyList() : Arrays.asList(accountViewModels);
    }

    @Override
    public List<AccountViewModel> getAllByLastNameAndRole(String lastName, String roleId) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AccountViewModel[]> forEntity = restTemplate.getForEntity(backendServerUrl + usersServerUrl + "?lastName=" + lastName + "&roleId=" + roleId, AccountViewModel[].class);
        AccountViewModel[] accountViewModels = forEntity.getBody();
        return accountViewModels == null ? Collections.emptyList() : Arrays.asList(accountViewModels);
    }

    @Override
    public List<UserViewModel> getTeachersByLastName(String lastName) {
        RestTemplate restTemplate = new RestTemplate();
        UserViewModel[] teachers = restTemplate.getForObject(backendServerUrl + usersServerUrl + "/teachers?lastName=" + lastName, UserViewModel[].class);
        return teachers == null ? Collections.emptyList() : Arrays.asList(teachers);
    }

    @Override
    public List<UserViewModel> getStudentsFromGroup(long groupId) {
        RestTemplate restTemplate = new RestTemplate();
        UserViewModel[] students = restTemplate.getForObject(backendServerUrl + groupsServerUrl + "/" + groupId + "/students", UserViewModel[].class);
        return students == null ? Collections.emptyList() : Arrays.asList(students);
    }

    @Override
    public List<RoleViewModel> getRoles() {
        RestTemplate restTemplate = new RestTemplate();
        RoleViewModel[] students = restTemplate.getForObject(backendServerUrl + usersServerUrl + "/roles", RoleViewModel[].class);
        return students == null ? Collections.emptyList() : Arrays.asList(students);
    }

    @Override
    public Long count() {
        return new RestTemplate().getForEntity(backendServerUrl + usersServerUrl + "/count", Long.class).getBody();
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        RestTemplate restTemplate = new RestTemplate();
        AccountViewModel account = restTemplate.postForEntity(backendServerUrl + loginServerUrl, email, AccountViewModel.class).getBody();
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (account != null) {
            authorities.add(new SimpleGrantedAuthority(account.getRole().getName()));
            return new User(account.getEmail(), account.getPassword(), authorities);
        }
        return null;
    }
}

