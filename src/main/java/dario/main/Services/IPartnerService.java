package dario.main.Services;

import dario.main.Models.Partner;

import java.util.List;

public interface IPartnerService {

    List<Partner> getPartners();
    Partner getPartner(Long id);
    Partner addPartner(Partner partner);
    Partner updatePartner(Long id, Partner partnerToUpdate);
    void deletePartner(Long id);
}
