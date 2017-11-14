package edu.hm.cs.cnj.cnjbackend.service;

import edu.hm.cs.cnj.cnjbackend.persistence.Teilnahme;
import edu.hm.cs.cnj.cnjbackend.persistence.TeilnahmeStatus;
import edu.hm.cs.cnj.cnjbackend.persistence.Veranstaltung;
import edu.hm.cs.cnj.cnjbackend.persistence.VeranstaltungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class VeranstaltungService {

    @Autowired
    private VeranstaltungRepository veranstaltungRepository;

    public Long erzeugeVeranstaltung(String titel, String beschreibung, Date beginn) {
        Veranstaltung veranstaltung = new Veranstaltung(titel, beschreibung, beginn);
        veranstaltungRepository.save(veranstaltung);
        return veranstaltung.getId();
    }

    public void fuegeTeilnahmeHinzu(long key, String name, int begleiter) {
        Veranstaltung veranstaltung = veranstaltungRepository.findOne(key);
        Teilnahme teilnahme = new Teilnahme(name, begleiter);
        veranstaltung.add(teilnahme);
    }

    public void sageOffeneTeilnahmenAbBis(Date time) {
        List<Veranstaltung> byBeginnBefore = veranstaltungRepository.findByBeginnBefore(time);
        byBeginnBefore.forEach(veranstaltung -> {
            veranstaltung.getEinladungen().forEach(einladung -> {
                if (einladung.getStatus().equals(TeilnahmeStatus.OFFEN)){
                    einladung.setStatus(TeilnahmeStatus.ABSAGE);
                }
            });
        });
    }
}