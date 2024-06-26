package org.park.public_gs.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.park.public_gs.service.UserInfoService;
import org.park.public_gs.vo.UserInfoVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserInfoController {

  private final UserInfoService userInfoService;

  @GetMapping("/user/userInfoList")
  public String getUserInfoList(Model model) {
    List<UserInfoVo> userInfoList = userInfoService.getUserInfoList();
    model.addAttribute("list", userInfoList);
    return "/user/userInfoList";
  }

  @GetMapping("/user/userInfo")
  public String getUserInfo(Model model) {
    return "/user/userInfo";
  }

  @PostMapping("user/userInfoInsert")
  public String getUserInfoInsert(UserInfoVo userInfoVo) {
    userInfoService.userInfoInsert(userInfoVo);
    return "redirect:userInfoList";
  }

  @GetMapping("/user/userInfoView")
  public String userInfoView(Model model, Integer seq) {
    model.addAttribute("view", userInfoService.userInfoSelect(seq));
    return "/user/userInfoView";
  }

  @GetMapping("/login")
  public String homeLogin(Model model) {
    return "/login";
  }

  @GetMapping("/main")
  public String homemain(Model model) {
    return "/main";
  }

  @PostMapping("/loginAction")
  public String userLogin(String userId, String userPw, HttpSession session) {

    log.debug("userInfo = {}", userId, userPw); // aop 설정 추천
    UserInfoVo loginResult = userInfoService.userLogin(userId);
    log.debug("loginResult = {}", loginResult); // aop 설정 추천
    if (loginResult.getUserId().equals(userId)) {
      //login 성공
      session.setAttribute("loginId", loginResult.getUserId());
      session.setAttribute("loginNm", loginResult.getUserNm());
      session.setAttribute("loginSpace", loginResult.getSpaceNo());
      session.setAttribute("loginGrade", loginResult.getGrade());
      return "redirect:/code/codeManage";
    } else {
      //실패
      return "/login";
    }
  }

}
