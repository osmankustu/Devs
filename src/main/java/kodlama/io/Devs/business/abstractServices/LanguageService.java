package kodlama.io.Devs.business.abstractServices;

import kodlama.io.Devs.business.requests.LanguageRequest;
import kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import kodlama.io.Devs.business.response.GetAllLanguageResponse;

import java.util.List;

public interface LanguageService {
    List<GetAllLanguageResponse> getAll();
    LanguageRequest add(LanguageRequest request) throws Exception;
    void delete(int id);
    UpdateLanguageRequest update(int id ,UpdateLanguageRequest request) throws Exception;
    GetAllLanguageResponse getById(int id);

}
