package com.burakcanaksoy.developercamp.business.concretes;

import com.burakcanaksoy.developercamp.business.abstracts.UserService;
import com.burakcanaksoy.developercamp.core.utilities.results.DataResult;
import com.burakcanaksoy.developercamp.core.utilities.results.Result;
import com.burakcanaksoy.developercamp.core.utilities.results.SuccessDataResult;
import com.burakcanaksoy.developercamp.dataAccess.abstracts.UserDao;
import com.burakcanaksoy.developercamp.entities.concretes.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {
    private final UserDao userDao;

    @Override
    public Result add(User user) {
        return new SuccessDataResult<>(this.userDao.save(user),"User added successfully");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<>(this.userDao.findByEmail(email),"User found");
    }
}
