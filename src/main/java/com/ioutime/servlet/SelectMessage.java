package com.ioutime.servlet;

import com.ioutime.dao.user.Select;
import com.ioutime.entity.UserMsg;
import com.ioutime.util.RespBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author ioutime
 * @version 1.0
 * @date 2021/8/16 17:04
 */

public class SelectMessage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String key = req.getParameter("key");
        String notes = req.getParameter("notes");
        /*数据库处理*/
        Select select = new Select();
        List<UserMsg> list = null;
        try {
            list = select.queryMsg(notes, key);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(list.isEmpty()){
            RespBody.response(resp,"400","没查到","");
        }else {
            RespBody.response(resp,"200","查询成功",list);
        }

    }
}
