package LMS.library;

import LMS.library.Table.LMSSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LMSService {
    @Autowired
    private LMSRepo lmsRepo;
    public LMSSchema createData(LMSSchema data){
        return lmsRepo.save(data);
    }
    public LMSSchema getById(Long id){
            return lmsRepo.findById(id).orElseThrow(()-> new RuntimeException("No Book Fond by tid id numdber"+id));
    }
    public List<LMSSchema> listAllBooks(){
        return lmsRepo.findAll();
    }
    public LMSSchema upadateData(LMSSchema data){

        return lmsRepo.save(data);
    }
    public void deletById(Long id){
        lmsRepo.deleteById(id);
    }
    public  void deleteAllBooks(){
        lmsRepo.deleteAll();
    }
}
