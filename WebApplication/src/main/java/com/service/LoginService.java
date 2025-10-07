package com.service;

import jakarta.servlet.http.HttpSession;

public interface LoginService {
	public String doProcess(String uname, String upass, HttpSession session);
}
