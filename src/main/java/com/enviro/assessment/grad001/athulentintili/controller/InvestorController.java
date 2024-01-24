package com.enviro.assessment.grad001.athulentintili.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.enviro.assessment.grad001.athulentintili.model.Investor;
import com.enviro.assessment.grad001.athulentintili.repo.InvestorRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class InvestorController {
    @Autowired
    private InvestorRepo investorRepo;

    @GetMapping
    public String showRegistrationForm(Model model){
        model.addAttribute("investor", new Investor());
        return "index";
    }
    
    @PostMapping
    public String registerInvestor(@ModelAttribute("investor") Investor investor) {
        investorRepo.save(investor);
        return "redirect:/registration?success";
    }
    

    @GetMapping("/getAllInvestors")
    public ResponseEntity<List<Investor>> getAllInvestors(){
        try{
            List<Investor> investorList= new ArrayList<>();
            investorRepo.findAll().forEach(investorList::add);
            if(investorList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(investorList,HttpStatus.OK);

        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @GetMapping("/getInvestorById/{id}")
    public ResponseEntity<Investor> getInvestorById(@PathVariable Long id){
        Optional<Investor> investorData = investorRepo.findById(id);
        if(investorData.isPresent()){
            return new ResponseEntity<>(investorData.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }

    @PostMapping("/addInvestor")
    public ResponseEntity<Investor> addInvestor(@RequestBody Investor investor) {
        Investor savedInvestor = investorRepo.save(investor);
        return new ResponseEntity<>(savedInvestor,HttpStatus.OK);
    }

    @PostMapping("/updateInvestorById/{id}")
    public ResponseEntity<Investor> UpdateInvestorById(@PathVariable Long id,@RequestBody Investor updatedInvestor) {
        Optional<Investor> oldInvestorData = investorRepo.findById(id);
        if(oldInvestorData.isPresent()){
        
            Investor newInvestor = oldInvestorData.get();
            newInvestor.setName(updatedInvestor.getName());
            newInvestor.setAddress(updatedInvestor.getAddress());
            newInvestor.setAge(updatedInvestor.getAge());
            Investor investor = investorRepo.save(newInvestor);
            return new ResponseEntity<>(investor,HttpStatus.OK);

        }
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteBookById/{id}")
    public ResponseEntity<HttpStatus> deleteInvestorById(@PathVariable Long id){
        investorRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
    
    

    
}
