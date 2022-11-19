<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.example.bean.BoardVO, com.example.dao.BoardDAO" %>
<%@ page import="com.example.file.Fileupload" %>

<%
	String sid = request.getParameter("id");
	if (sid != ""){

		int id = Integer.parseInt(sid);
		BoardVO u = new BoardVO();

		u.setSeq(id);
		BoardDAO boardDAO = new BoardDAO();
		/*String filename = boardDAO.getPhotoFilename(u.getSeq());
		if(filename!= null)
			Fileupload.deleteFile(request, filename);
		*/
		boardDAO.deleteBoard(u);
	}
	response.sendRedirect("posts.jsp");
%>