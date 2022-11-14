package kodlama.io.Devs.business.abstractServices;

import kodlama.io.Devs.business.requests.FrameworkRequest;
import kodlama.io.Devs.business.requests.UpdateFrameworkRequest;
import kodlama.io.Devs.business.response.GetAllFrameworkResponse;

import java.util.List;

public interface FrameworkService {
    List<GetAllFrameworkResponse> getAll();
    FrameworkRequest add(FrameworkRequest request) throws Exception;
    FrameworkRequest update(int id , UpdateFrameworkRequest request) throws Exception;
    void delete(int id) throws Exception;
    GetAllFrameworkResponse getById(int id) throws Exception;

}
