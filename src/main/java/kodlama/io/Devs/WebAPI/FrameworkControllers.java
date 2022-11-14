package kodlama.io.Devs.WebAPI;

import kodlama.io.Devs.business.abstractServices.FrameworkService;
import kodlama.io.Devs.business.requests.FrameworkRequest;
import kodlama.io.Devs.business.requests.UpdateFrameworkRequest;
import kodlama.io.Devs.business.response.GetAllFrameworkResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/framework")
public class FrameworkControllers {

    private FrameworkService _frameworkService;

    @Autowired
    FrameworkControllers(FrameworkService frameworkService){
        this._frameworkService =frameworkService ;
    }
    @GetMapping("getall")
    public List<GetAllFrameworkResponse> getAll(){
        return  _frameworkService.getAll();
    }
    @PostMapping("add")
    public FrameworkRequest add(FrameworkRequest request) throws Exception {
       return _frameworkService.add(request);
    }
     @GetMapping("getbyid")
    public GetAllFrameworkResponse getById(int id) throws Exception {

       return _frameworkService.getById(id);
     }
     @PutMapping("update")
    public FrameworkRequest update(int id , UpdateFrameworkRequest request) throws Exception {
        return _frameworkService.update(id,request);
     }
     @DeleteMapping("delete")
    public void delete(int id) throws Exception {
        _frameworkService.delete(id);
     }

}
