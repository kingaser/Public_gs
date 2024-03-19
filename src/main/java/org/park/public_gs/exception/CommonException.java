package org.park.public_gs.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class CommonException {

  @ExceptionHandler(Exception.class)
  public String except(Exception ex, Model model){
    log.error("Exception ...."+ ex.getMessage());
    model.addAttribute("exception", ex);
    log.error(model.toString());
    return "error_page";
  }
}
