package jstlel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/03")
public class Servlet03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        UserVo vo1 = new UserVo();
        vo1.setId(1L);
        vo1.setName("둘리");

        UserVo vo2 = new UserVo();
        vo2.setId(2L);
        vo2.setName("또치");

        UserVo vo3 = new UserVo();
        vo3.setId(3L);
        vo3.setName("도우너");

        List<UserVo> list = new ArrayList<>();
        list.add(vo1);
        list.add(vo2);
        list.add(vo3);
        req.setAttribute("list", list);

        String contents = "가\n나\n다\n라\n마";
        req.setAttribute("contents", contents);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/03.jsp");
        dispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
}
