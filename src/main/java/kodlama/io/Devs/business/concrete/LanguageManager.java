package kodlama.io.Devs.business.concrete;

import kodlama.io.Devs.business.abstractServices.FrameworkService;
import kodlama.io.Devs.business.abstractServices.LanguageService;
import kodlama.io.Devs.business.requests.LanguageRequest;

import kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import kodlama.io.Devs.business.response.GetAllFrameworkResponse;
import kodlama.io.Devs.business.response.GetAllLanguageResponse;

import kodlama.io.Devs.dataAccess.concrete.LanguageRepository;

import kodlama.io.Devs.entites.Language;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageManager  implements LanguageService {

    private final LanguageRepository _languageRepository;
    private FrameworkService _frameworkService;
    private final ModelMapper _mapper;

    @Autowired
     LanguageManager(LanguageRepository _languageRepository, ModelMapper mapper , FrameworkService frameworkService) {
        this._languageRepository = _languageRepository;
        this._frameworkService = frameworkService;
        this._mapper = mapper;
    }

    @Override
    public List<GetAllLanguageResponse> getAll() {
        List<Language> response = _languageRepository.findAll();
       // List<GetAllFrameworkResponse>  frameworks = _frameworkService.getAll();
        List<GetAllLanguageResponse> language = response.stream()
                .map(responses -> _mapper.map(responses,GetAllLanguageResponse.class)).collect(Collectors.toList());

        return language;

    }

    @Override
    public LanguageRequest add(LanguageRequest request) throws Exception {
        isNameEmpty(request.getName());
        isNameExist(request.getName());
        Language language = _mapper.map(request,Language.class);
        return _mapper.map(_languageRepository.save(language), LanguageRequest.class);
    }

    @Override
    public void delete(int id) {
        _languageRepository.deleteById(id);
    }

    @Override
    public UpdateLanguageRequest update(int id, UpdateLanguageRequest request) throws Exception {
        isNameExist(request.getName());
        isNameEmpty(request.getName());
        Language language = _languageRepository.getById(id);
        language.setName(request.getName());
        return _mapper.map(_languageRepository.save(language),UpdateLanguageRequest.class);
    }

    @Override
    public GetAllLanguageResponse getById(int id) {
        Language language =  _languageRepository.getById(id);
        GetAllLanguageResponse response = _mapper.map(language,GetAllLanguageResponse.class);
        return response;
    }

    private void isNameEmpty(String name) throws Exception {
        if (name.isEmpty() || name.isBlank()){
            throw new Exception("İsim Alanı Boş Geçilemez");
        }
    }

    private void isNameExist(String name) throws Exception {
        List<Language> languages = _languageRepository.findAll();
        for (Language language : languages) {
            if(language.getName().equals(name)){
                throw new Exception("Bu isimden zaten mevcut");
            }
        }
    }
}
