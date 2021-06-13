package com.sw.projekat.controller;

import com.sw.projekat.dto.AutomobilDTO;
import com.sw.projekat.dto.FotografijaDTO;
import com.sw.projekat.mapper.AutomobilDTOMapper;
import com.sw.projekat.mapper.FotografijaDTOMapper;
import com.sw.projekat.model.Automobil;
import com.sw.projekat.model.Fotografija;
import com.sw.projekat.service.FotografijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FotografijaController {

    @Autowired
    private FotografijaService fotografijaService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/fotografije/create/car-naziv/{naziv}")
    public ResponseEntity createFotografija(@RequestParam("File") MultipartFile fajl, @PathVariable String naziv) throws IOException {
        Fotografija fotografija=new Fotografija();

        String s=System.getProperty("file.separator");
        File f=new File(".");
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getCanonicalPath().split("Caradvisor")[0]);
        System.out.println(f.getPath());
        byte[] bytes = fajl.getBytes();
        try (FileOutputStream fos = new FileOutputStream((f.getCanonicalPath().split("Caradvisor")[0]+"Caradvisor/app/frontend/client/src/assets/img/"+fajl.getOriginalFilename()+naziv)))
        {
            fos.write(bytes);
        }
        File fajlic = new File(f.getCanonicalPath().split("Caradvisor")[0]+"Caradvisor/app/frontend/client/src/assets/img/"+fajl.getOriginalFilename());
        fotografija.setFoto(fajlic);
        fotografija.setId(1);
        fotografija.setCarNaziv(naziv);
        fotografija.setLokacijaFajl(f.getCanonicalPath().split("Caradvisor")[0]+"Caradvisor/app/frontend/client/src/assets/img/"+fajl.getOriginalFilename()+naziv);
        try {
            if( ImageIO.read(new File(fotografija.getLokacijaFajl())) == null)
                throw new IOException("Ovo nije slika");
            fotografija = fotografijaService.create(fotografija);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/fotografije/getByNaziv/{naziv}", method = RequestMethod.GET)
    public ResponseEntity<FotografijaDTO> getCar(@PathVariable String naziv ) {
        System.out.println("ssss");
        Fotografija f = fotografijaService.getByCarNaziv(naziv);
        System.out.println(f.getCarNaziv());
        FotografijaDTO dto =FotografijaDTOMapper.toDTO(f);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    private List<FotografijaDTO> toFotografijaDTOList(List<Fotografija> fotografijas){
        List<FotografijaDTO> fotografijaDTOS = new ArrayList<>();
        for (Fotografija fotografija : fotografijas){
            fotografijaDTOS.add(FotografijaDTOMapper.toDTO(fotografija));
        }
        return fotografijaDTOS;
    }

}
