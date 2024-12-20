package jstlel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/01")
public class Servlet01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int iVal = 10;
        long lVal = 10;
        float fVal = 3.14f;
        boolean bVal = true;
        String sVal = "가나다라";

        req.setAttribute("iVal", iVal);
        req.setAttribute("lVal", lVal);
        req.setAttribute("fVal", fVal);
        req.setAttribute("bVal", bVal);
        req.setAttribute("sVal", sVal);

        Object obj = null;
        UserVo vo = new UserVo();

        vo.setId(1L);
        vo.setName("둘리");

        req.setAttribute("obj", obj);
        req.setAttribute("user", vo);

        Map<String, Object> map = new HashMap<>();
        map.put("iVal", iVal);
        map.put("sVal", sVal);
        map.put("bVal", bVal);

        req.setAttribute("m", map);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/01.jsp");
        dispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
}
