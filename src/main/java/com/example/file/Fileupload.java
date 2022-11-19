package com.example.file;

import com.example.bean.BoardVO;
import com.example.dao.BoardDAO;
import com.oreilly.servlet.*;
import java.io.File;
import java.io.IOException;

import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import javax.servlet.http.HttpServletRequest;
import javax.swing.border.Border;

public class Fileupload {
    public BoardVO uploadPhoto(HttpServletRequest request){

        String filename = "";
        int sizeLimit = 15 * 1024 * 1024;

        String realPath = request.getServletContext().getRealPath("upload");
        File dir = new File(realPath);
        if (!dir.exists()) dir.mkdirs();

        BoardVO one = null;

        MultipartRequest multpartRequest = null;

        try{
            multpartRequest = new MultipartRequest(request, realPath,sizeLimit, "utf-8",new DefaultFileRenamePolicy());
            filename = multpartRequest.getFilesystemName("photo");
            one = new BoardVO();
             String seq = multpartRequest.getParameter("seq");
             if(seq != null && seq.equals("")) one.setSeq(Integer.parseInt(seq));

                one.setName(multpartRequest.getParameter("U_name"));
                one.setUserid(multpartRequest.getParameter("U_id"));
                one.setPassword(multpartRequest.getParameter("password"));
                one.setAge(Integer.parseInt(multpartRequest.getParameter("age")));
                one.setJob(multpartRequest.getParameter("job"));
                one.setHabit(multpartRequest.getParameter("habit"));
                one.setPhoto(multpartRequest.getParameter("photo"));
                one.setEmail(multpartRequest.getParameter("email"));
                one.setCnt(Integer.parseInt(multpartRequest.getParameter("cnt")));
            if(seq != null && seq.equals("")){
                BoardDAO dao = new BoardDAO();
                String oldfilename = dao.getPhotoFilename(Integer.parseInt(seq));
                if(filename != null && oldfilename != null){
                    Fileupload.deleteFile(request, oldfilename);
                }
                else if(filename == null && oldfilename != null)
                    filename = oldfilename;
            }
        }catch(IOException e){
            e.printStackTrace();;
        }
        return one;
    }
    public static void deleteFile(HttpServletRequest request, String filename){
        String filePath = request.getServletContext().getRealPath("upload");

        File f = new File(filePath + "/" + filename);
        if( f.exists() ) f.delete();
    }
}
