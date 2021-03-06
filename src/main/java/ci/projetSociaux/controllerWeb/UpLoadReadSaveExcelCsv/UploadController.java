package ci.projetSociaux.controllerWeb.UpLoadReadSaveExcelCsv;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping(value = "admin")
public class UploadController {

    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "C://temp//";

   @RequestMapping(value="/upload", method = RequestMethod.POST)
   //@PostMapping("/admin/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            //return "redirect:/admin/uploadStatus.html";
            return "admin/savePrgRecipiendaire.html";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

       // return "redirect:/admin/uploadStatus.html";
        return "admin/savePrgRecipiendaire.html";
    }

    @RequestMapping(value="/uploadStatus", method = RequestMethod.POST)
    //@GetMapping("/admin/uploadStatus")
    public String uploadStatus() {
    	// return "redirect:/admin/uploadStatus.html";
    	return "admin/savePrgRecipiendaire.html";
    }
    
    @RequestMapping(value="/upload", method = RequestMethod.GET)
   	public String pageHome( ModelMap modelMap) {

   		try {
   			  User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   		      modelMap.put("user", user); 
   			  return "admin/uploadimage.html";
   	    }catch (ClassCastException e) {
   	    	return "admin/uploadimage.html";
   	    }
    }

}