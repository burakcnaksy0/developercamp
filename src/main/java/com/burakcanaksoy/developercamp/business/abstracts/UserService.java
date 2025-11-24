package com.burakcanaksoy.developercamp.business.abstracts;

import com.burakcanaksoy.developercamp.core.utilities.results.DataResult;
import com.burakcanaksoy.developercamp.core.utilities.results.Result;
import com.burakcanaksoy.developercamp.entities.concretes.User;

public interface UserService {
    Result add(User user);
    DataResult<User> findByEmail(String email);
}