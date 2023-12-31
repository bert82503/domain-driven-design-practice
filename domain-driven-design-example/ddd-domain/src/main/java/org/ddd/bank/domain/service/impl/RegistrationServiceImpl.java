package org.ddd.bank.domain.service.impl;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import org.ddd.bank.domain.entity.User;
import org.ddd.bank.domain.entity.SalesRep;
import org.ddd.bank.domain.service.RegistrationService;
import org.ddd.bank.domain.value.Address;
import org.ddd.bank.domain.value.Name;
import org.ddd.bank.domain.value.PhoneNumber;
import org.ddd.bank.repository.SalesRepRepository;
import org.ddd.bank.repository.UserRepository;

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
