package dario.main.Controllers;

//import dario.main.Exceptions.ResponseExceptionHandler;

import dario.main.Models.Partner;
import dario.main.Services.IPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/api/partner")
public class PartnerController {
    @Autowired
    private IPartnerService partnerService;

    public PartnerController (final IPartnerService partnerService){
        this.partnerService = partnerService;
    }

    @GetMapping()
    public ResponseEntity<List<Partner>> getAllPartners(HttpServletResponse response){
        List<Partner> partnerList = partnerService.getPartners();
        return new ResponseEntity<>(partnerList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partner> getPartnerById(@PathVariable String id) {

            Long partnerId =Long.parseLong(id);
            Partner partner = partnerService.getPartner(partnerId);
            return new ResponseEntity<>(partner, HttpStatus.OK);
    }

    @RequestMapping(produces=MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<Partner> createPartner(@RequestBody Map<String, String> body){

        String name = body.get("name");
        String reference = body.get("reference");
        String locale = body.get("locale");
        String expirationTime = body.get("expirationTime");

        Partner partner = new Partner();
        partner.setReference(reference);
        partner.setExpirationTime(DatatypeConverter.parseDateTime(expirationTime).getTime());
        partner.setCompanyName(name);
        partner.setLocale(new Locale(locale));
        partnerService.addPartner(partner);
        return new ResponseEntity<>(partner, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<Partner> updatePartner(@PathVariable("id") final Long id,
                                                 @RequestBody Map<String, String> body){
        String name = body.get("name");
        String reference = body.get("reference");
        String locale = body.get("locale");
        String expirationTime = body.get("expirationTime");

        Partner partnerToUpdate = new Partner();
        partnerToUpdate.setReference(reference);
        partnerToUpdate.setExpirationTime(DatatypeConverter.parseDateTime(expirationTime).getTime());
        partnerToUpdate.setCompanyName(name);
        partnerToUpdate.setLocale(new Locale(locale));
        Partner updatedPartner = partnerService.updatePartner(id, partnerToUpdate);
        return new ResponseEntity<>(updatedPartner, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", produces=MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePartner(@PathVariable String id){
        Long partnerId =Long.parseLong(id);
        partnerService.deletePartner(partnerId);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
