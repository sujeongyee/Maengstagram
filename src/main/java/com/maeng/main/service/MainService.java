package com.maeng.main.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maeng.main.model.MainVO;



public interface MainService {
	List<MainVO> getList(HttpServletRequest request , HttpServletResponse response);

}
