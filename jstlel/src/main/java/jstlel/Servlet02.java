package jstlel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/02")
public class Servlet02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        /**
         * 1. 객체의 scope (존속범위)
         *    객체의 존재 범위
         * 2. 객체가 오래 존속하는 순서
         *    Application(Context) Scope > Session Scope > Request Scope > Page Scope
         * 3. EL이 이름으로 객체를 찾는 순
         *    Application(Context) Scope < Session Scope < Request Scope < Page Scope
         *
         * 주의: 같은 이름으로 여러 존속 범위에 저장하는 경우 주의가 필요
         */
        UserVo vo1 = new UserVo();
        vo1.setId(1L);
        vo1.setName("둘리1");
        req.getServletContext().setAttribute("vo", vo1);

        UserVo vo2 = new UserVo();
        vo2.setId(2L);
        vo2.setName("둘리2");
        req.getSession().setAttribute("vo", vo2);

        UserVo vo3 = new UserVo();
        vo3.setId(1L);
        vo3.setName("둘리2");
        req.getSession().setAttribute("vo", vo3);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/02.jsp");
        dispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
}
