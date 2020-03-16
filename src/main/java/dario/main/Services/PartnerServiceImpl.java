package dario.main.Services;

//import dario.main.Exceptions.PartnerNotFoundException;
import dario.main.Models.Partner;
import dario.main.Repository.IPartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PartnerServiceImpl implements IPartnerService {

    @Autowired
    private IPartnerRepository partnerRepository;

    public PartnerServiceImpl (final IPartnerRepository partnerRepository){
        this.partnerRepository = partnerRepository;
    }

    @Override
    public List<Partner> getPartners() { return partnerRepository.findAll(); }

    @Override
    public Partner getPartner(final Long id) {
//        Partner partner = partnerRepository.findById(id).orElseThrow(
//                () -> new PartnerNotFoundException(id)
//        );
        Partner partner = partnerRepository.findById(id).get();
        return partner;
    }

    @Override
    public Partner addPartner(final Partner partner) {

        return partnerRepository.save(partner);
    }

    @Override
    public Partner updatePartner(Long id, Partner partnerToUpdate) {
        Partner partnerFromDb = getPartner(id);
        partnerFromDb.setCompanyName(partnerToUpdate.getCompanyName());
        partnerFromDb.setExpirationTime(partnerToUpdate.getExpirationTime());
        partnerFromDb.setLocale(partnerToUpdate.getLocale());
        partnerFromDb.setReference(partnerToUpdate.getReference());
        return partnerRepository.save(partnerFromDb);
    }

    @Override
    public void deletePartner(Long id) { partnerRepository.deleteById(id); }
}
