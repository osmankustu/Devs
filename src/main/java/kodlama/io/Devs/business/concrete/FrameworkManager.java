package kodlama.io.Devs.business.concrete;


import kodlama.io.Devs.business.abstractServices.FrameworkService;
import kodlama.io.Devs.business.requests.FrameworkRequest;
import kodlama.io.Devs.business.requests.UpdateFrameworkRequest;
import kodlama.io.Devs.business.response.GetAllFrameworkResponse;
import kodlama.io.Devs.dataAccess.concrete.FrameworkRepository;
import kodlama.io.Devs.entites.Framework;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FrameworkManager implements FrameworkService {

    private FrameworkRepository _frameworkRepository;
    private final ModelMapper _mapper;



    public FrameworkManager(FrameworkRepository frameworkRepository,ModelMapper mapper){
        this._frameworkRepository = frameworkRepository;
        this._mapper = mapper;
    }

    @Override
    public List<GetAllFrameworkResponse> getAll() {
        List<Framework> frameworks = _frameworkRepository.findAll();
        List<GetAllFrameworkResponse> response = frameworks.stream().map(framework -> _mapper.map(framework,GetAllFrameworkResponse.class)).collect(Collectors.toList());

        return response;
    }

    @Override
    public FrameworkRequest add(FrameworkRequest request) throws Exception {
        isNameEmpty(request.getName());
        isNameExist(request.getName());
        Framework framework = _mapper.map(request,Framework.class);

        return _mapper.map(_frameworkRepository.save(framework),FrameworkRequest.class);

    }

    @Override
    public FrameworkRequest update(int id, UpdateFrameworkRequest request) throws Exception {
        isNameExist(request.getName());
        isNameEmpty(request.getName());
        isIdEmpty(id);
        Framework framework = _frameworkRepository.getById(id);
        Framework mapper = _mapper.map(framework,Framework.class);
        mapper.setName(request.getName());
        mapper.setLanguageId(request.getLanguageId());

        return _mapper.map(_frameworkRepository.save(framework),FrameworkRequest.class);

    }

    @Override
    public void delete(int id) throws Exception {
        isIdEmpty(id);
        _frameworkRepository.deleteById(id);

    }

    @Override
    public GetAllFrameworkResponse getById(int id) throws Exception {
        Framework framework = _frameworkRepository.getById(id);
         isIdEmpty(id);
        GetAllFrameworkResponse response = _mapper.map(framework,GetAllFrameworkResponse.class);

        return response;
    }
    //Business'a Özel Kurallar
    private void isIdEmpty(int id) throws Exception {
      Framework framework = _frameworkRepository.getById(id);
        if(id != framework.getId()){
              throw new Exception("Girilen Id Veritabanında Mevcut Değil");

          }
    }
    private void isNameEmpty(String name) throws Exception {
        if (name.isBlank() || name.isEmpty()){

            throw new Exception("İsim Alanı Boş Bırakılamaz ");
        }
    }
    private void isNameExist(String name) throws Exception {
        List<Framework> frameworks = _frameworkRepository.findAll();
        for (Framework framework : frameworks) {
            if (framework.getName().equals(name)){
                throw new Exception("Bu Frameworkden zaten mevcut");
            }

        }
    }
}

