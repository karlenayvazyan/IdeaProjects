package am.ak.mybatis.util;

import am.ak.mybatis.data.model.File;
import am.ak.mybatis.data.model.FileData;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UploadServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {
            List<File> files = null;
            FileUtility fileUtility = null;
            try {
                ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
                List<FileItem> items = upload.parseRequest(request);

                byte[] fileSRC = null;
                FileData data = new FileData();
                files = new ArrayList<File>();
                fileUtility = BeanProvider.getInstance().getBean(FileUtility.class, "fileUtility");
                for (FileItem item : items) {
                    if (item.isFormField()) {
                        if (item.getFieldName().equals("language_am")) {
                            data.setLanguageAm(item.getString());
                        } else if (item.getFieldName().equals("language_en")) {
                            data.setLanguageEn(item.getString());
                        } else if (item.getFieldName().equals("language_ru")) {
                            data.setLanguageRu(item.getString());
                        } else if (item.getFieldName().equals("categoryId")) {
                            long categoryId;
                            try {
                                categoryId = Long.parseLong(item.getString());
                            } catch (Exception e) {
                                categoryId = -1;
                            }
                            data.setCategoryId(categoryId);
                        }
                    } else {
                        File file = new File();
                        file.setSize(item.getSize());
                        file.setName(item.getName());
                        file.setContentType(item.getContentType());
                        fileSRC = item.get();
                        if (!Validator.isEmpty(fileSRC)) {
                            file.setCreationDate(new Date());
                            fileUtility.storeToTemp(file, fileSRC);
                        }
                        files.add(file);
                    }
                }
                data.setFiles(files);

                if (validate(data, request)) {
//                    User user = getUser(request);
//                    data.setUser(user);
//                    IFileManager manager = null;
//                    try {
//                        manager = new FileManagerImpl();
//                        manager.add(data, fileSRC);
//                        request.getSession().setAttribute(ScopeKeys.MESSAGE, "data stored successfully");
//                        response.sendRedirect("upload");
//                    } catch (InternalErrorException e) {
//                        request.setAttribute(ScopeKeys.MESSAGE, "Failed to store file");
//                        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//                    } finally {
//                        if (manager != null) {
//                            manager.close();
//                        }
//                    }
                } else {
                    request.getRequestDispatcher("/upload").forward(request, response);
                }
            } catch (FileUploadException e) {
                request.setAttribute(ScopeKeys.MESSAGE, "Filed to parse request");
                response.sendError(HttpServletResponse.SC_REQUESTED_RANGE_NOT_SATISFIABLE);
            } finally {
                for (File file : files) {
                    fileUtility.removeFromTemp(file);
                }
            }
        } else {
            request.setAttribute(ScopeKeys.MESSAGE, "Passed args vas not multipart");
            request.getRequestDispatcher("/upload").forward(request, response);
        }
    }

    private boolean validate(FileData data, HttpServletRequest request) {
        boolean isValid = true;
        if (Validator.isEmpty(data.getLanguageAm())) {
            isValid = false;
            request.setAttribute(ScopeKeys.MSG_ERR_LANGUAGE_AM, "Language am is required");
        }

        if (Validator.isEmpty(data.getLanguageAm())) {
            isValid = false;
            request.setAttribute(ScopeKeys.MSG_ERR_LANGUAGE_EN, "Language en is required");
        }

        if (Validator.isEmpty(data.getLanguageRu())) {
            isValid = false;
            request.setAttribute(ScopeKeys.MSG_ERR_LANGUAGE_RU, "Language ru is required");
        }
        return isValid;
    }
}