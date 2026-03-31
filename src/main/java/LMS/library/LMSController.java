package LMS.library;

import LMS.library.Table.LMSSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1")
public class LMSController {
    @Autowired
    private LMSService lmsService;
    @PostMapping("/post")
    public ResponseEntity<LMSSchema> createRow(@RequestBody  LMSSchema data){
        return new ResponseEntity<>(lmsService.createData(data), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<LMSSchema> getById(@PathVariable Long id){
        try{
            LMSSchema find = lmsService.getById(id);
            return new ResponseEntity<>(find,HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public List<LMSSchema> getAllBooks(){
        return lmsService.listAllBooks();
    }
    @PutMapping
    public ResponseEntity<LMSSchema> UpdateRow(@RequestBody LMSSchema data){
        return new ResponseEntity<>(lmsService.upadateData(data),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void deleteData(@PathVariable Long id){
        lmsService.deletById(id);
    }
    @DeleteMapping
    public void deleteAll(){
        lmsService.deleteAllBooks();
    }
}
