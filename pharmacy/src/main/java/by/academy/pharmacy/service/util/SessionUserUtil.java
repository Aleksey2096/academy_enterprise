package by.academy.pharmacy.service.util;

import by.academy.pharmacy.dto.UserDTO;
import by.academy.pharmacy.entity.SessionUser;

public final class SessionUserUtil {
    /**
     * SessionUserUtil singleton object.
     */
    private static final SessionUserUtil SESSION_USER_UTIL
            = new SessionUserUtil();

    private SessionUserUtil() {
    }

    /**
     * @return SessionUserUtil single instance.
     */
    public static SessionUserUtil getInstance() {
        return SESSION_USER_UTIL;
    }

    public SessionUser convertToSessionUser(final UserDTO userDTO) {
        SessionUser sessionUser = new SessionUser();
        sessionUser.setHealthCareCardNumber(userDTO.getHealthCareCardNumber());
        sessionUser.setLogin(userDTO.getLogin());
        sessionUser.setRole(userDTO.getRole());
        return sessionUser;
    }
}
