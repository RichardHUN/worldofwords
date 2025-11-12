package hu.unideb.inf.worldofwords.service;

import hu.unideb.inf.worldofwords.repository.BoyNamesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BoyNamesServiceImpl implements BoyNamesService {

    private final BoyNamesRepository repository;

    @Override
    public boolean isValidBoyName(String boyName) {
        return repository.findAll().getFirst().getBoyNames().contains(boyName);
    }

    @Override
    public List<String> allBoyNames() {
        return repository.findAll().getFirst().getBoyNames();
    }

}
