package kodlama.io.Devs.WebAPI;

import kodlama.io.Devs.business.abstractServices.LanguageService;
import kodlama.io.Devs.business.requests.LanguageRequest;
import kodlama.io.Devs.business.requests.UpdateFrameworkRequest;
import kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import kodlama.io.Devs.business.response.GetAllLanguageResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/language")
public class LanguageController {

    private LanguageService _languageService;

    LanguageController(LanguageService languageService){

        this._languageService = languageService;
    }
    @GetMapping("getall")
    public List<GetAllLanguageResponse> getAll(){

        return   _languageService.getAll();
    }

    @PostMapping("add")
    public LanguageRequest add(LanguageRequest request) throws Exception {
        return _languageService.add(request);
    }
    @PutMapping("update")
    public UpdateLanguageRequest update(int id , UpdateLanguageRequest request) throws Exception {
        return _languageService.update(id,request);
    }
    @DeleteMapping("delete")
    public void delete(int id ){
        _languageService.delete(id);
    }
    @GetMapping("getbyid")
    public GetAllLanguageResponse getById(int id){
       return _languageService.getById(id);
    }

}
