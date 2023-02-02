package org.example.controller;

import javax.servlet.http.HttpServletRequest;

public interface ServletCommand {
    String execute(HttpServletRequest request);
}
