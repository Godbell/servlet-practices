package guestbook.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import guestbook.dao.GuestBookDao;
import guestbook.vo.GuestBookVo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/gb")
public class GuestBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        String action = request.getParameter("a");
        GuestBookDao dao = new GuestBookDao();

        if ("add".equals(action)) {
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String contents = request.getParameter("contents");

            GuestBookVo vo = new GuestBookVo();
            vo.setName(name);
            vo.setPassword(password);
            vo.setContents(contents);

            dao.insert(vo);
            try {
                response.sendRedirect("/guestbook02/gb");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if ("deleteform".equals(action)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
            try {
                requestDispatcher.forward(request, response);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if ("delete".equals(action)) {
            Long id = Long.parseLong(request.getParameter("id"));
            String password = request.getParameter("password");
            dao.deleteByIdAndPassword(id, password);

            try {
                response.sendRedirect("/guestbook02/gb");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            List<GuestBookVo> list = dao.findAll();
            request.setAttribute("list", list);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
            try {
                requestDispatcher.forward(request, response);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        doGet(request, response);
    }
}
