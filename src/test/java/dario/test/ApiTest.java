package dario.test;

import dario.main.Models.Partner;
import dario.main.Repository.IPartnerRepository;
import dario.main.Services.IPartnerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = Partner.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.properties")
public class ApiTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private IPartnerRepository partnerRepository;

        @Test
        public void findAll() throws Exception {
            // given
            Partner partner = new Partner();
            partner.setLocale(Locale.forLanguageTag("fr_BE"));
            partner.setCompanyName("Dario Despi");
            partner.setExpirationTime(Date.valueOf("2017-10-03T16:46:00.000+0000"));
            partner.setReference("xxxxxx");

            List<Partner> partners = Arrays.asList(partner);
            given(partnerRepository.findAll()).willReturn(partners);

            // when + then
            this.mvc.perform(get("/api/v1/stocks"))
                    .andExpect(status().isOk())
                    .andExpect(content().json("[{'id': 1,'companyName': 'Dario Despi';'reference': 'xxxxxx'; 'locale':'fr_BE'; ''expirationTime':'2017-10-03T16:46:00.000+0000'}]"));
        }
}
