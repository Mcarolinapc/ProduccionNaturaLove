package com.NaturaLove.ProductNaturaLove.Go.RestController;

import com.NaturaLove.ProductNaturaLove.Go.Services.TallerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TallerRestController {

    @Autowired
    TallerService tallerService;

    @RequestMapping("/crearTalleresFake")
    public String creartalleres(){

        tallerService.createFakeTaller();

        return "hemos creado talleres";
    }

    @RequestMapping("/populatet")
    public String populatetalleres(){

        //tallerService.populateTalleres();

        return "hemos populado talleres";
    }




}
