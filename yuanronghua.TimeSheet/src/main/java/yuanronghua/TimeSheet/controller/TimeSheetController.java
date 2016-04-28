package yuanronghua.TimeSheet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import yuanronghua.TimeSheet.common.PageList;
import yuanronghua.TimeSheet.common.Query;
import yuanronghua.TimeSheet.common.RestResponse;
import yuanronghua.TimeSheet.service.TimeSheetService;
import yuanronghua.TimeSheet.vo.Account;
import yuanronghua.TimeSheet.vo.TimeSheet;

/**
 * @Title: TimeSheetController.java
 * @Package yuanronghua.TimeSheet.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author wb-yuanronghua
 * @date 2016年1月12日 下午2:16:10
 **/
@RestController
public class TimeSheetController {

    @Autowired
    private TimeSheetService timeSheetService;

    @RequestMapping("/index.vhtml")
    ModelAndView home(ModelMap modelMap) {
        return new ModelAndView("index");
    }

    @RequestMapping("/login.vhtml")
    ModelAndView loginhtml(ModelMap modelMap) {
        return new ModelAndView("login");
    }

    @RequestMapping("/time.vhtml")
    ModelAndView time(ModelMap modelMap) {
        return new ModelAndView("time");
    }

    @RequestMapping("/query.json")
    RestResponse query(@RequestParam int start, @RequestParam int pageSize) {
        RestResponse rs = new RestResponse();
        rs.setRestCode(RestResponse.REST_REST_SUCCESS_CODE);
        try {
            Query query = new Query();
            query.setPageSize(pageSize);
            query.setStart(start);
            PageList PageList = timeSheetService.query(query);
            rs.setResult(PageList);
        } catch (Exception e) {
            rs.setRestCode(RestResponse.REST_REST_FAILED_CODE);
        }
        return rs;

    }

    @RequestMapping("/queryByDate.json")
    RestResponse queryByDate(@RequestParam String begin_time, @RequestParam String end_time) {
        RestResponse rs = new RestResponse();
        rs.setRestCode(RestResponse.REST_REST_SUCCESS_CODE);
        try {
            Query query = new Query();
            query.setBegin_time(begin_time);
            query.setEnd_time(end_time);
            PageList PageList = timeSheetService.queryByDate(query);
            rs.setResult(PageList);
        } catch (Exception e) {
            rs.setRestCode(RestResponse.REST_REST_FAILED_CODE);
        }
        return rs;

    }

    @RequestMapping(value = "/add.do", method = RequestMethod.POST)
    RestResponse add(@RequestBody TimeSheet timeSheet) {
        RestResponse rs = new RestResponse();
        rs.setRestCode(RestResponse.REST_REST_SUCCESS_CODE);
        try {
            timeSheetService.add(timeSheet);
        } catch (Exception e) {
            rs.setRestCode(RestResponse.REST_REST_FAILED_CODE);
        }
        return rs;

    }

    @RequestMapping(value = "/remove.do", method = RequestMethod.POST)
    RestResponse remove(@RequestBody TimeSheet timeSheet) {
        RestResponse rs = new RestResponse();
        rs.setRestCode(RestResponse.REST_REST_SUCCESS_CODE);
        try {
            timeSheetService.remove(timeSheet);
        } catch (Exception e) {
            rs.setRestCode(RestResponse.REST_REST_FAILED_CODE);
        }
        return rs;
    }

    @RequestMapping(value = "/update.do", method = RequestMethod.POST)
    RestResponse update(@RequestBody TimeSheet timeSheet) {
        RestResponse rs = new RestResponse();
        rs.setRestCode(RestResponse.REST_REST_SUCCESS_CODE);
        try {
            timeSheetService.update(timeSheet);
        } catch (Exception e) {
            rs.setRestCode(RestResponse.REST_REST_FAILED_CODE);
        }
        return rs;
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    RestResponse login(@RequestBody Account account, HttpServletRequest request) {
        RestResponse rs = new RestResponse();
        rs.setRestCode(RestResponse.REST_REST_SUCCESS_CODE);
        try {
            Account login = timeSheetService.login(account);
            if (login != null) {
                request.getSession().setAttribute("name", login.getName());
                request.getSession().setMaxInactiveInterval(30 * 60);
                rs.setResult(login);
            }
        } catch (Exception e) {
            rs.setRestCode(RestResponse.REST_REST_FAILED_CODE);
        }
        return rs;
    }

    @RequestMapping(value = "/logout.do", method = RequestMethod.GET)
    RestResponse login(HttpServletRequest request, HttpServletResponse response) {
        RestResponse rs = new RestResponse();
        rs.setRestCode(RestResponse.REST_REST_SUCCESS_CODE);
        try {
            request.getSession().invalidate();
            response.sendRedirect("/index.vhtml");
        } catch (Exception e) {
            rs.setRestCode(RestResponse.REST_REST_FAILED_CODE);
        }
        return rs;
    }
}
