package com.example.springbootdemo.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class FileUploadController {

    /**
     *
     * @param nickname
     * @param photo
     * @param request could get the real path of web server,
     *                which is changing dynamically, like cloud server
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public String up(String nickname, MultipartFile photo, HttpServletRequest request) throws IOException {
        System.out.println(nickname);
        // get the file name
        System.out.println(photo.getOriginalFilename());
        // get the file type
        System.out.println(photo.getContentType());

        String path = request.getServletContext().getRealPath("/upload/");
        System.out.println(path);

        saveFile(photo, path);

        return "Upload Success";
    }

    private void saveFile(MultipartFile photo, String path) throws IOException{
        // pass the real path
        File dir = new File(path);
        // if dir doesn't exist, create a new one
        if(!dir.exists()) {
            dir.mkdir();
        }

        File file = new File(path + photo.getOriginalFilename());
        // save the origin photo to the file path
        photo.transferTo(file);
    }
}
