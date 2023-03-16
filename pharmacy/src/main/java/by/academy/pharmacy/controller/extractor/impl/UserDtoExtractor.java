package by.academy.pharmacy.controller.extractor.impl;

import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.dto.UserDTO;
import by.academy.pharmacy.service.util.PasswordUtil;
import by.academy.pharmacy.service.util.RequestDataUtil;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.DATE_JOINED_DB;
import static by.academy.pharmacy.entity.Constant.EMPTY_PATH;
import static by.academy.pharmacy.entity.Constant.HEALTH_CARE_CARD_NUMBER_DB;
import static by.academy.pharmacy.entity.Constant.IMAGE;
import static by.academy.pharmacy.entity.Constant.IMG_USER;
import static by.academy.pharmacy.entity.Constant.JPG;
import static by.academy.pharmacy.entity.Constant.LOGIN;
import static by.academy.pharmacy.entity.Constant.PASSWORD;
import static by.academy.pharmacy.entity.Constant.ROLE;

public class UserDtoExtractor implements Extractor<UserDTO> {
    private final RequestDataUtil requestDataUtil
            = RequestDataUtil.getInstance();

    @Override
    public UserDTO extract(final HttpServletRequest request) {
        UserDTO userDTO = new UserDTO();
        userDTO.setHealthCareCardNumber(
                requestDataUtil.getLong(HEALTH_CARE_CARD_NUMBER_DB, request));
        userDTO.setLogin(requestDataUtil.getString(LOGIN, request));
        userDTO.setPassword(PasswordUtil
                .generateStrongPasswordHash(
                        requestDataUtil.getString(PASSWORD, request)));
        userDTO.setRole(requestDataUtil.getRole(ROLE, request));
        userDTO.setJoinedDate(requestDataUtil.getDate(DATE_JOINED_DB, request));
        String avatarImagePath = IMG_USER + userDTO.getHealthCareCardNumber()
                + JPG;
        userDTO.setAvatarImagePath(avatarImagePath);
        requestDataUtil.saveFile(
                request.getServletContext().getRealPath(EMPTY_PATH)
                        + avatarImagePath,
                request, IMAGE);
        return userDTO;
    }
}
