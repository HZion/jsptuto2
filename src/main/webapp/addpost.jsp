<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.example.dao.BoardDAO"%>
<%@ page import ="com.example.*, java.io.File" %>
<%@ page import ="com.oreilly.servlet.*" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"		%>
<%@ page import="com.example.file.Fileupload" %>
<%@ page import="com.example.bean.BoardVO" %>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="u" class="com.example.bean.BoardVO" />

<jsp:setProperty property="*" name="u"/>

<%




	BoardDAO boardDAO = new BoardDAO();
	Fileupload upload = new Fileupload();
	BoardVO a = upload.uploadPhoto(request);

	int i = boardDAO.insertBoard(u);

	/* 파일 전송 가능한지 연습 -> 됨
	String filename = "";
	int sizeLimit = 15 * 1024 * 1024;

	String realPath = request.getServletContext().getRealPath("upload");
	File dir = new File(realPath);
	if (!dir.exists()) dir.mkdirs();

	MultipartRequest multpartRequest = null;
	multpartRequest = new MultipartRequest(request, realPath,
			sizeLimit, "utf-8",new DefaultFileRenamePolicy());
	filename = multpartRequest.getFilesystemName("photo");

	BoardDAO boardDAO = new BoardDAO();
	int i = boardDAO.insertBoard(u);

	boardDAO.uploadFile(u,filename);

	String msg = "데이터 추가 성공 !";
	if(i == 0) msg = "[에러] 데이터 추가 ";
*/
/*
	request.setCharacterEncoding("utf-8");
	BoardDAO boardDAO = new BoardDAO();
	Fileupload upload = new Fileupload();
	BoardVO u = upload.uploadPhoto(request);
	int i = boardDAO.insertBoard(u);

 */
%>
<script>

	location.href='posts.jsp';
</script>