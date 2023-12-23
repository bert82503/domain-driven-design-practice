package org.ddd.domain.service.impl;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import org.ddd.domain.entity.SalesRep;
import org.ddd.domain.entity.User;
import org.ddd.domain.service.RegistrationService;
import org.ddd.domain.value.object.Address;
import org.ddd.domain.value.object.Name;
import org.ddd.domain.value.object.PhoneNumber;
import org.ddd.repository.SalesRepRepository;
import org.ddd.repository.UserRepository;

/**
 * 用户注册领域服务实现
 *
 * @author guang.yi
 * @since 2023/12/23
 */
@Service("registrationService")
public class RegistrationServiceImpl implements RegistrationService {

    private final SalesRepRepository salesRepRepo;
    private final UserRepository userRepo;

    public RegistrationServiceImpl(
            SalesRepRepository salesRepRepo,
            UserRepository userRepo
    ) {
        this.salesRepRepo = salesRepRepo;
        this.userRepo = userRepo;
    }

    @Override
    public User register(
            @NotNull Name name,
            @NotNull PhoneNumber phone,
            @NotNull Address address
    ) {
        // 找到区域内的SalesRep
        SalesRep rep = salesRepRepo.findRep(phone.getAreaCode());

        // 最后创建用户，落盘，然后返回，这部分代码实际上也能用Builder解决
        User user = new User()
                .setName(name)
                .setPhone(phone)
                .setAddress(address);
        if (rep != null) {
            user.setRepId(rep.getRepId());
        }

        return userRepo.saveUser(user);
    }

}
