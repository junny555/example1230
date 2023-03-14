package example1230.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import example1230.dbconn.Dbconn;
import example1230.domain.BoardVo;
import example1230.service.BoardDao;
import oracle.sql.BlobDBAccess;


@WebServlet("/BoardController")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	String str;
	public BoardController(String path) {
		this.str=path;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(str.equals("/board/boardList.do")) {
			System.out.println("boardList.do 들어옴");
			
			
			BoardDao bd=new BoardDao();
			ArrayList<BoardVo> blist = bd.boardSelectAll();
			
			request.setAttribute("blist", blist);
			
			RequestDispatcher rd =request.getRequestDispatcher("/board/boardList.jsp");
			rd.forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
