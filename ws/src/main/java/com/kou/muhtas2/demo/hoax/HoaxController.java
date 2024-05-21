package com.kou.muhtas2.demo.hoax;

import com.kou.muhtas2.demo.hoax.dto.HoaxDTO;
import com.kou.muhtas2.demo.hoax.dto.HoaxSubmitDTO;
import com.kou.muhtas2.demo.shared.GenericMessage;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hoaxes")
public class HoaxController {

    @Autowired
    HoaxService hoaxService;


    @PostMapping("")
    GenericMessage saveHoax(@Valid @RequestBody HoaxSubmitDTO hoaxSubmitDTO){
        hoaxService.save(hoaxSubmitDTO);
       return new GenericMessage("Hoax saved");
    }

    @GetMapping("")
    Page<HoaxDTO> getHoaxes(@PageableDefault(sort = "id",direction = Sort.Direction.DESC) Pageable pageable){
        return hoaxService.getHoaxes(pageable).map(HoaxDTO::new);
    }
    @GetMapping("/users/{username}/hoaxes")
    Page<HoaxDTO> getUserHoaxes(@PathVariable String username,@PageableDefault(sort = "id",direction = Sort.Direction.DESC) Pageable pageable){
        return hoaxService.getHoaxesOfUser(username,pageable).map(HoaxDTO::new);
    }
    @DeleteMapping("/{id}")
    GenericMessage   deleteHoax(@PathVariable int id){
        hoaxService.deleteHoax(id);
        return new GenericMessage("Hoax Removed");
    }



}
